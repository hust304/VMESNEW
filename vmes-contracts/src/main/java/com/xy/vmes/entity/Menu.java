package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_menu:系统功能菜单表 实体类
 * @author 陈刚
 * @date 2018-07-23
 */
@TableName("vmes_menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//上级id-根root
	@TableField("pid")
	private String pid;
	//公司ID-组织架构
	@TableField("company_id")
	private String companyId;
	//菜单编号(表名,类名)
	@TableField("model_code")
	private String modelCode;
	//菜单名称
	@TableField("name")
	private String name;
	//菜单顺序
	@TableField("serial_number")
	private Integer serialNumber;
	//菜单图标
	@TableField("icon")
	private String icon;
	//
	@TableField("type")
	private String type;
	//模块List链接地址
	@TableField("url")
	private String url;
	//是否叶子节点(1:叶子节点0:非叶子节点) 数据字典:sys_isleaf
	@TableField("isleaf")
	private String isleaf;
	//菜单级别(最大支持4层)
	@TableField("layer")
	private Integer layer;
	//是否禁用(1:已禁用 0:启用) 数据字典:sys_isdisable
	@TableField("isdisable")
	private String isdisable;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//创建人账号
	@TableField("cuser")
	private String cuser;
	//修改时间
	@TableField("udate")
	private Date udate;
	//修改人账号
	@TableField("uuser")
	private String uuser;
	//根root节点ID
	@TableField("id_0")
	private String id0;
	//一级节点ID
	@TableField("id_1")
	private String id1;
	//二级节点ID
	@TableField("id_2")
	private String id2;
	//三级节点ID
	@TableField("id_3")
	private String id3;
	//四级节点ID
	@TableField("id_4")
	private String id4;
	//五级节点ID
	@TableField("id_5")
	private String id5;
	//是否查询全部
	//fasle: (false or is null) 无查询条件-查询结果集返回空或list.size()==0
	//true : 无查询条件-返回全部业务表数据
	private Boolean isQueryAll = Boolean.FALSE;

	//是否考虑自己在业务表中是否存在
	//false: (false or is null) 无需考虑自己在业务表中是否存在
	//true : 需要考虑自己在业务表中是否存在
	private Boolean isSelfExist = Boolean.FALSE;
	private String queryStr;


	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPid() {
		return pid;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIcon() {
		return icon;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}
	public String getIsleaf() {
		return isleaf;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getIsdisable() {
		return isdisable;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCuser() {
		return cuser;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUuser(String uuser) {
		this.uuser = uuser;
	}
	public String getUuser() {
		return uuser;
	}
	public void setId0(String id0) {
		this.id0 = id0;
	}
	public String getId0() {
		return id0;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getId1() {
		return id1;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getId2() {
		return id2;
	}
	public void setId3(String id3) {
		this.id3 = id3;
	}
	public String getId3() {
		return id3;
	}
	public void setId4(String id4) {
		this.id4 = id4;
	}
	public String getId4() {
		return id4;
	}
	public void setId5(String id5) {
		this.id5 = id5;
	}
	public String getId5() {
		return id5;
	}
	public Boolean getIsQueryAll() {
		return isQueryAll;
	}
	public void setIsQueryAll(Boolean isQueryAll) {
		this.isQueryAll = isQueryAll;
	}
	public Boolean getIsSelfExist() {
		return isSelfExist;
	}
	public void setIsSelfExist(Boolean isSelfExist) {
		this.isSelfExist = isSelfExist;
	}
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

}
