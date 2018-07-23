package com.xy.vmes.deecoop.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.service.EmployeeService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
* 说明：部门表 Controller
* 创建人：自动创建
* 创建时间：2018-07-20
*/
@RestController
@Slf4j
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @GetMapping("/employee/selectById/{id}")
    public String selectById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            Employee employee = employeeService.selectById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",employee);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/selectById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/employee/save")
    public String save() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
            employeeService.save(employee);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/save################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/employee/update")
    public String update() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
            employeeService.update(employee);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/update################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }



    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @GetMapping("/employee/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            employeeService.deleteById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/deleteById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/employee/dataListPage")
    public String dataListPage() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Pagination pg = HttpUtils.parsePagination();
            List<Employee> employeeList = employeeService.dataListPage(pd,pg);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",employeeList);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/dataListPage################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/employee/dataList")
    public String dataList() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            List<Employee> employeeList = employeeService.dataList(pd);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",employeeList);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################employee/dataList################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @GetMapping("/employee/excelExport")
    public void excelExport() {

        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","*");
        response.addHeader("Access-Control-Max-Age","100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials","false");
        try {
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
            }catch(Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                logger.error("################employee/excelExport################# 执行异常:"+sw.toString());
            }

    }



}



