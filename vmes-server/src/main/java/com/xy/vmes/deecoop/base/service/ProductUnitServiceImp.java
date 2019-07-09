package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.base.dao.ProductUnitMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.ProductUnit;
import com.xy.vmes.entity.ProductUnitPrice;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.ProductUnitPriceService;
import com.xy.vmes.service.ProductUnitService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：产品计价单位 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-15
*/
@Service
@Transactional(readOnly = false)
public class ProductUnitServiceImp implements ProductUnitService {


    @Autowired
    private ProductUnitMapper productUnitMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private ProductUnitPriceService productUnitPriceService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void save(ProductUnit productUnit) throws Exception{
        productUnit.setId(Conv.createUuid());
        productUnit.setCdate(new Date());
        productUnit.setUdate(new Date());
        productUnitMapper.insert(productUnit);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void update(ProductUnit productUnit) throws Exception{
        productUnit.setUdate(new Date());
        productUnitMapper.updateById(productUnit);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void updateAll(ProductUnit productUnit) throws Exception{
        productUnit.setUdate(new Date());
        productUnitMapper.updateAllColumnById(productUnit);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    //@Cacheable(cacheNames = "productUnit", key = "''+#id")
    public ProductUnit selectById(String id) throws Exception{
        return productUnitMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteById(String id) throws Exception{
        productUnitMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        productUnitMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return productUnitMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> dataList(PageData pd) throws Exception{
        return productUnitMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return productUnitMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return productUnitMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        productUnitMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<ProductUnit> selectByColumnMap(Map columnMap) throws Exception{
    List<ProductUnit> productUnitList =  productUnitMapper.selectByMap(columnMap);
        return productUnitList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return productUnitMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return productUnitMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return productUnitMapper.getDataListPage(pd,pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception{
        return productUnitMapper.getDataListPage(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-15
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        productUnitMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    public void updateToNotDefaultByPorId(String productId) throws Exception{
        productUnitMapper.updateToNotDefaultByPorId(productId);
    }

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
    public List<ProductUnit> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProductUnit>();
        }

        return this.dataList(pageData);
    }

    public ProductUnit findProductUnit(PageData object) throws Exception {
        List<ProductUnit> objectList = this.findProductUnitList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public ProductUnit findProductUnitById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findProductUnit(findMap);
    }

    public List<ProductUnit> findProductUnitList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    @Override
    public ResultModel updateIsDefaultProductUnit(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        ProductUnit productUnit = (ProductUnit) HttpUtils.pageData2Entity(pd, new ProductUnit());
        if(!StringUtils.isEmpty(productUnit.getProductId())){
            this.updateToNotDefaultByPorId(productUnit.getProductId());
        }
        this.update(productUnit);
        return model;
    }

    @Override
    public ResultModel listPageProductUnits(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("ProductUnit");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }


        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
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

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
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
        return model;
    }

    @Override
    public ResultModel updateProductUnitPrice(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String id = pd.getString("id");
        String productId = pd.getString("productId");
        String remark = pd.getString("remark");

        //punit 计价单位Id
        String punit = pd.getString("punit");
        if (punit == null || punit.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("计价单位为空或空字符串，请在(单位换算)中设定(计价单位)！");
            return model;
        }

        //货品单价 productPrice
        String productPrice = pd.getString("productPrice");
        if (productPrice == null || productPrice.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品单价为空，货品单价为必填项不可为空！");
            return model;
        }

        BigDecimal productPrice_big = BigDecimal.valueOf(0D);
        try {
            productPrice_big = new BigDecimal(productPrice);
            //四舍五入到2位小数
            productPrice_big = productPrice_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        PageData findMap = new PageData();
        findMap.put("productId", productId);
        findMap.put("unit", punit);
        findMap.put("productPrice", productPrice_big.toString());
        //isdisable:是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");

        ProductUnit productUnit = this.findProductUnit(findMap);
        if (productUnit == null) {
            //添加 vmes_product_unit_price:货品价格
            ProductUnitPrice productUnitPrice = new ProductUnitPrice();
            productUnitPrice.setProductId(productId);
            productUnitPrice.setPriceUnit(punit);
            productUnitPrice.setProductPrice(productPrice_big);
//            productUnitPrice.setRemark(remark);
            productUnitPriceService.save(productUnitPrice);

            //修改 vmes_product_unit
//            ProductUnit productUnit_update = new ProductUnit();
//            productUnit_update.setId(id);
//            productUnit_update.setProductPrice(productPrice_big);
//            productUnit_update.setRemark(remark);
//            this.update(productUnit_update);
        }
        ProductUnit productUnit_update = this.selectById(id);
        productUnit_update.setProductPrice(productPrice_big);
        productUnit_update.setRemark(remark);
        this.update(productUnit_update);
        return model;
    }

    @Override
    public ResultModel findListProductUnitByProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<LinkedHashMap<String, String>> unitPriceMapList = new ArrayList<LinkedHashMap<String, String>>();
        //获取指定栏位字符串-重新调整List<Column>
        String productId = pd.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            Map result = new HashMap();
            result.put("options", unitPriceMapList);
            model.putResult(result);
            return model;
        }
        pd.put("queryStr", "pu.unit is not null and punit.name is not null");

        //设置查询排序
        pd.put("orderStr", "pu.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> mapList = this.getDataListPage(pd);
        for (Map<String, Object> mapObject : mapList) {
            LinkedHashMap<String, String> priceUnitMap = new LinkedHashMap<String, String>();

            //计价单位id punit
            String priceUnitId = (String)mapObject.get("punit");
            priceUnitMap.put("id", priceUnitId);

            //计价单位名称 priceUnitName
            String priceUnitName = (String)mapObject.get("punitName");
            priceUnitMap.put("label", priceUnitName);

            //货品价格 productPrice
            BigDecimal productPrice = BigDecimal.valueOf(0D);
            if (mapObject.get("productPrice") != null) {
                productPrice = (BigDecimal)mapObject.get("productPrice");
            }
            //四舍五入到2位小数
            productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            priceUnitMap.put("productPrice", productPrice.toString());

            //计量转换计价单位 数量转换公式 npFormula
            String n2pFormula = "";
            if (mapObject.get("npFormula") != null && mapObject.get("npFormula").toString().trim().length() > 0) {
                n2pFormula = mapObject.get("npFormula").toString().trim();
            }
            priceUnitMap.put("n2pFormula", n2pFormula);

            //计价转换计量单位 数量转换公式 pn_formula
            String p2nFormula = "";
            if (mapObject.get("pnFormula") != null && mapObject.get("pnFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("pnFormula").toString().trim();
            }
            priceUnitMap.put("p2nFormula", p2nFormula);

            unitPriceMapList.add(priceUnitMap);
        }

        Map result = new HashMap();
        result.put("options", unitPriceMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel findListProductUnit(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String priceUnitListStr = "";
        String unitPriceMapStr = "";
        String unitFormulaMapN2PStr = "";
        String unitFormulaMapP2NStr = "";

        //获取指定栏位字符串-重新调整List<Column>

        String productId = pd.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.set("priceUnitListStr", priceUnitListStr);
            model.set("unitPriceMapStr", unitPriceMapStr);
            model.set("unitFormulaMapN2PStr", unitFormulaMapN2PStr);
            model.set("unitFormulaMapP2NStr", unitFormulaMapP2NStr);
            return model;
        }

        //设置查询排序
        pd.put("orderStr", "pu.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        pd.put("queryStr", "pu.unit is not null and punit.name is not null");

        //<计价单位id, 计价单位名称> Map
        List<LinkedHashMap<String, String>> priceUnitList = new ArrayList<LinkedHashMap<String, String>>();
        //<计价单位id, 货品价格> Map
        Map<String, String> unitPriceMap = new HashMap<String, String>();

        //<计价单位id, 计量转换计价单位 数量转换公式> Map
        Map<String, String> unitFormulaMap_N2P = new HashMap<String, String>();
        //<计价单位id, 计价转换计量单位 数量转换公式> Map
        Map<String, String> unitFormulaMap_P2N = new HashMap<String, String>();

        List<Map> mapList = this.getDataListPage(pd);
        for (Map<String, Object> mapObject : mapList) {
            LinkedHashMap<String, String> priceUnitMap = new LinkedHashMap<String, String>();

            //计价单位id priceUnit -- punit
            String priceUnit = (String)mapObject.get("punit");
            //计价单位名称 priceUnitName
            String priceUnitName = (String)mapObject.get("punitName");
            //货品价格 productPrice
            BigDecimal productPrice = (BigDecimal)mapObject.get("productPrice");

            //计量转换计价单位 数量转换公式 npFormula
            String n2pFormula = "";
            if (mapObject.get("npFormula") != null && mapObject.get("npFormula").toString().trim().length() > 0) {
                n2pFormula = mapObject.get("npFormula").toString().trim();
            }

            //计价转换计量单位 数量转换公式 pn_formula
            String p2nFormula = "";
            if (mapObject.get("pnFormula") != null && mapObject.get("pnFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("pnFormula").toString().trim();
            }

            priceUnitMap.put("value", priceUnit);
            priceUnitMap.put("label", priceUnitName);
            priceUnitList.add(priceUnitMap);

            unitPriceMap.put(priceUnit, productPrice.toString());
            unitFormulaMap_N2P.put(priceUnit, n2pFormula);
            unitFormulaMap_P2N.put(priceUnit, p2nFormula);
        }
        priceUnitListStr = YvanUtil.toJson(priceUnitList);
        model.set("priceUnitListStr", priceUnitListStr);

        //计价单位id 对应的货品价格
        ArrayList<ArrayList<String>> unitPriceList = new ArrayList<ArrayList<String>>();
        //遍历 <计价单位id, 货品价格> Map
        for (Iterator iterator = unitPriceMap.keySet().iterator(); iterator.hasNext();) {
            ArrayList<String> priceList = new ArrayList<String>();

            String mapKey = (String)iterator.next();
            priceList.add(mapKey);

            String mapValue = unitPriceMap.get(mapKey);
            priceList.add(mapValue);

            unitPriceList.add(priceList);
        }
        unitPriceMapStr = YvanUtil.toJson(unitPriceList);
        model.set("unitPriceMapStr", unitPriceMapStr);

        //计价单位id 对应的单位换算公式
        ArrayList<ArrayList<String>> unitFormulaList = new ArrayList<ArrayList<String>>();
        //遍历 <计价单位id, 计量转换计价单位 数量转换公式> Map
        for (Iterator iterator = unitFormulaMap_N2P.keySet().iterator(); iterator.hasNext();) {
            ArrayList<String> formulaList = new ArrayList<String>();

            String mapKey = (String)iterator.next();
            formulaList.add(mapKey);

            String mapValue = unitFormulaMap_N2P.get(mapKey);
            formulaList.add(mapValue);

            unitFormulaList.add(formulaList);
        }
        unitFormulaMapN2PStr = YvanUtil.toJson(unitFormulaList);
        model.set("unitFormulaMapN2PStr", unitFormulaMapN2PStr);

        unitFormulaList = new ArrayList<ArrayList<String>>();
        //遍历 <计价单位id, 计价转换计量单位 数量转换公式> Map
        for (Iterator iterator = unitFormulaMap_P2N.keySet().iterator(); iterator.hasNext();) {
            ArrayList<String> formulaList = new ArrayList<String>();

            String mapKey = (String)iterator.next();
            formulaList.add(mapKey);

            String mapValue = unitFormulaMap_P2N.get(mapKey);
            formulaList.add(mapValue);

            unitFormulaList.add(formulaList);
        }
        unitFormulaMapP2NStr = YvanUtil.toJson(unitFormulaList);
        model.set("unitFormulaMapP2NStr", unitFormulaMapP2NStr);
        return model;
    }

    @Override
    public ResultModel formulaReckonByProductCount(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        //公式 formula (计量转换计价单位 公式计算)
        //P=8*N  N(计量单位数量) P(计价单位数量)
        String formula = pd.getString("formula");

        //N(计量单位数量) P(计价单位数量)
        String parmKey = pd.getString("parmKey");

        Map<String, Object> parmMap = new HashMap<String, Object>();
        BigDecimal valueBig = null;

        //1. 库存数量 stockCount  计量转换计价 (单位换算)
        BigDecimal stockCountBig = BigDecimal.valueOf(0D);
        String stockCount = pd.getString("stockCount");
        if (stockCount != null && stockCount.trim().length() > 0) {
            parmMap.put(parmKey, stockCount);

            //(库存数量) 计量转换计价 通过公式 单位换算
            valueBig = EvaluateUtil.formulaReckon(parmMap, formula);
            if (valueBig != null) {
                stockCountBig = valueBig;
            }
            //四舍五入到2位小数
            stockCountBig = stockCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            model.set("stockCount_n2p", stockCountBig.toString());
        }

        //2. 库存可用数量 productStockCount 计量转换计价 (单位换算)
        BigDecimal productStockCountBig = BigDecimal.valueOf(0D);
        String productStockCount = pd.getString("productStockCount");
        if (productStockCount != null && productStockCount.trim().length() > 0) {
            parmMap.put(parmKey, productStockCount);
            //(库存可用数量) 计量转换计价 通过公式 单位换算
            valueBig = EvaluateUtil.formulaReckon(parmMap, formula);
            if (valueBig != null) {
                productStockCountBig = valueBig;
            }
            //四舍五入到2位小数
            productStockCountBig = productStockCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            model.set("productStockCount_n2p", productStockCountBig.toString());
        }

        //3. (计价单位数量)订购数量 count  计价转换计量 (单位换算)
        BigDecimal countBig = BigDecimal.valueOf(0D);
        String count = pd.getString("count");
        if (count != null && count.trim().length() > 0) {
            parmMap.put(parmKey, count);
            //(订购数量) 计价转换计量 通过公式 单位换算
            valueBig = EvaluateUtil.formulaReckon(parmMap, formula);
            if (valueBig != null) {
                countBig = valueBig;
            }
            //四舍五入到2位小数
            countBig = countBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            model.set("count_p2n", countBig.toString());
        }
        return model;
    }

    @Override
    public void exportExcelProductUnits(PageData pd,Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("ProductUnit");
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
            fileName = "ExcelProductUnit";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

//    @Override
//    public ResultModel importExcelProductUnits(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//        return model;
//    }
}



