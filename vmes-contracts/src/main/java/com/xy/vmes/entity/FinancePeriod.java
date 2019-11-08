package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_finance_period:应收应付期间表 实体类
 * @author 刘威 自动生成
 * @date 2019-11-05
 */
@TableName("vmes_finance_period")
public class FinancePeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//初始期间(yyyymm)
	@TableField("initial_period")
	private String initialPeriod;
	//初始日期
	@TableField("initial_period_date")
	private Date initialPeriodDate;
	//当前期间(yyyymm)
	@TableField("current_period")
	private String currentPeriod;
	//当前日期
	@TableField("current_period_date")
	private Date currentPeriodDate;
	//账期
	@TableField("period_day")
	private String periodDay;
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
	//禁用初始化（0:已禁用 1:启用）
	@TableField("disablesaleinit")
	private String disablesaleinit;
	//禁用初始化（0:已禁用 1:启用）
	@TableField("disablepurchaseinit")
	private String disablepurchaseinit;



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
	public void setInitialPeriodDate(Date initialPeriodDate) {
		this.initialPeriodDate = initialPeriodDate;
	}
	public Date getInitialPeriodDate() {
		return initialPeriodDate;
	}
	public void setCurrentPeriod(String currentPeriod) {
		this.currentPeriod = currentPeriod;
	}
	public String getCurrentPeriod() {
		return currentPeriod;
	}
	public void setCurrentPeriodDate(Date currentPeriodDate) {
		this.currentPeriodDate = currentPeriodDate;
	}
	public Date getCurrentPeriodDate() {
		return currentPeriodDate;
	}
	public void setPeriodDay(String periodDay) {
		this.periodDay = periodDay;
	}
	public String getPeriodDay() {
		return periodDay;
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
	public void setDisablesaleinit(String disablesaleinit) {
		this.disablesaleinit = disablesaleinit;
	}
	public String getDisablesaleinit() {
		return disablesaleinit;
	}
	public void setDisablepurchaseinit(String disablepurchaseinit) {
		this.disablepurchaseinit = disablepurchaseinit;
	}
	public String getDisablepurchaseinit() {
		return disablepurchaseinit;
	}

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
