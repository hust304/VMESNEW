package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_sale_order_change:订单变更记录表 实体类
 * @author 陈刚 自动生成
 * @date 2019-11-05
 */
@TableName("vmes_sale_order_change")
public class SaleOrderChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//订单id
	@TableField("order_id")
	private String orderId;
	//审核人id
	@TableField("audit_id")
	private String auditId;
	//状态(0:审核中 1:完成:审核通过 2:取消:审核不通过)
	@TableField("state")
	private String state;

	//发票类型(变更前-1:不开票 2:普票发票 3:增值税发票)
	@TableField("receipt_type_before")
	private String receiptTypeBefore;
	//发票类型(变更后-1:不开票 2:普票发票 3:增值税发票)
	@TableField("receipt_type_after")
	private String receiptTypeAfter;
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
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setReceiptTypeBefore(String receiptTypeBefore) {
		this.receiptTypeBefore = receiptTypeBefore;
	}
	public String getReceiptTypeBefore() {
		return receiptTypeBefore;
	}
	public void setReceiptTypeAfter(String receiptTypeAfter) {
		this.receiptTypeAfter = receiptTypeAfter;
	}
	public String getReceiptTypeAfter() {
		return receiptTypeAfter;
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
