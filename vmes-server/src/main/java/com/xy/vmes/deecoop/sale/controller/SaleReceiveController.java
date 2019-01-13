package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceive;
import com.xy.vmes.entity.SaleReceiveDetail;
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
import java.math.BigDecimal;
import java.util.*;



/**
* 说明：收款单Controller
* @author 刘威 自动生成
* @date 2019-01-10
*/
@RestController
@Slf4j
public class SaleReceiveController {

    private Logger logger = LoggerFactory.getLogger(SaleReceiveController.class);

    @Autowired
    private SaleReceiveService saleReceiveService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;

    @Autowired
    private CustomerService customerService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/saleReceive/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################saleReceive/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleReceive saleReceive = saleReceiveService.selectById(id);
        model.putResult(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################saleReceive/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceive saleReceive = (SaleReceive)HttpUtils.pageData2Entity(pd, new SaleReceive());
        saleReceiveService.save(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################saleReceive/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceive saleReceive = (SaleReceive)HttpUtils.pageData2Entity(pd, new SaleReceive());
        saleReceiveService.update(saleReceive);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @GetMapping("/saleReceive/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################saleReceive/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleReceiveService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################saleReceive/deleteByIds 执行开始 ################# ");
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
            saleReceiveService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################saleReceive/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleReceive> saleReceiveList = saleReceiveService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleReceiveList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################saleReceive/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleReceive> saleReceiveList = saleReceiveService.dataList(pd);
        model.putResult(saleReceiveList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-12-24
     */
    @PostMapping("/saleReceive/saveSaleReceiveAndDetail")
    @Transactional(rollbackFor=Exception.class)
    //注解为事务范围的方法中，事务的回滚仅仅对于unchecked的异常有效。对于checked异常无效。也就是说事务回滚仅仅发生在出现RuntimeException或Error的时候。如果希望一般的异常也能触发事务回滚，需要在注解了@Transactional的方法上，将@Transactional回滚参数设为：@Transactional(rollbackFor=Exception.class)
    public ResultModel saveSaleReceiveAndDetail()  throws Exception {

        logger.info("################saleReceive/saveSaleReceiveAndDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();



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
        BigDecimal addBalance = BigDecimal.valueOf(Double.parseDouble(pd.getString("addBalance")));
        BigDecimal currentBalance = BigDecimal.valueOf(Double.parseDouble(pd.getString("currentBalance")));
        BigDecimal detailBalance = BigDecimal.ZERO;

        if(mapList!=null&&mapList.size()>0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> detailMap = mapList.get(i);
                detailBalance = detailBalance.add(BigDecimal.valueOf(Double.parseDouble(detailMap.get("receiveAmount"))));
            }
        }

        if(detailBalance.compareTo(currentBalance)!=0){
//            throw new Exception("分摊明细总额必须与本次分摊总额一致！");
            model.putCode("1");
            model.putMsg("分摊明细总额必须与本次分摊总额一致！");
            return model;
        }


        Customer oldCustomer = customerService.selectById(customerId);
        customerService.updateCustomerBalance(oldCustomer,oldCustomer.getBalance().add(addBalance),pd.getString("uuser"),"1");//操作类型(0:变更 1:录入收款 -1:费用分摊)


        SaleReceive saleReceive = new SaleReceive();
        String id = Conv.createUuid();
        String companyID = pd.getString("currentCompanyId");
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_sale_receive", "R");
        saleReceive.setId(id);
        saleReceive.setCode(code);
        saleReceive.setType("1");//收款类型(0:预收款 1:普通收款 )
        saleReceive.setCustomerId(customerId);
        saleReceive.setReceiveSum(currentBalance);
        saleReceive.setCompanyId(companyID);
        saleReceive.setUuser(pd.getString("cuser"));
        saleReceive.setCuser(pd.getString("cuser"));
        saleReceiveService.save(saleReceive);


        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                SaleReceiveDetail detail = new SaleReceiveDetail();
                detail.setParentId(saleReceive.getId());
                detail.setOrderId(detailMap.get("id"));
                detail.setDiscountAmount(BigDecimal.valueOf(Double.parseDouble(detailMap.get("discountAmount"))));
                detail.setReceiveAmount(BigDecimal.valueOf(Double.parseDouble(detailMap.get("receiveAmount"))));
                detail.setState("1");//收款单状态(0:待收款 1:已收款 -1:已取消)
                detail.setUuser(pd.getString("cuser"));
                detail.setCuser(pd.getString("cuser"));
                saleReceiveDetailService.save(detail);

            }
        }

        oldCustomer = customerService.selectById(customerId);
        customerService.updateCustomerBalance(oldCustomer,oldCustomer.getBalance().subtract(currentBalance),pd.getString("uuser"),"-1");//操作类型(0:变更 1:录入收款 -1:费用分摊)
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/saveSaleReceiveAndDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/listPageSaleReceives")
    public ResultModel listPageSaleReceives()  throws Exception {
        logger.info("################saleReceive/listPageSaleReceives 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("SaleReceive");
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
        List<Map> varList = saleReceiveService.getDataListPage(pd,pg);
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
        logger.info("################saleReceive/listPageSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/exportExcelSaleReceives")
    public void exportExcelSaleReceives() throws Exception {
        logger.info("################saleReceive/exportExcelSaleReceives 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("SaleReceive");
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
        List<Map> dataList = saleReceiveService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleReceive";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleReceive/exportExcelSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2019-01-10
    */
    @PostMapping("/saleReceive/importExcelSaleReceives")
    public ResultModel importExcelSaleReceives(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################saleReceive/importExcelSaleReceives 执行开始 ################# ");
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
        logger.info("################saleReceive/importExcelSaleReceives 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



