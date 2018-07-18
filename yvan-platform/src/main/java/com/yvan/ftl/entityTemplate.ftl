package ${classPath};

import java.util.*;
import java.math.BigDecimal;

/** 
 * 说明：${TITLE} 实体类
 * 创建人：自动创建
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 */
public class ${objectName}{
	
<#list fieldList as var>
		<#if var[4] == 'Integer'>
	private int ${var[1]};				//${var[3]}
	public int get${var[2]}() {
		return ${var[1]};
	}
	public void set${var[2]}(int ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
		<#elseif var[4] == 'BigDecimal'>
	private BigDecimal ${var[1]};			//${var[3]}
	public BigDecimal get${var[2]}() {
		return ${var[1]};
	}
	public void set${var[2]}(BigDecimal ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
		<#elseif var[4] == 'Date'>
	private Date ${var[1]};			//${var[3]}
	public Date get${var[2]}() {
		return ${var[1]};
	}
	public void set${var[2]}(Date ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
		<#else>
	private String ${var[1]};			//${var[3]}
	public String get${var[2]}() {
		return ${var[1]};
	}
	public void set${var[2]}(String ${var[1]}) {
		this.${var[1]} = ${var[1]};
	}
		</#if>
</#list>

}
