package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_order_detail:外协订单明细 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-24
 */
@TableName("vmes_assist_order_detail")
public class AssistOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//外协订单id
	@TableField("parent_id")
	private String parentId;
	//计划明细id
	@TableField("plan_detail_id")
	private String planDetailId;
	//外协件id
	@TableField("assist_product_id")
	private String assistProductId;
	//单位id(单据单位)
	@TableField("order_unit")
	private String orderUnit;

	//订单订购数量
	@TableField("order_count")
	private BigDecimal orderCount;
	//损耗率
	@TableField("loss_ratio")
	private BigDecimal lossRatio;
	//单价
	@TableField("price")
	private BigDecimal price;
	//金额
	@TableField("amount")
	private BigDecimal amount;
	//约定交期(yyyy-MM-dd)
	@TableField("expect_date")
	private Date expectDate;

	//状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
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
	public void setPlanDetailId(String planDetailId) {
		this.planDetailId = planDetailId;
	}
	public String getPlanDetailId() {
		return planDetailId;
	}
	public void setAssistProductId(String assistProductId) {
		this.assistProductId = assistProductId;
	}
	public String getAssistProductId() {
		return assistProductId;
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
	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}
	public BigDecimal getLossRatio() {
		return lossRatio;
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
	public void setExpectDate(Date expectDate) {
		this.expectDate = expectDate;
	}
	public Date getExpectDate() {
		return expectDate;
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
