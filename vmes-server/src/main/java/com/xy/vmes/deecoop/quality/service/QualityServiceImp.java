package com.xy.vmes.deecoop.quality.service;

import com.xy.vmes.deecoop.quality.dao.QualityMapper;
import com.xy.vmes.entity.Quality;
import com.xy.vmes.service.QualityService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
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
* 说明：vmes_quality:质量检验项目 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-12-28
*/
@Service
@Transactional(readOnly = false)
public class QualityServiceImp implements QualityService {
    @Autowired
    private QualityMapper qualityMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void save(Quality object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        qualityMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public Quality selectById(String id) throws Exception{
        return qualityMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<Quality> selectByColumnMap(Map columnMap) throws Exception {
        List<Quality> warehouseCheckDetailList = qualityMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(Quality object) throws Exception {
        object.setUdate(new Date());
        qualityMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(Quality object) throws Exception {
        object.setUdate(new Date());
        qualityMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        qualityMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        qualityMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        qualityMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        qualityMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<Quality> dataList(PageData pd) throws Exception {
        return qualityMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-12-28
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return qualityMapper.getDataListPage(pd);
        } else if (pg != null) {
            return qualityMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    public List<Map> findListProductByQuality(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return qualityMapper.findListProductByQuality(pd);
        } else if (pg != null) {
            return qualityMapper.findListProductByQuality(pd,pg);
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
    public List<Quality> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<Quality>();
        }

        return this.dataList(pageData);
    }

    public Quality findQuality(PageData object) throws Exception {
        List<Quality> objectList = this.findQualityList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public Quality findQualityById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findQuality(findMap);
    }
    public List<Quality> findQualityList(PageData object) throws Exception  {
        return this.findDataList(object, null);
    }

    /**
     * 修改货品表
     * purchase:采购:(vmes_product.purchase_quality_type)字段
     *
     * @param business     业务名称 (purchase:采购)
     * @param productIds   货品id ','逗号分隔的字符串
     * @param qualityType  质验方式
     */
    public void updateProductQuality(String business, String productIds, String qualityType) {
        if (business == null || business.trim().length() == 0) {return;}
        if (productIds == null || productIds.trim().length() == 0) {return;}
        if (qualityType == null || qualityType.trim().length() == 0) {return;}

        if ("purchase".equals(business.trim())) {
            productIds = StringUtil.stringTrimSpace(productIds);
            productIds = "'" + productIds.replace(",", "','") + "'";

            PageData mapObject = new PageData();
            mapObject.put("purchaseQualityType", qualityType);
            mapObject.put("productIds", productIds);
            qualityMapper.updateProductQualityByPurchase(mapObject);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * (质量-采购质检)分页查询
     *
     * @param pd    查询参数对象PageData
     * @return      返回对象ResultModel
     * @throws Exception
     */
    public ResultModel listPageProductByQuality(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("productByQuality");
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

        if (pd.getString("currentCompanyId") != null) {
            pd.put("companyId", pd.getString("currentCompanyId").trim());
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

        List<Map> varList = this.findListProductByQuality(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageQuality(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("quality");
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

    //获取(质量-采购检验)采购签收明细检验项目
    //菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
    public ResultModel findQualityByPurchaseSignDtl(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("qualityBySignDetail");
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

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        //SQL查询语句 QualityMapper.getDataListPage
        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //name 质检项 --> qualityName
                String qualityName = new String();
                if (mapObject.get("name") != null) {
                    qualityName = mapObject.get("name").toString().trim();
                }
                mapObject.put("qualityName", qualityName);

                //criterion 检验标准 --> qualityCriterion
                String qualityCriterion = new String();
                if (mapObject.get("criterion") != null) {
                    qualityCriterion = mapObject.get("criterion").toString().trim();
                }
                mapObject.put("qualityCriterion", qualityCriterion);

                //badCount 检验不合格
                mapObject.put("badCount", "0.00");
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addQuality(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品id为空或空字符串！");
            return model;
        }
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //business:业务名称 (purchase:采购)
        String business = pageData.getString("business");
        if (business == null || business.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(business:业务名称)为空或空字符串！");
            return model;
        }

        //name 质检项
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("质检项为必填项不可为空！");
            return model;
        }

        //criterion 检验标准
        String criterion = pageData.getString("criterion");
        if (criterion == null || criterion.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("检验标准为必填项不可为空！");
            return model;
        }

        String cuser = pageData.getString("cuser");

        Quality addQuality = new Quality();
        addQuality.setCompanyId(companyId);
        addQuality.setCuser(cuser);

        addQuality.setProductId(productId);
        addQuality.setName(name);
        addQuality.setCriterion(criterion);
        addQuality.setBusiness(business);

        this.save(addQuality);

        return model;
    }

}



