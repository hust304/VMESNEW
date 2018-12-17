package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_deliver:发货表 实体类
 * @author 陈刚 自动生成
 * @date 2018-12-15
 */
@TableName("vmes_sale_deliver")
public class SaleDeliver implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//发货单编号
	@TableField("deliver_code")
	private String deliverCode;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//客户ID
	@TableField("customer_id")
	private String customerId;
	//发货状态(0:待发货 1:已发货 -1:已取消)
	@TableField("state")
	private String state;

	//发货类型(1:发货 2:送货 3:客户自提)
	@TableField("type")
	private String type;
	//制单人ID
	@TableField("make_id")
	private String makeId;
	//物流公司
	@TableField("waybill_company")
	private String waybillCompany;
	//物流单号
	@TableField("waybill_code")
	private String waybillCode;
	//车牌号
	@TableField("car_code")
	private String carCode;

	//车牌号
	@TableField("custome_address_id")
	private String customeAddressId;
	//发货日期
	@TableField("deliver_date")
	private Date deliverDate;
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
	public String getDeliverCode() {
		return deliverCode;
	}
	public void setDeliverCode(String deliverCode) {
		this.deliverCode = deliverCode;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
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
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomeAddressId() {
		return customeAddressId;
	}
	public void setCustomeAddressId(String customeAddressId) {
		this.customeAddressId = customeAddressId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
