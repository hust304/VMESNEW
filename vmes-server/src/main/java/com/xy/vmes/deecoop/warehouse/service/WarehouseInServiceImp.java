package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_warehouse_in:仓库入库单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInServiceImp implements WarehouseInService {

    @Autowired
    private WarehouseInMapper warehouseInMapper;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseInWarehouseProductService warehouseInWarehouseProductService;



    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setCdate(new Date());
        warehouseIn.setUdate(new Date());
        warehouseInMapper.insert(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setUdate(new Date());
        warehouseInMapper.updateById(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseIn warehouseIn) throws Exception{
        warehouseIn.setUdate(new Date());
        warehouseInMapper.updateAllColumnById(warehouseIn);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseIn> dataList(PageData pd) throws Exception{
        return warehouseInMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseIn> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseIn> warehouseInList =  warehouseInMapper.selectByMap(columnMap);
        return warehouseInList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseInMapper.getDataListPage(pd,pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception {
        return warehouseInMapper.getDataListPage(pd);
    }
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
//    public void deleteTableByWarehouseIn(String companyId) throws Exception {
//        PageData pageData = new PageData();
//        pageData.put("companyId", companyId);
//
//        warehouseInMapper.deleteTableByExecute(pageData);
//        warehouseInMapper.deleteTableByExecutor(pageData);
//        warehouseInMapper.deleteTableByDetail(pageData);
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
    public void deleteTableByWarehouseIn(String companyId, String warehouseGenre) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);

        if ("warehouse".equals(warehouseGenre)) {
            //warehouse:(简版,复杂版)仓库的入库单 清除
            pageData.put("isNeedWarehouseWarehouse", "true");
        } else if ("spare".equals(warehouseGenre)) {
            //spare:备件库的入库单 清除
            pageData.put("isNeedWarehouseSpare", "true");
        }

        warehouseInMapper.deleteTableByExecute(pageData);
        warehouseInMapper.deleteTableByExecutor(pageData);
        warehouseInMapper.deleteTableByDetail(pageData);

        //删除 parent 表
        warehouseInMapper.deleteTable(pageData);
    }

    public WarehouseIn findWarehouseIn(PageData object) {
        if (object == null) {return null;}

        List<WarehouseIn> objectList = this.findWarehouseInList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public WarehouseIn findWarehouseInById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseIn(findMap);
    }

    public List<WarehouseIn> findWarehouseInList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseIn> objectList = new ArrayList<WarehouseIn>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public WarehouseIn createWarehouseIn(String deptId, String deptName, String cuser, String companyId, String inType) {
        WarehouseIn warehouseIn = new WarehouseIn();
        warehouseIn.setId(Conv.createUuid());
        //入库单编号
        String code = coderuleService.createCoder(companyId, "vmes_warehouse_in", "I");
        warehouseIn.setCode(code);

        warehouseIn.setCompanyId(companyId);
        //入库类型 销售退货入库
        warehouseIn.setType(inType);
        warehouseIn.setDeptId(deptId);
        warehouseIn.setDeptName(deptName);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setMakeId(cuser);
        warehouseIn.setCuser(cuser);

        return warehouseIn;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public String checkColumn(WarehouseIn object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        //type 入库类型
        if (object.getType() == null || object.getType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "入库类型");
            msgBuf.append(str_isnull);
        }

        //warehouseId 所属仓库
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "所属仓库");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    @Override
    public void updateState(String id) throws Exception {
        WarehouseIn warehouseIn = this.findWarehouseInById(id);
        int yqx = 0;//已取消
        int dpd = 0;//待派单
        int zxz = 0;//执行中
        int ywc = 0;//已完成
        if(warehouseIn!=null){
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(id);
            if(detailList!=null&&detailList.size()>0){
                for(int i=0;i<detailList.size();i++){
                    WarehouseInDetail warehouseInDetail = detailList.get(i);
                    if("-1".equals(warehouseInDetail.getState())){
                        yqx = yqx + 1;
                    }else if("0".equals(warehouseInDetail.getState())){
                        dpd = dpd + 1;
                    }else if("1".equals(warehouseInDetail.getState())){
                        zxz = zxz + 1;
                    }else if("2".equals(warehouseInDetail.getState())){
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
                warehouseIn.setState("-1");//已取消
            }
            //该出库单明细状态全是已完成和已取消状态，则说明当前出库单状态为已完成
            else if(ywc>0&&yqx>=0&&zxz==0&&dpd==0){
                warehouseIn.setState("1");//已完成
            }
            //除了以上两种特殊情况，其他情况下的出库单状态均为未完成
            else{
                warehouseIn.setState("0");//未完成
            }
            this.update(warehouseIn);
        }

    }

    @Override
    public ResultModel listPageWarehouseIn(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseIn");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        Map result = new HashMap();
        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

//        //type 入库类型
//        String type = new String();
//        if (pd.get("type") != null && ((List)pd.get("type")).size() > 0) {
//            type = ((List)pd.get("type")).get(0).toString();
//        }
//        if (type != null && type.trim().length() > 0) {
//            pd.put("type", type);
//        } else {pd.put("type", new String());}

        pd.put("orderStr", "a.cdate desc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel addWarehouseIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseIn warehouseIn = (WarehouseIn) HttpUtils.pageData2Entity(pageData, new WarehouseIn());
        if (warehouseIn == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 仓库对象WarehouseIn 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumn(warehouseIn);
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
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_in", "I");
        warehouseIn.setCode(code);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseIn.setWarehouseAttribute("warehouse");
        this.save(warehouseIn);

        //2.添加入库单明细
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        warehouseInDetailService.addWarehouseInDetail(warehouseIn, detailList);

        return model;
    }

    @Override
    public ResultModel updateWarehouseIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseIn warehouseIn = (WarehouseIn)HttpUtils.pageData2Entity(pageData, new WarehouseIn());
        if (warehouseIn == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 WarehouseIn 异常！");
            return model;
        }

        //非空判断
        String msgStr = this.checkColumn(warehouseIn);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
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

        //1.更新入库单明细
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseInDetail detail : detailList) {
                String detailId = detail.getId();
                if (detailId == null || detailId.trim().length() == 0) {
                    String id = Conv.createUuid();
                    detail.setId(id);
                    //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("0");
                    detail.setParentId(warehouseIn.getId());
                    detail.setCuser(warehouseIn.getCuser());

                    //生成二维码
                    String QRCodeJson = warehouseInDetailService.warehouseInDtl2QRCode(detail);
                    String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
                    if (qrcode != null && qrcode.trim().length() > 0) {
                        detail.setQrcode(qrcode);
                    }
                    warehouseInDetailService.save(detail);
                }
                else {
                    //生成二维码
//                    WarehouseInDetail QRCodeObj = warehouseInDetailService.warehouseInDtl2QRCodeObj(detail, null);
//                    String qrcode = fileService.createQRCode("warehouseBase", YvanUtil.toJson(QRCodeObj));
//                    if (qrcode != null && qrcode.trim().length() > 0) {
//                        detail.setQrcode(qrcode);
//                    }

                    if (detail.getRemark() == null || detail.getRemark().trim().length() == 0) {
                        detail.setRemark("");
                    }

                    warehouseInDetailService.update(detail);
                }
            }
        }

        //2.更新入库单表头
        this.update(warehouseIn);

        //3.删除入库单明细
        String deleteIds = pageData.getString("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            deleteIds = StringUtil.stringTrimSpace(deleteIds);
            String[] delete_Ids = deleteIds.split(",");
            warehouseInDetailService.deleteByIds(delete_Ids);
        }

        return model;
    }

    @Override
    public ResultModel cancelWarehouseIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //1. 根据(入库单id)-查询入库单明细(vmes_warehouse_in_detail)
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许取消
        //判断明细中是否全部(0:待派单)--忽视状态(-1.已取消)
        if (!warehouseInDetailService.isAllExistStateByDetailList("0", "-1", detailList)) {
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
        this.update(warehouseIn);

        return model;
    }

    @Override
    public ResultModel recoveryWarehouseIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //入库单状态:state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseIn warehouseIn = this.findWarehouseInById(parentId);
        //验证出库单是否允许取消
        if (!"-1".equals(warehouseIn.getState())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单不是取消状态，不可恢复！");
            return model;
        }

        //2. 修改明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "0");
        warehouseInDetailService.updateStateByDetail(mapDetail);

        //3. 修改抬头表状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        this.update(warehouseIn);
        return model;
    }

    @Override
    public ResultModel deleteWarehouseIn(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        //1. 根据(入库单id)-查询入库单明细(vmes_warehouse_in_detail)
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        //验证明细是否允许删除
        //判断明细中是否全部(0:待派单) 忽视状态:-1:已取消
        if (!warehouseInDetailService.isAllExistStateByDetailList("0", "-1", detailList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单不可删除，该入库单中含有(1:执行中 2:已完成)状态，请核对后再次操作！");
            return model;
        }

        //2. 删除入库单明细
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        warehouseInDetailService.deleteByColumnMap(columnMap);

        //3. 删除入库单
        this.deleteById(parentId);

        return model;
    }

    @Override
    public void exportExcelWarehouseIn(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("warehouseIn");
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
            fileName = "ExcelWarehouseIn";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseIn(MultipartFile file) throws Exception {
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

    @Override
    public ResultModel listPageWarehouseInDetail(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
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

        pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
        if(varList!=null&&varList.size()>0){
            //获取当前企业全部<货位id, 货位名称>
            String companyId = pd.getString("currentCompanyId");
            warehouseService.implementBusinessMapByCompanyId(companyId);
            Map<String, String> keyNameMap = warehouseService.getKeyNameMap();


            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);

                //warehouseId 仓库货位id
                String warehouseId = "";
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    String mapKey = entry.getKey();
                    Object mapValue = map.get(mapKey);

                    //warehouseName 推荐库位
                    if ("warehouseName".equals(mapKey)) {
                        Product product = new Product();
                        product.setId((String)map.get("productId"));
                        product.setType((String)map.get("productType"));
                        String warehouseId_sys = warehouseProductService.findDefaultWarehousePosition(companyId, product);
                        String warehouseName = new String();
                        if (warehouseId_sys == null || warehouseId_sys.trim().length() == 0) {
//                            warehouseName = "无推荐货位，系统历史中无存放当前货品记录，系统中没有空货位！";
                            warehouseName = "无推荐货位！";
                        } else {
                            warehouseName = keyNameMap.get(warehouseId_sys);
                            if (warehouseName == null || warehouseName.trim().length() == 0) {
//                                warehouseName = "推荐货位id:" + warehouseId_sys + " 该货位以取消或系统中不存在！";
                                warehouseName = "无推荐货位！";
                            } else {
                                warehouseId = warehouseId_sys;
                            }
                        }

                        varMap.put(mapKey, warehouseName);
                    } else {
                        varMap.put(mapKey, mapValue != null ? mapValue.toString() : "");
                    }
                }
                varMap.put("warehouseId", warehouseId);
                varMapList.add(varMap);
            }
        }

        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel findWarehouseListByWarehouseIn(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDispatchWarehouseProduct");
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

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        pd.put("orderStr", "warehouseProduct.product_id,warehouseProduct.productType,warehouse.layer,warehouse.serial_number");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        String notInWarehouseIds = new String();
        if (pd.getString("notInWarehouseIds") != null && pd.getString("notInWarehouseIds").trim().length() > 0) {
            notInWarehouseIds = pd.getString("notInWarehouseIds").trim();
            notInWarehouseIds = StringUtil.stringTrimSpace(notInWarehouseIds);
            notInWarehouseIds = "'" + notInWarehouseIds.replace(",", "','") + "'";
        }
        pd.put("notInWarehouseIds", notInWarehouseIds);


        List<Map> varList = warehouseInWarehouseProductService.findAllListWarehouse(pd, pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel updateWarehouseInDispatch(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String executeId = pageData.getString("executeId");
        if (executeId == null || executeId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "[{\"id\":\"6d1e4503db6f46bcb22249b29abd4e27\",\"warehouseId\":\"0f1ca6d8e3614c9895edfc655433914c\"},{\"id\":\"824cdac10bb54c7aa62441e55696597e\",\"warehouseId\":\"45f58566a8534c77a63a0a8882d76def\"}]";

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

        //1. 入库单明细派单
        List<WarehouseInDetailEntity> detailList = warehouseInDetailService.mapList2DetailEntityList(mapList, null);
        String msgStr = warehouseInDetailService.checkDispatcheDetailList(detailList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        for (WarehouseInDetailEntity entity : detailList) {
            entity.setCuser(cuser);
            //企业id
            entity.setCompanyId(companyId);

            //入库明细分配执行人
            //添加设置任务待办表
            warehouseInExecutorService.addWarehouseInExecutor(entity, executeId);

            WarehouseInDetail inDetail = new WarehouseInDetail();
            inDetail.setId(entity.getId());
            //(推荐)货位ID
            inDetail.setWarehouseId(entity.getWarehouseId());
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            inDetail.setState("1");
            //detail.setExecuteId(executeId);
            warehouseInDetailService.update(inDetail);
        }

        return model;
    }
}



