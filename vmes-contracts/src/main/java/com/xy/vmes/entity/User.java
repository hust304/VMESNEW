package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 创建人：陈刚
 * 创建时间：2018-07-20
 */
public class User{
	
	private String id;			//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String employId;			//员工ID
	public String getEmployId() {
		return employId;
	}
	public void setEmployId(String employId) {
		this.employId = employId;
	}
	private String companyId;			//公司ID-组织架构
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	private String userCode;			//账号(系统登录账号)
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	private String password;			//密码(MD5加密)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String openId;			//用户微信ID
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	private String userName;			//姓名
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
