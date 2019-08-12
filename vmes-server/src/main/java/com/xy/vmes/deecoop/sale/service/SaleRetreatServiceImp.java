package com.xy.vmes.deecoop.sale.service;


import com.yvan.common.util.Common;
import com.xy.vmes.deecoop.sale.dao.SaleRetreatMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_retreat:退货单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-02-25
*/
@Service
@Transactional(readOnly = false)
public class SaleRetreatServiceImp implements SaleRetreatService {

    @Autowired
    private SaleRetreatMapper saleRetreatMapper;
    @Autowired
    private SaleRetreatDetailService saleRetreatDetailService;

    @Autowired
    private SaleReceiveService saleReceiveService;
    @Autowired
    private SaleReceiveDetailService saleReceiveDetailService;
    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private SaleOrderService saleOrderService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-02-25
    */
    @Override
    public void save(SaleRetreat saleOrderReturn) throws Exception{
        saleOrderReturn.setId(Conv.createUuid());
        saleOrderReturn.setCdate(new Date());
        saleOrderReturn.setUdate(new Date());
        saleRetreatMapper.insert(saleOrderReturn);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public SaleRetreat selectById(String id) throws Exception{
        return saleRetreatMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public List<SaleRetreat> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleRetreat> warehouseCheckDetailList =  saleRetreatMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void update(SaleRetreat object) throws Exception{
        object.setUdate(new Date());
        saleRetreatMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateAll(SaleRetreat object) throws Exception{
        object.setUdate(new Date());
        saleRetreatMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleRetreatMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleRetreatMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleRetreatMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleRetreatMapper.updateToDisableByIds(ids);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableBySaleRetreat(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        saleRetreatMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    public void updateStateByRetreat(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", "id in (" + ids + ")");

        saleRetreatMapper.updateStateByRetreat(pageData);
    }

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
    public List<SaleRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleRetreat>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public List<SaleRetreat> dataList(PageData pd) throws Exception{
        return saleRetreatMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleRetreatMapper.getDataListPage(pd, pg);
    }

    public SaleRetreat findSaleRetreat(PageData object) throws Exception {
        List<SaleRetreat> objectList = this.findSaleRetreatList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleRetreat findSaleRetreatById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleRetreat(findMap);
    }

    public List<SaleRetreat> findSaleRetreatList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleRetreat> mapList2RetreatList(List<Map<String, String>> mapList, List<SaleRetreat> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleRetreat>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleRetreat retreat = (SaleRetreat) HttpUtils.pageData2Entity(mapObject, new SaleRetreat());
            objectList.add(retreat);
        }

        return objectList;
    }

    /**
     *
     * 退货单明细表
     * deliverDetailId: rowData.id,
     * orderDetailId: rowData.orderDetaiId,
     * productId: rowData.productId,
     * orderSum: rowData.retreatOrderSum,
     * orderUnit: rowData.orderUnit,
     * orderCount: rowData.retreatOrderCount,
     * productUnit: rowData.productUnit,
     * remark: rowData.retreatRemark,
     *
     * orderId: rowData.orderId,
     * receiveAmount: rowData.receiveAmount,
     * notRetreatSum: rowData.notRetreatSum,
     * n2pFormula: rowData.n2pFormula,
     * p2nFormula: rowData.p2nFormula,
     *
     * @param mapList
     * @return
     */
    public String checkColumnByEdit(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //字段非空验证
        String msgStr = this.checkNullColumn(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            return msgStr;
        }

//        //receiveAmount 订单实收金额
//        msgStr = this.checkColumnByReceiveAmount(mapList);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            return msgStr;
//        }

        //订单可退金额 订单退货金额
        msgStr = this.checkOrderAllowReceiveSum(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            return msgStr;
        }

        return new String();
    }

    public String checkNullColumn(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //字段非空验证
        String nullMsgTemp = "第 {0} 行: ({1})为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        String numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> mapObject = mapList.get(i);

            //非空判断 deliverDetailId
            String deliverDetailId = mapObject.get("deliverDetailId");
            if (deliverDetailId == null || deliverDetailId.trim().length() == 0) {
                String msg_Str = MessageFormat.format(nullMsgTemp,
                        (i+1),
                        "发货明细id");
                msgBuf.append(msg_Str);
            }

            //orderCount 本次退货数量
            String orderCount_str = mapObject.get("orderCount");
            if (orderCount_str == null || orderCount_str.trim().length() == 0) {
                String msg_Str = MessageFormat.format(nullMsgTemp,
                        (i+1),
                        "本次退货数量");
                msgBuf.append(msg_Str);
            } else {
                try {
                    BigDecimal bigTemp = new BigDecimal(orderCount_str.trim());
                    if (bigTemp.doubleValue() <= 0D) {
                        //numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                        String msg_Str = MessageFormat.format(numberMsgTemp,
                                (i+1),
                                "本次退货数量",
                                orderCount_str);
                        msgBuf.append(msg_Str);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    //numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                    String msg_Str = MessageFormat.format(numberMsgTemp,
                            (i+1),
                            "本次退货数量",
                            orderCount_str);
                    msgBuf.append(msg_Str);
                }
            }
        }

        return msgBuf.toString();
    }

//    public String checkColumnByReceiveAmount(List<Map<String, String>> mapList) {
//        if (mapList == null || mapList.size() == 0) {return new String();}
//        String sumMsgTemp = "第 {0} 行: ({1})为空或等于零！" + Common.SYS_ENDLINE_DEFAULT;
//
//        StringBuffer msgBuf = new StringBuffer();
//        for (int i = 0; i < mapList.size(); i++) {
//            Map<String, String> mapObject = mapList.get(i);
//
//            //receiveAmount 订单实收金额
//            BigDecimal receiveAmount = BigDecimal.valueOf(0D);
//            String receiveAmount_str = mapObject.get("receiveAmount");
//            if (receiveAmount_str != null && receiveAmount_str.trim().length() > 0) {
//                try {
//                    receiveAmount = new BigDecimal(receiveAmount_str.trim());
//                    //四舍五入到2位小数
//                    receiveAmount = receiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (receiveAmount.doubleValue() == 0D) {
//                //sumMsgTemp = "第 {0} 行: ({1})为空或等于零！"
//                String msg_Str = MessageFormat.format(sumMsgTemp,
//                        (i+1),
//                        "订单实收金额");
//                msgBuf.append(msg_Str);
//            }
//        }
//
//        if (msgBuf.toString().trim().length() > 0) {
//            msgBuf.append("备注:订单实收金额为零，表示该订单无收款记录，请在(销售-应收款管理)中对该订单执行收款！").append(Common.SYS_ENDLINE_DEFAULT);
//        }
//
//        return msgBuf.toString();
//    }

    /**
     *
     * 退货单明细表
     * id: rowData.id,
     * orderSum: rowData.retreatOrderSum,
     *
     * sysOrderCode: rowData.orderId,
     * orderId: rowData.orderId,
     * receiveAmount: rowData.receiveAmount,
     * notRetreatSum: rowData.notRetreatSum
     *
     * @param mapList
     * @return
     */
    public String checkColumnByMoney(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //字段非空验证
        String msgStr = this.checkNullColumnByMoney(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            return msgStr;
        }

        //订单实收金额 订单退货金额
        msgStr = this.checkOrderAllowReceiveSumByMoney(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            return msgStr;
        }

        return new String();
    }

    public String checkNullColumnByMoney(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        //字段非空验证
        String nullMsgTemp = "第 {0} 行: ({1})为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        String numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, String> mapObject = mapList.get(i);

            //退货单明细id id
            String id = mapObject.get("id");
            if (id == null || id.trim().length() == 0) {
                String msg_Str = MessageFormat.format(nullMsgTemp,
                        (i+1),
                        "退货单明细id");
                msgBuf.append(msg_Str);
            }

            //退货金额 orderSum
            String orderSum_str = mapObject.get("orderSum");
            if (orderSum_str == null || orderSum_str.trim().length() == 0) {
                String msg_Str = MessageFormat.format(nullMsgTemp,
                        (i+1),
                        "退货金额");
                msgBuf.append(msg_Str);
            } else {
                try {
                    BigDecimal bigTemp = new BigDecimal(orderSum_str.trim());
                    if (bigTemp.doubleValue() < 0D) {
                        //numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                        String msg_Str = MessageFormat.format(numberMsgTemp,
                                (i+1),
                                "退货金额",
                                orderSum_str);
                        msgBuf.append(msg_Str);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    //numberMsgTemp = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                    String msg_Str = MessageFormat.format(numberMsgTemp,
                            (i+1),
                            "退货金额",
                            orderSum_str);
                    msgBuf.append(msg_Str);
                }
            }
        }

        return msgBuf.toString();
    }

