<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
说明：${TITLE} Mapper.xml
创建人：自动创建
创建时间：${nowDate?string("yyyy-MM-dd")}
 -->
<mapper namespace="${classPath}.${objectName}Mapper">

    <!--表名 -->
    <sql id="tableName">
	${table}
    </sql>

    <!-- 字段 -->
    <sql id="Field">
	<#list fieldList as var>
		<#if var[7] == "否">
		${var[0]} ${var[1]},<!-- ${var[3]} -->
		</#if>
	</#list>
	<#list fieldList as var>
		<#if var[7] == "是">
		${var[0]} ${var[1]} <!-- ${var[1]} -->
		</#if>
	</#list>
    </sql>

    <!-- 字段值 -->
    <sql id="FieldValue">
	<#list fieldList as var>
		<#if var[7] == "否">
		${r"#{"}${var[1]}${r"}"},<!-- ${var[3]} -->
		</#if>
	</#list>
	<#list fieldList as var>
		<#if var[7] == "是">
		${r"#{"}${var[1]}${r"}"} <!-- ${var[1]} -->
		</#if>
	</#list>
    </sql>


    <!-- 字段值 -->
    <sql id="Column">
    <#list fieldList as var>
        <#if var[7] == "否">
        '${var[3]}'  ${var[1]},
        </#if>
    </#list>
    <#list fieldList as var>
        <#if var[7] == "是">
        '${var[1]}' ${var[1]}
        </#if>
    </#list>
    </sql>

    <!-- 通过ID获取数据 -->
    <select id="findColumnList"  resultType="java.util.LinkedHashMap">
        select
        <include refid="Column"></include>
        from dual
    </select>

    <!-- 通过ID获取数据 -->
    <select id="findDataList"  parameterType="com.yvan.PageData"  resultType="java.util.Map">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        <if test="PageData!= null"><!-- 关键词检索 -->
            where 1=1
            <if test="PageData.keywords!= null and PageData.keywords != ''"><!-- 关键词检索 -->
                and
                (
                <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
					-->
                )
            </if>
        </if>
    </select>


    <!-- 新增-->
    <insert id="save" parameterType="com.xy.vmes.entity.${objectName}">
        insert into
        <include refid="tableName"></include>
        (
        <include refid="Field"></include>
        ) values (
        <include refid="FieldValue"></include>
        )
    </insert>

    <!-- 删除-->
    <delete id="delete" parameterType="com.xy.vmes.entity.${objectName}">
        delete from
        <include refid="tableName"></include>
        where
        id = ${r"#{"}id${r"}"}
    </delete>

    <!-- 修改 -->
    <update id="update" parameterType="com.xy.vmes.entity.${objectName}">
        update
        <include refid="tableName"></include>
        set
	<#list fieldList as var>
		<#if var[7] == "否">
		${var[0]} = ${r"#{"}${var[1]}${r"}"}, <!-- ${var[3]} -->
		</#if>
	</#list>
        id = ${r"#{"}id${r"}"}
        where
        id = ${r"#{"}id${r"}"}
    </update>

    <!-- 通过ID获取数据 -->
    <select id="findById" parameterType="com.yvan.PageData" resultType="com.xy.vmes.entity.${objectName}">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        where
        id = ${r"#{"}id${r"}"}
    </select>

    <!-- 列表 -->
    <select id="datalistPage" parameterType="com.yvan.PageData" resultType="com.xy.vmes.entity.${objectName}">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        <if test="PageData!= null"><!-- 关键词检索 -->
            where 1=1
            <if test="PageData.keywords!= null and PageData.keywords != ''"><!-- 关键词检索 -->
                and
                (
                <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
					-->
                )
            </if>
        </if>
    </select>

    <!-- 列表(全部) -->
    <select id="dataList" parameterType="com.yvan.PageData" resultType="com.xy.vmes.entity.${objectName}">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        <if test="PageData!= null"><!-- 关键词检索 -->
            where 1=1
            <if test="PageData.keywords!= null and PageData.keywords != ''"><!-- 关键词检索 -->
                and
                (
                <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{PageData.keywords})"},'%')
					-->
                )
            </if>
        </if>
    </select>

    <!-- 批量删除 -->
    <delete id="deleteByIds" parameterType="String">
        delete from
        <include refid="tableName"></include>
        where
        id in
        <foreach item="item" index="index" collection="array" open="(" separator="," close=")">
		${r"#{item}"}
        </foreach>
    </delete>

</mapper>