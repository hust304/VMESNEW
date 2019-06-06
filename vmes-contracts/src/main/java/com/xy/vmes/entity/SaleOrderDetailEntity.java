package com.xy.vmes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SaleOrderDetailEntity {

    //
    private String id;
    //订单ID
    private String parentId;
    //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
    private String state;
    //附件地址
    private String fileUrl;
    //交付日期
    private Date deliverDate;

    //订单订购数量
    private BigDecimal orderCount;
    //订单单位id
    private String orderUnit;
    //货品数量(计量数量)
    private BigDecimal productCount;
    //计量单位id
    private String productUnit;
    //货品数量(计价数量)
    private BigDecimal priceCount;

    //计价单位id
    private String priceUnit;
    //货品ID
    private String productId;
    //货品单价(货品计价单位匹配获得)
    private BigDecimal productPrice;
    //货品金额(订购数量 * 货品单价)
    private BigDecimal productSum;
    //是否锁定仓库(0:未锁定 1:已锁定)
    private String isLockWarehouse;

    //是否需要生产(0:无需 1:需要 库存不够)
    private String isNeedProduce;
    //锁定货品数量(计量单位)
    private BigDecimal lockCount;
    //可发货数量(计价单位)
    private BigDecimal needDeliverCount;
    //锁定开始时间
    private Date lockDate;
    //生产计划明细ID
    private String planDetailId;

    //创建用户id
    private String cuser;
    //创建时间
    private Date cdate;
    //修改用户id
    private String uuser;
    //修改时间
    private Date udate;
    //备注
    private String remark;

    //是否启用(0:已禁用 1:启用)
    private String isdisable;
    //修改锁定库存版本号
    private Integer versionLockCount;

    //(计价单位)本次发货数量
    private BigDecimal orderDtlDeliverCount;
    //非实体类字段:界面传值用
    private String deliverDtlRemark;

    //变更前-订购数量
    private BigDecimal oldOrderCount;
    //变更后-订购数量
    private BigDecimal newOrderCount;

    //变更前-锁定货品数量(计量单位)
    private BigDecimal oldLockCount;
    //变更后-锁定货品数量(计量单位)
    private BigDecimal newLockCount;
    //当前库存数量
    private BigDecimal stockCount;

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
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
    public Date getDeliverDate() {
        return deliverDate;
    }
    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }
    public BigDecimal getOrderCount() {
        return orderCount;
    }
    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }
    public String getOrderUnit() {
        return orderUnit;
    }
    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }
    public BigDecimal getProductCount() {
        return productCount;
    }
    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
    public String getProductUnit() {
        return productUnit;
    }
    public void setPriceCount(BigDecimal priceCount) {
        this.priceCount = priceCount;
    }
    public BigDecimal getPriceCount() {
        return priceCount;
    }
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }
    public String getPriceUnit() {
        return priceUnit;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    public BigDecimal getProductPrice() {
        return productPrice;
    }
    public void setProductSum(BigDecimal productSum) {
        this.productSum = productSum;
    }
    public BigDecimal getProductSum() {
        return productSum;
    }
    public void setIsLockWarehouse(String isLockWarehouse) {
        this.isLockWarehouse = isLockWarehouse;
    }
    public String getIsLockWarehouse() {
        return isLockWarehouse;
    }
    public void setIsNeedProduce(String isNeedProduce) {
        this.isNeedProduce = isNeedProduce;
    }
    public String getIsNeedProduce() {
        return isNeedProduce;
    }
    public void setLockCount(BigDecimal lockCount) {
        this.lockCount = lockCount;
    }
    public BigDecimal getLockCount() {
        return lockCount;
    }
    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }
    public Date getLockDate() {
        return lockDate;
    }
    public void setPlanDetailId(String planDetailId) {
        this.planDetailId = planDetailId;
    }
    public String getPlanDetailId() {
        return planDetailId;
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
    public String getDeliverDtlRemark() {
        return deliverDtlRemark;
    }
    public void setDeliverDtlRemark(String deliverDtlRemark) {
        this.deliverDtlRemark = deliverDtlRemark;
    }
    public BigDecimal getOrderDtlDeliverCount() {
        return orderDtlDeliverCount;
    }
    public void setOrderDtlDeliverCount(BigDecimal orderDtlDeliverCount) {
        this.orderDtlDeliverCount = orderDtlDeliverCount;
    }
    public BigDecimal getNeedDeliverCount() {
        return needDeliverCount;
    }
    public void setNeedDeliverCount(BigDecimal needDeliverCount) {
        this.needDeliverCount = needDeliverCount;
    }
    public BigDecimal getOldLockCount() {
        return oldLockCount;
    }
    public void setOldLockCount(BigDecimal oldLockCount) {
        this.oldLockCount = oldLockCount;
    }
    public BigDecimal getNewLockCount() {
        return newLockCount;
    }
    public void setNewLockCount(BigDecimal newLockCount) {
        this.newLockCount = newLockCount;
    }
    public BigDecimal getStockCount() {
        return stockCount;
    }
    public void setStockCount(BigDecimal stockCount) {
        this.stockCount = stockCount;
    }

    public BigDecimal getOldOrderCount() {
        return oldOrderCount;
    }
    public void setOldOrderCount(BigDecimal oldOrderCount) {
        this.oldOrderCount = oldOrderCount;
    }

    public BigDecimal getNewOrderCount() {
        return newOrderCount;
    }
    public void setNewOrderCount(BigDecimal newOrderCount) {
        this.newOrderCount = newOrderCount;
    }

    public Integer getVersionLockCount() {
        return versionLockCount;
    }

    public void setVersionLockCount(Integer versionLockCount) {
        this.versionLockCount = versionLockCount;
    }
}
