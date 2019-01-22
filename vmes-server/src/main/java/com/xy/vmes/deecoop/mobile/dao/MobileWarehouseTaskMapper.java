package com.xy.vmes.deecoop.mobile.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：仓库管理(入库,出库,盘点,移库)任务单
 * 创建人：房兆琦
 * 创建时间：2018-11-13
 */
@Mapper
@Repository
public interface MobileWarehouseTaskMapper {

    List<Map> findListPageWarehouseTaskList(PageData pd, Pagination pg);

}
