package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.SaleUnitPriceExcelService;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleUnitPriceMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleUnitPrice;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleUnitPriceService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：设置锁库时间 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-14
*/
@Service
@Transactional(readOnly = false)
public class SaleUnitPriceServiceImp implements SaleUnitPriceService {

    @Autowired
    private SaleUnitPriceMapper saleUnitPriceMapper;
    @Autowired
    private SaleUnitPriceExcelService saleUnitPriceExcelService;

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void save(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setId(Conv.createUuid());
        saleUnitPrice.setCdate(new Date());
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.insert(saleUnitPrice);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void update(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.updateById(saleUnitPrice);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void updateAll(SaleUnitPrice saleUnitPrice) throws Exception{
        saleUnitPrice.setUdate(new Date());
        saleUnitPriceMapper.updateAllColumnById(saleUnitPrice);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    //@Cacheable(cacheNames = "saleUnitPrice", key = "''+#id")
    public SaleUnitPrice selectById(String id) throws Exception{
        return saleUnitPriceMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleUnitPriceMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleUnitPriceMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleUnitPriceMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> dataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleUnitPriceMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleUnitPriceMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<SaleUnitPrice> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleUnitPrice> saleUnitPriceList =  saleUnitPriceMapper.selectByMap(columnMap);
        return saleUnitPriceList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleUnitPriceMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleUnitPriceMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleUnitPriceMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleUnitPriceMapper.getDataListPage(pd, pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-14
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleUnitPriceMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<SaleUnitPrice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleUnitPrice>();
        }

        return this.dataList(pageData);
    }

//    /**
//     * 创建人：刘威
//     * 创建时间：2018-12-14
//     */
//    @Override
//    public List<Map> getCustomerUnitPriceListPage(PageData pd,Pagination pg) throws Exception{
//        return saleUnitPriceMapper.getCustomerUnitPriceListPage(pd,pg);
//    }

//    /**
//     * 创建人：刘威
//     * 创建时间：2018-12-14
//     */
//    @Override
//    public List<Map> getCustomerUnitPriceHisListPage(PageData pd,Pagination pg) throws Exception{
//        return saleUnitPriceMapper.getCustomerUnitPriceHisListPage(pd,pg);
//    }
    @Override
    public SaleUnitPrice findSaleUnitPrice(PageData object) throws Exception {
        List<SaleUnitPrice> objectList = this.findSaleUnitPriceList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    @Override
    public SaleUnitPrice findSaleUnitPriceById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleUnitPrice(findMap);
    }
    @Override
    public List<SaleUnitPrice> findSaleUnitPriceList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    @Override
    public String checkColumn(SaleUnitPrice object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;

        //productId 货品ID
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "货品ID");
            msgBuf.append(str_isnull);
        }

        //unit 单位id
        if (object.getUnit() == null || object.getUnit().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "单位id");
            msgBuf.append(str_isnull);
        }

        //customerId 客户ID
        if (object.getCustomerId() == null || object.getCustomerId().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "客户ID");
            msgBuf.append(str_isnull);
        }

        //productPrice 货品单价
        if (object.getProductPrice() == null) {
            String str_isnull = MessageFormat.format(column_isnull, "货品单价");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    public void modifySaleUnitPrice(SaleUnitPrice object) throws Exception {
        //productId 货品ID
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            return;
        }
        //unit 单位id
        if (object.getUnit() == null || object.getUnit().trim().length() == 0) {
            return;
        }
        //customerId 客户ID
        if (object.getCustomerId() == null || object.getCustomerId().trim().length() == 0) {
            return;
        }
        //productPrice 货品单价
        if (object.getProductPrice() == null) {
            return;
        }
        //四舍五入到2位小数
        object.setProductPrice(object.getProductPrice().setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP));
        object.setUuser(object.getCuser());

        PageData findMap = new PageData();
        findMap.put("productId", object.getProductId());
        findMap.put("unit", object.getUnit());
        findMap.put("customerId", object.getCustomerId());

        SaleUnitPrice objectDB = this.findSaleUnitPrice(findMap);
        if (objectDB == null) {
            this.save(object);
        } else {
            objectDB.setProductPrice(object.getProductPrice());
            objectDB.setUuser(object.getCuser());
            this.update(objectDB);
        }
    }

//    @Override
//    public ResultModel listPageCustomerUnitPricesHis(PageData pd, Pagination pg) throws Exception {
//        ResultModel model = new ResultModel();
//
//        Map result = new HashMap();
//
//        List<Column> columnList = columnService.findColumnList("CustomerUnitPriceHis");
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
//        List<Map> varList = this.getCustomerUnitPriceHisListPage(pd,pg);
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
//        return model;
//    }

