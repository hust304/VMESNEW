package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse_loginfo:库存变更日志表 实体类
 * @author 陈刚 自动生成
 * @date 2018-11-23
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
	//执行ID(出入库执行ID 库存盘点执行ID)
	@TableField("execute_id")
	private String executeId;
	//源库存id-(出库,移库时填写)
	@TableField("source_wp_id")
	private String sourceWpId;
	//目标库存id-(入库,盘点,移库,填写)
	@TableField("target_wp_id")
	private String targetWpId;

	//当前操作数量
	@TableField("count")
	private BigDecimal count;
	//操作变更前数量(业务相关)
	@TableField("before_count")
	private BigDecimal beforeCount;
	//操作变更后数量(业务相关)
	@TableField("after_count")
	private BigDecimal afterCount;
	//(源)库存变更前数量(出库,移库时填写)
	@TableField("source_before_stockcount")
	private BigDecimal sourceBeforeStockcount;
	//(源)库存变更后数量(出库,移库时填写)
	@TableField("source_after_stockcount")
	private BigDecimal sourceAfterStockcount;

	//(目标)库存变更前数量(入库,盘点,移库,填写)
	@TableField("target_before_stockcount")
	private BigDecimal targetBeforeStockcount;
	//(目标)库存变更后数量(入库,盘点,移库,填写)
	@TableField("target_after_stockcount")
	private BigDecimal targetAfterStockcount;
	//操作数量(正数:加库存 负数:减库存)
	@TableField("operation_count")
	private BigDecimal operationCount;
	//业务类型(in:入库 out:出库: move:移库 check:库存盘点)
	@TableField("business_type")
	private String businessType;
	//操作类型(add:添加 modify:修改 delete:删除 reback:退单 checkAudit:盘点审核)
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
	public String getExecuteId() {
		return executeId;
	}
	public void setExecuteId(String executeId) {
		this.executeId = executeId;
	}
	public void setSourceWpId(String sourceWpId) {
		this.sourceWpId = sourceWpId;
	}
	public String getSourceWpId() {
		return sourceWpId;
	}
	public void setTargetWpId(String targetWpId) {
		this.targetWpId = targetWpId;
	}
	public String getTargetWpId() {
		return targetWpId;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
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
	public void setSourceBeforeStockcount(BigDecimal sourceBeforeStockcount) {
		this.sourceBeforeStockcount = sourceBeforeStockcount;
	}
	public BigDecimal getSourceBeforeStockcount() {
		return sourceBeforeStockcount;
	}
	public void setSourceAfterStockcount(BigDecimal sourceAfterStockcount) {
		this.sourceAfterStockcount = sourceAfterStockcount;
	}
	public BigDecimal getSourceAfterStockcount() {
		return sourceAfterStockcount;
	}
	public void setTargetBeforeStockcount(BigDecimal targetBeforeStockcount) {
		this.targetBeforeStockcount = targetBeforeStockcount;
	}
	public BigDecimal getTargetBeforeStockcount() {
		return targetBeforeStockcount;
	}
	public void setTargetAfterStockcount(BigDecimal targetAfterStockcount) {
		this.targetAfterStockcount = targetAfterStockcount;
	}
	public BigDecimal getTargetAfterStockcount() {
		return targetAfterStockcount;
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
