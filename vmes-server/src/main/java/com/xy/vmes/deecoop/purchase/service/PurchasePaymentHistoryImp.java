package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchasePaymentHistoryMapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.PurchasePaymentHistory;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.PurchasePaymentHistoryService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
 * 说明：vmes_purchase_payment_history:供应商账期汇总 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2019-03-11
 */
@Service
@Transactional(readOnly = false)
public class PurchasePaymentHistoryImp implements PurchasePaymentHistoryService {


    @Autowired
    private PurchasePaymentHistoryMapper purchasePaymentHistoryMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void save(PurchasePaymentHistory object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        purchasePaymentHistoryMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public PurchasePaymentHistory selectById(String id) throws Exception{
        return purchasePaymentHistoryMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentHistory> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchasePaymentHistory> warehouseCheckDetailList =  purchasePaymentHistoryMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void update(PurchasePaymentHistory object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentHistoryMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateAll(PurchasePaymentHistory object) throws Exception{
        object.setUdate(new Date());
        purchasePaymentHistoryMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePaymentHistoryMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePaymentHistoryMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePaymentHistoryMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePaymentHistoryMapper.updateToDisableByIds(ids);
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
    public List<PurchasePaymentHistory> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePaymentHistory>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<PurchasePaymentHistory> dataList(PageData pd) throws Exception{
        return purchasePaymentHistoryMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-03-11
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return purchasePaymentHistoryMapper.getDataListPage(pd, pg);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param pd    查询参数对象PageData
     * @param pg    分页参数对象Pagination
     * @return      返回对象ResultModel
     * @throws Exception
     */
    public ResultModel listPagePurchasePaymentHistory(PageData pd,Pagination pg) throws Exception{
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("purchaseReceiveCollect");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

}
