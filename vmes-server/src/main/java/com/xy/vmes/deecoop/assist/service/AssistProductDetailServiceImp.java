package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistProductDetailMapper;
import com.xy.vmes.entity.AssistOrderDetailChild;
import com.xy.vmes.entity.AssistProductDetail;
import com.xy.vmes.service.AssistProductDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.ClassUtils;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_assist_product_detail:外协件原材料 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-04-19
*/
@Service
@Transactional(readOnly = false)
public class AssistProductDetailServiceImp implements AssistProductDetailService {
    @Autowired
    private AssistProductDetailMapper assistProductDetailMapper;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void save(AssistProductDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistProductDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public AssistProductDetail selectById(String id) throws Exception{
        return assistProductDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public List<AssistProductDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistProductDetail> warehouseCheckDetailList = assistProductDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void update(AssistProductDetail object) throws Exception{
        object.setUdate(new Date());
        assistProductDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void updateAll(AssistProductDetail object) throws Exception{
        object.setUdate(new Date());
        assistProductDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistProductDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistProductDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistProductDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistProductDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-19
     */
    public List<AssistProductDetail> dataList(PageData pd) throws Exception{
        return assistProductDetailMapper.dataList(pd);
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
            return assistProductDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistProductDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistProductDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistProductDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistProductDetail findAssistProductDetail(PageData object) throws Exception {
        List<AssistProductDetail> objectList = this.findAssistProductDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistProductDetail findAssistProductDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistProductDetail(findMap);
    }

    public List<AssistProductDetail> findAssistProductDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistProductDetail> findAssistProductDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("orderStr", "cdate asc");

        return this.findAssistProductDetailList(findMap);
    }

    /**
     * 表(vmes_assist_product_detail:外协件原材料)对象 转换为目标类对象
     *
     * @param assistProductDtl 表(vmes_assist_product_detail:外协件原材料)对象
     * @param targetClazz      目标类
     * @return
     */
    public Object assistProductDetail2Target(AssistProductDetail assistProductDtl, Class<?> targetClazz) throws Exception {
        if (assistProductDtl == null) {
            return ClassUtils.instanceObject(targetClazz);
        }

        Object targetObject = ClassUtils.instanceObject(targetClazz);
        Map<Method, Field> methodFieldMap = ClassUtils.paraserSet(targetClazz);
        for (Iterator iterator = methodFieldMap.keySet().iterator(); iterator.hasNext();) {
            //目标类
            Method mapkey_targetMethod = (Method)iterator.next();
            Field target_field = methodFieldMap.get(mapkey_targetMethod);

            String target_fieldName = target_field.getName();
            if ("productId".equals(target_fieldName)) {
                mapkey_targetMethod.invoke(targetObject, assistProductDtl.getProductId());
            } else if ("unitId".equals(target_fieldName)) {
                mapkey_targetMethod.invoke(targetObject, assistProductDtl.getUnitId());
            } else if ("ratio".equals(target_fieldName)) {
                mapkey_targetMethod.invoke(targetObject, assistProductDtl.getRatio());
            }
        }

        return targetObject;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistProductDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistProductDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public static void main(String[] args) throws Exception {
        AssistProductDetailService service = new AssistProductDetailServiceImp();

        AssistProductDetail assistProductDtl = new AssistProductDetail();
        assistProductDtl.setParentId("ParentId");
        assistProductDtl.setUnitId("UnitId");
        assistProductDtl.setRatio(BigDecimal.valueOf(2.23D));

        Object object = service.assistProductDetail2Target(assistProductDtl, AssistOrderDetailChild.class);
        AssistOrderDetailChild aaaa = (AssistOrderDetailChild)object;

        System.out.print("*****************");
    }

}



