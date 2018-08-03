package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.EmployPost;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_employ_post:员工岗位关系表 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-08-01
*/
public interface EmployPostService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void save(EmployPost employPost) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void update(EmployPost employPost) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    EmployPost selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<EmployPost> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<EmployPost> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<EmployPost> selectByColumnMap(Map columnMap) throws Exception;


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    void updateToDisableByIds(String[] ids)throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
     * 创建人：刘威
     * 创建时间：2018-08-03
     */
    void updateToDisableByEmployIds(String[] ids) throws Exception;

}



