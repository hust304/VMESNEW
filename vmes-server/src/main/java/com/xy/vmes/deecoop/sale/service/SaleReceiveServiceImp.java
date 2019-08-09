package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：收款单 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-01-10
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveServiceImp implements SaleReceiveService {


    @Autowired
    private SaleReceiveMapper saleReceiveMapper;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SaleOrderService saleOrderService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void save(SaleReceive saleReceive) throws Exception{
        saleReceive.setId(Conv.createUuid());
        saleReceive.setCdate(new Date());
        saleReceive.setUdate(new Date());
        saleReceiveMapper.insert(saleReceive);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void update(SaleReceive saleReceive) throws Exception{
        saleReceive.setUdate(new Date());
        saleReceiveMapper.updateById(saleReceive);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateAll(SaleReceive saleReceive) throws Exception{
        saleReceive.setUdate(new Date());
        saleReceiveMapper.updateAllColumnById(saleReceive);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    //@Cacheable(cacheNames = "saleReceive", key = "''+#id")
    public SaleReceive selectById(String id) throws Exception{
        return saleReceiveMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceive> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceive> dataList(PageData pd) throws Exception{
        return saleReceiveMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceive> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceive> saleReceiveList =  saleReceiveMapper.selectByMap(columnMap);
        return saleReceiveList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByReceive(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        saleReceiveMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<SaleReceive> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceive>();
        }

        return this.dataList(pageData);
    }

    @Override
    public ResultModel saveSaleReceiveAndDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String dtlJsonStr = pd.getString("dtlJsonStr");

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加一条分摊明细数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }
        String customerId = pd.getString("id");
//        BigDecimal addBalance = BigDecimal.valueOf(Double.parseDouble(pd.getString("addBalance")));
        BigDecimal currentBalance = BigDecimal.valueOf(Double.parseDouble(pd.getString("currentBalance")));
        BigDecimal detailBalance = BigDecimal.ZERO;

        if(mapList!=null&&mapList.size()>0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> detailMap = mapList.get(i);
                detailBalance = detailBalance.add(BigDecimal.valueOf(Double.parseDouble(detailMap.get("receiveAmount"))));
            }
        }

        if(detailBalance.compareTo(currentBalance)>0){
            model.putCode("1");
            model.putMsg("分摊明细总额必须小于等于可分摊总额！");
            return model;
        }


//        Customer oldCustomer = customerService.selectById(customerId);
//        if(addBalance.compareTo(BigDecimal.ZERO)>0){
//            String remark = "录入收款："+ oldCustomer.getBalance().add(addBalance).subtract(oldCustomer.getBalance()).setScale(2, BigDecimal.ROUND_HALF_UP);
//            //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
//            customerService.updateCustomerBalance(
//                    oldCustomer,
//                    oldCustomer.getBalance().add(addBalance),
//                    pd.getString("uuser"),
//                    "1",
//                    remark);
//        }


        SaleReceive saleReceive = new SaleReceive();
        String id = Conv.createUuid();
        String companyID = pd.getString("currentCompanyId");
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_sale_receive", "R");
        saleReceive.setId(id);
        saleReceive.setCode(code);
        saleReceive.setType("1");//收款类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
        saleReceive.setCustomerId(customerId);
        saleReceive.setReceiveSum(detailBalance);
        saleReceive.setCompanyId(companyID);
        saleReceive.setUuser(pd.getString("cuser"));
        saleReceive.setCuser(pd.getString("cuser"));
        this.save(saleReceive);

        StringBuffer orderIdsBuf = new StringBuffer();
        Map<String, String> orderIdMap = new HashMap<String, String>();
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                SaleReceiveDetail detail = new SaleReceiveDetail();
                detail.setParentId(saleReceive.getId());
                String orderId = detailMap.get("id");
                detail.setOrderId(orderId);
                orderIdsBuf.append(orderId).append(",");
                orderIdMap.put(orderId, orderId);
                detail.setDiscountAmount(BigDecimal.valueOf(Double.parseDouble(detailMap.get("discountAmount"))));
                detail.setReceiveAmount(BigDecimal.valueOf(Double.parseDouble(detailMap.get("receiveAmount"))));
                //收款单状态(0:待收款 1:已收款 -1:已取消)
                detail.setState("0");
                detail.setUuser(pd.getString("cuser"));
                detail.setCuser(pd.getString("cuser"));
                saleReceiveDetailService.save(detail);
            }
        }

//        Customer oldCustomer = customerService.selectById(customerId);
//        //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
//        String remark_1 = "费用分摊：" + oldCustomer.getBalance().subtract(detailBalance).setScale(2, BigDecimal.ROUND_HALF_UP);
//        saleOrderService.updateCustomerBalance(
//                oldCustomer,
//                oldCustomer.getBalance().subtract(detailBalance),
//                pd.getString("uuser"),
//                "-1",
//                remark_1);


//        //查询付款单明细 vmes_sale_receive_detail
//        //收款明细状态(0:待收款 1:已收款 -1:已取消)
//        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderIdsBuf.toString(), "1");

//        //反写订单状态
//        if (orderIdMap.size() > 0) {
//            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext(); ) {
//                String orderId = (String) iterator.next();
//                if (orderReceiveMap.get(orderId) != null) {
//                    Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);
//                    SaleOrder saleOrder = saleOrderService.findSaleOrderById(orderId);
//                    //订单id-订单已完成付款金额
//                    BigDecimal receiveSum = BigDecimal.valueOf(0D);
//                    if (receiveMap.get("receiveSum") != null) {
//                        receiveSum = receiveMap.get("receiveSum");
//                    }
//                    BigDecimal orderSum = saleOrder.getOrderSum();
//                    if (receiveSum.doubleValue() >= orderSum.doubleValue()) {
//                        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//                        if("3".equals(saleOrder.getState())){
//                            saleOrder.setState("4");
//                            saleOrder.setPayDate(new Date());
//                            saleOrderService.update(saleOrder);
//                        }
//                    }
//                }
//            }
//        }

        return model;
    }

    @Override
    public ResultModel listPageSaleReceives(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("SaleReceive");
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
        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    public ResultModel auditPassSaleReceive(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pd.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("收款单id为空或空字符串！");
            return model;
        }
        String cuser = pd.getString("cuser");


        //1.获取收款单对象 (收款单id)
        SaleReceive saleReceive = this.selectById(parentId);
        //receiveSum 收款单总额
        BigDecimal receiveSum = saleReceive.getReceiveSum();

        String customerId = saleReceive.getCustomerId();
        Customer oldCustomer = customerService.selectById(customerId);
        //操作类型 (0:变更 1:录入收款 2:预付款 -1:费用分摊)
        String remark_1 = "费用分摊：" + oldCustomer.getBalance().subtract(receiveSum).setScale(2, BigDecimal.ROUND_HALF_UP);
        saleOrderService.updateCustomerBalance(
                oldCustomer,
                oldCustomer.getBalance().subtract(receiveSum),
                cuser,
                "-1",
                remark_1);

        //2.获取收款明细
        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        //state 收款单明细状态:(0:待收款(待审核) 1:已收款 -1:已取消)
        findMap.put("state", "0");
        List<SaleReceiveDetail> detailList = saleReceiveDetailService.findSaleReceiveDetailList(findMap);

        //3.反写订单状态
        //获取采购订单id-通过遍历收款明细
        StringBuffer orderIdsBuf = new StringBuffer();
        Map<String, String> orderIdMap = new HashMap<String, String>();
        if (detailList != null && detailList.size() > 0) {
            for (SaleReceiveDetail detail : detailList) {
                String orderId = detail.getOrderId();
                if (orderId != null && orderId.trim().length() > 0) {
                    orderIdsBuf.append(orderId.trim()).append(",");
                    orderIdMap.put(orderId.trim(), orderId.trim());
                }
            }
        }
        //查询付款单明细 vmes_sale_receive_detail
        //收款明细状态(0:待收款 1:已收款 -1:已取消)
        Map<String, Map<String, BigDecimal>> orderReceiveMap = saleReceiveDetailService.findMapOrderReceiveByOrderId(orderIdsBuf.toString(), "1");

        if (orderIdMap.size() > 0) {
            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext(); ) {
                String orderId = (String) iterator.next();
                if (orderReceiveMap.get(orderId) != null) {
                    Map<String, BigDecimal> receiveMap = orderReceiveMap.get(orderId);
                    SaleOrder saleOrder = saleOrderService.findSaleOrderById(orderId);
                    //订单id-订单已完成付款金额
                    BigDecimal receiveSumByOrder = BigDecimal.valueOf(0D);
                    if (receiveMap.get("receiveSum") != null) {
                        receiveSumByOrder = receiveMap.get("receiveSum");
                    }
                    BigDecimal orderSum = saleOrder.getOrderSum();
                    if (receiveSumByOrder.doubleValue() >= orderSum.doubleValue()) {
                        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
                        if("3".equals(saleOrder.getState())){
                            saleOrder.setState("4");
                            saleOrder.setPayDate(new Date());
                            saleOrderService.update(saleOrder);
                        }
                    }
                }
            }
        }

        //4. 修改收款单明细状态
        if (detailList != null && detailList.size() > 0) {
            for (SaleReceiveDetail detail : detailList) {
                SaleReceiveDetail editDetail = new SaleReceiveDetail();

                String id = detail.getId();
                editDetail.setId(id);

                //收款单明细状态:(0:待收款(待审核) 1:已收款 -1:已取消)
                editDetail.setState("1");

                saleReceiveDetailService.update(editDetail);
            }
        }

        //5.修改审核状态
        //auditResult 审核结果(0:未通过 1:已通过)
        saleReceive.setAuditResult("1");
        //auditUserId 审核人ID
        saleReceive.setAuditUserId(cuser);
        this.update(saleReceive);

        return model;
    }