//    @Override
//    public ResultModel listPageCustomerUnitPrices(PageData pd, Pagination pg) throws Exception {
//        ResultModel model = new ResultModel();
//        Map result = new HashMap();
//
//        List<Column> columnList = columnService.findColumnList("CustomerUnitPrice");
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
//        List<Map> varList = this.getCustomerUnitPriceListPage(pd,pg);
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
//        return model;
//    }

    @Override
    public ResultModel listPageSaleUnitPrices(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("SaleUnitPrice");
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

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel updateSaleUnitPriceByPrice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        SaleUnitPrice saleUnitPrice = (SaleUnitPrice) HttpUtils.pageData2Entity(pageData, new SaleUnitPrice());
        String msgStr = this.checkColumn(saleUnitPrice);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode("1");
            model.putMsg(msgStr);
            return model;
        }

        PageData findMap = new PageData();
        findMap.put("productId", saleUnitPrice.getProductId());
        findMap.put("unit", saleUnitPrice.getUnit());
        findMap.put("customerId", saleUnitPrice.getCustomerId());

        SaleUnitPrice objectDB = this.findSaleUnitPrice(findMap);
        if (objectDB == null) {
            this.save(saleUnitPrice);
        } else {
            this.update(saleUnitPrice);
        }
        return model;
    }

    @Override
    public ResultModel findSaleUnitPriceNew(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String productId = pageData.getString("productId");
        String unit = pageData.getString("unit");
        String customerId = pageData.getString("customerId");

        if (productId == null || productId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品id为空或空字符串！");
            return model;
        }
        if (unit == null || unit.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("单位id为空或空字符串！");
            return model;
        }
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        //isdisable:是否启用(0:已禁用 1:启用)
        pageData.put("isdisable", "1");
        if (pageData.getString("isdisable") != null && pageData.getString("isdisable").trim().length() > 0) {
            pageData.put("isdisable", pageData.getString("isdisable").trim());
        }

        pageData.put("orderStr", "cdate desc");
        if (pageData.getString("orderStr") != null && pageData.getString("orderStr").trim().length() > 0) {
            pageData.put("orderStr", pageData.getString("orderStr").trim());
        }

        List<SaleUnitPrice> objectList = this.findSaleUnitPriceList(pageData);
        if (objectList != null && objectList.size() > 0 && objectList.get(0).getProductPrice() != null) {
            BigDecimal productPrice = objectList.get(0).getProductPrice();
            //四舍五入到2位小数
            productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            model.set("productPrice", productPrice.toString());
        }

        return model;
    }

    @Override
    public void exportExcelSaleUnitPrices(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("SaleUnitPrice");
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
            fileName = "ExcelSaleUnitPrice";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelSaleUnitPrice(MultipartFile file) throws Exception {
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
        String companyId = httpRequest.getParameter("companyId");
        String userId = httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        dataMapLst.remove(0);

        StringBuffer checkColumnMsgStr = new StringBuffer();
        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = saleUnitPriceExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            checkColumnMsgStr.append(msgStr);
        }

        if (checkColumnMsgStr.toString().trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(checkColumnMsgStr.toString().trim());
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //2. 添加系统基础表
        // 1. 客户表
        // 2. 货品表
        // 3. 字典表(计量单位)

        //系统客户Map结构体: <客户名称, 客户id>
        Map<String, String> sysCustomerMap = new LinkedHashMap<>();
        //系统货品Map结构体: <货品名称_规格型号, 货品id>
        Map<String, String> sysProductMap = new LinkedHashMap<>();
        //系统字典表Map<单位名称, 单位id>
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("productUnit"), companyId);
        Map<String, String> sysUnitMap = dictionaryService.getNameKeyMap();

        saleUnitPriceExcelService.addSystemBaseTableImportExcel(dataMapLst,
                companyId,
                userId,
                sysCustomerMap,
                sysUnitMap,
                sysProductMap);

        //3. 遍历Excel导入List-Map<客户id_货品id_单位id, SaleUnitPrice>
        Map<String, SaleUnitPrice> saleUnitPriceMap = new HashMap<>();
        saleUnitPriceExcelService.findSaleUnitPriceMapByExcelList(dataMapLst,
                saleUnitPriceMap,
                sysCustomerMap,
                sysUnitMap,
                sysProductMap);

        //4. 遍历Map<String, SaleUnitPrice> 对业务表添加
        saleUnitPriceExcelService.addSaleUnitPrice(saleUnitPriceMap, companyId, userId);

        return model;
    }
}

