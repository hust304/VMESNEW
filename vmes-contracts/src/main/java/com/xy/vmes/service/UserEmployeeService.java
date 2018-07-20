package com.xy.vmes.service;

import com.xy.vmes.entity.ViewVmesUserEmployee;
import com.yvan.PageData;

import java.util.List;

/**
 * 说明：用户-员工 接口类
 * 创建人：自动生成
 * 创建时间：2018-07-18
 */
public interface UserEmployeeService {
    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    List<ViewVmesUserEmployee> findViewUserEmployList(PageData mapObj);
}
