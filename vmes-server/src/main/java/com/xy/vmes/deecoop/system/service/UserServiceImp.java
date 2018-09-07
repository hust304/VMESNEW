package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.UserMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.EmployeeService;
import com.xy.vmes.service.UserRoleService;
import com.xy.vmes.service.UserService;
import com.yvan.Conv;
import com.xy.vmes.common.util.Common;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_user:系统用户表 实现类
 * 创建人：刘威 自动创建
 * 创建时间：2018-07-26
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImp implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public void save(User user) throws Exception{
        user.setId(Conv.createUuid());
        user.setCdate(new Date());
        user.setUdate(new Date());
        userMapper.insert(user);
    }


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public void update(User user) throws Exception{
        user.setUdate(new Date());
//        userMapper.updateById(user);
        userMapper.updateAllColumnById(user);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    //@Cacheable(cacheNames = "user", key = "''+#id")
    public User selectById(String id) throws Exception{
        return userMapper.selectById(id);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public void deleteById(String id) throws Exception{
        userMapper.deleteById(id);
    }


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public List<User> dataListPage(PageData pd,Pagination pg) throws Exception{
        return userMapper.dataListPage(pd,pg);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public List<User> dataList(PageData pd) throws Exception{
        return userMapper.dataList(pd);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return userMapper.findColumnList();
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return userMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/




    /**
     * 创建人：刘威
     * 创建时间：2018-07-23
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        userMapper.deleteByIds(ids);
    }

//    /**
//     * 生成用户编码
//     *
//     * 创建人：陈刚
//     * 创建时间：2018-07-26
//     *
//     * @param companyID  公司ID-组织架构ID
//     * @return
//     */
//    @Override
//    public String createCoder(String companyID) {
//        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
//        //(企业编号+无需+无需+流水号)-W000142
//        CoderuleEntity object = new CoderuleEntity();
//        //tableName 业务名称(表名)
//        object.setTableName("vmes_user");
//        //companyID 公司ID
//        object.setCompanyID(companyID);
//        //length 指定位数(6)
//        object.setLength(Integer.valueOf(6));
//        //firstName 第一个编码名称
//        object.setFirstName("company");
//
//        //separator 分隔符
//        //object.setSeparator("-");
//        //filling 填充字符(0)
//        object.setFilling(Common.CODE_RULE_DEFAULT_FILLING);
//
//        //isNeedCompany 是否需要企业编号
//        object.setIsNeedCompany(Boolean.TRUE);
//
//        return coderuleService.findCoderule(object);
//    }



    /**
     * 判断用户手机号是否存在
     *
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public boolean isExistMobile(PageData pd) throws Exception{
        List<User> userList = userMapper.isExistMobile(pd);
        if(userList!=null&&userList.size()>0){
            return true;
        }
        return false;
    }


    /**
     * 批量修改用户信息为禁用状态
     *
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public void updateToDisableByIds(String[] ids) throws Exception{
        userMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-08-03
     */
    @Override
    public void  updateToDisableByEmployIds(String[] ids) throws Exception{
        userMapper.updateToDisableByEmployIds(ids);
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return userMapper.getColumnList();
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return userMapper.getDataList(pd);
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-07-26
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return userMapper.getDataListPage(pd,pg);
    }


    /**
     * 创建人：刘威
     * 创建时间：2018-08-03
     */
    @Override
    public void createUserAndRole(PageData pd, Employee employee ) throws Exception {
        String roleId = pd.getString("roleId");
        if(!StringUtils.isEmpty(roleId)){
            User user = new User();
            if(isExistMobile(pd)){
                throw  new RestException("10","用户中该手机号已存在，请修改手机号！");
            }
            String code = coderuleService.createCoder(employee.getCompanyId(),"vmes_user");
            if(StringUtils.isEmpty(code)){
                throw  new RestException("11","编码规则创建异常，请重新操作！");
            }
            user.setUserCode(code);
            user.setUserName(employee.getName());
            user.setCompanyId(employee.getCompanyId());
            user.setDeptId(pd.getString("deptId"));
            user.setEmail(employee.getEmail());
            user.setEmployId(employee.getId());
            user.setMobile(employee.getMobile());
            //用户类型(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
            user.setUserType(Common.DICTIONARY_MAP.get("userType_employee"));
            user.setCuser(pd.getString("cuser"));
            user.setUuser(pd.getString("uuser"));
            //使用手机号后六位进行加密作为默认密码
            String mobile = employee.getMobile();
            String password = mobile.substring(mobile.length()-6,mobile.length());
            user.setPassword(MD5Utils.MD5(password));
            save(user);

            //修改员工表用户ID
            employee.setUserId(user.getId());
            employeeService.update(employee);

            //新增用户角色信息
            UserRole userRole = new UserRole();
            userRole.setRoleId(pd.getString("roleId"));
            userRole.setUserId(user.getId());
            userRole.setCuser(pd.getString("cuser"));
            userRole.setUuser(pd.getString("uuser"));
            userRoleService.save(userRole);
        }
    }

    public User findUser(PageData object) {
        if (object == null) {return null;}

        List<User> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public List<User> findUserList(PageData object) {
        if (object == null) {return null;}

        List<User> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    /**
     * 获取企业管理员
     *
     * @param companyID  企业id
     * @return
     */
    public User findCompanyAdmin(String companyID) {
        if (companyID == null || companyID.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("companyId", companyID);
        //数据字典  userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户
        findMap.put("userType", Common.DICTIONARY_MAP.get("userType_company"));
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findUser(findMap);
    }

    /**
     * 批量修改(企业管理员)为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-08-06
     */
    public void updateDisableByCompanyIds(String[] companyIds) {
        userMapper.updateDisableByCompanyIds(companyIds);
    }

    /**
     * 获取企业当前用户数及用户总数
     * 创建人：刘威
     * @param pd
     * @return
     */
    public List<Map> selectCountUserNum(PageData pd) throws Exception{
        return  userMapper.selectCountUserNum(pd);
    }
}



