package com.xy.vmes.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * 说明：(组织架构,功能菜单,字典管理)-通用树形结构对象-与界面树形展示属性相关
 * 创建人：陈刚
 * 创建时间：2018-07-18
 */
public class TreeEntity {
    //(必须)当前节点名称
    private String title;
    //(必须)当前节点编码
    private String path;
    //当前节点ID
    private String id;
    //当前节点父ID
    private String pid;
    //当前节点级别
    private Integer layer;
    //菜单顺序
    private Integer serialNumber;
    //当前节点图标
    private String icon;
    //(必须)当前节点子节点
    private List<TreeEntity> children = new ArrayList<TreeEntity>();


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
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
    public List<TreeEntity> getChildren() {
        return children;
    }
    public void setChildren(List<TreeEntity> children) {
        this.children = children;
    }
    public Integer getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}
