package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;

/** 
 * 说明：vmes_assist_product:外协件 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-19
 */
@TableName("vmes_assist_product")
public class AssistProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//外协货品id(系统货品表id)
	@TableField("product_id")
	private String productId;
	//外协货品名称
	@TableField("product_name")
	private String productName;
	//工艺名称id
	@TableField("craft_id")
	private String craftId;
	//单位id
	@TableField("unit_id")
	private String unitId;

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
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setCraftId(String craftId) {
		this.craftId = craftId;
	}
	public String getCraftId() {
		return craftId;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
