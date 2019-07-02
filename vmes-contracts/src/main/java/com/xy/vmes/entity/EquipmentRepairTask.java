package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_equipment_repairTask:设备维修任务表 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-02
 */
@TableName("vmes_equipment_repairTask")
public class EquipmentRepairTask implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//设备维修单id
	@TableField("repair_id")
	private String repairId;
	//维修人id
	@TableField("repair_user")
	private String repairUser;
	//故障描述
	@TableField("fault_describe")
	private String faultDescribe;
	//预计维修时长(单位秒)
	@TableField("time_length")
	private BigDecimal timeLength;

	//执行结果(0:未解决 1:已解决)
	@TableField("task_result")
	private String taskResult;
	//任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
	@TableField("task_state")
	private String taskState;
	//任务类型(1:维修 2:退单)
	@TableField("task_type")
	private String taskType;
	//任务领取时间
	@TableField("receive_date")
	private Date receiveDate;
	//取消原因
	@TableField("cancel_reason")
	private String cancelReason;

	//取消时间
	@TableField("cancel_date")
	private Date cancelDate;
	//取消人id
	@TableField("cancel_user")
	private String cancelUser;
	//退回方式(1:退回仓库, 2:退回虚拟库)
	@TableField("retreat_type")
	private String retreatType;
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
	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}
	public String getRepairId() {
		return repairId;
	}
	public void setRepairUser(String repairUser) {
		this.repairUser = repairUser;
	}
	public String getRepairUser() {
		return repairUser;
	}
	public void setFaultDescribe(String faultDescribe) {
		this.faultDescribe = faultDescribe;
	}
	public String getFaultDescribe() {
		return faultDescribe;
	}
	public void setTimeLength(BigDecimal timeLength) {
		this.timeLength = timeLength;
	}
	public BigDecimal getTimeLength() {
		return timeLength;
	}
	public void setTaskResult(String taskResult) {
		this.taskResult = taskResult;
	}
	public String getTaskResult() {
		return taskResult;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	public Date getReceiveDate() {
		return receiveDate;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelUser(String cancelUser) {
		this.cancelUser = cancelUser;
	}
	public String getCancelUser() {
		return cancelUser;
	}
	public void setRetreatType(String retreatType) {
		this.retreatType = retreatType;
	}
	public String getRetreatType() {
		return retreatType;
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
