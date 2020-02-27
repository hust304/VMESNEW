package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/**
 * 说明：vmes_produce_plan:生产计划 实体类
 * @author 陈刚 自动生成
 * @date 2020-02-26
 */
@TableName("vmes_produce_plan")
public class ProducePlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//制单人id
	@TableField("make_id")
	private String makeId;
	//生产计划单号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//生产计划单号(用户自定义单号)
	@TableField("cust_code")
	private String custCode;

	//生产类型 (字典表-vmes_dictionary.id)
	@TableField("produce_type")
	private String produceType;
	//计划开始日期
	@TableField("begin_date")
	private Date beginDate;
	//计划结束日期
	@TableField("end_date")
	private Date endDate;
	//计划完成日期(业务反写字段)(yyyy-MM-dd)
	@TableField("plan_date")
	private Date planDate;
	//状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
	@TableField("state")
	private String state;

	//创建用户id
	@TableField("cuser")
	private String cuser;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//修改用户id
	@TableField("uuser")
	private String uuser;
	//修改时间
	@TableField("udate")
	private Date udate;
	//备注
	@TableField("remark")
	private String remark;

	//是否启用(0:已禁用 1:启用)
	@TableField("isdisable")
	private String isdisable;


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
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setProduceType(String produceType) {
		this.produceType = produceType;
	}
	public String getProduceType() {
		return produceType;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCuser() {
		return cuser;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	public String getUuser() {
		return uuser;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getIsdisable() {
		return isdisable;
	}

}
