package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.sale.dao.SaleAnalysisMapper;
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
        }
        List<Map> salesTrendList = saleAnalysisMapper.getSalesTrend(pd);

        List<String> yearMonthList = DateFormat.getAllYearMonth(pd.getString("startDate"),pd.getString("endDate"));
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
                            resultMap.put("salesVolume",salesTrend.get("salesVolume"));
                            resultMap.put("salesNumber",salesTrend.get("salesNumber"));
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
        }

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
        }
        List<Map> salesTrendByEmployeeList = saleAnalysisMapper.getSalesTrendByEmployee(pd);
        List<String> yearMonthList = DateFormat.getAllYearMonth(pd.getString("startDate"),pd.getString("endDate"));


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
        List<Map> result = new ArrayList<>();
        pd.put("genre","df7cb67fca4148bc9632c908e4a7fdea");
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

            for(Map elem : result){
                BigDecimal endPlus = elem.get("endPlus")!=null?(BigDecimal)elem.get("endPlus"):BigDecimal.ZERO;
                elem.put("proportion",endPlus.divide(endPlusTotal,2,BigDecimal.ROUND_HALF_UP));
            }
        }

        model.putResult(result);
        return model;
    }


    private List<Map> getSalesVolumeByCustomer(PageData pd) {
        List<Map> salesVolumeByCustomerList = saleAnalysisMapper.getSalesVolumeByCustomer(pd);
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
                    svbc.put("proportion",volume.divide(volumeTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return  salesVolumeByCustomerList!=null?salesVolumeByCustomerList:new ArrayList();
    }

    private List<Map> getProductReturnRate(PageData pd) {
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
                    prr.put("proportion",number.divide(numberTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return productReturnRateList!=null?productReturnRateList:new ArrayList();
    }

    private List<Map> getSalesVolumeNumberByProduct(PageData pd, String type) {
        List<Map> salesVolumeNumberByProductList = saleAnalysisMapper.getSalesVolumeNumberByProduct(pd);
        BigDecimal volumeTotal = BigDecimal.ZERO;
        BigDecimal numberTotal = BigDecimal.ZERO;
        if(salesVolumeNumberByProductList!=null&&salesVolumeNumberByProductList.size()>0){
            for(Map vnp : salesVolumeNumberByProductList){
//                String volumeStr = (String)vnp.get("volume");
//                String numberStr = (String)vnp.get("number");
//                BigDecimal volume = BigDecimal.valueOf(Double.parseDouble(volumeStr));
//                BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numberStr));
                BigDecimal number = vnp.get("number")!=null?(BigDecimal)vnp.get("number"):BigDecimal.ZERO;
                BigDecimal volume = vnp.get("volume")!=null?(BigDecimal)vnp.get("volume"):BigDecimal.ZERO;
                volumeTotal = volumeTotal.add(volume);
                numberTotal = numberTotal.add(number);
            }


            if(volumeTotal.compareTo(BigDecimal.ZERO)>0&&"volume".equals(type)){
                for(Map vnp : salesVolumeNumberByProductList){
//                    String volumeStr = (String)vnp.get("volume");
//                    BigDecimal volume = BigDecimal.valueOf(Double.parseDouble(volumeStr));
                    BigDecimal volume = vnp.get("volume")!=null?(BigDecimal)vnp.get("volume"):BigDecimal.ZERO;
                    vnp.put("proportion",volume.divide(volumeTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }else if(numberTotal.compareTo(BigDecimal.ZERO)>0&&"number".equals(type)){
                for(Map vnp : salesVolumeNumberByProductList){
//                    String numberStr = (String)vnp.get("number");
//                    BigDecimal number = BigDecimal.valueOf(Double.parseDouble(numberStr));
                    BigDecimal number = vnp.get("number")!=null?(BigDecimal)vnp.get("number"):BigDecimal.ZERO;
                    vnp.put("proportion",number.divide(numberTotal,2,BigDecimal.ROUND_HALF_UP));
                }
            }
        }

        return  salesVolumeNumberByProductList!=null?salesVolumeNumberByProductList:new ArrayList();

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
}
