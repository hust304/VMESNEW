package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_department:系统部门表 实体类
 * @author 陈刚
 * @date 2018-07-22
 */
public class Department implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String id;
	//上级id-根root
	private String pid;
	//部门编码
	private String code;
	//部门名称
	private String name;
	//是否叶子节点(1:叶子节点0:非叶子节点) 数据字典:sys_isleaf
	private String isleaf;
	//部门级别(最大支持5层)
	private Integer layer;
	//部门排列序号
	private Integer serialNumber;
	//组织类型(1:公司 2:部门) 数据字典:sys_organize_type
	private String organizeType;
	//公司类型 数据字典:sys_company_type
	private String companyType;
	//部门类型 数据字典:sys_department_type
	private String deptType;
	//部门长名称(中间使用-链接)
	private String longName;
	//部门长编码(中间使用-链接)
	private String longCode;
	//有效期(yyyy-mm-dd)
	private Date companyValidityDate;
	//系统用户数
	private Integer companyUserCount;
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
	//根root节点ID
	private String id0;
	//一级节点ID
	private String id1;
	//二级节点ID
	private String id2;
	//三级节点ID
	private String id3;
	//四级节点ID
	private String id4;
	//五级节点ID
	private String id5;
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
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPid() {
		return pid;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}
	public String getIsleaf() {
		return isleaf;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setOrganizeType(String organizeType) {
		this.organizeType = organizeType;
	}
	public String getOrganizeType() {
		return organizeType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	public String getDeptType() {
		return deptType;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongCode(String longCode) {
		this.longCode = longCode;
	}
	public String getLongCode() {
		return longCode;
	}
	public void setCompanyValidityDate(Date companyValidityDate) {
		this.companyValidityDate = companyValidityDate;
	}
	public Date getCompanyValidityDate() {
		return companyValidityDate;
	}
	public void setCompanyUserCount(Integer companyUserCount) {
		this.companyUserCount = companyUserCount;
	}
	public Integer getCompanyUserCount() {
		return companyUserCount;
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
	public void setId0(String id0) {
		this.id0 = id0;
	}
	public String getId0() {
		return id0;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getId1() {
		return id1;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getId2() {
		return id2;
	}
	public void setId3(String id3) {
		this.id3 = id3;
	}
	public String getId3() {
		return id3;
	}
	public void setId4(String id4) {
		this.id4 = id4;
	}
	public String getId4() {
		return id4;
	}
	public void setId5(String id5) {
		this.id5 = id5;
	}
	public String getId5() {
		return id5;
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
