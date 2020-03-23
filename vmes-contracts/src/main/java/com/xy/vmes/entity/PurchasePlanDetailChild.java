package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 说明：vmes_purchase_plan_detail_child:采购计划明细子表 实体类
 * @author 陈刚
 * @date 2020-03-23
 */
@TableName("vmes_purchase_plan_detail_child")
public class PurchasePlanDetailChild {
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;
    //采购计划id
    @TableField("plan_id")
    private String planId;
    //采购计划明细id
    @TableField("plan_dtl_id")
    private String planDtlId;
    //销售订单明细id
    @TableField("sale_order_dtl_id")
    private String saleOrderDtlId;
    //货品id
    @TableField("product_id")
    private String productId;

    //单位id(单据单位)
    @TableField("unit_id")
    private String unitId;
    //计划数量(单据单位)
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
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public void setPlanDtlId(String planDtlId) {
        this.planDtlId = planDtlId;
    }
    public String getPlanDtlId() {
        return planDtlId;
    }
    public void setSaleOrderDtlId(String saleOrderDtlId) {
        this.saleOrderDtlId = saleOrderDtlId;
    }
    public String getSaleOrderDtlId() {
        return saleOrderDtlId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
    public String getUnitId() {
        return unitId;
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

}
