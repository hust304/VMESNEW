package com.xy.vmes.service;

import com.xy.vmes.entity.Department;
import com.yvan.PageData;

/**
 * 说明：企业申请注册 接口类
 * 创建人：陈刚
 * 创建时间：2020-02-21
 */
public interface CompanyApplicationService {

    void addCompanyApplication(PageData companyMap) throws Exception;
}
