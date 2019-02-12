package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseCheckMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_warehouse_check:仓库库存盘点 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-13
*/
@Service
@Transactional(readOnly = false)
public class WarehouseCheckServiceImp implements WarehouseCheckService {

    @Autowired
    private WarehouseCheckMapper warehouseCheckMapper;
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
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void save(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setId(Conv.createUuid());
        warehouseCheck.setCdate(new Date());
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.insert(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public WarehouseCheck selectById(String id) throws Exception{
        return warehouseCheckMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheck> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseCheck> warehouseCheckList =  warehouseCheckMapper.selectByMap(columnMap);
        return warehouseCheckList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void update(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.updateById(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateAll(WarehouseCheck warehouseCheck) throws Exception{
        warehouseCheck.setUdate(new Date());
        warehouseCheckMapper.updateAllColumnById(warehouseCheck);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseCheckMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseCheckMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseCheckMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseCheckMapper.deleteByMap(columnMap);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByWarehouseCheck(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

        warehouseCheckMapper.deleteTableByExecute(pageData);
        warehouseCheckMapper.deleteTableByExecutor(pageData);
        warehouseCheckMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    @Override
    public List<WarehouseCheck> dataList(PageData pd) throws Exception{
        return warehouseCheckMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return warehouseCheckMapper.getDataListPage(pd, pg);
    }

    public WarehouseCheck findWarehouseCheck(PageData object) throws Exception {
        if (object == null) {return null;}

        List<WarehouseCheck> objectList = this.findWarehouseCheckList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseCheck findWarehouseCheckById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseCheck(findMap);
    }

    public List<WarehouseCheck> findWarehouseCheckList(PageData object) throws Exception {
        if (object == null) {return null;}

        return this.dataList(object);
    }

    @Override
    public ResultModel listPagewarehouseChecks(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("warehouseCheck");
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

        //设置查询排序
        pd.put("orderStr", "parent.cdate desc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd, pg);
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
    public ResultModel addWarehouseCheck(PageData pageData) throws Exception {

        ResultModel model = new ResultModel();
        String companyId = pageData.getString("currentCompanyId");

        WarehouseCheck warehouseCheck = (WarehouseCheck) HttpUtils.pageData2Entity(pageData, new WarehouseCheck());
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
            typeName = "货位无存放货品，该货位属于空货位！";
            String queryWarehouseStr = "warehouse_id in (" + queryIds + ")";
            findMap.put("queryWarehouseStr", queryWarehouseStr);
        } else if ("2".equals(warehouseCheck.getType().trim())) {
            typeName = "货品在仓库中不存在！";
            String queryProductStr = "product_id in (" + queryIds + ")";
            findMap.put("queryProductStr", queryProductStr);
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseProduct> warehouseProductList = warehouseProductService.findWarehouseProductList(findMap);
        if (warehouseProductList == null || warehouseProductList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("您所勾选的" + typeName);
            return model;
        }

        //盘点单编号
        warehouseCheck.setCompanyId(companyId);
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_check", "C");
        warehouseCheck.setMakeId(warehouseCheck.getCuser());
        warehouseCheck.setCode(code);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseCheck.setState("0");
        this.save(warehouseCheck);

        warehouseCheckDetailService.addWarehouseCheckDetail(warehouseCheck, warehouseProductList);

        return model;
    }

    @Override
    public ResultModel cancelWarehouseCheck(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
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
            this.update(parent);
        }
        return model;
    }

    @Override
    public ResultModel rebackWarehouseCheck(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
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
            this.update(parent);
        }

        return model;
    }

    @Override
    public ResultModel deleteWarehouseCheck(PageData pageData) throws Exception {

        ResultModel model = new ResultModel();
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
        this.deleteByIds(idArry);
        return model;
    }

    @Override
    public ResultModel checkUserRoleByWarehouseAudit(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
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
        if (userRoleIds.trim().indexOf(roleId) == -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("您的账号不属于(仓库盘点审核员)角色，请与企业管理员联系！");
            return model;
        }
        return model;
    }

    @Override
    public void exportExcelwarehouseChecks(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("warehouseCheckManage");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);
        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

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
    }

    @Override
    public ResultModel importExcelwarehouseChecks(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }


    @Override
    public void updateState(String id) throws Exception {
        WarehouseCheck warehouseCheck = this.findWarehouseCheckById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int shz = 0;//审核中
        int ywc = 0;//已完成
        if(warehouseCheck!=null){
            List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.findWarehouseCheckDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseCheckDetail warehouseCheckDetail = detailList.get(i);
                    if("-1".equals(warehouseCheckDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseCheckDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseCheckDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseCheckDetail.getState())){
                        shz = shz + 1;
                    }else if("3".equals(warehouseCheckDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前出库单没有明细则自动删除当前出库单
                this.deleteById(id);
                return;
            }
            //该出库单明细状态全是已取消状态，则说明当前出库单状态为已取消
            if(yqx>0&&dpd==0&&zxz==0&&ywc==0&&shz==0){
                warehouseCheck.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0&&shz==0){
                warehouseCheck.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseCheck.setState("0");//未完成
            }
            this.update(warehouseCheck);
        }

    }
}



