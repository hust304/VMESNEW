package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.yvan.*;
import com.yvan.common.util.StringUtil;
import com.yvan.platform.RestException;
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
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：Controller
* @author 陈刚 自动生成
* @date 2018-07-23
*/
@RestController
@Slf4j
public class DepartmentController {

    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/department/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Department department = departmentService.selectById(id);
        model.putResult(department);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/department/save")
    public ResultModel save()  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Department department = (Department)HttpUtils.pageData2Entity(pd, new Department());
        departmentService.save(department);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/department/update")
    public ResultModel update()  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Department department = (Department)HttpUtils.pageData2Entity(pd, new Department());
        departmentService.update(department);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/department/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        departmentService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/department/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Department> departmentList = departmentService.dataListPage(pd,pg);
        model.putResult(departmentList);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @PostMapping("/department/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Department> departmentList = departmentService.dataList(pd);
        model.putResult(departmentList);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-07-23
    */
    @GetMapping("/department/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################department/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = departmentService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = departmentService.findDataList(pd);
                    //request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################department/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 获得部门树形结构
     * 当前部门节点下面所有子节点树形结构
     *
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @GetMapping("/department/treeDepartments")
    public String treeDepartments() {
        PageData mapObj = HttpUtils.parsePageData();

        //递归调用获得(当前部门+当前部门下所有子部门)List结构体
        //Department detp = new Department();
        //detp.setId1("1");
        //detp.setName("公司1");
        //detp.setLayer(Integer.valueOf(1));
        //detp = null;
        //Tree<Department> treeObj = departmentService.findTree(detp);

        return null;
    }

    /**新增组织架构(组织类型:部门)
     * (organize_type:组织类型(1:公司 2:部门))
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/addDepartment")
    public ResultModel addDepartment() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Department deptObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (deptObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！</br>");
            return model;
        }

        String msgStr = departmentService.checkColumnByAdd(deptObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Department>
        Department paterObj = departmentService.findDepartmentById(deptObj.getPid());
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ deptObj.getPid() + ")系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (部门名称)在同一层名称不可重复
        if (departmentService.isExistByName(deptObj.getPid(), null, deptObj.getName())) {
            String msgTemp = "上级部门名称: {0}<br/>部门名称: {1}<br/>在系统中已经重复！</br>";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    deptObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        try {
            String id = Conv.createUuid();
            deptObj.setId(id);
            deptObj = departmentService.id2DepartmentByLayer(id,
                    Integer.valueOf(paterObj.getLayer().intValue() + 1),
                    deptObj);
            deptObj = departmentService.paterObject2ObjectDB(paterObj, deptObj);

            //获取部门编码
            String code = departmentService.createCoder("1");
            deptObj.setCode(code);

            //获取(长名称,长编码)- 通过'-'连接的字符串
            Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(paterObj);
            if (longNameCodeMpa != null
                && longNameCodeMpa.get("LongName") != null
                && longNameCodeMpa.get("LongName").trim().length() > 0
            ) {
                deptObj.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + deptObj.getName());
            }
            if (longNameCodeMpa != null
                && longNameCodeMpa.get("LongCode") != null
                && longNameCodeMpa.get("LongCode").trim().length() > 0
            ) {
                deptObj.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + deptObj.getCode());
            }
            //设置部门级别
            deptObj.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));

            departmentService.save(deptObj);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改组织架构(组织类型:部门)
     * (organize_type:组织类型(1:公司 2:部门))
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/updateDepartment")
    public ResultModel updateDepartment() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        Department deptObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (deptObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！</br>");
            return model;
        }

        String msgStr = departmentService.checkColumnByEdit(deptObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Department>
        Department paterObj = departmentService.findDepartmentById(deptObj.getPid());
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ deptObj.getPid() + ")系统中无数据，请与管理员联系！</br>");
            return model;
        }

        //2. (部门名称)在同一层名称不可重复
        if (departmentService.isExistByName(deptObj.getPid(), deptObj.getId(), deptObj.getName())) {
            String msgTemp = "上级部门名称: {0}<br/>部门名称: {1}<br/>在系统中已经重复！</br>";
            msgTemp = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    deptObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgTemp);
            return model;
        }

        try {
            Department deptDB = departmentService.findDepartmentById(deptObj.getId());
            deptDB = departmentService.object2objectDB(deptObj, deptDB);
            deptDB = departmentService.clearDepartmentByPath(deptDB);
            deptDB = departmentService.id2DepartmentByLayer(deptDB.getId(),
                    Integer.valueOf(paterObj.getLayer().intValue() + 1),
                    deptDB);
            deptDB = departmentService.paterObject2ObjectDB(paterObj, deptDB);

            //获取(长名称,长编码)- 通过'-'连接的字符串
            Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(paterObj);
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongName") != null
                    && longNameCodeMpa.get("LongName").trim().length() > 0
                    ) {
                deptDB.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + deptDB.getName());
            }
            if (longNameCodeMpa != null
                    && longNameCodeMpa.get("LongCode") != null
                    && longNameCodeMpa.get("LongCode").trim().length() > 0
                    ) {
                deptDB.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + deptDB.getCode());
            }
            //设置部门级别
            deptDB.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));
            departmentService.update(deptDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

    /**修改组织架构(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/updateDeptDisable")
    public ResultModel updateDeptDisable() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！<br/>";
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！<br/>";
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        try {
            Department objectDB = departmentService.findDepartmentById(id);
            objectDB.setIsdisable(isdisable);
            objectDB.setUdate(new Date());
            departmentService.update(objectDB);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }


    /**删除组织架构(组织类型:部门)
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/deleteDepartments")
    public ResultModel deleteDepartments() {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！</br>");
            return model;
        }

        String deptIds = (String)pageData.get("deptIds");
        if (deptIds == null || deptIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！</br>");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(deptIds);
        String[] id_arry = id_str.split(",");

//        id_str = "'" + id_str.replace(",", "','") + "'";
//        String pidQuery = "id in (" + id_str + ")";
//
//        //查询部门表-获得每一层的id-部门集合List<Department>
//        PageData findMap = new PageData();
//        //isdisable:是否禁用(1:已禁用 0:启用)
//        findMap.put("isdisable", "0");
//        findMap.put("queryStr", pidQuery);
//        findMap.put("mapSize", Integer.valueOf(findMap.size()));
//        List<Department> objectList = departmentService.findDepartmentList(findMap);
//
//        String msgStr = departmentService.checkDeleteDeptByList(objectList);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        try {
            departmentService.updateDisableByIds(id_arry);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return model;
    }

}



