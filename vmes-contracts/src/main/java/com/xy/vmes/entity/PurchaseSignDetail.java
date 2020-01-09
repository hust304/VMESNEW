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

	@TableField("id")
	private String id;
	//采购签收单ID
	@TableField("parent_id")
	private String parentId;
	//采购订单明细ID
	@TableField("order_detail_id")
	private String orderDetailId;
	//(签收入库)入库单明细id
	@TableField("in_detail_id")
	private String inDetailId;
	//产品ID
	@TableField("product_id")
	private String productId;

	//签收数量
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
	//采购订单id
	@TableField("order_id")
	private String orderId;
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
	//(检验)退货数量
	@TableField("retreat_count")
	private BigDecimal retreatCount;
	//(检验)让步接收数量
	@TableField("receive_count")
	private BigDecimal receiveCount;
	//(检验入库)入库单明细id
	@TableField("quality_inDtl_id")
	private String qualityInDtlId;

	//(检验让步接收入库)入库单明细id
	@TableField("receive_inDtl_id")
	private String receiveInDtlId;
	//状态(1:检验中 2:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//单据单位id(采购订单单位)
	@TableField("order_unit")
	private String orderUnit;

	//非表字段 传值使用
	private String n2pFormula;
	private String	n2pIsScale;
	private Integer n2pDecimalCount;

	private String p2nFormula;
	private String	p2nIsScale;
	private Integer p2nDecimalCount;


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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public BigDecimal getRetreatCount() {
		return retreatCount;
	}
	public void setRetreatCount(BigDecimal retreatCount) {
		this.retreatCount = retreatCount;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderUnit() {
		return orderUnit;
	}
	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	//////////////////////////////////////////////////////////////////
	public String getN2pFormula() {
		return n2pFormula;
	}
	public void setN2pFormula(String n2pFormula) {
		this.n2pFormula = n2pFormula;
	}
	public String getN2pIsScale() {
		return n2pIsScale;
	}
	public void setN2pIsScale(String n2pIsScale) {
		this.n2pIsScale = n2pIsScale;
	}
	public Integer getN2pDecimalCount() {
		return n2pDecimalCount;
	}
	public void setN2pDecimalCount(Integer n2pDecimalCount) {
		this.n2pDecimalCount = n2pDecimalCount;
	}
	public String getP2nFormula() {
		return p2nFormula;
	}
	public void setP2nFormula(String p2nFormula) {
		this.p2nFormula = p2nFormula;
	}
	public String getP2nIsScale() {
		return p2nIsScale;
	}
	public void setP2nIsScale(String p2nIsScale) {
		this.p2nIsScale = p2nIsScale;
	}
	public Integer getP2nDecimalCount() {
		return p2nDecimalCount;
	}

	public void setP2nDecimalCount(Integer p2nDecimalCount) {
		this.p2nDecimalCount = p2nDecimalCount;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
