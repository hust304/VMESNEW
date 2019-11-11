package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

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

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouse/warehouseBase/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/warehouseBase/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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
    @PostMapping("/warehouse/warehouseBase/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/warehouseBase/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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
    @PostMapping("/warehouse/warehouseBase/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/warehouseBase/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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
    @PostMapping("/warehouse/warehouseBase/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/warehouseBase/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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
    @PostMapping("/warehouse/warehouseBase/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/warehouseBase/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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
    @PostMapping("/warehouse/warehouseBase/treeWarehouse")
    public ResultModel treeWarehouse() throws Exception {
        logger.info("################warehouseBase/treeWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.treeWarehouse(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseBase/treeWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚
    * @date 2018-10-10
    */
    @PostMapping("/warehouse/warehouseBase/listPageWarehouse")
    public ResultModel listPageWarehouse() throws Exception {
        logger.info("################/warehouseBase/listPageWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseService.listPageWarehouse(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/listPageWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取全部仓库货位记录，同时带出该(货位,货品)库存数量
    @PostMapping("/warehouse/warehouseBase/findListWarehouseByWarehouseProduct")
    public ResultModel findListWarehouseByWarehouseProduct() throws Exception {
        logger.info("################/warehouseBase/findListWarehouseByWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseService.findListWarehouseByWarehouseProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/findListWarehouseByWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 仓库-入库管理-新增(页面)-仓库(多级选择框)
     * 获取当前企业(实体库,虚拟库)下面的仓库
     * isNeedwarehouseGenre 是否需要仓库属性
     *   isNeedwarehouseGenre:true:需要显示仓库属性(只显示仓库属性节点)
     *   isNeedwarehouseGenre:true:实体库只获取(仓库)这一层级 (layer:2 的这一层-layer大于2的节点筛选出去)
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseBase/treeSelectWarehouse")
    public ResultModel treeSelectWarehouse () throws Exception {
        logger.info("################/warehouse/warehouseBase/treeSelectWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String companyId = pd.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String isNeedEntityVirtual = new String();
        if (pd.getString("isNeedEntityVirtual") != null) {
            isNeedEntityVirtual = pd.getString("isNeedEntityVirtual").trim();
        }
        pd.put("isNeedEntityVirtual", isNeedEntityVirtual);
        //是否启用(0:已禁用 1:启用)
        pd.put("isdisable", "1");

        //isNeedwarehouseGenre 是否需要仓库属性
        String isNeedwarehouseGenre = pd.getString("isNeedwarehouseGenre");

        String orderStr = new String();
        if (pd.getString("orderStr") != null) {
            orderStr = pd.getString("orderStr").trim();
        }
        pd.put("orderStr", orderStr);

        List<TreeEntity> treeList = new ArrayList<TreeEntity>();
        List<Map> mapList = new ArrayList<Map>();
        try {
            mapList = warehouseService.getDataListPage(pd);
            if (mapList != null && mapList.size() > 0) {
                for (Map<String, Object> mapObject : mapList) {
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

                    TreeEntity treeNode = new TreeEntity();
                    //id 当前节点ID
                    String id = (String)mapObject.get("id");
                    treeNode.setId(id);
                    treeNode.setValue(id);

                    //pid 当前节点父ID
                    String pid = (String)mapObject.get("pid");
                    treeNode.setPid(pid);

                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    //虚拟库:warehouseVirtual:56f5e83dcb9911e884ad00163e105f05
                    if (Common.DICTIONARY_MAP.get("warehouseEntity").equals(pid)
                        || Common.DICTIONARY_MAP.get("warehouseVirtual").equals(pid)
                    ) {
                        treeNode.setPid(Common.DICTIONARY_MAP.get("warehouseRoot"));
                    }

                    //name (必须)当前节点名称
                    String name = (String)mapObject.get("name");
                    treeNode.setName(name);
                    treeNode.setLabel(name);

                    //isdisable (必须)是否禁用(0:已禁用 1:启用)
                    String isdisable = (String)mapObject.get("isdisable");
                    treeNode.setIsdisable(isdisable);

                    //layer 当前节点级别
                    if (mapObject.get("layer") != null) {
                        layer = (Integer)mapObject.get("layer");
                    }
                    treeNode.setLayer(layer);

                    //serialNumber 节点顺序
                    Integer serialNumber = Integer.valueOf(0);
                    if (mapObject.get("layer") != null) {
                        serialNumber = (Integer)mapObject.get("serialNumber");
                    }
                    treeNode.setSerialNumber(serialNumber);

                    treeList.add(treeNode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //插入根节点
        TreeEntity rootNode = new TreeEntity();
        Warehouse rootWarehouse = warehouseService.findWarehouseById(Common.DICTIONARY_MAP.get("warehouseRoot"));
        rootNode.setId(rootWarehouse.getId());
        rootNode.setPid(rootWarehouse.getPid());
        rootNode.setName(rootWarehouse.getName());
        rootNode.setIsdisable(rootWarehouse.getIsdisable());
        rootNode.setLayer(rootWarehouse.getLayer());
        rootNode.setSerialNumber(rootWarehouse.getSerialNumber());
        treeList.add(rootNode);

        TreeEntity treeObj = TreeUtil.switchTree(Common.DICTIONARY_MAP.get("warehouseRoot"), treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("options", treeObj.getChildren());
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseBase/treeSelectWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 新增仓库(实体库)
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseBase/addWarehouseByEntity")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseByEntity() throws Exception {
        logger.info("################/warehouseBase/addWarehouseByEntity 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.addWarehouseByEntity(pageData);
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
     *   默认创建(物料区,待检区,合格区,不合格区,其他)-这5个货位
     * 2:外部单位 (仓库名称:=客户供应商名称)-用户允许更改
     *
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseBase/addWarehouseByVirtual")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseByVirtual() throws Exception {
        logger.info("################/warehouseBase/addWarehouseByVirtual 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.addWarehouseByVirtual(pageData);
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
    @PostMapping("/warehouse/warehouseBase/addWarehousePosition")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehousePosition() throws Exception {
        logger.info("################/warehouseBase/addWarehousePosition 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.addWarehousePosition(pageData);
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
    @PostMapping("/warehouse/warehouseBase/addWarehousePositionByRange")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehousePositionByRange() throws Exception {
        logger.info("################/warehouseBase/addWarehousePositionByRange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.addWarehousePositionByRange(pageData);
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
    @PostMapping("/warehouse/warehouseBase/updateWarehouseByEntity")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseByEntity() throws Exception {
        logger.info("################/warehouseBase/updateWarehouseByEntity 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.updateWarehouseByEntity(pageData);
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
    @PostMapping("/warehouse/warehouseBase/updateWarehouseByVirtual")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseByVirtual() throws Exception {
        logger.info("################/warehouseBase/updateWarehouseByVirtual 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.updateWarehouseByVirtual(pageData);
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
    @PostMapping("/warehouse/warehouseBase/updateWarehousePositionByName")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehousePositionByName() throws Exception {
        logger.info("################/warehouseBase/updateWarehousePositionByName 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.updateWarehousePositionByName(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/updateWarehousePositionByName 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 刪除仓库或货位
     * @author 陈刚
     * @date 2018-10-10
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseBase/deleteWarehouse")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouse() throws Exception {
        logger.info("################/warehouseBase/deleteWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.deleteWarehouse(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/deleteWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库(禁用)状态
     *
     * @author 陈刚
     * @date 2019-11-11
     */
    @PostMapping("/warehouse/warehouseBase/updateDisableWarehouse")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableWarehouse() throws Exception {
        logger.info("################/warehouse/warehouseBase/updateDisableWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseService.updateDisableWarehouse(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseBase/updateDisableWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouse/warehouseBase/exportExcelWarehouse")
    public void exportExcelWarehouse() throws Exception {
        logger.info("################/warehouseBase/exportExcelWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseService.exportExcelWarehouse(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/exportExcelWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-10
    */
    @PostMapping("/warehouse/warehouseBase/importExcelWarehouse")
    public ResultModel importExcelWarehouse(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/warehouseBase/importExcelWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = warehouseService.importExcelWarehouse(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseBase/importExcelWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



