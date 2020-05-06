package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.deecoop.assist.dao.AssistSignDetailMapper;
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
* 说明：vmes_assist_sign_detail:外协签收单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-05-04
*/
@Service
@Transactional(readOnly = false)
public class AssistSignDetailServiceImp implements AssistSignDetailService {
    @Autowired
    private AssistSignDetailMapper assistSignDetailMapper;
    @Autowired
    private AssistSignService signService;
    @Autowired
    private AssistSignQualityDetailService assistSignQualityDetailService;

    @Autowired
    private AssistOrderDetailService orderDetailService;

    @Autowired
    private AssistPlanDetailService planDetailService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private PurchaseByFinanceBillService purchaseByFinanceBillService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistSignDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistSignDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistSignDetail selectById(String id) throws Exception{
        return assistSignDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistSignDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistSignDetail> warehouseCheckDetailList = assistSignDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistSignDetail object) throws Exception{
        object.setUdate(new Date());
        assistSignDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistSignDetail object) throws Exception{
        object.setUdate(new Date());
        assistSignDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistSignDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistSignDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistSignDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistSignDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistSignDetail> dataList(PageData pd) throws Exception{
        return assistSignDetailMapper.dataList(pd);
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
            return assistSignDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistSignDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistSignDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistSignDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistSignDetail findAssistSignDetail(PageData object) throws Exception {
        List<AssistSignDetail> objectList = this.findAssistSignDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistSignDetail findAssistSignDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistSignDetail(findMap);
    }

    public List<AssistSignDetail> findAssistSignDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistSignDetail> findAssistSignDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findAssistSignDetailList(findMap);
    }

    /**
     * 获取签收单状态-根据签收单明细状态
     * 签收单单状态(1:检验中 2:已完成 -1:已取消)
     * 签收单明细状态(1:检验中 2:已完成 -1:已取消)
     *
     * @param objectList      外协签收单明细List<AssistSignDetail>
     * @return
     */
    public String findParentStateByDetailList(List<AssistSignDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}

        //签收单明细状态(1:检验中 2:已完成 -1:已取消)
        int jyz = 0; //1:检验中
        int ywc = 0; //2:已完成
        int yqx = 0; //-1:已取消

        if (objectList != null && objectList.size() > 0) {
            for (AssistSignDetail detail : objectList) {
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
            //signDtlId 外协签收明细id
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

            Map<String, Object> productMap = new HashMap<>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", count);

            productByInMap.put(signDtlId, productMap);
        }

        return productByInMap;
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

        assistSignDetailMapper.updateStateByDetail(pageData);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistSignDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistSignDetail");
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

    //获取(质量-外协检验)外协签收明细检验
    //菜单路径:(质量-外协检验) 当前外协签收明细(执行)按钮弹出框查询调用方法
    public ResultModel listPageAssistSignDetailByQualityExecute(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistSignDetail");
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

    //外协签收明细-检验执行 Assist
    public ResultModel assistSignDetailByQualityExecute(PageData pageData) throws Exception {
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
            model.putMsg("外协签收明细执行 Json字符串-转换成List错误！");
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
        String signCode = new String();

        List<AssistSignDetail> signDetailList = new ArrayList<>();
        for (Map<String, String> objectMap : jsonMapList) {
            AssistSignDetail editSignDetail = new AssistSignDetail();

            supplierId = objectMap.get("supplierId");
            supplierName = objectMap.get("supplierName");

            //外协订单id
            orderId = objectMap.get("orderId");
            //外协订单明细id
            String orderDtlId = objectMap.get("orderDtlId");
            orderDtlIds = orderDtlIds + orderDtlId + ",";
            editSignDetail.setOrderDetailId(orderDtlId);

            //id 外协签收明细id
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
                signFineCount = BigDecimal.valueOf(qualityCount.doubleValue() - retreatCount.doubleValue());

                //1:全检:(实际)检验合格数 := 检验数量 - 不合格数量
                qualityFineCount = BigDecimal.valueOf(qualityCount.doubleValue() - badCount.doubleValue());
            } else if ("2".equals(qualityType) && qualityCount.doubleValue() != 0) {
                //2:抽检:收货合格数 := 签收数量 - 退货数量
                signFineCount = BigDecimal.valueOf(arriveCount.doubleValue() - retreatCount.doubleValue());

                //2:抽检:(实际)检验合格数 := (签收数量 - 不合格数量)
                qualityFineCount = BigDecimal.valueOf(arriveCount.doubleValue() - badCount.doubleValue());
            }
            //四舍五入到2位小数
            signFineCount = signFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setSignFineCount(signFineCount);

            //四舍五入到2位小数
            qualityFineCount = qualityFineCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            editSignDetail.setQualityFineCount(qualityFineCount);

//            //添加外协退货单
//            if (retreatCount != null && retreatCount.doubleValue() != 0) {
//                String retreatDtlId = retreatService.createRetreatByQuality(cuser, companyId, objectMap);
//                editSignDetail.setRetreatDtlId(retreatDtlId);
//            }

            this.update(editSignDetail);

            //price 单价(外协订单明细)
            BigDecimal price = BigDecimal.valueOf(0D);
            String priceStr = objectMap.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //amount 签收金额 = 收货合格数(signFineCount) * 单价(外协订单明细)
            BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * signFineCount.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //生成外协付款单(vmes_finance_bill)
            //外协签收单号
            signCode = objectMap.get("signCode");
            purchaseByFinanceBillService.addFinanceBillByAssist(editSignDetail.getId(),
                    companyId,
                    supplierId,
                    cuser,
                    //type: 单据类型 ( 0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购) 10:应付单(采购) 11:收货账单(外协) 12:退款单(外协))
                    //11:收货账单(外协) 12:退款单(外协)
                    "11",
                    //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                    "2",
                    null,
                    amount,
                    signCode);

            //外协签收单id
            String parentId = objectMap.get("parentId");
            if (parentId != null && parentId.trim().length() > 0) {
                List<AssistSignDetail> signDtlList = this.findAssistSignDetailListByParentId(parentId);

                //获取签收单状态-根据签收单明细
                if (signDtlList != null && signDtlList.size() > 0) {
                    AssistSign editSign = new AssistSign();
                    editSign.setId(parentId);

                    String parentState = this.findParentStateByDetailList(signDtlList);
                    editSign.setState(parentState);
                    signService.update(editSign);
                }
            }

            //添加(vmes_purchase_quality_detail:外协质检项明细)
            Object childObj = objectMap.get("children");
            List childList = (List)childObj;
            if (childList != null && childList.size() > 0) {
                for (int i = 0; i < childList.size(); i++) {
                    Map<String, String> childMap = (Map<String, String>)childList.get(i);
                    AssistSignQualityDetail addQualityDtl = (AssistSignQualityDetail)HttpUtils.pageData2Entity(childMap, new AssistSignQualityDetail());
                    assistSignQualityDetailService.save(addQualityDtl);
                }
            }
        }

        //修改外协订单////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据(外协订单明细id) 查询
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //查询SQL:AssistOrderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign
            PageData findMap = new PageData();
            findMap.put("detailIds", detailIds);
            orderDetailMap = orderDetailService.findCheckAssistOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 外协计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDetailList != null && signDetailList.size() > 0) {
            for (AssistSignDetail signDetail : signDetailList) {
                AssistOrderDetail editOrderDtl = new AssistOrderDetail();

                //orderDetailId 外协订单明细ID
                String orderDetailId = signDetail.getOrderDetailId();
                editOrderDtl.setId(orderDetailId);

                Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
                //orderCount 订单数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (valueMap.get("orderCount") != null) {
                    orderCount = (BigDecimal)valueMap.get("orderCount");
                }

                //signFineCount 收货合格数(签收数-(检验)退货数)
                BigDecimal signFineCount = BigDecimal.valueOf(0D);
                if (valueMap.get("signFineCount") != null) {
                    signFineCount = (BigDecimal)valueMap.get("signFineCount");
                }

                //外协订单明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
                if (signFineCount.doubleValue() >= orderCount.doubleValue()) {
                    editOrderDtl.setState("4");
                    orderDetailService.update(editOrderDtl);

                    //planDtlId 外协计划明细id
                    String planDtlId = (String)valueMap.get("planDtlId");
                    if (planDtlId != null && planDtlId.trim().length() > 0) {
                        AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                        editPlanDtl.setId(planDtlId);
                        //外协计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                        editPlanDtl.setState("4");
                        planDetailService.update(editPlanDtl);
                    }
                }

                //planId 外协计划id
                if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                    String planId = (String)valueMap.get("planId");
                    planIdMap.put(planId.trim(), planId.trim());
                }
            }
        }

