package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;



/**
* 说明：出库明细Controller
* @author 刘威 自动生成
* @date 2018-10-23
*/
@RestController
@Slf4j
public class WarehouseOutDetailController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutDetailController.class);

    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private WarehouseOutService warehouseOutService;

    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private WarehouseOutRecommendService warehouseOutRecommendService;

    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;

    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @GetMapping("/warehouseOutDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseOutDetail warehouseOutDetail = warehouseOutDetailService.selectById(id);
        model.putResult(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutDetail warehouseOutDetail = (WarehouseOutDetail)HttpUtils.pageData2Entity(pd, new WarehouseOutDetail());
        warehouseOutDetailService.save(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutDetail warehouseOutDetail = (WarehouseOutDetail)HttpUtils.pageData2Entity(pd, new WarehouseOutDetail());
        warehouseOutDetailService.update(warehouseOutDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @GetMapping("/warehouseOutDetail/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseOutDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutDetail/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            warehouseOutDetailService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutDetail/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutDetail> warehouseOutDetailList = warehouseOutDetailService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutDetailList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutDetail/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutDetail> warehouseOutDetailList = warehouseOutDetailService.dataList(pd);
        model.putResult(warehouseOutDetailList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * 出库单明细退单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseOutDetail/rebackWarehouseOutDetail")
    @Transactional
    public ResultModel rebackWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/rebackWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        String rebackBill = pageData.getString("rebackBill");

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("executor_id",currentUserId);
        columnMap.put("isdisable","1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //取消出库执行人并记录退单原因
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
        if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
            for(int i=0;i<warehouseOutExecutorList.size();i++){
                WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                if(StringUtils.isEmpty(warehouseOutExecutor.getRemark())){
                    warehouseOutExecutor.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseOutExecutor.setRemark(warehouseOutExecutor.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseOutExecutor.setIsdisable("0");
                warehouseOutExecutorService.update(warehouseOutExecutor);
            }
        }
        //取消出库记录并记录退单原因
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.selectByColumnMap(columnMap);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            for(int i=0;i<warehouseOutExecuteList.size();i++){
                WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteList.get(i);
                warehouseOutExecute.setIsdisable("0");
                if(StringUtils.isEmpty(warehouseOutExecute.getRemark())){
                    warehouseOutExecute.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseOutExecute.setRemark(warehouseOutExecute.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseOutExecuteService.update(warehouseOutExecute);
                //取消出库执行
                try {
                    //出库操作
                    WarehouseProduct outObject = warehouseProductService.selectById(warehouseOutExecute.getWarehouseProductId());
                    String msgStr = warehouseProductService.outStockCount(outObject, warehouseOutExecute.getCount().negate(), currentUserId, currentCompanyId);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        model.putCode(Integer.valueOf(1));
                        model.putMsg(msgStr);
                        return model;
                    }
                } catch (TableVersionException tabExc) {
                    //库存变更 version 锁
                    if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                        model.putCode(Integer.valueOf(1));
                        model.putMsg(tabExc.getMessage());
                        return model;
                    }
                }
            }
        }

        //删除推荐库位信息
        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        warehouseOutRecommendService.deleteByColumnMap(columnMap);

        //更新出库单及出库明细状态
        WarehouseOutDetail detail = warehouseOutDetailService.selectById(detailId);

        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        List<WarehouseOutExecutor> checkList = warehouseOutExecutorService.selectByColumnMap(columnMap);

        if(checkList!=null&&checkList.size()>0){
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
        }else {
            detail.setState("0");
        }

        warehouseOutDetailService.update(detail);
        warehouseOutService.updateState(detail.getParentId());


        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/rebackWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }











    /**
     * 出库单明细派单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseOutDetail/dispatchWarehouseOutDetail")
    @Transactional
    public ResultModel dispatchWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/dispatchWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String executorIdsStr = pageData.getString("executorIdsStr");
        String jsonDataStr = pageData.getString("jsonDataStr");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);



        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> detailMap = mapList.get(j);
                if(detailMap!=null&&detailMap.get("children")!=null){
                    String detailId = (String)detailMap.get("id");
                    if(!StringUtils.isEmpty(detailId)){

                        //新增出库执行人记录
                        if(!StringUtils.isEmpty(executorIdsStr)){
                            String[] executorIds = executorIdsStr.split(",");
                            if(executorIds!=null&&executorIds.length>0){
                                for(int i=0;i<executorIds.length;i++){
                                    String executorId = executorIds[i];
                                    WarehouseOutExecutor executor = new WarehouseOutExecutor();
                                    executor.setExecutorId(executorId);
                                    executor.setDetailId(detailId);
                                    warehouseOutExecutorService.save(executor);
                                }
                            }
                        }

                        //新增推荐库位记录
                        List childrenList = (List) detailMap.get("children");
                        if(childrenList!=null&&childrenList.size()>0){
                            for(int k=0;k<childrenList.size();k++){
                                Map<String, Object> childrenMap = (Map<String, Object>)childrenList.get(k);
                                if(childrenMap != null){
                                    String warehouseProductId = (String)childrenMap.get("id");
                                    String suggestCount = (String)childrenMap.get("suggestCount");
                                    WarehouseOutRecommend recommend = new WarehouseOutRecommend();
                                    recommend.setDetailId(detailId);
                                    recommend.setWarehouseProductId(warehouseProductId);
                                    recommend.setCount(StringUtils.isEmpty(suggestCount)?BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(suggestCount)));
                                    warehouseOutRecommendService.save(recommend);
                                }
                            }
                        }

                        //更新出库单及出库明细状态
                        WarehouseOutDetail detail = warehouseOutDetailService.selectById(detailId);
                        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                        detail.setState("1");
                        warehouseOutDetailService.update(detail);
                        warehouseOutService.updateState(detail.getParentId());

                    }
                }

            }
        }


        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/dispatchWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * 恢复出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseOutDetail/recoveryWarehouseOutDetail")
    @Transactional
    public ResultModel recoveryWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/recoveryWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = warehouseOutDetailService.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不是取消状态，不能恢复！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        warehouseOutDetailService.update(detail);
        //2.返写出库单状态
        warehouseOutService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/recoveryWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseOutDetail/cancelWarehouseOutDetail")
    @Transactional
    public ResultModel cancelWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/cancelWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = warehouseOutDetailService.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不可取消，该出库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        warehouseOutDetailService.update(detail);
        //2.返写出库单状态
        warehouseOutService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/cancelWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseOutDetail/deleteWarehouseOutDetail")
    @Transactional
    public ResultModel deleteWarehouseOutDetail() throws Exception {
        logger.info("################/warehouseOutDetail/deleteWarehouseOutDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单明细id为空或空字符串！");
            return model;
        }

        WarehouseOutDetail detail = warehouseOutDetailService.findWarehouseOutDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库明细不可删除，该出库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 删除入库明细
        warehouseOutDetailService.deleteById(detailId);
        //2.返写入库单状态
        warehouseOutService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutDetail/deleteWarehouseOutDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }







    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/listPageWarehouseOutDetails")
    public ResultModel listPageWarehouseOutDetails()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetail");
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
        List<Map> varList = warehouseOutDetailService.getDataListPage(pd,pg);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouseOutDetail/listPageWarehouseOutDetailsOutRecords")
    public ResultModel listPageWarehouseOutDetailsOutRecords()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsOutRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailRecords");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseOutDetailService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)rootTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("hideTitles",childrenTitleMap.get("hideTitles"));
                varMap.put("titles",childrenTitleMap.get("titles"));
                varMap.put("pid",null);
                varMap.put("children",getOutRecordsChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsOutRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    public List<Map> getOutRecordsChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("detailId",rootMap.get("id"));

        DecimalFormat df = new DecimalFormat("0.00");

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseOutExecuteService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double actualCount = Double.parseDouble((String)varMap.get("actualCount"));

                varMap.put("actualCount",df.format(actualCount));
                childrenMapList.add(varMap);
            }
        }
        return childrenMapList;
    }




    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouseOutDetail/listPageWarehouseOutDetailsExecute")
    public ResultModel listPageWarehouseOutDetailsExecute()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseOutRecommend");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseOutDetailService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)rootTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("hideTitles",childrenTitleMap.get("hideTitles"));
                varMap.put("titles",childrenTitleMap.get("titles"));
                varMap.put("pid",null);
                varMap.put("children",getExecuteChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    public List<Map> getExecuteChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("detailId",rootMap.get("id"));

        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
        }


        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseOutRecommendService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double suggestCount = Double.parseDouble((String)varMap.get("suggestCount"));
                double stockCount = Double.parseDouble((String)varMap.get("stockCount"));
                if(stockCount<suggestCount){
                    varMap.put("suggestCount",df.format(stockCount));
                    childrenMapList.add(varMap);
                }else {
                    varMap.put("suggestCount",df.format(suggestCount));
                    childrenMapList.add(varMap);
                }
            }
        }
        return childrenMapList;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouseOutDetail/listPageWarehouseOutDetailsDispatch")
    public ResultModel listPageWarehouseOutDetailsDispatch()  throws Exception {

        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseProductDispatch");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseOutDetailService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)rootTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("hideTitles",childrenTitleMap.get("hideTitles"));
                varMap.put("titles",childrenTitleMap.get("titles"));
                varMap.put("pid",null);
                varMap.put("children",getDispatchChildrenList(map,childrenTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    public Map getTitleList(List<Column> columnList){
        Map result = new HashMap();
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
        result.put("varModel",varModelMap);
        return result;
    }



    public List<Map> getDispatchChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("productId",rootMap.get("productId"));

        DecimalFormat df = new DecimalFormat("0.00");
        double count = 0.00;
        if(rootMap.get("count")!=null){
            count = ((BigDecimal) rootMap.get("count")).doubleValue();
        }


        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseProductService.getDataListPageDispatch(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                double stockCount = Double.parseDouble((String)varMap.get("stockCount"));
                if(count>0){
                    if(count>=stockCount){
                        varMap.put("suggestCount",df.format(stockCount));
                        count = count - stockCount;
                        childrenMapList.add(varMap);
                    }else if(count<stockCount){
                        varMap.put("suggestCount",df.format(count));
                        count = 0;
                        childrenMapList.add(varMap);
                    }
                }
            }
        }
        return childrenMapList;
    }




//    /**
//     * @author 刘威 自动创建，可以修改
//     * @date 2018-10-23
//     */
//    @PostMapping("/warehouseOutDetail/listPageWarehouseOutDetailsDispatch")
//    public ResultModel listPageWarehouseOutDetailsDispatch()  throws Exception {
//
//        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        ResultModel model = new ResultModel();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        Map result = new HashMap();
//
//        List<Column> columnList = columnService.findColumnList("WarehouseOutDetailDispatch");
//        if (columnList == null || columnList.size() == 0) {
//            model.putCode("1");
//            model.putMsg("数据库没有生成TabCol，请联系管理员！");
//            return model;
//        }
//
//        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
//        List<String> titlesHideList = new ArrayList<String>();
//        Map<String, String> varModelMap = new HashMap<String, String>();
//        if(columnList!=null&&columnList.size()>0){
//            for (Column column : columnList) {
//                if(column!=null){
//                    if("0".equals(column.getIshide())){
//                        titlesHideList.add(column.getTitleKey());
//                    }
//                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
//                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
//                    varModelMap.put(column.getTitleKey(),"");
//                    titlesList.add(titlesLinkedMap);
//                }
//            }
//        }
//        result.put("hideTitles",titlesHideList);
//        result.put("titles",titlesList);
//
//        List<Map> varMapList = new ArrayList();
//        List<Map> varList = warehouseOutDetailService.getDataListPage(pd,pg);
//        if(varList!=null&&varList.size()>0){
//            for(int i=0;i<varList.size();i++){
//                Map map = varList.get(i);
//                Map<String, String> varMap = new HashMap<String, String>();
//                varMap.putAll(varModelMap);
//                for (Map.Entry<String, String> entry : varMap.entrySet()) {
//                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
//                }
//                varMapList.add(varMap);
//            }
//        }
//        result.put("varList",varMapList);
//        result.put("pageData", pg);
//
//        model.putResult(result);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################warehouseOutDetail/listPageWarehouseOutDetailsDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }



    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/exportExcelWarehouseOutDetails")
    public void exportExcelWarehouseOutDetails() throws Exception {
        logger.info("################warehouseOutDetail/exportExcelWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("WarehouseOutDetail");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = warehouseOutDetailService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseOutDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/exportExcelWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-23
    */
    @PostMapping("/warehouseOutDetail/importExcelWarehouseOutDetails")
    public ResultModel importExcelWarehouseOutDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseOutDetail/importExcelWarehouseOutDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

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
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutDetail/importExcelWarehouseOutDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



