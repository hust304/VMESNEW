package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInDetailMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseInDetailEntity;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_detail:仓库入库单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInDetailServiceImp implements WarehouseInDetailService {
    @Autowired
    private WarehouseInDetailMapper warehouseInDetailMapper;
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setCdate(new Date());
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.insert(warehouseInDetail);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.updateById(warehouseInDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.updateAllColumnById(warehouseInDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInDetailMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    @Override
    public List<WarehouseInDetail> dataList(PageData pd) throws Exception{
        return warehouseInDetailMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseInDetail> warehouseInDetailList =  warehouseInDetailMapper.selectByMap(columnMap);
        return warehouseInDetailList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInDetailMapper.getDataListPage(pd, pg);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    @Override
    public void updateStateByDetail(PageData pd) throws Exception{
        warehouseInDetailMapper.updateStateByDetail(pd);
    }

    public WarehouseInDetail findWarehouseInDetail(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInDetail> objectList = this.findWarehouseInDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInDetail findWarehouseInDetailById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInDetail(findMap);
    }

    public List<WarehouseInDetail> findWarehouseInDetailList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInDetail> objectList = new ArrayList<WarehouseInDetail>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }
    public List<WarehouseInDetail> findWarehouseInDetailListByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInDetailList(findMap);
    }

    public List<WarehouseInDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseInDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInDetail detail = (WarehouseInDetail)HttpUtils.pageData2Entity(mapObject, new WarehouseInDetail());
            objectList.add(detail);
        }

        return objectList;
    }

    public List<WarehouseInDetailEntity> mapList2DetailEntityList(List<Map<String, String>> mapList, List<WarehouseInDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInDetailEntity detail = (WarehouseInDetailEntity)HttpUtils.pageData2Entity(mapObject, new WarehouseInDetailEntity());
            objectList.add(detail);
        }

        return objectList;
    }
    public WarehouseInDetail warehouseInDtl2QRCodeObj(WarehouseInDetail warehouseInDtl, WarehouseInDetail QRCodeObj) {
        if (QRCodeObj == null) {QRCodeObj = new WarehouseInDetail();}
        if (warehouseInDtl == null) {return QRCodeObj;}

        QRCodeObj.setProductId(warehouseInDtl.getProductId());
        QRCodeObj.setWarehouseId(warehouseInDtl.getWarehouseId());
        QRCodeObj.setCode(warehouseInDtl.getCode());

        return QRCodeObj;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String checkDispatcheDetailList(List<WarehouseInDetailEntity> objectList) {
        if (objectList == null || objectList.size() == 0) {
            return new String("请至少选择一条明细！");
        }

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            WarehouseInDetailEntity detail = objectList.get(i);
            if (detail.getWarehouseId() == null || detail.getWarehouseId().trim().length() == 0) {
                msgBuf.append("第 " + (i+1) + " 行：推荐库位为空，推荐库位必填项(系统无推荐货位，请指定或添加新货位)");
            }
        }

        return msgBuf.toString();
    }

    public void addWarehouseInDetail(WarehouseIn parentObj, List<WarehouseInDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        //获取批次号
        //PC+yyyyMMdd+00001 = 15位
        String code = coderuleService.createCoderCdateByDate(parentObj.getCompanyId(),
                "vmes_warehouse_in_detail",
                "yyyyMMdd",
                "PC");

        for (WarehouseInDetail detail : objectList) {
            String id = Conv.createUuid();
            detail.setId(id);
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            detail.setCode(code);

            this.save(detail);
        }
    }

    /**
     * 修改入库单明细状态(vmes_warehouse_in_detail)
     * state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * 入库执行明细(vmes_warehouse_in_execute)
     *     按照(detail_id:入库明细ID)汇总求和(count:当前入库数量)
     * 汇总数量 >= 入库数量  state:2:已完成
     *
     * @param detailList
     */
    public void updateStateWarehouseInDetail(List<WarehouseInDetail> detailList) throws Exception {
        if (detailList == null || detailList.size() == 0) {return;}

        //入库单ID
        String parentId = detailList.get(0).getParentId();

        //1. 根据(入库单ID)查询条件，获取仓库入库执行明细表-按照(入库明细ID)汇总求和
        Map<String, BigDecimal> mapObject = warehouseInExecuteService.findExecuteCountByParentId(parentId);

        //2. 修改入库单明细状态(vmes_warehouse_in_detail)
        for (WarehouseInDetail detail : detailList) {
            String detailId = detail.getId();
            BigDecimal executeCount = mapObject.get(detailId);

            //state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if (executeCount != null && detail.getCount() != null && executeCount.doubleValue() >= detail.getCount().doubleValue()) {
                detail.setState("2");
            } else if (executeCount != null && detail.getCount() != null && executeCount.doubleValue() < detail.getCount().doubleValue()) {
                detail.setState("1");
            }

            this.update(detail);
        }

        //3. 反写入库单(vmes_warehouse_in)状态
        WarehouseIn warehouseIn = new WarehouseIn();
        warehouseIn.setId(parentId);
        this.updateParentStateByDetailList(warehouseIn, detailList, null);
    }


    /**
     * 根据入库单明细状态-反写入库单状态
     * 入库单状态(0:未完成 1:已完成 -1:已取消)
     * 入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     *
     * @param parent       入库单对象
     * @param dtlList      入库单明细List<WarehouseInDetail>
     * @param ignoreState  忽视状态
     */
    public void updateParentStateByDetailList(WarehouseIn parent, List<WarehouseInDetail> dtlList, String ignoreState) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findWarehouseInDetailListByParentId(parent.getId());
        }

        if (dtlList.size() == 0) {
            warehouseInService.deleteById(parent.getId());
        } else {
            //获取入库单状态-根据入库单明细状态
            String parentState = this.findParentStateByDetailList(ignoreState, dtlList);
            parent.setState(parentState);
            warehouseInService.update(parent);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 入库单明细状态，在入库单明细List<WarehouseInDetail>中是否全部相同
     *   true : 全部相同，在入库单明细List
     *   false: 一条或多条不同，在入库单明细List
     *
     * @param state       明细状态-入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     * @param ignoreState 忽视状态(允许为空)
     * @param objectList  入库单明细List<WarehouseInDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseInDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseInDetail object : objectList) {
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
     * 获取入库单状态-根据入库单明细状态
     * 入库单状态(0:未完成 1:已完成 -1:已取消)
     * 入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     *
     * @param ignoreState  忽视状态
     * @param dtlList      入库单明细List<WarehouseInDetail>
     * @return
     */
    public String findParentStateByDetailList(String ignoreState, List<WarehouseInDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证入库单状态(1:已完成) --> 全部明细状态 (2:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "2";
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

    @Override
    public ResultModel listPageWarehouseInDetail(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
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

        pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd, pg);
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


    @Override
    public ResultModel listPageDetailProduct(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetailProduct");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
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

        PageData findMap = new PageData();
        findMap.put("orderStr", "a.cdate asc");


        String type = pd.getString("type");
        if (!"edit".equals(type)) {
            findMap.put("queryStr", "1=2");
        } else {
            String parentId = pd.getString("parentId");
            findMap.put("parentId", parentId);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(findMap, pg);
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

    @Override
    public ResultModel cancelWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();


        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单已经(已完成)！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        this.update(detail);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }
        return model;
    }

    @Override
    public ResultModel recoveryWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不是取消状态，不可恢复！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        this.update(detail);

        //2. 反写入库单主表状态
        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }
        return model;
    }

    @Override
    public ResultModel deleteWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (checkState != null && "1,2".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单已经(已完成)！");
            return model;
        }

        //1. 删除入库明细
        this.deleteById(detailId);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }

        return model;
    }
}



