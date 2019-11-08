package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_order_detail_change:订单明细变更记录表 实体类
 * @author 陈刚 自动生成
 * @date 2019-11-05
 */
@TableName("vmes_sale_order_detail_change")
public class SaleOrderDetailChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//订单变更id
	@TableField("parent_id")
	private String parentId;
	//订单明细id
	@TableField("order_dtl_id")
	private String orderDtlId;
	//订单订购数量(变更前-订单单位)
	@TableField("order_count_before")
	private BigDecimal orderCountBefore;
	//订单订购数量(变更后-订单单位)
	@TableField("order_count_after")
	private BigDecimal orderCountAfter;

	//货品单价(变更前)
	@TableField("product_price_before")
	private BigDecimal productPriceBefore;
	//货品单价(变更后)
	@TableField("product_price_after")
	private BigDecimal productPriceAfter;
	//约定交期(变更前)
	@TableField("deliver_date_before")
	private Date deliverDateBefore;
	//约定交期(变更后)
	@TableField("deliver_date_after")
	private Date deliverDateAfter;
	//发货单数量(订单单位)
	@TableField("deliver_count")
	private BigDecimal deliverCount;

	//完成发货数量(订单单位)
	@TableField("end_deliver_count")
	private BigDecimal endDeliverCount;
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
	public void setOrderDtlId(String orderDtlId) {
		this.orderDtlId = orderDtlId;
	}
	public String getOrderDtlId() {
		return orderDtlId;
	}
	public void setOrderCountBefore(BigDecimal orderCountBefore) {
		this.orderCountBefore = orderCountBefore;
	}
	public BigDecimal getOrderCountBefore() {
		return orderCountBefore;
	}
	public void setOrderCountAfter(BigDecimal orderCountAfter) {
		this.orderCountAfter = orderCountAfter;
	}
	public BigDecimal getOrderCountAfter() {
		return orderCountAfter;
	}
	public void setProductPriceBefore(BigDecimal productPriceBefore) {
		this.productPriceBefore = productPriceBefore;
	}
	public BigDecimal getProductPriceBefore() {
		return productPriceBefore;
	}
	public void setProductPriceAfter(BigDecimal productPriceAfter) {
		this.productPriceAfter = productPriceAfter;
	}
	public BigDecimal getProductPriceAfter() {
		return productPriceAfter;
	}
	public void setDeliverDateBefore(Date deliverDateBefore) {
		this.deliverDateBefore = deliverDateBefore;
	}
	public Date getDeliverDateBefore() {
		return deliverDateBefore;
	}
	public void setDeliverDateAfter(Date deliverDateAfter) {
		this.deliverDateAfter = deliverDateAfter;
	}
	public Date getDeliverDateAfter() {
		return deliverDateAfter;
	}
	public void setDeliverCount(BigDecimal deliverCount) {
		this.deliverCount = deliverCount;
	}
	public BigDecimal getDeliverCount() {
		return deliverCount;
	}
	public void setEndDeliverCount(BigDecimal endDeliverCount) {
		this.endDeliverCount = endDeliverCount;
	}
	public BigDecimal getEndDeliverCount() {
		return endDeliverCount;
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