    public String checkOrderAllowReceiveSumByMoney(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}
        StringBuffer msgBuf = new StringBuffer();

        //1. 获取 <订单编号, 订单id>sysOrderCode
        Map<String, String> orderCodeMap = this.findOrderCodeMap(mapList);
        //2. 获取 <订单编号, 实收金额>
        Map<String, BigDecimal> orderAllowReceiveAmountMap = this.findOrderAllowReceiveAmountMap(mapList);
        //3. 获取 <订单编号, 退货金额>
        Map<String, BigDecimal> orderRetreatSumMap = this.findOrderRetreatSumMap(mapList);

        String msgTemp = "订单编号:{0} 订单实收金额:{1} 订单退货金额(退货金额汇总):{2} 订单退货金额不可大于订单实收金额！" + Common.SYS_ENDLINE_DEFAULT;
        for (Iterator iterator = orderCodeMap.keySet().iterator(); iterator.hasNext();) {
            String orderCode = (String) iterator.next();
            //订单实收金额
            BigDecimal receiveAmount = orderAllowReceiveAmountMap.get(orderCode);
            //退货金额 retreatSum
            BigDecimal retreatSum = orderRetreatSumMap.get(orderCode);

            if (retreatSum.doubleValue() > receiveAmount.doubleValue()) {
                //msgTemp = "订单编号:{0} 订单实收金额:{1} 订单退货金额:{2} 订单退货金额不可大于订单实收金额！"
                String msg_Str = MessageFormat.format(msgTemp,
                        orderCode,
                        receiveAmount.toString(),
                        retreatSum.toString());
                msgBuf.append(msg_Str);
            }
        }

