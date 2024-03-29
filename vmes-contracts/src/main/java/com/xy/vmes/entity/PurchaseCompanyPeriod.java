package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_company_period:采购企业付款期设定 实体类
 * @author 陈刚 自动生成
 * @date 2019-03-12
 */
@TableName("vmes_purchase_company_period")
public class PurchaseCompanyPeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//初始付款期(yyyymm)
	@TableField("initial_period")
	private String initialPeriod;
	//初始付款期
	@TableField("initial_period_date")
	private Date initialPeriodDate;
	//当前付款期(yyyymm)
	@TableField("payment_period")
	private String paymentPeriod;

	//当前付款期
	@TableField("payment_period_date")
	private Date paymentPeriodDate;
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
	public void setInitialPeriod(String initialPeriod) {
		this.initialPeriod = initialPeriod;
	}
	public String getInitialPeriod() {
		return initialPeriod;
	}
	public void setPaymentPeriod(String paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}
	public String getPaymentPeriod() {
		return paymentPeriod;
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
	public Date getInitialPeriodDate() {
		return initialPeriodDate;
	}
	public void setInitialPeriodDate(Date initialPeriodDate) {
		this.initialPeriodDate = initialPeriodDate;
	}
	public Date getPaymentPeriodDate() {
		return paymentPeriodDate;
	}
	public void setPaymentPeriodDate(Date paymentPeriodDate) {
		this.paymentPeriodDate = paymentPeriodDate;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
