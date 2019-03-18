package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_payment_build:供应商付款初期设定 实体类
 * @author 陈刚 自动生成
 * @date 2019-03-12
 */
@TableName("vmes_purchase_payment_build")
public class PurchasePaymentBuild implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//供应商ID
	@TableField("supplier_id")
	private String supplierId;
	//付款期(yyyymm)
	@TableField("payment_period")
	private String paymentPeriod;
	//当前付款期
	@TableField("payment_period_date")
	private Date paymentPeriodDate;
	//应付款(期初)
	@TableField("begin_plus")
	private BigDecimal beginPlus;

	//预付款(期初)
	@TableField("begin_minus")
	private BigDecimal beginMinus;
	//付款值(期初)
	@TableField("begin_value")
	private BigDecimal beginValue;
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
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setPaymentPeriod(String paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}
	public String getPaymentPeriod() {
		return paymentPeriod;
	}
	public void setBeginPlus(BigDecimal beginPlus) {
		this.beginPlus = beginPlus;
	}
	public BigDecimal getBeginPlus() {
		return beginPlus;
	}
	public void setBeginMinus(BigDecimal beginMinus) {
		this.beginMinus = beginMinus;
	}
	public BigDecimal getBeginMinus() {
		return beginMinus;
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
	public BigDecimal getBeginValue() {
		return beginValue;
	}
	public void setBeginValue(BigDecimal beginValue) {
		this.beginValue = beginValue;
	}
	public Date getPaymentPeriodDate() {
		return paymentPeriodDate;
	}
	public void setPaymentPeriodDate(Date paymentPeriodDate) {
		this.paymentPeriodDate = paymentPeriodDate;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