//    @Override
//    public void exportExcelSaleReceives(PageData pd, Pagination pg) throws Exception {
//        List<Column> columnList = columnService.findColumnList("SaleReceive");
//        if (columnList == null || columnList.size() == 0) {
//            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
//        }
//
//        //根据查询条件获取业务数据List
//        String ids = (String)pd.getString("ids");
//        String queryStr = "";
//        if (ids != null && ids.trim().length() > 0) {
//            ids = StringUtil.stringTrimSpace(ids);
//            ids = "'" + ids.replace(",", "','") + "'";
//            queryStr = "id in (" + ids + ")";
//        }
//        pd.put("queryStr", queryStr);
//
//        pg.setSize(100000);
//        List<Map> dataList = this.getDataListPage(pd, pg);
//
//        //查询数据转换成Excel导出数据
//        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
//        HttpServletResponse response = HttpUtils.currentResponse();
//
//        //查询数据-Excel文件导出
//        String fileName = pd.getString("fileName");
//        if (fileName == null || fileName.trim().length() == 0) {
//            fileName = "ExcelSaleReceive";
//        }
//
//        //导出文件名-中文转码
//        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
//        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
//    }

//    @Override
//    public ResultModel importExcelSaleReceives(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//        //HttpServletRequest Request = HttpUtils.currentRequest();
//
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//        return model;
//    }

    public SaleReceive createReceive(String customerId, String cuser, String companyID, String receiveType) {
        SaleReceive receive = new SaleReceive();
        //收款单编号
        String code = coderuleService.createCoder(companyID, "vmes_sale_receive", "R");
        receive.setCode(code);

        receive.setCustomerId(customerId);
        receive.setCompanyId(companyID);
        //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
        receive.setType(receiveType);
        receive.setCuser(cuser);

        return receive;
    }
}

