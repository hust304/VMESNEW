package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 创建人：陈刚
 * 创建时间：2018-07-20
 */
public class Employee{
	
	private String id;			//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String userId;			//系统用户ID
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String companyId;			//公司ID-组织架构
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	private String code;			//员工编号
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String type;			//员工类型 数据字典:sys_employee_type
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String name;			//员工姓名
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String nameEn;			//员工英文名
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	private String photo;			//员工照片
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	private String icon;			//员工图片
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String mobile;			//手机号码
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	private String email;			//邮箱地址
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String sex;			//性别(1:男0:女) 数据字典:sys_employee_sex
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private Date birthday;			//出生日期(yyyy-mm-dd)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private Date entryDate;			//入职日期(yyyy-mm-dd)
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	private String nativePlace;			//籍贯
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	private String political;			//政治面貌 数据字典:sys_employee_political
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	private String identityNumber;			//身份证号
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	private String marital;			//婚姻状况(1:已婚 0:未婚) 数据字典:sys_employee_marital
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	private String isdisable;			//是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
	public String getIsdisable() {
		return isdisable;
	}
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	private Date cdate;			//创建时间
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	private String cuser;			//创建人账号
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	private Date udate;			//修改时间
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	private String uuser;			//修改人账号
	public String getUuser() {
		return uuser;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	private String column1;			//预留字段
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	private String column2;			//预留字段
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	private String column3;			//预留字段
	public String getColumn3() {
		return column3;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}

}
