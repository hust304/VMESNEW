package ${classPath};

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：${TITLE} 实体类
 * @author ${author}
 * @date ${nowDate?string("yyyy-MM-dd")}
 */
@TableName("${table}")
public class ${objectName} implements Serializable {
	private static final long serialVersionUID = 1L;

<#list fieldList as var>
<#if var[4] == 'Integer'>
	//${var[3]}
	@TableField("${var[0]}")
	private Integer ${var[1]};
<#elseif var[4] == 'BigDecimal'>
	//${var[3]}
	@TableField("${var[0]}")
	private BigDecimal ${var[1]};
<#elseif var[4] == 'Date'>
	//${var[3]}
	@TableField("${var[0]}")
	private Date ${var[1]};
<#else>
	//${var[3]}
	@TableField("${var[0]}")
	private String ${var[1]};
</#if>
</#list>
	//是否查询全部
	//fasle: (false or is null) 无查询条件-查询结果集返回空或list.size()==0
	//true : 无查询条件-返回全部业务表数据
	private Boolean isQueryAll = Boolean.FALSE;

	//是否考虑自己在业务表中是否存在
	//false: (false or is null) 无需考虑自己在业务表中是否存在
	//true : 需要考虑自己在业务表中是否存在
	private Boolean isSelfExist = Boolean.FALSE;
	private String queryStr;


<#list fieldList as var>
	<#if var[4] == 'Integer'>
	public void set${var[2]}(Integer ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
	public Integer get${var[2]}() {
		return ${var[1]};
	}
	<#elseif var[4] == 'BigDecimal'>
	public void set${var[2]}(BigDecimal ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
	public BigDecimal get${var[2]}() {
		return ${var[1]};
	}
	<#elseif var[4] == 'Date'>
	public void set${var[2]}(Date ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
	public Date get${var[2]}() {
		return ${var[1]};
	}
	<#else>
	public void set${var[2]}(String ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
	public String get${var[2]}() {
		return ${var[1]};
	}
	</#if>
</#list>
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
