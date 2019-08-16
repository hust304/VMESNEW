package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_initial:仓库初始化设定 实体类
 * @author 陈刚 自动生成
 * @date 2018-11-20
 */
@TableName("vmes_warehouse_initial")
public class WarehouseInitial implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//备注
	@TableField("remark")
	private String remark;
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
	//是否启用(0:已禁用 1:启用)
	@TableField("isdisable")
	private String isdisable;
	//是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
	//0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
	@TableField("is_disable_button")
	private String isDisableButton;
	//仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
	@TableField("warehouse_attribute")
	private String warehouseAttribute;


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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
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
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getIsdisable() {
		return isdisable;
	}
	public String getIsDisableButton() {
		return isDisableButton;
	}
	public void setIsDisableButton(String isDisableButton) {
		this.isDisableButton = isDisableButton;
	}
	public String getWarehouseAttribute() {
		return warehouseAttribute;
	}
	public void setWarehouseAttribute(String warehouseAttribute) {
		this.warehouseAttribute = warehouseAttribute;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
