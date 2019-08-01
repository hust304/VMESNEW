package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_equipment_repair:设备维修表 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-01
 */
@TableName("vmes_equipment_repair")
public class EquipmentRepair implements Serializable {
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
	//维修任务ID
	@TableField("repair_task_id")
	private String repairTaskId;
	//维修单编号(系统生成)
	@TableField("sys_code")
	private String sysCode;

	//报警时间
	@TableField("warn_date")
	private Date warnDate;
	//故障描述
	@TableField("fault_describe")
	private String faultDescribe;
	//是否停机 (1:停机维修 0:非停机维修)
	@TableField("is_stop")
	private String isStop;
	//设备状态(1:故障 2:维修中 3:已完成)
	@TableField("equipment_state")
	private String equipmentState;
	//开始维修时间
	@TableField("begin_time")
	private Date beginTime;

	//完成维修时间
	@TableField("end_time")
	private Date endTime;
	//取消原因
	@TableField("cancel_reason")
	private String cancelReason;
	//取消时间
	@TableField("cancel_date")
	private Date cancelDate;
	//取消人
	@TableField("cancel_user")
	private String cancelUser;
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
	public void setRepairTaskId(String repairTaskId) {
		this.repairTaskId = repairTaskId;
	}
	public String getRepairTaskId() {
		return repairTaskId;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setWarnDate(Date warnDate) {
		this.warnDate = warnDate;
	}
	public Date getWarnDate() {
		return warnDate;
	}
	public String getFaultDescribe() {
		return faultDescribe;
	}
	public void setFaultDescribe(String faultDescribe) {
		this.faultDescribe = faultDescribe;
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
