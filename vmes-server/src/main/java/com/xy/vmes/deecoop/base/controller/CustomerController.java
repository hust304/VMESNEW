package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
 * 说明：vmes_customer:客户供应商表Controller
 * @author 陈刚 自动生成
 * @date 2018-09-18
 */
@RestController
@Slf4j
public class CustomerController {
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomeAddressService customeAddressService;

    @Autowired
    private FileService fileService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @GetMapping("/customer/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################customer/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Customer customer = customerService.selectById(id);
        model.putResult(customer);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/save")
    public ResultModel save()  throws Exception {

        logger.info("################customer/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Customer customer = (Customer)HttpUtils.pageData2Entity(pd, new Customer());
        customerService.save(customer);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/update")
    public ResultModel update()  throws Exception {

        logger.info("################customer/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Customer customer = (Customer)HttpUtils.pageData2Entity(pd, new Customer());
        customerService.update(customer);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @GetMapping("/customer/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################customer/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        customerService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/deleteByIds")
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################customer/deleteById 执行开始 ################# ");
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
            customerService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################customer/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Customer> customerList = customerService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",customerList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，禁止修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################customer/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Customer> customerList = customerService.dataList(pd);
        model.putResult(customerList);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/listPageCustomers")
    public ResultModel listPageCustomers()  throws Exception {
        logger.info("################customer/listPageCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("customer");
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
        pd.put("orderStr", "cust.cdate desc");

        String genreId = pd.getString("pid");
        if (genreId != null && genreId.trim().length() > 0
            && !Common.DICTIONARY_MAP.get("customerSupplierGenre").equals(genreId)
        ) {
            pd.put("genre", genreId);
        }

        List<Map> varMapList = new ArrayList();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = customerService.getDataListPage(pd, pg);
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
        logger.info("################customer/listPageCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增客户供应商
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/customer/addCustomer")
    public ResultModel addCustomer() throws Exception {
        logger.info("################/customer/addCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        //获取客户供应商编码
        String companyId = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyId,"vmes_customer","C");
        if(StringUtils.isEmpty(code)){
            model.putCode(1);
            model.putMsg("客户供应商编码规则创建异常，请重新操作！");
            return model;
        }

        Customer object = (Customer)HttpUtils.pageData2Entity(pageData, new Customer());
        object.setCuser(pageData.getString("cuser"));
        object.setCompanyId(companyId);
        object.setCode(code);
        //生成客户供应商二维码
        String qrcode = fileService.createQRCode("customer", YvanUtil.toJson(object));
        if (qrcode != null && qrcode.trim().length() > 0) {
            object.setQrcode(qrcode);
        }
        customerService.save(object);

        Long endTime = System.currentTimeMillis();
        logger.info("################customer/addCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改客户供应商
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/customer/updateCustomer")
    public ResultModel updateCustomer() throws Exception {
        logger.info("################/customer/updateCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        Customer objectDB = (Customer)HttpUtils.pageData2Entity(pageData, new Customer());
        objectDB.setUuser(pageData.getString("cuser"));
        customerService.update(objectDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################customer/updateCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改客户供应商(禁用)状态
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/customer/updateDisableCustomer")
    public ResultModel updateDisableCustomer() throws Exception {
        logger.info("################/customer/updateDisableCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        String isdisable = pageData.getString("isdisable");

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

//        if (!customerService.checkDeleteCustomerByIds(id)) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("当前禁用的数据系统正在使用中，不可禁用操作！");
//            return model;
//        }

        //2. 修改客户供应商(禁用)状态
        Customer objectDB = (Customer)HttpUtils.pageData2Entity(pageData, new Customer());
        customerService.update(objectDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################customer/updateDisableCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除客户供应商
     * 1. 支持批量删除
     * 2. 如果删除数据被引用，则禁用该数据
     * 3. 如果删除数据未被引用，则直接物理删除
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/customer/deleteCustomers")
    public ResultModel deleteCustomers() throws Exception {
        logger.info("################/customer/deleteCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        //2. 删除客户供应商
        ids = StringUtil.stringTrimSpace(ids);
        customerService.deleteByIds(ids.split(","));

        //3. 删除客户供应商地址
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            customeAddressService.deleteCustAddrByCustId(id);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################customer/deleteCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/exportExcelCustomers")
    public void exportExcelCustomers() throws Exception {
        logger.info("################customer/exportExcelCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("Customer");
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
        List<Map> dataList = customerService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelCustomer";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/exportExcelCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * Excel导入
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/customer/importExcelCustomers")
    public ResultModel importExcelCustomers(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################customer/importExcelCustomers 执行开始 ################# ");
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
        logger.info("################customer/importExcelCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}