package com.xy.vmes.deecoop.mobile.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：手机端入库
 * 创建人：房兆琦
 * 创建时间：2018-11-13
 */
@Mapper
@Repository
public interface MobileWarehouseInMapper {

    //获得入库任务详细信息
    List<Map> findWarehouseIn(PageData pd);
    List<Map> listWarehouseInExecuteCount(PageData pd);

}

