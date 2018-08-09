package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_loginfo:系统日志表 实体类
 * @author 陈刚 自动生成
 * @date 2018-08-08
 */
@TableName("vmes_loginfo")
public class Loginfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//日志类型 operate:操作日志 state:状态日志
	@TableField("type")
	private String type;
	//业务单ID
	@TableField("business_id")
	private String businessId;
	//业务类别(1:生产计划 2:产品 3:部门 4:部门子计划 5:派工单 6:子派工单)
	@TableField("business_type")
	private String businessType;
	//产生源(app:终端操作 web:web端操作 sys:系统产生)
	@TableField("source")
	private String source;
	//业务名称 (表名)
	@TableField("table_name")
	private String tableName;
	//业务操作类型 (add,update,delete)
	@TableField("operate")
	private Integer operate;
	//备注
	@TableField("remark")
	private String remark;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//创建人账号
	@TableField("cuser")
	private String cuser;
	//(删除,修改)-业务id字符串
	@TableField("operate_value")
	private String operateValue;



	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSource() {
		return source;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setOperate(Integer operate) {
		this.operate = operate;
	}
	public Integer getOperate() {
		return operate;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCuser() {
		return cuser;
	}
	public void setOperateValue(String operateValue) {
		this.operateValue = operateValue;
	}
	public String getOperateValue() {
		return operateValue;
	}

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
