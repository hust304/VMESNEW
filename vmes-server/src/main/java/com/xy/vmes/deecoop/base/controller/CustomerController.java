package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.entity.TreeEntity;
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
    @GetMapping("/base/customer/selectById/{id}")
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
    @PostMapping("/base/customer/save")
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/base/customer/update")
    @Transactional(rollbackFor=Exception.class)
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
    @GetMapping("/base/customer/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/base/customer/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/base/customer/dataListPage")
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
    @PostMapping("/base/customer/dataList")
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


    @PostMapping("/base/customer/addCustomerBalance")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addCustomerBalance()  throws Exception {

        logger.info("################customer/addCustomerBalance 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = customerService.addCustomerBalance(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/addCustomerBalance 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/base/customer/updateCustomerBalance")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCustomerBalance()  throws Exception {

        logger.info("################customer/updateCustomerBalance 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = customerService.updateCustomerBalancee(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/updateCustomerBalance 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/base/customer/listPageCustomers")
    public ResultModel listPageCustomers()  throws Exception {
        logger.info("################customer/listPageCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = customerService.listPageCustomers(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/listPageCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    @PostMapping("/base/customer/listPageCustomerReceive")
    public ResultModel listPageCustomerReceive()  throws Exception {
        logger.info("################customer/listPageCustomerReceive 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = customerService.listPageCustomerReceive(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/listPageCustomerReceive 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/base/customer/listPageCustomerAccountDays")
    public ResultModel listPageCustomerAccountDays()  throws Exception {
        logger.info("################customer/listPageCustomerAccountDays 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = customerService.listPageCustomerAccountDays(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/listPageCustomerAccountDays 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增客户供应商
     *
     * @author 陈刚
     * @date 2018-09-19
     */
    @PostMapping("/base/customer/addCustomer")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addCustomer() throws Exception {
        logger.info("################/customer/addCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = customerService.addCustomer(pageData);
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
    @PostMapping("/base/customer/updateCustomer")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCustomer() throws Exception {
        logger.info("################/customer/updateCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = customerService.updateCustomer(pageData);
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
    @PostMapping("/base/customer/updateDisableCustomer")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableCustomer() throws Exception {
        logger.info("################/customer/updateDisableCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = customerService.updateDisableCustomer(pageData);
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
    @PostMapping("/base/customer/deleteCustomers")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteCustomers() throws Exception {
        logger.info("################/customer/deleteCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = customerService.deleteCustomers(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/deleteCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/base/customer/exportExcelCustomers")
    public void exportExcelCustomers() throws Exception {
        logger.info("################customer/exportExcelCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        customerService.exportExcelCustomers(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/exportExcelCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * Excel导入
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/base/customer/importExcelCustomers")
    public ResultModel importExcelCustomers(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################customer/importExcelCustomers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = customerService.importExcelCustomers(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/importExcelCustomers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/base/customer/listTreeCustomer")
    public ResultModel listTreeCustomer()  throws Exception {
        logger.info("################customer/listTreeCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = customerService.listTreeCustomer(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################customer/listTreeCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}