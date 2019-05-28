package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.base.dao.ProductMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_product:产品表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-09-21
*/
@Service
@Transactional(readOnly = false)
public class ProductServiceImp implements ProductService {


    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private ProductUnitPriceService productUnitPriceService;
    @Autowired
    private ProductPropertyService productPropertyService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private ProductExcelService productExcelService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void save(Product product) throws Exception{
        product.setCdate(new Date());
        product.setUdate(new Date());
        productMapper.insert(product);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void update(Product product) throws Exception{
        product.setUdate(new Date());
        productMapper.updateById(product);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void updateAll(Product product) throws Exception{
        product.setUdate(new Date());
        productMapper.updateAllColumnById(product);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    //@Cacheable(cacheNames = "product", key = "''+#id")
    public Product selectById(String id) throws Exception{
        return productMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteById(String id) throws Exception{
        productMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        productMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> dataListPage(PageData pd,Pagination pg) throws Exception{
        return productMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> dataList(PageData pd) throws Exception{
        return productMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return productMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return productMapper.findDataList(pd);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        productMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Product> selectByColumnMap(Map columnMap) throws Exception{
    List<Product> productList =  productMapper.selectByMap(columnMap);
        return productList;
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return productMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return productMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-21
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        productMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void initialProductByStockCount(String companyId) throws Exception {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        productMapper.updateProductInitialByStockCount(pageData);
    }

    public Product findProductById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findProduct(findMap);
    }

    public Product findProduct(PageData object) {
        if (object == null) {return null;}

        List<Product> objectList = this.findProductList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public List<Product> findProductList(PageData object) {
        if (object == null) {return null;}

        List<Product> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public String findIdsByProductList(List<Product> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Product object : objectList) {
            strBuf.append(object.getId().trim());
            strBuf.append(",");
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    public String findIdsByPageMapList(List<Map> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, Object> mapObject : mapList) {
            String productId = (String)mapObject.get("id");
            if (productId != null && productId.trim().length() > 0) {
                strBuf.append(productId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
        }
        return strTemp;
    }

    public List<Map> getDataListPage(PageData pd) throws Exception {
        return productMapper.getDataListPage(pd);
    }

    public Map<String, String> productObj2QRCodeObj(Product productObj, Map<String, String> QRCodeObj) {
        if (QRCodeObj == null) {QRCodeObj = new LinkedHashMap<String, String>();}
        if (productObj == null) {return QRCodeObj;}

        QRCodeObj.put("id", productObj.getId());

        String name = new String();
        if (productObj.getName() != null && productObj.getName().trim().length() > 0) {
            name = productObj.getName().trim();
        }
        QRCodeObj.put("name", name);

        String spec = new String();
        if (productObj.getSpec() != null && productObj.getSpec().trim().length() > 0) {
            name = productObj.getSpec().trim();
        }
        QRCodeObj.put("spec", spec);

        return QRCodeObj;
    }

    public ProductUnit product2ProductUnit(Product product, ProductUnit productUnit,String unit) {
        if (productUnit == null) {productUnit = new ProductUnit();}
        if (product == null) {return productUnit;}

        //货品id productId
        productUnit.setProductId(product.getId());
        //计价单位 unit
        productUnit.setUnit(unit);
        //计量转换计价单位 单位换算公式 np_formula
        productUnit.setNpFormula("P=N");
        //计价转换计量单位 单位换算公式 pn_formula
        productUnit.setPnFormula("N=P");
        productUnit.setIsdefault("1");
        productUnit.setType("1");
        //创建人id
        productUnit.setCuser(product.getCuser());
        //货品单价 productPrice
        if (product.getPrice() != null) {
            productUnit.setProductPrice(product.getPrice());
        }

        return productUnit;
    }

    public ProductUnitPrice product2ProductUnitPrice(Product product, ProductUnitPrice productUnitPrice,String unit) {
        if (productUnitPrice == null) {productUnitPrice = new ProductUnitPrice();}
        if (product == null) {return productUnitPrice;}

        //货品ID productId
        productUnitPrice.setProductId(product.getId());
        //计价单位ID priceUnit
        productUnitPrice.setPriceUnit(unit);
        //货品单价 productPrice
        productUnitPrice.setProductPrice(product.getPrice());
        //创建用户id cuser
        productUnitPrice.setCuser(product.getCuser());

        return productUnitPrice;
    }

    public Map<String, String> queryMap2ProductMap(Map queryMap, Map<String, String> productMap) {
        if (productMap == null) {productMap = new HashMap<String, String>();}
        if (queryMap == null || queryMap.size() == 0) {return productMap;}

        //货品id id productId
        productMap.put("productId", (String)queryMap.get("id"));

        //货品编号 code productCode
        String code = new String();
        if (queryMap.get("code") != null) {
            code = queryMap.get("code").toString().trim();
        }
        productMap.put("productCode", code);

        //货品名称 name productName
        String name = new String();
        if (queryMap.get("name") != null) {
            name = queryMap.get("name").toString().trim();
        }
        productMap.put("productName", name);

        //货品规格型号 spec productSpec
        String spec = new String();
        if (queryMap.get("spec") != null) {
            spec = queryMap.get("spec").toString().trim();
        }
        productMap.put("productSpec", spec);

        //货品属性 genreName productGenreName
        String genreName = new String();
        if (queryMap.get("genreName") != null) {
            genreName = queryMap.get("genreName").toString().trim();
        }
        productMap.put("productGenreName", genreName);

        //货品单位 unitName productUnitName
        String unitName = new String();
        if (queryMap.get("unitName") != null) {
            unitName = queryMap.get("unitName").toString().trim();
        }
        productMap.put("productUnitName", unitName);

        //库存数量 stockCount
        String stockCount = new String("0");
        BigDecimal stockCount_big = BigDecimal.valueOf(0D);
        if (queryMap.get("stockCount") != null) {
            String stockCount_str = queryMap.get("stockCount").toString().trim();
            try {
                stockCount_big = new BigDecimal(stockCount_str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (stockCount_big.doubleValue() != 0) {
                //四舍五入到2位小数
                stockCount_big = stockCount_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                stockCount = stockCount_big.toString();
            }
        }
        productMap.put("stockCount", stockCount);

        return productMap;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void updateStockCount(Product product, BigDecimal count,String uuser) throws Exception {
        PageData pd = new PageData();
        pd.put("id",product.getId());
        pd.put("version",product.getVersion());
        pd.put("uuser",uuser);
        pd.put("stockCount",count);

        Integer updateValue = null;
        try {
            updateValue = productMapper.updateStockCount(pd);
        } catch (Exception e) {}

        if (updateValue == null || 0 == updateValue.intValue()) {
            throw new Exception("当前系统繁忙，请稍后操作！");
        }
    }

    public void updateLockCount(String productId, Product oldProduct, BigDecimal lockCount, String uuser) throws Exception {
        if (productId == null || productId.trim().length() == 0) {return;}
        if (lockCount == null) {return;}
        if (oldProduct == null) {oldProduct = this.findProductById(productId);}

        double old_lockCount = 0D;
        if (oldProduct != null && oldProduct.getLockCount() != null) {
            old_lockCount = oldProduct.getLockCount().doubleValue();
        }
        double new_lockCount = old_lockCount + lockCount.doubleValue();

        BigDecimal lockCountBig = BigDecimal.valueOf(0D);
        if (new_lockCount > 0) {
            //四舍五入到2位小数
            lockCountBig = BigDecimal.valueOf(new_lockCount);
            lockCountBig = lockCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        }

        Product product = new Product();
        product.setId(productId);
        product.setLockCount(lockCountBig);
        if (uuser != null && uuser.trim().length() > 0) {
            product.setUuser(uuser);
        }

        this.update(product);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel listPageProducts(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("product");
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


        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }else{
            pd.put("orderStr", "prod.cdate desc");
        }

        String genreId = pd.getString("genreId");
        if (genreId != null && genreId.trim().length() > 0
                && !Common.DICTIONARY_MAP.get("productGenre").equals(genreId)
                ) {
            pd.put("genre", genreId);
        }

        String pathId = pd.getString("pathId");
        if(!StringUtils.isEmpty(pathId)){
            String[] ids = pathId.split("_");
            String idStr = "";
            if(ids!=null&&ids.length>0){
                for(int i=0;i<ids.length;i++){
                    if(StringUtils.isEmpty(idStr)){
                        idStr = "'"+ids[i]+"'";
                    }else{
                        idStr = idStr + " , '"+ids[i]+"'";
                    }
                }

            }
            if(!StringUtils.isEmpty(idStr)){
                String queryStr = " prod.id not in (select prod_id from vmes_bom_tree where id in ("+idStr+") ) ";
                pd.put("queryStr", queryStr);
            }
        }


        //isNeedCustomerPrice 是否需要客户货品单价 (true:需要客户单价 false:无需客户单价 is null 无需客户单价)
        String isNeedCustomerPrice = pd.getString("isNeedCustomerPrice");
        String customerId = pd.getString("customerId");

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd, pg);


        //当前查询页数据-获取货品id字符串(','逗号分隔的字符串)
        String ids = this.findIdsByPageMapList(varList);
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            queryStr = "'" + ids.replace(",", "','") + "'";
        }

        //当前查询页数据-货品id查询(货品属性表)
        PageData findMap = new PageData();
        findMap.put("queryProdIdsStr", queryStr);
        findMap.put("isdisable", "1");
        findMap.put("orderStr", "prod_id,cdate");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<ProductProperty> productPropertyList = productPropertyService.findProductPropertyList(findMap);

        Map<String, String> mapObject = productPropertyService.findProdPropertyJsonByProductPropertyList(productPropertyList);
//        Map<String, String> nameMap = productPropertyService.findProdPropertyNameByProductPropertyList(productPropertyList);

        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                //price 货品价格
                //BigDecimal price = (BigDecimal)map.get("price");

                //customerPrice 货品客户价格
                BigDecimal customerPrice = (BigDecimal)map.get("customerPrice");
                if ("true".equals(isNeedCustomerPrice) && customerPrice != null && customerPrice.doubleValue() > 0) {
                    map.put("price", customerPrice);
                }

                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    String mapKey = entry.getKey();
                    Object mapValue = map.get(mapKey);
                    //获取产品物料-自定义属性
                    if ("prodPropertyJsonStr".equals(mapKey)) {
                        String prodId = (String)map.get("id");
                        String jsonString = "";
                        if (mapObject.get(prodId) != null) {
                            jsonString = mapObject.get(prodId).trim();
                            varMap.put(mapKey, jsonString);
                        }
                    } else if ("prodProperty".equals(mapKey)) {
                        String prodId = (String)map.get("id");
                        if (mapObject.get(prodId) != null) {
                            String showString = mapObject.get(prodId+"_show").trim();
                            varMap.put(mapKey, showString);
                        }
                    } else {
                        varMap.put(mapKey, mapValue != null ? mapValue.toString() : "");
                    }

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
    public ResultModel listPageProductPropertys(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("productProperty");
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

        //无需分页
        pg.setSize(100000);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd, pg);
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
    public ResultModel addProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        //获取产品编码
        String companyId = pageData.getString("currentCompanyId");
        String code = coderuleService.createCoder(companyId,"vmes_product","P");
        if(StringUtils.isEmpty(code)){
            model.putCode(1);
            model.putMsg("产品编码规则创建异常，请重新操作！");
            return model;
        }

        //2. 添加产品表(vmes_product)
        Product product = (Product) HttpUtils.pageData2Entity(pageData, new Product());
        product.setCuser(pageData.getString("cuser"));
        product.setCompanyId(companyId);
        product.setCode(code);

        //生成产品二维码
        product.setId(Conv.createUuid());
        String qrcode = fileService.createQRCode("product", product.getId());
        if (qrcode != null && qrcode.trim().length() > 0) {
            product.setQrcode(qrcode);
        }
        this.save(product);

        //3. 添加 vmes_product_unit
        ProductUnit productUnit = this.product2ProductUnit(product, null,pageData.getString("unit"));
        productUnitService.save(productUnit);

        //4. 添加 vmes_product_unit_price
        if (product.getPrice() != null) {
            ProductUnitPrice productUnitPrice = this.product2ProductUnitPrice(product, null,pageData.getString("unit"));
            productUnitPriceService.save(productUnitPrice);
        }

        //5. 添加产品属性表(vmes_product_property)
        String dataListJsonStr = pageData.getString("prodPropertyJsonStr");
        //测试代码-真实环境无此代码
        //dataListJsonStr = "[{\"name\":\"属性名称_1\",\"value\":\"属性值_1\",\"remark\":\"备注_1\"},{\"name\":\"属性名称_2\",\"value\":\"属性值_2\",\"remark\":\"备注_2\"}]";

        if (dataListJsonStr != null && dataListJsonStr.trim().length() > 0) {
            //JsonString 转换成List<Map<String, Object>>
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) YvanUtil.jsonToList(dataListJsonStr);
            if (dataList == null || dataList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("自定义产品属性Json字符串-转换成List错误！");
                return model;
            }

            List<ProductProperty> propertyList = productPropertyService.mapList2ProductPropertyList(dataList, null);
            productPropertyService.addProductProperty(pageData.getString("cuser"),
                    product.getId(),
                    propertyList);
        }
        return model;
    }

    @Override
    public ResultModel updateProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //1. 非空判断
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("名称输入为空或空字符串，名称为必填不可为空！");
            return model;
        }

        Product productDB = (Product)HttpUtils.pageData2Entity(pageData, new Product());

        //2. 修改产品属性表(vmes_product_property)
        //按照产品id-删除产品属性表(vmes_product_property)
        productPropertyService.deleteProdPropertyByProdId(productDB.getId());

        String dataListJsonStr = pageData.getString("prodProperty");
        if (dataListJsonStr != null && dataListJsonStr.trim().length() > 0) {
            //JsonString 转换成List<Map<String, Object>>
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) YvanUtil.jsonToList(dataListJsonStr);
            if (dataList == null || dataList.size() == 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("自定义产品属性Json字符串-转换成List错误！");
                return model;
            }

            //添加产品属性表(vmes_product_property)-按照json字符串数据(dataListJsonStr)
            List<ProductProperty> propertyList = productPropertyService.mapList2ProductPropertyList(dataList, null);
            productPropertyService.addProductProperty(pageData.getString("cuser"),
                    productDB.getId(),
                    propertyList);
        }

        //3.修改产品表(vmes_product)
        productDB.setUuser(pageData.getString("cuser"));
        this.update(productDB);
        return model;
    }

    @Override
    public ResultModel updateDisableProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String isdisable = pageData.getString("isdisable");

        //1. 非空判断
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 修改产品物料(禁用)状态
        Product objectDB = (Product)HttpUtils.pageData2Entity(pageData, new Product());
        this.update(objectDB);

        return model;
    }


    @Override
    public ResultModel deleteProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        //1. 非空判断
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        //2. 删除产品物料
        ids = StringUtil.stringTrimSpace(ids);
        this.deleteByIds(ids.split(","));

        //3. 删除产品物料属性表(vmes_product_property)
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            productPropertyService.deleteProdPropertyByProdId(id);
        }

        return model;
    }

    @Override
    public void exportExcelProducts(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("product");
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
            fileName = "ExcelProduct";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelProduct(MultipartFile file) throws Exception {
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
        String msgStr = productExcelService.checkColumnImportExcel(dataMapLst,
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
        productExcelService.addImportExcelByList(dataMapLst);

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



