package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.ResponseCode;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
* 说明：vmes_employee:员工管理Controller
* @author 刘威 自动生成
* @date 2018-08-02
*/
@RestController
@Slf4j
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PostService postService;
    @Autowired
    private EmployPostService employPostService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private ColumnService columnService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Employee employee = employeeService.selectById(id);
        model.putResult(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/save")
    public ResultModel save()  throws Exception {

        logger.info("################employee/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.save(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/update")
    public ResultModel update()  throws Exception {

        logger.info("################employee/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.update(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        employeeService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################employee/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Employee> employeeList = employeeService.dataListPage(pd,pg);
        model.putResult(employeeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/dataList")
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
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################employee/excelExport 执行开始 ################# ");
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
        logger.info("################employee/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    private boolean isExistColumn(PageData pd) throws Exception {
        List<Map> varList = employeeService.findDataList(pd);
        if(varList!=null&&varList.size()>0){
            return true;
        }
        return false;
    }

    private boolean isExistMobile(PageData pd) throws Exception {
        PageData findMap = new PageData();
        findMap.put("mobile", (String)pd.get("mobile"));

        String userId = (String)pd.get("userId");
        if (userId != null && userId.trim().length() > 0) {
            findMap.put("id", userId);
        }

        boolean isExist = userService.isExistMobile(findMap);
        return isExist;
    }


    private EmployPost getMainEmployPost(String employId) throws Exception {
        Map columnMap = new HashMap();
        columnMap.put("employ_id",employId);
        columnMap.put("isplurality","0");
        columnMap.put("isdisable","0");
        List<EmployPost> employPostList = employPostService.selectByColumnMap(columnMap);
        if(employPostList!=null&&employPostList.size()>0){
            return employPostList.get(0);
        }
        return null;
    }

    /**
     * @author 刘威 新增员工信息同时需要根据情况新增用户信息
     * @date 2018-08-02
     */
    @PostMapping("/employee/addEmployeeAndUser")
    public ResultModel addEmployeeAndUser()  throws Exception {

        logger.info("################employee/addEmployeeAndUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String postId = pd.getString("postId");
        if(StringUtils.isEmpty(postId)){
            model.putMsg("岗位不能为空！！");
            model.putCode(1);
            return model;
        }
        String mobile = pd.getString("mobile");
        if(StringUtils.isEmpty(mobile)){
            model.putCode(1);
            model.putMsg("手机号不能为空！");
            return model;
        }
        if (mobile.trim().length() != 11) {
            model.putCode(1);
            model.putMsg("手机号长度错误！");
            return model;
        }

        mobile = mobile.trim();
        //手机号唯一性判断(vmes_employee:员工表)
        if (employeeService.isExistByMobile(null, mobile)) {
            model.putCode(1);
            model.putMsg("手机号:" + mobile + "在系统中已经存在，请核对后再次输入！");
            return model;
        }

        Post post = postService.selectById(postId);
        String  companyId = post.getCompanyId();

        //新增员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());

        //公司内部的工号唯一性校验
        PageData pdExist = new PageData();
        pdExist.putQueryStr("code = '"+employee.getCode()+"' and company_id = '"+companyId+"'");
        if(isExistColumn(pdExist)){
            model.putCode(3);
            model.putMsg("工号已存在，请重新输入！");
            return model;
        }
        employee.setMobile(mobile);
        employee.setCompanyId(companyId);
        employeeService.save(employee);
        //新增员工主岗信息
        EmployPost employPost = new EmployPost();
        employPost.setEmployId(employee.getId());
        employPost.setPostId(postId);
        employPost.setCuser(pd.getString("cuser"));
        employPost.setUuser(pd.getString("uuser"));
        employPost.setIsplurality("0");//主岗
        employPostService.save(employPost);

        //是否开通用户账号
        //isOpenUser 1:需要开通 0:无需开通
        String isOpenUser = (String)pd.get("isOpenUser");
        if (!"1".equals(isOpenUser)) {
            return model;
        }

        //新增用户信息
        String  deptId = post.getDeptId();
        pd.put("deptId",deptId);
        try {
            userService.createUserAndRole(pd,employee);
        }catch (RestException e){
            model.putCode(e.getCode());
            model.putMsg(e.getMessage());
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployeeAndUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 修改员工信息同时修改或新增用户信息（手机号，邮箱，角色）
     * @date 2018-08-02
     */
    @PostMapping("/employee/updateEmployeeAndUser")
    public ResultModel updateEmployeeAndUser()  throws Exception {

        logger.info("################employee/updateEmployeeAndUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String employeeId = (String)pd.get("employeeId");
        String mobile = pd.getString("mobile");

        if(StringUtils.isEmpty(mobile)){
            model.putCode(1);
            model.putMsg("手机号不能为空！");
            return model;
        }
        if (mobile.trim().length() != 11) {
            model.putCode(1);
            model.putMsg("手机号长度错误！");
            return model;
        }
        //手机号唯一性判断(vmes_employee:员工表)
        if (employeeService.isExistByMobile(employeeId, mobile)) {
            model.putCode(1);
            model.putMsg("手机号:" + mobile + "在系统中已经存在，请核对后再次输入！");
            return model;
        }

        //修改员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employee.setId(employeeId);

        mobile = mobile.trim();
        employee.setMobile(mobile);
        employeeService.update(employee);


        //获取员工主岗信息，找到当前员工所在部门
        //String employId = employee.getId();
        //employee = employeeService.selectById(employId);

        //判断是否拥有用户信息，如果没有则新增，如果有则修改
        String userId = employee.getUserId();
        if(StringUtils.isEmpty(userId)){
            //新增用户信息
            EmployPost employPost = getMainEmployPost(employeeId);
            Post post = postService.selectById(employPost.getPostId());
            String deptId = post.getDeptId();
            pd.put("deptId",deptId);
            try {
                userService.createUserAndRole(pd,employee);
            }catch (RestException e){
                model.putCode(e.getCode());
                model.putMsg(e.getMessage());
                return model;
            }
        }else {
            //修改用户信息
            User user = userService.selectById(userId);
            user.setEmail(employee.getEmail());
            user.setEmployId(employee.getId());
            user.setMobile(employee.getMobile());
            user.setUuser(pd.getString("uuser"));

            String roleId = (String)pd.get("roleId");
            if (roleId != null && roleId.trim().length() > 0) {
                //删除(用户id, 角色id)-(vmes_user_role:用户角色)
                Map columnMap = new HashMap();
                columnMap.put("user_id", userId);
                columnMap.put("role_id", roleId);
                userRoleService.deleteByColumnMap(columnMap);

                //新增用户角色信息
                UserRole userRole = new UserRole();
                userRole.setRoleId(pd.getString("roleId"));
                userRole.setUserId(user.getId());
                userRole.setCuser(pd.getString("cuser"));
                userRole.setUuser(pd.getString("uuser"));
                userRoleService.save(userRole);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateEmployeeAndUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/employee/updateDisableEmployee")
    public ResultModel updateDisableEmployee()  throws Exception {
        logger.info("################employee/updateDisableEmployee 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //id:主键id-(vmes_employ:员工岗位表)
        String employeeId = (String)pageData.get("employeeId");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (employeeId == null || employeeId.trim().length() == 0) {
            msgStr = msgStr + "员工id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        Employee employDB = employeeService.findEmployeeById(employeeId);
        employDB.setIsdisable(isdisable);
        employDB.setUuser(pageData.getString("uuser"));
        employeeService.update(employDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateDisableEmployee 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威  禁用员工信息包含主岗兼岗，同时禁用员工账号（支持批量删除，不支持物理删除）
     * @date 2018-08-02
     */
    @PostMapping("/employee/deleteEmployees")
    public ResultModel deleteEmployees()  throws Exception {
        logger.info("################employee/deleteEmployees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String employeeIds = pd.getString("employeeIds");
        if (employeeIds == null || employeeIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        //去除相同的id
        Map<String, String> mapTemp = new HashMap<String, String>();
        String[] idArray = employeeIds.split(",");
        for (String id : idArray) {
            mapTemp.put(id, id);
        }

        int i = 0;
        String[] idNewArry = new String[mapTemp.size()];
        for (Iterator iterator = mapTemp.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();
            idNewArry[i] = mapKey;
            i = i + 1;
        }

        //禁用员工信息
        employeeService.updateToDisableByIds(idNewArry);
        //禁用用户信息
        userService.updateToDisableByEmployIds(idNewArry);
        //禁用用户岗位信息
        employPostService.updateToDisableByEmployIds(idNewArry);

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/deleteEmployees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威  单独启用禁用员工信息包含主岗兼岗，同时禁用员工账号
     * @date 2018-08-02
     */
    @PostMapping("/employee/updateEmployeePostState")
    public ResultModel updateEmployeePostState()  throws Exception {

        logger.info("################employee/updateEmployeePostState 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String isplurality = pd.getString("isplurality");
        if(StringUtils.isEmpty(isplurality) ){
            model.putCode(1);
            model.putMsg("是否兼岗不能为空！");
            return model;
        }
        String isdisable = pd.getString("isdisable");
        if(StringUtils.isEmpty(isdisable) ){
            model.putCode(2);
            model.putMsg("是否禁用不能为空！");
            return model;
        }
        String employPostId = pd.getString("employPostId");
        if(StringUtils.isEmpty(employPostId) ){
            model.putCode(3);
            model.putMsg("员工岗位ID不能为空！");
            return model;
        }
        EmployPost employPost = employPostService.selectById(employPostId);
        Employee employee = employeeService.selectById(employPost.getEmployId());
        User user = userService.selectById(employee.getUserId());
        String[] employIds = new String[1];
        employIds[0] = employPost.getEmployId();
        employPost.setIsdisable(isdisable);
        employPost.setUuser(pd.getString("uuser"));
        employee.setIsdisable(isdisable);
        employee.setUuser(pd.getString("uuser"));
        user.setIsdisable(isdisable);
        user.setUuser(pd.getString("uuser"));
        //如果是兼岗，只需要禁用开启当前兼岗即可
        if ("1".equals(isplurality)){
            employPostService.update(employPost);
        }
        //如果是主岗，只需要禁用的同时要禁用兼岗、员工、用户，启用时只需启用主岗
        else {
            if("0".equals(isdisable)){
                employee.setLeaveDate(new Date());//设置离职日期
                employPostService.updateToDisableByEmployIds(employIds);//同时禁用该员工的主岗和兼岗
            }else {
                employPostService.update(employPost);//启用员工主岗
            }
            employeeService.update(employee);//禁用启用员工
            userService.update(user);//禁用启用用户
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateEmployeePostState 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 变更员工岗位（只变更主岗，先禁用后新增）（支持批量操作）
     * @author 刘威
     * @date 2018-08-02
     */
    @PostMapping("/employee/updateForChangeEmployeePost")
    public ResultModel updateForChangeEmployeePost()  throws Exception {

        logger.info("################employee/updateForChangeEmployeePost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String employPosts = pd.getString("employPosts");

//        employPosts ="[{\"employPostId\":\"3\",\"postId\":\"1\"}," +
//                "{\"employPostId\":\"3\",\"postId\":1532599975000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532601003000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532600923000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532600802000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532601034000}]";

        List employPostsList = YvanUtil.jsonToList(employPosts);
        if(employPostsList!=null&&employPostsList.size()>0){
            for(int i=0;i<employPostsList.size();i++){
                Map employPostsMap = (Map)employPostsList.get(i);
                if(employPostsMap!=null){
                    if(employPostsMap.get("employPostId")!=null && employPostsMap.get("postId")!=null){
                        //先禁用
                        EmployPost employPost = employPostService.selectById(employPostsMap.get("employPostId").toString());
                        employPost.setIsdisable("0");
                        employPost.setUuser(pd.getString("uuser"));
                        employPostService.update(employPost);
                        //后新增
                        EmployPost employPostNew = new EmployPost();
                        employPostNew.setPostId(employPostsMap.get("postId").toString());
                        employPostNew.setEmployId(employPost.getEmployId());
                        employPostNew.setIsplurality(employPost.getIsplurality());
                        employPostNew.setCuser(pd.getString("cuser"));
                        employPostNew.setUuser(pd.getString("uuser"));
                        employPostService.save(employPost);
                    }
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateForChangeEmployeePost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     *  开通员工用户账号（支持批量操作）
     * @author 刘威
     * @date 2018-08-02
     */
    @PostMapping("/employee/")
    public ResultModel addEmployToUser()  throws Exception {
//        employRoles ="[{\"employId\":\"3\",\"roleId\":\"1\"}," +
//                "{\"employId\":\"3\",\"roleId\":1532599975000}," +
//                "{\"employId\":\"3\",\"roleId\":1532601003000}," +
//                "{\"employId\":\"3\",\"roleId\":1532600923000}," +
//                "{\"employId\":\"3\",\"roleId\":1532600802000}," +
//                "{\"employId\":\"3\",\"roleId\":1532601034000}]";

        logger.info("################employee/addEmployToUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        StringBuffer msg = new StringBuffer();
        int success = 0;
        int error = 0;

        String employRoles = pd.getString("employRoles");
        if (employRoles == null || employRoles.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List employRolesList = YvanUtil.jsonToList(employRoles);
        if (employRolesList == null || employRolesList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        //去除相同的员工ID
        Map mapTemp = new HashMap();
        for(int i=0;i<employRolesList.size();i++) {
            Map employRolesMap = (Map)employRolesList.get(i);
            String employeeId = (String)employRolesMap.get("employeeId");
            if (employeeId != null && employeeId.trim().length() > 0) {
                mapTemp.put(employeeId, employRolesMap);
            }
        }

        List empRolesList = new ArrayList();
        for (Iterator iterator = mapTemp.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();
            Map mapValue = (Map)mapTemp.get(mapKey);
            if (mapValue != null && mapValue.size() > 0) {
                empRolesList.add(mapValue);
            }
        }

        for(int i=0;i<empRolesList.size();i++){
            Map employRolesMap = (Map)employRolesList.get(i);
            if(employRolesMap!=null){
                if(employRolesMap.get("employeeId")!=null && employRolesMap.get("roleId")!=null){
                    Employee employee = employeeService.selectById(employRolesMap.get("employeeId").toString());
                    String msgHeader = "员工："+employee.getName()+"("+employee.getCode()+")    ";
                    //判断当前员工是否已经拥有账号信息，如果没有则新增，如果有则提示已存在
                    if(StringUtils.isEmpty(employee.getUserId())){
                        //获取当前员工主岗信息
                        EmployPost employPost = getMainEmployPost(employee.getId());
                        Post post = postService.selectById(employPost.getPostId());
                        String deptId = post.getDeptId();
                        pd.put("deptId",deptId);
                        pd.put("roleId",employRolesMap.get("roleId").toString());
                        try {
                            //新增用户信息
                            userService.createUserAndRole(pd,employee);
                            msg.append(msgHeader+"创建账号成功！");
                            success = success + 1;
                        }catch (RestException e){
                            msg.append(msgHeader+"创建账号失败，失败原因如下："+e.getMessage());
                            error = error + 1;
                        }
                    }else {
                        msg.append(msgHeader+"创建账号失败，失败原因如下：当前员工账号已存在");
                        error = error + 1;
                    }
                }
            }
        }
        msg.append("合计： 创建成功"+success+"个,创建失败"+error+"个");
        model.putMsg(msg.toString());
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployToUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 设置员工兼岗（支持批量操作）
     * @author 刘威
     * @date 2018-08-02
     */
    @PostMapping("/employee/addEmployeePluralityPost")
    public ResultModel addEmployeePluralityPost()  throws Exception {
        logger.info("################employee/addEmployeePluralityPost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        String employeeId = (String)pageData.get("employeeId");
        String postIds = (String)pageData.get("postIds");

        String msgStr = new String();
        if (employeeId == null || employeeId.trim().length() == 0) {
            msgStr = msgStr + "员工id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (postIds == null || postIds.trim().length() == 0) {
            msgStr = msgStr + "岗位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //当前员工id-岗位id字符串-中是否含有主岗
        if (employPostService.checkEmployMainPostByPostIds(employeeId, postIds)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前选择的兼岗中含有主岗，请核对后再次操作！");
            return model;
        }

        //1. 删除(员工id, 兼岗)(vmes_employ_post)数据
        Map columnMap = new HashMap();
        columnMap.put("employ_id", employeeId);
        //是否兼岗(1:兼岗0:主岗)
        columnMap.put("isplurality", "1");
        employPostService.deleteByColumnMap(columnMap);

        postIds = StringUtil.stringTrimSpace(postIds);
        String[] postIdArry = postIds.split(",");
        for(int i = 0; i < postIdArry.length; i++){
            String postId = postIdArry[i];
            //新增员工兼岗信息
            EmployPost employPost = new EmployPost();
            employPost.setEmployId(employeeId);
            employPost.setPostId(postId);
            employPost.setCuser(pageData.getString("cuser"));
            //是否兼岗(1:兼岗0:主岗)
            employPost.setIsplurality("1");
            employPostService.save(employPost);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployeePluralityPost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 1. 员工id查询(vmes_employ_post)主岗-表对象
     * 2. 如果存在(员工id, old岗位id)设置禁用
     * 3. 插入数据(员工id, new岗位id)设置主岗
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/employee/addEmployeeMainPost")
    public ResultModel addEmployeeMainPost()  throws Exception {
        logger.info("################employee/addEmployeeMainPost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        String employeeId = (String)pageData.get("employeeId");
        String postId = (String)pageData.get("postId");

        String msgStr = new String();
        if (employeeId == null || employeeId.trim().length() == 0) {
            msgStr = msgStr + "员工id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (postId == null || postId.trim().length() == 0) {
            msgStr = msgStr + "岗位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //员工id查询(vmes_employ_post)主岗
        EmployPost mainEmployPost = employPostService.findMainEmployPost(employeeId);
        if (mainEmployPost != null && postId.equals(mainEmployPost.getPostId())) {
            return model;
        } else if (mainEmployPost != null && !postId.equals(mainEmployPost.getPostId())) {
            //是否禁用(0:已禁用 1:启用)
            mainEmployPost.setIsdisable("0");
            mainEmployPost.setUuser(pageData.getString("uuser"));
            employPostService.update(mainEmployPost);
        }

        //删除(员工id, 岗位id, 兼岗)-(vmes_employ_post)表记录
        Map columnMap = new HashMap();
        columnMap.put("employ_id", employeeId);
        columnMap.put("post_id", postId);
        //是否兼岗(1:兼岗0:主岗)
        columnMap.put("isplurality", "1");
        employPostService.deleteByColumnMap(columnMap);

        //2. 插入数据(员工id, new岗位id)设置主岗
        EmployPost newEmployPost = new EmployPost();
        newEmployPost.setEmployId(employeeId);
        newEmployPost.setPostId(postId);
        //是否兼岗(1:兼岗0:主岗)
        newEmployPost.setIsplurality("0");
        newEmployPost.setCuser(pageData.getString("cuser"));
        employPostService.save(newEmployPost);

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployeeMainPost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 员工信息列表查询分页
     * @date 2018-07-26
     */
    @PostMapping("/employee/listPageEmployees")
    public ResultModel listPageEmployees()  throws Exception {

        logger.info("################employee/listPageEmployees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("employee");
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

        String id = (String)pd.get("id");
        String type = (String)pd.get("type");

        //"dept" 部门 "post" 岗位
        if ("dept".equals(type)) {
            Integer layerInt = null;
            String layer = pd.getString("layer");
            if (layer != null && layer.trim().length() > 0) {
                try {
                    layerInt = Integer.parseInt(layer.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            String queryStr = departmentService.findDeptidById(id, layerInt, "dept.");
            if (queryStr != null && queryStr.trim().length() > 0) {
                pd.put("deptQueryStr", queryStr);
            }
        } else if ("post".equals(type)) {
            pd.put("postId", id);

        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = employeeService.getDataListPage(pd, pg);
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
        logger.info("################employee/listPageEmployees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    @GetMapping("/employee/exportExcelEmployees")
    public void exportExcelEmployees() throws Exception {
        logger.info("################employee/exportExcelEmployees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryColumn = pd.getString("queryColumn");
        List<Column> columnList = columnService.findColumnList("employee");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //3. 根据查询条件获取业务数据List
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        if (queryColumn != null && queryColumn.trim().length() > 0) {
            queryStr = queryStr + queryColumn;
        }

        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        //分页参数默认设置100000
        pg.setSize(100000);

        List<Map> dataList = employeeService.getDataListPage(pd,pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelEmployee";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/exportExcelEmployees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/employee/exportExcelUsers")
    public void exportExcelUsers()  throws Exception {

        logger.info("################employee/exportExcelUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = employeeService.getColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = employeeService.getDataList(pd);
                request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/exportExcelUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }



    /**
     * @author 刘威 通过ID查询
     * @date 2018-07-26
     */
    @PostMapping("/employee/selectEmployeeAndUserById/{employPostId}")
    public ResultModel selectEmployeeAndUserById(@PathVariable("employPostId") String employPostId)  throws Exception {

        logger.info("################employee/selectEmployeeAndUserById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        if(StringUtils.isEmpty(employPostId)){
            model.putCode(1);
            model.putMsg("查询失败，参数employPostId为空！");
            return model;
        }

        PageData pd = new PageData();
        pd.put("employPostId",employPostId);
        Map result = new HashMap();
        List<Map> varList = employeeService.selectEmployeeAndUserById(pd);
        if(varList!=null&&varList.size()>0){
            result.put("varList",varList.get(0));
            model.putResult(result);
        }else{
            model.putCode(2);
            model.putMsg("没有查询到数据！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/selectEmployeeAndUserById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



