package com.xy.vmes.entity;

public class SaleOrderDetailEntity extends SaleOrderDetail {

    //非实体类字段:界面传值用
    private String orderUnit;
    private String deliverDtlRemark;

    public String getOrderUnit() {
        return orderUnit;
    }
    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit;
    }
    public String getDeliverDtlRemark() {
        return deliverDtlRemark;
    }
    public void setDeliverDtlRemark(String deliverDtlRemark) {
        this.deliverDtlRemark = deliverDtlRemark;
    }
}
