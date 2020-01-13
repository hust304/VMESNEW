package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.purchase.dao.PurchaseSignDetailMapper;
import com.xy.vmes.deecoop.purchase.dao.PurchaseSignInDetailMapper;
import com.xy.vmes.entity.PurchaseSignDetail;
import com.xy.vmes.service.PurchaseSignDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_purchase_sign_detail:采购签收明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-03-12
*/
@Service
@Transactional(readOnly = false)
public class PurchaseSignDetailServiceImp implements PurchaseSignDetailService {
    @Autowired
    private PurchaseSignDetailMapper purchaseSignDetailMapper;
    @Autowired
    private PurchaseSignInDetailMapper purchaseSignInDetailMapper;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void save(PurchaseSignDetail object) throws Exception {
        object.setCdate(new Date());
        object.setUdate(new Date());
        purchaseSignDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public PurchaseSignDetail selectById(String id) throws Exception{
        return purchaseSignDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<PurchaseSignDetail> selectByColumnMap(Map columnMap) throws Exception {
        List<PurchaseSignDetail> warehouseCheckDetailList = purchaseSignDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(PurchaseSignDetail object) throws Exception {
        object.setUdate(new Date());
        purchaseSignDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(PurchaseSignDetail object) throws Exception {
        object.setUdate(new Date());
        purchaseSignDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        purchaseSignDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        purchaseSignDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        purchaseSignDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        purchaseSignDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<PurchaseSignDetail> dataList(PageData pd) throws Exception {
        return purchaseSignDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return purchaseSignDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchaseSignDetailMapper.getDataListPage(pd, pg);
        }

        return mapList;
    }

    public void updateStateByDetail(PageData pd) throws Exception{
        purchaseSignDetailMapper.updateStateByDetail(pd);
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
    public List<PurchaseSignDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseSignDetail>();
        }

        return this.dataList(pageData);
    }

    public PurchaseSignDetail findSignDetail(PageData object) throws Exception {
        List<PurchaseSignDetail> objectList = this.findSignDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchaseSignDetail findSignDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSignDetail(findMap);
    }

    public List<PurchaseSignDetail> findSignDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchaseSignDetail> findSignDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSignDetailList(findMap);
    }

    /**
     * 获取签收单状态-根据签收单明细状态
     * 签收单单状态(1:检验中 2:已完成 -1:已取消)
     * 签收单明细状态(1:检验中 2:已完成 -1:已取消)
     *
     * @param objectList      采购签收单明细List<PurchaseSignDetail>
     * @return
     */
    public String findParentStateByDetailList(List<PurchaseSignDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}

        //签收单明细状态(1:检验中 2:已完成 -1:已取消)
        int jyz = 0; //1:检验中
        int ywc = 0; //2:已完成
        int yqx = 0; //-1:已取消

        if (objectList != null && objectList.size() > 0) {
            for (PurchaseSignDetail detail : objectList) {
                if ("-1".equals(detail.getState())) {
                    yqx = yqx + 1;
                } else if ("1".equals(detail.getState())) {
                    jyz = jyz + 1;
                } else if ("2".equals(detail.getState())) {
                    ywc = ywc + 1;
                }
            }
        }

        //签收单明细状态:-1:已取消 全是已取消状态  签收单状态:-1:已取消
        if (yqx > 0 && yqx == objectList.size()) {
            return "-1";

            //签收单明细状态:2:已完成(发货) 全是已完成  签收单状态:2:已完成
        } else if (ywc > 0 && yqx >= 0 && jyz == 0) {
            return "2";

            //签收单明细状态:1:检验中 一条或多条  签收单状态:1:检验中
        } else if (jyz > 0) {
            return "1";
        }

        return null;
    }

    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param objectList
     * @return
     */
    public Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> objectList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
        if (objectList == null || objectList.size() == 0) {return productByInMap;}

        for (Map<String, String> objectMap : objectList) {
            //单位换算
            //p2nFormula 单位换算公式:计价单位转换计量单位:
            String p2nFormula = new String();
            if (objectMap.get("p2nFormula") != null) {
                p2nFormula = objectMap.get("p2nFormula").trim();
            }

            //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
            String p2nIsScale = new String();
            if (objectMap.get("p2nIsScale") != null) {
                p2nIsScale = objectMap.get("p2nIsScale").trim();
            }

            //小数位数 (最小:0位 最大:4位)
            Integer p2nDecimalCount = Integer.valueOf(2);
            String p2nDecimalCountStr = objectMap.get("p2nDecimalCount");
            if (p2nDecimalCountStr != null) {
                try {
                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////

            //signDtlId 采购签收明细id
            String signDtlId = objectMap.get("signDtlId");

            //productId 货品id
            String productId = objectMap.get("productId");

            //count 签收数量(arriveCount) count := inCount 入库数量
            BigDecimal count = BigDecimal.valueOf(0D);
            String arriveCountStr = objectMap.get("arriveCount");
            if (arriveCountStr != null && arriveCountStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(arriveCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //(计量单位)入库数量 - 单位换算公式(p2nFormula)
            BigDecimal prodCount = EvaluateUtil.countFormulaP2N(count, p2nFormula);
            prodCount = StringUtil.scaleDecimal(prodCount, p2nIsScale, p2nDecimalCount);

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", prodCount);

            productByInMap.put(signDtlId, productMap);
        }

        return productByInMap;
    }

    /**
     * 获取采购签收明细入库执行情况
     * 查询SQL语句: PurchaseSignInDetailMapper.findSignDetailByInDetail
     * @param object
     * @return
     */
    public List<Map<String, Object>> findSignDetailByInDetail(PageData object) throws Exception {
        return purchaseSignInDetailMapper.findSignDetailByInDetail(object);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchaseSignDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("PurchaseSignDetail");
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

    //获取(质量-采购检验)采购签收明细检验
    //菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
    public ResultModel listPagePurchaseSignDetailByQualityExecute(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("PurchaseSignDetail");
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

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //qualityType 检验方式id (1:全检 2:抽检)
                String qualityType = "1";
                if (mapObject.get("qualityType") != null && mapObject.get("qualityType").toString().trim().length() > 0) {
                    qualityType = mapObject.get("qualityType").toString().trim();
                }

                //arriveCount 签收数
                BigDecimal arriveCount = BigDecimal.valueOf(0D);
                if (mapObject.get("arriveCount") != null) {
                    arriveCount = (BigDecimal)mapObject.get("arriveCount");
                }

                //qualityCount 实检数
                BigDecimal qualityCount = BigDecimal.valueOf(0D);
                //qualityType 检验方式:1:全检 qualityCount实检数 == arriveCount签收数
                if ("1".equals(qualityType)) {
                    qualityCount = arriveCount;
                }
                //四舍五入到2位小数
                qualityCount = qualityCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                mapObject.put("qualityCount", qualityCount.toString());

                BigDecimal tempBigDecimal = BigDecimal.valueOf(0D);
                tempBigDecimal = tempBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                //badCount 不合格数
                mapObject.put("badCount", tempBigDecimal.toString());
                //retreatCount 退货数
                mapObject.put("retreatCount", tempBigDecimal.toString());
                //receiveCount 让步接收
                mapObject.put("receiveCount", tempBigDecimal.toString());
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    //采购签收明细-检验执行
    public ResultModel purchaseSignDetailByQualityExecute(PageData pd) throws Exception {
        return null;
    }

    //采购签收明细-免检
    public ResultModel updateSignDetailByQuality(PageData pd) throws Exception {
        return null;
    }

}



