package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_user_role:用户角色表 实体类
 * @author 陈刚
 * @date 2018-07-23
 */
@TableName("vmes_user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//用户ID
	@TableField("user_id")
	private String userId;
	//角色ID
	@TableField("role_id")
	private String roleId;
	//是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
	@TableField("isdisable")
	private String isdisable;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//创建人账号
	@TableField("cuser")
	private String cuser;
	//修改时间
	@TableField("udate")
	private Date udate;
	//修改人账号
	@TableField("uuser")
	private String uuser;
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
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleId() {
		return roleId;
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
