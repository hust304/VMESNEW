package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.MenuMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.MenuButtonService;
import com.xy.vmes.service.MenuService;
import com.xy.vmes.service.MenuTreeService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.Tree;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_menu:系统功能菜单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-31
*/
@Service
@Transactional(readOnly = false)
public class MenuServiceImp implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuButtonService menuButtonService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void save(Menu menu) throws Exception{
        menu.setCdate(new Date());
        menuMapper.insert(menu);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void update(Menu menu) throws Exception{
        menu.setUdate(new Date());
        menuMapper.updateById(menu);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    //@Cacheable(cacheNames = "menu", key = "''+#id")
    public Menu selectById(String id) throws Exception{
        return menuMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void deleteById(String id) throws Exception{
        menuMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Menu> dataListPage(PageData pd,Pagination pg) throws Exception{
        return menuMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Menu> dataList(PageData pd) throws Exception{
        return menuMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return menuMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return menuMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Autowired
    private MenuTreeService menuTreeService;
    @Autowired
    private CoderuleService coderuleService;

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    @Override
    public List<LinkedHashMap<String, String>> getColumnList() throws Exception{
        return menuMapper.getColumnList();
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    @Override
    public List<Map<String, Object>> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return menuMapper.getDataListPage(pd, pg);
    }

    /**
     * 生成菜单编码
     *
     * 创建人：陈刚
     * 创建时间：2018-08-02
     *
     * @param companyID  公司ID-组织架构ID
     * @return
     */
//    public String createCoder(String companyID) {
//        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
//        //(无需+前缀字符+无需+流水号)-W000142
//        CoderuleEntity object = new CoderuleEntity();
//        //tableName 业务名称(表名)
//        object.setTableName("vmes_menu");
//        //companyID 公司ID
//        object.setCompanyID(companyID);
//        //length 指定位数(5)
//        object.setLength(Common.CODE_RULE_LENGTH_DEFAULT);
//        //firstName 第一个编码名称
//        object.setFirstName("prefix");
//
//        //separator 分隔符
//        //object.setSeparator("-");
//        //filling 填充字符(0)
//        object.setFilling(Common.CODE_RULE_DEFAULT_FILLING);
//
//        //isNeedPrefix 是否需要前缀
//        object.setIsNeedPrefix(Boolean.TRUE);
//        //prefix 前缀字符
//        object.setPrefix("M");
//
//        return coderuleService.findCoderule(object);
//    }
    /**
     * 批量修改菜单信息为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-07-31
     */
    public void updateDisableByIds(String[] ids) throws Exception {
        menuMapper.updateDisableByIds(ids);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-31
     * @param object
     * @return
     */
    public String checkColumnByAdd(Menu object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！<br/>";

        if (object.getPid() == null || object.getPid().trim().length() == 0) {
            msgBuf.append("pid为空或空字符串！<br/>");
        }
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "菜单名称");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-31
     * @param object
     * @return
     */
    public String checkColumnByEdit(Menu object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！<br/>";

        if (object.getId() == null || object.getId().trim().length() == 0) {
            msgBuf.append("id为空或空字符串！<br/>");
        }
        if (object.getPid() == null || object.getPid().trim().length() == 0) {
            msgBuf.append("pid为空或空字符串！<br/>");
        }
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "菜单名称");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    /**
     * 查询菜单表(vmes_menu)
     * @param object
     * @return
     */
    public List<Menu> findMenuList(PageData object) {
        if (object == null) {return null;}

        List<Menu> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    /**
     * 查询菜单表(vmes_menu)
     * @param object
     * @return
     */
    public Menu findMenu(PageData object) {
        if (object == null) {return null;}

        List<Menu> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    /**
     * 根据ID-查询菜单表(vmes_menu)
     * @param id
     * @return
     */
    public Menu findMenuById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Menu> objectList = this.findMenuList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    /**
     * 根据pid-查询菜单表(vmes_menu)
     * @param pid
     * @return
     */
    public List<Menu> findMenuListByPid(String pid) {
        List<Menu> objectList = new ArrayList<Menu>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //是否禁用(0:已禁用 1:启用) 数据字典:sys_isdisable
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        objectList = this.findMenuList(findMap);

        return objectList;
    }

    /**
     * 菜单名称同一层级是否相同
     *
     * @param pid   (不可为空)
     * @param id    (允许为空)-(添加时is null, 修改时 is not null)
     * @param name  (不可为空)
     * @return
     *     true : 菜单名称存在名称相同
     *     false: 菜单名称不存在名称相同(默认值)
     */
    public boolean isExistByName(String pid, String id, String name) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("name", name);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Menu> objectList = this.findMenuList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    /**
     * 根据菜单对象<Menu>当前菜单节点下面所有节点生成树形结构
     * 1. <Menu>对象为空时-生成整棵树-(pid:=root)开始-菜单级别(0-5)
     * 2. <Menu>对象is not null
     * (允许为空)Menu.id         当前菜单id
     * (允许为空)Menu.companyId  当前菜单(companyId)-公司id
     * (允许为空)Menu.name       当前菜单名称
     * (允许为空)Menu.layer      当前菜单级别
     * 3. (id,companyId,name,layer) 不可同时为空
     * id is not null id对应的菜单+id下面所有子菜单
     * id is null (companyId,name,layer) is not null
     * <p>
     * <p>
     * <p>
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     * @param menu 允许为空-<Menu>对象(vmes_menu:系统菜单表)
     * @return
     */
    public Tree<Menu> findMenuTree(Menu menu) {
        Menu findObj = null;

        if (menu == null) {
            findObj = new Menu();
            findObj.setPid("root");
        } else if (menu != null) {
            //1. 参数非空判断
            if (menu.getId() != null && menu.getId().trim().length() > 0) {
                findObj = new Menu();
                findObj.setId(menu.getId().trim());
            } else if (menu.getCompanyId() != null && menu.getCompanyId().trim().length() > 0
                    && menu.getName() != null && menu.getName().trim().length() > 0
                    && menu.getLayer() != null
                    ) {
                findObj = new Menu();
                findObj.setCompanyId(menu.getCompanyId().trim());
                findObj.setName(menu.getName().trim());
                findObj.setLayer(menu.getLayer());
            }
        }

        if (findObj == null) {
            throw new RestException("", "参数错误:Menu(id,companyId,name,layer) 参数为空或空字符串，请与管理员联系！");
        }

        //2. 根据参数查询(vmes_menu:系统部门表)--获得返回树结构根节点
        //isdisable:是否禁用(0:已禁用 1:启用)
        findObj.setIsdisable("1");

        PageData pageData = HttpUtils.entity2PageData(findObj, new PageData());
        List<Menu> objectList = this.findMenuList(pageData);
        if (objectList == null || objectList.size() == 0) {
            String msgStr = "参数错误:Menu(pid,code,name,layer) 查询无数据，请与管理员联系！";
            throw new RestException("", msgStr);
        }
        Menu root_obj = objectList.get(0);

        //3. 生成部门树
        menuTreeService.initialization();
        menuTreeService.findMenuTree(root_obj.getId());

        return null;
    }

    /**
     * 获取菜单id字符串-(','分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    public String findMenuidByMenuList(List<Menu> objectList) {
        StringBuffer strBuf = new StringBuffer();
        if (objectList == null || objectList.size() == 0) {return strBuf.toString();}

        for (Menu dept : objectList) {
            strBuf.append(dept.getId().trim());
            strBuf.append(",");
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.indexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    /**
     * 获取菜单最大级别-遍历菜单List<Menu>
     *
     * 创建人：陈刚
     * 创建时间：2018-07-24
     * @param objectList
     * @return
     */
    public Integer findMaxLayerByMenuList(List<Menu> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}
        int maxLayer = 0;

        for (Menu object : objectList) {
            if (object.getLayer() != null && object.getLayer().intValue() > maxLayer) {
                maxLayer = object.getLayer().intValue();
            }
        }

        if (maxLayer > 0) {return Integer.valueOf(maxLayer);}
        return null;
    }

    public Integer findMaxSerialNumberByPid(String pid) {
        if (pid == null || pid.trim().length() == 0) {return Integer.valueOf(0);}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Menu> objectList = null;
        try {
            objectList = this.findMenuList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectList != null && objectList.size() > 0) {return Integer.valueOf(objectList.size());}

        return Integer.valueOf(0);
    }

    public Menu id2MenuByLayer(String id, Integer layer, Menu objectDB) {
        if (objectDB == null) {objectDB = new Menu();}
        if (id == null || id.trim().length() == 0) {return objectDB;}
        if (layer == null) {return objectDB;}

        if (0 == layer.intValue()) {
            objectDB.setId0(id);
        } else if (1 == layer.intValue()) {
            objectDB.setId1(id);
        } else if (2 == layer.intValue()) {
            objectDB.setId2(id);
        } else if (3 == layer.intValue()) {
            objectDB.setId3(id);
        } else if (4 == layer.intValue()) {
            objectDB.setId4(id);
        } else if (layer.intValue() == 5) {
            objectDB.setId5(id);
        }

        return objectDB;
    }

    public Menu paterObject2ObjectDB(Menu paterObject, Menu objectDB) {
        if (objectDB == null) {objectDB = new Menu();}
        if (paterObject == null) {return objectDB;}

        if (paterObject.getId0() != null && paterObject.getId0().trim().length() > 0) {
            objectDB.setId0(paterObject.getId0().trim());
        }
        if (paterObject.getId1() != null && paterObject.getId1().trim().length() > 0) {
            objectDB.setId1(paterObject.getId1().trim());
        }
        if (paterObject.getId2() != null && paterObject.getId2().trim().length() > 0) {
            objectDB.setId2(paterObject.getId2().trim());
        }
        if (paterObject.getId3() != null && paterObject.getId3().trim().length() > 0) {
            objectDB.setId3(paterObject.getId3().trim());
        }
        if (paterObject.getId4() != null && paterObject.getId4().trim().length() > 0) {
            objectDB.setId4(paterObject.getId4().trim());
        }
        if (paterObject.getId5() != null && paterObject.getId5().trim().length() > 0) {
            objectDB.setId5(paterObject.getId5().trim());
        }

        return objectDB;
    }

    public Menu clearMenuByPath(Menu objectDB) {
        if (objectDB == null) {objectDB = new Menu();}

        objectDB.setId0(null);
        objectDB.setId1(null);
        objectDB.setId2(null);
        objectDB.setId3(null);
        objectDB.setId4(null);
        objectDB.setId5(null);
        objectDB.setLayer(null);

        return objectDB;
    }

    public Menu object2objectDB(Menu object, Menu objectDB) {
        if (objectDB == null) {objectDB = new Menu();}
        if (object == null) {return objectDB;}

        objectDB.setPid(object.getPid());
        objectDB.setName(object.getName());
        objectDB.setUrl(object.getUrl());
        objectDB.setIsdisable(object.getIsdisable());

        //serialNumber 菜单顺序
        if (object.getSerialNumber() != null) {
            objectDB.setSerialNumber(object.getSerialNumber());
        }

        return objectDB;
    }

    /**
     * check菜单ID是否允许删除
     * 菜单ID(菜单按钮)-是否使用
     *
     * 创建人：陈刚
     * 创建时间：2018-07-30
     * @param ids
     * @return
     */
    public String checkDeleteMenuByIds(String ids) {
        if (ids == null || ids.trim().length() == 0) {return new String();}

        String msgTemp = "第&nbsp;{0}&nbsp;行:&nbsp;菜单在({1})中使用不可禁用！<br/>";
        StringBuffer msgBuf = new StringBuffer();

        String[] menuid_arry = ids.split(",");
        PageData findMap = new PageData();
        for (int i = 0; i < menuid_arry.length; i++) {
            String menuid = menuid_arry[i];

            findMap.put("isdisable", "1");
            findMap.put("roleId", menuid);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));

            //当前菜单ID(菜单按钮)
            List<MenuButton> list = menuButtonService.findMenuButtonList(findMap);
            if (list != null && list.size() > 0) {
                String msg_3 = MessageFormat.format(msgTemp, (i+1), "菜单按钮");
                msgBuf.append(msg_3);
            }
        }

        return  msgBuf.toString();
    }

}



