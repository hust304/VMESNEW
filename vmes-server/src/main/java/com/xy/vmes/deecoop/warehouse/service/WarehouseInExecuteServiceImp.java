package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInExecuteMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
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
import java.text.SimpleDateFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_execute:仓库入库执行明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInExecuteServiceImp implements WarehouseInExecuteService {


    @Autowired
    private WarehouseInExecuteMapper warehouseInExecuteMapper;
    @Autowired
    private WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setCdate(new Date());
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.insert(warehouseInExecute);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseInExecute warehouseInExecute) throws Exception{
        warehouseInExecute.setUdate(new Date());
        warehouseInExecuteMapper.updateAllColumnById(warehouseInExecute);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> dataList(PageData pd) throws Exception{
        return warehouseInExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseInExecute> warehouseInExecuteList =  warehouseInExecuteMapper.selectByMap(columnMap);
        return warehouseInExecuteList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseInExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInExecuteMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateIsdisableByExecute(String detailId, String isdisable) throws Exception {
        if (detailId == null || detailId.trim().length() == 0) {return;}
        if (isdisable == null || isdisable.trim().length() == 0) {return;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("isdisable", isdisable);
        warehouseInExecuteMapper.updateIsdisableByExecute(findMap);
    }

    /**
     * 获取入库执行明细列表(修改入库执行)
     * @param pd
     * @return
     */
    public List<Map> findListWarehouseInExecuteByEdit(PageData pd) throws Exception {
        return warehouseInExecuteMapper.findListWarehouseInExecuteByEdit(pd);
    }

    public List<Map<String, Object>> findSumcountByWarehouseInExecute(PageData object) {
        if (object == null) {return null;}
        return warehouseInExecuteMapper.findSumcountByWarehouseInExecute(object);
    }

    public Map<String, BigDecimal> findExecuteCountByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        Map<String, BigDecimal> mapObject = new HashMap<String, BigDecimal>();
        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        List<Map<String, Object>> mapList = this.findSumcountByWarehouseInExecute(findMap);
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> mapObj : mapList) {
                String detailId = (String)mapObj.get("detailId");
                BigDecimal count = (BigDecimal)mapObj.get("executeCount");
                if (detailId != null && count != null) {
                    mapObject.put(detailId, count);
                }
            }
        }

        return mapObject;
    }

    public WarehouseInExecute findWarehouseInExecute(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = this.findWarehouseInExecuteList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInExecute findWarehouseInExecuteById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecute(findMap);}

    public List<WarehouseInExecute> findWarehouseInExecuteList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInExecute> objectList = new ArrayList<WarehouseInExecute>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public List<WarehouseInExecute> findWarehouseInExecuteListByDetailId(String detailId) {
        if (detailId == null || detailId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInExecuteList(findMap);
    }

    public List<WarehouseInExecute> mapList2ExecuteList(List<Map<String, String>> mapList, List<WarehouseInExecute> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInExecute>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInExecute execute = (WarehouseInExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseInExecute());
            objectList.add(execute);
        }

        return objectList;
    }
    ///////////////////////////////////////////////////////////////////////////////
