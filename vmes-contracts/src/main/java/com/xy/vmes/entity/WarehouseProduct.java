package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_product:仓库货位产品库存表 实体类
 * @author 陈刚 自动生成
 * @date 2018-10-16
 */
@TableName("vmes_warehouse_product")
public class WarehouseProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;
	//二维码
	@TableField("qrcode")
	private String qrcode;
	//企业ID-组织架构
	@TableField("company_id")
	private String companyId;
	//仓库货位ID
	@TableField("warehouse_id")
	private String warehouseId;
	//产品ID
	@TableField("product_id")
	private String productId;

	//货位批次号
	@TableField("code")
	private String code;
	//库存数量
	@TableField("stock_count")
	private BigDecimal stockCount;
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
	//审核时间
	@TableField("audit_date")
	private Date auditDate;
	//备注
	@TableField("remark")
	private String remark;
	//是否启用(0:已禁用 1:启用)
	@TableField("isdisable")
	private String isdisable;
	//版本号(库存数量修改时)
	@TableField("version")
	private Integer version;

	//企业定制化字段///////////////////////////////////////////////////////////////////////////
	//货品单价(计量单位)
	@TableField("price")
	private BigDecimal price;


	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setStockCount(BigDecimal stockCount) {
		this.stockCount = stockCount;
	}
	public BigDecimal getStockCount() {
		return stockCount;
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
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getVersion() {
		return version;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
