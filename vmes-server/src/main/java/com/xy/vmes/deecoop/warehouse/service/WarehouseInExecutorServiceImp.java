package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInExecutorMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_executor:入库明细执行人 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-31
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInExecutorServiceImp implements WarehouseInExecutorService {


    @Autowired
    private WarehouseInExecutorMapper warehouseInExecutorMapper;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private TaskService taskService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void save(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setId(Conv.createUuid());
        warehouseInExecute.setCdate(new Date());
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.insert(warehouseInExecute);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void update(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.updateById(warehouseInExecute);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void updateAll(WarehouseInExecutor warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecutorMapper.updateAllColumnById(warehouseInExecute);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInExecutorMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInExecutorMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<WarehouseInExecutor> dataList(PageData pd) throws Exception{
        return warehouseInExecutorMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInExecutorMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<WarehouseInExecutor> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseInExecutor> warehouseInExecuteList =  warehouseInExecutorMapper.selectByMap(columnMap);
        return warehouseInExecuteList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInExecutorMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 获取入库明细执行人列表(添加入库执行)
     * @param pd
     * @return
     * @throws Exception
     */
    public List<Map> findListWarehouseInExecutorByAddExecute(PageData pd) throws Exception {
        return warehouseInExecutorMapper.findListWarehouseInExecutorByAddExecute(pd);
    }

    public WarehouseInExecutor findWarehouseInExecutor(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecutor> objectList = this.findWarehouseInExecutorList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInExecutor findWarehouseInExecutorById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecutor(findMap);
    }

    public List<WarehouseInExecutor> findWarehouseInExecutorList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecutor> objectList = new ArrayList<WarehouseInExecutor>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }
    public List<WarehouseInExecutor> findWarehouseInExecutorListByDetailId(String detailId) {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecutorList(findMap);
    }

    public void addWarehouseInExecutor(WarehouseInDetailEntity detail, String userIds) {
        if (detail == null) {return;}
        if (detail.getId() == null || detail.getId().trim().length() == 0) {return;}
        if (userIds == null || userIds.trim().length() == 0) {return;}

        userIds = StringUtil.stringTrimSpace(userIds);
        String[] strArry = userIds.split(",");

        for (String userId : strArry) {
            WarehouseInExecutor object = new WarehouseInExecutor();
            object.setCuser(detail.getCuser());
            object.setDetailId(detail.getId());
            object.setExecutorId(userId);

            Task task = taskService.warehouseInDtl2Task(detail, null);
            task.setExecutorId(userId);
            try {
                this.save(object);
                taskService.save(task);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public ResultModel listPageWarehouseInExecutor(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInExecutor");
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

        pd.put("orderStr", "executor.cdate asc");
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

    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap, String companyId) throws Exception {
        String productId = (String)firstRowMap.get("productId");
        String warehouseId = (String)firstRowMap.get("warehouseId");
        String detailId = (String)firstRowMap.get("id");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("productId", productId);
        findMap.put("warehouseId", warehouseId);
        findMap.put("companyId", companyId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = this.findListWarehouseInExecutorByAddExecute(findMap);
        if(varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)secondTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("pid",firstRowMap.get("id").toString());
                secondMapList.add(varMap);

            }
        }

        return secondMapList;
    }

    @Override
    public ResultModel findListByWarehouseInExecutor(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String firstFieldCode = pd.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }

        Map<String, Object> firstTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        result.put("hideTitles",firstTitleMap.get("hideTitles"));
        result.put("titles",firstTitleMap.get("titles"));

        //B. 第二级: 获取入库单明细执行人Title列表
        columnList = columnService.findColumnList("warehouseInExecutorByAddExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String secondFieldCode = pd.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }

        Map<String, Object> secondTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //C. 查询第一层数据
        String companyId = pd.getString("currentCompanyId");

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)firstTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("hideTitles", secondTitleMap.get("hideTitles"));
                varMap.put("titles", secondTitleMap.get("titles"));
                varMap.put("pid", null);
                //查询第二层数据
                varMap.put("children", this.findSecondList(map, secondTitleMap ,companyId));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel updateExecutor(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pd.getString("cuser");
        String detailId = pd.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String executorIds = pd.getString("executorIds");
        if (executorIds == null || executorIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<WarehouseInExecute> executeLiset = warehouseInExecuteService.findWarehouseInExecuteList(findMap);
        if(executeLiset != null && executeLiset.size() > 0) {
            model.putCode("1");
            model.putMsg("该入库单执行人已开始执行，不可修改执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }

        List<WarehouseInExecutor> executorLiset = this.findWarehouseInExecutorList(findMap);
        for (WarehouseInExecutor executor : executorLiset) {
            executor.setIsdisable("0");
            executor.setRemark("执行人变更");
            this.update(executor);
        }

        String[] executorIdArr = executorIds.split(",");
        for (String executorId : executorIdArr) {
            WarehouseInExecutor executor = new WarehouseInExecutor();
            executor.setCuser(cuser);
            executor.setDetailId(detailId);
            executor.setExecutorId(executorId);
            this.save(executor);
        }

        return model;
    }
}



