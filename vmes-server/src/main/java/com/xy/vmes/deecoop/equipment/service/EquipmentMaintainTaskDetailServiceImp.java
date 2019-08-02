package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.deecoop.equipment.dao.EquipmentMaintainTaskDetailMapper;
import com.xy.vmes.entity.EquipmentMaintainTaskDetail;
import com.xy.vmes.service.EquipmentMaintainTaskDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentMaintainTaskOutDetailService;
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
* 说明：vmes_equipment_maintainTask_detail:设备保养任务明细表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-07-29
*/
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainTaskDetailServiceImp implements EquipmentMaintainTaskDetailService {

    @Autowired
    private EquipmentMaintainTaskDetailMapper equipmentMaintainTaskDetailMapper;
    @Autowired
    private EquipmentMaintainTaskOutDetailService maintainTaskOutDetailService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void save(EquipmentMaintainTaskDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        equipmentMaintainTaskDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public EquipmentMaintainTaskDetail selectById(String id) throws Exception{
        return equipmentMaintainTaskDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public List<EquipmentMaintainTaskDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<EquipmentMaintainTaskDetail> warehouseCheckDetailList = equipmentMaintainTaskDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void update(EquipmentMaintainTaskDetail object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainTaskDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void updateAll(EquipmentMaintainTaskDetail object) throws Exception{
        object.setUdate(new Date());
        equipmentMaintainTaskDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMaintainTaskDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMaintainTaskDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    public List<EquipmentMaintainTaskDetail> dataList(PageData pd) throws Exception{
        return equipmentMaintainTaskDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return equipmentMaintainTaskDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return equipmentMaintainTaskDetailMapper.getDataListPage(pd,pg);
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
    public List<EquipmentMaintainTaskDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<EquipmentMaintainTaskDetail>();
        }

        return this.dataList(pageData);
    }

    public EquipmentMaintainTaskDetail findMaintainTaskDetail(PageData object) throws Exception {
        List<EquipmentMaintainTaskDetail> objectList = this.findMaintainTaskDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public EquipmentMaintainTaskDetail findMaintainTaskDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findMaintainTaskDetail(findMap);
    }

    public List<EquipmentMaintainTaskDetail> findMaintainTaskDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<EquipmentMaintainTaskDetail> findMaintainTaskDetailListByTaskId(String taskId) throws Exception {
        if (taskId == null || taskId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("taskId", taskId);

        return this.findMaintainTaskDetailList(findMap);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<EquipmentMaintainTaskDetail> jsonMapList2DetailList(List<Map<String, String>> jsonMapList, List<EquipmentMaintainTaskDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<EquipmentMaintainTaskDetail>();}
        if (jsonMapList == null || jsonMapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : jsonMapList) {
            EquipmentMaintainTaskDetail detail = (EquipmentMaintainTaskDetail)HttpUtils.pageData2Entity(mapObject, new EquipmentMaintainTaskDetail());
            objectList.add(detail);
        }

        return objectList;
    }

    /**
     * 获取新的editJsonMap
     * Map<String, List<Map<String, String>>>
     *     notEqualZeroList: 退回数量(不等于零)List
     *     equalZeroList:    退回数量(等于零)List
     *
     * Map<String, String>
     *   receiveCount 领取数量
     *   applyCount   实际使用数量
     *   retreatCount 退回数量 := 领取数量 - 实际使用数量
     *
     * @param editJsonMapList
     * @return
     */
    public Map<String, List<Map<String, String>>> findNewEditJsonMap (List<Map<String, String>> editJsonMapList) {
        Map<String, List<Map<String, String>>> newEditJsonMap = new HashMap<String, List<Map<String, String>>>();

        //退回数量(不等于零)List
        List<Map<String, String>> notEqualZeroList = new ArrayList<Map<String, String>>();
        //退回数量(等于零)List
        List<Map<String, String>> equalZeroList = new ArrayList<Map<String, String>>();

        for (Map<String, String> mapObject : editJsonMapList) {
            //领取数量 receiveCount
            BigDecimal receiveCount = BigDecimal.valueOf(0D);
            String receiveCountStr = mapObject.get("receiveCount");
            if (receiveCountStr != null && receiveCountStr.trim().length() > 0) {
                try {
                    receiveCount = new BigDecimal(receiveCountStr);
                    //四舍五入到2位小数
                    receiveCount = receiveCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            mapObject.put("receiveCount", receiveCount.toString());

            //实际使用数量 applyCount
            BigDecimal applyCount = BigDecimal.valueOf(0D);
            String applyCountStr = mapObject.get("applyCount");
            if (applyCountStr != null && applyCountStr.trim().length() > 0) {
                try {
                    applyCount = new BigDecimal(applyCountStr);
                    //四舍五入到2位小数
                    applyCount = applyCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            mapObject.put("applyCount", applyCount.toString());

            //退回数量 retreatCount := 领取数量 - 实际使用数量
            BigDecimal retreatCount = BigDecimal.valueOf(receiveCount.doubleValue() - applyCount.doubleValue());
            //四舍五入到2位小数
            retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            mapObject.put("retreatCount", retreatCount.toString());

            if (0D != retreatCount.doubleValue()) {
                notEqualZeroList.add(mapObject);
            } else if (0D == retreatCount.doubleValue()) {
                equalZeroList.add(mapObject);
            }
        }

        newEditJsonMap.put("notEqualZeroList", notEqualZeroList);
        newEditJsonMap.put("equalZeroList", equalZeroList);

        return newEditJsonMap;
    }

    /**
     * 返回货品出库Map
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByOut(List<Map<String, String>> jsonMapList) {
        Map<String, Map<String, Object>> productByOutMap = new HashMap<String, Map<String, Object>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return productByOutMap;}

        for (Map<String, String> mapObject : jsonMapList) {
            String productId = mapObject.get("productId");

            //receiveCount 领取数量 := outCount 出库数量
            BigDecimal receiveCount = BigDecimal.valueOf(0D);
            String receiveCountStr = mapObject.get("receiveCount");
            if (receiveCountStr != null && receiveCountStr.trim().length() > 0) {
                try {
                    receiveCount = new BigDecimal(receiveCountStr);
                    //四舍五入到2位小数
                    receiveCount = receiveCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("outDtlId", null);
            productMap.put("outCount", receiveCount);

            productByOutMap.put(productId, productMap);
        }

        return productByOutMap;
    }

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByIn(List<Map<String, String>> jsonMapList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
        if (jsonMapList == null || jsonMapList.size() == 0) {return productByInMap;}

        for (Map<String, String> mapObject : jsonMapList) {
            String productId = mapObject.get("productId");

            //退回数量 retreatCount := inCount 入库数量
            BigDecimal retreatCount = BigDecimal.valueOf(0D);
            String retreatCountStr = mapObject.get("retreatCount");
            if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
                try {
                    retreatCount = new BigDecimal(retreatCountStr);
                    //四舍五入到2位小数
                    retreatCount = retreatCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", retreatCount);

            productByInMap.put(productId, productMap);
        }

        return productByInMap;
    }

    public void addMaintainTaskDetail(String cuser,
                                    List<EquipmentMaintainTaskDetail> objectList,
                                    Map<String, Map<String, Object>> productByOutMap) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}

        for (EquipmentMaintainTaskDetail detail : objectList) {
            String productId = detail.getProductId();
            detail.setCuser(cuser);

            Map<String, Object> productMap = productByOutMap.get(productId);
            //outDtlId:  出库明细id
            String outDtlId = new String();
            if (productMap != null && productMap.get("outDtlId") != null) {
                outDtlId = (String)productMap.get("outDtlId");
            }
            detail.setOutDtlId(outDtlId);

            //outCount:  出库数量
            if (productMap != null && productMap.get("outCount") != null) {
                BigDecimal outCount = (BigDecimal)productMap.get("outCount");
                detail.setOutCount(outCount);
            }

            this.save(detail);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageMaintainTaskDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintainTaskDetail");
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

    public ResultModel findListTaskDetailByOutDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintainTaskDetailByOutDetail");
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
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = maintainTaskOutDetailService.findTaskDetailByOutDetail(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }


}



