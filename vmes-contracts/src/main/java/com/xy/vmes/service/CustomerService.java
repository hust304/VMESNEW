package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Customer;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_customer:客户供应商表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-09-18
*/
public interface CustomerService {


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void save(Customer customer) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void update(Customer customer) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void updateAll(Customer customer) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    Customer selectById(String id) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<Customer> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<Customer> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<Customer> selectByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-18
    */
    void updateToDisableByIds(String[] ids) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    Customer findCustomer(PageData object);
    Customer findCustomerById(String id);

    /**
     * check客户列表List<Customer>是否允许删除
     * true : 可以删除
     * false: 不可删除
     *
     * 创建人：陈刚
     * 创建时间：2018-09-18
     * @param ids
     * @return
     */
    boolean checkDeleteCustomerByIds(String ids);

    /**
     * 获取(删除,修改)客户表主键id(vmes_customer)-通过','分隔的字符串
     *     <"DeleteIds", 客户表主键id>
     *     <"UpdateIds", 客户表主键id>
     * @param ids
     * @return
     */
    Map<String, String> findDeleteCustIdsByIds(String ids);

}



