package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.sale.dao.SaleAnalysisMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.FinanceBillService;
import com.xy.vmes.service.SaleAnalysisService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 46368 on 2020/4/8.
 */
@Service
@Transactional(readOnly = false)
public class SaleAnalysisServiceImp implements SaleAnalysisService {

    @Autowired
    private SaleAnalysisMapper saleAnalysisMapper;

    @Autowired
    private FinanceBillService financeBillService;

    @Autowired
    private ColumnService columnService;

    @Override
    public ResultModel syntheticalQuery(PageData pd) throws Exception {

        ResultModel model = new ResultModel();
        Map result = new HashMap();

        String currentYearMonth = DateFormat.getCurrentYearMonth();
        String lastYearMonth = DateFormat.getLastYearMonth(currentYearMonth);
        String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
        String currentYear = DateFormat.getCurrentYear();
        String lastYear = DateFormat.getLastYear(currentYear);
        String nextYear = DateFormat.getNextYear(currentYear);
        String startYearMonth_YearOnYear = DateFormat.getStartYearMonth_YearOnYear(currentYearMonth);
        String endYearMonth_YearOnYear = DateFormat.getEndYearMonth_YearOnYear(currentYearMonth);



        pd.put("startDate",lastYearMonth);
        pd.put("endDate",currentYearMonth);
        Map lastMonthSalesMap = getSalesVolumeNumber(pd);
        result.put("salesVolumeLastMonth",lastMonthSalesMap.get("volume"));
        result.put("salesNumberLastMonth",lastMonthSalesMap.get("number"));

        pd.put("startDate",startYearMonth_YearOnYear);
        pd.put("endDate",endYearMonth_YearOnYear);
        Map yearOnYearSalesMap = getSalesVolumeNumber(pd);
        result.put("salesVolumeYearOnYear",yearOnYearSalesMap.get("volume"));
        result.put("salesNumberYearOnYear",yearOnYearSalesMap.get("number"));

        pd.put("startDate",currentYear);
        pd.put("endDate",nextYear);
        Map currentYearSalesMap = getSalesVolumeNumber(pd);
        result.put("salesVolumeYear",currentYearSalesMap.get("volume"));
        result.put("salesNumberYear",currentYearSalesMap.get("number"));

        pd.put("startDate",lastYear);
        pd.put("endDate",currentYear);
        Map lastYearSalesMap = getSalesVolumeNumber(pd);
        result.put("salesVolumeLastYear",lastYearSalesMap.get("volume"));
        result.put("salesNumberLastYear",lastYearSalesMap.get("number"));



        pd.put("startDate",currentYearMonth);
        pd.put("endDate",nextYearMonth);
        Map currentMonthSalesMap = getSalesVolumeNumber(pd);
        result.put("salesVolumeMonth",currentMonthSalesMap.get("volume"));
        result.put("salesNumberMonth",currentMonthSalesMap.get("number"));


        Map salesOrderNumberMap = getSalesOrderNumber(pd);
        result.put("orderNumberMonth",salesOrderNumberMap.get("allNum"));
        result.put("orderNumberPending",salesOrderNumberMap.get("undoNum"));


        Map accountsReceivableMap = getAccountsReceivable(pd);
        result.put("accountsReceivable",accountsReceivableMap.get("accountsReceivable"));
        result.put("accountsReceivableMonth",accountsReceivableMap.get("accountsReceivableMonth"));

        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel salesTrendQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> result = new ArrayList<>();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            String startYearMonth_YearOnYear = DateFormat.getStartYearMonth_YearOnYear(currentYearMonth);
            pd.put("startDate",startYearMonth_YearOnYear);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<String> yearMonthList = DateFormat.getAllYearMonth(pd.getString("startDate"),pd.getString("endDate"));

        List<Map> salesTrendList = saleAnalysisMapper.getSalesTrend(pd);


        if(yearMonthList!=null&&yearMonthList.size()>0){
            for(String yearMonth : yearMonthList){

                Map resultMap = new HashMap();
                resultMap.put("month",yearMonth);
                resultMap.put("salesVolume","0.00");
                resultMap.put("salesNumber","0.00");

                if(salesTrendList!=null&&salesTrendList.size()>0){
                    for(Map salesTrend : salesTrendList){
                        String month = salesTrend.get("month")!=null?(String)salesTrend.get("month"):"";
                        if(month.equals(yearMonth)){
                            resultMap.put("salesVolume",salesTrend.get("volume"));
                            resultMap.put("salesNumber",salesTrend.get("number"));
                        }
                    }
                }
                result.add(resultMap);
            }
        }


        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel salesVolumeByProductQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            pd.put("startDate",currentYearMonth);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<Map> salesVolumeByProductList = getSalesVolumeNumberByProduct(pd,"volume");

        model.putResult(salesVolumeByProductList);

        return model;
    }

    @Override
    public ResultModel salesNumberByProductQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            pd.put("startDate",currentYearMonth);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<Map> salesVolumeByProductList = getSalesVolumeNumberByProduct(pd,"number");

