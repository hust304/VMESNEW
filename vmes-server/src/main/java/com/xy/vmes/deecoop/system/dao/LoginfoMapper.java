package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Loginfo;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_loginfo:系统日志表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-08-08
*/
@Mapper
@Repository
public interface LoginfoMapper extends BaseMapper<Loginfo> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-08
     */
    @Select("dataList")
    List<Loginfo> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-08
     */
    @Select("getColumnList")
    List<LinkedHashMap<String, String>> getColumnList();

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-08
     */
    @Select("getDataListPage")
    List<Map<String, Object>> getDataListPage(PageData pd, Pagination pg);

}


