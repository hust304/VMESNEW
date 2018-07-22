package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_user:系统用户表 实体类
 * @author 陈刚
 * @date 2018-07-22
 */
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String id;
	//员工ID
	private String employId;
	//公司ID-组织架构
	private String companyId;
	//账号(系统登录账号)
	private String userCode;
	//密码(MD5加密)
	private String password;
	//用户微信ID
	private String openId;
	//姓名
	private String userName;
	//是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
	private String isdisable;
	//创建时间
	private Date cdate;
	//创建人账号
	private String cuser;
	//修改时间
	private Date udate;
	//修改人账号
	private String uuser;
	//预留字段
	private String column1;
	//预留字段
	private String column2;
	//预留字段
	private String column3;
	//是否查询全部
	//fasle: (false or is null) 无查询条件-查询结果集返回空或list.size()==0
	//true : 无查询条件-返回全部业务表数据
	private Boolean isQueryAll = Boolean.FALSE;

	//是否考虑自己在业务表中是否存在
	//false: (false or is null) 无需考虑自己在业务表中是否存在
	//true : 需要考虑自己在业务表中是否存在
	private Boolean isSelfExist = Boolean.FALSE;
	private String queryStr;


	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setEmployId(String employId) {
		this.employId = employId;
	}
	public String getEmployId() {
		return employId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getIsdisable() {
		return isdisable;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCuser() {
		return cuser;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	public String getUuser() {
		return uuser;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}
	public String getColumn3() {
		return column3;
	}
	public Boolean getIsQueryAll() {
		return isQueryAll;
	}
	public void setIsQueryAll(Boolean isQueryAll) {
		this.isQueryAll = isQueryAll;
	}
	public Boolean getIsSelfExist() {
		return isSelfExist;
	}
	public void setIsSelfExist(Boolean isSelfExist) {
		this.isSelfExist = isSelfExist;
	}
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

}
