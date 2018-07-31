package com.xy.vmes.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * 说明：(组织架构,功能菜单,字典管理)-通用树形结构对象-与界面树形展示属性相关
 * 创建人：陈刚
 * 创建时间：2018-07-18
 */
public class TreeEntity {
    //当前节点ID
    private String id;
    //当前节点名称
    private String label;
    //当前节点级别
    private Integer layer;
    //当前节点图标
    private String icon;
    //当前节点子节点
    private List<TreeEntity> childList = new ArrayList<TreeEntity>();


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Integer getLayer() {
        return layer;
    }
    public void setLayer(Integer layer) {
        this.layer = layer;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public List<TreeEntity> getChildList() {
        return childList;
    }
    public void setChildList(List<TreeEntity> childList) {
        this.childList = childList;
    }
}
