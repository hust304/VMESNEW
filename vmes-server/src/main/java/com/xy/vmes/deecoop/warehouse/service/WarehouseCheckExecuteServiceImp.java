package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckExecuteMapper;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.xy.vmes.service.*;
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
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckExecuteServiceImp implements WarehouseCheckExecuteService {


    @Autowired
    private WarehouseCheckExecuteMapper warehouseCheckExecuteMapper;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheckExecute object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheckExecute selectById(String id) throws Exception{
        return warehouseCheckExecuteMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheckExecute> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheckExecute> warehouseCheckDetailList =  warehouseCheckExecuteMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheckExecute object) throws Exception{
        object.setUdate(new Date());
        warehouseCheckExecuteMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckExecuteMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckExecuteMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckExecuteMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<WarehouseCheckExecute> dataList(PageData pd) throws Exception {
        return warehouseCheckExecuteMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.getDataListPage(pd, pg);
    }
    public List<Map> findListWarehouseCheckExecuteByAudit(PageData pd, Pagination pg) throws Exception {
        return warehouseCheckExecuteMapper.findListWarehouseCheckExecuteByAudit(pd, pg);
    }

    public WarehouseCheckExecute findWarehouseCheckExecute(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheckExecute> objectList = this.findWarehouseCheckExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseCheckExecute findWarehouseCheckExecuteById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecute(findMap);
    }

    public List<WarehouseCheckExecute> findWarehouseCheckExecuteList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }
    public List<WarehouseCheckExecute> findWarehouseCheckExecuteListByDetailId(String detailId) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheckExecuteList(findMap);
    }

    @Override
    public ResultModel addWarehouseCheckExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String addExecuteJsonStr = pageData.getString("addExecuteJsonStr");
        if (addExecuteJsonStr == null || addExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(addExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细执行 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            if (execute.getCount() == null) {execute.setCount(BigDecimal.valueOf(0D));}
            execute.setExecutorId(cuser);
            execute.setCuser(cuser);
            //state:状态(0:待审核 2:同意 3:不同意)
            execute.setState("0");
            this.save(execute);

            //修改盘点明细状态
            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(execute.getDetailId());
            detail.setState("2");
            warehouseCheckDetailService.update(detail);
            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
        return model;
    }

    @Override
    public ResultModel rebackWarehouseCheckByDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String rebackDetailJsonStr = pageData.getString("rebackDetailJsonStr");

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        if (rebackDetailJsonStr == null || rebackDetailJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(rebackDetailJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细退单 Json字符串-转换成List错误！");
            return model;
        }

        List<WarehouseCheckDetail> detailList = new ArrayList<WarehouseCheckDetail>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckDetail detail = (WarehouseCheckDetail) HttpUtils.pageData2Entity(mapObject, new WarehouseCheckDetail());
            detailList.add(detail);
        }

        String msgStr = this.checkStateByDetailList(detailList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        this.rebackWarehouseCheck(detailList,remark,cuser);

        return model;
    }
    @Override
    public void rebackWarehouseCheck(List<WarehouseCheckDetail> detailList,String rebackBillReason,String cuser) throws Exception {

        Map<String, String> parentMap = new HashMap<String, String>();
        for (WarehouseCheckDetail detail : detailList) {
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setRemark(rebackBillReason);
            warehouseCheckDetailService.update(detail);

            //isdisable: 是否启用(0:已禁用 1:启用)
            warehouseCheckExecutorService.updateIsdisableByExecutor("0",
                    rebackBillReason,
                    null,
                    detail.getId(),
                    cuser);

            parentMap.put(detail.getParentId(), detail.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }
    }


    private String checkStateByDetailList(List<WarehouseCheckDetail> detailList) {
        StringBuffer msgBuf = new StringBuffer();
        if (detailList == null || detailList.size() == 0) {return msgBuf.toString();}

        String msgTemp = "第 {0} 行: 盘点明细状态({1})，盘点明细状态必须是(执行中)允许退回！" + Common.SYS_ENDLINE_DEFAULT;
        for (int i = 0; i < detailList.size(); i++) {
            WarehouseCheckDetail detail = detailList.get(i);
            //明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            if ("2,3".indexOf(detail.getState()) != -1) {
                String msgStr = MessageFormat.format(msgTemp,
                        (i+1),
                        Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detail.getState()));
                msgBuf.append(msgStr);
            }
        }

        return msgBuf.toString();
    }


}



