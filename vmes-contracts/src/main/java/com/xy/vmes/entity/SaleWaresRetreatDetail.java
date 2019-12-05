package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_wares_retreat_detail:无订单退货明细 实体类
 * @author 陈刚 自动生成
 * @date 2019-12-05
 */
@TableName("vmes_sale_wares_retreat_detail")
public class SaleWaresRetreatDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//退货单id
	@TableField("parent_id")
	private String parentId;
	//入库明细id
	@TableField("in_detail_id")
	private String inDetailId;
	//货品id
	@TableField("product_id")
	private String productId;
	//单据单位id
	@TableField("order_unit")
	private String orderUnit;

	//计量单位id
	@TableField("product_unit")
	private String productUnit;
	//退货数量(单据单位)
	@TableField("order_count")
	private BigDecimal orderCount;
	//退货数量(计量数量)
	@TableField("product_count")
	private BigDecimal productCount;
	//货品单价(单据单价)
	@TableField("order_price")
	private BigDecimal orderPrice;
	//退货金额(单据退货数量 * 单据 单价)
	@TableField("order_sum")
	private BigDecimal orderSum;

	//状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
	@TableField("state")
	private String state;
	//退货原因
	@TableField("reason")
	private String reason;
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
	public void setInDetailId(String inDetailId) {
		this.inDetailId = inDetailId;
	}
	public String getInDetailId() {
		return inDetailId;
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
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setOrderCount(BigDecimal orderCount) {
		this.orderCount = orderCount;
	}
	public BigDecimal getOrderCount() {
		return orderCount;
	}
	public void setProductCount(BigDecimal productCount) {
		this.productCount = productCount;
	}
	public BigDecimal getProductCount() {
		return productCount;
	}
	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}
	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
	public void setOrderSum(BigDecimal orderSum) {
		this.orderSum = orderSum;
	}
	public BigDecimal getOrderSum() {
		return orderSum;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReason() {
		return reason;
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
