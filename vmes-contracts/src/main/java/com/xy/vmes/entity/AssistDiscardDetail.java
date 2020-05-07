package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_discard_detail:外协报废明细 实体类
 * @author 陈刚 自动生成
 * @date 2020-05-07
 */
@TableName("vmes_assist_discard_detail")
public class AssistDiscardDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//退货单
	@TableField("parent_id")
	private String parentId;
	//外协订单id
	@TableField("order_id")
	private String orderId;
	//订单明细id
	@TableField("order_dtl_id")
	private String orderDtlId;
	//发货明细子表id(原材料)
	@TableField("deliver_dtl_child_id")
	private String deliverDtlChildId;

	//外协发货明细id
	@TableField("deliver_dtl_id")
	private String deliverDtlId;
	//外协发货id
	@TableField("deliver_id")
	private String deliverId;
	//外协件id(外协件)
	@TableField("assist_product_id")
	private String assistProductId;
	//原材料id(系统货品表id)
	@TableField("product_id")
	private String productId;
	//订单单位id
	@TableField("order_unit")
	private String orderUnit;

	//报废数量(订单单位)
	@TableField("order_count")
	private BigDecimal orderCount;
	//单价(外协件)
	@TableField("price")
	private BigDecimal price;
	//金额(外协件)
	@TableField("amount")
	private BigDecimal amount;
	//状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
	@TableField("state")
	private String state;
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
	public void setOrderDtlId(String orderDtlId) {
		this.orderDtlId = orderDtlId;
	}
	public String getOrderDtlId() {
		return orderDtlId;
	}
	public void setDeliverDtlChildId(String deliverDtlChildId) {
		this.deliverDtlChildId = deliverDtlChildId;
	}
	public String getDeliverDtlChildId() {
		return deliverDtlChildId;
	}
	public void setDeliverDtlId(String deliverDtlId) {
		this.deliverDtlId = deliverDtlId;
	}
	public String getDeliverDtlId() {
		return deliverDtlId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	public String getDeliverId() {
		return deliverId;
	}
	public void setAssistProductId(String assistProductId) {
		this.assistProductId = assistProductId;
	}
	public String getAssistProductId() {
		return assistProductId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}
	public String getOrderUnit() {
		return orderUnit;
	}
	public void setOrderCount(BigDecimal orderCount) {
		this.orderCount = orderCount;
	}
	public BigDecimal getOrderCount() {
		return orderCount;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmount() {
		return amount;
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

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
