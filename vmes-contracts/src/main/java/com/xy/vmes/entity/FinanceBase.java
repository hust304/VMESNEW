package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_finance_base:应收应付初始化 实体类
 * @author 刘威 自动生成
 * @date 2019-11-05
 */
@TableName("vmes_finance_base")
public class FinanceBase implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//客户ID
	@TableField("customer_id")
	private String customerId;
	//类型（0：应收；1：应付）
	@TableField("type")
	private String type;
	//收/付款期间(yyyymm)
	@TableField("period")
	private String period;
	//收/付款期间
	@TableField("period_date")
	private Date periodDate;
	//应收/付款(期初)
	@TableField("begin_plus")
	private BigDecimal beginPlus;
	//预收/付款(期初)
	@TableField("begin_minus")
	private BigDecimal beginMinus;
	//收/付款值(期初)
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
	//公司ID
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
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriodDate(Date periodDate) {
		this.periodDate = periodDate;
	}
	public Date getPeriodDate() {
		return periodDate;
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
	public void setBeginValue(BigDecimal beginValue) {
		this.beginValue = beginValue;
	}
	public BigDecimal getBeginValue() {
		return beginValue;
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
