package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_equipment_maintain:设备保养单 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-29
 */
@TableName("vmes_equipment_maintain")
public class EquipmentMaintain implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//设备ID
	@TableField("equipment_id")
	private String equipmentId;
	//保养内容ID(保养内容表vmes_equipment_maintain_content.id)
	@TableField("maintain_content_id")
	private String maintainContentId;
	//是否停机 (1:停机保养 0:非停机保养)
	@TableField("is_stop")
	private String isStop;

	//保养计划ID
	@TableField("plan_id")
	private String planId;
	//保养任务ID
	@TableField("maintain_task_id")
	private String maintainTaskId;
	//保养单编号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//保养开始时间(根据保养计划-系统计算)
	@TableField("sys_begin_time")
	private Date sysBeginTime;
	//保养结束时间(根据保养计划-系统计算)
	@TableField("sys_end_time")
	private Date sysEndTime;

	//保养时间(yyyy-MM-dd)
	@TableField("maintain_date")
	private Date maintainDate;
	//下一保养时间(yyyy-MM-dd)
	@TableField("next_maintain_date")
	private Date nextMaintainDate;
	//设备状态(1:待保养 2:保养中 3:已完成)
	@TableField("equipment_state")
	private String equipmentState;
	//开始保养时间
	@TableField("begin_time")
	private Date beginTime;
	//完成保养时间
	@TableField("end_time")
	private Date endTime;

	//取消原因
	@TableField("cancel_reason")
	private String cancelReason;
	//取消时间
	@TableField("cancel_date")
	private Date cancelDate;
	//取消人id
	@TableField("cancel_user")
	private String cancelUser;
	//是否允许保养(0:不允许 1:允许)
	@TableField("is_allow_maintain")
	private String isAllowMaintain;
	//保养单有效状态(1:有效 0:无效 is null 无效)
	@TableField("is_valid_state")
	private String isValidState;

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
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setMaintainContentId(String maintainContentId) {
		this.maintainContentId = maintainContentId;
	}
	public String getMaintainContentId() {
		return maintainContentId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setMaintainTaskId(String maintainTaskId) {
		this.maintainTaskId = maintainTaskId;
	}
	public String getMaintainTaskId() {
		return maintainTaskId;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setSysBeginTime(Date sysBeginTime) {
		this.sysBeginTime = sysBeginTime;
	}
	public Date getSysBeginTime() {
		return sysBeginTime;
	}
	public void setSysEndTime(Date sysEndTime) {
		this.sysEndTime = sysEndTime;
	}
	public Date getSysEndTime() {
		return sysEndTime;
	}
	public void setMaintainDate(Date maintainDate) {
		this.maintainDate = maintainDate;
	}
	public Date getMaintainDate() {
		return maintainDate;
	}
	public void setNextMaintainDate(Date nextMaintainDate) {
		this.nextMaintainDate = nextMaintainDate;
	}
	public Date getNextMaintainDate() {
		return nextMaintainDate;
	}
	public void setEquipmentState(String equipmentState) {
		this.equipmentState = equipmentState;
	}
	public String getEquipmentState() {
		return equipmentState;
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
	public void setIsAllowMaintain(String isAllowMaintain) {
		this.isAllowMaintain = isAllowMaintain;
	}
	public String getIsAllowMaintain() {
		return isAllowMaintain;
	}
	public void setIsValidState(String isValidState) {
		this.isValidState = isValidState;
	}
	public String getIsValidState() {
		return isValidState;
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
	public String getIsStop() {
		return isStop;
	}
	public void setIsStop(String isStop) {
		this.isStop = isStop;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
