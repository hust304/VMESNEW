package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_retreat:退货单 实体类
 * @author 陈刚 自动生成
 * @date 2019-05-09
 */
@TableName("vmes_purchase_retreat")
public class PurchaseRetreat implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//供应商ID
	@TableField("supplier_id")
	private String supplierId;
	//采购订单id
	@TableField("order_id")
	private String orderId;
	//退货类型-(字典表-vmes_dictionary.id)
	@TableField("type")
	private String type;

	//退货编号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//退货金额
	@TableField("total_sum")
	private BigDecimal totalSum;
	//实际退货金额
	@TableField("reality_total")
	private BigDecimal realityTotal;
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

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BigDecimal getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(BigDecimal totalSum) {
		this.totalSum = totalSum;
	}
	public BigDecimal getRealityTotal() {
		return realityTotal;
	}
	public void setRealityTotal(BigDecimal realityTotal) {
		this.realityTotal = realityTotal;
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
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getUuser() {
		return uuser;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsdisable() {
		return isdisable;
	}
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
