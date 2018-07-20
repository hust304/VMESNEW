package com.xy.vmes.deecoop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xy.vmes.entity.ViewVmesUserEmployee;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建人：陈刚
 * 创建时间：2018-07-20
 */
@Mapper
@Repository
public interface ViewVmesUserEmployeeMapper extends BaseMapper<ViewVmesUserEmployee> {

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @Select("findViewUserEmployList")
    List<ViewVmesUserEmployee> findViewUserEmployList(PageData pd);
}
