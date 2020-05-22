package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistRetreatDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
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
    private AssistOrderService assistOrderService;
    @Autowired
    private AssistOrderDetailService assistOrderDetailService;
    @Autowired
    private AssistOrderDetailChildService assistOrderChildService;
    @Autowired
    private AssistPlanDetailService planDetailService;

    @Autowired
    private AssistRetreatService retreatService;
    @Autowired
    private AssistDiscardService assistDiscardService;
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

    /**
     * 返回货品出库Map
     * 业务货品出库Map<业务单id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param objectList
     * @return
     */
    public Map<String, Map<String, Object>> findProductBusinessMapByOut(List<AssistRetreatDetail> objectList) {
        Map<String, Map<String, Object>> prodBusinessByOutMap = new HashMap<>();
        if (objectList == null || objectList.size() == 0) {return prodBusinessByOutMap;}

        for (AssistRetreatDetail dtlObject : objectList) {
            //id:销售订单明细id
            String id = dtlObject.getId();
            String productId = dtlObject.getProductId();

            //orderCount:退货数量(订单单位) := outCount 出库数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (dtlObject.getOrderCount() != null) {
                orderCount = dtlObject.getOrderCount();
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("outDtlId", null);
            productMap.put("outCount", orderCount);

            prodBusinessByOutMap.put(id, productMap);
        }

        return prodBusinessByOutMap;
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
                if (parentState != null && parentState.trim().length() > 0) {
                    editRetreat.setState(parentState);
                    retreatService.update(editRetreat);
                }
            }
        }

        //修改外协订单////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
        //查询SQL:AssistOrderDetailChildMapper.findCheckAssistOrderChild
        String orderId = pageData.getString("orderId");
        List<Map<String, Object>> orderChildList = assistOrderChildService.findCheckAssistOrderChild(orderId);
        String finishOrderId = assistOrderChildService.finishOrderByAssistOrderChild(orderChildList);

        if (finishOrderId != null && finishOrderId.trim().length() > 0) {
            AssistOrder editOrder = new AssistOrder();
            editOrder.setId(finishOrderId);
            //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
            editOrder.setState("4");
            assistOrderService.update(editOrder);

            //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
            assistOrderDetailService.updateStateByDetail("4", finishOrderId);

            Map<String, String> planMap = new HashMap<>();
            Map<String, String> planDtlMap = new HashMap<>();
            if (orderChildList != null && orderChildList.size() > 0) {
                for (Map<String, Object> objectMap : orderChildList) {
                    //planId 外协计划id
                    String planId = (String)objectMap.get("planId");
                    if (planId != null && planId.trim().length() > 0) {
                        planMap.put(planId, planId);
                    }

                    //planDtlId 外协计划明细id
                    String planDtlId = (String)objectMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        planDtlMap.put(planDtlId, planDtlId);
                    }
                }
            }

            //外协计划明细
            if (planDtlMap != null) {
                for (Iterator iterator = planDtlMap.keySet().iterator(); iterator.hasNext();) {
                    String planDtlId = (String)iterator.next();
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        planDetailService.update(editPlanDtl);
                    }
                }
            }

            if (planMap != null) {
                for (Iterator iterator = planMap.keySet().iterator(); iterator.hasNext();) {
                    String planId = (String)iterator.next();
                    if (planId != null && planId.trim().length() > 0) {
                        AssistPlan editPlan = new AssistPlan();
                        editPlan.setId(planId);
                        planDetailService.updateParentStateByDetailList(editPlan, null);
                    }
                }
            }
        }

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
    public ResultModel updateAssistRetreatDetailByProductQualityExecute(PageData pageData) throws Exception {
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
            model.putMsg("外协退货检验执行 Json字符串-转换成List错误！");
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

        //修改外协签收////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String orderDtlIds = new String();
        String orderId = new String();
        String supplierId = new String();
        String supplierName = new String();
        String retreatCode = new String();

        List<AssistRetreatDetail> retreatDetailList = new ArrayList<>();
        for (Map<String, String> objectMap : jsonMapList) {
            AssistRetreatDetail editRetreatDetail = new AssistRetreatDetail();

            //外协退货单号
            retreatCode = objectMap.get("retreatCode");
            supplierId = objectMap.get("supplierId");
            supplierName = objectMap.get("supplierName");

            //外协订单id
            orderId = objectMap.get("orderId");
            //外协订单明细id
            String orderDtlId = objectMap.get("orderDtlId");
            orderDtlIds = orderDtlIds + orderDtlId + ",";

            //id 外协签收明细id
            String id = objectMap.get("id");
            editRetreatDetail.setId(id);

            //qualityType 检验方式 (1:全检 2:抽检)
            String qualityType = objectMap.get("qualityType");
            editRetreatDetail.setQualityType(qualityType);

            //退货数量 orderCount
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            String orderCountStr = objectMap.get("orderCount");
            if (orderCountStr != null && orderCountStr.trim().length() > 0) {
                try {
                    orderCount = new BigDecimal(orderCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editRetreatDetail.setOrderCount(orderCount);

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
            editRetreatDetail.setQualityCount(qualityCount);

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
            editRetreatDetail.setBadCount(badCount);

            //discardCount (检验)报废数量
            BigDecimal discardCount = BigDecimal.valueOf(0D);
            String discardCountStr = objectMap.get("discardCount");
            if (discardCountStr != null && discardCountStr.trim().length() > 0) {
                try {
                    discardCount = new BigDecimal(discardCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            discardCount = discardCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editRetreatDetail.setDiscardCount(discardCount);

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
            editRetreatDetail.setReceiveCount(receiveCount);

            //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
            editRetreatDetail.setState("3");
            retreatDetailList.add(editRetreatDetail);

            //退货数量 orderCount
            orderCount = editRetreatDetail.getOrderCount();
            //报废数量 discardCount
            discardCount = editRetreatDetail.getDiscardCount();

            //signFineCount 收货合格数(签收数:检验数量-报废数)
            BigDecimal signFineCount = BigDecimal.valueOf(0D);
            //qualityFineCount (实际)检验合格数 (检验数量 - 不合格数量)
            BigDecimal qualityFineCount = BigDecimal.valueOf(0D);

            //qualityType 检验方式 (1:全检 2:抽检)
            if ("1".equals(qualityType)) {
                //1:全检:收货合格数 := 检验数量-退货数
                signFineCount = BigDecimal.valueOf(qualityCount.doubleValue() - discardCount.doubleValue());

                //1:全检:(实际)检验合格数 := 检验数量 - 不合格数量
                qualityFineCount = BigDecimal.valueOf(qualityCount.doubleValue() - badCount.doubleValue());
            } else if ("2".equals(qualityType) && qualityCount.doubleValue() != 0) {
                //2:抽检:收货合格数 := 签收数量(退货数量) - 退货数量
                signFineCount = BigDecimal.valueOf(orderCount.doubleValue() - discardCount.doubleValue());

                //2:抽检:(实际)检验合格数 := (签收数量 - 不合格数量)
                qualityFineCount = BigDecimal.valueOf(orderCount.doubleValue() - badCount.doubleValue());
            }
            //四舍五入到2位小数
            signFineCount = signFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editRetreatDetail.setSignFineCount(signFineCount);

            //四舍五入到2位小数
            qualityFineCount = qualityFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editRetreatDetail.setQualityFineCount(qualityFineCount);

            //添加外协报废单
            if (discardCount != null && discardCount.doubleValue() != 0) {
                //type:报废类型(1:外协件 2:外协原材料)
                assistDiscardService.createDiscardByQuality(cuser, companyId, "2", objectMap);
            }

            this.update(editRetreatDetail);

            //外协退货单id
            String parentId = objectMap.get("parentId");
            if (parentId != null && parentId.trim().length() > 0) {
                List<AssistRetreatDetail> retreatDtlList = this.findAssistRetreatDetailListByParentId(parentId);
                if (retreatDtlList != null && retreatDtlList.size() > 0) {
                    AssistRetreat editRetreat = new AssistRetreat();
                    editRetreat.setId(parentId);

                    String parentState = this.findParentStateByDetailList(retreatDtlList);
                    editRetreat.setState(parentState);
                    retreatService.update(editRetreat);
                }
            }

//            //添加(vmes_purchase_quality_detail:外协质检项明细)
//            Object childObj = objectMap.get("children");
//            List childList = (List)childObj;
//            if (childList != null && childList.size() > 0) {
//                for (int i = 0; i < childList.size(); i++) {
//                    Map<String, String> childMap = (Map<String, String>)childList.get(i);
//                    AssistSignQualityDetail addQualityDtl = (AssistSignQualityDetail)HttpUtils.pageData2Entity(childMap, new AssistSignQualityDetail());
//                    assistSignQualityDetailService.save(addQualityDtl);
//                }
//            }
        }

        //修改外协订单////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
        //查询SQL:AssistOrderDetailChildMapper.findCheckAssistOrderChild
        List<Map<String, Object>> orderChildList = assistOrderChildService.findCheckAssistOrderChild(orderId);
        String finishOrderId = assistOrderChildService.finishOrderByAssistOrderChild(orderChildList);

        if (finishOrderId != null && finishOrderId.trim().length() > 0) {
            AssistOrder editOrder = new AssistOrder();
            editOrder.setId(finishOrderId);
            //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
            editOrder.setState("4");
            assistOrderService.update(editOrder);

            //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
            assistOrderDetailService.updateStateByDetail("4", finishOrderId);

            Map<String, String> planMap = new HashMap<>();
            Map<String, String> planDtlMap = new HashMap<>();
            if (orderChildList != null && orderChildList.size() > 0) {
                for (Map<String, Object> objectMap : orderChildList) {
                    //planId 外协计划id
                    String planId = (String)objectMap.get("planId");
                    if (planId != null && planId.trim().length() > 0) {
                        planMap.put(planId, planId);
                    }

                    //planDtlId 外协计划明细id
                    String planDtlId = (String)objectMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        planDtlMap.put(planDtlId, planDtlId);
                    }
                }
            }

            //外协计划明细
            if (planDtlMap != null) {
                for (Iterator iterator = planDtlMap.keySet().iterator(); iterator.hasNext();) {
                    String planDtlId = (String)iterator.next();
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        planDetailService.update(editPlanDtl);
                    }
                }
            }

            if (planMap != null) {
                for (Iterator iterator = planMap.keySet().iterator(); iterator.hasNext();) {
                    String planId = (String)iterator.next();
                    if (planId != null && planId.trim().length() > 0) {
                        AssistPlan editPlan = new AssistPlan();
                        editPlan.setId(planId);
                        planDetailService.updateParentStateByDetailList(editPlan, null);
                    }
                }
            }
        }

        //生成(正常接收Map, 让步接收Map) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //正常接收Map
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();
        //让步接收Map
        Map<String, Map<String, Object>> businessByReceiveInMap = new HashMap<>();

        for (Map<String, String> objectMap : jsonMapList) {
            //外协退货明细id
            String retreatDtlId = objectMap.get("id");
            //货品id
            String productId = objectMap.get("productId");

            ////////////////////////////////////////////////////////////////////////////////////////////
            //退货数量 orderCount
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            String orderCountStr = objectMap.get("orderCount");
            if (orderCountStr != null && orderCountStr.trim().length() > 0) {
                try {
                    orderCount = new BigDecimal(orderCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

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
            //正常接收数量 := 签收数量 - (检验)不合格数量
            BigDecimal inCount = BigDecimal.valueOf(orderCount.doubleValue() - badCount.doubleValue());
            //四舍五入到2位小数
            inCount = inCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

//            //(计量单位)正常接收数量 -> 单位换算公式(p2nFormula)
//            BigDecimal p2n_inCount = EvaluateUtil.countFormulaP2N(inCount, p2nFormula);
//            p2n_inCount = StringUtil.scaleDecimal(p2n_inCount, p2nIsScale, p2nDecimalCount);

            if (inCount != null && inCount.doubleValue() > 0) {
                //Map<String, Map<String, Object>> businessByInMap
                Map<String, Object> inValueMap = new HashMap<>();

                //productId: 货品id
                inValueMap.put("productId", productId);
                //inDtlId:   入库明细id
                inValueMap.put("inDtlId", null);
                //inCount:   入库数量
                inValueMap.put("inCount", inCount);

                businessByInMap.put(retreatDtlId, inValueMap);
            }

            //让步接收数量 : (检验)让步接收数量
            BigDecimal receiveInCount = receiveCount;
            //(计量单位)让步接收数量 -> 单位换算公式(p2nFormula)
            //BigDecimal p2n_receiveInCount = EvaluateUtil.countFormulaP2N(receiveInCount, p2nFormula);
            //p2n_receiveInCount = StringUtil.scaleDecimal(p2n_receiveInCount, p2nIsScale, p2nDecimalCount);
            if (receiveInCount != null && receiveInCount.doubleValue() > 0) {
                Map<String, Object> inValueMap = new HashMap<>();

                //productId: 货品id
                inValueMap.put("productId", productId);
                //inDtlId:   入库明细id
                inValueMap.put("inDtlId", null);
                //inCount:   入库数量
                inValueMap.put("inCount", receiveInCount);

                businessByReceiveInMap.put(retreatDtlId, inValueMap);
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    retreatCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistRetreatDetail editRetreatDetail = new AssistRetreatDetail();

                    //retreatDtlId 外协退货明细id
                    String retreatDtlId = (String)iterator.next();
                    editRetreatDetail.setId(retreatDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(retreatDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");

                    //qualityInDtlId (检验入库)入库单明细id
                    editRetreatDetail.setQualityInDtlId(inDtlId);

                    this.update(editRetreatDetail);
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
                    AssistRetreatDetail editRetreatDetail = new AssistRetreatDetail();

                    //retreatDtlId 外协退货明细id
                    String retreatDtlId = (String)iterator.next();
                    editRetreatDetail.setId(retreatDtlId);

                    Map<String, Object> mapValue = businessByInMap.get(retreatDtlId);
                    //inDtlId:   入库明细id
                    String inDtlId = (String)mapValue.get("inDtlId");
                    //qualityInDtlId (检验入库)入库单明细id
                    editRetreatDetail.setQualityInDtlId(inDtlId);

                    this.update(editRetreatDetail);
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    "让步接收",
                    retreatCode,
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                AssistRetreatDetail editRetreatDetail = new AssistRetreatDetail();

                //retreatDtlId 外协退货明细id
                String retreatDtlId = (String)iterator.next();
                editRetreatDetail.setId(retreatDtlId);

                Map<String, Object> mapValue = businessByReceiveInMap.get(retreatDtlId);
                //inDtlId:   入库明细id
                String inDtlId = (String)mapValue.get("inDtlId");

                //receiveInDtlId (检验让步接收入库)入库单明细id
                editRetreatDetail.setReceiveInDtlId(inDtlId);

                this.update(editRetreatDetail);
            }

        } else if (businessByReceiveInMap != null && businessByReceiveInMap.size() > 0 && Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
            //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
            warehouseInCreateService.createWarehouseInBusinessBySimple(supplierId,
                    supplierName,
                    //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                    Common.DICTIONARY_MAP.get("warehouseEntity"),
                    cuser,
                    companyId,
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    "让步接收",
                    retreatCode,
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                AssistRetreatDetail editSignDetail = new AssistRetreatDetail();

                //retreatDtlId 外协退货明细id
                String retreatDtlId = (String)iterator.next();
                editSignDetail.setId(retreatDtlId);

                Map<String, Object> mapValue = businessByReceiveInMap.get(retreatDtlId);
                //inDtlId:   入库明细id
                String inDtlId = (String)mapValue.get("inDtlId");

                //receiveInDtlId (检验让步接收入库)入库单明细id
                editSignDetail.setReceiveInDtlId(inDtlId);

                this.update(editSignDetail);
            }
        }

        return model;
    }

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

    public ResultModel listPageAssistRetreatDetailByQualityExecute(PageData pd) throws Exception {
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

                //qualityType 检验方式id (1:全检 2:抽检)
                String qualityType = "1";
                if (mapObject.get("qualityType") != null && mapObject.get("qualityType").toString().trim().length() > 0) {
                    qualityType = mapObject.get("qualityType").toString().trim();
                }
                mapObject.put("qualityTypeValue", qualityType);

                //qualityTypeName 检验方式id (1:全检 2:抽检)
                String qualityTypeName = "全检";
                if (mapObject.get("qualityTypeName") != null && mapObject.get("qualityTypeName").toString().trim().length() > 0) {
                    qualityTypeName = mapObject.get("qualityTypeName").toString().trim();
                }
                mapObject.put("qualityTypeName", qualityTypeName);

                //orderCount 退货数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (mapObject.get("orderCount") != null) {
                    orderCount = (BigDecimal)mapObject.get("orderCount");
                }

                //qualityCount 实检数
                BigDecimal qualityCount = BigDecimal.valueOf(0D);
                //qualityType 检验方式:1:全检 qualityCount实检数 == orderCount 退货数量
                if ("1".equals(qualityType)) {
                    qualityCount = orderCount;
                }
                //四舍五入到2位小数
                qualityCount = qualityCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                mapObject.put("qualityCount", qualityCount.toString());

                BigDecimal tempBigDecimal = BigDecimal.valueOf(0D);
                tempBigDecimal = tempBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                //badCount 不合格数
                mapObject.put("badCount", tempBigDecimal.toString());
                //discardCount 报废数量
                mapObject.put("discardCount", tempBigDecimal.toString());
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

}

