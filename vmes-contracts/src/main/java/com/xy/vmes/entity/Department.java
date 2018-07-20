package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：部门表 实体类
 * 创建人：自动创建
 * 创建时间：2018-07-18
 */
public class Department{

	private String id;			//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String pid;			//上级id-根root
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	private String code;			//部门编码
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String name;			//部门名称
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String isleaf;			//是否叶子节点(1:叶子节点0:非叶子节点) 数据字典:sys_isleaf
	public String getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}
	private Integer layer;				//部门级别(最大支持5层)
	public Integer getLayer() {
		return layer;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	private Integer serialNumber;				//部门排列序号
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	private String organizeType;			//组织类型(1:公司 2:部门) 数据字典:sys_organize_type
	public String getOrganizeType() {
		return organizeType;
	}
	public void setOrganizeType(String organizeType) {
		this.organizeType = organizeType;
	}
	private String companyType;			//公司类型 数据字典:sys_company_type
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	private String deptType;			//部门类型 数据字典:sys_department_type
	public String getDeptType() {
		return deptType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	private String longName;			//部门长名称(中间使用-链接)
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	private String longCode;			//部门长编码(中间使用-链接)
	public String getLongCode() {
		return longCode;
	}
	public void setLongCode(String longCode) {
		this.longCode = longCode;
	}
	private Date companyValidityDate;			//有效期(yyyy-mm-dd)
	public Date getCompanyValidityDate() {
		return companyValidityDate;
	}
	public void setCompanyValidityDate(Date companyValidityDate) {
		this.companyValidityDate = companyValidityDate;
	}
	private Integer companyUserCount;				//系统用户数
	public Integer getCompanyUserCount() {
		return companyUserCount;
	}
	public void setCompanyUserCount(Integer companyUserCount) {
		this.companyUserCount = companyUserCount;
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
	private String id0;			//根root节点ID
	public String getId0() {
		return id0;
	}
	public void setId0(String id0) {
		this.id0 = id0;
	}
	private String id1;			//一级节点ID
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	private String id2;			//二级节点ID
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	private String id3;			//三级节点ID
	public String getId3() {
		return id3;
	}
	public void setId3(String id3) {
		this.id3 = id3;
	}
	private String id4;			//四级节点ID
	public String getId4() {
		return id4;
	}
	public void setId4(String id4) {
		this.id4 = id4;
	}
	private String id5;			//五级节点ID
	public String getId5() {
		return id5;
	}
	public void setId5(String id5) {
		this.id5 = id5;
	}

}
