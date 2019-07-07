package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutExecutorMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.xy.vmes.entity.WarehouseOutExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.xy.vmes.service.WarehouseOutExecutorService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.yvan.Conv;

/**
* 说明：出库执行人 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-01
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutExecutorServiceImp implements WarehouseOutExecutorService {


    @Autowired
    private WarehouseOutExecutorMapper warehouseOutExecutorMapper;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void save(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setId(Conv.createUuid());
        warehouseOutExecutor.setCdate(new Date());
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.insert(warehouseOutExecutor);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void update(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.updateById(warehouseOutExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateAll(WarehouseOutExecutor warehouseOutExecutor) throws Exception{
        warehouseOutExecutor.setUdate(new Date());
        warehouseOutExecutorMapper.updateAllColumnById(warehouseOutExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutExecutor", key = "''+#id")
    public WarehouseOutExecutor selectById(String id) throws Exception{
        return warehouseOutExecutorMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutExecutorMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutExecutorMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutExecutorMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> dataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutExecutorMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutExecutorMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<WarehouseOutExecutor> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutExecutor> warehouseOutExecutorList =  warehouseOutExecutorMapper.selectByMap(columnMap);
        return warehouseOutExecutorList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutExecutorMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutExecutorMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutExecutorMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-01
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Override
    public ResultModel updateExecutor(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pd.getString("detailId");
        String executorIds = pd.getString("executorIds");
        pd.put("queryStr","detail_id ='"+detailId+"' and isdisable = '1' ");
        pd.put("mapSize", Integer.valueOf(pd.size()));
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataList(pd);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            model.putCode("1");
            model.putMsg("该出库单执行人已开始出库，不能直接更换执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }

        if(!StringUtils.isEmpty(executorIds)){
            String[] executorIdArr = executorIds.split(",");
            if(executorIdArr!=null&&executorIdArr.length>0){
                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                List<WarehouseOutExecutor> warehouseOutExecutorList = this.selectByColumnMap(columnMap);
                if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
                    for(int i=0;i<warehouseOutExecutorList.size();i++){
                        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                        warehouseOutExecutor.setIsdisable("0");
                        warehouseOutExecutor.setRemark("执行人变更");
                        this.update(warehouseOutExecutor);
                    }
                }

                for(int i=0;i<executorIdArr.length;i++){
                    WarehouseOutExecutor warehouseOutExecutor = new WarehouseOutExecutor();
                    warehouseOutExecutor.setDetailId(detailId);
                    warehouseOutExecutor.setExecutorId(executorIdArr[i]);
                    this.save(warehouseOutExecutor);
                }
            }
        }else {
            model.putCode("2");
            model.putMsg("未勾选记录，请重新选择！");
            return model;
        }

        return model;
    }

    @Override
    public ResultModel listPageWarehouseOutExecutors(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutExecutor");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addWarehouseOutExecutorBySimple(List<WarehouseOutDetail> outDtlList) throws Exception {
        if (outDtlList == null || outDtlList.size() == 0) {return;}

        for (WarehouseOutDetail outDetail : outDtlList) {
            WarehouseOutExecutor outExecutor = new WarehouseOutExecutor();

            outExecutor.setDetailId(outDetail.getId());
            outExecutor.setExecutorId(outDetail.getCuser());
            outExecutor.setCuser(outDetail.getCuser());

            this.save(outExecutor);
        }
    }



}



