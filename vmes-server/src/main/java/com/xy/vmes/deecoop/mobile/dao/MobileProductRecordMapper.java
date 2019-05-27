package com.xy.vmes.deecoop.mobile.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：库存查询     （接口复用，不发送参数获得公司所有的库存信息；发送参数则进行筛选）
 * 创建人：房兆琦
 * 创建时间：2018-11-13
 */
@Mapper
@Repository
public interface MobileProductRecordMapper {

    //手机端功能
    List<Map> listPageProductRecords(PageData pd, Pagination pg);

}

