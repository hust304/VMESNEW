package com.xy.vmes.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：vmes_employee:员工表 实体类
 * @author 陈刚
 * @date 2018-07-23
 */
@TableName("vmes_employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	@TableField("id")
	private String id;
	//系统用户ID
	@TableField("user_id")
	private String userId;
	//公司ID-组织架构
	@TableField("company_id")
	private String companyId;
	//员工编号
	@TableField("code")
	private String code;
	//员工类型 数据字典:sys_employee_type
	@TableField("type")
	private String type;
	//员工姓名
	@TableField("name")
	private String name;
	//员工英文名
	@TableField("name_en")
	private String nameEn;
	//员工照片
	@TableField("photo")
	private String photo;
	//员工图片
	@TableField("icon")
	private String icon;
	//手机号码
	@TableField("mobile")
	private String mobile;
	//邮箱地址
	@TableField("email")
	private String email;
	//性别(1:男0:女) 数据字典:sys_employee_sex
	@TableField("sex")
	private String sex;
	//出生日期(yyyy-mm-dd)
	@TableField("birthday")
	private Date birthday;
	//入职日期(yyyy-mm-dd)
	@TableField("entry_date")
	private Date entryDate;
	//籍贯
	@TableField("native_place")
	private String nativePlace;
	//政治面貌 数据字典:sys_employee_political
	@TableField("political")
	private String political;
	//身份证号
	@TableField("identity_number")
	private String identityNumber;
	//婚姻状况(1:已婚 0:未婚) 数据字典:sys_employee_marital
	@TableField("marital")
	private String marital;
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
	//预留字段
	@TableField("column_1")
	private String column1;
	//预留字段
	@TableField("column_2")
	private String column2;
	//预留字段
	@TableField("column_3")
	private String column3;
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
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
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
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIcon() {
		return icon;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile() {
		return mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getPolitical() {
		return political;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getMarital() {
		return marital;
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
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}
	public String getColumn3() {
		return column3;
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
