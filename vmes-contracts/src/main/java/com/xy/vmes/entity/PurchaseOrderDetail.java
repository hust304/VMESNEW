package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_order_detail:采购订单明细 实体类
 * @author 刘威 自动生成
 * @date 2019-03-05
 */
@TableName("vmes_purchase_order_detail")
public class PurchaseOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//采购订单ID
	@TableField("parent_id")
	private String parentId;
	//产品ID
	@TableField("product_id")
	private String productId;
	//采购原因(字典表-vmes_dictionary.id)
	@TableField("reason")
	private String reason;
	//采购数量
	@TableField("count")
	private BigDecimal count;
	//到货数量
	@TableField("arrive_count")
	private BigDecimal arriveCount;
	//单位
	@TableField("unit")
	private String unit;
	//单价
	@TableField("price")
	private BigDecimal price;
	//采购金额
	@TableField("amount")
	private BigDecimal amount;
	//期望到货时间
	@TableField("edate")
	private Date edate;
	//实际到货时间
	@TableField("adate")
	private Date adate;
	//状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
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
	//附件
	@TableField("attachment")
	private String attachment;
	//采购补充说明
	@TableField("remark")
	private String remark;
	//是否启用(0:已禁用 1:启用)
	@TableField("isdisable")
	private String isdisable;

	//采购计划明细ID
	@TableField("plan_id")
	private String planId;


	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
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
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReason() {
		return reason;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setArriveCount(BigDecimal arriveCount) {
		this.arriveCount = arriveCount;
	}
	public BigDecimal getArriveCount() {
		return arriveCount;
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
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	public Date getAdate() {
		return adate;
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
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getAttachment() {
		return attachment;
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
