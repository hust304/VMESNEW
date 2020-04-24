package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_order:外协订单表 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-24
 */
@TableName("vmes_assist_order")
public class AssistOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//供应商id
	@TableField("supplier_id")
	private String supplierId;
	//制单人id
	@TableField("make_id")
	private String makeId;
	//审核人id
	@TableField("audit_id")
	private String auditId;

	//外协订单号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//外协订单号(用户自定义单号)
	@TableField("cust_code")
	private String custCode;
	//下单日期(yyyy-MM-dd)
	@TableField("order_date")
	private Date orderDate;
	//约定交期(yyyy-MM-dd)
	@TableField("expect_date")
	private Date expectDate;
	//金额
	@TableField("amount")
	private BigDecimal amount;

	//状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
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
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditId() {
		return auditId;
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
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}
	public Date getExpectDate() {
		return expectDate;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmount() {
		return amount;
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

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
