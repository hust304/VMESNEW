package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.*;

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
    private WarehouseExcelService warehouseExcelService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductToolService warehouseProductToolService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private ColumnService columnService;

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
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseMapper.getDataListPage(pd);
        } else if (pg != null) {
            return warehouseMapper.getDataListPage(pd,pg);
        }

        return mapList;
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
    public List<Map> getDataListPage(PageData pd) throws Exception {
        return warehouseMapper.getDataListPage(pd);
    }

    public void deleteWarehouseByPath(PageData pd) throws Exception {
        warehouseMapper.deleteWarehouseByPath(pd);
    }
    /**
     * 获取全部仓库货位记录，同时带出该(货位,货品)库存数量
     *
     * @param pd
     * @param pg
     * @return
     */
    public List<Map> findListWarehouseByWarehouseProduct(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseMapper.findListWarehouseByWarehouseProduct(pd, pg);
    }

    private Map<String, String> keyNameMap;
    private Map<String, String> nameKeyMap;

    public Map<String, String> getKeyNameMap() {
        return keyNameMap;
    }
    public Map<String, String> getNameKeyMap() {
        return nameKeyMap;
    }

    public void createBusinessMap() {
        this.keyNameMap = new HashMap<String, String>();
        this.nameKeyMap = new HashMap<String, String>();
    }

    public void implementBusinessMapByCompanyId(String companyId) {
        this.createBusinessMap();

        PageData findMap = new PageData();
        //isLeaf:是否叶子(0:非叶子 1:是叶子)
        findMap.put("isLeaf", "1");
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId.trim());
        }
        findMap.put("isdisable","1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Warehouse> objectList = this.findWarehouseList(findMap);
        if (objectList == null || objectList.size() == 0) {return;}

        for (Warehouse object : objectList) {
            String mapKey = object.getId();
            String mapName = object.getPathName();
            if (mapName != null && mapName.trim().length() > 0) {
                this.keyNameMap.put(mapKey, mapName);
                this.nameKeyMap.put(mapName, mapKey);
            }
        }
    }

    public void implementBusinessMapByParentID(String parentId, String companyId) {
        this.createBusinessMap();
        if (parentId == null || parentId.trim().length() == 0) {return;}

        List<Warehouse> deptList = this.findWarehouseListByPid(parentId, companyId);
        if (deptList == null || deptList.size() == 0) {return;}
        for (Warehouse object : deptList) {
            String id = object.getId();
            String name = object.getName();
            if (name != null && name.trim().length() > 0) {
                this.keyNameMap.put(id, name);
                this.nameKeyMap.put(name, id);
            }
        }
    }

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

    public List<Warehouse> findWarehouseListByPid(String pid, String companyId) {
        List<Warehouse> objectList = new ArrayList<Warehouse>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("companyId", companyId);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        objectList = this.findWarehouseList(findMap);
        return objectList;
    }

    public boolean isExistByName(String pid, String id, String name, String companyId) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        name = "'" + StringUtil.stringTrimSpace(name).replace(",", "','") + "'";
        findMap.put("queryStr", "name in (" + name + ")");
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("companyId", companyId);

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

    public Integer findMaxSerialNumber(String pid) {
        if (pid == null || pid.trim().length() == 0) {return Integer.valueOf(0);}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Warehouse> objectList = null;
        try {
            objectList = this.findWarehouseList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (objectList != null && objectList.size() > 0) {
            return Integer.valueOf(objectList.size());
        }

        return Integer.valueOf(0);
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

        //warehouseId 仓库ID
        if (paterObject.getWarehouseId() != null && paterObject.getWarehouseId().trim().length() > 0) {
            objectDB.setWarehouseId(paterObject.getWarehouseId().trim());
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
        objectDB.setWarehouseId(null);
        objectDB.setLayer(null);

        return objectDB;
    }

    public Warehouse warehouseObj2QRCodeObj(Warehouse warehouseObj, Warehouse QRCodeObj) {
        if (QRCodeObj == null) {QRCodeObj = new Warehouse();}
        if (warehouseObj == null) {return QRCodeObj;}

        QRCodeObj.setId(warehouseObj.getId());
        QRCodeObj.setPid(warehouseObj.getPid());
        QRCodeObj.setLayer(warehouseObj.getLayer());
        QRCodeObj.setName(warehouseObj.getName());
        QRCodeObj.setPathName(warehouseObj.getPathName());

        return QRCodeObj;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public String findPidsByWarehouseList(List<Warehouse> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Warehouse object : objectList) {
            String pid = object.getPid();
            if (pid != null && pid.trim().length() > 0) {
                strBuf.append(pid.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
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

        int count = 0;
        Integer maxCount = this.findMaxSerialNumber(paterObj.getId());
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
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + (count+1) ));

            try {
                //生成货位二维码
                //Warehouse QRCodeObj = this.warehouseObj2QRCodeObj(warehouse, null);
                String qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
                if (qrcode != null && qrcode.trim().length() > 0) {
                    warehouse.setQrcode(qrcode);
                }
                this.save(warehouse);
            } catch (Exception e) {
                e.printStackTrace();
            }

            count = count + 1;
        }

        //是否叶子(0:非叶子 1:是叶子)
        if ("1".equals(paterObj.getIsLeaf())) {
            paterObj.setIsLeaf("0");
            try {
                this.update(paterObj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void createWarehouseByPosition(Warehouse paterObj, List<String> nameList) {
        if (paterObj == null) {return;}
        if (nameList == null || nameList.size() == 0) {return;}

        Integer maxCount = this.findMaxSerialNumber(paterObj.getId());
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
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
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + (i+1) ));

            try {
                //生成货位二维码
                //Warehouse QRCodeObj = this.warehouseObj2QRCodeObj(warehouse, null);
                String qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
                if (qrcode != null && qrcode.trim().length() > 0) {
                    warehouse.setQrcode(qrcode);
                }
                this.save(warehouse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //是否叶子(0:非叶子 1:是叶子)
        if ("1".equals(paterObj.getIsLeaf())) {
            paterObj.setIsLeaf("0");
            try {
                this.update(paterObj);
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
        //pathName 根节点到本节点路径名称
        tree.setPathName(warehouse.getPathName());
        //pathId 根节点到本节点路径ID
        tree.setPathId(warehouse.getPathId());

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

    @Override
    public ResultModel listWarehouseNodeByPid(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串");
            return model;
        }

        String pid = pageData.getString("pid");
        if (pid == null || pid.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("pid为空或空字符串");
            return model;
        }

        int layer_int = 0;
        String layer = pageData.getString("layer");
        if (layer == null || layer.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("layer为空或空字符串");
            return model;
        } else {
            try {
                layer_int = Integer.valueOf(layer).intValue();
            } catch (NumberFormatException numberExc) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("layer(" + layer + ")错误，layer必须是正整数！");
                return model;
            }
        }

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("pid", pid);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        findMap.put("orderStr", "serial_number asc");

        List<Warehouse> objectList = this.findWarehouseList(findMap);
        List<TreeEntity> treeList = this.warehouseList2TreeList(objectList, null);

        TreeEntity nodeObject = new TreeEntity();
        nodeObject.setName(Integer.valueOf(layer_int).toString() + "级货位");
        nodeObject.setChildren(treeList);

        String nodeJsonStr = YvanUtil.toJson(nodeObject);
        System.out.println("nodeJsonStr: " + nodeJsonStr);

        model.putResult(nodeObject);

        return model;
    }

    @Override
    public ResultModel treeWarehouse(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        PageData findMap = new PageData();

        //设定查询条件
        String companyId = pageData.getString("currentCompanyId");
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }

//        //是否简版仓库 Y:是简版 N:非简版 is null:非简版
//        String isSimple = pageData.getString("isSimple");
//        if ("Y".equals(isSimple)) {
//            findMap.put("isSimple", "Y");
//        }
//
//        String isNotSimple = pageData.getString("isNotSimple");
//        if ("true".equals(isNotSimple)) {
//            findMap.put("isNotSimple", isNotSimple);
//        }

        //isNeedEntityVirtual 查询结果集需要(实体库,虚拟库)
        if ("true".equals(pageData.getString("isNeedEntityVirtual"))) {
            findMap.put("isNeedEntityVirtual", "true");
        }
        //isNeedEntity 查询结果集需要(实体库)
        if ("true".equals(pageData.getString("isNeedEntity"))) {
            findMap.put("isNeedEntity", "true");
        }
        //isNeedVirtual 查询结果集需要(虚拟库)
        if ("true".equals(pageData.getString("isNeedVirtual"))) {
            findMap.put("isNeedVirtual", "true");
        }

        //是否需要(备件库) isNeedSpare isNotNeedSpare
        if ("true".equals(pageData.getString("isNeedSpare"))) {
            findMap.put("isNeedSpare", "true");
        }
        if ("true".equals(pageData.getString("isNotNeedSpare"))) {
            findMap.put("isNotNeedSpare", "true");
        }

        //树形结构-开始显示节点id
        String treeNodeId = "";
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            findMap.put("layerQueryStr", "layer in (0,1)");
            treeNodeId = Common.DICTIONARY_MAP.get("warehouseRoot");
        } else if (id != null && id.trim().length() > 0) {
            treeNodeId = id.trim();
            findMap.put("nodeId", treeNodeId);

            if (Common.DICTIONARY_MAP.get("warehouseEntity").equals(id)) {
                findMap.put("layerQueryStr", "layer in (1)");
                findMap.put("isNeedEntity", null);
            } else if (Common.DICTIONARY_MAP.get("warehouseVirtual").equals(id)) {
                findMap.put("layerQueryStr", "layer in (1)");
                findMap.put("isNeedVirtual", null);
            }
        }

        String notInWarehouseIds = new String();
        if (pageData.getString("notInWarehouseIds") != null && pageData.getString("notInWarehouseIds").trim().length() > 0) {
            notInWarehouseIds = pageData.getString("notInWarehouseIds").trim();
            notInWarehouseIds = StringUtil.stringTrimSpace(notInWarehouseIds);
            notInWarehouseIds = "'" + notInWarehouseIds.replace(",", "','") + "'";
        }
        findMap.put("notInWarehouseIds", notInWarehouseIds);

        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        findMap.put("orderStr", "layer,serial_number asc");

        List<Warehouse> objectList = this.findWarehouseList(findMap);
        List<TreeEntity> treeList = this.warehouseList2TreeList(objectList, null);

        TreeEntity treeObj = TreeUtil.switchTree(treeNodeId, treeList);
        //String treeJsonStr = YvanUtil.toJson(treeObj);
        //System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouse(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouse");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);


        //isNeedwarehouseGenre 是否需要仓库属性
        String isNeedwarehouseGenre = pd.getString("isNeedwarehouseGenre");

        //是否启用(0:已禁用 1:启用)
        //pd.put("isdisable", "1");
        pd.put("orderStr", "a.pid,a.layer,a.serial_number asc");

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> newList = new ArrayList<Map>();
        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                String pathId = (String)mapObject.get("pathId");

                //layer 当前节点级别
                Integer layer = Integer.valueOf(0);
                if (mapObject.get("layer") != null) {
                    layer = (Integer)mapObject.get("layer");
                }

                //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                //虚拟库:warehouseVirtual:56f5e83dcb9911e884ad00163e105f05
                //实体库: 只获取(仓库)这一层级 (layer:2 的这一层-layer大于2的节点筛选出去)
                if ("true".equals(isNeedwarehouseGenre)
                        && pathId != null && pathId.trim().length() > 0
                        && pathId.indexOf(Common.DICTIONARY_MAP.get("warehouseEntity")) != -1
                        && layer.intValue() != 2
                        ) {
                    continue;
                }

                newList.add(mapObject);
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel findListWarehouseByWarehouseProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseByWarehouseProduct");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        pd.put("orderStr", "warehouse.layer,warehouse.serial_number asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findListWarehouseByWarehouseProduct(pd, pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel addWarehouseByEntity(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumnByEntity(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseEntity 实体库
        String pid = Common.DICTIONARY_MAP.get("warehouseEntity");
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(实体库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }

        String companyID = pageData.getString("currentCompanyId");
        //2. (仓库名称)在同一层名称不可重复
        if (this.isExistByName(pid, null, warehouse.getName(),companyID)) {
            String msgTemp = "实体库-仓库名称: {0}在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        String id = Conv.createUuid();
        warehouse.setId(id);
        warehouse.setWarehouseId(id);

        //获取仓库编码
        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WE");
        warehouse.setCompanyId(companyID);
        warehouse.setCode(code);
        //设置仓库路径名称
        warehouse = this.paterObject2Warehouse(paterObj, warehouse);

        //生成仓库(实体库)二维码
        //Warehouse QRCodeObj = this.warehouseObj2QRCodeObj(warehouse, null);
        String qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }

        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = this.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

//        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
//        String isSimple = pageData.getString("isSimple");
//        if ("Y".equals(isSimple)) {
//            warehouse.setIsSimple("Y");
//        }

        this.save(warehouse);
        return model;
    }

    @Override
    public ResultModel addWarehouseByVirtual(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumnByVirtual(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseVirtual 虚拟库
        String pid = Common.DICTIONARY_MAP.get("warehouseVirtual");
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(虚拟库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        //(仓库名称)在同一层名称不可重复
        if (this.isExistByName(pid, null, warehouse.getName(),companyID)) {
            String msgTemp = "虚拟库-仓库名称: {0}在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        String id = Conv.createUuid();
        warehouse.setId(id);
        warehouse.setWarehouseId(id);

        //获取仓库编码
        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WV");
        warehouse.setCompanyId(companyID);
        warehouse.setCode(code);
        //设置仓库路径名称
        warehouse = this.paterObject2Warehouse(paterObj, warehouse);

        //生成仓库(虚拟库)二维码
        //Warehouse QRCodeObj = this.warehouseObj2QRCodeObj(warehouse, null);
        String qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }
        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = this.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

//        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
//        String isSimple = pageData.getString("isSimple");
//        if ("Y".equals(isSimple)) {
//            warehouse.setIsSimple("Y");
//        }

        this.save(warehouse);

        //virtualGenre: 虚拟库属性(1:内部单位 2:外部单位)
        //1:内部单位:默认创建(物料区,待检区,合格区,不合格区,其他)-这5个货位
        if ("1".equals(warehouse.getVirtualGenre())) {
            //departmentPosition 部门货位名称(字典名称)
            dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("departmentPosition"), null);
            Map<String, String> keyNameMap = dictionaryService.getKeyNameMap();
            this.createWarehouseByDeptPosition(warehouse, keyNameMap);
        }
        return model;
    }

    @Override
    public ResultModel addWarehousePosition(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        if (warehouse.getPid() == null || warehouse.getPid().trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("上级id为空或空字符串！");
            return model;
        }
        if (warehouse.getName() == null || warehouse.getName().trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("库位名称为空或空字符串！");
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        String pid = warehouse.getPid().trim();
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + warehouse.getPid().trim() + ")系统中无数据，请与管理员联系！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        //(货位名称)在同一层名称不可重复
        if (this.isExistByName(pid, null, warehouse.getName(),companyID)) {
            String msgTemp = "上级名称: {0}{2}货位名称: {1}{2}在系统中已经重复！{2}";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    warehouse.getName(),
                    Common.SYS_ENDLINE_DEFAULT);
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        String id = Conv.createUuid();
        warehouse.setId(id);

        //获取货位编码
        warehouse.setCompanyId(companyID);

        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WP");
        warehouse.setCode(code);

        //设置库位路径名称
        warehouse = this.paterObject2Warehouse(paterObj, warehouse);

        //生成货位二维码
        //Warehouse QRCodeObj = this.warehouseObj2QRCodeObj(warehouse, null);
        String qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }
        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = this.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        this.save(warehouse);

        //是否叶子(0:非叶子 1:是叶子)
        if ("1".equals(paterObj.getIsLeaf())) {
            paterObj.setIsLeaf("0");
            this.update(paterObj);
        }
        return model;
    }

    @Override
    public ResultModel addWarehousePositionByRange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //非空判断
        //pid 上级id
        String pid = pageData.getString("pid");
        if (pid == null || pid.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("上级id为空或空字符串！");
            return model;
        }
        //start 起始范围
        String start = pageData.getString("start");
        if (start == null || start.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("起始范围为空或空字符串！");
            return model;
        }
        //end 结束范围
        String end = pageData.getString("end");
        if (end == null || end.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("结束范围为空或空字符串！");
            return model;
        }
        //name 货位名称
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位名称为空或空字符串！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        //pid 获取父节点对象<Warehouse>
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + pid + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //根据起止范围获取货位名称List
        List<String> nameList = this.findNameList(start, end, name);
        String nameString = this.nameList2NameString(nameList);
        if (nameString == null || nameString.trim().length() == 0) {
            return model;
        }
        if (this.isExistByName(pid, null, nameString,companyID)) {
            String msgTemp = "当前起止范围{0}-{1}，库位名称:{2}，系统生成货位名称在仓库名称:{3}下重复，请核对后再次操作！";
            String str_isnull = MessageFormat.format(msgTemp,
                    start,
                    end,
                    name,
                    paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //获取当前登录用户id
        String cuser = pageData.getString("cuser");
        paterObj.setCuser(cuser);

        //添加货位-按起止范围
        this.createWarehouseByPosition(paterObj, nameList);
        return model;
    }


    @Override
    public ResultModel updateWarehouseByEntity(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumnByEntity(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseEntity 实体库
        String pid = Common.DICTIONARY_MAP.get("warehouseEntity");
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(实体库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        //(仓库名称)在同一层名称不可重复
        if (this.isExistByName(pid, warehouse.getId(), warehouse.getName(),companyID)) {
            String msgTemp = "实体库-仓库名称: {0}在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //设置仓库路径名称
        warehouse = this.clearWarehouseByPath(warehouse);
        warehouse = this.paterObject2Warehouse(paterObj, warehouse);
        this.update(warehouse);
        return model;
    }

    @Override
    public ResultModel updateWarehouseByVirtual(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumnByVirtual(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseVirtual 虚拟库
        String pid = Common.DICTIONARY_MAP.get("warehouseVirtual");
        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(虚拟库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }
        String companyID = pageData.getString("currentCompanyId");
        //(仓库名称)在同一层名称不可重复
        if (this.isExistByName(pid, warehouse.getId(), warehouse.getName(),companyID)) {
            String msgTemp = "虚拟库-仓库名称: {0}在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //virtualGenre: 虚拟库属性(1:内部单位 2:外部单位)
        //1:内部单位:默认创建(物料区,待检区,合格区,不合格区)-这4个货位
        if ("1".equals(warehouse.getVirtualGenre())) {
            //删除原来的货位
            Map columnMap = new HashMap();
            columnMap.put("pid", warehouse.getId());
            columnMap.put("layer", Integer.valueOf(warehouse.getLayer() + 1) );
            this.deleteByColumnMap(columnMap);

            //departmentPosition 部门货位名称(字典名称)
            dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("departmentPosition"), null);
            Map<String, String> keyNameMap = dictionaryService.getKeyNameMap();
            this.createWarehouseByDeptPosition(warehouse, keyNameMap);
        }

        //设置仓库路径名称
        warehouse = this.clearWarehouseByPath(warehouse);
        warehouse = this.paterObject2Warehouse(paterObj, warehouse);
        this.update(warehouse);
        return model;
    }

    @Override
    public ResultModel updateWarehousePositionByName(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //非空判断
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串！");
            return model;
        }
        String pid = pageData.getString("pid");
        if (pid == null || pid.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("上级id为空或空字符串！");
            return model;
        }
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位名称为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("currentCompanyId");

        Warehouse paterObj = this.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + pid + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(货位名称)在同一层名称不可重复
        if (this.isExistByName(pid, id, name,companyId)) {
            String msgTemp = "货位名称:{0}，上级名称:{1}下重复，请核对后再次操作！";
            String str_isnull = MessageFormat.format(msgTemp,
                    name,
                    paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        Warehouse warehouse = this.findWarehouseById(id);
        warehouse.setName(name);
        //pathName 根节点到本节点路径名称
        if (paterObj.getPathName() != null && paterObj.getPathName().trim().length() > 0) {
            warehouse.setPathName(paterObj.getPathName().trim() + "-" + name);
        }
        this.update(warehouse);
        return model;
    }

    @Override
    public ResultModel deleteWarehouse(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = (String)pageData.get("currentCompanyId");
        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        //this.updateToDisableByIds(id_arry);


        //遍历勾选仓库id数组
        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < id_arry.length; i++) {
            String warehouseId = id_arry[i];

            //获取指定仓库(仓库id)是否存在库存
            //   Boolean.TRUE : 仓库中存在货品数量大于零的货品
            //   Boolean.FALSE: 仓库中不存在货品数量大于零的货品
            Boolean isExistStockCount = warehouseProductToolService.isExistStockCountByWarehouseId(companyId, warehouseId);
            if (isExistStockCount != null && isExistStockCount.booleanValue()) {
                msgBuf.append("第 (" +(i+1)+") 行：该仓库存在货品不可删除禁用！");
            }
        }
        if (msgBuf != null && msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //1. 验证当前仓库id或货位id下所有子仓库或子货位是否含有货品
        msgBuf = new StringBuffer();
        for (String warehouseId : id_arry) {
            Warehouse warehouse = this.findWarehouseById(warehouseId);

            PageData findMap = new PageData();
            findMap.put("warehouseId", warehouseId);
            findMap.put("companyId", companyId);
            List<Map<String, Object>> mapList = warehouseProductService.findWarehouseProductByWarehouse(findMap);

            if (mapList != null && mapList.size() > 0) {
                String tempStr = "名称:{0} 名称路径:{1} 当前仓库或货位名称下所有子仓库或子货位含有货品，不可删除该仓库或货位" + Common.SYS_ENDLINE_DEFAULT;
                String msgStr = MessageFormat.format(tempStr,
                        warehouse.getName(),
                        warehouse.getPathName()
                );
                msgBuf.append(msgStr);
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //2. 删除当前仓库id或货位id并且删除所有子仓库或子货位
        for (String warehouseId : id_arry) {
            PageData findMap = new PageData();
            findMap.put("warehouseId", warehouseId);
            findMap.put("companyId", companyId);
            this.deleteWarehouseByPath(findMap);
        }

        return model;
    }

    public ResultModel updateDisableWarehouse(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        //是否启用(0:已禁用 1:启用)
        String isdisable = pageData.getString("isdisable");
        String companyId = pageData.getString("currentCompanyId");

        //1. 非空判断
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //1. 获取指定仓库(仓库id)是否存在库存
        if ("0".equals(isdisable.trim())) {
            Boolean isExistStockCount = warehouseProductToolService.isExistStockCountByWarehouseId(companyId, id);
            if (isExistStockCount != null && isExistStockCount.booleanValue()) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("该仓库存在货品不可删除禁用！");
                return model;
            }
        }

        //2. 修改客户供应商(禁用)状态
        Warehouse editWarehouse = new Warehouse();
        editWarehouse.setId(id);
        editWarehouse.setIsdisable(isdisable);
        this.update(editWarehouse);

        return model;
    }

    @Override
    public void exportExcelWarehouse(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("warehouse");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List

        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouse";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouse(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
                || fileName.matches("^.+\\.(?i)(xls)$"))
                ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        //去掉列表名称行
        dataMapLst.remove(0);

        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = warehouseExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                userId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(this.exportExcelError(msgStr).toString());
            return model;
        }

        //2. Excel导入字段-名称唯一性判断-在Excel文件中
        //3. Excel导入字段-名称唯一性判断-在业务表中判断
        //4. Excel数据添加到货品表
        Map<String, List<Map<String, String>>> warehouseMap = warehouseExcelService.findWarehouseMapByImportDataList(dataMapLst);
        warehouseExcelService.addImportExcelByMap(warehouseMap);

        return model;
    }

    /**
     * 添加(仓库) vmes_warehouse - Excel导入时调用
     * 按仓库名称导入(仓库名称,一级名称,二级名称,三级名称,四级名称,五级名称,六级名称)
     *
     * @param parent    父节点对象
     * @param companyId 企业id
     * @param nameList  仓库名称List
     * @param count     递归执行次数
     */
    public void addWarehouseByNameList(Warehouse parent,
                                       String companyId,
                                       List<String> nameList,
                                       int count) {
        if (nameList == null || nameList.size() == 0) {return;}

        //1. 仓库名称
        String name = nameList.get(nameList.size() - count);
        if (name == null || name.trim().length() == 0) {return;}

        this.implementBusinessMapByParentID(parent.getId(), companyId);
        Map<String, String> nameKeyMap = this.getNameKeyMap();

        //获取当前节点<Warehouse>对象
        Warehouse warehouse = new Warehouse();
        if (nameKeyMap.get(name.trim()) == null) {
            //添加操作
            warehouse.setId(Conv.createUuid());
            warehouse.setName(name);
            //是否叶子(0:非叶子 1:是叶子)
            warehouse.setIsLeaf("1");

            //生成货位二维码
            String qrcode = "";
            try {
                qrcode = fileService.createQRCode("warehouseBase", warehouse.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (qrcode != null && qrcode.trim().length() > 0) {
                warehouse.setQrcode(qrcode);
            }

            warehouse.setCuser(parent.getCuser());
            warehouse.setCompanyId(parent.getCompanyId());

            //货位编码
            String code = coderuleService.createCoder(warehouse.getCompanyId(), "vmes_warehouse","WP");
            warehouse.setCode(code);

            //设置默认顺序
            if (warehouse.getSerialNumber() == null) {
                Integer maxCount = this.findMaxSerialNumber(parent.getPid());
                warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
            }
            warehouse = this.paterObject2Warehouse(parent, warehouse);

            try {
                this.save(warehouse);

                if (parent != null && "1".equals(parent.getIsLeaf())) {
                    //是否叶子(0:非叶子 1:是叶子)
                    Warehouse parentEdit = new Warehouse();
                    parentEdit.setId(parent.getId());
                    parentEdit.setIsLeaf("0");
                    this.update(parentEdit);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String id = nameKeyMap.get(name.trim()).trim();
            warehouse = this.findWarehouseById(id);
        }

        if (0 == (count - 1)) {
            return;
        } else {
            count = count - 1;
            addWarehouseByNameList(warehouse,
                    companyId,
                    nameList,
                    count);
        }
    }

    private StringBuffer exportExcelError(String msgStr) {
        StringBuffer msgBuf = new StringBuffer();
        msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
        msgBuf.append(msgStr.trim());
        msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

        return msgBuf;
    }
}



