package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
import java.math.BigDecimal;
import java.util.*;



/**
* 说明：vmes_sale_deliver:发货表Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverController {

    private Logger logger = LoggerFactory.getLogger(SaleDeliverController.class);

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;


    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliver/listPageSaleDeliver")
    public ResultModel listPageSaleDeliver() throws Exception {
        logger.info("################saleDeliver/listPageSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleDeliver");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
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

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleDeliverService.getDataListPage(pd,pg);
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
        logger.info("################saleDeliver/listPageSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/saleDeliver/addSaleDeliver")
    @Transactional
    public ResultModel addSaleDeliver() throws Exception {
        logger.info("################saleDeliver/addSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //验证勾选的订单明细(客户)是否相同
        String msgStr = saleDeliverService.checkCustomerByOrderDetailList(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String customerId = mapList.get(0).get("customerId");
        String customerName = mapList.get(0).get("customerName");

        //获取订单明细
        //1. 本次发货数量(计价单位)
        //2. 公式:P(计价单位) 转换 N(计量单位)
        //3. count:订购数量(计价数量) -- 本次发货数量(计价单位)
        //   productCount:货品数量(计量数量) --本次发货数量(计量单位)
        List<SaleOrderDetailEntity> orderDtlList = saleDeliverDetailService.mapList2OrderDetailList(mapList, null);

        //1. 创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(customerId,
                customerName,
                cuser,
                companyId,
                Common.DICTIONARY_MAP.get("saleOut"));

        //获取实体仓库id
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("layer", "2");
        findMap.put("isEntity", "true");
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);
        warehouseOut.setWarehouseId(warehouseList.get(0).getId());
        warehouseOutService.save(warehouseOut);

        List<WarehouseOutDetail> outDtlList = saleOrderDetailService.orderDtlList2OutDtlList(orderDtlList, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, outDtlList);
        //订单明细id --> 出库明细id -- <订单明细id, 出库明细id>Map
        Map<String, String> orderDtl2OutDtlMap = new HashMap<String, String>();
        for (WarehouseOutDetail outDtl : outDtlList) {
            orderDtl2OutDtlMap.put(outDtl.getBusinessId(), outDtl.getId());
        }

        //2. 创建发货单
        SaleDeliver saleDeliver = new SaleDeliver();
        //发货单编号
        String code = coderuleService.createCoder(companyId, "vmes_sale_deliver", "F");
        saleDeliver.setDeliverCode(code);
        saleDeliver.setCustomerId(customerId);
        saleDeliver.setCompanyId(companyId);
        //state:状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("0");
        saleDeliver.setMakeId(cuser);
        saleDeliver.setCuser(cuser);
        saleDeliverService.save(saleDeliver);

        List<SaleDeliverDetail> deliverDtlList = saleOrderDetailService.orderDtlList2DeliverDtllList(orderDtlList, null);
        saleDeliverDetailService.addDeliverDetail(saleDeliver, deliverDtlList, orderDtl2OutDtlMap);

        //3. 反写订单明细
        //订单明细id --> 发货明细id -- <订单明细id, 发货明细id>Map
        Map<String, String> orderDtl2DeliverDtlMap = new HashMap<String, String>();
        for (SaleDeliverDetail deliverDtl : deliverDtlList) {
            orderDtl2DeliverDtlMap.put(deliverDtl.getOrderDetaiId(), deliverDtl.getId());
        }

        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            String orderDtl_id = orderDtl.getId();
            if (orderDtl2DeliverDtlMap.get(orderDtl_id) != null) {
                SaleOrderDetail orderDetail = new SaleOrderDetail();
                orderDetail.setId(orderDtl_id);
                //发货明细ID
                //orderDetail.setDeliverDetailId(orderDtl2DeliverDtlMap.get(orderDtl_id));
                //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
                orderDetail.setState("3");
                saleOrderDetailService.update(orderDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliver/addSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货类型)-发货完成
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/saleDeliver/updateSaleDeliverByDeliverType")
    @Transactional
    public ResultModel updateSaleDeliverByDeliverType() throws Exception {
        logger.info("################saleDeliver/updateSaleDeliverByDeliverType 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        //1. 验证当前出库单id-对应的出库明细状态(是否全部完成出库)
        try {
            Boolean isAllOut = saleDeliverDetailService.checkIsAllOutByDeliverId(deliverId);
            if (isAllOut != null && !isAllOut.booleanValue()) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("当前发货明细对应的出库明细状态(待派单,执行中,已取消)，必须全部出库完成，！");
                return model;
            }
        } catch (ApplicationException e) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(e.getMessage());
            return model;
        }

        SaleDeliver saleDeliver = (SaleDeliver)HttpUtils.pageData2Entity(pageData, new SaleDeliver());
        saleDeliver.setId(deliverId);
        //状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("1");
        saleDeliverService.update(saleDeliver);

        //状态(0:待发货 1:已发货 -1:已取消)
        saleDeliverDetailService.updateStateByDetail("1", deliverId);

//        //获取订单id的发货金额 Map<订单id, 发货金额>
//        Map<String, BigDecimal> orderDeliverSumMap = saleDeliverDetailService.findOrderDeliverSumByDeliverId(deliverId, null);
//        if (orderDeliverSumMap != null && orderDeliverSumMap.size() > 0) {
//            for (Iterator iterator = orderDeliverSumMap.keySet().iterator(); iterator.hasNext();) {
//                String mapKey = (String)iterator.next();
//                BigDecimal deliverSum = orderDeliverSumMap.get(mapKey);
//
//                SaleOrder order = new SaleOrder();
//                order.setId(mapKey);
//                order.setDeliverSum(deliverSum);
//                saleOrderService.update(order);
//            }
//        }

        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliver/updateSaleDeliverByDeliverType 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消发货单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/saleDeliver/cancelSaleDeliver")
    @Transactional
    public ResultModel cancelSaleDeliver() throws Exception {
        logger.info("################saleDeliver/cancelSaleDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String deliverId = pageData.getString("id");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        //状态(0:待发货 1:已发货 -1:已取消)
        SaleDeliver saleDeliver = saleDeliverService.findSaleDeliverById(deliverId);
        if ("1".equals(saleDeliver.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前发货单状态(已发货)，不可取消发货单！");
            return model;
        }

        //验证发货单是否允许取消
        //出库单明细状态(状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        String msgStr = saleDeliverDetailService.checkOutDetailStateByCancelDeliver(deliverId);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //1. 取消出库单
        String outParentIds = saleDeliverDetailService.findOutIdsByDeliverId(deliverId);
        if (outParentIds != null && outParentIds.trim().length() > 0) {
            //取消出库单状态(0:未完成 1:已完成 -1:已取消)
            warehouseOutService.updateStateByOut("-1", outParentIds);

            //取消出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            warehouseOutDetailService.updateStateByDetail("-1", outParentIds);
        }

        //2. 清除订单明细与发货明细的关联关系
        saleDeliverDetailService.updateOrderDetailByCancelDeliver(deliverId);

        //取消发货单
        //状态(0:待发货 1:已发货 -1:已取消)
        saleDeliver.setState("-1");
        saleDeliverService.update(saleDeliver);

        //发货明细状态(0:待发货 1:已发货 -1:已取消)
        saleDeliverDetailService.updateStateByDetail("-1", deliverId);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliver/cancelSaleDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliver/exportExcelSaleDelivers")
    public void exportExcelSaleDelivers() throws Exception {
        logger.info("################saleDeliver/exportExcelSaleDelivers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("saleDeliver");
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
        List<Map> dataList = saleDeliverService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleDeliver";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliver/exportExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliver/importExcelSaleDelivers")
    public ResultModel importExcelSaleDelivers(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################saleDeliver/importExcelSaleDelivers 执行开始 ################# ");
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
        logger.info("################saleDeliver/importExcelSaleDelivers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



