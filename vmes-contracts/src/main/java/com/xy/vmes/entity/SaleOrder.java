package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_order:订单表 实体类
 * @author 陈刚 自动生成
 * @date 2018-12-05
 */
@TableName("vmes_sale_order")
public class SaleOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//订单编号(用户)
	@TableField("order_number")
	private String orderNumber;
	//订单编号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//发票类型(1:不开票 2:增值税普通发票 3:增值税专用发票)
	@TableField("receipt_type")
	private String receiptType;

	//计价类型(1:先计价 2:后计价)
	@TableField("price_type")
	private String priceType;
	//订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//制单人ID
	@TableField("make_id")
	private String makeId;
	//审核人ID
	@TableField("audit_id")
	private String auditId;
	//客户ID
	@TableField("customer_id")
	private String customerId;

	//下单日期
	@TableField("order_date")
	private Date orderDate;
	//合计金额
	@TableField("total_sum")
	private BigDecimal totalSum;
	//折扣金额
	@TableField("discount_sum")
	private BigDecimal discountSum;
	//订单金额(合计金额 - 折扣金额)
	@TableField("order_sum")
	private BigDecimal orderSum;
	//预付款(定金)
	@TableField("advance_sum")
	private BigDecimal advanceSum;

	//发货金额
	@TableField("deliver_sum")
	private BigDecimal deliverSum;
	//应收款(发货金额-预付款)(废弃不用)
	@TableField("receivables")
	private BigDecimal receivables;
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
	//约定交期
	@TableField("expect_date")
	private Date expectDate;
	//发货完成日期
	@TableField("deliver_date")
	private Date deliverDate;

	//付款完成日期
	@TableField("pay_date")
	private Date payDate;
	//付款状态(0:未付款 1:付款中 2:已付款)
	@TableField("pay_state")
	private String payState;


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
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public String getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getPriceType() {
		return priceType;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
	public BigDecimal getTotalSum() {
		return totalSum;
	}
	public void setDiscountSum(BigDecimal discountSum) {
		this.discountSum = discountSum;
	}
	public BigDecimal getDiscountSum() {
		return discountSum;
	}
	public void setOrderSum(BigDecimal orderSum) {
		this.orderSum = orderSum;
	}
	public BigDecimal getOrderSum() {
		return orderSum;
	}
	public void setAdvanceSum(BigDecimal advanceSum) {
		this.advanceSum = advanceSum;
	}
	public BigDecimal getAdvanceSum() {
		return advanceSum;
	}
	public void setReceivables(BigDecimal receivables) {
		this.receivables = receivables;
	}
	public BigDecimal getReceivables() {
		return receivables;
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
	public BigDecimal getDeliverSum() {
		return deliverSum;
	}
	public void setDeliverSum(BigDecimal deliverSum) {
		this.deliverSum = deliverSum;
	}
	public Date getExpectDate() {
		return expectDate;
	}
	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
