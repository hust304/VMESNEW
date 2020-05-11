package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistRetreatDetailMapper;
import com.xy.vmes.entity.AssistRetreat;
import com.xy.vmes.entity.AssistRetreatDetail;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_assist_retreat_detail:外协退货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-05-07
*/
@Service
@Transactional(readOnly = false)
public class AssistRetreatDetailServiceImp implements AssistRetreatDetailService {
    @Autowired
    private AssistRetreatDetailMapper assistRetreatDetailMapper;

    @Autowired
    private AssistRetreatService retreatService;
    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistRetreatDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistRetreatDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistRetreatDetail selectById(String id) throws Exception{
        return assistRetreatDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistRetreatDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistRetreatDetail> warehouseCheckDetailList = assistRetreatDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        assistRetreatDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        assistRetreatDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistRetreatDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistRetreatDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistRetreatDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistRetreatDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistRetreatDetail> dataList(PageData pd) throws Exception{
        return assistRetreatDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistRetreatDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistRetreatDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistRetreatDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistRetreatDetail findAssistRetreatDetail(PageData object) throws Exception {
        List<AssistRetreatDetail> objectList = this.findAssistRetreatDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistRetreatDetail findAssistRetreatDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistRetreatDetail(findMap);
    }

    public List<AssistRetreatDetail> findAssistRetreatDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistRetreatDetail> findAssistRetreatDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findAssistRetreatDetailList(findMap);
    }

    public BigDecimal findTotalAmount(List<AssistRetreatDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        BigDecimal totalAmount = BigDecimal.valueOf(0D);
        for (AssistRetreatDetail detail : objectList) {

            //amount:金额
            if (detail.getAmount() != null) {
                totalAmount = BigDecimal.valueOf(totalAmount.doubleValue() + detail.getAmount().doubleValue());
            }
        }

        //四舍五入到2位小数
        return totalAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获取外协退货单状态-根据退货单明细状态
     * 外协退货单状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
     * 外协退货单明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
     *
     * @param detailList      外协退货单明细List<AssistSignDetail>
     * @return
     */
    public String findParentStateByDetailList(List<AssistRetreatDetail> detailList) {
        if (detailList == null || detailList.size() == 0) {return null;}

        //外协退货单状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        int dtl_dtj = 0;  //0:待提交
        int dtl_dsh = 0;  //1:待审核
        int dtl_dth = 0;  //2:待退货
        int dtl_ywc = 0;  //3:已完成
        int dtl_yqx = 0;  //-1:已取消
        //由各自业务更改--(0:待提交 1:待审核 2:待退货 -1:已取消 )

        //明细变更状态(3:已完成 -1:已取消)
        for (AssistRetreatDetail dtlObject : detailList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dtj = dtl_dtj + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_dsh = dtl_dsh + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_dth = dtl_dth + 1;
            } else if ("3".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //外协退货单明细状态:-1:已取消 全是已取消状态  订单状态:-1:已取消
        if (dtl_yqx > 0 && dtl_yqx == detailList.size()) {
            return "-1";

            //外协退货单明细状态:3:已完成 全是已完成  退货单状态:3:已完成
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dtj == 0 && dtl_dsh == 0 && dtl_dth == 0)
        ) {
            return "3";
        }

        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        assistRetreatDetailMapper.updateStateByDetail(pageData);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //供应商原材料退回-免检
    public ResultModel updateAssistRetreatDetailByProductQuality(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String retreatDtlId = pageData.getString("retreatDtlId");
        if (retreatDtlId == null || retreatDtlId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协退货明细id为空或空字符串！");
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
        //根据(外协退货明细id-供应商退回) 查询
        //SQL语句: AssistRetreatDetailMapper.getDataListPage
        PageData findMap = new PageData();
        findMap.put("retreatDtlId", retreatDtlId);
        List<Map> mapList = this.getDataListPage(findMap, null);

        Map<String, Object> retreatDetailMap = new HashMap<>();
        if (mapList != null && mapList.size() > 0) {
            retreatDetailMap = mapList.get(0);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改外协退货
        AssistRetreatDetail editRetreatDetail = new AssistRetreatDetail();
        editRetreatDetail.setId(retreatDtlId);
        //quality:质检属性 (1:免检 2:检验)
        editRetreatDetail.setQuality("1");
        //qualityType 检验方式 (1:全检 2:抽检)
        editRetreatDetail.setQualityType(null);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreatDetail.setState("2");

        //qualityCount (实际)检验数量
        editRetreatDetail.setQualityCount(BigDecimal.valueOf(0D));
        //badCount (检验)不合格数量
        editRetreatDetail.setBadCount(BigDecimal.valueOf(0D));
        //discardCount (检验)报废数量
        editRetreatDetail.setDiscardCount(BigDecimal.valueOf(0D));
        //receiveCount (检验)让步接收数量
        editRetreatDetail.setReceiveCount(BigDecimal.valueOf(0D));

        //orderCount 退货数量(供应商退回数量)
        BigDecimal orderCountDB = BigDecimal.valueOf(0D);
        if (retreatDetailMap.get("orderCount") != null) {
            orderCountDB = (BigDecimal)retreatDetailMap.get("orderCount");
        }
        //signFineCount 收货合格数(签收数)
        editRetreatDetail.setSignFineCount(orderCountDB);
        //qualityFineCount (实际)检验合格数
        editRetreatDetail.setQualityFineCount(orderCountDB);

//        BigDecimal price = BigDecimal.valueOf(0D);
//        if (signDetailMap.get("price") != null) {
//            price = (BigDecimal)signDetailMap.get("price");
//        }

        //amount 签收金额 = 签收数量 * 单价(外协订单明细)
        //BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * arriveCountDB.doubleValue());
        //四舍五入到2位小数
        //amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        this.update(editRetreatDetail);

        //外协签收单id
        String parentId = (String)retreatDetailMap.get("parentId");
        if (parentId != null && parentId.trim().length() > 0) {
            List<AssistRetreatDetail> retreatDtlList = this.findAssistRetreatDetailListByParentId(parentId);

            //获取外协退货单状态-根据外协退货明细
            if (retreatDtlList != null && retreatDtlList.size() > 0) {
                AssistRetreat editRetreat = new AssistRetreat();
                editRetreat.setId(parentId);

                String parentState = this.findParentStateByDetailList(retreatDtlList);
                editRetreat.setState(parentState);
                retreatService.update(editRetreat);
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //修改外协订单
//        //根据(外协订单明细id) 查询
//        String orderDtlIds = (String)retreatDetailMap.get("orderDetailId");
//        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
//        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
//            String detailIds = orderDtlIds.trim();
//            detailIds = StringUtil.stringTrimSpace(detailIds);
//            detailIds = "'" + detailIds.replace(",", "','") + "'";
//
//            //查询SQL:AssistOrderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign
//            findMap = new PageData();
//            findMap.put("orderDtlIds", detailIds);
//            orderDetailMap = orderDetailService.findCheckAssistOrderDetailMap(findMap);
//        }
//
//        //遍历当前签收明细List
//        //planId 外协计划id
//        Map<String, String> planIdMap = new HashMap<>();
//        if (retreatDetailMap != null && retreatDetailMap.size() > 0) {
//            AssistOrderDetail editOrderDtl = new AssistOrderDetail();
//
//            //orderDetailId 外协订单明细ID
//            String orderDetailId = (String)retreatDetailMap.get("orderDetailId");
//            editOrderDtl.setId(orderDetailId);
//
//            Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
//            if (valueMap != null) {
//                //orderCount 订单数量
//                BigDecimal orderCount = BigDecimal.valueOf(0D);
//                if (valueMap.get("orderCount") != null) {
//                    orderCount = (BigDecimal)valueMap.get("orderCount");
//                }
//
//                //signFineCount 收货合格数(签收数-(检验)退货数)
//                BigDecimal signFineCount = BigDecimal.valueOf(0D);
//                if (valueMap.get("signFineCount") != null) {
//                    signFineCount = (BigDecimal)valueMap.get("signFineCount");
//                }
//
//                //外协单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
//                if (signFineCount.doubleValue() >= orderCount.doubleValue()) {
//                    editOrderDtl.setState("4");
//                    orderDetailService.update(editOrderDtl);
//
//                    //planDtlId 外协计划明细id
//                    String planDtlId = (String)valueMap.get("planDtlId");
//                    if (planDtlId != null && planDtlId.trim().length() > 0) {
//                        AssistPlanDetail editPlanDtl = new AssistPlanDetail();
//                        editPlanDtl.setId(planDtlId);
//                        //外协计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
//                        editPlanDtl.setState("4");
//                        planDetailService.update(editPlanDtl);
//                    }
//
//                    //planId 外协计划id
//                    if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
//                        String planId = (String)valueMap.get("planId");
//                        planIdMap.put(planId.trim(), planId.trim());
//                    }
//                }
//            }
//        }
//
//        //反写外协订单状态
//        String orderId = (String)retreatDetailMap.get("orderId");
//        AssistOrder editOrder = new AssistOrder();
//        editOrder.setId(orderId);
//        orderDetailService.updateParentStateByDetailList(editOrder, null);
//        //反写 (外协计划明细,外协计划)状态
//        if (planIdMap != null) {
//            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
//                String planId = (String)iterator.next();
//                if (planId != null && planId.trim().length() > 0) {
//                    //planService.updateState(planId);
//                    AssistPlan editPlan = new AssistPlan();
//                    editPlan.setId(planId);
//                    planDetailService.updateParentStateByDetailList(editPlan, null);
//                }
//            }
//        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();

        //货品id
        String productId = (String)retreatDetailMap.get("productId");

        //orderCount:退货数量
        BigDecimal orderCount = BigDecimal.valueOf(0D);
        if (retreatDetailMap.get("orderCount") != null) {
            orderCount = (BigDecimal)retreatDetailMap.get("orderCount");
        }

//        //(计量单位)签收数量 -> 单位换算公式(p2nFormula)
//        BigDecimal p2n_arriveCount = EvaluateUtil.countFormulaP2N(arriveCount, p2nFormula);
//        p2n_arriveCount = StringUtil.scaleDecimal(p2n_arriveCount, p2nIsScale, p2nDecimalCount);

        if (orderCount != null && orderCount.doubleValue() > 0) {
            Map<String, Object> inValueMap = new HashMap<>();

            //productId: 货品id
            inValueMap.put("productId", productId);
            //inDtlId:   入库明细id
            inValueMap.put("inDtlId", null);
            //inCount:   入库数量
            inValueMap.put("inCount", orderCount);

            businessByInMap.put(retreatDtlId, inValueMap);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        String retreatCode = (String)retreatDetailMap.get("retreatCode");
        String supplierId = (String)retreatDetailMap.get("supplierId");
        String supplierName = (String)retreatDetailMap.get("supplierName");

        //正常接收入库(正常接收Map businessByInMap)
        if (businessByInMap != null && businessByInMap.size() > 0 && Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
            //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
            warehouseInCreateService.createWarehouseInBusinessByComplex(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    retreatCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistRetreatDetail editRetreatDtl = new AssistRetreatDetail();

                    //retreatDtlId 外协退货明细id
                    String retreatDtlId_key = (String)iterator.next();
                    editRetreatDtl.setId(retreatDtlId_key);

                    Map<String, Object> mapValue = businessByInMap.get(retreatDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //qualityInDtlId (检验入库)入库单明细id
                    editRetreatDtl.setQualityInDtlId(inDtlId);

                    this.update(editRetreatDtl);
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    retreatCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistRetreatDetail editRetreatDtl = new AssistRetreatDetail();

                    //retreatDtlId 外协退货明细id
                    String signDtlId_key = (String)iterator.next();
                    editRetreatDtl.setId(signDtlId_key);

                    Map<String, Object> mapValue = businessByInMap.get(retreatDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //qualityInDtlId (检验入库)入库单明细id
                    editRetreatDtl.setQualityInDtlId(inDtlId);

                    this.update(editRetreatDtl);
                }
            }
        }

        return model;
    }

    //供应商原材料退回-检验执行
    //ResultModel assistRetreatDetailByProductQualityExecute(PageData pageData) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistRetreatDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistRetreatDetail");
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

            for (Map<String, Object> mapObject : varList) {
                String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                mapObject.put("prodInfo", prodInfo);
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



