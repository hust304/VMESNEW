<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
说明：${TITLE} Mapper.xml
创建人：${author} 自动创建
创建时间：${nowDate?string("yyyy-MM-dd")}
 -->
<mapper namespace="${classPath}.${objectName}Mapper">

    <!--表名 自动创建，禁止修改-->
    <sql id="tableName">
	${table}
    </sql>

    <!-- 字段 自动创建，禁止修改-->
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

    <!-- 字段值 自动创建，禁止修改-->
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


    <!-- 字段值 自动创建，禁止修改-->
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

    <!-- 自动创建，禁止修改 -->
    <select id="findColumnList"  resultType="java.util.LinkedHashMap">
        select
        <include refid="Column"></include>
        from dual
    </select>

    <!-- 自动创建，禁止修改 -->
    <select id="findDataList"  parameterType="com.yvan.PageData"  resultType="java.util.Map">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        where 1=1
        <if test="keywords!= null and keywords != ''"><!-- 关键词检索 -->
            and
            (
            <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
					-->
            )
        </if>
    </select>

    <!-- 列表 自动创建，禁止修改-->
    <select id="datalistPage" parameterType="com.yvan.PageData" resultType="com.xy.vmes.entity.${objectName}">
        select
        <include refid="Field"></include>
        from
        <include refid="tableName"></include>
        where 1=1
        <if test="keywords!= null and keywords != ''"><!-- 关键词检索 -->
            and
            (
            <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
					-->
            )
        </if>
    </select>

    <!-- 列表(全部) 自动创建，禁止修改-->
    <select id="dataList" parameterType="com.yvan.PageData" resultType="com.xy.vmes.entity.${objectName}">
        select
            <include refid="Field"></include>
        from
            <include refid="tableName"></include>
        <choose>
            <!--
                mapSize (0 or is null) 无查询参数-业务层传入
                isQueryAll 是否查询全部
                fasle: (false or is null) 无查询条件-查询结果集返回空或list.size()==0
                true : 无查询条件-返回全部业务表数据
            -->
            <when test="(mapSize == null || mapSize == 0) and 'true' != isQueryAll ">
                where 1=2
            </when>
            <otherwise>
                <where>
                    <!--isSelfExist 是否考虑自己在业务表中是否存在
                        false: (false or is null) 无需考虑自己在业务表中是否存在
                        true : 需要考虑自己在业务表中是否存在
                    -->
                    <if test="id != null and id!=''" >
                        <choose>
                            <when test="'true' == isSelfExist">
                                <![CDATA[ and id <> ${r"#{"}id${r"}"} ]]>
                            </when>
                            <otherwise>
                                and id = ${r"#{"}id${r"}"}
                            </otherwise>
                        </choose>
                    </if>


                    <!--queryStr 自定义sql查询语句-->
                    <if test="queryStr != null and queryStr!=''" >
                        and ${r"${"}queryStr${r"}"}
                    </if>
                </where>
            </otherwise>
        </choose>
    </select>

    <!-- 批量删除 自动创建，禁止修改-->
    <delete id="deleteByIds" parameterType="java.lang.String">
        delete from
        <include refid="tableName"></include>
        where
        id in
        <foreach item="item" index="index" collection="array" open="(" separator="," close=")">
		${r"#{item}"}
        </foreach>
    </delete>



    <!-- ***************************************************以上为自动生成代码禁止修改，请在下面添加业务代码************************************************* -->


    <!-- 字段 自动创建，可以修改-->
    <sql id="Field1">
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

    <!-- 字段值 自动创建，可以修改-->
    <sql id="Column1">
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


    <!-- 自动创建，可以修改 -->
    <select id="getColumnList"  resultType="java.util.LinkedHashMap">
        select
        <include refid="Column1"></include>
        from dual
    </select>

    <!-- 自动创建，可以修改 -->
    <select id="getDataList"  parameterType="com.yvan.PageData"  resultType="java.util.Map">
        select
        <include refid="Field1"></include>
        from
        <include refid="tableName"></include>
        where 1=1
        <if test="keywords!= null and keywords != ''"><!-- 关键词检索 -->
            and
            (
            <!--	根据需求自己加检索条件
						字段1 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
						 or
						字段2 LIKE CONCAT(CONCAT('%', ${r"#{keywords})"},'%')
					-->
            )
        </if>
    </select>



    <!-- 自动创建，可以修改-->
    <update id="updateToDisableByIds" parameterType="java.lang.String" >
        update
        <include refid="tableName"></include>
        set isdisable = 1
        where
        id in
        <foreach item="item" index="index" collection="array" open="(" separator="," close=")">
        ${r"#{item}"}
        </foreach>
    </update>

</mapper>