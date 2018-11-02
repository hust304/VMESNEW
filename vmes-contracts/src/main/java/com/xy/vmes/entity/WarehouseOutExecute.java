package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：出库执行 实体类
 * @author 刘威 自动生成
 * @date 2018-11-01
 */
@TableName("vmes_warehouse_out_execute")
public class WarehouseOutExecute implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//出库明细ID
	@TableField("detail_id")
	private String detailId;
	//执行人ID
	@TableField("executor_id")
	private String executorId;
	//(实际)货位ID
	@TableField("warehouse_id")
	private String warehouseId;
	//当前出库数量
	@TableField("count")
	private BigDecimal count;
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
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}
	public String getExecutorId() {
		return executorId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setCount(BigDecimal count) {
		this.count = count;
	}
	public BigDecimal getCount() {
		return count;
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
