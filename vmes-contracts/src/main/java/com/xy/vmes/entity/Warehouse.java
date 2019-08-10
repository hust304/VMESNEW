package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_warehouse:仓库货位表 实体类
 * @author 陈刚 自动生成
 * @date 2018-10-10
 */
@TableName("vmes_warehouse")
public class Warehouse implements Serializable {
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
	//实体库-仓库类型-(货品属性一致)-(字典表-vmes_dictionary.id)
	@TableField("entity_type")
	private String entityType;
	//虚拟库-属性(1:内部单位 2:外部单位)
	@TableField("virtual_genre")
	private String virtualGenre;
	//内部单位(部门ID)
	@TableField("virtual_dept_id")
	private String virtualDeptId;
	//内部单位名称
	@TableField("virtual_dept_name")
	private String virtualDeptName;
	//外部单位ID(客户id)
	@TableField("virtual_customer_id")
	private String virtualCustomerId;
	//外部单位名称
	@TableField("virtual_customer_name")
	private String virtualCustomerName;
	//货位级别
	@TableField("layer")
	private Integer layer;
	//二维码-(图片相对路径)
	@TableField("qrcode")
	private String qrcode;
	//货位编码
	@TableField("code")
	private String code;
	//仓库ID
	@TableField("warehouse_id")
	private String warehouseId;
	//货位名称
	@TableField("name")
	private String name;
	//英文名称
	@TableField("name_en")
	private String nameEn;
	//同级排列序号
	@TableField("serial_number")
	private Integer serialNumber;
	//是否叶子(0:非叶子 1:是叶子)
	@TableField("isLeaf")
	private String isLeaf;
	//货位所属部门ID
	@TableField("dept_id")
	private String deptId;
	//部门货位ID-(字典表-vmes_dictionary.id)
	@TableField("dept_place_key")
	private String deptPlaceKey;
	//根节点到本节点路径名称
	@TableField("path_name")
	private String pathName;
	//根节点到本节点路径ID
	@TableField("path_id")
	private String pathId;
	//是否公开 (0:不公开:企业内部维护 1:公开:超级管理员维护)
	@TableField("isopen")
	private String isopen;
	//备注
	@TableField("remark")
	private String remark;
	//创建用户id
	@TableField("cuser")
	private String cuser;
	//创建时间
	@TableField("cdate")
	private Date cdate;
	//修改用户id
	@TableField("uuser")
	private String uuser;
	//修改时间
	@TableField("udate")
	private Date udate;
	//是否启用(0:已禁用 1:启用)
	@TableField("isdisable")
	private String isdisable;
	//是否简版仓库 Y:是简版 N:非简版 is null:非简版
	@TableField("is_simple")
	private String isSimple;


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
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setVirtualGenre(String virtualGenre) {
		this.virtualGenre = virtualGenre;
	}
	public String getVirtualGenre() {
		return virtualGenre;
	}
	public void setVirtualDeptId(String virtualDeptId) {
		this.virtualDeptId = virtualDeptId;
	}
	public String getVirtualDeptId() {
		return virtualDeptId;
	}
	public void setVirtualDeptName(String virtualDeptName) {
		this.virtualDeptName = virtualDeptName;
	}
	public String getVirtualDeptName() {
		return virtualDeptName;
	}
	public void setVirtualCustomerId(String virtualCustomerId) {
		this.virtualCustomerId = virtualCustomerId;
	}
	public String getVirtualCustomerId() {
		return virtualCustomerId;
	}
	public void setVirtualCustomerName(String virtualCustomerName) {
		this.virtualCustomerName = virtualCustomerName;
	}
	public String getVirtualCustomerName() {
		return virtualCustomerName;
	}
	public void setLayer(Integer layer) {
		this.layer = layer;
	}
	public Integer getLayer() {
		return layer;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptPlaceKey(String deptPlaceKey) {
		this.deptPlaceKey = deptPlaceKey;
	}
	public String getDeptPlaceKey() {
		return deptPlaceKey;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathId(String pathId) {
		this.pathId = pathId;
	}
	public String getPathId() {
		return pathId;
	}
	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
	public String getIsopen() {
		return isopen;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
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
	public void setIsdisable(String isdisable) {
		this.isdisable = isdisable;
	}
	public String getIsdisable() {
		return isdisable;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getIsSimple() {
		return isSimple;
	}
	public void setIsSimple(String isSimple) {
		this.isSimple = isSimple;
	}
/*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}
