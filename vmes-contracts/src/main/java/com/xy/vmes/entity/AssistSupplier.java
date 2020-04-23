package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_assist_supplier:外协供应商 实体类
 * @author 陈刚 自动生成
 * @date 2020-04-23
 */
@TableName("vmes_assist_supplier")
public class AssistSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//企业id
	@TableField("company_id")
	private String companyId;
	//供应商id
	@TableField("supplier_id")
	private String supplierId;
	//外协件id
	@TableField("assist_product_id")
	private String assistProductId;
	//单价
	@TableField("price")
	private BigDecimal price;

	//损耗率
	@TableField("loss_ratio")
	private BigDecimal lossRatio;
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
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setAssistProductId(String assistProductId) {
		this.assistProductId = assistProductId;
	}
	public String getAssistProductId() {
		return assistProductId;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}
	public BigDecimal getLossRatio() {
		return lossRatio;
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
