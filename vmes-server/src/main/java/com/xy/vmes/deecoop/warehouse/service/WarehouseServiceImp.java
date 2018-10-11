package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMapper;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.FileService;
import com.xy.vmes.service.WarehouseService;
import com.yvan.Numbers;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse:仓库货位表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-10
*/
@Service
@Transactional(readOnly = false)
public class WarehouseServiceImp implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void save(Warehouse warehouse) throws Exception{
        warehouse.setCdate(new Date());
        warehouseMapper.insert(warehouse);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void update(Warehouse warehouse) throws Exception{
        warehouse.setUdate(new Date());
        warehouseMapper.updateById(warehouse);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void updateAll(Warehouse warehouse) throws Exception{
        warehouse.setUdate(new Date());
        warehouseMapper.updateAllColumnById(warehouse);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public List<Warehouse> dataList(PageData pd) throws Exception{
        return warehouseMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public Warehouse findWarehouse(PageData object) {
        if (object == null) {return null;}

        List<Warehouse> objectList = this.findWarehouseList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public Warehouse findWarehouseById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouse(findMap);
    }

    public Warehouse findWarehouseByRoot() {
        PageData findMap = new PageData();
        findMap.put("pid", "root");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouse(findMap);
    }

    public List<Warehouse> findWarehouseList(PageData object) {
        if (object == null) {return null;}

        List<Warehouse> objectList = new ArrayList<Warehouse>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<Warehouse> findWarehouseListByPid(String pid) {
        List<Warehouse> objectList = new ArrayList<Warehouse>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        objectList = this.findWarehouseList(findMap);
        return objectList;
    }

    public boolean isExistByName(String pid, String id, String name) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);

        name = "'" + StringUtil.stringTrimSpace(name).replace(",", "','") + "'";
        findMap.put("queryStr", "name in (" + name + ")");

        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Warehouse> objectList = this.findWarehouseList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public List<String> findNameListByNumber(int start, int end) {
        List<String> objList = new ArrayList<String>();
        if (start == -1) {return objList;}
        if (end == -1) {return objList;}
        if (end < start) {return objList;}

        for (int i = start; i <= end; i++) {
            objList.add(Integer.valueOf(i).toString());
        }

        return objList;
    }

    public List<String> findNameListByChar(String start, String end) {
        List<String> objList = new ArrayList<String>();

        long start_long = StringUtil.char2Number(start);
        if (start_long == -1) {return objList;}

        long end_long = StringUtil.char2Number(end);
        if (end_long == -1) {return objList;}

        for (long i = start_long; i <= end_long; i++) {
            objList.add(Numbers.toString(i, Numbers.MAX_RADIX));
        }

        return objList;
    }

    public List<String> findNameList(String start, String end, String suffix) {
        List<String> objList = new ArrayList<String>();
        if (start == null || start.trim().length() == 0) {return objList;}
        if (end == null || end.trim().length() == 0) {return objList;}

        //获取(开始,结束)范围
        int start_int = -1;
        try {
            start_int = Integer.parseInt(start);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int end_int = -1;
        try {
            end_int = Integer.parseInt(end);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //获取(开始,结束)范围List
        if (start_int != -1 && end_int != -1) {
            objList = this.findNameListByNumber(start_int, end_int);
        } else if (start_int == -1 && end_int == -1) {
            objList = this.findNameListByChar(start, end);
        }

        List<String> newList = new ArrayList<String>();
        if (suffix == null || suffix.trim().length() == 0) {return objList;}
        if (objList.size() > 0) {
            for (String str : objList) {
                newList.add(str + suffix);
            }
        }

        return newList;
    }

    public String nameList2NameString(List<String> nameList) {
        if (nameList == null || nameList.size() == 0) {return new String();}

        StringBuffer bufStr = new StringBuffer();
        for (String str : nameList) {
            if (str.trim().length() > 0) {
                bufStr.append(str.trim());
                bufStr.append(",");
            }
        }

        String strTemp = bufStr.toString();
        //去掉最后一个','
        if (strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
        }
        return strTemp;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public String checkColumnByEntity(Warehouse object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //name 仓库名称
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "仓库名称");
            msgBuf.append(str_isnull);
        }

        //entityType 仓库类型
        if (object.getEntityType() == null || object.getEntityType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "仓库类型");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }
    public String checkColumnByVirtual(Warehouse object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //name 仓库名称
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "仓库名称");
            msgBuf.append(str_isnull);
        }

        //virtualGenre:虚拟库-属性(1:内部单位 2:外部单位)
        if (object.getVirtualGenre() == null || object.getVirtualGenre().trim().length() == 0) {
            msgBuf.append("请选择(内部单位,外部单位)" + Common.SYS_ENDLINE_DEFAULT);
        }

        if ("1".equals(object.getVirtualGenre().trim())) {
            //virtualDeptId 内部单位(部门ID)
            if (object.getVirtualDeptId() == null || object.getVirtualDeptId().trim().length() == 0) {
                String str_isnull = MessageFormat.format(column_isnull, "所属部门");
                msgBuf.append(str_isnull);
            }
            //virtualDeptName 内部单位名称
            if (object.getVirtualDeptName() == null || object.getVirtualDeptName().trim().length() == 0) {
                String str_isnull = MessageFormat.format(column_isnull, "所属部门");
                msgBuf.append(str_isnull);
            }
        }

        return msgBuf.toString();
    }

    public Warehouse paterObject2Warehouse(Warehouse paterObject, Warehouse objectDB) {
        if (objectDB == null) {objectDB = new Warehouse();}
        if (paterObject == null) {return objectDB;}

        if (paterObject.getId() != null && paterObject.getId().trim().length() > 0) {
            objectDB.setPid(paterObject.getId().trim());
        }

        //pathName:根节点到本节点路径名称
        String paterPathName = "";
        if (paterObject.getPathName() != null && paterObject.getPathName().trim().length() > 0) {
            paterPathName = paterObject.getPathName().trim();
        }
        if (objectDB.getName() != null && objectDB.getName().trim().length() > 0) {
            if (paterPathName.trim().length() == 0) {
                objectDB.setPathName(objectDB.getName());
            } else {
                objectDB.setPathName(paterPathName + "-" + objectDB.getName());
            }
        }

        //pathId:根节点到本节点路径ID
        String paterPathId = "";
        if (paterObject.getPathId() != null && paterObject.getPathId().trim().length() > 0) {
            paterPathId = paterObject.getPathId().trim();
        }
        if (paterPathId.trim().length() == 0) {
            objectDB.setPathId(objectDB.getId());
        } else {
            objectDB.setPathId(paterPathId + "-" + objectDB.getId());
        }

        //设置仓库或货位级别
        if (paterObject.getLayer() != null) {
            objectDB.setLayer(Integer.valueOf(paterObject.getLayer().intValue() + 1));
        }
        return objectDB;
    }

    public Warehouse clearWarehouseByPath(Warehouse objectDB) {
        if (objectDB == null) {objectDB = new Warehouse();}

        objectDB.setPathId(null);
        objectDB.setPathName(null);
        objectDB.setLayer(null);

        return objectDB;
    }

    /**
     * 创建部门货位
     * @param paterObj
     * @param keyNameMap
     * @return
     */
    public void createWarehouseByDeptPosition(Warehouse paterObj, Map<String, String> keyNameMap) {
        if (paterObj == null) {return;}
        if (keyNameMap == null || keyNameMap.size() == 0) {return;}

        for (Iterator iterator = keyNameMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();
            String mapValue = keyNameMap.get(mapKey).toString().trim();

            Warehouse warehouse = new Warehouse();
            warehouse.setId(Conv.createUuid());

            String companyID = paterObj.getCompanyId();
            if (companyID != null && companyID.trim().length() > 0) {
                String code = coderuleService.createCoder(companyID, "vmes_warehouse","WP");
                warehouse.setCode(code);
                warehouse.setCompanyId(companyID);
            }

            warehouse.setCuser(paterObj.getCuser());
            warehouse.setName(mapValue);
            //dept_id:货位所属部门ID
            warehouse.setDeptId(paterObj.getVirtualDeptId());
            //dept_place_key: 部门货位ID-(字典表-vmes_dictionary.id)
            warehouse.setDeptPlaceKey(mapKey);

            //设置货位路径名称
            warehouse = this.paterObject2Warehouse(paterObj, warehouse);

            try {
                //生成货位二维码
                String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(warehouse));
                if (qrcode != null && qrcode.trim().length() > 0) {
                    warehouse.setQrcode(qrcode);
                }
                this.save(warehouse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void createWarehouseByPosition(Warehouse paterObj, List<String> nameList) {
        if (paterObj == null) {return;}
        if (nameList == null || nameList.size() == 0) {return;}

        for (String name : nameList) {
            Warehouse warehouse = new Warehouse();
            warehouse.setId(Conv.createUuid());

            String companyID = paterObj.getCompanyId();
            if (companyID != null && companyID.trim().length() > 0) {
                String code = coderuleService.createCoder(companyID, "vmes_warehouse","WP");
                warehouse.setCode(code);
                warehouse.setCompanyId(companyID);
            }

            warehouse.setCuser(paterObj.getCuser());
            warehouse.setName(name);
            //设置货位路径名称
            warehouse = this.paterObject2Warehouse(paterObj, warehouse);

            try {
                //生成货位二维码
                String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(warehouse));
                if (qrcode != null && qrcode.trim().length() > 0) {
                    warehouse.setQrcode(qrcode);
                }
                this.save(warehouse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public TreeEntity warehouse2Tree(Warehouse warehouse, TreeEntity tree) {
        if (tree == null) {tree = new TreeEntity();}
        if (warehouse == null) {return tree;}

        //树形结构基本属性
        //id 当前节点ID
        tree.setId(warehouse.getId());
        //pid 当前节点父ID
        tree.setPid(warehouse.getPid());
        //name 当前节点名称
        tree.setName(warehouse.getName());
        //(必须)是否禁用(0:已禁用 1:启用)
        tree.setIsdisable(warehouse.getIsdisable());
        //layer 当前节点级别
        tree.setLayer(warehouse.getLayer());
        //serialNumber 节点顺序
        tree.setSerialNumber(Integer.valueOf(0));
        //virtualGenre:虚拟库-属性
        tree.setVirtualGenre(warehouse.getVirtualGenre());

        return tree;
    }
    public List<TreeEntity> warehouseList2TreeList(List<Warehouse> warehouseList, List<TreeEntity> treeList) {
        if (treeList == null) {treeList = new ArrayList<TreeEntity>();}
        if (warehouseList == null || warehouseList.size() == 0) {return treeList;}

        //遍历List<Warehouse>-生成treeList
        for (Warehouse object : warehouseList) {
            TreeEntity tree = this.warehouse2Tree(object, null);
            treeList.add(tree);
        }
        return treeList;
    }
}



