package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.entity.*;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
public class WarehouseProductExcelBySimpleServiceImp implements WarehouseProductExcelBySimpleService {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;

    private Map<String, Map<String, String>> dictionaryMap = new HashMap<String, Map<String, String>>();

    /**
     * 导入字段非空判断-(库存数量)数字判断-(仓库类型,货品属性)字典表判断
     * @param objectList
     * @param companyId
     * @param index
     * @param maxShowRow
     * @return
     */
    public String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                         String companyId,
                                         Integer index,
                                         Integer maxShowRow) {
        StringBuffer strBuf = new StringBuffer();

        int index_int = 1;
        if (index != null) {
            index_int = index.intValue();
        }

        int maxShowRow_int = 20;
        if (maxShowRow != null) {
            maxShowRow_int = maxShowRow.intValue();
        }

        this.dictionaryMap.clear();
        //获取 货品属性 字典Map productGenre
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("productGenre") , null);
        this.dictionaryMap.put("genreKeyNameMap", dictionaryService.getKeyNameMap());
        this.dictionaryMap.put("genreNameKeyMap", dictionaryService.getNameKeyMap());

        //获取 仓库类型 字典Map warehouseType
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("warehouseType"), companyId);
        this.dictionaryMap.put("warehouseTypeKeyNameMap", dictionaryService.getKeyNameMap());
        this.dictionaryMap.put("warehouseTypeNameKeyMap", dictionaryService.getNameKeyMap());

        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error_1 = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;
        int maxRow = 0;
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //pathName 货位名称
            String pathName = mapObject.get("pathName");
            if (pathName == null || pathName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "货位名称");
                strBuf.append(str_isnull);
            }

            //warehouseTypeName 仓库类型
            String warehouseTypeName = mapObject.get("warehouseTypeName");
            if (warehouseTypeName == null || warehouseTypeName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "仓库类型");
                strBuf.append(str_isnull);
            }

            //productCode 货品编码
            //productName 货品名称
            String productName = mapObject.get("productName");
            if (productName == null || productName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "货品名称");
                strBuf.append(str_isnull);
            }

            //productSpec 规格型号
            String productSpec = mapObject.get("productSpec");
            if (productSpec == null || productSpec.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "规格型号");
                strBuf.append(str_isnull);
            }

            //productPictureCode 图号 允许为空
            //productGenreName 货品属性
            String productGenreName = mapObject.get("productGenreName");
            if (productGenreName == null || productGenreName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "货品属性");
                strBuf.append(str_isnull);
            }

            //productUnitName 计量单位
            String productUnitName = mapObject.get("productUnitName");
            if (productUnitName == null || productUnitName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "计量单位");
                strBuf.append(str_isnull);
            }

            //stockCount 库存数量
            String stockCount = mapObject.get("stockCount");
            if (stockCount == null || stockCount.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "库存数量");
                strBuf.append(str_isnull);
            } else if (stockCount != null && stockCount.trim().length() > 0) {
                stockCount = stockCount.trim();
                try {
                    //全数字
                    BigDecimal bigDecimal = new BigDecimal(stockCount);
                    //四舍五入到2位小数
                    bigDecimal = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    mapObject.put("stockCount", bigDecimal.toString());

                } catch (NumberFormatException e) {
                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                    String str_error = MessageFormat.format(msg_column_error,
                            (i+index_int),
                            "库存数量",
                            stockCount);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                }
            }

            //warehouseTypeName 仓库类型
            if (warehouseTypeName != null && warehouseTypeName.trim().length() > 0) {
                warehouseTypeName = warehouseTypeName.trim();
                if (this.dictionaryMap != null && this.dictionaryMap.get("warehouseTypeNameKeyMap") != null) {
                    Map<String, String> warehouseTypeNameKeyMap = this.dictionaryMap.get("warehouseTypeNameKeyMap");
                    if (warehouseTypeNameKeyMap.get(warehouseTypeName) == null) {
                        //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！"
                        String str_isnull = MessageFormat.format(msg_column_error_1,
                                (i+index_int),
                                "仓库类型",
                                warehouseTypeName);
                        strBuf.append(str_isnull);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                    } else {
                        mapObject.put("warehouseType", warehouseTypeNameKeyMap.get(warehouseTypeName));
                    }
                }
            }

            //productGenreName 货品属性
            if (productGenreName != null && productGenreName.trim().length() > 0) {
                productGenreName = productGenreName.trim();
                if (this.dictionaryMap != null && this.dictionaryMap.get("genreNameKeyMap") != null) {
                    Map<String, String> productGenreNameKeyMap = this.dictionaryMap.get("genreNameKeyMap");
                    if (productGenreNameKeyMap.get(productGenreName) == null) {
                        //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！"
                        String str_isnull = MessageFormat.format(msg_column_error_1,
                                (i+index_int),
                                "货品属性",
                                productGenreName);
                        strBuf.append(str_isnull);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                    } else {
                        mapObject.put("productGenre", productGenreNameKeyMap.get(productGenreName));
                    }
                }
            }
        }

        return strBuf.toString();
    }

    /**
     * 添加系统基础表
     * 1. 仓库表
     * 2. 货品表
     * 3. 字典表(计量单位)
     * @param objectList
     * @param companyId
     */
    public void addSystemBaseTableImportExcel(List<LinkedHashMap<String, String>> objectList,
                                              String companyId,
                                              String userId) throws Exception {
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //1. 查询仓库表-系统中已经存在的仓库比较-不存在添加仓库表
            Map<String, String> sysWarehouseMap = this.findWarehouseMapBySystem(companyId);
            Map<String, String> excelWarehouseMap = this.findWarehouseMapByExcel(objectList);
            this.addWarehouse(excelWarehouseMap, sysWarehouseMap, companyId, userId);

            //2. 查询字典表(货品单位)-系统中已经存在的单位比较-不存在添加字典表(货品单位)
            // productUnitName 计量单位
            dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("productUnit"), companyId);
            Map<String, String> sysUnitMap = dictionaryService.getNameKeyMap();
            Map<String, String> excelUnitMap = this.findUnitMapByExcel(objectList);
            this.addUnit(excelUnitMap, sysUnitMap, companyId, userId);

            //3. 查询货品表(货品名称_规格型号)-系统中已经存在的货品比较-不存在添加货品表(货品单位)
            Map<String, String> sysProductMap = this.findProductMapBySystem(companyId);
            Map<String, Map<String, String>> excelProductMap = this.findProductMapByExcel(objectList, companyId);
            this.addProduct(excelProductMap, sysProductMap, companyId, userId);

            //4. 货品计量单位绑定
            this.addProductUnit(excelProductMap, companyId, userId);
        }
    }

    public void findWarehouseProductMapByExcelDataList(List<LinkedHashMap<String, String>> objectList,
                                                       Map<String, WarehouseProduct> warehouseProductMap,
                                                       String companyId) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}

        //仓库Map结构体: <仓库名称, 仓库id>
        Map<String, String> sysWarehouseMap = this.findWarehouseMapBySystem(companyId);
        //货品Map结构体: <货品名称_规格型号, 货品id>
        Map<String, String> sysProductMap = this.findProductMapBySystem(companyId);

        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //pathName 货位名称
            String pathName = mapObject.get("pathName");
            String warehouseId = new String();
            if (sysWarehouseMap != null && sysWarehouseMap.get(pathName) != null) {
                warehouseId = sysWarehouseMap.get(pathName);
            }

            //productName 货品名称
            String productName = mapObject.get("productName");
            //productSpec 规格型号
            String productSpec = mapObject.get("productSpec");
            String productMapKey = productName + "_" + productSpec;

            String productId = new String();
            if (sysProductMap != null && sysProductMap.get(productMapKey) != null) {
                productId = sysProductMap.get(productMapKey);
            }

            //stockCount 库存数量
            String stockCount = mapObject.get("stockCount");
            BigDecimal stockCount_big = new BigDecimal(stockCount);

            //仓库货品
            String warehouseProductKey = warehouseId + "-" + productId;
            if (warehouseProductMap.get(warehouseProductKey) != null) {
                WarehouseProduct addWarehouseProduct = warehouseProductMap.get(warehouseProductKey);

                BigDecimal add_stockCount = addWarehouseProduct.getStockCount();
                BigDecimal new_stockCount = BigDecimal.valueOf(add_stockCount.doubleValue() + stockCount_big.doubleValue());
                //四舍五入到2位小数
                new_stockCount = new_stockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addWarehouseProduct.setStockCount(new_stockCount);

                warehouseProductMap.put(warehouseProductKey, addWarehouseProduct);
            } else if (warehouseProductMap.get(warehouseProductKey) == null) {
                WarehouseProduct warehouseProduct = new WarehouseProduct();
                warehouseProduct.setWarehouseId(warehouseId);
                warehouseProduct.setProductId(productId);
                warehouseProduct.setStockCount(stockCount_big);
                warehouseProductMap.put(warehouseProductKey, warehouseProduct);
            }
        }
    }

    public void addWarehouseProduct(Map<String, WarehouseProduct> warehouseProductMap, String companyId, String userId) throws Exception {
        if (warehouseProductMap == null || warehouseProductMap.size() == 0) {return;}

        //获取Excel导入货品批次号Map<货品id, 批次号>
        Map<String, String> productPCCodeMap = this.findProductPCCodeMap(companyId, warehouseProductMap);

        for (Iterator iterator = warehouseProductMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();
            WarehouseProduct warehouseProduct = warehouseProductMap.get(mapKey);
            String productId = warehouseProduct.getProductId();

            String code = productPCCodeMap.get(productId);
            warehouseProduct.setCode(code);
            warehouseProduct.setCuser(userId);
            warehouseProduct.setCompanyId(companyId);

            //生成二维码
            String QRCodeJson = warehouseProductService.warehouseProduct2QRCode(warehouseProduct);
            String qrcode = fileService.createQRCode("warehouseProduct", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                warehouseProduct.setQrcode(qrcode);
            }
            warehouseProductService.save(warehouseProduct);

            Product product = productService.findProductById(productId);
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + warehouseProduct.getStockCount().doubleValue());
            productService.updateStockCount(product, prodStockCount, userId, "in");
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取仓库Map结构体
     * 仓库Map结构体: <仓库名称, 仓库id>
     *
     * @param companyId
     * @return
     */
    private Map<String, String> findWarehouseMapBySystem(String companyId) throws Exception {
        Map<String, String> warehouseMap = new LinkedHashMap<>();
        if (companyId == null || companyId.trim().length() == 0) {return warehouseMap;}

        //查询仓库表 vmes_warehouse
        PageData findMap = new PageData();
        findMap.put("currentCompanyId", companyId);
        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        findMap.put("pid", Common.DICTIONARY_MAP.get("warehouseEntity"));
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        List<Map> warehouseMapList = warehouseService.getDataListPage(findMap, null);
        if (warehouseMapList == null || warehouseMapList.size() == 0) {return warehouseMap;}

        for (Map<String, Object> mapObject : warehouseMapList) {
            //name 仓库名称
            String name = (String)mapObject.get("name");
            //id 仓库id
            String id = (String)mapObject.get("id");

            //entityTypeName 仓库类型
            //String entityTypeName = (String)mapObject.get("entityTypeName");
            warehouseMap.put(name, id);
        }

        return warehouseMap;
    }

    private Map<String, String> findWarehouseMapByExcel(List<LinkedHashMap<String, String>> objectList) {
        Map<String, String> warehouseMap = new LinkedHashMap<>();
        if (objectList == null || objectList.size() == 0) {return warehouseMap;}

        for (Map<String, String> mapObject : objectList) {
            //pathName 货位名称
            String pathName = mapObject.get("pathName");

            //warehouseTypeName 仓库类型
            String warehouseTypeName = mapObject.get("warehouseTypeName");

            warehouseMap.put(pathName, warehouseTypeName);
        }

        return warehouseMap;
    }

    private void addWarehouse(Map<String, String> excelWarehouseMap,
                              Map<String, String> sysWarehouseMap,
                              String companyId,
                              String userId) throws Exception {
        if (excelWarehouseMap == null) {return;}

        //1.(仓库名称) 与系统仓库表结构体比较 是否存在
        List<String> addWarehouseList = new ArrayList();
        for (Iterator iterator = excelWarehouseMap.keySet().iterator(); iterator.hasNext();) {
            //仓库名称
            String mapKey = iterator.next().toString().trim();
            if (sysWarehouseMap.get(mapKey) == null) {
                addWarehouseList.add(mapKey);
            }
        }

        if (addWarehouseList.size() > 0) {
            String pid = Common.DICTIONARY_MAP.get("warehouseEntity");
            Warehouse paterObj = warehouseService.findWarehouseById(pid);

            for (String warehouseValue : addWarehouseList) {
                //仓库名称 warehouseName
                String warehouseName = warehouseValue;

                //warehouseTypeName 仓库类型
                String warehouseTypeName = new String();
                if (excelWarehouseMap != null && excelWarehouseMap.get(warehouseName) != null) {
                    warehouseTypeName = excelWarehouseMap.get(warehouseName);
                }

                //添加 仓库表
                Warehouse addWarehouse = new Warehouse();
                addWarehouse.setId(Conv.createUuid());
                addWarehouse.setWarehouseId(addWarehouse.getId());
                addWarehouse.setCuser(userId);

                addWarehouse.setName(warehouseName);
                //entity_type 仓库类型
                if (warehouseTypeName != null && warehouseTypeName.trim().length() > 0) {
                    warehouseTypeName = warehouseTypeName.trim();
                    if (this.dictionaryMap != null && this.dictionaryMap.get("warehouseTypeNameKeyMap") != null) {
                        Map<String, String> warehouseTypeNameKeyMap = this.dictionaryMap.get("warehouseTypeNameKeyMap");
                        if (warehouseTypeNameKeyMap.get(warehouseTypeName) != null) {
                            addWarehouse.setEntityType(warehouseTypeNameKeyMap.get(warehouseTypeName));
                        }
                    }
                }

                //获取仓库编码
                String code = coderuleService.createCoder(companyId, "vmes_warehouse","WE");
                addWarehouse.setCompanyId(companyId);
                addWarehouse.setCode(code);
                //设置仓库路径名称
                addWarehouse = warehouseService.paterObject2Warehouse(paterObj, addWarehouse);

                //生成仓库(实体库)二维码
                String qrcode = fileService.createQRCode("warehouseBase", addWarehouse.getId());
                if (qrcode != null && qrcode.trim().length() > 0) {
                    addWarehouse.setQrcode(qrcode);
                }

                //设置默认顺序
                if (addWarehouse.getSerialNumber() == null) {
                    Integer maxCount = warehouseService.findMaxSerialNumber(pid);
                    addWarehouse.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
                }

                warehouseService.save(addWarehouse);
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, String> findUnitMapByExcel(List<LinkedHashMap<String, String>> objectList) {
        Map<String, String> warehouseMap = new LinkedHashMap<>();
        if (objectList == null || objectList.size() == 0) {return warehouseMap;}

        for (Map<String, String> mapObject : objectList) {
            //productUnitName 计量单位
            String productUnitName = mapObject.get("productUnitName");

            warehouseMap.put(productUnitName, productUnitName);
        }

        return warehouseMap;
    }

    private void addUnit(Map<String, String> excelUnitMap,
                         Map<String, String> sysUnitMap,
                         String companyId,
                         String userId) throws Exception {
        if (excelUnitMap == null) {return;}

        //1.(计量单位名称) 与系统字典表结构体比较 是否存在
        List<String> addUnitList = new ArrayList();
        for (Iterator iterator = excelUnitMap.keySet().iterator(); iterator.hasNext();) {
            //计量单位名称
            String mapKey = iterator.next().toString().trim();
            if (sysUnitMap.get(mapKey) == null) {
                addUnitList.add(mapKey);
            }
        }

        if (addUnitList.size() > 0) {
            String pid = Common.DICTIONARY_MAP.get("productUnit");
            //productUnit: 0ae6e79890db490585e13f34bf00ea4b 货品计量单位
            Dictionary paterObj = dictionaryService.findDictionaryById(pid);

            for (String productUnitName : addUnitList) {
                //创建字典信息
                Dictionary addDictionary = new Dictionary();
                addDictionary.setId(Conv.createUuid());
                addDictionary.setCompanyId(companyId);
                addDictionary.setCuser(userId);
                addDictionary.setName(productUnitName);

                //isglobal: 0：否  1：是
                //0:非全局设置 1:是全局(超级管理员创建的数据字典都是全局设置)
                addDictionary.setIsglobal("0");

                addDictionary = dictionaryService.id2DictionaryByLayer(addDictionary.getId(),
                        Integer.valueOf(paterObj.getLayer().intValue() + 1),
                        addDictionary);
                addDictionary = dictionaryService.paterObject2ObjectDB(paterObj, addDictionary);

                //设置默认部门顺序
                if (addDictionary.getSerialNumber() == null) {
                    Integer maxCount = dictionaryService.findMaxSerialNumber(addDictionary.getPid());
                    addDictionary.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
                }
                dictionaryService.save(addDictionary);
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取货品Map结构体
     * 货品Map结构体: <货品名称_规格型号, 货品id>
     *
     * @param companyId
     * @return
     */
    private Map<String, String> findProductMapBySystem(String companyId) throws Exception {
        Map<String, String> productMap = new LinkedHashMap<>();
        if (companyId == null || companyId.trim().length() == 0) {return productMap;}

        //查询货品表 vmes_product
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Product> productList = productService.findProductList(findMap);
        if (productList == null || productList.size() == 0) {return productMap;}

        for (Product product : productList) {
            //name 货品名称
            String name = product.getName();
            //spec 规格型号
            String spec = product.getSpec();
            //id 货品id
            String id = product.getId();

            String mapKey = name + "_" + spec;
            productMap.put(mapKey, id);
        }

        return productMap;
    }

    private Map<String, String> findProductNameMapBySystem(String companyId) throws Exception {
        Map<String, String> productMap = new LinkedHashMap<>();
        if (companyId == null || companyId.trim().length() == 0) {return productMap;}

        //查询货品表 vmes_product
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Product> productList = productService.findProductList(findMap);
        if (productList == null || productList.size() == 0) {return productMap;}

        for (Product product : productList) {
            //name 货品名称
            String name = product.getName();
            //spec 规格型号
            //String spec = product.getSpec();
            //id 货品id
            String id = product.getId();

            productMap.put(name, id);
        }

        return productMap;
    }

    private Map<String, Map<String, String>> findProductMapByExcel(List<LinkedHashMap<String, String>> objectList, String companyId) {
        Map<String, Map<String, String>> productMap = new LinkedHashMap<>();
        if (objectList == null || objectList.size() == 0) {return productMap;}

        //获取当前企业-货品单位
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("productUnit"), companyId);
        Map<String, String> sysUnitMap = dictionaryService.getNameKeyMap();

        for (Map<String, String> mapObject : objectList) {
            Map<String, String> productValueMap = new HashMap();

            //productName 货品名称
            String productName = mapObject.get("productName");
            productValueMap.put("productName", productName);

            //productSpec 规格型号
            String productSpec = mapObject.get("productSpec");
            productValueMap.put("productSpec", productSpec);

            //productPictureCode 图号
            String productPictureCode = mapObject.get("productPictureCode");
            productValueMap.put("productPictureCode", productPictureCode);

            //productGenreName 货品属性
            String productGenreName = mapObject.get("productGenreName");
            productValueMap.put("productGenreName", productGenreName);

            //productUnitName 计量单位
            String productUnitName = mapObject.get("productUnitName");
            productValueMap.put("productUnitName", productUnitName);

            //productUnit 计量单位id
            String productUnit = new String();
            if (sysUnitMap != null && sysUnitMap.get(productUnitName) != null) {
                productUnit = sysUnitMap.get(productUnitName);
            }
            productValueMap.put("productUnit", productUnit);

            //mapKey := 货品名称_规格型号
            String mapKey = productName + "_" + productSpec;
            productMap.put(mapKey, productValueMap);
        }

        return productMap;
    }

    private void addProduct(Map<String, Map<String, String>> excelProductMap,
                            Map<String, String> sysProductMap,
                            String companyId,
                            String userId) throws Exception {
        if (excelProductMap == null) {return;}

        //1.(货品名称_规格型号) 与系统货品表结构体比较 是否存在
        List<String> addProductList = new ArrayList();
        for (Iterator iterator = excelProductMap.keySet().iterator(); iterator.hasNext();) {
            //mapKey:货品名称_规格型号
            String mapKey = iterator.next().toString().trim();
            if (sysProductMap.get(mapKey) == null) {
                addProductList.add(mapKey);
            }
        }

        if (addProductList.size() > 0) {
            for (String productKey : addProductList) {
                //添加产品表(vmes_product)
                Product addProduct = new Product();
                addProduct.setId(Conv.createUuid());
                addProduct.setCompanyId(companyId);
                addProduct.setCuser(userId);

                Map<String, String> productMap = excelProductMap.get(productKey);
                //productName 货品名称
                String productName = productMap.get("productName");
                addProduct.setName(productName);

                //productSpec 规格型号
                String productSpec = productMap.get("productSpec");
                addProduct.setSpec(productSpec);

                //productPictureCode 图号
                String productPictureCode = productMap.get("productPictureCode");
                if (productPictureCode != null) {
                    addProduct.setPictureCode(productPictureCode.trim());
                }

                //productGenreName 货品属性
                String productGenreName = productMap.get("productGenreName");
                if (productGenreName != null && productGenreName.trim().length() > 0) {
                    productGenreName = productGenreName.trim();
                    if (this.dictionaryMap != null && this.dictionaryMap.get("genreNameKeyMap") != null) {
                        Map<String, String> genreNameKeyMap = this.dictionaryMap.get("genreNameKeyMap");
                        if (genreNameKeyMap.get(productGenreName) != null) {
                            addProduct.setGenre(genreNameKeyMap.get(productGenreName));
                        }
                    }
                }

                //创建货品编码
                String code = coderuleService.createCoder(companyId,"vmes_product","P");
                addProduct.setCode(code);

                //生成货品二维码
                String qrcode = fileService.createQRCode("product", addProduct.getId());
                if (qrcode != null && qrcode.trim().length() > 0) {
                    addProduct.setQrcode(qrcode);
                }
                productService.save(addProduct);
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void addProductUnit(Map<String, Map<String, String>> excelProductMap, String companyId, String userId) throws Exception {
        if (excelProductMap == null) {return;}

        Map<String, Map<String, String>> productUnitMap = new LinkedHashMap<>();
        Map<String, String> prodNameKeyMap = this.findProductNameMapBySystem(companyId);
        for (Iterator iterator = excelProductMap.keySet().iterator(); iterator.hasNext();) {
            //mapKey:货品名称_规格型号
            String mapKey = iterator.next().toString().trim();
            Map<String, String> productMap = excelProductMap.get(mapKey);

            //productName 货品名称
            String productName = productMap.get("productName");

            String productId = new String();
            if (prodNameKeyMap != null && prodNameKeyMap.get(productName) != null) {
                productId = prodNameKeyMap.get(productName).trim();
            }

            //productUnitName 计量单位
            //String productUnitName = productMap.get("productUnitName");

            //productUnit 计量单位id
            String productUnit = productMap.get("productUnit");

            if (productId != null && productId.trim().length() > 0 && productUnit != null && productUnit.trim().length() > 0) {
                Map<String, String> productUnitValue = new HashMap();
                productUnitValue.put("productId", productId);
                productUnitValue.put("productUnit", productUnit);

                productUnitMap.put((productId + "_" + productUnit), productUnitValue);
            }
        }

        for (Iterator iterator = productUnitMap.keySet().iterator(); iterator.hasNext();) {
            //mapKey:货品id_计量单位id
            String mapKey = iterator.next().toString().trim();
            Map<String, String> productUnitValue = productUnitMap.get(mapKey);

            //productId 货品id
            String productId = productUnitValue.get("productId");

            //productUnit 计量单位id
            String productUnit = productUnitValue.get("productUnit");

            PageData findMap = new PageData();
            findMap.put("productId", productId);
            findMap.put("unit", productUnit);
            //type 单位类型 (1:计量单位 0:计价单位)
            findMap.put("type", "1");
            //是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            List<ProductUnit> objectList = productUnitService.findProductUnitList(findMap);
            if (objectList != null && objectList.size() > 0) {continue;}

            ProductUnit addProductUnit = new ProductUnit();
            addProductUnit.setCuser(userId);
            addProductUnit.setProductId(productId);
            addProductUnit.setUnit(productUnit);
            //type 单位类型 (1:计量单位 0:计价单位)
            addProductUnit.setType("1");

            //npFormula 计量单位转换计价单位
            addProductUnit.setNpFormula("P=N");
            addProductUnit.setN2pIsScale(Common.SYS_ISSCALE_TRUE);
            addProductUnit.setN2pDecimalCount(Integer.valueOf(Common.SYS_NUMBER_FORMAT_2));

            //pnFormula 计价单位转换计量单位
            addProductUnit.setPnFormula("N=P");
            addProductUnit.setP2nIsScale(Common.SYS_ISSCALE_TRUE);
            addProductUnit.setP2nDecimalCount(Integer.valueOf(Common.SYS_NUMBER_FORMAT_2));

            productUnitService.save(addProductUnit);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, String> findProductPCCodeMap(String companyId, Map<String, WarehouseProduct> warehouseProductMap) {
        Map<String, String> productPCCodeMap = new HashMap<String, String>();
        if (warehouseProductMap == null || warehouseProductMap.size() == 0) {return productPCCodeMap;}

        for (Iterator iterator = warehouseProductMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();
            WarehouseProduct warehouseProduct = warehouseProductMap.get(mapKey);
            if (warehouseProduct != null && warehouseProduct.getProductId() != null && warehouseProduct.getProductId().trim().length() > 0) {
                productPCCodeMap.put(warehouseProduct.getProductId().trim(), new String());
            }
        }

        for (Iterator iterator_1 = productPCCodeMap.keySet().iterator(); iterator_1.hasNext();) {
            String mapKey = (String)iterator_1.next();

            //获取批次号
            //PC+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(companyId,
                    "vmes_product_pc",
                    "yyyyMMdd",
                    "PC");

            productPCCodeMap.put(mapKey, code);
        }

        return productPCCodeMap;
    }
}
