package com.xy.vmes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WarehouseMoveDetailEntity {
    //
    private String id;
    //移库单ID
    private String parentId;
    //当前库位产品ID
    private String warehouseProductId;
    //移库数量
    private BigDecimal count;
    //状态(0:待派单 1:执行中 2:已完成)
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
    //二维码-(图片相对路径)
    private String qrcode;

    //非实体属性
    private String productName;

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
    public void setWarehouseProductId(String warehouseProductId) {
        this.warehouseProductId = warehouseProductId;
    }
    public String getWarehouseProductId() {
        return warehouseProductId;
    }
    public void setCount(BigDecimal count) {
        this.count = count;
    }
    public BigDecimal getCount() {
        return count;
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
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
    public String getQrcode() {
        return qrcode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
