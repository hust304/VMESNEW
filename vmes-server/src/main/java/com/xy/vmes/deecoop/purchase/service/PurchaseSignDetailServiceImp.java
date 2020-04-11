package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.purchase.dao.PurchaseSignDetailMapper;
import com.xy.vmes.deecoop.purchase.dao.PurchaseSignInDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
    private PurchaseSignService signService;
    @Autowired
    private PurchaseQualityDetailService qualityDetailService;
    @Autowired
    private PurchaseOrderDetailToolService orderDetailToolService;

    @Autowired
    private PurchaseOrderService orderService;
    @Autowired
    private PurchaseOrderDetailService orderDetailService;

    @Autowired
    private PurchasePlanService planService;
    @Autowired
    private PurchasePlanDetailService planDetailService;
    @Autowired
    private PurchaseRetreatService retreatService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;
    @Autowired
    private PurchaseByFinanceBillService purchaseByFinanceBillService;

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

        List<Map> varList = this.getDataListPage(pd, pg);
        //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
        String prodColumnKey = pd.getString("prodColumnKey");
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);

                //inParentId (免检)入库单id
                String inParentId = new String();
                if (mapObject.get("inParentId") != null) {
                    inParentId = mapObject.get("inParentId").toString().trim();
                }
                //inCode (免检)入库单编码
                String inCode = new String();
                if (mapObject.get("inCode") != null) {
                    inCode = mapObject.get("inCode").toString().trim();
                }

                //qualityInParentId (检验入库)入库单编码
                String qualityInParentId = new String();
                if (mapObject.get("qualityInParentId") != null) {
                    qualityInParentId = mapObject.get("qualityInParentId").toString().trim();
                }
                //qualityInCode (检验入库)入库单编码
                String qualityInCode = new String();
                if (mapObject.get("qualityInCode") != null) {
                    qualityInCode = mapObject.get("qualityInCode").toString().trim();
                }

                //quality 质检属性id (1:免检 2:检验)
                String quality = new String();
                if (mapObject.get("quality") != null) {
                    quality = mapObject.get("quality").toString().trim();
                }

                //qualityTypeName 检验方式 (1:全检 2:抽检)
                if ("1".equals(quality)) {
                    mapObject.put("qualityTypeName", "免检");
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //signInParentId  合格入库单id
                //signInCode 合格入库单号

                //quality 质检属性:1:免检  (免检)入库单
                if ("1".equals(quality)) {
                    mapObject.put("signInParentId", inParentId);
                    mapObject.put("signInCode", inCode);

                    //quality 质检属性:2:检验  (检验入库)入库单
                } else if ("2".equals(quality)) {
                    mapObject.put("signInParentId", qualityInParentId);
                    mapObject.put("signInCode", qualityInCode);
                }

//                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                //receiveInParentId (检验让步接收入库)入库单id
//                String receiveInParentId = new String();
//                if (mapObject.get("receiveInParentId") != null) {
//                    receiveInParentId = mapObject.get("receiveInParentId").toString().trim();
//                }
//                //receiveInCode (检验让步接收入库)入库单编码
//                String receiveInCode = new String();
//                if (mapObject.get("receiveInCode") != null) {
//                    receiveInCode = mapObject.get("receiveInCode").toString().trim();
//                }

            }

        }

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
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");
            for (Map<String, Object> mapObject : varList) {
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);

                //qualityType 检验方式id (1:全检 2:抽检)
                String qualityType = "1";
                if (mapObject.get("qualityType") != null && mapObject.get("qualityType").toString().trim().length() > 0) {
                    qualityType = mapObject.get("qualityType").toString().trim();
                }

                //qualityTypeName 检验方式id (1:全检 2:抽检)
                String qualityTypeName = "全检";
                if (mapObject.get("qualityTypeName") != null && mapObject.get("qualityTypeName").toString().trim().length() > 0) {
                    qualityTypeName = mapObject.get("qualityTypeName").toString().trim();
                }
                mapObject.put("qualityTypeName", qualityTypeName);

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
    public ResultModel purchaseSignDetailByQualityExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //获取基本参数 数据非空验证
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String jsonStr = pageData.getString("jsonStr");
        if (jsonStr == null || jsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一行数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
        if(jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收明细执行 Json字符串-转换成List错误！");
            return model;
        }

        //创建(复杂版,简版)仓库-入库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        //修改采购签收////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String orderDtlIds = new String();
        String orderId = new String();
        String supplierId = new String();
        String supplierName = new String();

        List<PurchaseSignDetail> signDetailList = new ArrayList<>();
        for (Map<String, String> objectMap : jsonMapList) {
            PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

            supplierId = objectMap.get("supplierId");
            supplierName = objectMap.get("supplierName");

            //采购订单id
            orderId = objectMap.get("orderId");
            //采购订单明细id
            String orderDtlId = objectMap.get("orderDtlId");
            orderDtlIds = orderDtlIds + orderDtlId + ",";
            editSignDetail.setOrderDetailId(orderDtlId);

            //id 采购签收明细id
            String id = objectMap.get("id");
            editSignDetail.setId(id);

            //qualityType 检验方式 (1:全检 2:抽检)
            String qualityType = objectMap.get("qualityType");
            editSignDetail.setQualityType(qualityType);

            //签收数量 arriveCount
            BigDecimal arriveCount = BigDecimal.valueOf(0D);
            String arriveCountStr = objectMap.get("arriveCount");
            if (arriveCountStr != null && arriveCountStr.trim().length() > 0) {
                try {
                    arriveCount = new BigDecimal(arriveCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            arriveCount = arriveCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setArriveCount(arriveCount);

            //qualityCount (实际)检验数量
            BigDecimal qualityCount = BigDecimal.valueOf(0D);
            String qualityCountStr = objectMap.get("qualityCount");
            if (qualityCountStr != null && qualityCountStr.trim().length() > 0) {
                try {
                    qualityCount = new BigDecimal(qualityCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            qualityCount = qualityCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setQualityCount(qualityCount);

            //badCount (检验)不合格数量
            BigDecimal badCount = BigDecimal.valueOf(0D);
            String badCountStr = objectMap.get("badCount");
            if (badCountStr != null && badCountStr.trim().length() > 0) {
                try {
                    badCount = new BigDecimal(badCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            badCount = badCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setBadCount(badCount);

            //retreatCount (检验)退货数量
            BigDecimal retreatCount = BigDecimal.valueOf(0D);
            String retreatCountStr = objectMap.get("retreatCount");
            if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
                try {
                    retreatCount = new BigDecimal(retreatCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            retreatCount = retreatCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setRetreatCount(retreatCount);

            //receiveCount (检验)让步接收数量
            BigDecimal receiveCount = BigDecimal.valueOf(0D);
            String receiveCountStr = objectMap.get("receiveCount");
            if (receiveCountStr != null && receiveCountStr.trim().length() > 0) {
                try {
                    receiveCount = new BigDecimal(receiveCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            receiveCount = receiveCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setReceiveCount(receiveCount);

            //状态(1:检验中 2:已完成 -1:已取消)
            editSignDetail.setState("2");
            signDetailList.add(editSignDetail);

            //qualityCount (实际)检验数量
            qualityCount = editSignDetail.getQualityCount();

            //签收数量 arriveCount
            arriveCount = editSignDetail.getArriveCount();
            //(检验)退货数量 retreatCount
            retreatCount = editSignDetail.getRetreatCount();

            //signFineCount 收货合格数(签收数:检验数量-退货数)
            BigDecimal signFineCount = BigDecimal.valueOf(0D);
            //qualityFineCount (实际)检验合格数 (检验数量 - 不合格数量)
            BigDecimal qualityFineCount = BigDecimal.valueOf(0D);

            //qualityType 检验方式 (1:全检 2:抽检)
            if ("1".equals(qualityType)) {
                //1:全检:收货合格数 := 检验数量-退货数
                BigDecimal tempBig = BigDecimal.valueOf(qualityCount.doubleValue() - retreatCount.doubleValue());
                if (tempBig.doubleValue() >= 0) {
                    signFineCount = tempBig;
                }

                //1:全检:(实际)检验合格数 := 检验数量 - 不合格数量
                tempBig = BigDecimal.valueOf(qualityCount.doubleValue() - badCount.doubleValue());
                if (tempBig.doubleValue() >= 0) {
                    qualityFineCount = tempBig;
                }
            } else if ("2".equals(qualityType) && qualityCount.doubleValue() != 0) {
                //2:抽检:收货合格数 := (签收数量/检验数量) * (检验数量 - 退货数量)
                //ratio 签收数量/检验数量
                BigDecimal ratio = BigDecimal.valueOf(arriveCount.doubleValue() / qualityCount.doubleValue());
                BigDecimal tempBig = BigDecimal.valueOf(ratio.doubleValue() * (qualityCount.doubleValue() - retreatCount.doubleValue()) );
                if (tempBig.doubleValue() >= 0) {
                    signFineCount = tempBig;
                }

                //2:抽检:(实际)检验合格数 := (签收数量/检验数量) * (检验数量 - 不合格数量)
                tempBig = BigDecimal.valueOf(ratio.doubleValue() * (qualityCount.doubleValue() - badCount.doubleValue()) );
                if (tempBig.doubleValue() >= 0) {
                    qualityFineCount = tempBig;
                }
            }
            //四舍五入到2位小数
            signFineCount = signFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setSignFineCount(signFineCount);

            //四舍五入到2位小数
            qualityFineCount = qualityFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setQualityFineCount(qualityFineCount);

            //添加采购退货单
            if (retreatCount != null && retreatCount.doubleValue() != 0) {
                String retreatDtlId = retreatService.createRetreatByQuality(cuser, companyId, objectMap);
                editSignDetail.setRetreatDtlId(retreatDtlId);
            }

            this.update(editSignDetail);

            //price 单价(采购订单明细)
            BigDecimal price = BigDecimal.valueOf(0D);
            String priceStr = objectMap.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //amount 签收金额 = 收货合格数(signFineCount) * 单价(采购订单明细)
            BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * signFineCount.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //生成采购付款单(vmes_finance_bill)
            //采购签收单号
            String signCode = objectMap.get("signCode");
            purchaseByFinanceBillService.addFinanceBillByPurchase(editSignDetail.getId(),
                    companyId,
                    supplierId,
                    cuser,
                    //type单据类型(0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购))
                    "6",
                    //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                    "2",
                    null,
                    amount,
                    signCode);

            //采购签收单id
            String parentId = objectMap.get("parentId");
            if (parentId != null && parentId.trim().length() > 0) {
                List<PurchaseSignDetail> signDtlList = this.findSignDetailListByParentId(parentId);

                //获取签收单状态-根据签收单明细
                if (signDtlList != null && signDtlList.size() > 0) {
                    PurchaseSign editSign = new PurchaseSign();
                    editSign.setId(parentId);

                    String parentState = this.findParentStateByDetailList(signDtlList);
                    editSign.setState(parentState);
                    signService.update(editSign);
                }
            }

            //添加(vmes_purchase_quality_detail:采购质检项明细)
            Object childObj = objectMap.get("children");
            List childList = (List)childObj;
            if (childList != null && childList.size() > 0) {
                for (int i = 0; i < childList.size(); i++) {
                    Map<String, String> childMap = (Map<String, String>)childList.get(i);
                    PurchaseQualityDetail addQualityDtl = (PurchaseQualityDetail)HttpUtils.pageData2Entity(childMap, new PurchaseQualityDetail());
                    qualityDetailService.save(addQualityDtl);
                }
            }
        }

        //修改采购订单////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据(采购订单明细id) 查询
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //SQL语句: PurchaseOrderDetailCollectMapper.findPurchaseOrderDetailCollect
            PageData findMap = new PageData();
            findMap.put("detailIds", detailIds);
            orderDetailMap = orderDetailToolService.findPurchaseOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 采购计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDetailList != null && signDetailList.size() > 0) {
            for (PurchaseSignDetail signDetail : signDetailList) {
                PurchaseOrderDetail editOrderDtl = new PurchaseOrderDetail();

                //orderDetailId 采购订单明细ID
                String orderDetailId = signDetail.getOrderDetailId();
                editOrderDtl.setId(orderDetailId);

                Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
                //detailCount 采购数量
                BigDecimal detailCount = BigDecimal.valueOf(0D);
                if (valueMap.get("detailCount") != null) {
                    detailCount = (BigDecimal)valueMap.get("detailCount");
                }

//                //arriveCount 签收数量:= (已完成)签收数量 - (已完成)退货数量
//                BigDecimal arriveCount = BigDecimal.valueOf(0D);
//                if (valueMap.get("arriveCount") != null) {
//                    arriveCount = (BigDecimal)valueMap.get("arriveCount");
//                }

                //signFineCount 收货合格数(签收数-(检验)退货数)
                BigDecimal signFineCount = BigDecimal.valueOf(0D);
                if (valueMap.get("signFineCount") != null) {
                    signFineCount = (BigDecimal)valueMap.get("signFineCount");
                }

                //采购单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收(无此状态) 4:已完成 -1:已取消)
                if (signFineCount.doubleValue() >= detailCount.doubleValue()) {
                    editOrderDtl.setState("4");
                    orderDetailService.update(editOrderDtl);

                    //planDtlId 采购计划明细id
                    String planDtlId = (String)valueMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        PurchasePlanDetail editPlanDtl = new PurchasePlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //采购计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        planDetailService.update(editPlanDtl);
                    }
                }

                //planId 采购计划id
                if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                    String planId = (String)valueMap.get("planId");
                    planIdMap.put(planId.trim(), planId.trim());
                }
            }
        }

        //反写采购订单状态
        orderService.updateState(orderId);
        //反写 (采购计划明细,采购计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    planService.updateState(planId);
                }
            }
        }

        //生成(正常接收Map, 让步接收Map) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //正常接收Map
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();
        //让步接收Map
        Map<String, Map<String, Object>> businessByReceiveInMap = new HashMap<>();

        for (Map<String, String> objectMap : jsonMapList) {
            //采购签收明细id
            String signDtlId = objectMap.get("id");
            //货品id
            String productId = objectMap.get("productId");

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

            ////////////////////////////////////////////////////////////////////////////////////////////
            //qualityCount (实际)检验数量
            BigDecimal qualityCount = BigDecimal.valueOf(0D);
            String qualityCountStr = objectMap.get("qualityCount");
            if (qualityCountStr != null && qualityCountStr.trim().length() > 0) {
                try {
                    qualityCount = new BigDecimal(qualityCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            qualityCount = qualityCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //badCount (检验)不合格数量
            BigDecimal badCount = BigDecimal.valueOf(0D);
            String badCountStr = objectMap.get("badCount");
            if (badCountStr != null && badCountStr.trim().length() > 0) {
                try {
                    badCount = new BigDecimal(badCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            badCount = badCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //receiveCount (检验)让步接收数量
            BigDecimal receiveCount = BigDecimal.valueOf(0D);
            String receiveCountStr = objectMap.get("receiveCount");
            if (receiveCountStr != null && receiveCountStr.trim().length() > 0) {
                try {
                    receiveCount = new BigDecimal(receiveCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            receiveCount = receiveCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            ////////////////////////////////////////////////////////////////////////////////////////////
            //正常接收数量 := (实际)检验数量 - (检验)不合格数量
            BigDecimal inCount = BigDecimal.valueOf(qualityCount.doubleValue() - badCount.doubleValue());
            //四舍五入到2位小数
            inCount = inCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //(计量单位)正常接收数量 -> 单位换算公式(p2nFormula)
            BigDecimal p2n_inCount = EvaluateUtil.countFormulaP2N(inCount, p2nFormula);
            p2n_inCount = StringUtil.scaleDecimal(p2n_inCount, p2nIsScale, p2nDecimalCount);

            if (p2n_inCount != null && p2n_inCount.doubleValue() > 0) {
                //Map<String, Map<String, Object>> businessByInMap
                Map<String, Object> inValueMap = new HashMap<>();

                //productId: 货品id
                inValueMap.put("productId", productId);
                //inDtlId:   入库明细id
                inValueMap.put("inDtlId", null);
                //inCount:   入库数量
                inValueMap.put("inCount", p2n_inCount);

                businessByInMap.put(signDtlId, inValueMap);
            }

            //让步接收数量 : (检验)让步接收数量
            BigDecimal receiveInCount = receiveCount;
            //(计量单位)让步接收数量 -> 单位换算公式(p2nFormula)
            BigDecimal p2n_receiveInCount = EvaluateUtil.countFormulaP2N(receiveInCount, p2nFormula);
            p2n_receiveInCount = StringUtil.scaleDecimal(p2n_receiveInCount, p2nIsScale, p2nDecimalCount);
            if (p2n_receiveInCount != null && p2n_receiveInCount.doubleValue() > 0) {
                Map<String, Object> inValueMap = new HashMap<>();

                //productId: 货品id
                inValueMap.put("productId", productId);
                //inDtlId:   入库明细id
                inValueMap.put("inDtlId", null);
                //inCount:   入库数量
                inValueMap.put("inCount", p2n_receiveInCount);

                businessByReceiveInMap.put(signDtlId, inValueMap);
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //正常接收入库(正常接收Map businessByInMap)
        if (businessByInMap != null && businessByInMap.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    null,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");

                    //qualityInDtlId (检验入库)入库单明细id
                    editSignDetail.setQualityInDtlId(inDtlId);

                    this.update(editSignDetail);
                }
            }

        } else if (businessByInMap != null && businessByInMap.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    null,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId = (String)iterator.next();
                    editSignDetail.setId(signDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //qualityInDtlId (检验入库)入库单明细id
                    editSignDetail.setQualityInDtlId(inDtlId);

                    this.update(editSignDetail);
                }
            }
        }

        //让步接收入库///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //让步接收入库(让步接收Map businessByReceiveInMap)
        if (businessByReceiveInMap != null && businessByReceiveInMap.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    "让步接收",
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                //signDtlId 采购签收id
                String signDtlId = (String)iterator.next();
                editSignDetail.setId(signDtlId);

                Map<String, Object> mapValue = businessByReceiveInMap.get(signDtlId);
                //inDtlId:   入库明细id
                String inDtlId = (String)mapValue.get("inDtlId");

                //receiveInDtlId (检验让步接收入库)入库单明细id
                editSignDetail.setReceiveInDtlId(inDtlId);

                this.update(editSignDetail);
            }

        } else if (businessByReceiveInMap != null && businessByReceiveInMap.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    "让步接收",
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                PurchaseSignDetail editSignDetail = new PurchaseSignDetail();

                //signDtlId 采购签收id
                String signDtlId = (String)iterator.next();
                editSignDetail.setId(signDtlId);

                Map<String, Object> mapValue = businessByReceiveInMap.get(signDtlId);
                //inDtlId:   入库明细id
                String inDtlId = (String)mapValue.get("inDtlId");

                //receiveInDtlId (检验让步接收入库)入库单明细id
                editSignDetail.setReceiveInDtlId(inDtlId);

                this.update(editSignDetail);
            }
        }

        return model;
    }

    //采购签收明细-免检
    public ResultModel updateSignDetailByQuality(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String signDtlId = pageData.getString("signDtlId");
        if (signDtlId == null || signDtlId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购签收明细id为空或空字符串！");
            return model;
        }

        //获取基本参数 数据非空验证
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //创建(复杂版,简版)仓库-入库单-需要的参数///////////////////////////////////////////////////////////////////////////////////
        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据(采购签收明细id) 查询
        //SQL语句: PurchaseSignDetailMapper.getDataListPage
        PageData findMap = new PageData();
        findMap.put("signDtlId", signDtlId);
        List<Map> mapList = this.getDataListPage(findMap, null);

        Map<String, Object> signDetailMap = new HashMap<>();
        if (mapList != null && mapList.size() > 0) {
            signDetailMap = mapList.get(0);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改采购签收
        PurchaseSignDetail editSignDetail = new PurchaseSignDetail();
        editSignDetail.setId(signDtlId);
        //quality:质检属性 (1:免检 2:检验)
        editSignDetail.setQuality("1");
        //qualityType 检验方式 (1:全检 2:抽检)
        editSignDetail.setQualityType(null);
        //状态(1:检验中 2:已完成 -1:已取消)
        editSignDetail.setState("2");

        //qualityCount (实际)检验数量
        editSignDetail.setQualityCount(BigDecimal.valueOf(0D));
        //badCount (检验)不合格数量
        editSignDetail.setBadCount(BigDecimal.valueOf(0D));
        //retreatCount (检验)退货数量
        editSignDetail.setRetreatCount(BigDecimal.valueOf(0D));
        //receiveCount (检验)让步接收数量
        editSignDetail.setReceiveCount(BigDecimal.valueOf(0D));

        //arriveCount 签收数量
        BigDecimal arriveCountDB = BigDecimal.valueOf(0D);
        if (signDetailMap.get("arriveCount") != null) {
            arriveCountDB = (BigDecimal)signDetailMap.get("arriveCount");
        }
        //signFineCount 收货合格数(签收数)
        editSignDetail.setSignFineCount(arriveCountDB);
        //qualityFineCount (实际)检验合格数
        editSignDetail.setQualityFineCount(arriveCountDB);

        BigDecimal price = BigDecimal.valueOf(0D);
        if (signDetailMap.get("price") != null) {
            price = (BigDecimal)signDetailMap.get("price");
        }

        //amount 签收金额 = 签收数量 * 单价(采购订单明细)
        BigDecimal amount = BigDecimal.valueOf(0D);
        amount = BigDecimal.valueOf(price.doubleValue() * arriveCountDB.doubleValue());
        //四舍五入到2位小数
        amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        this.update(editSignDetail);

        //采购签收单id
        String parentId = (String)signDetailMap.get("parentId");
        if (parentId != null && parentId.trim().length() > 0) {
            List<PurchaseSignDetail> signDtlList = this.findSignDetailListByParentId(parentId);

            //获取签收单状态-根据签收单明细
            if (signDtlList != null && signDtlList.size() > 0) {
                PurchaseSign editSign = new PurchaseSign();
                editSign.setId(parentId);

                String parentState = this.findParentStateByDetailList(signDtlList);
                editSign.setState(parentState);
                signService.update(editSign);
            }
        }

        String supplierId = (String)signDetailMap.get("supplierId");

        //生成采购(vmes_finance_bill)付款单
        String signCode = (String)signDetailMap.get("signCode");
        purchaseByFinanceBillService.addFinanceBillByPurchase(editSignDetail.getId(),
                companyId,
                supplierId,
                cuser,
                //type单据类型(0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购))
                "6",
                //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                "2",
                null,
                amount,
                signCode);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改采购订单
        //根据(采购订单明细id) 查询
        String orderDtlIds = (String)signDetailMap.get("orderDetailId");
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //SQL语句: PurchaseOrderDetailCollectMapper.findPurchaseOrderDetailCollect
            findMap = new PageData();
            findMap.put("detailIds", detailIds);
            orderDetailMap = orderDetailToolService.findPurchaseOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 采购计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDetailMap != null && signDetailMap.size() > 0) {
            PurchaseOrderDetail editOrderDtl = new PurchaseOrderDetail();

            //orderDetailId 采购订单明细ID
            String orderDetailId = (String)signDetailMap.get("orderDetailId");
            editOrderDtl.setId(orderDetailId);

            Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
            //detailCount 采购数量
            BigDecimal detailCount = BigDecimal.valueOf(0D);
            if (valueMap.get("detailCount") != null) {
                detailCount = (BigDecimal)valueMap.get("detailCount");
            }

//            //arriveCount 签收数量:= (已完成)签收数量 - (已完成)退货数量
//            BigDecimal arriveCount = BigDecimal.valueOf(0D);
//            if (valueMap.get("arriveCount") != null) {
//                arriveCount = (BigDecimal)valueMap.get("arriveCount");
//            }

            //signFineCount 收货合格数(签收数-(检验)退货数)
            BigDecimal signFineCount = BigDecimal.valueOf(0D);
            if (valueMap.get("signFineCount") != null) {
                signFineCount = (BigDecimal)valueMap.get("signFineCount");
            }

            //采购单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
            if (signFineCount.doubleValue() >= detailCount.doubleValue()) {
                editOrderDtl.setState("4");
                orderDetailService.update(editOrderDtl);

                //planDtlId 采购计划明细id
                String planDtlId = (String)valueMap.get("planDtlId");
                if (planDtlId != null && planDtlId.trim().length() > 0) {
                    PurchasePlanDetail editPlanDtl = new PurchasePlanDetail();
                    editPlanDtl.setId(planDtlId);
                    //采购计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                    editPlanDtl.setState("4");
                    planDetailService.update(editPlanDtl);
                }
            }

            //planId 采购计划id
            if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                String planId = (String)valueMap.get("planId");
                planIdMap.put(planId.trim(), planId.trim());
            }
        }

        //反写采购订单状态
        String orderId = (String)signDetailMap.get("orderId");
        orderService.updateState(orderId);
        //反写 (采购计划明细,采购计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    planService.updateState(planId);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();

        //货品id
        String productId = (String)signDetailMap.get("productId");

        //p2nFormula 单位换算公式:计价单位转换计量单位:
        String p2nFormula = new String();
        if (signDetailMap.get("p2nFormula") != null) {
            p2nFormula = signDetailMap.get("p2nFormula").toString().trim();
        }

        //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
        String p2nIsScale = new String();
        if (signDetailMap.get("p2nIsScale") != null) {
            p2nIsScale = signDetailMap.get("p2nIsScale").toString().trim();
        }

        //小数位数 (最小:0位 最大:4位)
        Integer p2nDecimalCount = Integer.valueOf(2);
        if (signDetailMap.get("p2nDecimalCount") != null) {
            p2nDecimalCount = (Integer)signDetailMap.get("p2nDecimalCount");
        }

        //签收数量
        BigDecimal arriveCount = BigDecimal.valueOf(0D);
        if (signDetailMap.get("arriveCount") != null) {
            arriveCount = (BigDecimal)signDetailMap.get("arriveCount");
        }

        //(计量单位)签收数量 -> 单位换算公式(p2nFormula)
        BigDecimal p2n_arriveCount = EvaluateUtil.countFormulaP2N(arriveCount, p2nFormula);
        p2n_arriveCount = StringUtil.scaleDecimal(p2n_arriveCount, p2nIsScale, p2nDecimalCount);

        if (arriveCount != null && arriveCount.doubleValue() > 0) {
            Map<String, Object> inValueMap = new HashMap<>();

            //productId: 货品id
            inValueMap.put("productId", productId);
            //inDtlId:   入库明细id
            inValueMap.put("inDtlId", null);
            //inCount:   入库数量
            inValueMap.put("inCount", p2n_arriveCount);

            businessByInMap.put(signDtlId, inValueMap);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        supplierId = (String)signDetailMap.get("supplierId");
        String supplierName = (String)signDetailMap.get("supplierName");

        //正常接收入库(正常接收Map businessByInMap)
        if (businessByInMap != null && businessByInMap.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    null,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDtl = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId_key = (String)iterator.next();
                    editSignDtl.setId(signDtlId_key);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //inDetailId (签收入库)入库单明细id
                    editSignDtl.setInDetailId(inDtlId);

                    this.update(editSignDtl);
                }
            }
        } else if (businessByInMap != null && businessByInMap.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //d78ceba5beef41f5be16f0ceee775399 采购入库:purchaseIn
                    Common.DICTIONARY_MAP.get("purchaseIn"),
                    null,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    PurchaseSignDetail editSignDtl = new PurchaseSignDetail();

                    //signDtlId 采购签收id
                    String signDtlId_key = (String)iterator.next();
                    editSignDtl.setId(signDtlId_key);

                    Map<String, Object> mapValue = businessByInMap.get(signDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //inDetailId (签收入库)入库单明细id
                    editSignDtl.setInDetailId(inDtlId);

                    this.update(editSignDtl);
                }
            }
        }

        return model;
    }

}



