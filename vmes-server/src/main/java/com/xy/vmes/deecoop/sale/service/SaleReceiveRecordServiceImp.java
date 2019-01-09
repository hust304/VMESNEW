package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveRecordMapper;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.CustomerService;
import com.xy.vmes.service.SaleReceiveRecordService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：收款记录 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-25
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveRecordServiceImp implements SaleReceiveRecordService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SaleReceiveRecordMapper saleReceiveRecordMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void save(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setId(Conv.createUuid());
        saleReceiveRecord.setCdate(new Date());
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.insert(saleReceiveRecord);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void update(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.updateById(saleReceiveRecord);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void updateAll(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.updateAllColumnById(saleReceiveRecord);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    //@Cacheable(cacheNames = "saleReceiveRecord", key = "''+#id")
    public SaleReceiveRecord selectById(String id) throws Exception{
        return saleReceiveRecordMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveRecordMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveRecordMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveRecordMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> dataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveRecordMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveRecordMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceiveRecord> saleReceiveRecordList =  saleReceiveRecordMapper.selectByMap(columnMap);
        return saleReceiveRecordList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveRecordMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveRecordMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveRecordMapper.updateToDisableByIds(ids);
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
    public List<SaleReceiveRecord> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceiveRecord>();
        }

        return this.dataList(pageData);
    }

    /**
     * 修改客户余额
     * 1. 修改客户表(vmes_customer)
     * 2. 添加历史表(vmes_sale_receive_record)
     *
     * @param customerId  客户id
     * @param customer    客户对象
     * @param editBalance 修改客户余额 (订单取消，订单删除 该参数为负数)
     * @param user        用户id
     */
    public void editCustomerBalanceByOrder(String customerId, Customer customer, BigDecimal editBalance, String user) throws ApplicationException,TableVersionException {
        if (customerId == null || customerId.trim().length() == 0) {return;}
        if (editBalance == null) {return;}
        if (customer == null) {customer = customerService.findCustomerById(customerId);}
        if (customer == null) {return;}

        //1. 修改客户表(vmes_customer)
        //变更前
        BigDecimal before_balance = BigDecimal.valueOf(0D);
        if (customer.getBalance() != null) {
            before_balance = customer.getBalance();
        }

        //变更后
        double new_balance = before_balance.doubleValue() + editBalance.doubleValue();
        BigDecimal new_balanceBig = BigDecimal.valueOf(new_balance);
        //四舍五入到2位小数
        new_balanceBig = new_balanceBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        try {
            customerService.updateCustomerBalance(customer, new_balanceBig, user,"1");
        } catch (Exception e) {
            e.printStackTrace();
            throw new TableVersionException(Common.SYS_STOCKCOUNT_ERRORCODE, "当前系统繁忙，请稍后操作！");
        }

//        //2. 添加历史表(vmes_sale_receive_record)
//        SaleReceiveRecord saleReceiveRecord = new SaleReceiveRecord();
//        saleReceiveRecord.setBeforeAmount(before_balance);
//        saleReceiveRecord.setAfterAmount(new_balanceBig);
//        saleReceiveRecord.setAmount(editBalance);
//        saleReceiveRecord.setCustomerId(customerId);
//        //(0:修改 1:添加 2:取消 -1:删除)
//        saleReceiveRecord.setType("0");
//        saleReceiveRecord.setRemark("录入收款："+ editBalance.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP));
//        saleReceiveRecord.setUuser(user);
//        saleReceiveRecord.setCuser(user);
//        try {
//            this.save(saleReceiveRecord);
//        } catch (Exception e) {
//            throw new ApplicationException(e.getMessage());
//        }

    }
}



