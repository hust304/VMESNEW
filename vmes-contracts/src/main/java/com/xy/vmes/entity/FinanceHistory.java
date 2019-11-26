package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_finance_history:历史账单 实体类
 * @author 刘威 自动生成
 * @date 2019-11-20
 */
@TableName("vmes_finance_history")
public class FinanceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//客户/供应商ID
	@TableField("customer_id")
	private String customerId;
	//账单期间(yyyymm)
	@TableField("period")
	private String period;
	//应收款(期初)
	@TableField("begin_plus")
	private BigDecimal beginPlus;
	//预收款(期初)
	@TableField("begin_minus")
	private BigDecimal beginMinus;
	//本期发生
	@TableField("now_plus")
	private BigDecimal nowPlus;
	//收款金额(本期)
	@TableField("now_minus")
	private BigDecimal nowMinus;
	//应收款(期末)
	@TableField("end_plus")
	private BigDecimal endPlus;
	//预收款(期末)
	@TableField("end_minus")
	private BigDecimal endMinus;
	//逾期账款
	@TableField("overdue")
	private BigDecimal overdue;
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
	@TableField("company_id")
	private String companyId;

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPeriod() {
		return period;
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
	public void setNowPlus(BigDecimal nowPlus) {
		this.nowPlus = nowPlus;
	}
	public BigDecimal getNowPlus() {
		return nowPlus;
	}
	public void setNowMinus(BigDecimal nowMinus) {
		this.nowMinus = nowMinus;
	}
	public BigDecimal getNowMinus() {
		return nowMinus;
	}
	public void setEndPlus(BigDecimal endPlus) {
		this.endPlus = endPlus;
	}
	public BigDecimal getEndPlus() {
		return endPlus;
	}
	public void setEndMinus(BigDecimal endMinus) {
		this.endMinus = endMinus;
	}
	public BigDecimal getEndMinus() {
		return endMinus;
	}
	public void setOverdue(BigDecimal overdue) {
		this.overdue = overdue;
	}
	public BigDecimal getOverdue() {
		return overdue;
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
