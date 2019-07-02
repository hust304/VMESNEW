package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_equipment_repairTask_detail:设备维修任务明细表 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-02
 */
@TableName("vmes_equipment_repairTask_detail")
public class EquipmentRepairTaskDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//维修任务ID
	@TableField("task_id")
	private String taskId;
	//备件ID(货品)ID
	@TableField("product_id")
	private String productId;
	//货品分类(0:货品类1:备件类)
	@TableField("product_type")
	private String productType;
	//领取数量
	@TableField("receive_count")
	private BigDecimal receiveCount;
	//实际使用数量
	@TableField("apply_count")
	private BigDecimal applyCount;
	//退回方式(1:退回仓库, 2:退回虚拟库)
	@TableField("retreat_type")
	private String retreatType;
	//退回数量
	@TableField("retreat_count")
	private BigDecimal retreatCount;
	//出库明细ID(领取)
	@TableField("out_dtl_id")
	private String outDtlId;
	//出库数量(领取)
	@TableField("out_count")
	private BigDecimal outCount;
	//入库明细ID(退还)
	@TableField("in_dtl_id")
	private String inDtlId;
	//入库数量(退还)
	@TableField("in_count")
	private BigDecimal inCount;
	//虚拟库ID(货位ID)
	@TableField("warehouse_id")
	private String warehouseId;
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
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductType() {
		return productType;
	}
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}
	public void setApplyCount(BigDecimal applyCount) {
		this.applyCount = applyCount;
	}
	public BigDecimal getApplyCount() {
		return applyCount;
	}
	public void setRetreatType(String retreatType) {
		this.retreatType = retreatType;
	}
	public String getRetreatType() {
		return retreatType;
	}
	public void setRetreatCount(BigDecimal retreatCount) {
		this.retreatCount = retreatCount;
	}
	public BigDecimal getRetreatCount() {
		return retreatCount;
	}
	public void setOutDtlId(String outDtlId) {
		this.outDtlId = outDtlId;
	}
	public String getOutDtlId() {
		return outDtlId;
	}
	public void setOutCount(BigDecimal outCount) {
		this.outCount = outCount;
	}
	public BigDecimal getOutCount() {
		return outCount;
	}
	public void setInDtlId(String inDtlId) {
		this.inDtlId = inDtlId;
	}
	public String getInDtlId() {
		return inDtlId;
	}
	public void setInCount(BigDecimal inCount) {
		this.inCount = inCount;
	}
	public BigDecimal getInCount() {
		return inCount;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseId() {
		return warehouseId;
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
