package com.xy.vmes.deecoop.sale.service;


import com.xy.vmes.deecoop.sale.dao.SaleOrdeDetailChangeMapper;
import com.xy.vmes.entity.SaleOrdeDetailChange;
import com.xy.vmes.service.SaleOrdeDetailChangeService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_saleOrdeDtl_change:订单明细变更记录表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-11-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrdeDetailChangeServiceImp implements SaleOrdeDetailChangeService {
    @Autowired
    private SaleOrdeDetailChangeMapper saleOrdeDtlChangeMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void save(SaleOrdeDetailChange object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public SaleOrdeDetailChange selectById(String id) throws Exception{
        return saleOrdeDtlChangeMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<SaleOrdeDetailChange> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleOrdeDetailChange> warehouseCheckDetailList = saleOrdeDtlChangeMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void update(SaleOrdeDetailChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateAll(SaleOrdeDetailChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleOrdeDtlChangeMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleOrdeDtlChangeMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleOrdeDtlChangeMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleOrdeDtlChangeMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    public List<SaleOrdeDetailChange> dataList(PageData pd) throws Exception {
        return saleOrdeDtlChangeMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrdeDtlChangeMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrdeDtlChangeMapper.getDataListPage(pd, pg);
        }

        return mapList;
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
    public List<SaleOrdeDetailChange> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrdeDetailChange>();
        }

        return this.dataList(pageData);
    }

    public SaleOrdeDetailChange findOrdeDtlChange(PageData object) throws Exception {
        List<SaleOrdeDetailChange> objectList = this.findOrdeDtlChangeList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleOrdeDetailChange findOrdeDtlChangeById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findOrdeDtlChange(findMap);
    }

    public List<SaleOrdeDetailChange> findOrdeDtlChangeList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleOrdeDetailChange> findOrdeDtlChangeListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findOrdeDtlChangeList(findMap);
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleOrdeDtlChange(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("saleOrdeDtlChange");
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



