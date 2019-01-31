package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckExecutorMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.TaskService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckExecutorService;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckExecutorServiceImp implements WarehouseCheckExecutorService {


    @Autowired
    private WarehouseCheckExecutorMapper warehouseCheckExecutorMapper;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private TaskService taskService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheckExecutor object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckExecutor selectById(String id) throws Exception{
        return warehouseCheckExecutorMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckExecutor> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckExecutor> warehouseCheckDetailList =  warehouseCheckExecutorMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckExecutor object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckExecutor object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecutorMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckExecutorMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckExecutorMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckExecutorMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateIsdisableByExecutor(String isdisable,
                                          String remark,
                                          String parentId,
                                          String detailId,
                                          String executorId) {
        if (isdisable == null || isdisable.trim().length() == 0) {return;}
        if (detailId == null || detailId.trim().length() == 0) {return;}
        if (executorId == null || executorId.trim().length() == 0) {return;}

        PageData mapObject = new PageData();
        mapObject.put("isdisable", isdisable);
        mapObject.put("detailId", detailId);
        mapObject.put("executorId", executorId);
        if (parentId != null && parentId.trim().length() > 0) {
            mapObject.put("parentId", parentId);
        }
        if (remark != null && remark.trim().length() > 0) {
            mapObject.put("remark", remark);
        }

        warehouseCheckExecutorMapper.updateIsdisableByExecutor(mapObject);
    }
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<WarehouseCheckExecutor> dataList(PageData pd) throws Exception {
        return warehouseCheckExecutorMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecutorMapper.getDataListPage(pd, pg);
    }

    /**
     * 获取盘点明细执行人列表(添加盘点执行)
     * @param pd
     * @return
     * @throws Exception
     */
    public List<Map> findListWarehouseCheckExecutorByAddExecute(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecutorMapper.findListWarehouseCheckExecutorByAddExecute(pd, pg);
    }

    public WarehouseCheckExecutor findWarehouseCheckExecutor(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckExecutor> objectList = this.findWarehouseCheckExecutorList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseCheckExecutor findWarehouseCheckExecutorById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecutor(findMap);
    }

    public List<WarehouseCheckExecutor> findWarehouseCheckExecutorList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }
    public List<WarehouseCheckExecutor> findWarehouseCheckExecutorListByDetailId(String detailId) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecutorList(findMap);
    }

    public void addWarehouseCheckExecutor(WarehouseCheckDetailEntity detail, String userIds) throws Exception {
        if (detail == null) {return;}
        if (detail.getId() == null || detail.getId().trim().length() == 0) {return;}
        if (userIds == null || userIds.trim().length() == 0) {return;}

        userIds = StringUtil.stringTrimSpace(userIds);
        String[] strArry = userIds.split(",");

        for (String userId : strArry) {
            WarehouseCheckExecutor object = new WarehouseCheckExecutor();
            object.setParentId(detail.getParentId());
            object.setDetailId(detail.getId());
            object.setCuser(detail.getCuser());
            object.setExecutorId(userId);

            Task task = taskService.warehouseCheckDtl2Task(detail, null);
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
    public ResultModel findListByWarehouseCheckExecutor(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecutorByAddExecute");
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

        pd.put("orderStr", "executor.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findListWarehouseCheckExecutorByAddExecute(pd, pg);
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
    public ResultModel addWarehouseCheckExecutor(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = pageData.getString("currentCompanyId");
        String executeId = pageData.getString("executeId");
        if (executeId == null || executeId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "[{\"id\":\"6d1e4503db6f46bcb22249b29abd4e27\"},{\"id\":\"824cdac10bb54c7aa62441e55696597e\"}]";
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库单明细派单
        List<WarehouseCheckDetailEntity> detailList = warehouseCheckDetailService.mapList2DetailEntityList(mapList, null);

        String cuser = pageData.getString("cuser");
        for (WarehouseCheckDetailEntity dtlEntity : detailList) {
            dtlEntity.setCuser(cuser);
            dtlEntity.setCompanyId(companyId);

            //盘点明细分配执行人
            this.addWarehouseCheckExecutor(dtlEntity, executeId);

            WarehouseCheckDetail detail = new WarehouseCheckDetail();
            detail.setId(dtlEntity.getId());
            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("1");
            warehouseCheckDetailService.update(detail);
        }
        return model;
    }
}



