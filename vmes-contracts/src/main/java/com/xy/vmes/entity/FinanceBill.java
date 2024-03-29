package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_finance_bill:应收/应付单 实体类
 * @author 刘威 自动生成
 * @date 2019-11-07
 */
@TableName("vmes_finance_bill")
public class FinanceBill implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//编码
	@TableField("code")
	private String code;
	//业务ID
	@TableField("business_id")
	private String businessId;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//客户/供应商ID
	@TableField("customer_id")
	private String customerId;
	//单据类型 ( 0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购) 10:应付单(采购) 11:收货账单(外协) 12:退款单(外协) 13:扣款单(外协))
	//销售(客户)  : 0:收款单(销售) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 8:应收单(销售)
	//采购(供应商): 1:付款单(采购) 6:收货账单(采购) 7:扣款单(采购) 9:退款单(采购) 10:应付单(采购)
	//外协(供应商): 11:收货账单(外协) 12:退款单(外协) 13:扣款单(外协)
	@TableField("type")
	private String type;
	//金额
	@TableField("amount")
	private BigDecimal amount;
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
	//状态（0：待提交 1：待审核 2：已审核 -1：已取消）
	@TableField("state")
	private String state;
	//审核用户id
	@TableField("suser")
	private String suser;
	//审核时间
	@TableField("sdate")
	private Date sdate;
	//收/付款期间(yyyyMM)
	@TableField("period")
	private String period;

	//业务属性 1:销售订单退货 2:销售无订单退货
	@TableField("attribute")
	private String attribute;

	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
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
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmount() {
		return amount;
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
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
