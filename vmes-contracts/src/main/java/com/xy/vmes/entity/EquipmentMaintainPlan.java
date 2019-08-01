package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_equipment_maintain_plan:设备保养计划 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-25
 */
@TableName("vmes_equipment_maintain_plan")
public class EquipmentMaintainPlan implements Serializable,Cloneable {
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

	//保养计划单编号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//保养方式(自定义 按周期 数据字典-vmes_dictionary.id)
	@TableField("mode_id")
	private String modeId;
	//计划保养时间
	@TableField("maintain_date")
	private Date maintainDate;
	//计划开始日期
	@TableField("begin_plan")
	private Date beginPlan;
	//计划结束日期
	@TableField("end_plan")
	private Date endPlan;

	//重复频率类型(day:天 week:周 month:月)
	@TableField("period_type")
	private String periodType;
	//重复频率数字(间隔数字)
	@TableField("period_count")
	private Integer periodCount;
	//重复时间(周)-(SUNDAY:周日 MONDAY:周1 TUESDAY:周2 WEDNESDAY:周3 THURSDAY:周4 FRIDAY:周5 SATURDAY:周6)
	@TableField("period_dayofweek")
	private String periodDayofweek;
	//重复时间(月)-(01-31)
	@TableField("period_dayofmonth")
	private String periodDayofmonth;
	//重复时间(天)-(01-24)
	@TableField("period_hourofday")
	private String periodHourofday;

	//自定义重复名称
	@TableField("period_name")
	private String periodName;
	//重复类型 (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
	@TableField("sys_period_type")
	private String sysPeriodType;
	//重复类型名称
	@TableField("sys_period_type_name")
	private String sysPeriodTypeName;
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
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setMaintainContentId(String maintainContentId) {
		this.maintainContentId = maintainContentId;
	}
	public String getMaintainContentId() {
		return maintainContentId;
	}
	public void setModeId(String modeId) {
		this.modeId = modeId;
	}
	public String getModeId() {
		return modeId;
	}
	public void setMaintainDate(Date maintainDate) {
		this.maintainDate = maintainDate;
	}
	public Date getMaintainDate() {
		return maintainDate;
	}
	public void setBeginPlan(Date beginPlan) {
		this.beginPlan = beginPlan;
	}
	public Date getBeginPlan() {
		return beginPlan;
	}
	public void setEndPlan(Date endPlan) {
		this.endPlan = endPlan;
	}
	public Date getEndPlan() {
		return endPlan;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodCount(Integer periodCount) {
		this.periodCount = periodCount;
	}
	public Integer getPeriodCount() {
		return periodCount;
	}
	public void setPeriodDayofweek(String periodDayofweek) {
		this.periodDayofweek = periodDayofweek;
	}
	public String getPeriodDayofweek() {
		return periodDayofweek;
	}
	public void setPeriodDayofmonth(String periodDayofmonth) {
		this.periodDayofmonth = periodDayofmonth;
	}
	public String getPeriodDayofmonth() {
		return periodDayofmonth;
	}
	public void setPeriodHourofday(String periodHourofday) {
		this.periodHourofday = periodHourofday;
	}
	public String getPeriodHourofday() {
		return periodHourofday;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setSysPeriodType(String sysPeriodType) {
		this.sysPeriodType = sysPeriodType;
	}
	public String getSysPeriodType() {
		return sysPeriodType;
	}
	public void setSysPeriodTypeName(String sysPeriodTypeName) {
		this.sysPeriodTypeName = sysPeriodTypeName;
	}
	public String getSysPeriodTypeName() {
		return sysPeriodTypeName;
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
public EquipmentMaintainPlan clone() {
	EquipmentMaintainPlan object = null;
	try{
		object = (EquipmentMaintainPlan)super.clone();
	}catch(CloneNotSupportedException e) {
		e.printStackTrace();
	}
	return object;
}

}
