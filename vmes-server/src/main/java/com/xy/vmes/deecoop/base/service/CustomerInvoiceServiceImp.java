package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.CustomerInvoiceMapper;
import com.xy.vmes.entity.CustomerInvoice;
import com.xy.vmes.service.CustomerInvoiceService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
* 说明：vmes_customer_invoice:客户开票信息 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-01-09
*/
@Service
@Transactional(readOnly = false)
public class CustomerInvoiceServiceImp implements CustomerInvoiceService {


    @Autowired
    private CustomerInvoiceMapper customerInvoiceMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-09
    */
    @Override
    public void save(CustomerInvoice customerInvoice) throws Exception{
        customerInvoice.setId(Conv.createUuid());
        customerInvoice.setCdate(new Date());
        customerInvoice.setUdate(new Date());
        customerInvoiceMapper.insert(customerInvoice);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public CustomerInvoice selectById(String id) throws Exception{
        return customerInvoiceMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<CustomerInvoice> selectByColumnMap(Map columnMap) throws Exception{
        List<CustomerInvoice> warehouseCheckDetailList =  customerInvoiceMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void update(CustomerInvoice object) throws Exception{
        object.setUdate(new Date());
        customerInvoiceMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateAll(CustomerInvoice object) throws Exception{
        object.setUdate(new Date());
        customerInvoiceMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteById(String id) throws Exception{
        customerInvoiceMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        customerInvoiceMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        customerInvoiceMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        customerInvoiceMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<CustomerInvoice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<CustomerInvoice>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<CustomerInvoice> dataList(PageData pd) throws Exception{
        return customerInvoiceMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return customerInvoiceMapper.getDataListPage(pd,pg);
    }

    public CustomerInvoice findCustomerInvoice(PageData object) throws Exception{
        List<CustomerInvoice> objectList = this.findCustomerInvoiceList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public CustomerInvoice findCustomerInvoiceById(String id) throws Exception{
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findCustomerInvoice(findMap);
    }

    public List<CustomerInvoice> findCustomerInvoiceList(PageData object) throws Exception{
        return this.findDataList(object, null);
    }
}



