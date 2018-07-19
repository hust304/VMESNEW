package com.xy.vmes.entity;


/**
 * 说明：(组织架构,功能菜单,字典管理)-通用树形结构对象-与界面树形展示属性相关
 * 创建人：陈刚
 * 创建时间：2018-07-18
 */
public class TreeEntity {
    //当前节点ID
    private String id;
    //当前节点名称
    private String text;
    //当前节点-部门级别
    private Integer layer;
    //当前节点状态
    private String state = "closed";
    //是否有孩子
    private String isChild;
    //当前节点图标
    private String iconCls;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsChild() {
        return isChild;
    }

    public void setIsChild(String isChild) {
        this.isChild = isChild;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }
}
