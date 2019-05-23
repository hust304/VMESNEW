package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_check_detail:仓库库存盘点明细 实体类
 * @author 陈刚 自动生成
 * @date 2018-11-14
 */
@TableName("vmes_warehouse_check_detail")
public class WarehouseCheckDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//盘点单ID
	@TableField("parent_id")
	private String parentId;
	//二维码-(图片相对路径)
	@TableField("qrcode")
	private String qrcode;
	//执行人ID
	@TableField("execute_id")
	private String executeId;
	//库存id
	@TableField("warehouse_product_id")
	private String warehouseProductId;

	//货位ID(系统生成)
	@TableField("warehouse_id")
	private String warehouseId;
	//货品ID(系统生成)
	@TableField("product_id")
	private String productId;
	//货位批次号(系统生成)
	@TableField("code")
	private String code;
	//库存数量
	@TableField("stock_count")
	private BigDecimal stockCount;
	//状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
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
	//当前盘点时(库存数量)台账数量
	@TableField("check_stock_count")
	private BigDecimal checkStockCount;


	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setExecuteId(String executeId) {
		this.executeId = executeId;
	}
	public String getExecuteId() {
		return executeId;
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
	public String getWarehouseProductId() {
		return warehouseProductId;
	}
	public void setWarehouseProductId(String warehouseProductId) {
		this.warehouseProductId = warehouseProductId;
	}
	public BigDecimal getCheckStockCount() {
		return checkStockCount;
	}
	public void setCheckStockCount(BigDecimal checkStockCount) {
		this.checkStockCount = checkStockCount;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