//    public BigDecimal findSumCountByExecuteList(List<WarehouseInExecute> objectList) {
//        double sumCount = 0D;
//        if (objectList != null && objectList.size() > 0) {
//            for (WarehouseInExecute object : objectList) {
//                if (object.getCount() != null) {
//                    sumCount = sumCount + object.getCount().doubleValue();
//                }
//            }
//        }
//
//        //四舍五入 2位小数
//        return BigDecimal.valueOf(sumCount).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//    }

    public String checkColumnExecuteList(List<WarehouseInExecute> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}
        String column_isnull = "第 {0} 行: {1}为空或{2}为空，({1},{2})为必填不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            WarehouseInExecute object = objectList.get(i);
            if ((object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0)
                || object.getCount() == null
            ) {
                String str_isnull = MessageFormat.format(column_isnull,
                        Integer.valueOf(i+1).toString(),
                        "实际货位ID",
                        "入库数量");
                msgBuf.append(str_isnull);
            }
        }

        return msgBuf.toString();
    }

    @Override
    public ResultModel batchAddWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String executeJsonStr = pageData.getString("executeJsonStr");
        if (executeJsonStr == null || executeJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一条入库数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(executeJsonStr);
        if(mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细执行 Json字符串-转换成List错误！");
            return model;
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (Map<String, Object> warehouseInDetailMap : mapList) {
                Object executeObj = warehouseInDetailMap.get("children");
                if (executeObj == null) {continue;}

                List executeList = (List)executeObj;
                if (executeList == null || executeList.size() == 0) {continue;}

                //入库单明细 warehouseInDetailMap
                //界面上 model_code := 'warehouseInDetail' 中获得
                String parentId = (String)warehouseInDetailMap.get("parentId");
                String productId = (String)warehouseInDetailMap.get("productId");
                String detailId = (String)warehouseInDetailMap.get("id");
                //批次号
                String code = (String)warehouseInDetailMap.get("code");

                //入库执行明细 executeMap
                // 界面上 model_code := 'warehouseInExecutorByAddExecute' 中获得
                for (int i = 0; i < executeList.size(); i++) {
                    Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);
                    //入库货位id warehouseId
                    String warehouseId = (String)executeMap.get("warehouseId");
                    //入库数量 count
                    String count = (String)executeMap.get("count");

                    BigDecimal count_Big = BigDecimal.valueOf(0D);
                    if (count != null && count.trim().length() > 0) {
                        try {
                            count_Big = new BigDecimal(count);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    //入库操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //货位批次号
                    inObject.setCode(code);
                    //产品ID
                    inObject.setProductId(productId);
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseId);

                    //库存变更日志
                    String executeId = Conv.createUuid();

                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setParentId(parentId);
                    loginfo.setDetailId(detailId);
                    loginfo.setExecuteId(executeId);
                    loginfo.setCompanyId(companyId);
                    loginfo.setCuser(cuser);
                    //operation 操作类型(add:添加 modify:修改 delete:删除:)
                    loginfo.setOperation("add");

                    //beforeCount 操作变更前数量(业务相关)
                    loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                    //afterCount 操作变更后数量(业务相关)
                    loginfo.setAfterCount(count_Big);

                    String msgStr = warehouseProductService.inStockCount(inObject, count_Big, loginfo);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                    } else {
                        WarehouseInExecute execute = new WarehouseInExecute();
                        execute.setId(executeId);
                        execute.setDetailId(detailId);
                        execute.setWarehouseId(warehouseId);
                        execute.setExecutorId(cuser);
                        execute.setCount(count_Big);
                        execute.setCuser(cuser);
                        this.save(execute);

                        Product product = productService.findProductById(productId);
                        BigDecimal prodCount = BigDecimal.valueOf(0D);
                        if (product.getStockCount() != null) {
                            prodCount = product.getStockCount();
                        }

                        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count_Big.doubleValue());
                        productService.updateStockCount(product, prodStockCount, cuser);
                    }
                }

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
                warehouseInDetailService.updateStateWarehouseInDetail(detailList);
            }

        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串");
            return model;
        }
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串");
            return model;
        }
        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串");
            return model;
        }
        String code = pageData.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串");
            return model;
        }

        //入库数量 count
        String count = pageData.getString("count");
        BigDecimal countBig = BigDecimal.valueOf(0D);
        if (count == null || count.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库数量为空或空字符串！");
            return model;
        } else {
            try {
                BigDecimal doubleBig = new BigDecimal(count);
                if (doubleBig.doubleValue() < 0) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                    return model;
                }
                countBig = doubleBig;
            } catch (NumberFormatException numberExc) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                return model;
            }
        }


        StringBuffer msgBuf = new StringBuffer();
        try {
            //入库操作
            WarehouseProduct inObject = new WarehouseProduct();
            //货位批次号
            inObject.setCode(code);
            //产品ID
            inObject.setProductId(productId);
            //(实际)货位ID
            inObject.setWarehouseId(warehouseId);

            //库存变更日志
            String executeId = Conv.createUuid();

            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId(parentId);
            loginfo.setDetailId(detailId);
            loginfo.setExecuteId(executeId);
            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除:)
            loginfo.setOperation("add");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(BigDecimal.valueOf(0D));
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(countBig);

            String msgStr = warehouseProductService.inStockCount(inObject, countBig, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                msgBuf.append( "入库操作失败:" + msgStr);
            } else {
                WarehouseInExecute execute = new WarehouseInExecute();
                execute.setId(executeId);
                execute.setDetailId(detailId);
                execute.setWarehouseId(warehouseId);
                execute.setExecutorId(cuser);
                execute.setCount(countBig);
                execute.setCuser(cuser);
                this.save(execute);

                Product product = productService.findProductById(productId);
                BigDecimal prodCount = BigDecimal.valueOf(0D);
                if (product.getStockCount() != null) {
                    prodCount = product.getStockCount();
                }

                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + countBig.doubleValue());
                productService.updateStockCount(product, prodStockCount, cuser);

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
                warehouseInDetailService.updateStateWarehouseInDetail(detailList);
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }
        return model;
    }

    @Override
    public ResultModel rebackWarehouseInExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("rebackRemark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

        //根据入库单明细id-获取该入库单明细中-所有入库执行List
        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("executorId", cuser);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseInExecute> executeList = this.findWarehouseInExecuteList(findMap);
        List<WarehouseInExecutor> executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);

        if (executorList == null || executorList.size() == 0) {return model;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            //A. 入库执行明细-库存数量退回
            for (int i = 0; i < executeList.size(); i++) {
                WarehouseInExecute execute = executeList.get(i);

                //入库数量 count
                if (execute.getCount() == null) {continue;}

                //入库操作
                WarehouseProduct inObject = new WarehouseProduct();
                //货位批次号
                inObject.setCode(detail.getCode());
                //产品ID
                inObject.setProductId(detail.getProductId());
                //(实际)货位ID
                inObject.setWarehouseId(execute.getWarehouseId());

                //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                double count = -1 * execute.getCount().doubleValue();

                //库存变更日志
                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(detail.getParentId());
                loginfo.setDetailId(detail.getId());
                loginfo.setExecuteId(execute.getId());

                loginfo.setCompanyId(companyId);
                loginfo.setCuser(cuser);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                loginfo.setOperation("reback");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(execute.getCount());
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(BigDecimal.valueOf(execute.getCount().doubleValue() + count));

                //(修改库存数量)退回已经入库数量
                String msgStr = warehouseProductService.inStockCount(inObject, BigDecimal.valueOf(count), loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                }
            }

            if (msgBuf.toString().trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgBuf.toString());
                return model;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strTemp = " 退单原因:{0} 操作时间：{1} ";
                String remarkStr = MessageFormat.format(remark, dateFormat.format(new Date()));

                //B. 修改入库执行表 vmes_warehouse_in_execute
                for (WarehouseInExecute execute : executeList) {
                    //isdisable: 是否启用(0:已禁用 1:启用)
                    execute.setIsdisable("0");

                    if (execute.getRemark() == null) {
                        execute.setRemark(remarkStr);
                    } else {
                        execute.setRemark(execute.getRemark() + remarkStr);
                    }
                    this.update(execute);

                    //产品ID
                    String productId = detail.getProductId();
                    //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                    double count = -1 * execute.getCount().doubleValue();

                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count);
                    productService.updateStockCount(product, prodStockCount, cuser);
                }

                //C. 入库明细执行人 vmes_warehouse_in_executor
                if (executorList != null && executorList.size() > 0) {
                    for (WarehouseInExecutor executor : executorList) {
                        //isdisable: 是否启用(0:已禁用 1:启用)
                        executor.setIsdisable("0");

                        if (executor.getRemark() == null) {
                            executor.setRemark(remarkStr);
                        } else {
                            executor.setRemark(executor.getRemark() + remarkStr);
                        }

                        warehouseInExecutorService.update(executor);
                    }
                }

                //D. 修改入库单明细状态
                findMap = new PageData();
                findMap.put("detailId", detailId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);
                if (executorList != null && executorList.size() > 0) {
                    //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                }else {
                    detail.setState("0");
                }
                if (detail.getRemark() == null) {
                    detail.setRemark(remarkStr);
                } else {
                    detail.setRemark(detail.getRemark() + remarkStr);
                }
                warehouseInDetailService.update(detail);

                //E. 修改修改当前入库单明细状态--同时反写入库单状态
                WarehouseIn parent = new WarehouseIn();
                parent.setId(detail.getParentId());
                //入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消) --忽视明细状态(-1:已取消)
                warehouseInDetailService.updateParentStateByDetailList(parent, null, null);
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////
}



