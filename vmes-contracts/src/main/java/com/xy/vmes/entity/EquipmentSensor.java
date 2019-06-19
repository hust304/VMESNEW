package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_equipment_sensor:设备传感器指标(设备联网) 实体类
 * @author 陈刚 自动生成
 * @date 2019-06-19
 */
@TableName("vmes_equipment_sensor")
public class EquipmentSensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//设备ID
	@TableField("equipment_id")
	private String equipmentId;
	//指标类型(A:传感器指标 B:分析指标)
	@TableField("target_type")
	private String targetType;
	//指标编号-(A0001,B0001)-(与表vmes_source_sensor字段对应)
	@TableField("target_code")
	private String targetCode;

	//指标名称
	@TableField("target_name")
	private String targetName;
	//指标公式
	@TableField("target_formula")
	private String targetFormula;
	//指标公式(转换栏位名称公式-SQL查询语句直接使用)
	@TableField("target_formula_column")
	private String targetFormulaColumn;
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
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}
	public String getTargetCode() {
		return targetCode;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetFormula(String targetFormula) {
		this.targetFormula = targetFormula;
	}
	public String getTargetFormula() {
		return targetFormula;
	}
	public void setTargetFormulaColumn(String targetFormulaColumn) {
		this.targetFormulaColumn = targetFormulaColumn;
	}
	public String getTargetFormulaColumn() {
		return targetFormulaColumn;
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
