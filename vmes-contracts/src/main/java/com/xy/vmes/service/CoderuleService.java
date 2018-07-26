package com.xy.vmes.service;

import com.xy.vmes.entity.Coderule;
import com.xy.vmes.entity.CoderuleEntity;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_coderule:系统编码规则表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-07-26
*/
public interface CoderuleService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    void save(Coderule coderule) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    void update(Coderule coderule) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    List<Coderule> dataList(PageData pd) throws Exception;
    List<Map<String, Object>> findDataList(PageData pd) throws Exception;
    Coderule findCoderule(PageData pd);
    Map<String, Object> findCoderuleMap(PageData pd);
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-26
     */
    Integer updateCoderule(PageData pd) throws Exception;

    ////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取业务编号-根据通用编码规则(企业编号+前缀字符+日期字符+流水号)
     *
     * 参数说明:
     *   <SysCoderuleEntity>object
     *     (不可为空)SysCoderuleEntity.tableName  业务名称(表名)
     *     (不可为空)SysCoderuleEntity.did1                       一级部门ID
     *     (不可为空)SysCoderuleEntity.firstName  第一个编码名称
     *     (不可为空)SysCoderuleEntity.type       类别(表名:=produce_workflow 有意义)
     *     (允许为空)SysCoderuleEntity.separator  分隔符
     *     (允许为空)SysCoderuleEntity.filling    填充字符
     *     (允许为空)SysCoderuleEntity.length     指定位数
     *     (允许为空)SysCoderuleEntity.prefix     前缀字符
     *     (允许为空)SysCoderuleEntity.dateFormat 日期格式
     *
     *     (允许为空)SysCoderuleEntity.isNeedCompany
     *     (允许为空)SysCoderuleEntity.isNeedPrefix
     *     (允许为空)SysCoderuleEntity.isNeedDate
     *     (允许为空)SysCoderuleEntity.isNeedCode
     *
     * @param object  生成编码-通用编码规则需要的参数对象
     * @return
     */
    String findCoderule(CoderuleEntity object) throws Exception;

}



