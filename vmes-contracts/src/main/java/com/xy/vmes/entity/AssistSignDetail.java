package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_sign_detail:外协签收单明细 实体类
 * @author 陈刚 自动生成
 * @date 2020-05-04
 */
@TableName("vmes_assist_sign_detail")
public class AssistSignDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//签收单id
	@TableField("parent_id")
	private String parentId;
	//采购订单id
	@TableField("order_id")
	private String orderId;
	//采购订单明细id
	@TableField("order_detail_id")
	private String orderDetailId;
	//(免检签收入库)入库单明细id
	@TableField("in_detail_id")
	private String inDetailId;

	//外协件id
	@TableField("assist_product_id")
	private String assistProductId;
	//单据单位id
	@TableField("order_unit")
	private String orderUnit;
	//签收数量
	@TableField("arrive_count")
	private BigDecimal arriveCount;
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
	@TableField("quality_indtl_id")
	private String qualityIndtlId;

	//(检验让步接收入库)入库单明细id
	@TableField("receive_indtl_id")
	private String receiveIndtlId;
	//状态(1:检验中 2:已完成 -1:已取消)
	@TableField("state")
	private String state;
	//收货合格数(签收数-退货数)
	@TableField("sign_fine_count")
	private BigDecimal signFineCount;
	//(实际)检验合格数(签收数-不合格数)
	@TableField("quality_fine_count")
	private BigDecimal qualityFineCount;
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
	public void setArriveCount(BigDecimal arriveCount) {
		this.arriveCount = arriveCount;
	}
	public BigDecimal getArriveCount() {
		return arriveCount;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getQuality() {
		return quality;
	}
	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
	}
	public String getQualityType() {
		return qualityType;
	}
	public void setQualityCount(BigDecimal qualityCount) {
		this.qualityCount = qualityCount;
	}
	public BigDecimal getQualityCount() {
		return qualityCount;
	}
	public void setBadCount(BigDecimal badCount) {
		this.badCount = badCount;
	}
	public BigDecimal getBadCount() {
		return badCount;
	}
	public void setRetreatCount(BigDecimal retreatCount) {
		this.retreatCount = retreatCount;
	}
	public BigDecimal getRetreatCount() {
		return retreatCount;
	}
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}
	public void setQualityIndtlId(String qualityIndtlId) {
		this.qualityIndtlId = qualityIndtlId;
	}
	public String getQualityIndtlId() {
		return qualityIndtlId;
	}
	public void setReceiveIndtlId(String receiveIndtlId) {
		this.receiveIndtlId = receiveIndtlId;
	}
	public String getReceiveIndtlId() {
		return receiveIndtlId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setSignFineCount(BigDecimal signFineCount) {
		this.signFineCount = signFineCount;
	}
	public BigDecimal getSignFineCount() {
		return signFineCount;
	}
	public void setQualityFineCount(BigDecimal qualityFineCount) {
		this.qualityFineCount = qualityFineCount;
	}
	public BigDecimal getQualityFineCount() {
		return qualityFineCount;
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
