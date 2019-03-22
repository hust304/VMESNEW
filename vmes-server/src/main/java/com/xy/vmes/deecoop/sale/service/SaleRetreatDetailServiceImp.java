package com.xy.vmes.deecoop.sale.service;


import com.xy.vmes.common.util.*;
import com.xy.vmes.deecoop.sale.dao.SaleRetreatDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_retreat_detail:退货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-02-25
*/
@Service
@Transactional(readOnly = false)
public class SaleRetreatDetailServiceImp implements SaleRetreatDetailService {

    @Autowired
    private SaleRetreatDetailMapper saleRetreatDetailMapper;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void save(SaleRetreatDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleRetreatDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public SaleRetreatDetail selectById(String id) throws Exception{
        return saleRetreatDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public List<SaleRetreatDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleRetreatDetail> warehouseCheckDetailList =  saleRetreatDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void update(SaleRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        saleRetreatDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateAll(SaleRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        saleRetreatDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleRetreatDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleRetreatDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleRetreatDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleRetreatDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    public List<SaleRetreatDetail> dataList(PageData pd) throws Exception {
        return saleRetreatDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return saleRetreatDetailMapper.getDataListPage(pd, pg);
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
    public List<SaleRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleRetreatDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleRetreatDetail findSaleOrderReturnDetail(PageData object) throws Exception {
        List<SaleRetreatDetail> objectList = this.findSaleOrderReturnDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleRetreatDetail findSaleOrderReturnDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrderReturnDetail(findMap);
    }

    public List<SaleRetreatDetail> findSaleOrderReturnDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<SaleRetreatDetail> findSaleOrderReturnDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleOrderReturnDetailList(findMap);
    }

    public List<SaleRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleRetreatDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleRetreatDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleRetreatDetail detail = (SaleRetreatDetail) HttpUtils.pageData2Entity(mapObject, new SaleRetreatDetail());

            //orderCount 退货数量(订单单位)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            detail.setOrderCount(orderCount);

            //计价转换计量单位 数量转换公式 p2nFormula
            String p2nFormula = mapObject.get("p2nFormula");
            BigDecimal valueBig = BigDecimal.valueOf(0D);
            //P(计价单位) --> N(计量单位)
            if (p2nFormula != null && p2nFormula.trim().length() > 0) {
                valueBig = EvaluateUtil.countFormulaP2N(orderCount, p2nFormula);
            }
            //productCount 退货数量(计量数量)
            detail.setProductCount(valueBig);

            objectList.add(detail);
        }

        return objectList;
    }

    public BigDecimal findTotalSumByDetailList(List<SaleRetreatDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleRetreatDetail detail : objectList) {
            //orderSum 退货金额
            double orderSum_double = 0D;
            if (detail.getOrderSum() != null) {
                orderSum_double = detail.getOrderSum().doubleValue();
            }

            totalSum_double = totalSum_double + orderSum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    public WarehouseInDetail retreatDetail2InDetail(SaleRetreatDetail retreatDetail, WarehouseInDetail inDetail) {
        if (inDetail == null) {inDetail = new WarehouseInDetail();}
        if (retreatDetail == null) {return inDetail;}

        //productId 产品ID
        inDetail.setProductId(retreatDetail.getProductId());
        //count 入库数量 (订单明细 计量单位数量)
        inDetail.setCount(retreatDetail.getProductCount());
        //businessId 业务id(退货明细id)
        inDetail.setBusinessId(retreatDetail.getId());

        return inDetail;
    }

    public List<WarehouseInDetail> retreatDtlList2InDtlList(List<SaleRetreatDetail> retreatDtlList, List<WarehouseInDetail> inDtlList) {
        if (inDtlList == null) {inDtlList = new ArrayList<WarehouseInDetail>();}
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return inDtlList;}

        for (SaleRetreatDetail retreatDtl : retreatDtlList) {
            WarehouseInDetail inDetail = this.retreatDetail2InDetail(retreatDtl, null);
            inDtlList.add(inDetail);
        }

        return inDtlList;
    }

    public List<SaleReceiveDetail> retreatMap2ReceiveDtlList(Map<String, BigDecimal> orderRetreatSumMap, List<SaleReceiveDetail> receiveDtlList) {
        if (receiveDtlList == null) {receiveDtlList = new ArrayList<SaleReceiveDetail>();}
        if (orderRetreatSumMap == null || orderRetreatSumMap.size() == 0) {return receiveDtlList;}

        for (Iterator iterator = orderRetreatSumMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();

            SaleReceiveDetail receiveDetail = new SaleReceiveDetail();
            receiveDetail.setOrderId(mapKey);
            //状态(0:待收款 1:已收款 -1:已取消)
            receiveDetail.setState("1");

            //receiveAmount 实收金额
            BigDecimal receiveAmount = BigDecimal.valueOf(0D);
            if (orderRetreatSumMap.get(mapKey) != null && orderRetreatSumMap.get(mapKey).doubleValue() != 0D) {
                receiveAmount = BigDecimal.valueOf(orderRetreatSumMap.get(mapKey).doubleValue() * -1) ;

                //四舍五入到2位小数
                receiveAmount = receiveAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                receiveDetail.setReceiveAmount(receiveAmount);
            }

            receiveDtlList.add(receiveDetail);
        }

        return receiveDtlList;
    }

    public Map<String, Map<String, BigDecimal>> findOrderDtlRetreatCountMap(List<SaleRetreatDetail> objectList) {
        Map<String, Map<String, BigDecimal>> mapObject = new HashMap<String, Map<String, BigDecimal>>();
        if (objectList == null || objectList.size() == 0) {return mapObject;}

        for (SaleRetreatDetail object : objectList) {
            String orderDtlId = object.getOrderDetailId();

            Map<String, BigDecimal> retreatMap = new HashMap<String, BigDecimal>();
            //orderCount 退货数量(订单单位)
            BigDecimal orderCount = object.getOrderCount();
            retreatMap.put("orderCount", orderCount);

            //orderSum 退货金额
            BigDecimal orderSum = object.getOrderSum();
            retreatMap.put("orderSum", orderSum);

            mapObject.put(orderDtlId, retreatMap);
        }

        return mapObject;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 验证入库单明细状态 (0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * @param retreatId 退货单id
     * @return
     */
    public String checkInDetailStateByRetreatId(String retreatId) throws Exception {
        if (retreatId == null || retreatId.trim().length() == 0) {return new String();}

        PageData findMap = new PageData();
        findMap.put("isNeedRetreat", "true");
        findMap.put("retreatId", retreatId);
        //入库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        findMap.put("queryStr", "state in ('1','2')");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseInDetail> inDetailLiset = warehouseInDetailService.dataList(findMap);
        if (inDetailLiset != null && inDetailLiset.size() > 0) {
            return new String("当前退货单含有(执行中,已完成)入库单，不可取消退货单");
        }

        return new String();
    }

    public String findOrderDtlIdsByRetreatDtlList(List<SaleRetreatDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (SaleRetreatDetail object : objectList) {
            String orderDtlId = object.getOrderDetailId();
            if (orderDtlId != null && orderDtlId.trim().length() > 0)  {
                strBuf.append(orderDtlId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strTemp;
    }

    public void addSaleRetreatDetail(SaleRetreat parentObj, List<SaleRetreatDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (SaleRetreatDetail detail : objectList) {
            //退货明细状态 (0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }

    public void updateStateByDetail(PageData pd) throws Exception {
        saleRetreatDetailMapper.updateStateByDetail(pd);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleRetreatDetailMapper.updateStateByDetail(pageData);
    }

    public void updateOrderByRetreat(Map<String, Map<String, BigDecimal>> orderDtlRetreatMap, List<SaleOrderDetail> orderDtlList) throws Exception {
        if (orderDtlRetreatMap == null || orderDtlRetreatMap.size() == 0) {return;}
        if (orderDtlList == null || orderDtlList.size() == 0) {return;}

        Map<String, String> orderMap = new HashMap<String, String>();
        for (SaleOrderDetail orderDetail : orderDtlList) {
            SaleOrderDetail orderDetailEdit = new SaleOrderDetail();

            String orderId = orderDetail.getParentId();
            orderMap.put(orderId, orderId);

            String orderDtlId = orderDetail.getId();
            orderDetailEdit.setId(orderDtlId);

            //orderCount 订单订购数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (orderDetail.getOrderCount() != null) {
                orderCount = orderDetail.getOrderCount();
            }

            //productSum 货品金额(订购数量 * 货品单价)
            BigDecimal productSum = BigDecimal.valueOf(0D);
            if (orderDetail.getProductSum() != null) {
                productSum = orderDetail.getProductSum();
            }

            //orderCount 退货数量(订单单位)
            Map<String, BigDecimal> retreatMap = orderDtlRetreatMap.get(orderDtlId);
            BigDecimal retreatOrderCount = BigDecimal.valueOf(0D);
            if (retreatMap.get("orderCount") != null) {
                retreatOrderCount = retreatMap.get("orderCount");
            }

            //orderSum 退货金额
            BigDecimal retreatOrderSum = BigDecimal.valueOf(0D);
            if (retreatMap.get("orderSum") != null) {
                retreatOrderSum = retreatMap.get("orderSum");
            }

            orderCount = BigDecimal.valueOf(orderCount.doubleValue() - retreatOrderCount.doubleValue());
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDetailEdit.setOrderCount(orderCount);

            productSum = BigDecimal.valueOf(productSum.doubleValue() - retreatOrderSum.doubleValue());
            //四舍五入到2位小数
            productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            orderDetailEdit.setProductSum(productSum);

            saleOrderDetailService.update(orderDetailEdit);
        }

        //修改订单
        for (Iterator iterator = orderMap.keySet().iterator(); iterator.hasNext();) {
            SaleOrder orderEdit = new SaleOrder();

            String orderId = (String) iterator.next();
            orderEdit.setId(orderId);

            List<SaleOrderDetail> orderDetailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
            if (orderDetailList == null || orderDetailList.size() == 0) {continue;}

            //订单明细总金额
            BigDecimal totalSum = saleOrderDetailService.findTotalSumByPrice(orderDetailList);

            //discountSum折扣金额
            orderEdit.setDiscountSum(BigDecimal.valueOf(0D));
            //totalSum 合计金额
            orderEdit.setTotalSum(totalSum);
            //orderSum 订单金额
            orderEdit.setOrderSum(totalSum);

            String remark = "";
            SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
            if (orderDB.getRemark() != null && orderDB.getRemark().trim().length() > 0) {
                remark = orderDB.getRemark().trim();
            }

            String tempStr = "退货单审核通过：修改订单数量和订单金额{0}";
            String msgStr = MessageFormat.format(
                    tempStr,
                    DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT)
            );
            remark = remark + msgStr;
            orderEdit.setRemark(remark);

            saleOrderService.update(orderEdit);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleRetreatDetail(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleRetreatDetail");
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

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelSaleRetreatDetail(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("saleOrderReturnDetail");
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
            fileName = "ExcelSaleOrderReturnDetail";
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
    public ResultModel importExcelSaleRetreatDetail(MultipartFile file) throws Exception{
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


}



