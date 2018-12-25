package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：收款记录 实体类
 * @author 刘威 自动生成
 * @date 2018-12-25
 */
@TableName("vmes_sale_receive_record")
public class SaleReceiveRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//客户ID
	@TableField("customer_id")
	private String customerId;
	//操作类型（0：改 1：加  -1：减 ）
	@TableField("type")
	private String type;
	//操作值
	@TableField("amount")
	private BigDecimal amount;
	//操作后余额
	@TableField("after_amount")
	private BigDecimal afterAmount;
	//操作前余额
	@TableField("before_amount")
	private BigDecimal beforeAmount;
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
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAfterAmount(BigDecimal afterAmount) {
		this.afterAmount = afterAmount;
	}
	public BigDecimal getAfterAmount() {
		return afterAmount;
	}
	public void setBeforeAmount(BigDecimal beforeAmount) {
		this.beforeAmount = beforeAmount;
	}
	public BigDecimal getBeforeAmount() {
		return beforeAmount;
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
