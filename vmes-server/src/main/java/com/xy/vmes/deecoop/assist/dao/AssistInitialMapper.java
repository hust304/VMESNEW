package com.xy.vmes.deecoop.assist.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 说明：:外协件初始化 Mapper.java
 * 创建人：陈刚
 * 创建时间：2020-05-13
 */
@Mapper
@Repository
public interface AssistInitialMapper {
    void deleteAssistByInitial(PageData pd);
}
