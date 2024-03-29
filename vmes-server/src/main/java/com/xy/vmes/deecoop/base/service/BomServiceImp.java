package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.base.dao.BomMapper;
import com.xy.vmes.entity.Bom;
import com.xy.vmes.entity.BomTree;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-09-29
*/
@Service
@Transactional(readOnly = false)
public class BomServiceImp implements BomService {


    @Autowired
    private BomMapper bomMapper;
    @Autowired
    private BomService bomService;
    @Autowired
    private BomTreeService bomTreeService;
    @Autowired
    private BomExcelService bomExcelService;
    @Autowired
    private BomTreeToProductService bomTreeToProductService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private SystemToolService systemToolService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void save(Bom bom) throws Exception{
        bom.setId(Conv.createUuid());
        bom.setCdate(new Date());
        bom.setUdate(new Date());
        bomMapper.insert(bom);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void update(Bom bom) throws Exception{
        bom.setUdate(new Date());
        bomMapper.updateById(bom);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateAll(Bom bom) throws Exception{
        bom.setUdate(new Date());
        bomMapper.updateAllColumnById(bom);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    //@Cacheable(cacheNames = "bom", key = "''+#id")
    public Bom selectById(String id) throws Exception{
        return bomMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteById(String id) throws Exception{
        bomMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        bomMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return bomMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> dataList(PageData pd) throws Exception{
        return bomMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return bomMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return bomMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        bomMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> selectByColumnMap(Map columnMap) throws Exception{
    List<Bom> bomList =  bomMapper.selectByMap(columnMap);
        return bomList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return bomMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return bomMapper.getDataListPage(pd);
        } else if (pg != null) {
            return bomMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        bomMapper.updateToDisableByIds(ids);
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    public void updateToNotDefaultByPorId(String prodId) throws Exception {
        bomMapper.updateToNotDefaultByPorId(prodId);
    }

    @Override
    public ResultModel listPageBoms(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList(pd.getString("modelCode"));
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = bomService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        String isNullAlarm = pd.getString("isNullAlarm");
        if("true".equals(isNullAlarm)){
            if(varMapList==null || varMapList.size()<=0){
                model.putCode("1");
                model.putMsg("请先为产品设置Bom！");
                return model;
            }
        }

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelBoms(PageData pd) throws Exception {
        List<Column> columnList = columnService.findColumnList("bomTreeToProduct");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        String bomId = pd.getString("bomId");
        pd.put("bomId", bomId);

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        List<Map<String, Object>> dataList = bomTreeToProductService.findBomTreeProductList(pd);
        //获取root节点
        Map<String, Object> rootMap = bomTreeToProductService.findRootMap(dataList);

        //BomTreeToProduct 查询结果集-生成Excel导出数据
        List<Map<String, Object>> bomTreeProdList = new ArrayList<>();
        bomTreeToProductService.findMapLitBomTreeToProduct(rootMap, dataList, bomTreeProdList);
        List<Map> exportMapList = bomTreeToProductService.findMapListExportExcel(bomTreeProdList);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, exportMapList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelBom";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportBomByDataList(response,
                fileName,
                rootMap,
                dataMapList);
    }

    @Override
    public ResultModel importExcelBoms(MultipartFile file) throws Exception {
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

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        //去掉列表名称行
        dataMapLst.remove(0);

        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = bomExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                userId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(this.exportExcelError(msgStr).toString());
            return model;
        }

        //2. Excel导入字段-名称唯一性判断-在Excel文件中
        //3. Excel导入字段-名称唯一性判断-在业务表中判断
        //4. Excel数据添加到货品表
        Map<String, List<Map<String, String>>> bomMap = bomExcelService.findBomMapByImportDataList(dataMapLst);
        bomExcelService.addImportExcelByMap(bomMap);

        return model;
    }


    @Override
    public ResultModel addBom(PageData pd) throws Exception {
        Bom bom = (Bom)HttpUtils.pageData2Entity(pd, new Bom());
        ResultModel model = new ResultModel();
        if(StringUtils.isEmpty(pd.getString("currentCompanyId"))){
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户公司ID为空！");
            return model;
        }
        bom.setCompanyId(pd.getString("currentCompanyId"));
        String code = coderuleService.createCoder(pd.getString("currentCompanyId"),"vmes_bom","B");
        bom.setCode(code);
        if("1".equals(bom.getIsdefault())){
            PageData pageData = new PageData();
            pageData.put("isdefault","1");
            pageData.put("prodId",pd.getString("prodId"));
            List<Map> bomList = bomService.getDataList(pageData);
            if(bomList!=null&&bomList.size()>0){
                for(int i=0;i<bomList.size();i++){
                    Map bomMap = bomList.get(i);
                    if(bomMap.get("id")!=null){
                        Bom updateBom = new Bom();
                        updateBom.setId(bomMap.get("id").toString());
                        updateBom.setIsdefault("0");
                        bomService.update(updateBom);
                    }
                }
            }
        }
        bomService.save(bom);

        BomTree bomTree = new BomTree();
        String id = Conv.createUuid();
        bomTree.setId(id);
        bomTree.setPathId(id);
        bomTree.setLayer(0);
        bomTree.setProdId(pd.getString("prodId"));
        bomTree.setParentProdId("root");
        bomTree.setRatio(BigDecimal.ONE);
        bomTree.setBomId(bom.getId());
        bomTreeService.save(bomTree);
        model.put("id",bom.getId());
        return model;
    }

    @Override
    public ResultModel updateBom(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Bom bom = (Bom)HttpUtils.pageData2Entity(pd, new Bom());
        this.update(bom);
        return model;
    }

    @Override
    public ResultModel updateIsDefaultBom(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Bom bom = (Bom)HttpUtils.pageData2Entity(pd, new Bom());
        if(!StringUtils.isEmpty(pd.getString("prodId"))){
            this.updateToNotDefaultByPorId(pd.getString("prodId"));
        }
        this.update(bom);
        return model;
    }

    @Override
    public ResultModel deleteBoms(PageData pd) throws Exception {
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
            this.deleteByIds(id_arry);
            bomTreeService.deleteByBomIds(id_arry);
        }
        return model;
    }

    private StringBuffer exportExcelError(String msgStr) {
        StringBuffer msgBuf = new StringBuffer();
        msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
        msgBuf.append(msgStr.trim());
        msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

        return msgBuf;
    }
}



