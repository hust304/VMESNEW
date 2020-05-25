package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_retreat_detail:外协退货明细 实体类
 * @author 陈刚 自动生成
 * @date 2020-05-07
 */
@TableName("vmes_assist_retreat_detail")
public class AssistRetreatDetail implements Serializable {
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
	//发货明细子表id(原材料)(废弃字段)
	@TableField("deliver_dtl_child_id")
	private String deliverDtlChildId;

	//外协发货明细id(废弃字段)
	@TableField("deliver_dtl_id")
	private String deliverDtlId;
	//外协发货id(废弃字段)
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

	//退货数量(订单单位)
	@TableField("order_count")
	private BigDecimal orderCount;
	//单价(外协件)
	@TableField("price")
	private BigDecimal price;
	//金额(外协件)
	@TableField("amount")
	private BigDecimal amount;
	//状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
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

	//质检属性 (1:免检 2:检验)
	@TableField("quality")
	private String quality;
	//检验方式 (1:全检 2:抽检)
	@TableField("quality_type")
	private String qualityType;
	//(实际)检验数量
	@TableField("quality_count")
	private BigDecimal qualityCount;
	//(检验)不合格数量
	@TableField("bad_count")
	private BigDecimal badCount;
	//(检验)报废数量
	@TableField("discard_count")
	private BigDecimal discardCount;

	//(检验)让步接收数量
	@TableField("receive_count")
	private BigDecimal receiveCount;
	//(检验入库)入库单明细id
	@TableField("quality_inDtl_id")
	private String qualityInDtlId;
	//(检验让步接收入库)入库单明细id
	@TableField("receive_inDtl_id")
	private String receiveInDtlId;
	//收货合格数(签收数-退货数)
	@TableField("sign_fine_count")
	private BigDecimal signFineCount;
	//(实际)检验合格数(签收数-不合格数)
	@TableField("quality_fine_count")
	private BigDecimal qualityFineCount;

	//出库明细ID
	@TableField("out_dtl_id")
	private String outDtlId;
	//订单明细子表id
	@TableField("orderDtl_child_id")
	private String orderDtlChildId;


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
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getQualityType() {
		return qualityType;
	}
	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
	}
	public BigDecimal getQualityCount() {
		return qualityCount;
	}
	public void setQualityCount(BigDecimal qualityCount) {
		this.qualityCount = qualityCount;
	}
	public BigDecimal getBadCount() {
		return badCount;
	}
	public void setBadCount(BigDecimal badCount) {
		this.badCount = badCount;
	}
	public BigDecimal getDiscardCount() {
		return discardCount;
	}
	public void setDiscardCount(BigDecimal discardCount) {
		this.discardCount = discardCount;
	}
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}
	public String getQualityInDtlId() {
		return qualityInDtlId;
	}
	public void setQualityInDtlId(String qualityInDtlId) {
		this.qualityInDtlId = qualityInDtlId;
	}
	public String getReceiveInDtlId() {
		return receiveInDtlId;
	}
	public void setReceiveInDtlId(String receiveInDtlId) {
		this.receiveInDtlId = receiveInDtlId;
	}
	public BigDecimal getSignFineCount() {
		return signFineCount;
	}
	public void setSignFineCount(BigDecimal signFineCount) {
		this.signFineCount = signFineCount;
	}
	public BigDecimal getQualityFineCount() {
		return qualityFineCount;
	}
	public void setQualityFineCount(BigDecimal qualityFineCount) {
		this.qualityFineCount = qualityFineCount;
	}
	public String getOutDtlId() {
		return outDtlId;
	}
	public void setOutDtlId(String outDtlId) {
		this.outDtlId = outDtlId;
	}
	public String getOrderDtlChildId() {
		return orderDtlChildId;
	}
	public void setOrderDtlChildId(String orderDtlChildId) {
		this.orderDtlChildId = orderDtlChildId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
