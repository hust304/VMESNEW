package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：设置锁库时间 实体类
 * @author 刘威 自动生成
 * @date 2018-12-14
 */
@TableName("vmes_sale_unit_price")
public class SaleUnitPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//货品ID
	@TableField("product_id")
	private String productId;
	//单位id
	@TableField("unit")
	private String unit;
	//客户ID
	@TableField("customer_id")
	private String customerId;
	//货品单价
	@TableField("product_price")
	private BigDecimal productPrice;
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
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
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
