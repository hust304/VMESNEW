package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.*;
import com.yvan.*;
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
import java.util.*;



/**
* 说明：vmes_warehouse_in:仓库入库单Controller
* @author 陈刚 自动生成
* @date 2018-10-16
*/
@RestController
@Slf4j
public class WarehouseInController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################warehouseIn/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pd, new WarehouseIn());
        warehouseInService.save(warehouseIn);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################warehouseIn/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pd, new WarehouseIn());
        warehouseInService.update(warehouseIn);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @GetMapping("/warehouseIn/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseIn/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseInService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseIn/deleteByIds 执行开始 ################# ");
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
            warehouseInService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseIn/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseIn> warehouseInList = warehouseInService.dataList(pd);
        model.putResult(warehouseInList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/listPageWarehouseIns")
    public ResultModel listPageWarehouseIns() throws Exception {
        logger.info("################warehouseIn/listPageWarehouseIns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseIn");
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
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInService.getDataListPage(pd, pg);
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
        logger.info("################warehouseIn/listPageWarehouseIns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseIn/addWarehouseIn")
    @Transactional
    public ResultModel addWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/addWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pageData, new WarehouseIn());
        if (warehouseIn == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseIn 异常！");
            return model;
        }

        //非空判断
        String msgStr = warehouseInService.checkColumn(warehouseIn);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "[{\"productId\":\"9c414aadb2874b969b11d49e141b2f57\",\"count\":\"23.56\"},{\"productId\":\"ade5be7286214bd482240c603ad331a2\",\"count\":\"54.32\"}]";

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细Json字符串-转换成List错误！");
            return model;
        }

        String companyID = pageData.getString("currentCompanyId");

        //1. 添加入库单
        String parentId = Conv.createUuid();
        warehouseIn.setId(parentId);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setCompanyId(companyID);
        //入库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_in", "W");
        warehouseIn.setCode(code);
        warehouseInService.save(warehouseIn);

        //2.添加入库单明细
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        warehouseInDetailService.addWarehouseInDetail(warehouseIn, detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/addWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseIn/updateWarehouseIn")
    @Transactional
    public ResultModel updateWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/updateWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/updateWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseIn/updateCancelWarehouseIn")
    @Transactional
    public ResultModel updateCancelWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/updateCancelWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //1. 根据(入库单id)-查询入库单明细(vmes_warehouse_in_detail)
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许取消(-1.已取消)
        if (!warehouseInDetailService.checkStateByDetailList("-1", null, detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单不可取消，该入库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "-1");
        warehouseInDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseIn warehouseIn = new WarehouseIn();
        warehouseIn.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("-1");
        warehouseInService.update(warehouseIn);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/updateCancelWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseIn/deleteWarehouseIn")
    @Transactional
    public ResultModel deleteWarehouseIn() throws Exception {
        logger.info("################/warehouseIn/deleteWarehouseIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //1. 根据(入库单id)-查询入库单明细(vmes_warehouse_in_detail)
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许删除(0:待派单) 忽视状态:-1:已取消
        if (!warehouseInDetailService.checkStateByDetailList("0", "-1", detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单不可删除，该入库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 删除入库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseInDetailService.deleteByColumnMap(columnMap);

        //3. 删除入库单
        warehouseInService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseIn/deleteWarehouseIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/exportExcelWarehouseIns")
    public void exportExcelWarehouseIn() throws Exception {
        logger.info("################warehouseIn/exportExcelWarehouseIns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("warehouseIn");
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
        List<Map> dataList = warehouseInService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseIn";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseIn/exportExcelWarehouseIns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-10-16
    */
    @PostMapping("/warehouseIn/importExcelWarehouseIns")
    public ResultModel importExcelWarehouseIn(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseIn/importExcelWarehouseIns 执行开始 ################# ");
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
        logger.info("################warehouseIn/importExcelWarehouseIns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



