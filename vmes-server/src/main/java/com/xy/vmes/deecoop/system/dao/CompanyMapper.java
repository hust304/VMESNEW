package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CompanyMapper  {
    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    List<LinkedHashMap> getColumnList();

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
}
