package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private DepartmentExcelService departmentExcelService;
    @Autowired
    private PostService postService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

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
        Pagination pg = HttpUtils.parsePagination(pd);
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
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/department/treeDepartments")
    public ResultModel treeDepartments()  throws Exception {
        logger.info("################/department/treeDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String deptId = null;
        if (pd.get("currentCompanyId") != null && pd.get("currentCompanyId").toString().trim().length() > 0) {
            deptId = ((String)pd.get("currentCompanyId")).trim();
        }

        List<TreeEntity> treeList = departmentService.getTreeList(pd);
        TreeEntity treeObj = TreeUtil.switchTree(deptId, treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/department/treeDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


//    /**
//     * 获得部门树形结构
//     * 当前部门节点下面所有子节点树形结构
//     *
//     * 创建人：陈刚
//     * 创建时间：2018-07-20
//     */
//    @GetMapping("/department/treeDepartments")
//    public String treeDepartments() {
//        PageData mapObj = HttpUtils.parsePageData();
//
//        //递归调用获得(当前部门+当前部门下所有子部门)List结构体
//        //Department detp = new Department();
//        //detp.setId1("1");
//        //detp.setName("公司1");
//        //detp.setLayer(Integer.valueOf(1));
//        //detp = null;
//        //Tree<Department> treeObj = departmentService.findTree(detp);
//
//        return null;
//    }

    /**新增组织架构(组织类型:部门)
     * (organize_type:组织类型(1:公司 2:部门))
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/addDepartment")
    public ResultModel addDepartment() throws Exception {
        logger.info("################department/addDepartment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        Department deptObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (deptObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！");
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
            model.putMsg("(pid:"+ deptObj.getPid() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (部门名称)在同一层名称不可重复
        if (departmentService.isExistByName(deptObj.getPid(), null, deptObj.getName())) {
            String msgTemp = "上级部门名称: {0}{2}部门名称: {1}{2}在系统中已经重复！{2}";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    deptObj.getName(),
                    Common.SYS_ENDLINE_DEFAULT);
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }


        //3. 创建部门信息
        String id = Conv.createUuid();
        deptObj.setId(id);
        //组织类型(1:公司 2:部门)
        deptObj.setOrganizeType("2");
        deptObj.setCuser(pageData.getString("cuser"));

        //获取部门编码
        String companyID = pageData.getString("currentCompanyId");
        String code = departmentService.createCoder(companyID);
        deptObj.setCode(code);

        deptObj = departmentService.id2DepartmentByLayer(id,
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                deptObj);
        deptObj = departmentService.paterObject2ObjectDB(paterObj, deptObj);


//        //获取(长名称,长编码)- 通过'-'连接的字符串
//        Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(paterObj);
//        if (longNameCodeMpa != null
//            && longNameCodeMpa.get("LongName") != null
//            && longNameCodeMpa.get("LongName").trim().length() > 0
//        ) {
//            deptObj.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + deptObj.getName());
//        }
//        if (longNameCodeMpa != null
//            && longNameCodeMpa.get("LongCode") != null
//            && longNameCodeMpa.get("LongCode").trim().length() > 0
//        ) {
//            deptObj.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + deptObj.getCode());
//        }

        //设置默认部门顺序
        if (deptObj.getSerialNumber() == null) {
            Integer maxCount = departmentService.findMaxSerialNumber(deptObj.getPid());
            deptObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        departmentService.save(deptObj);

        //4. 创建部门岗位信息
        String companyId = deptObj.getId1();
        //负责人(岗位)
        String code_1 = coderuleService.createCoder(companyId,"vmes_post","P");
        Post post_1 = new Post();
        post_1.setDeptId(deptObj.getId());
        post_1.setName("负责人");
        post_1.setCompanyId(companyId);
        post_1.setCode(code_1);
        post_1.setCuser(pageData.getString("cuser"));
        post_1.setRemark("负责人(岗位)-创建部门-系统自动创建");
        postService.save(post_1);

        //员工(岗位)
        String code_2 = coderuleService.createCoder(companyId,"vmes_post","P");
        Post post_2 = new Post();
        post_2.setDeptId(deptObj.getId());
        post_2.setName("员工");
        post_2.setCompanyId(companyId);
        post_2.setCode(code_2);
        post_2.setCuser(pageData.getString("cuser"));
        post_2.setRemark("员工(岗位)-创建部门-系统自动创建");
        postService.save(post_2);

        Long endTime = System.currentTimeMillis();
        logger.info("################/department/addDepartment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改组织架构(组织类型:部门)
     * (organize_type:组织类型(1:公司 2:部门))
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/updateDepartment")
    public ResultModel updateDepartment() throws Exception {
        logger.info("################department/updateDepartment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        Department deptObj = (Department)HttpUtils.pageData2Entity(pageData, new Department());
        if (deptObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 组织对象Department 异常！");
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
            model.putMsg("(pid:"+ deptObj.getPid() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (部门名称)在同一层名称不可重复
        if (departmentService.isExistByName(deptObj.getPid(), deptObj.getId(), deptObj.getName())) {
            String msgTemp = "上级部门名称: {0}{2}部门名称: {1}{2}在系统中已经重复！{2}";
            msgTemp = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    deptObj.getName(),
                    Common.SYS_ENDLINE_DEFAULT);
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgTemp);
            return model;
        }

        //3. 修改部门信息
        Department deptDB = departmentService.findDepartmentById(deptObj.getId());
        deptDB = departmentService.object2objectDB(deptObj, deptDB);
        deptDB = departmentService.clearDepartmentByPath(deptDB);
        deptDB = departmentService.id2DepartmentByLayer(deptDB.getId(),
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                deptDB);
        deptDB = departmentService.paterObject2ObjectDB(paterObj, deptDB);

//        //获取(长名称,长编码)- 通过'-'连接的字符串
//        Map<String, String> longNameCodeMpa = departmentService.findLongNameCodeByPater(paterObj);
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongName") != null
//                && longNameCodeMpa.get("LongName").trim().length() > 0
//                ) {
//            deptDB.setLongName(longNameCodeMpa.get("LongName").trim() + "-" + deptDB.getName());
//        }
//        if (longNameCodeMpa != null
//                && longNameCodeMpa.get("LongCode") != null
//                && longNameCodeMpa.get("LongCode").trim().length() > 0
//                ) {
//            deptDB.setLongCode(longNameCodeMpa.get("LongCode").trim() + "-" + deptDB.getCode());
//        }

        //设置默认部门顺序
        if (deptObj.getSerialNumber() == null) {
            Integer maxCount = departmentService.findMaxSerialNumber(deptObj.getPid());
            deptDB.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        departmentService.update(deptDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################/department/updateDepartment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改组织架构(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/updateDisableDept")
    public ResultModel updateDisableDept() throws Exception {
        logger.info("################department/updateDisableDept 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

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

        //2. 当前组织节点下是否含有(子节点-岗位)
        msgStr = departmentService.checkDeleteDeptByIds(id);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 修改组织架构(禁用)状态
        Department objectDB = departmentService.findDepartmentById(id);
        objectDB.setIsdisable(isdisable);
        objectDB.setUdate(new Date());
        departmentService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################/department/updateDisableDept 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**删除组织架构(组织类型:部门)
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/department/deleteDepartments")
    public ResultModel deleteDepartments() throws Exception {
        logger.info("################department/deleteDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");

        //2. 当前组织节点下是否含有(子节点-岗位)
        String msgStr = departmentService.checkDeleteDeptByIds(id_str);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        departmentService.updateDisableByIds(id_arry);
        Long endTime = System.currentTimeMillis();
        logger.info("################/department/deleteDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**组织管理分页查询List
//     *
//     * @author 陈刚
//     * @date 2018-08-08
//     */
//    @PostMapping("/department/listPageDepartments")
//    public ResultModel listPageDepartments() throws Exception {
//        ResultModel model = new ResultModel();
//        Map<String, Object> mapObj = new HashMap<String, Object>();
//
//
//        //1. 查询遍历List列表
//        LinkedHashMap<String, String> titlesLinkedMap = new LinkedHashMap<String, String>();
//        List<String> titlesHideList = new ArrayList<String>();
//        Map<String, String> varModelMap = new HashMap<String, String>();
//        List<LinkedHashMap<String, String>> titleList = departmentService.getColumnList();
//        if(titleList != null && titleList.size() >0 ){
//            LinkedHashMap<String, String> titlesMap = titleList.get(0);
//            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
//                if(entry.getKey().indexOf("_hide") != -1){
//                    titlesLinkedMap.put(entry.getKey().replace("_hide",""), entry.getValue());
//                    titlesHideList.add(entry.getKey().replace("_hide",""));
//                    varModelMap.put(entry.getKey().replace("_hide",""), "");
//                }else{
//                    titlesLinkedMap.put(entry.getKey(), entry.getValue());
//                    varModelMap.put(entry.getKey(), "");
//                }
//            }
//        }
//        mapObj.put("hideTitles",titlesHideList);
//        mapObj.put("titles",titlesLinkedMap);
//
//        //2. 分页查询数据List
//        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        List<Map<String, Object>> varList = departmentService.getDataListPage(pd, pg);
//        if(varList != null && varList.size() > 0){
//            for(int i=0; i < varList.size(); i++){
//                Map<String, Object> map = varList.get(i);
//                Map<String, String> varMap = new HashMap<String, String>();
//                varMap.putAll(varModelMap);
//                for (Map.Entry<String, String> entry : varMap.entrySet()) {
//                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
//                }
//                varMapList.add(varMap);
//            }
//        }
//        mapObj.put("varList",varMapList);
//        mapObj.put("pageData", YvanUtil.toJson(pg));
//
//        model.putResult(mapObj);
//        return model;
//    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-08-23
     */
    @PostMapping("/department/listPageDepartments")
    public ResultModel listPageDepartments()  throws Exception {

        logger.info("################department/listPageDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("department");
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

//        //所属企业id
//        String companyId = (String)pd.get("companyId");
//        String queryIdStr_1 = "";
//        if (companyId != null && companyId.trim().length() > 0) {
//            queryIdStr_1 = departmentService.findDeptidById(companyId, null, "a.");
//        }
//
//        //部门id
//        String deptId = (String)pd.get("deptId");
//        String queryIdStr_2 = "";
//        if (deptId != null && deptId.trim().length() > 0) {
//            queryIdStr_2 = departmentService.findDeptidById(deptId, null, "a.");
//        }
//
//        List<String> sqlStrList = new ArrayList<String>();
//        if (queryIdStr_1.trim().length() > 0) {sqlStrList.add(queryIdStr_1);}
//        if (queryIdStr_2.trim().length() > 0) {sqlStrList.add(queryIdStr_2);}
//
//        String queryStr = "";
//        for (String sqlStr : sqlStrList) {
//            queryStr = queryStr + sqlStr.trim() + " and ";
//        }
//        //去掉最后一个"and"
//        if (queryStr.lastIndexOf("and") != -1) {
//            queryStr = queryStr.substring(0, queryStr.lastIndexOf("and"));
//        }
//
//        if (queryStr.trim().length() > 0) {
//            queryStr = "(" + queryStr + ")";
//            pd.put("queryStr", queryStr);
//        }
//
//        String userType = (String)pd.get("userType");
//        //(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
//        if (Common.DICTIONARY_MAP.get("userType_admin").equals(userType) && pd.get("cuser") != null && pd.get("cuser").toString().trim().length() > 0) {
//            pd.put("cuser", pd.get("cuser").toString().trim());
//        } else {pd.put("cuser", null);}

        List<Map> varMapList = new ArrayList();
        List<Map> varList = departmentService.getDataListPage(pd,pg);
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
        logger.info("################department/listPageDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出功能：
     * 1. 勾选指定行导出-(','逗号分隔的id字符串)
     * 2. 按查询条件导出(默认查询方式)
     * 参数说明:
     *   ids          : 业务id字符串-(','分隔的字符串)
     *   queryColumn  : 查询字段(sql where 子句)
     *   showFieldcode: 导出Excel字段Code-显示顺序按照字符串排列顺序-(','分隔的字符串)

     * 注意: 参数(ids,queryColumn)这两个参数是互斥的，(有且有一个参数不为空)
     *
     * @throws Exception
     */
    @PostMapping("/department/exportExcelDepartments")
    public void exportExcelDepartments() throws Exception {
        logger.info("################department/exportExcelDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("department");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = departmentService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelDepartment";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################department/exportExcelDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * Excel文件导入
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/department/importExcelDepartments")
    public ResultModel importExcelDepartments(@RequestParam(value="excelFile") MultipartFile file) throws Exception {
        logger.info("################department/importExcelDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

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
        List<DeptExcelEntity> excelList = departmentExcelService.mapList2ImportExcelList(dataMapLst, null);
        if (excelList == null || excelList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Excel导入文件为空，请填写需要导入的数据！");
            return model;
        }

        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String msgStr = departmentExcelService.checkColumnImportExcel(excelList,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(msgStr.trim());
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        msgStr = departmentExcelService.checkExistImportExcelBySelf(excelList, Integer.valueOf(3), Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(msgStr.trim());
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        msgStr = departmentExcelService.checkExistImportExcelByDatabase(
                excelList,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(msgStr.trim());
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        String userId = (String)httpRequest.getParameter("userId");
        departmentExcelService.addImportExcelByList(excelList,
                userId,
                companyId);

        Long endTime = System.currentTimeMillis();
        logger.info("################department/importExcelDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

        //"Excel数据导入成功，共成功导入({0})条！"
        model.putMsg(MessageFormat.format("Excel数据导入成功，共成功导入({0})条！", excelList.size()));
        return model;
    }
}



