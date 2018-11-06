package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_loginfo:库存变更日志表 实体类
 * @author 陈刚 自动生成
 * @date 2018-11-06
 */
@TableName("vmes_warehouse_loginfo")
public class WarehouseLoginfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//企业ID
	@TableField("company_id")
	private String companyId;
	//明细id(出入库明细id 库存盘点明细id)
	@TableField("business_id")
	private String businessId;
	//货位批次号
	@TableField("code")
	private String code;
	//产品ID
	@TableField("product_id")
	private String productId;
	//仓库货位ID
	@TableField("warehouse_id")
	private String warehouseId;
	//当前操作数量
	@TableField("count")
	private BigDecimal count = BigDecimal.valueOf(0D);
	//操作变更前数量(业务相关)
	@TableField("before_count")
	private BigDecimal beforeCount = BigDecimal.valueOf(0D);
	//操作变更后数量(业务相关)
	@TableField("after_count")
	private BigDecimal afterCount = BigDecimal.valueOf(0D);
	//库存变更前数量(库存相关)
	@TableField("before_stock_count")
	private BigDecimal beforeStockCount = BigDecimal.valueOf(0D);
	//库存变更后数量(库存相关)
	@TableField("after_stock_count")
	private BigDecimal afterStockCount = BigDecimal.valueOf(0D);
	//操作数量(正数:加库存 负数:减库存)
	@TableField("operation_count")
	private BigDecimal operationCount = BigDecimal.valueOf(0D);
	//业务类型(in:入库 out:出库: move:移库 check:库存盘点)
	@TableField("business_type")
	private String businessType;
	//操作类型(add:添加 modify:修改 delete:删除:)
	@TableField("operation")
	private String operation;
	//创建用户id
	@TableField("cuser")
	private String cuser;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//备注
	@TableField("remark")
	private String remark;


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
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public BigDecimal getCount() {
		return count;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public void setBeforeCount(BigDecimal beforeCount) {
		this.beforeCount = beforeCount;
	}
	public BigDecimal getBeforeCount() {
		return beforeCount;
	}
	public void setAfterCount(BigDecimal afterCount) {
		this.afterCount = afterCount;
	}
	public BigDecimal getAfterCount() {
		return afterCount;
	}
	public void setBeforeStockCount(BigDecimal beforeStockCount) {
		this.beforeStockCount = beforeStockCount;
	}
	public BigDecimal getBeforeStockCount() {
		return beforeStockCount;
	}
	public void setAfterStockCount(BigDecimal afterStockCount) {
		this.afterStockCount = afterStockCount;
	}
	public BigDecimal getAfterStockCount() {
		return afterStockCount;
	}
	public void setOperationCount(BigDecimal operationCount) {
		this.operationCount = operationCount;
	}
	public BigDecimal getOperationCount() {
		return operationCount;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperation() {
		return operation;
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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}

/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
