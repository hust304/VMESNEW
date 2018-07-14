package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

/**
 * Created by luoyifan on 2018/7/14.
 */
@TableName("sys_department")
public class Department {

    @JsonProperty("id")
    @TableField("id")
    private Long id;
    @JsonProperty("pid")
    @TableField("pid")
    private Long pid;
    @JsonProperty("name")
    @TableField("name")
    private String name;
    @JsonProperty("status")
    @TableField("status")
    private Boolean status;
    @JsonProperty("createby")
    @TableField("createby")
    private Long createby;
    @JsonProperty("add_date")
    @TableField("add_date")
    private DateTime add_date;
    @JsonProperty("update_date")
    @TableField("update_date")
    private DateTime update_date;
    @JsonProperty("orderby")
    @TableField("orderby")
    private Short orderby;
    @JsonProperty("level")
    @TableField("level")
    private Long level;
    @JsonProperty("path")
    @TableField("path")
    private String path;
    @JsonProperty("number")
    @TableField("number")
    private String number;
    @JsonProperty("longnumber")
    @TableField("longnumber")
    private String longnumber;
    @JsonProperty("type")
    @TableField("type")
    private String type;
    @JsonProperty("property")
    @TableField("property")
    private String property;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public DateTime getAdd_date() {
        return add_date;
    }

    public void setAdd_date(DateTime add_date) {
        this.add_date = add_date;
    }

    public DateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(DateTime update_date) {
        this.update_date = update_date;
    }

    public Short getOrderby() {
        return orderby;
    }

    public void setOrderby(Short orderby) {
        this.orderby = orderby;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLongnumber() {
        return longnumber;
    }

    public void setLongnumber(String longnumber) {
        this.longnumber = longnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
