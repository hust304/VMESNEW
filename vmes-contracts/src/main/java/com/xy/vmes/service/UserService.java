package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.User;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 接口类
* 创建人：自动生成
* 创建时间：2018-07-20
*/
public interface UserService {


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void save(User user) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void delete(User user) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void update(User user) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void deleteById(String id) throws Exception;
    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    User selectById(String id) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    User findById(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<User> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<User> dataList(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    List<Map> findDataList(PageData pd) throws Exception;
}



