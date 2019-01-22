package com.xy.vmes.deecoop.mobile.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：手机端移库
 * 创建人：房兆琦
 * 创建时间：2018-11-13
 */
@Mapper
@Repository
public interface MobileWarehouseMoveMapper {

    List<Map> findWarehouseMove(PageData pd);

}

