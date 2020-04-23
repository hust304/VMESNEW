package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistSupplierMapper;
import com.xy.vmes.entity.AssistSupplier;
import com.xy.vmes.service.AssistSupplierService;

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
* 说明：vmes_assist_supplier:外协供应商 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-04-23
*/
@Service
@Transactional(readOnly = false)
public class AssistSupplierServiceImp implements AssistSupplierService {
    @Autowired
    private AssistSupplierMapper assistSupplierMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void save(AssistSupplier object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistSupplierMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public AssistSupplier selectById(String id) throws Exception{
        return assistSupplierMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public List<AssistSupplier> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistSupplier> warehouseCheckDetailList = assistSupplierMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void update(AssistSupplier object) throws Exception{
        object.setUdate(new Date());
        assistSupplierMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void updateAll(AssistSupplier object) throws Exception{
        object.setUdate(new Date());
        assistSupplierMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistSupplierMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistSupplierMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistSupplierMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistSupplierMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    public List<AssistSupplier> dataList(PageData pd) throws Exception{
        return assistSupplierMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistSupplierMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistSupplierMapper.getDataListPage(pd,pg);
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
    public List<AssistSupplier> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistSupplier>();
        }

        return this.dataList(pageData);
    }

    public AssistSupplier findAssistSupplier(PageData object) throws Exception {
        List<AssistSupplier> objectList = this.findAssistSupplierList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistSupplier findAssistSupplierById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistSupplier(findMap);
    }
    public List<AssistSupplier> findAssistSupplierList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    /**
     * 判断(供应商,外协件)--表(vmes_assist_supplier:外协供应商) 是否存在
     * @param id
     * @param companyId       企业id
     * @param supplierId      供应商id
     * @param assistProductId 外协件id
     * @return
     */
    public boolean isExistAssistSupplier(String id, String companyId, String supplierId, String assistProductId) throws Exception {
        PageData findMap = new PageData();
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("companyId", companyId);
        findMap.put("supplierId", supplierId);
        findMap.put("assistProductId", assistProductId);

        List<AssistSupplier> objetList = this.findAssistSupplierList(findMap);
        if (objetList != null && objetList.size() > 0) {
            return true;
        }

        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistSupplier(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistSupplier");
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



