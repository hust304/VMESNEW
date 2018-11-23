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
* 说明：移库单明细Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveDetailController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveDetailController.class);

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    @Autowired
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMoveDetail/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveDetail/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseMoveDetail warehouseMoveDetail = warehouseMoveDetailService.selectById(id);
        model.putResult(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMoveDetail/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveDetail warehouseMoveDetail = (WarehouseMoveDetail)HttpUtils.pageData2Entity(pd, new WarehouseMoveDetail());
        warehouseMoveDetailService.save(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMoveDetail/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveDetail warehouseMoveDetail = (WarehouseMoveDetail)HttpUtils.pageData2Entity(pd, new WarehouseMoveDetail());
        warehouseMoveDetailService.update(warehouseMoveDetail);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMoveDetail/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveDetail/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseMoveDetailService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMoveDetail/deleteByIds 执行开始 ################# ");
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
            warehouseMoveDetailService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMoveDetail/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMoveDetail> warehouseMoveDetailList = warehouseMoveDetailService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveDetailList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMoveDetail/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMoveDetail> warehouseMoveDetailList = warehouseMoveDetailService.dataList(pd);
        model.putResult(warehouseMoveDetailList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * 出库单明细退单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveDetail/rebackWarehouseMoveDetail")
    @Transactional
    public ResultModel rebackWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/rebackWarehouseMoveDetail 执行开始 ################# ");
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
        List<WarehouseMoveExecutor> warehouseMoveExecutorList = warehouseMoveExecutorService.selectByColumnMap(columnMap);
        if(warehouseMoveExecutorList!=null&&warehouseMoveExecutorList.size()>0){
            for(int i=0;i<warehouseMoveExecutorList.size();i++){
                WarehouseMoveExecutor warehouseMoveExecutor = warehouseMoveExecutorList.get(i);
                if(StringUtils.isEmpty(warehouseMoveExecutor.getRemark())){
                    warehouseMoveExecutor.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseMoveExecutor.setRemark(warehouseMoveExecutor.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
//                warehouseMoveExecutor.setIsdisable("0");
                warehouseMoveExecutorService.update(warehouseMoveExecutor);
            }
        }
        //取消出库记录并记录退单原因
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            for(int i=0;i<warehouseMoveExecuteList.size();i++){
                WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                warehouseMoveExecute.setIsdisable("0");
                if(StringUtils.isEmpty(warehouseMoveExecute.getRemark())){
                    warehouseMoveExecute.setRemark("退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }else {
                    warehouseMoveExecute.setRemark(warehouseMoveExecute.getRemark()+"  退单原因:"+rebackBill+" 操作时间："+ dateFormat.format(new Date()));
                }
                warehouseMoveExecuteService.update(warehouseMoveExecute);
                //取消出库执行
                try {
                    //出库操作
                    WarehouseProduct outObject = warehouseProductService.selectById(warehouseMoveExecute.getWarehouseProductId());
                    WarehouseProduct inObject = warehouseProductService.selectById(warehouseMoveExecute.getNewWarehouseProductId());
                    String msgStr = warehouseProductService.moveStockCount(outObject,inObject,warehouseMoveExecute.getCount().negate(), currentUserId, currentCompanyId);
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

//        //删除推荐库位信息
//        columnMap = new HashMap();
//        columnMap.put("detail_id",detailId);
//        warehouseMoveRecommendService.deleteByColumnMap(columnMap);

        //更新出库单及出库明细状态
        WarehouseMoveDetail detail = warehouseMoveDetailService.selectById(detailId);

        columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        List<WarehouseMoveExecutor> checkList = warehouseMoveExecutorService.selectByColumnMap(columnMap);

        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("1");

        warehouseMoveDetailService.update(detail);
        warehouseMoveService.updateState(detail.getParentId());


        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/rebackWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveDetail/deleteWarehouseMoveDetail")
    @Transactional
    public ResultModel deleteWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/deleteWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = warehouseMoveDetailService.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细不可删除，该移库单明细状态(1:执行中 2:已完成)！");
            return model;
        }


        //1. 删除移库明细
        warehouseMoveDetailService.deleteById(detailId);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/deleteWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 取消移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveDetail/cancelWarehouseMoveDetail")
    @Transactional
    public ResultModel cancelWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/cancelWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = warehouseMoveDetailService.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细是已完成状态，不可取消！");
            return model;
        }

        PageData pd = new PageData();
        pd.put("queryStr","detail_id ='"+detail.getId()+"' and isdisable = '1' ");
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataList(pd);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            model.putCode("1");
            model.putMsg("该移库单执行人已开始执行，不能直接更换执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }


        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        warehouseMoveDetailService.update(detail);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/cancelWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 恢复移库单明细
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveDetail/recoveryWarehouseMoveDetail")
    @Transactional
    public ResultModel recoveryWarehouseMoveDetail() throws Exception {
        logger.info("################/warehouseMoveDetail/recoveryWarehouseMoveDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细id为空或空字符串！");
            return model;
        }

        WarehouseMoveDetail detail = warehouseMoveDetailService.findWarehouseMoveDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库明细不是取消状态，不能执行恢复操作！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("1");
        warehouseMoveDetailService.update(detail);
        //2.返写移库单状态
        warehouseMoveService.updateState(detail.getParentId());

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveDetail/recoveryWarehouseMoveDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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


    public List<Map> getExecuteChildrenList(Map rootMap,Map childrenTitleMap,PageData pd)  throws Exception {

        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("parentId",rootMap.get("id"));

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseMoveDetailService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)childrenTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMap.put("pid",rootMap.get("id").toString());
                childrenMapList.add(varMap);
            }
        }
        return childrenMapList;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouseMoveDetail/listPageWarehouseMoveDetailsExecute")
    public ResultModel listPageWarehouseMoveDetailsExecute()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMove");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseMoveDetailExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseMoveService.getDataListPage(pd,pg);
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
                varMap.put("children",getExecuteChildrenList(map,childrenTitleMap,pd));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-23
     */
    @PostMapping("/warehouseMoveDetail/listPageWarehouseMoveDetailsRecords")
    public ResultModel listPageWarehouseMoveDetailsRecords()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetailRecords");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("WarehouseMoveExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = getTitleList(columnList);



        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseMoveDetailService.getDataListPage(pd,pg);
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
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetailsRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    public List<Map> getOutRecordsChildrenList(Map rootMap,Map childrenTitleMap)  throws Exception {
        PageData pd = new PageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        pd.put("detailId",rootMap.get("id"));

        DecimalFormat df = new DecimalFormat("0.00");

        List<Map> childrenMapList = new ArrayList();
        List<Map> varList = warehouseMoveExecuteService.getDataListPage(pd,pg);
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
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/listPageWarehouseMoveDetails")
    public ResultModel listPageWarehouseMoveDetails()  throws Exception {

        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetail");
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
        List<Map> varList = warehouseMoveDetailService.getDataListPage(pd,pg);
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
        logger.info("################warehouseMoveDetail/listPageWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/exportExcelWarehouseMoveDetails")
    public void exportExcelWarehouseMoveDetails() throws Exception {
        logger.info("################warehouseMoveDetail/exportExcelWarehouseMoveDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveDetail");
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
        List<Map> dataList = warehouseMoveDetailService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseMoveDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveDetail/exportExcelWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveDetail/importExcelWarehouseMoveDetails")
    public ResultModel importExcelWarehouseMoveDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMoveDetail/importExcelWarehouseMoveDetails 执行开始 ################# ");
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
        logger.info("################warehouseMoveDetail/importExcelWarehouseMoveDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



