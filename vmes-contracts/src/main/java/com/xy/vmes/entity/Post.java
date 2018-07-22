package com.xy.vmes.entity;

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_post:岗位表 实体类
 * @author 陈刚
 * @date 2018-07-22
 */
public class Post implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String id;
	//公司ID-组织架构
	private String companyId;
	//岗位名称
	private String name;
	//岗位级别(0-7)
	private Integer layer;
	//是否兼岗(Y:兼岗N:主岗) 数据字典:sys_isplurality
	private String isplurality;
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
	//所属部门ID
	private String deptId;
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
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setIsplurality(String isplurality) {
		this.isplurality = isplurality;
	}
	public String getIsplurality() {
		return isplurality;
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
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptId() {
		return deptId;
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