        //反写外协订单状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);
        orderDetailService.updateParentStateByDetailList(editOrder, null);
        //反写 (外协计划明细,外协计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    AssistPlan editPlan = new AssistPlan();
                    editPlan.setId(planId);
                    planDetailService.updateParentStateByDetailList(editPlan, null);
                }
            }
        }

        //生成(正常接收Map, 让步接收Map) ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //正常接收Map
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();
        //让步接收Map
        Map<String, Map<String, Object>> businessByReceiveInMap = new HashMap<>();

        for (Map<String, String> objectMap : jsonMapList) {
            //外协签收明细id
            String signDtlId = objectMap.get("id");
            //货品id
            String productId = objectMap.get("productId");

//            //p2nFormula 单位换算公式:计价单位转换计量单位:
//            String p2nFormula = new String();
//            if (objectMap.get("p2nFormula") != null) {
//                p2nFormula = objectMap.get("p2nFormula").trim();
//            }

//            //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
//            String p2nIsScale = new String();
//            if (objectMap.get("p2nIsScale") != null) {
//                p2nIsScale = objectMap.get("p2nIsScale").trim();
//            }

//            //小数位数 (最小:0位 最大:4位)
//            Integer p2nDecimalCount = Integer.valueOf(2);
//            String p2nDecimalCountStr = objectMap.get("p2nDecimalCount");
//            if (p2nDecimalCountStr != null) {
//                try {
//                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }

            ////////////////////////////////////////////////////////////////////////////////////////////
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
            BigDecimal inCount = BigDecimal.valueOf(arriveCount.doubleValue() - badCount.doubleValue());
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

                businessByInMap.put(signDtlId, inValueMap);
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    signCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDetail = new AssistSignDetail();

                    //signDtlId 外协签收id
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    signCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDetail = new AssistSignDetail();

                    //signDtlId 外协签收id
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    "让步接收",
                    signCode,
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                AssistSignDetail editSignDetail = new AssistSignDetail();

                //signDtlId 外协签收id
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    "让步接收",
                    signCode,
                    businessByReceiveInMap);

            for (Iterator iterator = businessByReceiveInMap.keySet().iterator(); iterator.hasNext();) {
                AssistSignDetail editSignDetail = new AssistSignDetail();

                //signDtlId 外协签收id
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

    //外协签收明细-免检
    public ResultModel updateAssistSignDetailByQuality(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String signDtlId = pageData.getString("signDtlId");
        if (signDtlId == null || signDtlId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协签收明细id为空或空字符串！");
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
        //根据(外协签收明细id) 查询
        //SQL语句: AssistSignDetailMapper.getDataListPage
        PageData findMap = new PageData();
        findMap.put("signDtlId", signDtlId);
        List<Map> mapList = this.getDataListPage(findMap, null);

        Map<String, Object> signDetailMap = new HashMap<>();
        if (mapList != null && mapList.size() > 0) {
            signDetailMap = mapList.get(0);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改外协签收
        AssistSignDetail editSignDetail = new AssistSignDetail();
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

        //amount 签收金额 = 签收数量 * 单价(外协订单明细)
        BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * arriveCountDB.doubleValue());
        //四舍五入到2位小数
        amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        this.update(editSignDetail);

        //外协签收单id
        String parentId = (String)signDetailMap.get("parentId");
        if (parentId != null && parentId.trim().length() > 0) {
            List<AssistSignDetail> signDtlList = this.findAssistSignDetailListByParentId(parentId);

            //获取签收单状态-根据签收单明细
            if (signDtlList != null && signDtlList.size() > 0) {
                AssistSign editSign = new AssistSign();
                editSign.setId(parentId);

                String parentState = this.findParentStateByDetailList(signDtlList);
                editSign.setState(parentState);
                signService.update(editSign);
            }
        }

        String supplierId = (String)signDetailMap.get("supplierId");

        //生成外协(vmes_finance_bill)付款单
        String signCode = (String)signDetailMap.get("signCode");
        purchaseByFinanceBillService.addFinanceBillByAssist(editSignDetail.getId(),
                companyId,
                supplierId,
                cuser,
                //type: 单据类型 ( 0:收款单(销售) 1:付款单(采购) 2:减免单(销售) 3:退款单(销售) 4:发货账单(销售) 5:退货账单(销售) 6:收货账单(采购) 7:扣款单(采购) 8:应收单(销售) 9:退款单(采购) 10:应付单(采购) 11:收货账单(外协) 12:退款单(外协))
                //11:收货账单(外协) 12:退款单(外协)
                "11",
                //state:状态(0：待提交 1：待审核 2：已审核 -1：已取消)
                "2",
                null,
                amount,
                signCode);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //修改外协订单
        //根据(外协订单明细id) 查询
        String orderDtlIds = (String)signDetailMap.get("orderDetailId");
        Map<String, Map<String, Object>> orderDetailMap = new HashMap<>();
        if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
            String detailIds = orderDtlIds.trim();
            detailIds = StringUtil.stringTrimSpace(detailIds);
            detailIds = "'" + detailIds.replace(",", "','") + "'";

            //查询SQL:AssistOrderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign
            findMap = new PageData();
            findMap.put("orderDtlIds", detailIds);
            orderDetailMap = orderDetailService.findCheckAssistOrderDetailMap(findMap);
        }

        //遍历当前签收明细List
        //planId 外协计划id
        Map<String, String> planIdMap = new HashMap<>();
        if (signDetailMap != null && signDetailMap.size() > 0) {
            AssistOrderDetail editOrderDtl = new AssistOrderDetail();

            //orderDetailId 外协订单明细ID
            String orderDetailId = (String)signDetailMap.get("orderDetailId");
            editOrderDtl.setId(orderDetailId);

            Map<String, Object> valueMap = orderDetailMap.get(orderDetailId);
            //orderCount 订单数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (valueMap.get("orderCount") != null) {
                orderCount = (BigDecimal)valueMap.get("orderCount");
            }

            //signFineCount 收货合格数(签收数-(检验)退货数)
            BigDecimal signFineCount = BigDecimal.valueOf(0D);
            if (valueMap.get("signFineCount") != null) {
                signFineCount = (BigDecimal)valueMap.get("signFineCount");
            }

            //外协单明细状态(0:待提交 1:待审核 2:采购中 3:部分签收 4:已完成 -1:已取消)
            if (signFineCount.doubleValue() >= orderCount.doubleValue()) {
                editOrderDtl.setState("4");
                orderDetailService.update(editOrderDtl);

                //planDtlId 外协计划明细id
                String planDtlId = (String)valueMap.get("planDtlId");
                if (planDtlId != null && planDtlId.trim().length() > 0) {
                    AssistPlanDetail editPlanDtl = new AssistPlanDetail();
                    editPlanDtl.setId(planDtlId);
                    //外协计划明细状态(0:待提交 1:待审核 2:待执行 3:执行中 4:已完成 -1:已取消)
                    editPlanDtl.setState("4");
                    planDetailService.update(editPlanDtl);
                }
            }

            //planId 外协计划id
            if (valueMap.get("planId") != null && valueMap.get("planId").toString().trim().length() > 0) {
                String planId = (String)valueMap.get("planId");
                planIdMap.put(planId.trim(), planId.trim());
            }
        }

        //反写外协订单状态
        String orderId = (String)signDetailMap.get("orderId");
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);
        orderDetailService.updateParentStateByDetailList(editOrder, null);
        //反写 (外协计划明细,外协计划)状态
        if (planIdMap != null) {
            for (Iterator iterator = planIdMap.keySet().iterator(); iterator.hasNext();) {
                String planId = (String)iterator.next();
                if (planId != null && planId.trim().length() > 0) {
                    //planService.updateState(planId);
                    AssistPlan editPlan = new AssistPlan();
                    editPlan.setId(planId);
                    planDetailService.updateParentStateByDetailList(editPlan, null);
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, Map<String, Object>> businessByInMap = new HashMap<>();

        //货品id
        String productId = (String)signDetailMap.get("productId");

//        //p2nFormula 单位换算公式:计价单位转换计量单位:
//        String p2nFormula = new String();
//        if (signDetailMap.get("p2nFormula") != null) {
//            p2nFormula = signDetailMap.get("p2nFormula").toString().trim();
//        }

//        //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
//        String p2nIsScale = new String();
//        if (signDetailMap.get("p2nIsScale") != null) {
//            p2nIsScale = signDetailMap.get("p2nIsScale").toString().trim();
//        }

//        //小数位数 (最小:0位 最大:4位)
//        Integer p2nDecimalCount = Integer.valueOf(2);
//        if (signDetailMap.get("p2nDecimalCount") != null) {
//            p2nDecimalCount = (Integer)signDetailMap.get("p2nDecimalCount");
//        }

        //签收数量
        BigDecimal arriveCount = BigDecimal.valueOf(0D);
        if (signDetailMap.get("arriveCount") != null) {
            arriveCount = (BigDecimal)signDetailMap.get("arriveCount");
        }

//        //(计量单位)签收数量 -> 单位换算公式(p2nFormula)
//        BigDecimal p2n_arriveCount = EvaluateUtil.countFormulaP2N(arriveCount, p2nFormula);
//        p2n_arriveCount = StringUtil.scaleDecimal(p2n_arriveCount, p2nIsScale, p2nDecimalCount);

        if (arriveCount != null && arriveCount.doubleValue() > 0) {
            Map<String, Object> inValueMap = new HashMap<>();

            //productId: 货品id
            inValueMap.put("productId", productId);
            //inDtlId:   入库明细id
            inValueMap.put("inDtlId", null);
            //inCount:   入库数量
            inValueMap.put("inCount", arriveCount);

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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    signCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDtl = new AssistSignDetail();

                    //signDtlId 外协签收id
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
                    //外协入库 064dda15d44d4f8fa6330c5c7e46300e:assistIn
                    Common.DICTIONARY_MAP.get("assistIn"),
                    null,
                    signCode,
                    businessByInMap);

            if (businessByInMap != null) {
                for (Iterator iterator = businessByInMap.keySet().iterator(); iterator.hasNext();) {
                    AssistSignDetail editSignDtl = new AssistSignDetail();

                    //signDtlId 外协签收id
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

