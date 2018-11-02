package com.xy.vmes.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 说明：(组织架构,功能菜单,字典管理)-通用树形结构对象-与界面树形展示属性相关
 * 创建人：陈刚
 * 创建时间：2018-07-18
 */
public class TreeEntity implements Cloneable {
    //树形结构基本属性
    //当前节点ID
    private String id;
    //当前节点父ID
    private String pid;
    //(必须)当前节点名称
    private String name;
    //(必须)是否禁用(0:已禁用 1:启用)
    private String isdisable;
    //当前节点级别
    private Integer layer;
    //节点顺序
    private Integer serialNumber = Integer.valueOf(0);

    //菜单树
    //当前节点编码
    private String url;
    //当前节点图标
    private String icon;

    //岗位树(属性)"dept" 部门 "post" 岗位
    private String type;
    private String deptName;
    private String postName;

    //数据字典属性
    private String label;
    private String value;

    //BomID
    private String bomId;
    private String bomTreeId;
    private String pathId;

    //仓库树
    //virtual_genre:虚拟库-属性
    private String virtualGenre;
    //根节点到本节点路径ID pathId
    //根节点到本节点路径名称
    private String pathName;

    //当前节点-是否绑定角色(1:绑定 0:未绑定)
    private Boolean isBindRole;

    //(必须)当前节点子节点
    private List<TreeEntity> children = new ArrayList<TreeEntity>();

    //级联table表头信息
    private List titles;
    private List hideTitles;
    //级联table值信息
    private Map vauleMap;


    public List getTitles() {
        return titles;
    }

    public void setTitles(List titles) {
        this.titles = titles;
    }

    public List getHideTitles() {
        return hideTitles;
    }

    public void setHideTitles(List hideTitles) {
        this.hideTitles = hideTitles;
    }

    public Map getVauleMap() {
        return vauleMap;
    }

    public void setVauleMap(Map vauleMap) {
        this.vauleMap = vauleMap;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

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
    public Boolean getIsBindRole() {
        return isBindRole;
    }
    public void setIsBindRole(Boolean isBindRole) {
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
    public TreeEntity clone() {
        TreeEntity object = null;
        try{
            object = (TreeEntity)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }
    public String getBomId() {
        return bomId;
    }
    public void setBomId(String bomId) {
        this.bomId = bomId;
    }
    public String getPathId() {
        return pathId;
    }
    public void setPathId(String pathId) {
        this.pathId = pathId;
    }
    public String getBomTreeId() {
        return bomTreeId;
    }
    public void setBomTreeId(String bomTreeId) {
        this.bomTreeId = bomTreeId;
    }
    public String getVirtualGenre() {
        return virtualGenre;
    }
    public void setVirtualGenre(String virtualGenre) {
        this.virtualGenre = virtualGenre;
    }
    public String getPathName() {
        return pathName;
    }
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
