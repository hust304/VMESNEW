package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Template;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_template:标准开发模板 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-08-23
*/
public interface TemplateService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void save(Template template) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void update(Template template) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-23
     */
    void updateAll(Template template) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    Template selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Template> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Template> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Template> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    void updateToDisableByIds(String[] ids)throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    List<Map> getTestDataListPage(PageData pd, Pagination pg) throws Exception;

    List<Map> getTestDataList2Page(PageData pd, Pagination pg) throws Exception;
}



