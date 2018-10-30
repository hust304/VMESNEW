package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.*;



/**
* 说明：vmes_warehouse:仓库货位表Controller
* @author 陈刚 自动生成
* @date 2018-10-10
*/
@RestController
@Slf4j
public class WarehouseController {
    private Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################/warehouseBase/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pd, new Warehouse());
        warehouseService.save(warehouse);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################/warehouseBase/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pd, new Warehouse());
        warehouseService.update(warehouse);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/warehouseBase/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/warehouseBase/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            warehouseService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/warehouseBase/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Warehouse> warehouseList = warehouseService.dataList(pd);
        model.putResult(warehouseList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 获取仓库树结构
     * 1. 当前企业的仓库树
     * 2. 指定仓库节点及该节点下所有子节点
     *    指定仓库节id(为空或空字符串)-得到整棵仓库树
     *
     * @author 陈刚
     * @date 2018-10-10
     */
    @PostMapping("/warehouseBase/treeWarehouse")
    public ResultModel treeWarehouse() throws Exception {
        logger.info("################warehouseBase/treeWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        PageData findMap = new PageData();

        //树形结构-开始显示节点id
        String treeNodeId = "";

        //设定查询条件
        String companyId = pageData.getString("currentCompanyId");
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            findMap.put("layerQueryStr", "layer in (0,1)");
            treeNodeId = Common.DICTIONARY_MAP.get("warehouseRoot");
        } else if (id != null && id.trim().length() > 0) {
            treeNodeId = id.trim();
        }
        findMap.put("nodeId", treeNodeId);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Warehouse> objectList = warehouseService.findWarehouseList(findMap);
        List<TreeEntity> treeList = warehouseService.warehouseList2TreeList(objectList, null);

        TreeEntity treeObj = TreeUtil.switchTree(treeNodeId, treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseBase/treeWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/listPageWarehouse")
    public ResultModel listPageWarehouse() throws Exception {
        logger.info("################/warehouseBase/listPageWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouse");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
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

        PageData pd = HttpUtils.parsePageData();
        pd.put("orderStr", "a.cdate desc");
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseService.getDataListPage(pd, pg);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/listPageWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增仓库(实体库)
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/addWarehouseByEntity")
    @Transactional
    public ResultModel addWarehouseByEntity() throws Exception {
        logger.info("################/warehouseBase/addWarehouseByEntity 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseService.checkColumnByEntity(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseEntity 实体库
        String pid = Common.DICTIONARY_MAP.get("warehouseEntity");
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(实体库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (仓库名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, null, warehouse.getName())) {
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
        String companyID = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WE");
        warehouse.setCompanyId(companyID);
        warehouse.setCode(code);
        //设置仓库路径名称
        warehouse = warehouseService.paterObject2Warehouse(paterObj, warehouse);

        //生成仓库(实体库)二维码
        String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(warehouse));
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }

        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = warehouseService.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

        warehouseService.save(warehouse);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/addWarehouseByEntity 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增仓库(虚拟库)
     * 上级id
     * pid：2d75e49bcb9911e884ad00163e105f05：实体库
     * pid：56f5e83dcb9911e884ad00163e105f05：虚拟库
     *
     * virtualGenre: 虚拟库属性(1:内部单位 2:外部单位)
     * 1:内部单位 (仓库名称:=部门名称)-用户不可更改
     *   默认创建(物料区,待检区,合格区,不合格区)-这4个货位
     * 2:外部单位 (仓库名称:=客户供应商名称)-用户允许更改
     *
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/addWarehouseByVirtual")
    @Transactional
    public ResultModel addWarehouseByVirtual() throws Exception {
        logger.info("################/warehouseBase/addWarehouseByVirtual 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseService.checkColumnByVirtual(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseVirtual 虚拟库
        String pid = Common.DICTIONARY_MAP.get("warehouseVirtual");
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(虚拟库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(仓库名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, null, warehouse.getName())) {
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
        String companyID = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WV");
        warehouse.setCompanyId(companyID);
        warehouse.setCode(code);
        //设置仓库路径名称
        warehouse = warehouseService.paterObject2Warehouse(paterObj, warehouse);

        //生成仓库(虚拟库)二维码
        String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(warehouse));
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }
        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = warehouseService.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        warehouseService.save(warehouse);

        //virtualGenre: 虚拟库属性(1:内部单位 2:外部单位)
        //1:内部单位:默认创建(物料区,待检区,合格区,不合格区)-这4个货位
        if ("1".equals(warehouse.getVirtualGenre())) {
            //departmentPosition 部门货位名称(字典名称)
            dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("departmentPosition"), null);
            Map<String, String> keyNameMap = dictionaryService.getKeyNameMap();
            warehouseService.createWarehouseByDeptPosition(warehouse, keyNameMap);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/addWarehouseByVirtual 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增仓库货位(按名称添加)
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/addWarehousePosition")
    @Transactional
    public ResultModel addWarehousePosition() throws Exception {
        logger.info("################/warehouseBase/addWarehousePosition 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
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
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + warehouse.getPid().trim() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(货位名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, null, warehouse.getName())) {
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
        String companyID = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyID, "vmes_warehouse","WP");
        warehouse.setCode(code);
        //设置库位路径名称
        warehouse = warehouseService.paterObject2Warehouse(paterObj, warehouse);

        //生成货位二维码
        String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(warehouse));
        if (qrcode != null && qrcode.trim().length() > 0) {
            warehouse.setQrcode(qrcode);
        }
        //设置默认顺序
        if (warehouse.getSerialNumber() == null) {
            Integer maxCount = warehouseService.findMaxSerialNumber(pid);
            warehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        warehouseService.save(warehouse);

        //是否叶子(0:非叶子 1:是叶子)
        if ("1".equals(paterObj.getIsLeaf())) {
            paterObj.setIsLeaf("0");
            warehouseService.update(paterObj);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/addWarehousePosition 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增仓库货位(按起止范围)
     * 起始范围:字符(a-z,A-Z) 数字(0-9)
     * 结束范围:字符(a-z,A-Z) 数字(0-9)
     *
     * 例如:
     * 1. 起止范围 [A,D] 库位名称：库位名称
     *    系统自动生成: A库位名称 B库位名称 C库位名称 D库位名称
     * 2. 起止范围 [3,6] 库位名称：库位名称
     *    系统自动生成: 3库位名称 4库位名称 5库位名称 6库位名称
     *
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @GetMapping("/warehouseBase/addWarehousePositionByRange")
    @Transactional
    public ResultModel addWarehousePositionByRange() throws Exception {
        logger.info("################/warehouseBase/addWarehousePositionByRange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

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

        //pid 获取父节点对象<Warehouse>
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + pid + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //根据起止范围获取货位名称List
        List<String> nameList = warehouseService.findNameList(start, end, name);
        String nameString = warehouseService.nameList2NameString(nameList);
        if (nameString == null || nameString.trim().length() == 0) {
            return model;
        }
        if (warehouseService.isExistByName(pid, null, nameString)) {
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
        warehouseService.createWarehouseByPosition(paterObj, nameList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/addWarehousePositionByRange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 修改仓库(实体库)
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/updateWarehouseByEntity")
    @Transactional
    public ResultModel updateWarehouseByEntity() throws Exception {
        logger.info("################/warehouseBase/updateWarehouseByEntity 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseService.checkColumnByEntity(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseEntity 实体库
        String pid = Common.DICTIONARY_MAP.get("warehouseEntity");
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(实体库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(仓库名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, warehouse.getId(), warehouse.getName())) {
            String msgTemp = "实体库-仓库名称: {0}在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //设置仓库路径名称
        warehouse = warehouseService.clearWarehouseByPath(warehouse);
        warehouse = warehouseService.paterObject2Warehouse(paterObj, warehouse);
        warehouseService.update(warehouse);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/updateWarehouseByEntity 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库(虚拟库)
     * 上级id
     * pid：2d75e49bcb9911e884ad00163e105f05：实体库
     * pid：56f5e83dcb9911e884ad00163e105f05：虚拟库
     *
     * virtualGenre: 虚拟库属性(1:内部单位 2:外部单位)
     * 1:内部单位 (仓库名称:=部门名称)-用户不可更改
     *   默认创建(物料区,待检区,合格区,不合格区)-这4个货位
     *   删除这4个货位
     *
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/updateWarehouseByVirtual")
    @Transactional
    public ResultModel updateWarehouseByVirtual() throws Exception {
        logger.info("################/warehouseBase/updateWarehouseByVirtual 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Warehouse warehouse = (Warehouse)HttpUtils.pageData2Entity(pageData, new Warehouse());
        if (warehouse == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象Warehouse 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseService.checkColumnByVirtual(warehouse);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Warehouse>
        //warehouseVirtual 虚拟库
        String pid = Common.DICTIONARY_MAP.get("warehouseVirtual");
        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(虚拟库id:" + Common.DICTIONARY_MAP.get("warehouseEntity") + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(仓库名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, warehouse.getId(), warehouse.getName())) {
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
            warehouseService.deleteByColumnMap(columnMap);

            //departmentPosition 部门货位名称(字典名称)
            dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("departmentPosition"), null);
            Map<String, String> keyNameMap = dictionaryService.getKeyNameMap();
            warehouseService.createWarehouseByDeptPosition(warehouse, keyNameMap);
        }

        //设置仓库路径名称
        warehouse = warehouseService.clearWarehouseByPath(warehouse);
        warehouse = warehouseService.paterObject2Warehouse(paterObj, warehouse);
        warehouseService.update(warehouse);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/updateWarehouseByVirtual 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库货位
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/updateWarehousePosition")
    @Transactional
    public ResultModel updateWarehousePosition() throws Exception {
        logger.info("################/warehouseBase/updateWarehousePosition 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

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

        Warehouse paterObj = warehouseService.findWarehouseById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(上级id:" + pid + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //(货位名称)在同一层名称不可重复
        if (warehouseService.isExistByName(pid, id, name)) {
            String msgTemp = "货位名称:{0}，上级名称:{1}下重复，请核对后再次操作！";
            String str_isnull = MessageFormat.format(msgTemp,
                    name,
                    paterObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        Warehouse warehouse = warehouseService.findWarehouseById(id);
        warehouse.setName(name);
        warehouseService.update(warehouse);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/updateWarehousePosition 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 刪除仓库或货位
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouseBase/deleteWarehouse")
    @Transactional
    public ResultModel deleteWarehouse() throws Exception {
        logger.info("################/warehouseBase/deleteWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        warehouseService.updateToDisableByIds(id_arry);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/deleteWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/exportExcelWarehouse")
    public void exportExcelWarehouse() throws Exception {
        logger.info("################/warehouseBase/exportExcelWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("warehouse");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = warehouseService.getDataListPage(pd, pg);

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
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/exportExcelWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouseBase/importExcelWarehouse")
    public ResultModel importExcelWarehouse(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/warehouseBase/importExcelWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/importExcelWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



