package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

/**
 * Created by luoyifan on 2018/7/14.
 */
@Getter
@Setter
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

}
