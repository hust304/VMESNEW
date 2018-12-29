package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_order_detail:订单明细 实体类
 * @author 陈刚 自动生成
 * @date 2018-12-05
 */
@TableName("vmes_sale_order_detail")
public class SaleOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//订单ID
	@TableField("parent_id")
	private String parentId;
	//订单状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//附件地址
	@TableField("file_url")
	private String fileUrl;
	//交付日期
	@TableField("deliver_date")
	private Date deliverDate;

	//订购数量(计价数量)
	@TableField("count")
	private BigDecimal count;
	//货品数量(计量数量)
	@TableField("product_count")
	private BigDecimal productCount;
	//货品ID
	@TableField("product_id")
	private String productId;
	//货品单价(货品计价单位匹配获得)
	@TableField("product_price")
	private BigDecimal productPrice;
	//货品金额(订购数量 * 货品单价)
	@TableField("product_sum")
	private BigDecimal productSum;

	//计量单位id
	@TableField("product_unit")
	private String productUnit;
	//计价单位id
	@TableField("price_unit")
	private String priceUnit;
	//是否锁定仓库(0:未锁定 1:已锁定
	@TableField("is_lock_warehouse")
	private String isLockWarehouse;
	//是否需要生产(0:无需 1:需要 库存不够)
	@TableField("is_need_produce")
	private String isNeedProduce;
	//锁定货品数量
	@TableField("lock_count")
	private BigDecimal lockCount;

	//锁定开始时间
	@TableField("lock_date")
	private Date lockDate;
	//发货明细ID
	@TableField("deliver_detail_id")
	private String deliverDetailId;
	//生产计划明细ID
	@TableField("plan_detail_id")
	private String planDetailId;
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

	/////////////////////////////////////////////////////////
	//非实体类字段:界面传值用
	private String orderUnit;


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
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setProductCount(BigDecimal productCount) {
		this.productCount = productCount;
	}
	public BigDecimal getProductCount() {
		return productCount;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductSum(BigDecimal productSum) {
		this.productSum = productSum;
	}
	public BigDecimal getProductSum() {
		return productSum;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setIsLockWarehouse(String isLockWarehouse) {
		this.isLockWarehouse = isLockWarehouse;
	}
	public String getIsLockWarehouse() {
		return isLockWarehouse;
	}
	public String getIsNeedProduce() {
		return isNeedProduce;
	}
	public void setIsNeedProduce(String isNeedProduce) {
		this.isNeedProduce = isNeedProduce;
	}
	public void setLockCount(BigDecimal lockCount) {
		this.lockCount = lockCount;
	}
	public BigDecimal getLockCount() {
		return lockCount;
	}
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
	public Date getLockDate() {
		return lockDate;
	}
	public void setDeliverDetailId(String outDetailId) {
		this.deliverDetailId = outDetailId;
	}
	public String getDeliverDetailId() {
		return deliverDetailId;
	}

	public void setPlanDetailId(String planDetailId) {
		this.planDetailId = planDetailId;
	}
	public String getPlanDetailId() {
		return planDetailId;
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
	public String getOrderUnit() {
		return orderUnit;
	}
	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
