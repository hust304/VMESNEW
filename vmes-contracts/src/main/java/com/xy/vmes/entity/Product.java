package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_product:产品表 实体类
 * @author 陈刚 自动生成
 * @date 2018-09-21
 */
@TableName("vmes_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//公司ID-组织架构
	@TableField("company_id")
	private String companyId;
	//二维码-(图片相对路径)
	@TableField("qrcode")
	private String qrcode;
	//产品编码
	@TableField("code")
	private String code;
	//产品名称
	@TableField("name")
	private String name;
	//英文名称
	@TableField("name_en")
	private String nameEn;
	//规格型号
	@TableField("spec")
	private String spec;
	//产品属性(字典表-vmes_dictionary.id)
	@TableField("genre")
	private String genre;
	//计量单位(字典表-vmes_dictionary.id)
	@TableField("unit")
	private String unit;
	//结算单位(字典表-vmes_dictionary.id)
	@TableField("last_unit")
	private String lastUnit;
	//结算比例
	@TableField("last_ratio")
	private BigDecimal lastRatio;
	//单价
	@TableField("price")
	private BigDecimal price;
	//类型(字典表-vmes_dictionary.id)
	@TableField("type")
	private String type;
	//保存期(yyyy-mm-dd)
	@TableField("validity_date")
	private Date validityDate;
	//保质期(天)
	@TableField("validity_days")
	private BigDecimal validityDays;
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
	//产品图片
	@TableField("photo")
	private String photo;

	//库存数量
	@TableField("stock_count")
	private BigDecimal stockCount;
	//安全库存数量
	@TableField("safety_count")
	private BigDecimal safetyCount;
	//乐观锁
	@TableField("version")
	private Integer version;

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
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getSpec() {
		return spec;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGenre() {
		return genre;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setLastUnit(String lastUnit) {
		this.lastUnit = lastUnit;
	}
	public String getLastUnit() {
		return lastUnit;
	}
	public void setLastRatio(BigDecimal lastRatio) {
		this.lastRatio = lastRatio;
	}
	public BigDecimal getLastRatio() {
		return lastRatio;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
	public Date getValidityDate() {
		return validityDate;
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
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhoto() {
		return photo;
	}
	public BigDecimal getStockCount() {
		return stockCount;
	}
	public void setStockCount(BigDecimal stockCount) {
		this.stockCount = stockCount;
	}
	public BigDecimal getSafetyCount() {
		return safetyCount;
	}
	public void setSafetyCount(BigDecimal safetyCount) {
		this.safetyCount = safetyCount;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public BigDecimal getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(BigDecimal validityDays) {
		this.validityDays = validityDays;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
