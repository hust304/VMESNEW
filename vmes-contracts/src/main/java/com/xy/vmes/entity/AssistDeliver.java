package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_deliver:外协发货表 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-27
 */
@TableName("vmes_assist_deliver")
public class AssistDeliver implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//外协订单id
	@TableField("order_id")
	private String orderId;
	//供应商id
	@TableField("supplier_id")
	private String supplierId;
	//经办人id
	@TableField("make_id")
	private String makeId;

	//外协发货单号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//外协发货单号(用户自定义单号)
	@TableField("cust_code")
	private String custCode;
	//发货类型(1:发货 2:送货 3:供应商自提)
	@TableField("type")
	private String type;
	//发货金额
	@TableField("amount")
	private BigDecimal amount;
	//发货完成时间
	@TableField("deliver_date")
	private Date deliverDate;

	//发货状态(0:待发货 1:已发货 -1:已取消)
	@TableField("state")
	private String state;
	//物流公司
	@TableField("waybill_company")
	private String waybillCompany;
	//物流单号
	@TableField("waybill_code")
	private String waybillCode;
	//车牌号
	@TableField("car_code")
	private String carCode;
	//手机号
	@TableField("supplier_mobile")
	private String supplierMobile;

	//联系人
	@TableField("supplier_name")
	private String supplierName;
	//收货地址
	@TableField("supplier_address")
	private String supplierAddress;
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
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
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
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setWaybillCompany(String waybillCompany) {
		this.waybillCompany = waybillCompany;
	}
	public String getWaybillCompany() {
		return waybillCompany;
	}
	public void setWaybillCode(String waybillCode) {
		this.waybillCode = waybillCode;
	}
	public String getWaybillCode() {
		return waybillCode;
	}
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	public String getCarCode() {
		return carCode;
	}
	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}
	public String getSupplierMobile() {
		return supplierMobile;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierAddress() {
		return supplierAddress;
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
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
