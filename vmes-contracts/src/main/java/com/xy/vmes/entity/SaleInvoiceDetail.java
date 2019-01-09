package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_invoice_detail:发票明细 实体类
 * @author 陈刚 自动生成
 * @date 2019-01-08
 */
@TableName("vmes_sale_invoice_detail")
public class SaleInvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//发票ID
	@TableField("parent_id")
	private String parentId;
	//订单ID
	@TableField("order_id")
	private String orderId;
	//订单明细ID
	@TableField("order_detai_id")
	private String orderDetaiId;
	//发票状态(0:待开票 1:已开票 -1:已开票)
	@TableField("state")
	private String state;

	//开票数量
	@TableField("count")
	private BigDecimal count;
	//货品单价
	@TableField("product_price")
	private BigDecimal productPrice;
	//发票金额
	@TableField("sum")
	private BigDecimal sum;
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
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderDetaiId(String orderDetaiId) {
		this.orderDetaiId = orderDetaiId;
	}
	public String getOrderDetaiId() {
		return orderDetaiId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public BigDecimal getSum() {
		return sum;
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
