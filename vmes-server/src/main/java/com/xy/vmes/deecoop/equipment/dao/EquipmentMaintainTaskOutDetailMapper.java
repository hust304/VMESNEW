package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EquipmentMaintainTaskOutDetailMapper {
    List<Map> findTaskDetailByOutDetail(PageData pd, Pagination pg);
    List<Map> findTaskDetailByOutDetail(PageData pd);
}
