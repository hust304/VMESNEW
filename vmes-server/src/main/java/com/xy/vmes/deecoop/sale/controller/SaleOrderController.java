package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleOrder;
import com.xy.vmes.entity.SaleOrderDetail;
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

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_sale_order:订单表Controller
* @author 陈刚 自动生成
* @date 2018-12-05
*/
@RestController
@Slf4j
public class SaleOrderController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderController.class);

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/listPageSaleOrder")
    public ResultModel listPageSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/listPageSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrder");
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

        //设置查询排序
        pd.put("orderStr", "saleOrder.cdate desc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleOrderService.getDataListPage(pd, pg);
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
        logger.info("################/sale/saleOrder/listPageSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/addSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/addSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());

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

        //获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);

        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(detailList);
        order.setTotalSum(totalSum);

        //discount_sum:折扣金额
        BigDecimal discountSum = BigDecimal.valueOf(0D);
        if (order.getDiscountSum() != null) {
            discountSum = order.getDiscountSum();
        }
        order.setDiscountSum(discountSum);

        //order_sum:订单金额(合计金额 - 折扣金额)
        //四舍五入到2位小数
        BigDecimal orderSum = BigDecimal.valueOf(totalSum.doubleValue() - order.getDiscountSum().doubleValue()).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        order.setOrderSum(orderSum);

        String parentId = Conv.createUuid();
        order.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("0");
        String companyID = pageData.getString("currentCompanyId");
        order.setCompanyId(companyID);
        //订单编号
        //D+yyyyMMdd+00001 = 14位
        String code = coderuleService.createCoderCdateByDate(companyID,
                "vmes_sale_order",
                "yyyyMMdd",
                "D");
        order.setSysCode(code);

        //priceType计价类型(1:先计价 2:后计价)
        //2:后计价 无订单总金额 无订单金额
        if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {
            order.setTotalSum(BigDecimal.valueOf(0D));
            order.setOrderSum(BigDecimal.valueOf(0D));
        }
        saleOrderService.save(order);

        //2.添加订单明细
        saleOrderDetailService.addSaleOrderDetail(order, detailList);

        //3.修改客户余额(vmes_customer.balance)
        //advance_sum:预付款(定金)
        if (order.getAdvanceSum() != null) {
            saleReceiveRecordService.editCustomerBalanceByOrder(order.getCustomerId(), null, order.getAdvanceSum(), order.getCuser());
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/addSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/updateSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/updateSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        SaleOrder order = (SaleOrder)HttpUtils.pageData2Entity(pageData, new SaleOrder());

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

        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = saleOrderService.findSaleOrderById(order.getId());
        if (!"0".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可修改！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //获取订单明细
        List<SaleOrderDetail> detailList = saleOrderDetailService.mapList2OrderDetailListByEdit(mapList, null);

        //total_sum:合计金额
        BigDecimal totalSum = saleOrderDetailService.findTotalSumByDetailList(detailList);
        order.setTotalSum(totalSum);

        //discount_sum:折扣金额
        BigDecimal discountSum = BigDecimal.valueOf(0D);
        if (order.getDiscountSum() != null) {
            discountSum = order.getDiscountSum();
        }
        order.setDiscountSum(discountSum);

        //order_sum:订单金额(合计金额 - 折扣金额)
        //四舍五入到2位小数
        BigDecimal orderSum = BigDecimal.valueOf(totalSum.doubleValue() - order.getDiscountSum().doubleValue()).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        order.setOrderSum(orderSum);

        if (detailList != null && detailList.size() > 0) {
            for (SaleOrderDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
                    //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
                    detail.setState("0");
                    detail.setParentId(order.getId());
                    detail.setCuser(order.getCuser());
                    saleOrderDetailService.save(detail);
                } else {
                    saleOrderDetailService.update(detail);
                }
            }
        }

        //2.修改订单表头
        //2:后计价 无订单总金额 无订单金额
        if (order.getPriceType() != null && "2".equals(order.getPriceType().trim())) {
            order.setTotalSum(BigDecimal.valueOf(0D));
            order.setOrderSum(BigDecimal.valueOf(0D));
        }
        saleOrderService.update(order);

        //3.修改客户余额(vmes_customer.balance)
        //advance_sum:预付款(定金)
        BigDecimal new_advanceSum = BigDecimal.valueOf(0D);
        if (order.getAdvanceSum() != null) {
            new_advanceSum = order.getAdvanceSum();
        }

        BigDecimal old_advanceSum = BigDecimal.valueOf(0D);
        if (order_old.getAdvanceSum() != null) {
            old_advanceSum = order_old.getAdvanceSum();
        }

        if ((new_advanceSum.doubleValue() - old_advanceSum.doubleValue()) != 0D) {
            BigDecimal editBalance = BigDecimal.valueOf(new_advanceSum.doubleValue() - old_advanceSum.doubleValue());
            //四舍五入到2位小数
            editBalance = editBalance.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            saleReceiveRecordService.editCustomerBalanceByOrder(order.getCustomerId(), null, editBalance, order.getCuser());
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/updateSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/deleteSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/deleteSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = saleOrderService.findSaleOrderById(parentId);
        if (!"0".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可删除！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 删除订单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        saleOrderDetailService.deleteByColumnMap(columnMap);

        //3. 删除订单
        saleOrderService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/deleteSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消订单
     * @author 陈刚
     * @date 2018-12-10
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/cancelSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单id为空或空字符串！");
            return model;
        }

        //1. 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        SaleOrder order_old = saleOrderService.findSaleOrderById(parentId);
        if (!"0".equals(order_old.getState())) {
            String msgTemp = "订单状态({0})不可取消！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_SALE_ORDER_STATE.get(order_old.getState()));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        mapDetail.put("state", "-1");
        saleOrderDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleOrder order = new SaleOrder();
        order.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        order.setState("-1");
        saleOrderService.update(order);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交订单
     * @author 陈刚
     * @date 2018-12-11
     * @throws Exception
     */
    @PostMapping("/sale/saleOrder/submitSaleOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitSaleOrder() throws Exception {
        logger.info("################/sale/saleOrder/cancelSaleOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String orderJsonStr = pageData.getString("orderJsonStr");
        if (orderJsonStr == null || orderJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(orderJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单Json字符串-转换成List错误！");
            return model;
        }

        //获取订单
        String ids = "";
        List<SaleOrder> orderList = saleOrderService.mapList2OrderList(mapList, null);
        for (SaleOrder order : orderList) {
            if (order.getId() != null && order.getId().trim().length() > 0) {
                ids = ids + order.getId().trim() + ",";
            }
        }
        ids = StringUtil.stringTrimSpace(ids);

        //1. 订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        saleOrderService.updateStateByOrder("1", ids);

        //2. 订单明细状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        saleOrderDetailService.updateStateByDetail("1", ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/submitSaleOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/exportExcelSaleOrders")
    public void exportExcelSaleOrders() throws Exception {
        logger.info("################/sale/saleOrder/exportExcelSaleOrders 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("saleOrder");
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
        List<Map> dataList = saleOrderService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleOrder";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrder/exportExcelSaleOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-05
    */
    @PostMapping("/sale/saleOrder/importExcelSaleOrders")
    public ResultModel importExcelSaleOrders(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleOrder/importExcelSaleOrders 执行开始 ################# ");
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
        logger.info("################/sale/saleOrder/importExcelSaleOrders 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



