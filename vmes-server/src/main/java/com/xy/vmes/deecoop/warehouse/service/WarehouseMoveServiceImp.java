package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：移库单 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveServiceImp implements WarehouseMoveService {


    @Autowired
    private WarehouseMoveMapper warehouseMoveMapper;
    @Autowired
    private ColumnService columnService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private ProductService productService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setId(Conv.createUuid());
        warehouseMove.setCdate(new Date());
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.insert(warehouseMove);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.updateById(warehouseMove);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMove warehouseMove) throws Exception{
        warehouseMove.setUdate(new Date());
        warehouseMoveMapper.updateAllColumnById(warehouseMove);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMove", key = "''+#id")
    public WarehouseMove selectById(String id) throws Exception{
        return warehouseMoveMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> dataList(PageData pd) throws Exception{
        return warehouseMoveMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMove> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMove> warehouseMoveList =  warehouseMoveMapper.selectByMap(columnMap);
        return warehouseMoveList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void deleteTableByWarehouseMove(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

        warehouseMoveMapper.deleteTableByExecute(pageData);
        warehouseMoveMapper.deleteTableByExecutor(pageData);
        warehouseMoveMapper.deleteTableByDetail(pageData);

        Map<String, String> columnMap = new HashMap<String, String>();
        columnMap.put("company_id", companyId);
        this.deleteByColumnMap(columnMap);
    }

    public List<WarehouseMove> findWarehouseMoveList(PageData object) {
        if (object == null) {return null;}
        List<WarehouseMove> objectList = new ArrayList<WarehouseMove>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }

    public WarehouseMove findWarehouseMove(PageData object) {
        if (object == null) {return null;}
        List<WarehouseMove> objectList = this.findWarehouseMoveList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }
        return null;
    }

    public WarehouseMove findWarehouseMoveById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}
        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        return this.findWarehouseMove(findMap);
    }

    @Override
    public void updateState(String id) throws Exception {
        WarehouseMove warehouseMove = this.findWarehouseMoveById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(warehouseMove!=null){
            List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.findWarehouseMoveDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseMoveDetail warehouseMoveDetail = detailList.get(i);
                    if("-1".equals(warehouseMoveDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseMoveDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseMoveDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseMoveDetail.getState())){
                        ywc = ywc + 1;
                    }
                }
            }else{
                //如果当前出库单没有明细则自动删除当前出库单
                this.deleteById(id);
                return;
            }
            //该出库单明细状态全是已取消状态，则说明当前出库单状态为已取消
            if(yqx>0&&dpd==0&&zxz==0&&ywc==0){
                warehouseMove.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0){
                warehouseMove.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseMove.setState("0");//未完成
            }
            this.update(warehouseMove);
        }

    }

    @Override
    public ResultModel deleteWarehouseMove(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();


        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单id为空或空字符串！");
            return model;
        }

        //1. 根据(移库单id)-查询移库单明细(vmes_warehouse_in_detail)
        List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.findWarehouseMoveDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许删除
        //判断明细中是否全部(0:待派单) 忽视状态:-1:已取消
        if (!warehouseMoveDetailService.isAllExistStateByDetailList("0", "-1", detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前移库单不可删除，该移库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 删除移库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseMoveDetailService.deleteByColumnMap(columnMap);

        //3. 删除移库单
        this.deleteById(parentId);

        return model;
    }

    @Override
    public ResultModel saveWarehouseMove(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pd.getString("cuser");
        String dtlJsonStr = pd.getString("dtlJsonStr");
        String executorIdsStr = pd.getString("executorIdsStr");

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细Json字符串-转换成List错误！");
            return model;
        }
        String currentUserId = pd.getString("currentUserId");
        String companyID = pd.getString("currentCompanyId");
        String warehouseId = pd.getString("warehouseId");
        WarehouseMove warehouseMove = new WarehouseMove();
        //1. 添加移库单
        String id = Conv.createUuid();
        warehouseMove.setId(id);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseMove.setState("0");
        warehouseMove.setCompanyId(companyID);
        warehouseMove.setType("b73d12669b4646e68c1a633da5b5d22d");//移库类型：移库
        warehouseMove.setMakeId(currentUserId);
        warehouseMove.setCuser(currentUserId);
        warehouseMove.setWarehouseId(warehouseId);
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_move", "O");
        warehouseMove.setCode(code);
        this.save(warehouseMove);

        //2.添加移库单明细

        List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.mapList2DetailList(mapList, null);
        warehouseMoveDetailService.addWarehouseMoveDetail(warehouseMove, detailList);

        //3.移库单派工添加执行人信息
        if(detailList!=null&&detailList.size()>0){
            for(int i=0;i<detailList.size();i++){
                WarehouseMoveDetail detail = detailList.get(i);
                //新增移库执行人记录
                if(!StringUtils.isEmpty(executorIdsStr)){
                    String[] executorIds = executorIdsStr.split(",");
                    if(executorIds!=null&&executorIds.length>0){
                        for(int j=0;j<executorIds.length;j++){
                            String executorId = executorIds[j];
                            WarehouseMoveExecutor executor = new WarehouseMoveExecutor();
                            executor.setExecutorId(executorId);
                            executor.setDetailId(detail.getId());
                            executor.setCuser(currentUserId);
                            warehouseMoveExecutorService.save(executor);
                            String ProductName = null;
                            WarehouseProduct warehouseProduct = warehouseProductService.selectById(detail.getWarehouseProductId());
                            if(warehouseProduct!=null){
                                Product Product = productService.selectById(warehouseProduct.getProductId());
                                if(Product!=null){
                                    ProductName = Product.getName();
                                }
                            }

                            Task task = taskService.createTaskByWarehouseMove(detail.getId(), executorId, cuser);
                            task.setTaskName(code + "_" + ProductName);
                            task.setCompanyId(companyID);
                            taskService.save(task);
                        }
                    }
                }
            }
        }

        return model;
    }

    @Override
    public ResultModel listPageWarehouseMoves(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMove");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelWarehouseMoves(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("WarehouseMove");
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
            fileName = "ExcelWarehouseMove";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseMoves(MultipartFile file) throws Exception {
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
        return model;
    }
}



