package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 实体类
 * @author 陈刚 自动生成
 * @date 2018-11-15
 */
@TableName("vmes_warehouse_check_execute")
public class WarehouseCheckExecute implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//盘点单ID
	@TableField("parent_id")
	private String parentId;
	//入库明细ID
	@TableField("detail_id")
	private String detailId;
	//执行人ID
	@TableField("executor_id")
	private String executorId;
	//审核人ID
	@TableField("audit_id")
	private String auditId;

	//盘点数量
	@TableField("count")
	private BigDecimal count;
	// 状态(0:待审核 2:同意 3:不同意)
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
	//审核时间
	@TableField("audit_date")
	private Date auditDate;


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
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}
	public String getExecutorId() {
		return executorId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
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
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
