package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Loginfo;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_loginfo:系统日志表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-08-08
*/
public interface LoginfoService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    void save(Loginfo loginfo) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    List<Loginfo> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    List<LinkedHashMap<String, String>> getColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    List<Map<String, Object>> getDataListPage(PageData pd, Pagination pg) throws Exception;

}



