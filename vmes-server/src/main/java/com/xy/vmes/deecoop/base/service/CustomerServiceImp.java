package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.CustomerMapper;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.CustomerService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
 * 说明：vmes_customer:客户供应商表 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2018-09-18
 */
@Service
@Transactional(readOnly = false)
public class CustomerServiceImp implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void save(Customer customer) throws Exception{
        customer.setId(Conv.createUuid());
        customer.setCdate(new Date());
        customer.setUdate(new Date());
        customerMapper.insert(customer);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void update(Customer customer) throws Exception{
        customer.setUdate(new Date());
        customerMapper.updateById(customer);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void updateAll(Customer customer) throws Exception{
        customer.setUdate(new Date());
        customerMapper.updateAllColumnById(customer);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    //@Cacheable(cacheNames = "customer", key = "''+#id")
    public Customer selectById(String id) throws Exception{
        return customerMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void deleteById(String id) throws Exception{
        customerMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        customerMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<Customer> dataListPage(PageData pd,Pagination pg) throws Exception{
        return customerMapper.dataListPage(pd,pg);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<Customer> dataList(PageData pd) throws Exception{
        return customerMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return customerMapper.findColumnList();
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return customerMapper.findDataList(pd);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        customerMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<Customer> selectByColumnMap(Map columnMap) throws Exception{
        List<Customer> customerList =  customerMapper.selectByMap(columnMap);
        return customerList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return customerMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-09-18
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        customerMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    @Override
    public List<Map> getReceiveDataListPage(PageData pd,Pagination pg) throws Exception{
        return customerMapper.getReceiveDataListPage(pd,pg);
    }


    @Override
    public List<TreeEntity> getTreeList(PageData pd) throws Exception{
        return  customerMapper.getTreeList(pd);
    }

    public Customer findCustomer(PageData object) {
        if (object == null) {return null;}

        List<Customer> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public Customer findCustomerById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Customer> objectList = this.findCustomerList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    public List<Customer> findCustomerList(PageData object) {
        if (object == null) {return null;}

        List<Customer> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    /**
     * check客户列表List<Customer>是否允许删除
     *
     * 创建人：陈刚
     * 创建时间：2018-09-18
     * @param ids
     * @return
     */
    public boolean checkDeleteCustomerByIds(String ids) {
        return true;
    }

    /**
     * 获取(删除,修改)客户表主键id(vmes_customer)-通过','分隔的字符串
     *     <"DeleteIds", 客户表主键id>
     *     <"UpdateIds", 客户表主键id>
     * @param ids
     * @return
     */
    public Map<String, String> findDeleteCustIdsByIds(String ids) {
        Map<String, String> mapObject = new HashMap<String, String>();
        if (ids == null || ids.trim().length() == 0) {return mapObject;}

        String deleteIds = "";
        String updateIds = "";
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            if (this.checkDeleteCustomerByIds(id)) {
                updateIds = updateIds + id + ",";
            } else {
                deleteIds = deleteIds + id + ",";
            }
        }

        if (deleteIds.trim().length() > 0) {
            deleteIds = deleteIds.substring(0, deleteIds.lastIndexOf(","));
        }
        if (updateIds.trim().length() > 0) {
            updateIds = updateIds.substring(0, updateIds.lastIndexOf(","));
        }

        mapObject.put("DeleteIds", deleteIds);
        mapObject.put("UpdateIds", updateIds);

        return mapObject;
    }


    @Override
    public void updateCustomerBalance(Customer customer, BigDecimal balance, String uuser) throws Exception {
        PageData pd = new PageData();
        pd.put("id",customer.getId());
        pd.put("version",customer.getVersion());
        pd.put("uuser",uuser);
        pd.put("balance",balance);
        customerMapper.updateCustomerBalance(pd);
    }
}
