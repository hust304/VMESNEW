package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：部门表 实体类
 * 创建人：自动创建
 * 创建时间：2018-07-18
 */
public class Employee{
	
	private int id;				//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;			//员工名字
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String birthday;			//出生年月
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	private String gender;			//性别
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private String phonenum;			//手机号码
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	private String jobtitle;			//职位
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	private int createby;				//创建人id
	public int getCreateby() {
		return createby;
	}
	public void setCreateby(int createby) {
		this.createby = createby;
	}
	private String serialNo;			//员工号
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	private Date addDate;			//添加时间
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	private Date updateDate;			//修改时间
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	private String avatar;			//员工头像
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	private String idcard;			//身份证
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	private String password;			//密码
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private int rid;				//角色id
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	private String status;			//使用状态 1:正常 0:停用
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String companyid;			//公司ID-组织架构一级部门ID
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

}
