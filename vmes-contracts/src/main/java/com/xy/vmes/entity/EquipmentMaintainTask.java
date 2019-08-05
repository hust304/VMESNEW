package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_equipment_maintainTask:设备保养任务 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-29
 */
@TableName("vmes_equipment_maintainTask")
public class EquipmentMaintainTask implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//保养单id
	@TableField("maintain_id")
	private String maintainId;
	//保养人id
	@TableField("maintain_user")
	private String maintainUser;
	//保养描述
	@TableField("maintain_describe")
	private String maintainDescribe;
	//执行结果(0:未解决 1:已解决)
	@TableField("task_result")
	private String taskResult;

	//任务状态(0:未领取任务 1:已领取任务 2:已领料 3:已报工 4:已退单 )
	@TableField("task_state")
	private String taskState;
	//任务类型(1:保养 2:退单)
	@TableField("task_type")
	private String taskType;
	//任务开始时间(领取时间)
	@TableField("begin_time")
	private Date beginTime;
	//任务结束时间
	@TableField("end_time")
	private Date endTime;
	//取消原因
	@TableField("cancel_reason")
	private String cancelReason;

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
	public void setMaintainId(String maintainId) {
		this.maintainId = maintainId;
	}
	public String getMaintainId() {
		return maintainId;
	}
	public void setMaintainUser(String maintainUser) {
		this.maintainUser = maintainUser;
	}
	public String getMaintainUser() {
		return maintainUser;
	}
	public String getMaintainDescribe() {
		return maintainDescribe;
	}
	public void setMaintainDescribe(String maintainDescribe) {
		this.maintainDescribe = maintainDescribe;
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
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getCancelReason() {
		return cancelReason;
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
