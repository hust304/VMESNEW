package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_retreat:退货单 实体类
 * @author 陈刚 自动生成
 * @date 2019-02-25
 */
@TableName("vmes_sale_retreat")
public class SaleRetreat implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//客户ID
	@TableField("customer_id")
	private String customerId;
	//退货类型-(字典表-vmes_dictionary.id)
	@TableField("type")
	private String type;
	//退货编号(系统生成)
	@TableField("sys_code")
	private String sysCode;

	//状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//退货金额
	@TableField("total_sum")
	private BigDecimal totalSum;
	//退货完成日期
	@TableField("retreat_date")
	private Date retreatDate;
	//审核人ID
	@TableField("audit_id")
	private String auditId;
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
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
	public BigDecimal getTotalSum() {
		return totalSum;
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
	public Date getRetreatDate() {
		return retreatDate;
	}
	public void setRetreatDate(Date retreatDate) {
		this.retreatDate = retreatDate;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
