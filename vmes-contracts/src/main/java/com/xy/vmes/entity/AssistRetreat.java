package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_retreat:外协退货单 实体类
 * @author 陈刚 自动生成
 * @date 2020-05-07
 */
@TableName("vmes_assist_retreat")
public class AssistRetreat implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//供应商id
	@TableField("supplier_id")
	private String supplierId;
	//审核人id
	@TableField("audit_id")
	private String auditId;
	//退货单号(系统生成)
	@TableField("sys_code")
	private String sysCode;

	//退货单号(用户自定义单号)
	@TableField("cust_code")
	private String custCode;
	//退货类型(1:外协件 2:外协原材料)
	@TableField("type")
	private String type;
	//退货金额
	@TableField("amount")
	private BigDecimal amount;
	//退货完成日期(yyyy-MM-dd)
	@TableField("retreat_date")
	private Date retreatDate;
	//状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
	@TableField("state")
	private String state;

	//退货属性(1:系统生成 2:用户生成)
	@TableField("attribute")
	private String attribute;
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
	public void setRetreatDate(Date retreatDate) {
		this.retreatDate = retreatDate;
	}
	public Date getRetreatDate() {
		return retreatDate;
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
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
