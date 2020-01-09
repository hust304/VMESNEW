package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_purchase_quality_detail:采购质检项明细 实体类
 * @author 陈刚 自动生成
 * @date 2020-01-09
 */
@TableName("vmes_purchase_quality_detail")
public class PurchaseQualityDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//采购订单明细ID
	@TableField("sign_detail_id")
	private String signDetailId;
	//货品id
	@TableField("product_id")
	private String productId;
	//单据单位id(采购订单单位)
	@TableField("order_unit")
	private String orderUnit;
	//质检项id
	@TableField("quality_id")
	private String qualityId;

	//(质检项)不合格数量
	@TableField("bad_count")
	private BigDecimal badCount;
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
	public void setSignDetailId(String signDetailId) {
		this.signDetailId = signDetailId;
	}
	public String getSignDetailId() {
		return signDetailId;
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
	public void setQualityId(String qualityId) {
		this.qualityId = qualityId;
	}
	public String getQualityId() {
		return qualityId;
	}
	public void setBadCount(BigDecimal badCount) {
		this.badCount = badCount;
	}
	public BigDecimal getBadCount() {
		return badCount;
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
