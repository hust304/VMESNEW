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
    private String name;
    //(必须)当前节点编码
    private String url;
    //(必须)是否禁用(0:已禁用 1:启用)
    private String isdisable;

    //岗位树(属性)"dept" 部门 "post" 岗位
    private String type;
    private String deptName;
    private String postName;

    //当前节点-是否绑定角色(1:绑定 0:未绑定)
    private String isBindRole;
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


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
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
    public String getIsdisable() {
        return isdisable;
    }
    public void setIsdisable(String isdisable) {
        this.isdisable = isdisable;
    }
    public String getIsBindRole() {
        return isBindRole;
    }
    public void setIsBindRole(String isBindRole) {
        this.isBindRole = isBindRole;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getPostName() {
        return postName;
    }
    public void setPostName(String postName) {
        this.postName = postName;
    }
}
