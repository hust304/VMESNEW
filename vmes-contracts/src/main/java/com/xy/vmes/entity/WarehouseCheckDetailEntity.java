package com.xy.vmes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WarehouseCheckDetailEntity {

    //
    private String id;
    //盘点单ID
    private String parentId;
    //二维码-(图片相对路径)
    private String qrcode;
    //执行人ID
    private String executeId;
    //库存id
    private String warehouseProductId;

    //货位ID(系统生成)
    private String warehouseId;
    //货品ID(系统生成)
    private String productId;
    //货位批次号(系统生成)
    private String code;
    //库存数量
    private BigDecimal stockCount;
    //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
    private String state;

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

    //非实体属性
    private String taskName;
    //企业ID-组织架构
    private String companyId;


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
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
