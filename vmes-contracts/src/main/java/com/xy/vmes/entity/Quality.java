package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_quality:质量检验项目 实体类
 * @author 陈刚 自动生成
 * @date 2019-12-28
 */
@TableName("vmes_quality")
public class Quality implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//货品id
	@TableField("product_id")
	private String productId;
	//系统编号(系统生成)
	@TableField("sys_code")
	private String sysCode;
	//质检项
	@TableField("name")
	private String name;

	//检验标准
	@TableField("criterion")
	private String criterion;
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
	//业务名称 (purchase:采购)
	@TableField("business")
	private String business;


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
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCriterion(String criterion) {
		this.criterion = criterion;
	}
	public String getCriterion() {
		return criterion;
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
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