        return msgBuf.toString();
    }

    public String checkOrderAllowReceiveSum(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}
        StringBuffer msgBuf = new StringBuffer();

        //1. 获取 <订单编号, 订单id>sysOrderCode
        Map<String, String> orderCodeMap = this.findOrderCodeMap(mapList);
        //2. 获取 <订单编号, 可退金额>
        Map<String, BigDecimal> orderAllowReceiveSumMap = this.findOrderAllowReceiveSumMap(mapList);
        //3. 获取 <订单编号, 退货金额>
        Map<String, BigDecimal> orderRetreatSumMap = this.findOrderRetreatSumMap(mapList);

        String msgTemp = "订单编号:{0} 订单可退金额:{1} 订单退货金额(退货金额汇总):{2} 订单退货金额不可大于订单可退金额！" + Common.SYS_ENDLINE_DEFAULT;
        for (Iterator iterator = orderCodeMap.keySet().iterator(); iterator.hasNext();) {
            String orderCode = (String) iterator.next();
            //订单可退金额
            BigDecimal allowReceiveSum = orderAllowReceiveSumMap.get(orderCode);
            //退货金额 retreatSum
            BigDecimal retreatSum = orderRetreatSumMap.get(orderCode);

            if (retreatSum.doubleValue() > allowReceiveSum.doubleValue()) {
                //msgTemp = "订单编号:{0} 订单可退金额:{1} 订单退货金额:{2} 订单退货金额不可大于订单可退金额！"
                String msg_Str = MessageFormat.format(msgTemp,
                        orderCode,
                        allowReceiveSum.toString(),
                        retreatSum.toString());
                msgBuf.append(msg_Str);
            }
        }

        return msgBuf.toString();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleRetreat(PageData pd,Pagination pg) throws Exception {

        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleRetreat");
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

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public ResultModel checkRetreatEdit(PageData pageData) {
        ResultModel model = new ResultModel();

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无退货列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货明细Json字符串-转换成List错误！");
            return model;
        }

        String msgStr = this.checkColumnByEdit(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        return model;
    }

    public ResultModel addSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //客户ID
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        //退货类型
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货类型id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无退货列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货明细Json字符串-转换成List错误！");
            return model;
        }

