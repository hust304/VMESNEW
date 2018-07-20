package com.xy.vmes.entity;

import java.util.Date;

/**
 * 创建人：陈刚
 * 创建时间：2018-07-20
 */
public class ViewVmesUserEmployee {
    private String id;

    //--vmes_user:系统用户表--//
    private String user_id;
    //员工ID
    private String user_employId;
    //公司ID-组织架构
    private String user_companyId;
    //账号(系统登录账号)
    private String user_userCode;
    //密码(MD5加密)
    private String password;

    //用户微信ID
    private String openId;
    //姓名
    private String userName;
    //是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
    private String user_isdisable;
    //创建时间
    private Date user_cdate;
    //创建人账号
    private String user_cuser;

    //修改时间
    private Date user_udate;
    //修改人账号
    private String user_uuser;
    //预留字段
    private String user_column1;
    //预留字段
    private String user_column2;
    //预留字段
    private String user_column3;

    ////////////////////////////////////////////////////////////////
    //--vmes_employee:员工表--//
    private String employ_id;
    //系统用户ID
    private String employ_userId;
    //公司ID-组织架构
    private String employ_companyId;
    //员工编号
    private String employ_code;
    //员工类型 数据字典:sys_employee_type
    private String employ_type;

    //员工姓名
    private String employ_name;
    //员工英文名
    private String employ_nameEn;
    //员工照片
    private String photo;
    //员工图片
    private String icon;
    //手机号码
    private String mobile;

    //邮箱地址
    private String email;
    //性别(1:男0:女) 数据字典:sys_employee_sex
    private String sex;
    //出生日期(yyyy-mm-dd)
    private Date birthday;
    //入职日期(yyyy-mm-dd)
    private Date entryDate;
    //籍贯
    private String nativePlace;

    //政治面貌 数据字典:sys_employee_political
    private String political;
    //身份证号
    private String identityNumber;
    //婚姻状况(1:已婚 0:未婚) 数据字典:sys_employee_marital
    private String marital;
    //是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
    private String employ_isdisable;
    //创建时间
    private Date employ_cdate;

    //创建人账号
    private String employ_cuser;
    //修改时间
    private Date employ_udate;
    //修改人账号
    private String employ_uuser;
    //预留字段
    private String employ_column1;
    //预留字段
    private String employ_column2;

    //预留字段
    private String employ_column3;
//////////////////////////////////////////////////////////////////////////////////////

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_employId() {
        return user_employId;
    }

    public void setUser_employId(String user_employId) {
        this.user_employId = user_employId;
    }

    public String getUser_companyId() {
        return user_companyId;
    }

    public void setUser_companyId(String user_companyId) {
        this.user_companyId = user_companyId;
    }

    public String getUser_userCode() {
        return user_userCode;
    }

    public void setUser_userCode(String user_userCode) {
        this.user_userCode = user_userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_isdisable() {
        return user_isdisable;
    }

    public void setUser_isdisable(String user_isdisable) {
        this.user_isdisable = user_isdisable;
    }

    public Date getUser_cdate() {
        return user_cdate;
    }

    public void setUser_cdate(Date user_cdate) {
        this.user_cdate = user_cdate;
    }

    public String getUser_cuser() {
        return user_cuser;
    }

    public void setUser_cuser(String user_cuser) {
        this.user_cuser = user_cuser;
    }

    public Date getUser_udate() {
        return user_udate;
    }

    public void setUser_udate(Date user_udate) {
        this.user_udate = user_udate;
    }

    public String getUser_uuser() {
        return user_uuser;
    }

    public void setUser_uuser(String user_uuser) {
        this.user_uuser = user_uuser;
    }

    public String getUser_column1() {
        return user_column1;
    }

    public void setUser_column1(String user_column1) {
        this.user_column1 = user_column1;
    }

    public String getUser_column2() {
        return user_column2;
    }

    public void setUser_column2(String user_column2) {
        this.user_column2 = user_column2;
    }

    public String getUser_column3() {
        return user_column3;
    }

    public void setUser_column3(String user_column3) {
        this.user_column3 = user_column3;
    }

    public String getEmploy_id() {
        return employ_id;
    }

    public void setEmploy_id(String employ_id) {
        this.employ_id = employ_id;
    }

    public String getEmploy_userId() {
        return employ_userId;
    }

    public void setEmploy_userId(String employ_userId) {
        this.employ_userId = employ_userId;
    }

    public String getEmploy_companyId() {
        return employ_companyId;
    }

    public void setEmploy_companyId(String employ_companyId) {
        this.employ_companyId = employ_companyId;
    }

    public String getEmploy_code() {
        return employ_code;
    }

    public void setEmploy_code(String employ_code) {
        this.employ_code = employ_code;
    }

    public String getEmploy_type() {
        return employ_type;
    }

    public void setEmploy_type(String employ_type) {
        this.employ_type = employ_type;
    }

    public String getEmploy_name() {
        return employ_name;
    }

    public void setEmploy_name(String employ_name) {
        this.employ_name = employ_name;
    }

    public String getEmploy_nameEn() {
        return employ_nameEn;
    }

    public void setEmploy_nameEn(String employ_nameEn) {
        this.employ_nameEn = employ_nameEn;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getEmploy_isdisable() {
        return employ_isdisable;
    }

    public void setEmploy_isdisable(String employ_isdisable) {
        this.employ_isdisable = employ_isdisable;
    }

    public Date getEmploy_cdate() {
        return employ_cdate;
    }

    public void setEmploy_cdate(Date employ_cdate) {
        this.employ_cdate = employ_cdate;
    }

    public String getEmploy_cuser() {
        return employ_cuser;
    }

    public void setEmploy_cuser(String employ_cuser) {
        this.employ_cuser = employ_cuser;
    }

    public Date getEmploy_udate() {
        return employ_udate;
    }

    public void setEmploy_udate(Date employ_udate) {
        this.employ_udate = employ_udate;
    }

    public String getEmploy_uuser() {
        return employ_uuser;
    }

    public void setEmploy_uuser(String employ_uuser) {
        this.employ_uuser = employ_uuser;
    }

    public String getEmploy_column1() {
        return employ_column1;
    }

    public void setEmploy_column1(String employ_column1) {
        this.employ_column1 = employ_column1;
    }

    public String getEmploy_column2() {
        return employ_column2;
    }

    public void setEmploy_column2(String employ_column2) {
        this.employ_column2 = employ_column2;
    }

    public String getEmploy_column3() {
        return employ_column3;
    }

    public void setEmploy_column3(String employ_column3) {
        this.employ_column3 = employ_column3;
    }
}
