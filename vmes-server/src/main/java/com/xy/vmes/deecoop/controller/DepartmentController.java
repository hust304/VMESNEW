package com.xy.vmes.deecoop.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.Tree;
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
 * 说明：部门表 Controller
 * 创建人：自动创建
 * 创建时间：2018-07-18
 */
@RestController
@Slf4j
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @GetMapping("/department/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id) {
        ResultModel model = new ResultModel();
        Department department = departmentService.selectById(id);
        model.set("code", 0);
        model.set("msg", "执行成功");
        model.set("result", department);
        return model;
    }


    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/findById")
    public ResultModel findById() {
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Department department = departmentService.findById(pd);
        model.put("code", 0);
        model.put("msg", "执行成功！");
        model.put("result", department);
        return model;
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/save")
    public String save() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Department department = (Department) HttpUtils.copyToEntity(pd, Department.class);
            departmentService.save(department);
            result.put("code", 0);
            result.put("msg", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/save################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/update")
    public String update() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Department department = (Department) HttpUtils.copyToEntity(pd, Department.class);
            departmentService.update(department);
            result.put("code", 0);
            result.put("msg", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/update################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/delete")
    public String delete() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Department department = (Department) HttpUtils.copyToEntity(pd, Department.class);
            departmentService.delete(department);
            result.put("code", 0);
            result.put("msg", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/delete################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }


    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @GetMapping("/department/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            departmentService.deleteById(id);
            result.put("code", 0);
            result.put("msg", "执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/deleteById################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/dataListPage")
    public String dataListPage() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Pagination pg = HttpUtils.parsePagination();
            List<Department> departmentList = departmentService.dataListPage(pd, pg);
            result.put("code", 0);
            result.put("msg", "执行成功！");
            result.put("result", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/dataListPage################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @PostMapping("/department/dataList")
    public String dataList() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            List<Department> departmentList = departmentService.dataList(pd);
            result.put("code", 0);
            result.put("msg", "执行成功！");
            result.put("result", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################department/dataList################# 执行异常:" + sw.toString());
            result.put("code", 1);
            result.put("msg", "执行异常！");
            result.put("result", sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @GetMapping("/department/excelExport")
    public void excelExport() throws Exception {

        HttpServletResponse response = HttpUtils.currentResponse();
        HttpServletRequest request = HttpUtils.currentRequest();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Max-Age", "100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials", "false");
        ExcelUtil.buildDefaultExcelDocument(request, response, new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = departmentService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = departmentService.findDataList(pd);
                request.setAttribute("varList", varList);
            }
        });

    }

}



