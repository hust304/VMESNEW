package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchaseSignMapper;
import com.xy.vmes.entity.PurchaseSign;
import com.xy.vmes.entity.PurchaseSignDetail;
import com.xy.vmes.service.PurchaseSignDetailService;
import com.xy.vmes.service.PurchaseSignService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.*;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_purchase_sign:采购签收 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-03-12
*/
@Service
@Transactional(readOnly = false)
public class PurchaseSignServiceImp implements PurchaseSignService {
    @Autowired
    private PurchaseSignMapper purchaseSignMapper;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private PurchaseSignDetailService purchaseSignDetailService;

//    /**
//     * 创建人：陈刚 自动创建，禁止修改
//     * 创建时间：2019-12-05
//     */
//    @Override
//    public void save(PurchaseSign object) throws Exception {
//        object.setId(Conv.createUuid());
//        object.setCdate(new Date());
//        object.setUdate(new Date());
//        purchaseSignMapper.insert(object);
//    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public PurchaseSign selectById(String id) throws Exception{
        return purchaseSignMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<PurchaseSign> selectByColumnMap(Map columnMap) throws Exception {
        List<PurchaseSign> warehouseCheckDetailList = purchaseSignMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(PurchaseSign object) throws Exception {
        object.setUdate(new Date());
        purchaseSignMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(PurchaseSign object) throws Exception {
        object.setUdate(new Date());
        purchaseSignMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        purchaseSignMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        purchaseSignMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        purchaseSignMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        purchaseSignMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<PurchaseSign> dataList(PageData pd) throws Exception {
        return purchaseSignMapper.dataList(pd);
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
            return purchaseSignMapper.getDataListPage(pd);
        } else if (pg != null) {
            return purchaseSignMapper.getDataListPage(pd,pg);
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
    public List<PurchaseSign> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchaseSign>();
        }

        return this.dataList(pageData);
    }

    public PurchaseSign findPurchaseSign(PageData object) throws Exception {
        List<PurchaseSign> objectList = this.findPurchaseSignList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchaseSign findPurchaseSignById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPurchaseSign(findMap);
    }
    public List<PurchaseSign> findPurchaseSignList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPagePurchaseSign(PageData pd) throws Exception{
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("PurchaseSign");
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
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////
//    /**
//     * 创建采购签收单及签收明细
//     *
//     * @param cuser      当前用户id
//     * @param companyId  企业id
//     * @param orderId    采购订单id
//     * @param valueMap   参数Map<String, Object>
//     *   businessByInMap: 入库货品数据Map
//     *   jsonMapList：    签收界面传回json数据
//     * @throws Exception
//     */
//    public void createPurchaseSign(String cuser,
//                                   String companyId,
//                                   String orderId,
//                                   Map<String, Object> valueMap) throws Exception {
//        //创建签收单
//        PurchaseSign purchaseSign =  new PurchaseSign();
//        purchaseSign.setSdate(new Date());
//        purchaseSign.setSignId(cuser);
//        purchaseSign.setCuser(cuser);
//        purchaseSign.setCompanyId(companyId);
//        purchaseSign.setOrderId(orderId);
//        this.save(purchaseSign);
//
//        //业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
//        // 货品Map<String, Object>
//        //     productId: 货品id
//        //     inDtlId:   入库明细id
//        //     inCount:   入库数量
//        Map<String, Map<String, Object>> businessByInMap = (Map<String, Map<String, Object>>)valueMap.get("businessByInMap");
//
//        List<Map<String, String>> jsonMapList = (List<Map<String, String>>)valueMap.get("jsonMapList");
//        if (jsonMapList != null && jsonMapList.size() > 0) {
//            for (Map<String, String> jsonObject : jsonMapList) {
//                PurchaseSignDetail purchaseSignDetail = new PurchaseSignDetail();
//
//                String orderDetailId = jsonObject.get("orderDetailId");
//                purchaseSignDetail.setOrderDetailId(orderDetailId);
//
//                String productId = jsonObject.get("productId");
//                purchaseSignDetail.setProductId(productId);
//
//                if (businessByInMap != null && businessByInMap.get(orderDetailId) != null) {
//                    Map<String, Object> productInMap = businessByInMap.get(orderDetailId);
//                    purchaseSignDetail.setInDetailId((String)productInMap.get("inDtlId"));
//                }
//
//                //到货数量 count := inCount 入库数量
//                BigDecimal count = BigDecimal.valueOf(0D);
//                String countStr = jsonObject.get("count");
//                if (countStr != null && countStr.trim().length() > 0) {
//                    try {
//                        count = new BigDecimal(countStr);
//                        //四舍五入到2位小数
//                        count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//                purchaseSignDetail.setArriveCount(count);
//
//                purchaseSignDetail.setParentId(purchaseSign.getId());
//                purchaseSignDetail.setCuser(purchaseSign.getCuser());
//                purchaseSignDetailService.save(purchaseSignDetail);
//            }
//        }
//    }


}



