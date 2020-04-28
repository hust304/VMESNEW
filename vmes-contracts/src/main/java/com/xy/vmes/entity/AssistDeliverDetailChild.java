package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_deliver_detail_child:外协发货明细子表 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-27
 */
@TableName("vmes_assist_deliver_detail_child")
public class AssistDeliverDetailChild implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//外协发货单id
	@TableField("deliver_id")
	private String deliverId;
	//外协发货明细id
	@TableField("deliver_dtl_id")
	private String deliverDtlId;
	//出库单明细id
	@TableField("out_dtl_id")
	private String outDtlId;
	//入库单明细id
	@TableField("in_dtl_id")
	private String inDtlId;

	//订单明细子表id
	@TableField("orderDtl_child_id")
	private String orderDtlChildId;
	//原材料id(系统货品表id)
	@TableField("product_id")
	private String productId;
	//单位id
	@TableField("unit_id")
	private String unitId;
	//用料比例
	@TableField("ratio")
	private BigDecimal ratio;
	//原材料数量(单据单位)
	@TableField("count")
	private BigDecimal count;

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
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverDtlId(String deliverDtlId) {
		this.deliverDtlId = deliverDtlId;
	}
	public String getDeliverDtlId() {
		return deliverDtlId;
	}
	public void setOutDtlId(String outDtlId) {
		this.outDtlId = outDtlId;
	}
	public String getOutDtlId() {
		return outDtlId;
	}
	public void setInDtlId(String inDtlId) {
		this.inDtlId = inDtlId;
	}
	public String getInDtlId() {
		return inDtlId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
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
	public String getOrderDtlChildId() {
		return orderDtlChildId;
	}
	public void setOrderDtlChildId(String orderDtlChildId) {
		this.orderDtlChildId = orderDtlChildId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