//        String msgStr = this.checkColumnByEdit(mapList);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        List<SaleRetreatDetail> retreatDtlList = saleRetreatDetailService.mapList2DetailList(mapList, null);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //1. 退货单
        SaleRetreat retreat = new SaleRetreat();
        retreat.setType(type);
        retreat.setCustomerId(customerId);
        //获取退货总金额
        BigDecimal totalSum = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlList);
        retreat.setTotalSum(totalSum);

        String companyID = pageData.getString("currentCompanyId");
        retreat.setCompanyId(companyID);

        String cuser = pageData.getString("cuser");
        retreat.setCuser(cuser);

        //退货单编号
        //D+yyyyMMdd+00001 = 14位
        String code = coderuleService.createCoderCdateByDate(companyID,
                "vmes_sale_retreat",
                "yyyyMMdd",
                "T");
        retreat.setSysCode(code);

        //状态状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            retreat.setState("1");
        }
        this.save(retreat);

        //2. 退货单明细
        saleRetreatDetailService.addSaleRetreatDetail(retreat, retreatDtlList);

        return model;
    }

    public ResultModel updateSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //退货类型
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货类型id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无退货列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货明细Json字符串-转换成List错误！");
            return model;
        }

//        String msgStr = this.checkColumnByEdit(mapList);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        List<SaleRetreatDetail> retreatDtlList = saleRetreatDetailService.mapList2DetailList(mapList, null);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //修改退货单(退货总金额)
        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        retreatEdit.setType(type);
        BigDecimal totalSum = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlList);
        retreatEdit.setTotalSum(totalSum);
        this.update(retreatEdit);

        Map<String, Object> columnMap = new HashMap<String, Object>();
        columnMap.put("parent_id", parentId);
        saleRetreatDetailService.deleteByColumnMap(columnMap);

        SaleRetreat retreat = new SaleRetreat();
        retreat.setId(parentId);
        String cuser = pageData.getString("cuser");
        retreat.setCuser(cuser);
        saleRetreatDetailService.addSaleRetreatDetail(retreat, retreatDtlList);

        return model;
    }

    public ResultModel deleteSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //2. 删除退货单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        saleRetreatDetailService.deleteByColumnMap(columnMap);

        //3. 删除货单单
        this.deleteById(parentId);


        return model;
    }
    public ResultModel cancelSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        mapDetail.put("state", "-1");
        saleRetreatDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleRetreat retreat = new SaleRetreat();
        retreat.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreat.setState("-1");
        this.update(retreat);

        return model;
    }

    public ResultModel recoverySaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "0");
        saleRetreatDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("0");
        this.update(retreatEdit);

        return model;
    }

    public ResultModel submitSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String retreatJsonStr = pageData.getString("retreatJsonStr");
        if (retreatJsonStr == null || retreatJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(retreatJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单Json字符串-转换成List错误！");
            return model;
        }

        //获取订单
        String ids = "";
        List<SaleRetreat> orderList = this.mapList2RetreatList(mapList, null);
        for (SaleRetreat order : orderList) {
            if (order.getId() != null && order.getId().trim().length() > 0) {
                ids = ids + order.getId().trim() + ",";
            }
        }
        ids = StringUtil.stringTrimSpace(ids);

        //1. 退货单状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        this.updateStateByRetreat("1", ids);

        //2. 退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        saleRetreatDetailService.updateStateByDetail("1", ids);

        return model;
    }

    public ResultModel rebackBySubmitSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        mapDetail.put("state", "0");
        saleRetreatDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        SaleRetreat retreat = new SaleRetreat();
        retreat.setId(parentId);
        //state:状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreat.setState("0");
        this.update(retreat);

        return model;
    }

    public ResultModel updateRetreatByMoney(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String companyID = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无退货列表数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货明细Json字符串-转换成List错误！");
            return model;
        }

        String msgStr = this.checkColumnByMoney(mapList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        List<SaleRetreatDetail> retreatDtlList = saleRetreatDetailService.mapList2DetailList(mapList, null);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //获取退货单(退货总金额)
        BigDecimal receiveSum = BigDecimal.valueOf(0D);
        BigDecimal retreatTotalSum = saleRetreatDetailService.findTotalSumByDetailList(retreatDtlList);
        if (retreatTotalSum != null && retreatTotalSum.doubleValue() != 0D) {
            receiveSum = BigDecimal.valueOf(retreatTotalSum.doubleValue() * -1);

            //1. 创建收款单
            //收款单类型(0:预收款 1:普通收款 2:发货退款 3:订单退款)
            SaleReceive receive = saleReceiveService.createReceive(customerId,
                    cuser,
                    companyID,
                    "2");

            receive.setReceiveSum(receiveSum);
            saleReceiveService.save(receive);

            //2. 创建收款单明细
            //获取 <订单id, 退货金额>
            Map<String, BigDecimal> orderRetreatSumMap = this.findOrderIdRetreatSumMap(mapList);
            List<SaleReceiveDetail> receiveDtlList = saleRetreatDetailService.retreatMap2ReceiveDtlList(orderRetreatSumMap, null);
            saleReceiveDetailService.addReceiveDetail(receive, receiveDtlList);
        }

        //3. 修改退货单
        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        retreatEdit.setTotalSum(retreatTotalSum);
        //状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("3");
        this.update(retreatEdit);

        //4. 修改退货单明细
        for (SaleRetreatDetail detail : retreatDtlList) {
            SaleRetreatDetail detailEdit = new SaleRetreatDetail();
            detailEdit.setId(detail.getId());
            detailEdit.setOrderSum(detail.getOrderSum());
            //退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
            detailEdit.setState("3");
            saleRetreatDetailService.update(detailEdit);
        }

        // 获取Map<订单编号, 订单id>
        Map<String, String> orderCodeMap = this.findOrderCodeMap(mapList);
        //获取 <订单编号, 退货金额>
        Map<String, BigDecimal> orderRetreatSumMap = this.findOrderRetreatSumMap(mapList);

        if (orderCodeMap != null && orderCodeMap.size() > 0) {
            for (Iterator iterator = orderCodeMap.keySet().iterator(); iterator.hasNext();) {
                String orderCode = (String) iterator.next();
                String orderId = orderCodeMap.get(orderCode);
                //订单退款金额(大于零的小数)
                BigDecimal orderRetreatSum = orderRetreatSumMap.get(orderCode);

                //修改订单金额
                if (orderId != null && orderId.trim().length() > 0 && orderRetreatSum != null && orderRetreatSum.doubleValue() != 0) {
                    SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
                    //orderSum 订单金额
                    if (orderDB != null && orderDB.getOrderSum() != null) {
                        BigDecimal orderSum = orderDB.getOrderSum();
                        BigDecimal newOrderSum = BigDecimal.valueOf(orderSum.doubleValue() - orderRetreatSum.doubleValue());
                        //四舍五入到2位小数
                        newOrderSum = newOrderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                        SaleOrder orderEdit = new SaleOrder();
                        orderEdit.setId(orderId);
                        orderEdit.setTotalSum(newOrderSum);
                        orderEdit.setOrderSum(newOrderSum);
                        orderEdit.setDiscountSum(BigDecimal.valueOf(0D));
                        saleOrderService.update(orderEdit);
                    }

                    //增加客户余额
                    if (orderDB != null && customerId != null) {
                        String remarkTemp = "订单编号:{0} 退款金额:{1}";
                        String remark = MessageFormat.format(remarkTemp,
                                orderCode,
                                orderRetreatSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP)
                        );
                        saleReceiveRecordService.editCustomerBalanceByOrder(
                                customerId,
                                null,
                                //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
                                "3",
                                BigDecimal.valueOf(orderRetreatSum.doubleValue()),
                                cuser,
                                remark);
                    }
                }
            }
        }

        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelSaleRetreat(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("saleOrderReturn");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);
        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleOrderReturn";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }


    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel importExcelSaleRetreat(MultipartFile file) throws Exception{
        ResultModel model = new ResultModel();
        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
        || !(fileName.matches("^.+\\.(?i)(xlsx)$")
        || fileName.matches("^.+\\.(?i)(xls)$"))
        ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        return model;
    }

    ///////////////////////////////////////////////////////////////////

    /**
     *
     * 退货单明细表
     * deliverDetailId: rowData.id,
     * orderDetailId: rowData.orderDetaiId,
     * productId: rowData.productId,
     * orderSum: rowData.retreatOrderSum,
     * orderUnit: rowData.orderUnit,
     * orderCount: rowData.retreatOrderCount,
     * productUnit: rowData.productUnit,
     * remark: rowData.retreatRemark,
     *
     * sysOrderCode: rowData.sysOrderCode,
     * orderId: rowData.orderId,
     * receiveAmount: rowData.receiveAmount,
     * notRetreatSum: rowData.notRetreatSum,
     * n2pFormula: rowData.n2pFormula,
     * p2nFormula: rowData.p2nFormula,
     *
     * @param mapList
     * @return
     */
    private Map<String, String> findOrderCodeMap(List<Map<String, String>> mapList) {
        Map<String, String> orderMap = new HashMap<String, String>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            String orderId = mapObject.get("orderId");
            String orderCode = mapObject.get("sysOrderCode");
            if (orderCode != null && orderCode.trim().length() > 0) {
                orderMap.put(orderCode, orderId);
            }

        }

        return orderMap;
    }

    private Map<String, BigDecimal> findOrderAllowReceiveSumMap(List<Map<String, String>> mapList) {
        Map<String, BigDecimal> orderMap = new HashMap<String, BigDecimal>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            String orderCode = mapObject.get("sysOrderCode");

            BigDecimal allowReceiveSum = BigDecimal.valueOf(0D);
            String notRetreatSum_str = mapObject.get("notRetreatSum");
            if (notRetreatSum_str != null && notRetreatSum_str.trim().length() > 0) {
                try {
                    allowReceiveSum = new BigDecimal(notRetreatSum_str.trim());
                    //四舍五入到2位小数
                    allowReceiveSum = allowReceiveSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (orderCode != null && orderCode.trim().length() > 0) {
                orderMap.put(orderCode, allowReceiveSum);
            }
        }

        return orderMap;
    }

    private Map<String, BigDecimal> findOrderAllowReceiveAmountMap(List<Map<String, String>> mapList) {
        Map<String, BigDecimal> orderMap = new HashMap<String, BigDecimal>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        for (Map<String, String> mapObject : mapList) {
            String orderCode = mapObject.get("sysOrderCode");

            BigDecimal receiveAmount = BigDecimal.valueOf(0D);
            String receiveAmount_str = mapObject.get("receiveAmount");
            if (receiveAmount_str != null && receiveAmount_str.trim().length() > 0) {
                try {
                    receiveAmount = new BigDecimal(receiveAmount_str.trim());
                    //四舍五入到2位小数
                    receiveAmount = receiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (orderCode != null && orderCode.trim().length() > 0) {
                orderMap.put(orderCode, receiveAmount);
            }
        }

        return orderMap;
    }

    private Map<String, BigDecimal> findOrderRetreatSumMap(List<Map<String, String>> mapList) {
        Map<String, BigDecimal> orderMap = new HashMap<String, BigDecimal>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        //按照订单编号 汇总求和(退货金额)
        Map<String, BigDecimal> mapTemp = new HashMap<String, BigDecimal>();
        for (Map<String, String> mapObject : mapList) {
            String orderCode = mapObject.get("sysOrderCode");
            if (orderCode == null || orderCode.trim().length() == 0) {continue;}

            BigDecimal orderSum = BigDecimal.valueOf(0D);
            String orderSum_str = mapObject.get("orderSum");
            if (orderSum_str != null && orderSum_str.trim().length() > 0) {
                try {
                    orderSum = new BigDecimal(orderSum_str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (mapTemp.get(orderCode) == null) {
                mapTemp.put(orderCode, orderSum);
            } else {
                BigDecimal total = mapTemp.get(orderCode);
                total = BigDecimal.valueOf(total.doubleValue() + orderSum.doubleValue());
                mapTemp.put(orderCode, total);
            }
        }

        for (Iterator iterator = mapTemp.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            BigDecimal total = mapTemp.get(mapKey);
            //四舍五入到2位小数
            total = total.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            orderMap.put(mapKey, total);
        }

        return orderMap;
    }

    private Map<String, BigDecimal> findOrderIdRetreatSumMap(List<Map<String, String>> mapList) {
        Map<String, BigDecimal> orderMap = new HashMap<String, BigDecimal>();
        if (mapList == null || mapList.size() == 0) {return orderMap;}

        //按照订单id 汇总求和(退货金额)
        Map<String, BigDecimal> mapTemp = new HashMap<String, BigDecimal>();
        for (Map<String, String> mapObject : mapList) {
            String orderId = mapObject.get("orderId");
            if (orderId == null || orderId.trim().length() == 0) {continue;}

            BigDecimal orderSum = BigDecimal.valueOf(0D);
            String orderSum_str = mapObject.get("orderSum");
            if (orderSum_str != null && orderSum_str.trim().length() > 0) {
                try {
                    orderSum = new BigDecimal(orderSum_str.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (mapTemp.get(orderId) == null) {
                mapTemp.put(orderId, orderSum);
            } else {
                BigDecimal total = mapTemp.get(orderId);
                total = BigDecimal.valueOf(total.doubleValue() + orderSum.doubleValue());
                mapTemp.put(orderId, total);
            }
        }

        for (Iterator iterator = mapTemp.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            BigDecimal total = mapTemp.get(mapKey);
            //四舍五入到2位小数
            total = total.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            orderMap.put(mapKey, total);
        }

        return orderMap;
    }


}



