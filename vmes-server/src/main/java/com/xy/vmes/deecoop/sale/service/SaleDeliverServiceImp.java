package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverMapper;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.service.SaleDeliverService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_sale_deliver:发货表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Service
@Transactional(readOnly = false)
public class SaleDeliverServiceImp implements SaleDeliverService {

    @Autowired
    private SaleDeliverMapper saleDeliverMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-15
    */
    @Override
    public void save(SaleDeliver saleDeliver) throws Exception{
        saleDeliver.setId(Conv.createUuid());
        saleDeliver.setCdate(new Date());
        saleDeliver.setUdate(new Date());
        saleDeliverMapper.insert(saleDeliver);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public SaleDeliver selectById(String id) throws Exception{
        return saleDeliverMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliver> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleDeliver> warehouseCheckDetailList =  saleDeliverMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void update(SaleDeliver object) throws Exception{
        object.setUdate(new Date());
        saleDeliverMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateAll(SaleDeliver object) throws Exception{
        object.setUdate(new Date());
        saleDeliverMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleDeliverMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleDeliverMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleDeliverMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleDeliverMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByDeliver(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        saleDeliverMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliver> dataList(PageData pd) throws Exception{
        return saleDeliverMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleDeliverMapper.getDataListPage(pd,pg);
    }

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
    public List<SaleDeliver> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleDeliver>();
        }

        return this.dataList(pageData);
    }

    public SaleDeliver findSaleDeliver(PageData object) throws Exception {
        List<SaleDeliver> objectList = this.findSaleDeliverList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleDeliver findSaleDeliverById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleDeliver(findMap);
    }

    public List<SaleDeliver> findSaleDeliverList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ////////////////////////////////////////////////////////////////

    /**
     * 验证客户是否相同，订单明细生成发货单
     * model_code = 'saleOrderDetail'
     *
     * @param mapList
     * @return
     */
    public String checkCustomerByOrderDetailList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String msgTemp = "第 {0} 行: 勾选的数据(客户名称)不相同" + Common.SYS_ENDLINE_DEFAULT;

        Map<String, String> customerMap = new HashMap<String, String>();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> detailMap = mapList.get(i);

            String customerId = detailMap.get("customerId");
            if (customerMap.size() == 1 && customerMap.get(customerId) == null) {
                String msg_Str = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msg_Str);
            } else if (customerMap.size() == 0) {
                customerMap.put(customerId, customerId);
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            msgBuf.append("请通过查询条件过滤出相同客户名称的订单！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }
}



