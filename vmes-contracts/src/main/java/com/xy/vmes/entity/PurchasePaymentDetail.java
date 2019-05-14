package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_payment_detail:采购订单付款单明细 实体类
 * @author 陈刚 自动生成
 * @date 2019-05-14
 */
@TableName("vmes_purchase_payment_detail")
public class PurchasePaymentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//采购付款单ID
	@TableField("parent_id")
	private String parentId;
	//采购订单ID
	@TableField("order_id")
	private String orderId;
	//状态(0:待收款 1:已付款 -1:已取消)
	@TableField("state")
	private String state;
	//实付金额
	@TableField("payment_sum")
	private BigDecimal paymentSum;

	//折扣金额
	@TableField("discount_amount")
	private BigDecimal discountAmount;
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
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setPaymentSum(BigDecimal paymentSum) {
		this.paymentSum = paymentSum;
	}
	public BigDecimal getPaymentSum() {
		return paymentSum;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
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
