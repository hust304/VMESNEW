package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.entity.Menu;
import com.xy.vmes.service.MenuTreeService;
import com.xy.vmes.service.MenuService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.StringUtil;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuTreeServiceImp implements MenuTreeService {
    @Autowired
    private MenuService menuService;

    //最大部门级别-系统最大支持6层-部门级别[0-5](0:默认层)
    private Integer maxLayer;
    //递归计数器-递归执行次数
    private Integer count;
    //当前递归执行所在层
    private Integer execute_layer;

    private List<Menu> list_0;
    private List<Menu> list_1;
    private List<Menu> list_2;
    private List<Menu> list_3;
    private List<Menu> list_4;
    private List<Menu> list_5;

    /**
     * 初始化方法
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void initialization() {
        this.maxLayer = Integer.valueOf(6);
        this.count = Integer.valueOf(0);
        this.execute_layer = Integer.valueOf(-1);

        list_1 = new ArrayList<Menu>();
        list_2 = new ArrayList<Menu>();
        list_3 = new ArrayList<Menu>();
        list_4 = new ArrayList<Menu>();
        list_5 = new ArrayList<Menu>();
    }

    /**
     * 根据菜单对象<Menu>当前菜单节点下面所有节点生成树形结构
     * 查询次数: 从当前节点到最低层叶子节点-总共菜单层级数
     *
     * 1. 该方法为递归调用
     * 2. 递归执行次数: count := 0 获取当前节点--
     * 3. 根据(pids)获取下一层<Menu>List
     * 4. 递归结束条件(递归执行次数 > 6 or 查询无子节点)
     * 5. 递归调用结束后生成(list_0,list_1,...,list_5)结构体
     *
     * @param pids  (','分隔的字符串)
     * @return
     * @throws RestException
     *
     * 创建人：陈刚
     * 创建时间：2018-07-31
     *
     */
    public void findMenuTree(String pids) {
        if (pids == null || pids.trim().length() == 0) {
            throw new RestException("", "参数错误:部门pid为空或空字符串！");
        }

        //1. count := 0 获取当前节点<Menu>(vmes_Menu:系统部门表)对象
        Menu findObj = new Menu();
        if (count == 0) {
            try {
                //isdisable:是否禁用(1:已禁用 0:启用)
                findObj.setIsdisable("0");
                findObj.setId(pids);
                PageData pageData = HttpUtils.entity2PageData(findObj, new PageData());
                Menu deptObj = menuService.findMenu(pageData);
                if (deptObj == null) {
                    return;
                }
                if (deptObj.getLayer() == null || deptObj.getLayer() == -1) {
                    throw new RestException("", "参数错误:部门id:" + pids + "部门级别为空或等于-1，请与管理员联系！");
                }

                //放入List结构体中
                List<Menu> objectList = new ArrayList<Menu>();
                objectList.add(deptObj);
                this.execute_layer = deptObj.getLayer();
                this.findLayerList(objectList, this.execute_layer);

                //execute_layer递归执行所在层 +1
                this.execute_layer = Integer.valueOf(this.execute_layer.intValue() + 1);
                //执行次数+1
                this.count = Integer.valueOf(this.count.intValue() + 1);

            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }

        //2. 根据pids获取下一层<Menu>List
        pids = StringUtil.stringTrimSpace(pids);
        pids = "'" + pids.replace(",", "','") + "'";
        String pidQuery = "pid in (" + pids + ")";

        PageData pageData = new PageData();
        //isdisable:是否禁用(1:已禁用 0:启用)
        pageData.put("isdisable", "0");
        pageData.put("queryStr", pidQuery);
        pageData.put("mapSize", Integer.valueOf(pageData.size()));

        List<Menu> childList = null;
        try {
            childList = menuService.findMenuList(pageData);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //当前childList 放入List结构体中
        this.findLayerList(childList, this.execute_layer);
        //execute_layer递归执行所在层 +1
        this.execute_layer = Integer.valueOf(this.execute_layer.intValue() + 1);

        //执行次数+1
        this.count = Integer.valueOf(this.count.intValue() + 1);

        //子部门<Menu>List-生成id字符串(','分隔的字符串)
        String chid_ids = menuService.findMenuidByMenuList(childList);

        //递归结束条件: 递归执行次数 > 6 or 查询无子节点
        if (count > 6 || childList == null || childList.size() == 0) {
            return;
        } else {
            //递归调用: findDeptTree()
            this.findMenuTree(chid_ids);
        }
    }

    /**
     * 根据已知的菜单List<Menu>-生成树形结构
     * @param menuList
     * @param layer
     */
    public void findMenuTreeByList(List<Menu> menuList, Integer layer) {
        if (menuList == null || menuList.size() == 0) {return;}
        if (layer == null) {return;}

        //获得每一层的id字符串Map
        Map<String, String> mapObj = new LinkedHashMap<String, String>();
        for (Menu object : menuList) {
            if (layer.intValue() == 0) {
                String id = object.getId0();
                mapObj.put(id, id);
            } else if (layer.intValue() == 1) {
                String id = object.getId1();
                mapObj.put(id, id);
            } else if (layer.intValue() == 2) {
                String id = object.getId2();
                mapObj.put(id, id);
            } else if (layer.intValue() == 3) {
                String id = object.getId3();
                mapObj.put(id, id);
            } else if (layer.intValue() == 4) {
                String id = object.getId4();
                mapObj.put(id, id);
            }
        }

        //遍历Map获得id字符串(通过','逗号分隔的字符串)
        StringBuffer ids = new StringBuffer();
        for (Iterator iterator = mapObj.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            ids.append(mapKey);
            ids.append(",");
        }
        String idsTemp = ids.toString();
        //去掉最后一个','
        if (idsTemp.lastIndexOf(",") != -1) {
            idsTemp = idsTemp.substring(0, idsTemp.lastIndexOf(","));
        }

        String id_str = StringUtil.stringTrimSpace(idsTemp);
        id_str = "'" + id_str.replace(",", "','") + "'";
        String pidQuery = "id in (" + id_str + ")";

        //查询部门表-获得每一层的id-部门集合List<Menu>
        PageData pageData = new PageData();
        //isdisable:是否禁用(1:已禁用 0:启用)
        pageData.put("isdisable", "0");
        pageData.put("queryStr", pidQuery);
        pageData.put("mapSize", Integer.valueOf(pageData.size()));

        List<Menu> objList = null;
        try {
            objList = menuService.findMenuList(pageData);
            //按照(Menu.serialNumber)部门排列序号-升序排序
            this.orderAcsBySerialNumber(objList);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //当前objList 放入List结构体中
        this.findLayerList(objList, layer);

        //递归结束条件(部门级别layer == 0)
        if (layer == 0) {
            return;
        } else {
            //递归调用: findMenuTreeByList()
            this.findMenuTreeByList(menuList, (layer - 1));
        }
    }

    public List<Menu> getList_0() {
        return list_0;
    }
    public void setList_0(List<Menu> list_0) {
        this.list_0 = list_0;
    }
    public List<Menu> getList_1() {
        return list_1;
    }
    public void setList_1(List<Menu> list_1) {
        this.list_1 = list_1;
    }
    public List<Menu> getList_2() {
        return list_2;
    }
    public void setList_2(List<Menu> list_2) {
        this.list_2 = list_2;
    }
    public List<Menu> getList_3() {
        return list_3;
    }
    public void setList_3(List<Menu> list_3) {
        this.list_3 = list_3;
    }
    public List<Menu> getList_4() {
        return list_4;
    }
    public void setList_4(List<Menu> list_4) {
        this.list_4 = list_4;
    }
    public List<Menu> getList_5() {
        return list_5;
    }
    public void setList_5(List<Menu> list_5) {
        this.list_5 = list_5;
    }

    ///////////////////////////////////////////////////////////////////////////
    //重写排序方法: 按照(Menu.serialNumber)升序排序
    private void orderAcsBySerialNumber(List<Menu> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                Menu object_0 = (Menu)arg0;
                Menu object_1 = (Menu)arg1;
                return object_0.getSerialNumber().compareTo(object_1.getSerialNumber());
            }
        });
    }

    private void findLayerList(List<Menu> objectList, Integer execute_layer) {
        if (objectList == null || objectList.size() == 0) {return;}
        if (execute_layer == null || -1 == execute_layer.intValue()) {return;}

        if (1 == execute_layer.intValue()) {this.setList_1(objectList);}
        if (2 == execute_layer.intValue()) {this.setList_2(objectList);}
        if (3 == execute_layer.intValue()) {this.setList_3(objectList);}
        if (4 == execute_layer.intValue()) {this.setList_4(objectList);}
        if (5 == execute_layer.intValue()) {this.setList_5(objectList);}
    }
}
