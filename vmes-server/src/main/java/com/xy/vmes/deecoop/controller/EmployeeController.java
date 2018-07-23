package com.xy.vmes.deecoop.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.service.EmployeeService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


/**
* 说明：Controller
* @author 陈刚 自动生成
* @date 2018-07-23
*/
@RestController
@Slf4j
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/employee/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Employee employee = employeeService.selectById(id);
        model.putResult(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/employee/save")
    public ResultModel save()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.save(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/employee/update")
    public ResultModel update()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.update(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/employee/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        employeeService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/employee/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Employee> employeeList = employeeService.dataListPage(pd,pg);
        model.putResult(employeeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/employee/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Employee> employeeList = employeeService.dataList(pd);
        model.putResult(employeeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/employee/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = employeeService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = employeeService.findDataList(pd);
                    request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

}



