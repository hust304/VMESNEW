package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：收款单明细 实体类
 * @author 刘威 自动生成
 * @date 2018-12-24
 */
@TableName("vmes_sale_receive_detail")
public class SaleReceiveDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//订单ID
	@TableField("order_id")
	private String orderId;
	//上级ID
	@TableField("parent_id")
	private String parentId;
	//收款类型(1:预收款 2:普通收款)
	@TableField("type")
	private String type;
	//收款单状态(0:待收款 1:已收款 -1:已取消)
	@TableField("state")
	private String state;
	//已收款
	@TableField("receive_amount")
	private BigDecimal receiveAmount;
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
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
	public BigDecimal getReceiveAmount() {
		return receiveAmount;
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
