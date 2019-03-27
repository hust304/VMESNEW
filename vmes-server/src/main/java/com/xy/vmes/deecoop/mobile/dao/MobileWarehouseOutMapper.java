package com.xy.vmes.deecoop.mobile.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2019/1/22.
 */
@Mapper
@Repository
public interface  MobileWarehouseOutMapper {
    List<Map> findWarehouseOutByDetailId(PageData pd);

    List<Map> listWarehousePath(PageData pd);

    List<Map> listWarehouseCode(PageData pd);

    List<Map> listWarehouseOutExecuteCount(PageData pd);
}
