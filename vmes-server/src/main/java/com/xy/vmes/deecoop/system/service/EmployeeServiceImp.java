package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.system.dao.EmployeeMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_employee:员工管理 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-02
*/
@Service
@Transactional(readOnly = false)
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployPostService employPostService;
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private ColumnService columnService;
    @Autowired
    private EmployeeExcelService employeeExcelService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void save(Employee employee) throws Exception{
        employee.setId(Conv.createUuid());
        employee.setCdate(new Date());
        employee.setUdate(new Date());
        employeeMapper.insert(employee);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void update(Employee employee) throws Exception{
        employee.setUdate(new Date());
        employeeMapper.updateById(employee);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public void updateAll(Employee employee) throws Exception{
        employee.setUdate(new Date());
        employeeMapper.updateAllColumnById(employee);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    //@Cacheable(cacheNames = "employee", key = "''+#id")
    public Employee selectById(String id) throws Exception{
        return employeeMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteById(String id) throws Exception{
        employeeMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        employeeMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> dataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> dataList(PageData pd) throws Exception{
        return employeeMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return employeeMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return employeeMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        employeeMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> selectByColumnMap(Map columnMap) throws Exception{
    List<Employee> employeeList =  employeeMapper.selectByMap(columnMap);
        return employeeList;
    }


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return employeeMapper.getColumnList();
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return employeeMapper.getDataList(pd);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        employeeMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：刘威
     * 创建时间：2018-08-06
     */
    @Override
    public List<Map> selectEmployeeAndUserById(PageData pd) throws Exception{
        return employeeMapper.selectEmployeeAndUserById(pd);
    }

    public Employee findEmployee(PageData object) {
        if (object == null) {return null;}

        List<Employee> objectList = this.findEmployeeList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public List<Employee> findEmployeeList(PageData object) {
        if (object == null) {return null;}

        List<Employee> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public Employee findEmployeeById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Employee> objectList = this.findEmployeeList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    public boolean isExistByCode(String id, String code,String companyId) {
        if (code == null || code.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("code", code);
        findMap.put("currentCompanyId",companyId);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Employee> objectList = this.findEmployeeList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public boolean isExistByMobile(String id, String mobile) {
        if (mobile == null || mobile.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mobile", mobile);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Employee> objectList = this.findEmployeeList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    @Override
    public ResultModel addEmployeeAndUser(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
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
            model.putMsg("手机号:" + mobile + "在员工管理中已经存在，请核对后再次输入！");
            return model;
        }
        if (userService.isExistByMobile(null, mobile)) {
            model.putCode(1);
            model.putMsg("手机号:" + mobile + "在用户管理中已经存在，请核对后再次输入！");
            return model;
        }

        Post post = postService.selectById(postId);
        String companyId = post.getCompanyId();

        //新增员工信息
        String roleId = pd.getString("roleId");
        Employee employee = (Employee) HttpUtils.pageData2Entity(pd, new Employee());
        if ("1".equals(employee.getIsOpenUser()) && (roleId == null || roleId.trim().length() == 0) ) {
            model.putCode(1);
            model.putMsg("角色名称为空，角色名称为必填项不可为空！" );
            return model;
        }

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
        //isOpenUser 1:需要开通 0:无需开通 is null
        if (!"1".equals(employee.getIsOpenUser())) {
            return model;
        }

        //新增用户信息
        String deptId = post.getDeptId();
        pd.put("deptId",deptId);
//        try {
//            userService.createUserAndRole(pd,employee);
//        }catch (RestException e){
//            model.putCode(e.getCode());
//            model.putMsg(e.getMessage());
//            return model;
//        }
        model = userService.createUserAndRole(pd,employee);
        if(((Integer)model.get("code")).intValue()!=0){
            return model;
        }
        return model;
    }

    @Override
    public ResultModel updateEmployeeAndUser(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String employeeId = (String)pd.get("employeeId");
        String userId = (String)pd.get("userId");
        String mobile = pd.getString("mobile");
        String code = pd.getString("code");
        String companyId = pd.getString("companyId");
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
        if (this.isExistByCode(employeeId, code,companyId)) {
            model.putCode(2);
            model.putMsg("员工号:" + code + "在系统中已经存在，请核对后再次输入！");
            return model;
        }
        //手机号唯一性判断(vmes_employee:员工表)
        if (this.isExistByMobile(employeeId, mobile)) {
            model.putCode(1);
            model.putMsg("手机号:" + mobile + "在员工管理中已经存在，请核对后再次输入！");
            return model;
        }
        if(!StringUtils.isEmpty(userId)){
            if (userService.isExistByMobile(userId, mobile)) {
                model.putCode(1);
                model.putMsg("手机号:" + mobile + "在用户管理中已经存在，请核对后再次输入！");
                return model;
            }
        }


        String roleId = pd.getString("roleId");
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        if ("1".equals(employee.getIsOpenUser()) && (roleId == null || roleId.trim().length() == 0) ) {
            model.putCode(1);
            model.putMsg("角色名称为空，角色名称为必填项不可为空！" );
            return model;
        }

        //修改员工信息
        employee.setId(employeeId);
        mobile = mobile.trim();
        employee.setMobile(mobile);

        if (employee.getRemark() == null || employee.getRemark().trim().length() == 0) {
            employee.setRemark("");
        }

        employeeService.update(employee);

        //获取员工主岗信息，找到当前员工所在部门
        //String employId = employee.getId();
        //employee = employeeService.selectById(employId);

        //判断是否拥有用户信息，如果没有则新增，如果有则修改
        userId = employee.getUserId();
        if(StringUtils.isEmpty(userId)){
            //新增用户信息
            EmployPost employPost = getMainEmployPost(employeeId);
            Post post = postService.selectById(employPost.getPostId());
            String deptId = post.getDeptId();
            pd.put("deptId",deptId);
//            try {
//                userService.createUserAndRole(pd,employee);
//            }catch (RestException e){
//                model.putCode(e.getCode());
//                model.putMsg(e.getMessage());
//                return model;
//            }
            model = userService.createUserAndRole(pd,employee);
            if(((Integer)model.get("code")).intValue()!=0){
                return model;
            }
        }else {
            //修改用户信息
            User user = userService.selectById(userId);
            user.setEmail(employee.getEmail());
            user.setEmployId(employee.getId());
            user.setMobile(employee.getMobile());
            user.setUuser(pd.getString("uuser"));
            userService.update(user);
            //String roleId = (String)pd.get("roleId");
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
        return model;
    }

    @Override
    public ResultModel updateDisableEmployee(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //id:主键id-(vmes_employ:员工岗位表)
        String employeeId = (String)pageData.get("employeeId");
        String isdisable = (String)pageData.get("isdisable");
        String id = (String)pageData.get("id");
        //String userId = (String)pageData.get("userId");


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

//        //员工离职
//        if("0".equals(isdisable)) {
//            //获取员工下全部岗位
//            PageData fineMap = new PageData();
//            fineMap.put("employId", employeeId);
//            fineMap.put("mapSize", Integer.valueOf(fineMap.size()));
//            List<EmployPost> postList = employPostService.findEmployPostList(fineMap);
//            for (EmployPost post : postList) {
//                EmployPost postEdit = new EmployPost();
//                postEdit.setId(post.getId());
//                postEdit.setIsdisable(isdisable);
//                employPostService.update(postEdit);
//            }
//        } else if ("1".equals(isdisable)) {
//            //获取员工下全部岗位
//            PageData fineMap = new PageData();
//            fineMap.put("employId", employeeId);
//            //是否兼岗(1:兼岗0:主岗)
//            fineMap.put("isplurality", "1");
//            fineMap.put("mapSize", Integer.valueOf(fineMap.size()));
//            EmployPost post = employPostService.findEmployPost(fineMap);
//            if (post != null) {
//                EmployPost postEdit = new EmployPost();
//                postEdit.setId(post.getId());
//                postEdit.setIsdisable(isdisable);
//                employPostService.update(postEdit);
//            }
//        }

        Employee employDB = employeeService.findEmployeeById(employeeId);
        Employee employeeEdit = new Employee();
        employeeEdit.setId(employDB.getId());
        employeeEdit.setIsdisable(isdisable);
        employeeEdit.setUuser(pageData.getString("uuser"));
        employeeService.update(employeeEdit);

        if (employDB != null && employDB.getUserId() != null && employDB.getUserId().trim().length() > 0) {
            String userId = employDB.getUserId().trim();

            User userEdit = new User();
            userEdit.setId(userId);
            userEdit.setIsdisable(isdisable);
            userEdit.setUuser(pageData.getString("uuser"));
            userService.update(userEdit);
        }

        return model;
    }

    @Override
    public ResultModel deleteEmployees(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
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

//        //禁用员工信息
//        employeeService.updateToDisableByIds(idNewArry);
//        //禁用用户信息
//        userService.updateToDisableByEmployIds(idNewArry);
//        //禁用用户岗位信息
//        employPostService.updateToDisableByEmployIds(idNewArry);

        for (int j = 0; j < idNewArry.length; j++) {
            String employId = idNewArry[j];

            //1. 删除(vmes_employ_post)员工岗位表
            employPostService.deleteEmployPostByEmployId(employId);

            //根据员工id查询(vmes_employee)-获取当前员工用户id
            String userId = "";
            Employee employee = employeeService.findEmployeeById(employId);
            if (employee != null && employee.getUserId() != null && employee.getUserId().trim().length() > 0) {
                userId = employee.getUserId().trim();

                //2. 删除(vmes_user)用户表
                userService.deleteById(userId);

                //3. 删除(vmes_user_role)用户角色表
                userRoleService.deleteUserRoleByUserId(userId);
            }
        }

        //4. 删除(vmes_employee)员工表
        employeeService.deleteByIds(idNewArry);
        return model;
    }

    public ResultModel deleteEmployeeByPost(PageData pd)throws Exception {
        ResultModel model = new ResultModel();
        String employeePostIds = pd.getString("employeePostIds");
        if (employeePostIds == null || employeePostIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        employeePostIds = StringUtil.stringTrimSpace(employeePostIds);
        String[] idArray = employeePostIds.split(",");
        for (int i = 0; i < idArray.length; i++) {
            String employeePostId = idArray[i];
            employPostService.deleteById(employeePostId);
        }

        return model;
    }

    @Override
    public ResultModel updateEmployeePostState(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }

    @Override
    public ResultModel updateForChangeEmployeePost(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }

    @Override
    public ResultModel addEmployToUser(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

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
                            //新增用户信息
                        model = userService.createUserAndRole(pd,employee);
                        if(((Integer)model.get("code")).intValue()!=0){
                            msg.append(msgHeader+"创建账号失败，失败原因如下："+model.get("msg"));
                            error = error + 1;
                        }else{
                            msg.append(msgHeader+"创建账号成功！");
                            success = success + 1;
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
        return model;
    }

    @Override
    public ResultModel addEmployeePluralityPost(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }

    @Override
    public ResultModel addEmployeeMainPost(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }

    @Override
    public ResultModel listPageEmployees(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
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

        String id = pd.getString("id");
        String type = pd.getString("type");

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

        //默认isdisable:=1
        pd.put("isdisable", Common.SYS_DEFAULT_ISDISABLE_1);
        String isdisableByQuery = pd.getString("isdisableByQuery");
        if (isdisableByQuery != null && isdisableByQuery.trim().length() > 0) {
            pd.put("isdisable", isdisableByQuery);
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
        return model;
    }

    @Override
    public void exportExcelEmployees(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("employee");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List

        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "employpost.id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);


        pg.setSize(100000);
        List<Map> dataList = employeeService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelEmployee";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);

    }

    @Override
    public ResultModel selectEmployeeAndUserById(String employPostId) throws Exception {
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
        return model;
    }

    public ResultModel importExcelEmployee(MultipartFile file) throws Exception {
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

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        //去掉列表名称行
        dataMapLst.remove(0);

        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = employeeExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                userId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(this.exportExcelError(msgStr).toString());
            return model;
        }

        //2. Excel导入字段唯一性判断-在Excel文件中
        msgStr = employeeExcelService.checkExistImportExcelBySelf(dataMapLst,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(this.exportExcelError(msgStr).toString());
            return model;
        }

        //3. Excel导入字段唯一性判断-在业务表中判断
        msgStr = employeeExcelService.checkExistImportExcelByDatabase(dataMapLst,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(this.exportExcelError(msgStr).toString());
            return model;
        }

        //4. Excel数据添加到货品表
        employeeExcelService.addImportExcelByList(dataMapLst);

        return model;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private StringBuffer exportExcelError(String msgStr) {
        StringBuffer msgBuf = new StringBuffer();
        msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
        msgBuf.append(msgStr.trim());
        msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

        return msgBuf;
    }

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
        //是否兼岗(1:兼岗0:主岗)
        columnMap.put("isplurality","0");
        //是否禁用(0:已禁用 1:启用)
        columnMap.put("isdisable","1");
        List<EmployPost> employPostList = employPostService.selectByColumnMap(columnMap);
        if(employPostList!=null&&employPostList.size()>0){
            return employPostList.get(0);
        }
        return null;
    }
}