        model.putResult(salesVolumeByProductList);

        return model;
    }

    @Override
    public ResultModel productReturnRateQuery(PageData pd)  throws Exception{
        ResultModel model = new ResultModel();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            pd.put("startDate",currentYearMonth);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<Map> productReturnRateList = getProductReturnRate(pd);

        model.putResult(productReturnRateList);

        return model;
    }

    @Override
    public ResultModel salesVolumeByCustomerQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            pd.put("startDate",currentYearMonth);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<Map> salesVolumeByCustomerList = getSalesVolumeByCustomer(pd);

        model.putResult(salesVolumeByCustomerList);

        return model;
    }

    @Override
    public ResultModel salesByEmployeeQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            pd.put("startDate",currentYearMonth);
            pd.put("endDate",nextYearMonth);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        pd.put("orderStr"," sum(ifnull(saleOrderDetail.product_price*saleOrderDetail.order_count,0)) desc");
        List<Map> salesByEmployeeList = saleAnalysisMapper.getSalesByEmployee(pd);

        model.putResult(salesByEmployeeList);

        return model;
    }

    @Override
    public ResultModel salesTrendByEmployeeQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> result = new ArrayList<>();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            String currentYearMonth = DateFormat.getCurrentYearMonth();
            String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
            String startYearMonth_YearOnYear = DateFormat.getStartYearMonth_YearOnYear(currentYearMonth);
            pd.put("startDate",startYearMonth_YearOnYear);
            pd.put("endDate",nextYearMonth);
        }else{

            String nextYearMonth = DateFormat.getNextYearMonth(endDate);
            pd.put("endDate",nextYearMonth);
        }

        List<String> yearMonthList = DateFormat.getAllYearMonth(pd.getString("startDate"),pd.getString("endDate"));

        List<Map> salesTrendByEmployeeList = saleAnalysisMapper.getSalesTrendByEmployee(pd);


        if(salesTrendByEmployeeList!=null&&salesTrendByEmployeeList.size()>0) {
            Set<String> idSet = new HashSet<>();
            for (Map salesTrend : salesTrendByEmployeeList) {
                String salesTrendId = (String)salesTrend.get("id");
                idSet.add(salesTrendId);
            }

            for(String id : idSet){
                Map resultMap = new HashMap();
                List seriesData = new ArrayList<>();
                List<Map> volumeMonthData = new ArrayList<>();
                resultMap.put("id",id);
                resultMap.put("name",null);
                resultMap.put("monthData",yearMonthList);
                resultMap.put("seriesData",seriesData);
                resultMap.put("volumeMonthData",volumeMonthData);


                List<Map> volumeMonthList = new ArrayList<>();
                for (Map salesTrend : salesTrendByEmployeeList) {
                    String salesTrendId = (String)salesTrend.get("id");
                    if(id.equals(salesTrendId)){
                        resultMap.put("name",salesTrend.get("name"));
                        volumeMonthList.add(salesTrend);
                    }
                }

                if(yearMonthList!=null&&yearMonthList.size()>0) {
                    for (String yearMonth : yearMonthList) {
                        Map volumeMonthMap = new HashMap();
                        volumeMonthMap.put("month",yearMonth);
                        volumeMonthMap.put("salesVolume","0.00");


                        for(Map volumeMonth : volumeMonthList){
                            String month = volumeMonth.get("month")!=null?(String)volumeMonth.get("month"):"";
                            if(month.equals(yearMonth)){
                                volumeMonthMap.put("salesVolume",volumeMonth.get("salesVolume"));
                            }
                        }

                        volumeMonthData.add(volumeMonthMap);
                    }
                }


                for(Map volumeMonth : volumeMonthData){
                    seriesData.add(volumeMonth.get("salesVolume"));
                }


                result.add(resultMap);


            }
        }


        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel accountsReceivableQuery(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> result = new LinkedList();
        pd.put("genre","df7cb67fca4148bc9632c908e4a7fdea");
        pd.put("orderStr"," case when nowPlus-nowMinus+beginPlus-beginMinus>0 then round(ifnull(nowPlus-nowMinus+beginPlus-beginMinus,0),2) else 0.00 end desc ");
        List<Map>  receiveMapList = financeBillService.getFinanceReceiveView(pd,null);
        if(receiveMapList!=null&&receiveMapList.size()>0){
            BigDecimal endPlusTotal = BigDecimal.ZERO;
            for(Map receiveMap : receiveMapList){
                Map newReceiveMap = new HashMap();
                newReceiveMap.put("id",receiveMap.get("id"));
                newReceiveMap.put("name",receiveMap.get("name"));
                newReceiveMap.put("endPlus",receiveMap.get("endPlus"));
                newReceiveMap.put("proportion","0.00");
                BigDecimal endPlus = receiveMap.get("endPlus")!=null?(BigDecimal)receiveMap.get("endPlus"):BigDecimal.ZERO;
                endPlusTotal = endPlusTotal.add(endPlus);

                result.add(newReceiveMap);
            }

            if(endPlusTotal.compareTo(BigDecimal.ZERO)>0){
                for(Map elem : result){
                    BigDecimal endPlus = elem.get("endPlus")!=null?(BigDecimal)elem.get("endPlus"):BigDecimal.ZERO;
                    elem.put("proportion",endPlus.multiply(BigDecimal.valueOf(100)).divide(endPlusTotal,2,BigDecimal.ROUND_HALF_UP));
                    elem.put("endPlusTotal",endPlusTotal.setScale(2,BigDecimal.ROUND_HALF_UP));
                }
            }

        }

        model.putResult(result);
        return model;
    }


    private List<Map> getSalesVolumeByCustomer(PageData pd) {
        pd.put("orderStr"," sum(ifnull(saleOrderDetail.product_price*saleOrderDetail.order_count,0)) desc");
        List<Map> salesVolumeByCustomerList = saleAnalysisMapper.getSalesVolumeNumberByCustomer(pd);
        BigDecimal volumeTotal = BigDecimal.ZERO;
        if(salesVolumeByCustomerList!=null&&salesVolumeByCustomerList.size()>0){
            for(Map svbc : salesVolumeByCustomerList){
                BigDecimal volume = svbc.get("volume")!=null?(BigDecimal)svbc.get("volume"):BigDecimal.ZERO;
                volumeTotal = volumeTotal.add(volume);
            }

            if(volumeTotal.compareTo(BigDecimal.ZERO)>0){
                for(Map svbc : salesVolumeByCustomerList){
//                    String volumeStr = (String)svbc.get("volume");
//                    BigDecimal volume = BigDecimal.valueOf(Double.parseDouble(volumeStr));
                    BigDecimal volume = svbc.get("volume")!=null?(BigDecimal)svbc.get("volume"):BigDecimal.ZERO;
                    svbc.put("proportion",volume.multiply(BigDecimal.valueOf(100)).divide(volumeTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return  salesVolumeByCustomerList!=null?salesVolumeByCustomerList:new ArrayList();
    }

    private List<Map> getProductReturnRate(PageData pd) {
        pd.put("orderStr"," sum(ifnull(retreatDetail.order_count,0)) desc");
        List<Map> productReturnRateList = saleAnalysisMapper.getProductReturnRate(pd);
        BigDecimal numberTotal = BigDecimal.ZERO;
        if(productReturnRateList!=null&&productReturnRateList.size()>0){
            for(Map prr : productReturnRateList){
//                String numberStr = (String)prr.get("number");
//                BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numberStr));
                BigDecimal number = prr.get("number")!=null?(BigDecimal)prr.get("number"):BigDecimal.ZERO;
                numberTotal = numberTotal.add(number);
            }

            if(numberTotal.compareTo(BigDecimal.ZERO)>0){
                for(Map prr : productReturnRateList){
//                    String numberStr = (String)prr.get("number");
//                    BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numberStr));
                    BigDecimal number = prr.get("number")!=null?(BigDecimal)prr.get("number"):BigDecimal.ZERO;
                    prr.put("proportion",number.multiply(BigDecimal.valueOf(100)).divide(numberTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return productReturnRateList!=null?productReturnRateList:new ArrayList();
    }

    private List<Map> getSalesVolumeNumberByProduct(PageData pd, String type) {

        if("volume".equals(type)){
            pd.put("orderStr","sum(ifnull(saleOrderDetail.product_price*saleOrderDetail.order_count,0)) desc");
        }else{
            pd.put("orderStr"," sum(ifnull(saleOrderDetail.order_count,0)) desc");
        }

        List<Map> salesVolumeNumberByProductList = saleAnalysisMapper.getSalesVolumeNumberByProduct(pd);

        calculateProportion(salesVolumeNumberByProductList,type);

        return  salesVolumeNumberByProductList!=null?salesVolumeNumberByProductList:new ArrayList();

    }

    private void calculateProportion(List<Map> varList, String type) {
        BigDecimal volumeTotal = BigDecimal.ZERO;
        BigDecimal numberTotal = BigDecimal.ZERO;
        if(varList!=null&&varList.size()>0){
            for(Map vnp : varList){
                BigDecimal number = vnp.get("number")!=null?(BigDecimal)vnp.get("number"):BigDecimal.ZERO;
                BigDecimal volume = vnp.get("volume")!=null?(BigDecimal)vnp.get("volume"):BigDecimal.ZERO;
                volumeTotal = volumeTotal.add(volume);
                numberTotal = numberTotal.add(number);
            }
            if(volumeTotal.compareTo(BigDecimal.ZERO)>0&&"volume".equals(type)){
                for(Map vnp : varList){
                    BigDecimal volume = vnp.get("volume")!=null?(BigDecimal)vnp.get("volume"):BigDecimal.ZERO;
                    vnp.put("proportion",volume.multiply(BigDecimal.valueOf(100)).divide(volumeTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }else if(numberTotal.compareTo(BigDecimal.ZERO)>0&&"number".equals(type)){
                for(Map vnp : varList){
                    BigDecimal number = vnp.get("number")!=null?(BigDecimal)vnp.get("number"):BigDecimal.ZERO;
                    vnp.put("proportion",number.multiply(BigDecimal.valueOf(100)).divide(numberTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }
    }


    private List<Map> getSalesVolumeNumberByCustomer(PageData pd, String type) {
        if("volume".equals(type)){
            pd.put("orderStr","sum(ifnull(saleOrderDetail.product_price*saleOrderDetail.order_count,0)) desc");
        }else{
            pd.put("orderStr"," sum(ifnull(saleOrderDetail.order_count,0)) desc");
        }

        List<Map> salesVolumeByCustomerList = saleAnalysisMapper.getSalesVolumeNumberByCustomer(pd);
        calculateProportion(salesVolumeByCustomerList,type);

        return  salesVolumeByCustomerList!=null?salesVolumeByCustomerList:new ArrayList();
    }

    private List<Map> getSalesVolumeNumberByEmployee(PageData pd, String type) {
        if("volume".equals(type)){
            pd.put("orderStr","sum(ifnull(saleOrderDetail.product_price*saleOrderDetail.order_count,0)) desc");
        }else{
            pd.put("orderStr"," sum(ifnull(saleOrderDetail.order_count,0)) desc");
        }

        List<Map> salesVolumeByEmployeeList = saleAnalysisMapper.getSalesVolumeNumberByEmployee(pd);
        calculateProportion(salesVolumeByEmployeeList,type);

        return  salesVolumeByEmployeeList!=null?salesVolumeByEmployeeList:new ArrayList();
    }




    private Map getAccountsReceivable(PageData pd) throws Exception {
        Map result = new HashMap();
        pd.put("genre","df7cb67fca4148bc9632c908e4a7fdea");
        Map<String,Object> receiveMap = financeBillService.getFinanceReceiveGroup(pd);

        result.put("accountsReceivable",receiveMap.get("nowReceiveAmount"));
        result.put("accountsReceivableMonth",receiveMap.get("currentMonthReceiveAmount"));


        return result;
    }

    private Map getSalesOrderNumber(PageData pd) {
        List<Map>  result = saleAnalysisMapper.getSalesOrderNumber(pd);
        if(result!=null&&result.size()>0){
            return result.get(0)!=null?result.get(0):new HashMap();
        }else{
            return new HashMap();
        }
    }

    private Map getSalesVolumeNumber(PageData pd) {
        List<Map>  result = saleAnalysisMapper.getSalesVolumeNumber(pd);
        if(result!=null&&result.size()>0){
            return result.get(0)!=null?result.get(0):new HashMap();
        }else{
            return new HashMap();
        }
    }


    @Override
    public ResultModel salesTrendQueryByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("salesTrendQueryByDMY");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }


        List<String> yearMonthDayList =  initPageDataByDMY(pd);

        List<Map> salesTrendList = saleAnalysisMapper.getSalesTrendQueryByDMY(pd);

        List<Map> varList = new ArrayList<>();
        if(yearMonthDayList!=null&&yearMonthDayList.size()>0){
            for(String yearMonthDay : yearMonthDayList){

                Map elementMap = new HashMap();
                elementMap.put("id",UUID.randomUUID());
                elementMap.put("date",yearMonthDay);
                elementMap.put("salesVolume","0.00");
                elementMap.put("salesNumber","0.00");
                elementMap.put("ordersNum","0");

                if(salesTrendList!=null&&salesTrendList.size()>0){
                    for(Map salesTrend : salesTrendList){
                        String date = salesTrend.get("date")!=null?(String)salesTrend.get("date"):"";
                        if(date.equals(yearMonthDay)){
                            elementMap.put("salesVolume",salesTrend.get("salesVolume"));
                            elementMap.put("salesNumber",salesTrend.get("salesNumber"));
                            elementMap.put("ordersNum",salesTrend.get("ordersNum"));
                        }
                    }
                }
                varList.add(elementMap);
            }
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);


        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel salesTrendProductByDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String date = pd.getString("date");
        String type = pd.getString("type");
        if(!StringUtils.isEmpty(date)){
            initPageDataByDate(pd,date);
        }else{
            model.putCode(6);
            model.putMsg("时间参数不能为空！");
            return model;
        }

        List<Map> salesVolumeByProductList = getSalesVolumeNumberByProduct(pd,type);

        model.putResult(salesVolumeByProductList);

        return model;
    }

    private void initPageDataByDate(PageData pd,String date) {
        String cycle = pd.getString("cycle");
        pd.put("startDate",date);
        if("day".equals(cycle)){
            String nextYearMonthDay = DateFormat.getNextYearMonthDay(date);
            pd.put("endDate",nextYearMonthDay);
        }else if("year".equals(cycle)){
            String nextYear = DateFormat.getNextYear(date);
            pd.put("endDate",nextYear);
        }else{
            String nextYearMonth = DateFormat.getNextYearMonth(date);
            pd.put("endDate",nextYearMonth);
        }
    }


    private List<String> initPageDataByDMY(PageData pd) throws Exception {
        List<String> yearMonthDayList =  new ArrayList<>();
        String startDate = pd.getString("startDate");
        String endDate = pd.getString("endDate");
        String cycle = pd.getString("cycle");
        if(StringUtils.isEmpty(startDate)||StringUtils.isEmpty(endDate)){
            if("day".equals(cycle)){
                String currentYearMonthDay = DateFormat.getCurrentYearMonthDay();
                String nextYearMonthDay = DateFormat.getNextYearMonthDay(currentYearMonthDay);
                String lastMonthSameDay = DateFormat.getLastMonthSameDay(currentYearMonthDay);
                pd.put("format","%Y-%m-%d");
                pd.put("startDate",lastMonthSameDay);
                pd.put("endDate",nextYearMonthDay);
            }else if("year".equals(cycle)){
                String currentYear = DateFormat.getCurrentYear();
                String nextYear = DateFormat.getNextYear(currentYear);
                String lastTenYear = DateFormat.getLastTenYear(currentYear);
                pd.put("format","%Y");
                pd.put("startDate",lastTenYear);
                pd.put("endDate",nextYear);
            }else{
                String currentYearMonth = DateFormat.getCurrentYearMonth();
                String nextYearMonth = DateFormat.getNextYearMonth(currentYearMonth);
                String startYearMonth_YearOnYear = DateFormat.getStartYearMonth_YearOnYear(currentYearMonth);
                pd.put("format","%Y-%m");
                pd.put("startDate",startYearMonth_YearOnYear);
                pd.put("endDate",nextYearMonth);

            }

        }else{

            if("day".equals(cycle)){
                String nextYearMonthDay = DateFormat.getNextYearMonthDay(endDate);
                pd.put("format","%Y-%m-%d");
                pd.put("endDate",nextYearMonthDay);
            }else if("year".equals(cycle)){
                String nextYear = DateFormat.getNextYear(endDate);
                pd.put("format","%Y");
                pd.put("endDate",nextYear);
            }else{
                String nextYearMonth = DateFormat.getNextYearMonth(endDate);
                pd.put("format","%Y-%m");
                pd.put("endDate",nextYearMonth);
            }

        }

        if("day".equals(cycle)){
            yearMonthDayList = DateFormat.getAllYearMonthDay(pd.getString("startDate"),pd.getString("endDate"));
        }else if("year".equals(cycle)){
            yearMonthDayList = DateFormat.getAllYear(pd.getString("startDate"),pd.getString("endDate"));
        }else{
            yearMonthDayList = DateFormat.getAllYearMonth(pd.getString("startDate"),pd.getString("endDate"));
        }

        return yearMonthDayList;
    }


    @Override
    public ResultModel salesTrendCustomerByDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String date = pd.getString("date");
        String type = pd.getString("type");
        if(!StringUtils.isEmpty(date)){
            initPageDataByDate(pd,date);
        }else{
            model.putCode(7);
            model.putMsg("时间参数不能为空！");
            return model;
        }

        List<Map> salesVolumeNumberByCustomerList = getSalesVolumeNumberByCustomer(pd,type);

        model.putResult(salesVolumeNumberByCustomerList);

        return model;
    }

    @Override
    public ResultModel salesTrendEmployeeByDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String date = pd.getString("date");
        String type = pd.getString("type");
        if(!StringUtils.isEmpty(date)){
            initPageDataByDate(pd,date);
        }else{
            model.putCode(8);
            model.putMsg("时间参数不能为空！");
            return model;
        }

        List<Map> salesVolumeNumberByEmployeeList = getSalesVolumeNumberByEmployee(pd,type);

        model.putResult(salesVolumeNumberByEmployeeList);

        return model;
    }


    @Override
    public ResultModel salesProductQueryByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("salesProductQueryByDMY");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }


        List<String> yearMonthDayList =  initPageDataByDMY(pd);

        List<Map> salesProductQueryByDMYList = saleAnalysisMapper.getSalesProductQueryByDMY(pd);

        List<Map> varList = new ArrayList<>();

        if(salesProductQueryByDMYList!=null&&salesProductQueryByDMYList.size()>0) {
            Set<String> idSet = new HashSet<>();
            for (Map salesProduct : salesProductQueryByDMYList) {
                String salesProductId = (String) salesProduct.get("id");
                idSet.add(salesProductId);
            }

            for (String id : idSet) {
                String name = null;

                List<Map> elementList = new ArrayList<>();
                for (Map salesProduct : salesProductQueryByDMYList) {
                    String salesProductId = (String)salesProduct.get("id");
                    if(id.equals(salesProductId)){
                        name = salesProduct.get("name")!=null?(String)salesProduct.get("name"):null;
                        elementList.add(salesProduct);
                    }
                }

                if(yearMonthDayList!=null&&yearMonthDayList.size()>0) {
                    for (String yearMonthDay : yearMonthDayList) {
                        Map elementMap = new HashMap();
                        elementMap.put("id",id);
                        elementMap.put("name",name);
                        elementMap.put("date",yearMonthDay);
                        elementMap.put("salesVolume","0.00");
                        elementMap.put("salesNumber","0.00");
                        elementMap.put("maxPrice","0.0000");
                        elementMap.put("minPrice","0.0000");

                        for(Map element : elementList){
                            String date = element.get("date")!=null?(String)element.get("date"):"";
                            if(date.equals(yearMonthDay)){
                                elementMap.put("salesVolume",element.get("salesVolume"));
                                elementMap.put("salesNumber",element.get("salesNumber"));
                                elementMap.put("maxPrice",element.get("maxPrice"));
                                elementMap.put("minPrice",element.get("minPrice"));
                            }
                        }

                        varList.add(elementMap);
                    }
                }
            }


        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);


        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel salesProductVolumeByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<String> yearMonthDayList =  initPageDataByDMY(pd);

        List<Map> salesProductQueryByDMYList = saleAnalysisMapper.getSalesProductQueryByDMY(pd);

        List<Map> result = getFirstTenResult(salesProductQueryByDMYList,yearMonthDayList,"volume");

        model.putResult(result);

        return model;
    }

    private List<Map> getFirstTenResult(List<Map> varList,List<String> yearMonthDayList,String type) {
        List<Map> result = new ArrayList<>();

        if(varList!=null&&varList.size()>0) {
            Set<String> idSet = new HashSet<>();
            for (Map element : varList) {
                String salesProductId = (String) element.get("id");
                idSet.add(salesProductId);
            }
            for (String id : idSet) {
                List seriesData = new ArrayList<>();
                List<Map> elementData = new ArrayList<>();
                BigDecimal volumeTotal = BigDecimal.ZERO;
                BigDecimal numberTotal = BigDecimal.ZERO;
                Map resultMap = new HashMap();
                resultMap.put("id",id);
                resultMap.put("name",null);
                resultMap.put("numberTotal",numberTotal);
                resultMap.put("volumeTotal",volumeTotal);
                resultMap.put("dateData",yearMonthDayList);
                resultMap.put("seriesData",seriesData);
                resultMap.put("elementData",elementData);



                List<Map> elementList = new ArrayList<>();
                for (Map element : varList) {
                    String salesProductId = (String)element.get("id");
                    if(id.equals(salesProductId)){
                        resultMap.put("name",element.get("name"));
                        elementList.add(element);
                    }
                }

                if(yearMonthDayList!=null&&yearMonthDayList.size()>0) {
                    for (String yearMonthDay : yearMonthDayList) {
                        Map elementMap = new HashMap();
                        elementMap.put("date",yearMonthDay);
                        elementMap.put("salesVolume","0.00");
                        elementMap.put("salesNumber","0.00");

                        for(Map element : elementList){
                            String date = element.get("date")!=null?(String)element.get("date"):"";
                            if(date.equals(yearMonthDay)){
                                elementMap.put("salesVolume",element.get("salesVolume"));
                                elementMap.put("salesNumber",element.get("salesNumber"));

                                BigDecimal volume = elementMap.get("salesVolume")!=null?(BigDecimal)elementMap.get("salesVolume"):BigDecimal.ZERO;
                                BigDecimal number = elementMap.get("salesNumber")!=null?(BigDecimal)elementMap.get("salesNumber"):BigDecimal.ZERO;
                                volumeTotal = volumeTotal.add(volume);
                                numberTotal = numberTotal.add(number);
                            }
                        }

                        elementData.add(elementMap);
                    }
                }


                resultMap.put("numberTotal",numberTotal);
                resultMap.put("volumeTotal",volumeTotal);

                for(Map element : elementData){
                    if("volume".equals(type)){
                        seriesData.add(element.get("salesVolume"));
                    }else{
                        seriesData.add(element.get("salesNumber"));
                    }

                }


                result.add(resultMap);
            }

            result.sort(
                    new Comparator<Map>() {
                        @Override
                        public int compare(Map o1, Map o2) {
                            if("volume".equals(type)){
                                return ((BigDecimal)o2.get("volumeTotal")).compareTo((BigDecimal)o1.get("volumeTotal"));
                            }else{
                                return ((BigDecimal)o2.get("numberTotal")).compareTo((BigDecimal)o1.get("numberTotal"));
                            }
                        }
                    }
            );

            if (result.size()>10) {
                result = result.subList(0,10);
            }

        }

        return result;
    }


    @Override
    public ResultModel salesProductNumberByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<String> yearMonthDayList =  initPageDataByDMY(pd);
        List<Map> salesProductQueryByDMYList = saleAnalysisMapper.getSalesProductQueryByDMY(pd);
        List<Map> result = getFirstTenResult(salesProductQueryByDMYList,yearMonthDayList,"number");
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesProductProportion(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String type = pd.getString("type");
        initPageDataByDMY(pd);
        List<Map> salesVolumeByProductList = getSalesVolumeNumberByProduct(pd,type);
        model.putResult(salesVolumeByProductList);
        return model;
    }


    @Override
    public ResultModel salesProductCustomer(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> resultList = new ArrayList();
        initPageDataByDMY(pd);
        String idStr = pd.getString("productIds");
        Set<String> idSet = distinctIds(idStr);
        if(idSet!=null&&idSet.size()>0){
            for(String id : idSet){
                Map result = new HashMap();
                pd.put("productId",id);
                List<Map> salesProductCustomerList = getSalesVolumeNumberByCustomer(pd,"volume");
                if(salesProductCustomerList!=null&&salesProductCustomerList.size()>0){
                    result.put("productId",id);
                    result.put("productName",salesProductCustomerList.get(0).get("productName"));
                    result.put("varList",salesProductCustomerList);
                    resultList.add(result);
                }
            }
        }
        model.putResult(resultList);
        return model;
    }


    @Override
    public ResultModel salesProductEmployee(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> resultList = new ArrayList();
        initPageDataByDMY(pd);
        String idStr = pd.getString("productIds");
        Set<String> idSet = distinctIds(idStr);
        if(idSet!=null&&idSet.size()>0){
            for(String id : idSet){
                Map result = new HashMap();
                pd.put("productId",id);
                List<Map> salesProductEmployeeList = getSalesVolumeNumberByEmployee(pd,"volume");
                if(salesProductEmployeeList!=null&&salesProductEmployeeList.size()>0){
                    result.put("productId",id);
                    result.put("productName",salesProductEmployeeList.get(0).get("productName"));
                    result.put("varList",salesProductEmployeeList);
                    resultList.add(result);
                }
            }
        }
        model.putResult(resultList);
        return model;
    }

    private Set<String> distinctIds(String idStr) {
        Set<String> idSet = new HashSet();
        if(!StringUtils.isEmpty(idStr)){
            String[] ids = idStr.split(",");
            if(ids!=null&&ids.length>0){
                for(String id : ids){
                    idSet.add(id);
                }
            }
        }
        return idSet;
    }


    @Override
    public ResultModel salesCustomerQueryByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("salesCustomerQueryByDMY");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }


        List<String> yearMonthDayList =  initPageDataByDMY(pd);

        List<Map> salesCustomerQueryByDMYList = saleAnalysisMapper.getSalesCustomerQueryByDMY(pd);

        List<Map> varList = new ArrayList<>();

        if(salesCustomerQueryByDMYList!=null&&salesCustomerQueryByDMYList.size()>0) {
            Set<String> idSet = new HashSet<>();
            for (Map salesCustomer : salesCustomerQueryByDMYList) {
                String salesCustomerId = (String) salesCustomer.get("id");
                idSet.add(salesCustomerId);
            }

            for (String id : idSet) {
                String name = null;

                List<Map> elementList = new ArrayList<>();
                for (Map salesCustomer : salesCustomerQueryByDMYList) {
                    String salesProductId = (String)salesCustomer.get("id");
                    if(id.equals(salesProductId)){
                        name = salesCustomer.get("name")!=null?(String)salesCustomer.get("name"):null;
                        elementList.add(salesCustomer);
                    }
                }

                if(yearMonthDayList!=null&&yearMonthDayList.size()>0) {
                    for (String yearMonthDay : yearMonthDayList) {
                        Map elementMap = new HashMap();
                        elementMap.put("id",id);
                        elementMap.put("name",name);
                        elementMap.put("date",yearMonthDay);
                        elementMap.put("salesVolume","0.00");
                        elementMap.put("salesNumber","0.00");


                        for(Map element : elementList){
                            String date = element.get("date")!=null?(String)element.get("date"):"";
                            if(date.equals(yearMonthDay)){
                                elementMap.put("salesVolume",element.get("salesVolume"));
                                elementMap.put("salesNumber",element.get("salesNumber"));
                            }
                        }

                        varList.add(elementMap);
                    }
                }
            }
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesCustomerVolumeByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<String> yearMonthDayList =  initPageDataByDMY(pd);
        List<Map> salesCustomerQueryByDMYList = saleAnalysisMapper.getSalesCustomerQueryByDMY(pd);
        List<Map> result = getFirstTenResult(salesCustomerQueryByDMYList,yearMonthDayList,"volume");
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesCustomerNumberByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<String> yearMonthDayList =  initPageDataByDMY(pd);
        List<Map> salesCustomerQueryByDMYList = saleAnalysisMapper.getSalesCustomerQueryByDMY(pd);
        List<Map> result = getFirstTenResult(salesCustomerQueryByDMYList,yearMonthDayList,"number");
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesCustomerProportion(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String type = pd.getString("type");
        initPageDataByDMY(pd);
        List<Map> salesVolumeByCustomerList = getSalesVolumeNumberByCustomer(pd,type);
        model.putResult(salesVolumeByCustomerList);
        return model;
    }


    @Override
    public ResultModel salesCustomerProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> resultList = new ArrayList();
        initPageDataByDMY(pd);
        String idStr = pd.getString("customerIds");
        Set<String> idSet = distinctIds(idStr);
        if(idSet!=null&&idSet.size()>0){
            for(String id : idSet){
                Map result = new HashMap();
                pd.put("customerId",id);
                List<Map> salesCustomerProductList = getSalesVolumeNumberByProduct(pd,"volume");
                if(salesCustomerProductList!=null&&salesCustomerProductList.size()>0){
                    result.put("customerId",id);
                    result.put("customerName",salesCustomerProductList.get(0).get("customerName"));
                    result.put("varList",salesCustomerProductList);
                    resultList.add(result);
                }

            }
        }
        model.putResult(resultList);

        return model;
    }


    @Override
    public ResultModel salesEmployeeQueryByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("salesEmployeeQueryByDMY");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }


        List<String> yearMonthDayList =  initPageDataByDMY(pd);

        List<Map> salesEmployeeQueryByDMYList = saleAnalysisMapper.getSalesEmployeeQueryByDMY(pd);

        List<Map> varList = new ArrayList<>();

        if(salesEmployeeQueryByDMYList!=null&&salesEmployeeQueryByDMYList.size()>0) {
            Set<String> idSet = new HashSet<>();
            for (Map salesEmployee : salesEmployeeQueryByDMYList) {
                String salesEmployeeId = (String) salesEmployee.get("id");
                idSet.add(salesEmployeeId);
            }

            for (String id : idSet) {
                String name = null;

                List<Map> elementList = new ArrayList<>();
                for (Map salesEmployee : salesEmployeeQueryByDMYList) {
                    String salesProductId = (String)salesEmployee.get("id");
                    if(id.equals(salesProductId)){
                        name = salesEmployee.get("name")!=null?(String)salesEmployee.get("name"):null;
                        elementList.add(salesEmployee);
                    }
                }

                if(yearMonthDayList!=null&&yearMonthDayList.size()>0) {
                    for (String yearMonthDay : yearMonthDayList) {
                        Map elementMap = new HashMap();
                        elementMap.put("id",id);
                        elementMap.put("name",name);
                        elementMap.put("date",yearMonthDay);
                        elementMap.put("salesVolume","0.00");
                        elementMap.put("salesNumber","0.00");

                        for(Map element : elementList){
                            String date = element.get("date")!=null?(String)element.get("date"):"";
                            if(date.equals(yearMonthDay)){
                                elementMap.put("salesVolume",element.get("salesVolume"));
                                elementMap.put("salesNumber",element.get("salesNumber"));
                            }
                        }
                        varList.add(elementMap);
                    }
                }
            }
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        return model;
    }


    @Override
    public ResultModel salesEmployeeVolumeByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<String> yearMonthDayList =  initPageDataByDMY(pd);
        List<Map> salesEmployeeVolumeByDMYList = saleAnalysisMapper.getSalesEmployeeQueryByDMY(pd);
        List<Map> result = getFirstTenResult(salesEmployeeVolumeByDMYList,yearMonthDayList,"volume");
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesEmployeeNumberByDMY(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<String> yearMonthDayList =  initPageDataByDMY(pd);
        List<Map> salesEmployeeNumberByDMYList = saleAnalysisMapper.getSalesEmployeeQueryByDMY(pd);
        List<Map> result = getFirstTenResult(salesEmployeeNumberByDMYList,yearMonthDayList,"number");
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel salesEmployeeProportion(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String type = pd.getString("type");
        initPageDataByDMY(pd);
        List<Map> salesVolumeByEmployeeList = getSalesVolumeNumberByEmployee(pd,type);
        model.putResult(salesVolumeByEmployeeList);
        return model;
    }


    @Override
    public ResultModel salesEmployeeProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> resultList = new ArrayList();

        initPageDataByDMY(pd);
        String idStr = pd.getString("employeeIds");

        Set<String> idSet = distinctIds(idStr);

        if(idSet!=null&&idSet.size()>0){
            for(String id : idSet){
                Map result = new HashMap();
                pd.put("employeeId",id);
                List<Map> salesEmployeeProductList = getSalesVolumeNumberByProduct(pd,"volume");
                if(salesEmployeeProductList!=null&&salesEmployeeProductList.size()>0){
                    result.put("employeeId",id);
                    result.put("employeeName",salesEmployeeProductList.get(0).get("employeeName"));
                    result.put("varList",salesEmployeeProductList);
                    resultList.add(result);
                }
            }
        }
        model.putResult(resultList);
        return model;
    }






}
