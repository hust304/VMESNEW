package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.FileService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_check_detail:仓库库存盘点明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-13
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckDetailServiceImp implements WarehouseCheckDetailService {

    @Autowired
    private WarehouseCheckDetailMapper warehouseCheckDetailMapper;
    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void save(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setId(Conv.createUuid());
        warehouseCheckDetail.setCdate(new Date());
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.insert(warehouseCheckDetail);
    }

    public void saveObject(WarehouseCheckDetail object) throws Exception {
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckDetail selectById(String id) throws Exception{
        return warehouseCheckDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckDetail> warehouseCheckDetailList =  warehouseCheckDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.updateById(warehouseCheckDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckDetail warehouseCheckDetail) throws Exception{
        warehouseCheckDetail.setUdate(new Date());
        warehouseCheckDetailMapper.updateAllColumnById(warehouseCheckDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckDetailMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-13
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateStateByDetail(String parentId, String state) {
        if (parentId == null || parentId.trim().length() == 0) {return;}
        if (state == null || state.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("parentId", parentId);
        pageData.put("state", state);
        warehouseCheckDetailMapper.updateStateByDetail(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckDetail> dataList(PageData pd) throws Exception{
        return warehouseCheckDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseCheckDetailMapper.getDataListPage(pd, pg);
    }

    public WarehouseCheckDetail findWarehouseCheckDetail(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckDetail> objectList = this.findWarehouseCheckDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseCheckDetail findWarehouseCheckDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckDetail(findMap);
    }

    public List<WarehouseCheckDetail> findWarehouseCheckDetailList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }

    public List<WarehouseCheckDetail> findWarehouseCheckDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckDetailList(findMap);
    }

    public List<WarehouseCheckDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseCheckDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseCheckDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseCheckDetail detail = (WarehouseCheckDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckDetail());
            objectList.add(detail);
        }

        return objectList;
    }

    public List<WarehouseCheckDetailEntity> mapList2DetailEntityList(List<Map<String, String>> mapList, List<WarehouseCheckDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseCheckDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseCheckDetailEntity detail = (WarehouseCheckDetailEntity) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckDetailEntity());
            objectList.add(detail);
        }

        return objectList;
    }

    public WarehouseCheckDetail warehouseCheckDtl2QRCodeObj(WarehouseCheckDetail warehouseCheckDtl, WarehouseCheckDetail QRCodeObj) {
        if (QRCodeObj == null) {QRCodeObj = new WarehouseCheckDetail();}
        if (warehouseCheckDtl == null) {return QRCodeObj;}

        QRCodeObj.setId(warehouseCheckDtl.getId());
        QRCodeObj.setParentId(warehouseCheckDtl.getParentId());
        QRCodeObj.setWarehouseProductId(warehouseCheckDtl.getWarehouseProductId());
        QRCodeObj.setProductId(warehouseCheckDtl.getProductId());
        QRCodeObj.setWarehouseId(warehouseCheckDtl.getWarehouseId());
        QRCodeObj.setCode(warehouseCheckDtl.getCode());

        return QRCodeObj;
    }
    /////////////////////////////////////////////////////////////
    /**
     * 获取业务id字符串(逗号分隔的字符串)
     *
     * @param mapList 业务id
     * @return
     */
    public String findBusinessIdByMapList(List<Map<String, String>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, String> mapObject : mapList) {
            String businessId = mapObject.get("businessId");
            if (businessId != null && businessId.trim().length() > 0) {
                strBuf.append(businessId);
                strBuf.append(",");
            }
        }

        String idsTemp = strBuf.toString();
        //去掉最后一个','
        if (idsTemp.lastIndexOf(",") != -1) {
            idsTemp = idsTemp.substring(0, idsTemp.lastIndexOf(","));
        }

        return idsTemp;
    }

    public void addWarehouseCheckDetail(WarehouseCheck parentObj, List<WarehouseProduct> objectList) throws Exception {
        if (parentObj == null || (parentObj.getId() == null || parentObj.getId().trim().length() == 0)) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseProduct warehouseProduct : objectList) {
            WarehouseCheckDetail detail = new WarehouseCheckDetail();

            String id = Conv.createUuid();
            detail.setId(id);
            detail.setParentId(parentObj.getId());
            detail.setWarehouseProductId(warehouseProduct.getId());
            detail.setCode(warehouseProduct.getCode());
            detail.setProductId(warehouseProduct.getProductId());
            detail.setWarehouseId(warehouseProduct.getWarehouseId());

            detail.setStockCount(BigDecimal.valueOf(0D));
            if (warehouseProduct.getStockCount() != null) {
                detail.setStockCount(warehouseProduct.getStockCount());
            }

            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setCuser(parentObj.getCuser());

            //获取二维码信息
            WarehouseCheckDetail QRCodeObj = this.warehouseCheckDtl2QRCodeObj(detail, null);
            String qrcode = fileService.createQRCode("warehouseCheck", YvanUtil.toJson(QRCodeObj));
            if (qrcode != null && qrcode.trim().length() > 0) {
                detail.setQrcode(qrcode);
            }

            this.saveObject(detail);
        }

    }

    /**
     * 根据盘点明细状态-反写盘点单状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param parent       入库单对象
     * @param dtlList      入库单明细List<WarehouseCheckDetail>
     * @param ignoreState  忽视状态
     */
    public void updateParentStateByDetailList(WarehouseCheck parent, List<WarehouseCheckDetail> dtlList, String ignoreState) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findWarehouseCheckDetailListByParentId(parent.getId());
        }

        if (dtlList != null && dtlList.size() == 0) {
            warehouseCheckService.deleteById(parent.getId());
        } else {
            //获取入库单状态-根据入库单明细状态
            String parentState = this.findParentStateByDetailList(ignoreState, dtlList);
            parent.setState(parentState);
            warehouseCheckService.update(parent);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 一条或多条相同，在盘点单明细List
     *   false: 全部不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public boolean isExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseCheckDetail object : objectList) {
            String dtl_state = object.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if ("-1".equals(dtl_state)) {dtl_state = "c";}

            //忽视状态:判断与明细状态 相同则继续执行循环
            if (ignoreState != null && ignoreState.trim().length() > 0 && ignoreState.indexOf(dtl_state) != -1) {continue;}

            if (state.indexOf(dtl_state) != -1) {
                return true;
            }
        }

        return false;
    }

    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 全部相同，在盘点单明细List
     *   false: 一条或多条不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseCheckDetail object : objectList) {
            String dtl_state = object.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if ("-1".equals(dtl_state)) {dtl_state = "c";}

            //忽视状态:判断与明细状态 相同则继续执行循环
            if (ignoreState != null && ignoreState.trim().length() > 0 && ignoreState.indexOf(dtl_state) != -1) {continue;}

            if (state.indexOf(dtl_state) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取盘点单状态-根据盘点明细状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param ignoreState  忽视状态
     * @param dtlList      盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    public String findParentStateByDetailList(String ignoreState, List<WarehouseCheckDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证入库单状态(1:已完成) --> 全部明细状态 (3:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "3";
        if (this.isAllExistStateByDetailList(checkDtlState, ignoreState, dtlList)) {
            return "1";
        }

        //2. 验证入库单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, null, dtlList)) {
            return "-1";
        }

        return parentState;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isAllAuditStateByDetailExecuteList(String state, List<Map<String, Object>> mapList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (mapList == null || mapList.size() == 0) {return false;}

        for (Map<String, Object> mapObject : mapList) {
            String executeState = (String)mapObject.get("executeState");
            if (executeState == null || executeState.trim().length() == 0) {return false;}

            if (!state.equals(executeState)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ResultModel listPageWarehouseCheckDetails(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("warehouseCheckDetail");
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
        if (columnList != null && columnList.size() > 0) {
            for (Column column : columnList) {
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
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

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel cancelWarehouseCheckDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细id为空或空字符串！");
            return model;
        }

        WarehouseCheckDetail detail = this.findWarehouseCheckDetailById(detailId);
        String detailState = detail.getState();
        if ("-1".equals(detailState)) {detailState = "c";}

        //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        if (detailState != null && "1,2,3".indexOf(detailState.trim()) != -1) {
            String msgTemp = "该盘点明细状态{0}，当前盘点明细不可取消！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detailState));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        detail.setState("-1");
        this.update(detail);

        //2.返写盘点单状态
        //获取盘点单状态-根据盘点明细状态 -- 忽视状态(-1:已取消)
        WarehouseCheck parent = new WarehouseCheck();
        parent.setId(detail.getParentId());
        if (parent != null) {
            this.updateParentStateByDetailList(parent, null, null);
        }
        return model;
    }

    @Override
    public ResultModel deleteWarehouseCheckDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细id为空或空字符串！");
            return model;
        }

        WarehouseCheckDetail detail = this.findWarehouseCheckDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        // 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        if (checkState != null && "1,2,3".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前盘点明细不可删除，该盘点明细状态(执行中,审核中,已完成)！");
            return model;
        }

        //1. 删除盘点明细
        this.deleteById(detailId);

        //2.返写盘点单状态
        //获取盘点单状态-根据盘点明细状态 -- 忽视状态(-1:已取消)
        WarehouseCheck parent = new WarehouseCheck();
        parent.setId(detail.getParentId());
        if (parent != null) {
            this.updateParentStateByDetailList(parent, null, null);
        }
        return model;
    }


}



