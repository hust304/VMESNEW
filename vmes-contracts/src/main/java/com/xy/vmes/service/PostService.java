package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Post;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_post:岗位管理 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-08-01
*/
public interface PostService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void save(Post post) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    void update(Post post) throws Exception;

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
    Post selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<Post> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    List<Post> dataList(PageData pd) throws Exception;

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
    List<Post> selectByColumnMap(Map columnMap) throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
     * 创建人：刘威 自动创建，可以修改
     * 创建时间：2018-08-01
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，可以修改
    * 创建时间：2018-08-01
    */
    void updateToDisableByIds(String[] ids)throws Exception;

}



