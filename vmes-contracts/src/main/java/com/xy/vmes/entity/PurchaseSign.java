package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_purchase_sign:采购签收 实体类
 * @author 刘威 自动生成
 * @date 2019-03-12
 */
@TableName("vmes_purchase_sign")
public class PurchaseSign implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//采购订单id
	@TableField("order_id")
	private String orderId;
	//企业id
	@TableField("company_id")
	private String companyId;
	//签收人(系统用户id)
	@TableField("sign_id")
	private String signId;
	//签收时间
	@TableField("sdate")
	private Date sdate;

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
	//签收单号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//签收单号(系统生成)
	@TableField("cust_code")
	private String custCode;
	//状态(1:检验中 2:已完成 -1:已取消)
	@TableField("state")
	private String state;


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
	public void setSignId(String signId) {
		this.signId = signId;
	}
	public String getSignId() {
		return signId;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getSdate() {
		return sdate;
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
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
