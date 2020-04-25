package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_retreat_detail:退货明细 实体类
 * @author 陈刚 自动生成
 * @date 2019-05-09
 */
@TableName("vmes_purchase_retreat_detail")
public class PurchaseRetreatDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//退货单ID
	@TableField("parent_id")
	private String parentId;
	//采购订单明细ID
	@TableField("order_detail_id")
	private String orderDetailId;
	//出库明细ID
	@TableField("out_detail_id")
	private String outDetailId;
	//货品ID
	@TableField("product_id")
	private String productId;

	//退货金额
	@TableField("amount")
	private BigDecimal amount;
	//订单单位ID
	@TableField("unit")
	private String unit;
	//退货数量
	@TableField("count")
	private BigDecimal count;
	//明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
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

	//入库明细ID-退货换货
	@TableField("in_detail_id")
	private String inDetailId;

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
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOutDetailId(String outDetailId) {
		this.outDetailId = outDetailId;
	}
	public String getOutDetailId() {
		return outDetailId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
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
	public String getInDetailId() {
		return inDetailId;
	}
	public void setInDetailId(String inDetailId) {
		this.inDetailId = inDetailId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
