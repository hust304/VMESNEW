package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.xy.vmes.service.WarehouseOutService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.MessageFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：出库 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-10-22
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutServiceImp implements WarehouseOutService {

    @Autowired
    private WarehouseOutMapper warehouseOutMapper;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void save(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setId(Conv.createUuid());
        warehouseOut.setCdate(new Date());
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.insert(warehouseOut);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void update(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.updateById(warehouseOut);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void updateAll(WarehouseOut warehouseOut) throws Exception{
        warehouseOut.setUdate(new Date());
        warehouseOutMapper.updateAllColumnById(warehouseOut);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOut", key = "''+#id")
    public WarehouseOut selectById(String id) throws Exception{
        return warehouseOutMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> dataList(PageData pd) throws Exception{
        return warehouseOutMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<WarehouseOut> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOut> warehouseOutList =  warehouseOutMapper.selectByMap(columnMap);
        return warehouseOutList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutMapper.getDataListPage(pd,pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception {
        return warehouseOutMapper.getDataListPage(pd);
    }
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-10-22
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
//    public void deleteTableByWarehouseOut(String companyId) throws Exception {
//        PageData pageData = new PageData();
//        pageData.put("companyId", companyId);
//
//        warehouseOutMapper.deleteTableByRecommend(pageData);
//        warehouseOutMapper.deleteTableByExecute(pageData);
//        warehouseOutMapper.deleteTableByExecutor(pageData);
//        warehouseOutMapper.deleteTableByDetail(pageData);
//
//        Map<String, String> columnMap = new HashMap<String, String>();
//        columnMap.put("company_id", companyId);
//        this.deleteByColumnMap(columnMap);
//    }

    /**
     *
     * @param companyId  企业id
     * @param warehouseGenre 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
     * @throws Exception
     */
    public void deleteTableByWarehouseOut(String companyId, String warehouseGenre) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

//        if ("true".equals(isSpare)) {
//            pageData.put("isNeedNotInWarehouseSpare", null);
//
//            //isSpare:=true (删除的是备件库)
//            pageData.put("isNeedWarehouseSpare", "true");
//        }

        if ("warehouse".equals(warehouseGenre)) {
            //warehouse:(简版,复杂版)仓库的入库单 清除
            pageData.put("isNeedWarehouseWarehouse", "true");
        } else if ("spare".equals(warehouseGenre)) {
            //spare:备件库的入库单 清除
            pageData.put("isNeedWarehouseSpare", "true");
        }

        warehouseOutMapper.deleteTableByRecommend(pageData);
        warehouseOutMapper.deleteTableByExecute(pageData);
        warehouseOutMapper.deleteTableByExecutor(pageData);
        warehouseOutMapper.deleteTableByDetail(pageData);

        //删除 parent 表
        warehouseOutMapper.deleteTable(pageData);
    }

    public String checkColumn(WarehouseOut object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //type 出库类型
        if (object.getType() == null || object.getType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "出库类型");
            msgBuf.append(str_isnull);
        }

        //warehouseId 所属仓库
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "所属仓库");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    public WarehouseOut findWarehouseOutById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseOut(findMap);
    }



    public WarehouseOut findWarehouseOut(PageData object) {
        if (object == null) {return null;}

        List<WarehouseOut> objectList = this.findWarehouseOutList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public List<WarehouseOut> findWarehouseOutList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseOut> objectList = new ArrayList<WarehouseOut>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }


    @Override
    public void updateState(String id) throws Exception {
        WarehouseOut warehouseOut = this.findWarehouseOutById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(warehouseOut!=null){
            List<WarehouseOutDetail> detailList = warehouseOutDetailService.findWarehouseOutDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseOutDetail warehouseOutDetail = detailList.get(i);
                    if("-1".equals(warehouseOutDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseOutDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseOutDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseOutDetail.getState())){
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
                warehouseOut.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0){
                warehouseOut.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseOut.setState("0");//未完成
            }
            this.update(warehouseOut);
        }

    }

    public void updateStateByOut(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", "id in (" + ids + ")");

        warehouseOutMapper.updateStateByOut(pageData);
    }

    ////////////////////////////////////////////////////////////////////////////////
    public WarehouseOut createWarehouseOut(String deptId, String deptName, String cuser, String companyId, String outType) {
        WarehouseOut warehouseOut = new WarehouseOut();
        //出库单编号
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_out", "O");
        warehouseOut.setCode(code);

        warehouseOut.setCompanyId(companyId);
        //出库类型 销售发货出库
        warehouseOut.setType(outType);
        warehouseOut.setDeptId(deptId);
        warehouseOut.setDeptName(deptName);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        warehouseOut.setMakeId(cuser);
        warehouseOut.setCuser(cuser);

        return warehouseOut;
    }

    @Override
    public ResultModel updateWarehouseOut(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseOut warehouseOut = (WarehouseOut) HttpUtils.pageData2Entity(pageData, new WarehouseOut());
        if (warehouseOut == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseOut 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumn(warehouseOut);
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


        //1.更新出库单表头
        this.update(warehouseOut);

        //2.更新出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        if(detailList!=null&&detailList.size()>0){
            for(int i=0;i<detailList.size();i++){
                WarehouseOutDetail detail = detailList.get(i);
                if(StringUtils.isEmpty(detail.getId())){
                    warehouseOutDetailService.addWarehouseOutDetail(warehouseOut,detail);
                }else {
                    warehouseOutDetailService.update(detail);
                }
            }
        }

        //3.删除出库单明细
        String deleteIds = pageData.getString("deleteIds");
        if(!StringUtils.isEmpty(deleteIds)){
            String[] delete_Ids = deleteIds.split(",");
            warehouseOutDetailService.deleteByIds(delete_Ids);
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseOut(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseOut warehouseOut = (WarehouseOut)HttpUtils.pageData2Entity(pageData, new WarehouseOut());
        if (warehouseOut == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseOut 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumn(warehouseOut);
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

        //1. 添加出库单
        String id = Conv.createUuid();
        warehouseOut.setId(id);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        warehouseOut.setCompanyId(companyID);
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_out", "O");
        warehouseOut.setCode(code);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
        this.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.mapList2DetailList(mapList, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, detailList);

        return model;
    }

    @Override
    public ResultModel recoveryWarehouseOut(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }
        WarehouseOut warehouseOut = this.selectById(parentId);

        //出库单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        //验证出库单是否允许取消
        if (!"-1".equals(warehouseOut.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库单不是取消状态，不能恢复！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "0");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("0");
        this.update(warehouseOut);

        return model;
    }

    @Override
    public ResultModel cancelWarehouseOut(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        //1. 根据(出库单id)-查询出库单明细(vmes_warehouse_out_detail)
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.findWarehouseOutDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许取消
        //判断明细中是否全部(0:待派单)--忽视状态(-1.已取消)
        if (!warehouseOutDetailService.isAllExistStateByDetailList("0", "-1", detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库单不可取消，该出库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "-1");
        warehouseOutDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        WarehouseOut warehouseOut = new WarehouseOut();
        warehouseOut.setId(parentId);
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseOut.setState("-1");
        this.update(warehouseOut);

        return model;
    }


    @Override
    public ResultModel deleteWarehouseOut(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        //1. 根据(出库单id)-查询出库单明细(vmes_warehouse_in_detail)
        List<WarehouseOutDetail> detailList = warehouseOutDetailService.findWarehouseOutDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许删除
        //判断明细中是否全部(0:待派单) 忽视状态:-1:已取消
        if (!warehouseOutDetailService.isAllExistStateByDetailList("0", "-1", detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前出库单不可删除，该出库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 删除出库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseOutDetailService.deleteByColumnMap(columnMap);

        //3. 删除出库单
        this.deleteById(parentId);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseOuts(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOut");
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
    public void exportExcelWarehouseOuts(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("WarehouseOut");
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
            fileName = "ExcelWarehouseOut";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseOuts(MultipartFile file) throws Exception {
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



