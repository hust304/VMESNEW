package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_sale_deliver_detail:发货明细 实体类
 * @author 陈刚 自动生成
 * @date 2018-12-15
 */
@TableName("vmes_sale_deliver_detail")
public class SaleDeliverDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//发货单ID
	@TableField("parent_id")
	private String parentId;
	//订单ID
	@TableField("order_id")
	private String orderId;
	//订单明细ID
	@TableField("order_detai_id")
	private String orderDetaiId;
	//出单明细id
	@TableField("out_detail_id")
	private String outDetailId;

    //货品ID
    @TableField("product_id")
    private String productId;
	//发货状态(0:待发货 1:已发货 -1:已取消)
	@TableField("state")
	private String state;
	//货品单价
	@TableField("product_price")
	private BigDecimal productPrice;
	//订单明细单位id
	@TableField("order_unit")
	private String orderUnit;
	//计价单位id
	@TableField("price_unit")
	private String priceUnit;

	//发货数量
	@TableField("count")
	private BigDecimal count;
	//发货金额
	@TableField("sum")
	private BigDecimal sum;
	//发货日期
	@TableField("deliver_date")
	private Date deliverDate;
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
	public void setOrderDetaiId(String orderDetaiId) {
		this.orderDetaiId = orderDetaiId;
	}
	public String getOrderDetaiId() {
		return orderDetaiId;
	}
	public void setOutDetailId(String outDetailId) {
		this.outDetailId = outDetailId;
	}
	public String getOutDetailId() {
		return outDetailId;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
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
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }
	public String getOrderUnit() {
		return orderUnit;
	}
	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
