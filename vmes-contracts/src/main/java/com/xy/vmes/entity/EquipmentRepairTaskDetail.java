package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_equipment_repairTask_detail:设备维修任务明细表 实体类
 * @author 陈刚 自动生成
 * @date 2019-07-01
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
	//领取数量
	@TableField("receive_count")
	private BigDecimal receiveCount;
	//领取出库明细ID
	@TableField("receive_outdtl_id")
	private String receiveOutdtlId;

	//实际使用数量
	@TableField("apply_count")
	private BigDecimal applyCount;
	//退回方式(1:退回备件库, 2:退回虚拟库)
	@TableField("retreat_type")
	private String retreatType;
	//退回数量
	@TableField("retreat_count")
	private BigDecimal retreatCount;
	//退回入库明细ID
	@TableField("retreat_indtl_id")
	private String retreatIndtlId;
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
	public void setReceiveCount(BigDecimal receiveCount) {
		this.receiveCount = receiveCount;
	}
	public BigDecimal getReceiveCount() {
		return receiveCount;
	}
	public void setReceiveOutdtlId(String receiveOutdtlId) {
		this.receiveOutdtlId = receiveOutdtlId;
	}
	public String getReceiveOutdtlId() {
		return receiveOutdtlId;
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
	public void setRetreatIndtlId(String retreatIndtlId) {
		this.retreatIndtlId = retreatIndtlId;
	}
	public String getRetreatIndtlId() {
		return retreatIndtlId;
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
