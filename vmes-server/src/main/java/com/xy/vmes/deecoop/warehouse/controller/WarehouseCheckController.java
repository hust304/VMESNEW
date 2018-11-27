package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
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

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* 说明：vmes_warehouse_check:仓库库存盘点Controller
* @author 陈刚 自动生成
* @date 2018-11-13
*/
@RestController
@Slf4j
public class WarehouseCheckController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckController.class);

    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚
     * @date 2018-11-13
     */
    @PostMapping("/warehouseCheck/listPagewarehouseChecks")
    public ResultModel listPagewarehouseChecks() throws Exception {
        logger.info("################warehouseCheck/listPagewarehouseChecks 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheck");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
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
        pd.put("orderStr", "parent.cdate desc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckService.getDataListPage(pd, pg);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheck/listPagewarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouseCheck/addWarehouseCheck")
    @Transactional
    public ResultModel addWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/addWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("currentCompanyId");

        WarehouseCheck warehouseCheck = (WarehouseCheck)HttpUtils.pageData2Entity(pageData, new WarehouseCheck());
        if (warehouseCheck == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseCheck 异常！");
            return model;
        }

        //type: 盘点类型(1:按库位 2:货品)
        if (warehouseCheck.getType() == null || warehouseCheck.getType().trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点类型为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条(货品，货位)数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        String ids = warehouseCheckDetailService.findBusinessIdByMapList(mapList);
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条(货品，货位)数据！");
            return model;
        }
        ids = StringUtil.stringTrimSpace(ids);
        String queryIds = "'" + ids.replace(",", "','") + "'";

        //查询库存表 vmes_warehouse_product
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);

        //type: 盘点类型(1:按货位 2:货品)
        String typeName = "";
        if ("1".equals(warehouseCheck.getType().trim())) {
            typeName = "货位";
            String queryWarehouseStr = "warehouse_id in (" + queryIds + ")";
            findMap.put("queryWarehouseStr", queryWarehouseStr);
        } else if ("2".equals(warehouseCheck.getType().trim())) {
            typeName = "货品";
            String queryProductStr = "product_id in (" + queryIds + ")";
            findMap.put("queryProductStr", queryProductStr);
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseProduct> warehouseProductList = warehouseProductService.findWarehouseProductList(findMap);
        if (warehouseProductList == null || warehouseProductList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("您所勾选的("+typeName+")在系统库存中不存在！");
            return model;
        }

        //盘点单编号
        warehouseCheck.setCompanyId(companyId);
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_check", "C");
        warehouseCheck.setMakeId(warehouseCheck.getCuser());
        warehouseCheck.setCode(code);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheck.setState("0");
        warehouseCheckService.save(warehouseCheck);

        warehouseCheckDetailService.addWarehouseCheckDetail(warehouseCheck, warehouseProductList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/addWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouseCheck/cancelWarehouseCheck")
    @Transactional
    public ResultModel cancelWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/cancelWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条盘点单！");
            return model;
        }

        //验证盘点单-明细中状态()-是否允许取消
        //允许删除-明细中状态全部是(待派单)或全部是(已取消)
        StringBuffer msgBuf = new StringBuffer();
        String[] idArry = ids.split(",");
        for(int i = 0; i < idArry.length; i++) {
            String parentId = idArry[i];

            PageData findMap = new PageData();
            findMap.put("parentId", parentId);
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消) 忽视状态(-1:已取消)
            findMap.put("queryStr", "state in ('1','2','3')");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.findWarehouseCheckDetailList(findMap);
            if (detailList != null && detailList.size() > 0) {
                msgBuf.append("第 " + (i+1) + " 行: 盘点单明细中含有(执行中,审核中,已完成)状态，该盘点单不可取消！");
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            msgBuf.append("盘点明细全部是(待派单)或全部是(已取消)允许取消！");

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        for (String parentId : idArry) {
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            warehouseCheckDetailService.updateStateByDetail(parentId, "-1");

            WarehouseCheck parent = new WarehouseCheck();
            parent.setId(parentId);
            //状态(0:未完成 1:已完成 -1:已取消)
            parent.setState("-1");
            warehouseCheckService.update(parent);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/cancelWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)退回盘点单(退回整个盘点单)
     * 1. 填写退回原因
     * 2. 盘点明细必须是(<=1:执行中)-允许退回
     * 3. 退回成功后盘点明细状态(0:待派单)
     * 4. 修改盘点明细执行人表(vmes_warehouse_check_executor.isdisable)状态
     *
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouseCheck/rebackWarehouseCheck")
    @Transactional
    public ResultModel rebackWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/rebackWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");

        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条盘点单！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        //验证盘点单-明细中状态()-是否允许退回
        //盘点明细必须是(<=1:执行中)-允许退回
        StringBuffer msgBuf = new StringBuffer();
        String[] idArry = ids.split(",");
        for(int i = 0; i < idArry.length; i++) {
            String parentId = idArry[i];

            PageData findMap = new PageData();
            findMap.put("parentId", parentId);
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消) 忽视状态(-1:已取消)
            findMap.put("queryStr", "state in ('2','3')");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.findWarehouseCheckDetailList(findMap);
            if (detailList != null && detailList.size() > 0) {
                msgBuf.append("第 " + (i+1) + " 行: 盘点单明细中含有(审核中,已完成)状态，该盘点单不可退回！");
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        for (String parentId : idArry) {
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            warehouseCheckDetailService.updateStateByDetail(parentId, "0");

            Map<String, String> columnMap = new HashMap<String, String>();
            columnMap.put("parent_id", parentId);
            columnMap.put("executor_id", cuser);
            //是否启用(0:已禁用 1:启用)
            columnMap.put("isdisable", "1");
            warehouseCheckExecutorService.deleteByColumnMap(columnMap);

            WarehouseCheck parent = new WarehouseCheck();
            parent.setId(parentId);
            //状态(0:未完成 1:已完成 -1:已取消)
            parent.setState("0");
            warehouseCheckService.update(parent);
        }


        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/rebackWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 删除盘点单
     * @author 陈刚
     * @date 2018-11-13
     * @throws Exception
     */
    @PostMapping("/warehouseCheck/deleteWarehouseCheck")
    @Transactional
    public ResultModel deleteWarehouseCheck() throws Exception {
        logger.info("################/warehouseCheck/deleteWarehouseCheck 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条盘点单！");
            return model;
        }

        //验证盘点单-明细中状态()-是否允许删除
        //允许删除-明细中状态全部是(待派单)或全部是(已取消)
        StringBuffer msgBuf = new StringBuffer();
        String[] idArry = ids.split(",");
        for(int i = 0; i < idArry.length; i++) {
            String parentId = idArry[i];

            PageData findMap = new PageData();
            findMap.put("parentId", parentId);
            //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消) 忽视状态(-1:已取消)
            findMap.put("queryStr", "state in ('1','2','3')");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.findWarehouseCheckDetailList(findMap);
            if (detailList != null && detailList.size() > 0) {
                msgBuf.append("第 " + (i+1) + " 行: 盘点单明细中含有(执行中,审核中,已完成)状态，该盘点单不可删除！");
            }
        }
        if (msgBuf.toString().trim().length() > 0) {
            msgBuf.append("盘点明细全部是(待派单)或全部是(已取消)允许删除！");

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        for (String parentId : idArry) {
            //1. 删除盘点明细表
            Map<String, String> columnMap = new HashMap<String, String>();
            columnMap.put("parent_id", parentId);
            warehouseCheckDetailService.deleteByColumnMap(columnMap);
        }

        //2. 删除盘点表
        warehouseCheckService.deleteByIds(idArry);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/deleteWarehouseCheck 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 验证当前登录用户是否含有(仓库盘点审核角色)
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-15
     */
    @PostMapping("/warehouseCheck/checkUserRoleByWarehouseAudit")
    public ResultModel checkUserRoleByWarehouseAudit() throws Exception {
        logger.info("################/warehouseCheck/checkUserRoleByWarehouseAudit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("currentCompanyId");
        String userRoleIds = pageData.getString("userRoleIds");
        if (userRoleIds == null || userRoleIds.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前登录用户角色id为空或空字符串！");
            return model;
        }

        PageData findMap = new PageData();
        findMap.put("name", "仓库盘点审核员");
        findMap.put("currentCompanyId", companyId);
        //isdisable: 是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Role> roleList = roleService.findRoleList(findMap);

        if (roleList == null || roleList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前系统中无(仓库盘点审核员)角色，请与企业管理员联系！");
            return model;
        }

        String roleId = roleList.get(0).getId();
//        if (userRoleIds.trim().indexOf(roleId) == -1) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("您的账号不属于(仓库盘点审核员)角色，请与企业管理员联系！");
//            return model;
//        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheck/checkUserRoleByWarehouseAudit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-13
     */
    @PostMapping("/warehouseCheck/exportExcelwarehouseChecks")
    public void exportExcelwarehouseChecks() throws Exception {
        logger.info("################warehouseCheck/exportExcelwarehouseChecks 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("warehouseCheckManage");
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
        List<Map> dataList = warehouseCheckService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelwarehouseCheck";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheck/exportExcelwarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * Excel导入
     *
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-13
     */
    @PostMapping("/warehouseCheck/importExcelwarehouseChecks")
    public ResultModel importExcelwarehouseChecks(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseCheck/importExcelwarehouseChecks 执行开始 ################# ");
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
        logger.info("################warehouseCheck/importExcelwarehouseChecks 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



