package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_in:仓库入库单 实体类
 * @author 陈刚 自动生成
 * @date 2018-10-16
 */
@TableName("vmes_warehouse_in")
public class WarehouseIn implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID-组织架构
	@TableField("company_id")
	private String companyId;
	//入库单编码
	@TableField("code")
	private String code;
	//入库类型-(字典表-vmes_dictionary.id)
	@TableField("type")
	private String type;
	//仓库ID(仓库表-layer:2的记录)
	@TableField("warehouse_id")
	private String warehouseId;

	//单位id(部门id或客户id)
	@TableField("dept_id")
	private String deptId;
	//单位名称(部门或客户)
	@TableField("dept_name")
	private String deptName;
	//制单人ID
	@TableField("make_id")
	private String makeId;
	//状态(0:未完成 1:已完成 -1:已取消)
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

	//是否简版仓库 Y:是简版 N:非简版 is null:非简版
	@TableField("is_simple")
	private String isSimple;


	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}
	public String getMakeId() {
		return makeId;
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
	public String getIsSimple() {
		return isSimple;
	}
//	public void setIsSimple(String isSimple) {
//		this.isSimple = isSimple;
//	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
