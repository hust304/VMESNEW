package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：设置锁库时间 实体类
 * @author 刘威 自动生成
 * @date 2018-12-12
 */
@TableName("vmes_sale_lock_date")
public class SaleLockDate implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//公司id
	@TableField("company_id")
	private String companyId;
	//天
	@TableField("day")
	private Integer day;
	//时
	@TableField("hour")
	private Integer hour;
	//分
	@TableField("minute")
	private Integer minute;
	//秒
	@TableField("second")
	private Integer second;
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
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getDay() {
		return day;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Integer getHour() {
		return hour;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Integer getMinute() {
		return minute;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getSecond() {
		return second;
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
