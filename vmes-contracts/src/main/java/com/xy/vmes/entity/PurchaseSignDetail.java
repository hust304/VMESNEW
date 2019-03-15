package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_sign_detail:采购签收明细 实体类
 * @author 刘威 自动生成
 * @date 2019-03-12
 */
@TableName("vmes_purchase_sign_detail")
public class PurchaseSignDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//采购签收单ID
	@TableField("parent_id")
	private String parentId;
	//采购订单明细ID
	@TableField("order_detail_id")
	private String orderDetailId;
	//入库单明细id
	@TableField("in_detail_id")
	private String inDetailId;
	//产品ID
	@TableField("product_id")
	private String productId;
	//到货数量
	@TableField("arrive_count")
	private BigDecimal arriveCount;
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
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderDetailId() {
		return orderDetailId;
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
	public void setArriveCount(BigDecimal arriveCount) {
		this.arriveCount = arriveCount;
	}
	public BigDecimal getArriveCount() {
		return arriveCount;
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
