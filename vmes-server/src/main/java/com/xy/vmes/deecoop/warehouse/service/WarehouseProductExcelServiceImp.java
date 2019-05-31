package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
public class WarehouseProductExcelServiceImp implements WarehouseProductExcelService {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;

    private Map<String, Map<String, String>> dictionaryMap = new HashMap<String, Map<String, String>>();

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

        //获取 计量单位 字典Map
        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("productUnit"), companyId);
        this.dictionaryMap.put("unitKeyNameMap", dictionaryService.getKeyNameMap());
        this.dictionaryMap.put("unitNameKeyMap", dictionaryService.getNameKeyMap());

        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;

        int maxRow = 0;
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //验证 (货位编码,货位名称) 非空判断
            String msgStr = this.checkWarehouseColumn(mapObject, (i+index_int));
            if (msgStr != null && msgStr.trim().length() > 0) {
                strBuf.append(msgStr);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //验证 (货品名称,规格型号,货品属性,计量单位) 非空判断,(货品属性,计量单位) 字典名称验证
            msgStr = this.checkProductColumn(mapObject, (i+index_int));
            if (msgStr != null && msgStr.trim().length() > 0) {
                strBuf.append(msgStr);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
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
//                    if (bigDecimal.doubleValue() <= 0) {
//                        //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
//                        String str_error = MessageFormat.format(msg_column_error,
//                                (i+index_int),
//                                "库存数量",
//                                stockCount);
//                        strBuf.append(str_error);
//
//                        maxRow = maxRow + 1;
//                        if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//                    }

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
        }

        return strBuf.toString();
    }

    public String checkColumnImportExcelByDataBase(List<LinkedHashMap<String, String>> objectList,
                                            String companyId,
                                            Integer index,
                                            Integer maxShowRow,
                                            Map<String, String> warehouseMap,
                                            Map<String, String> productMap) {
        StringBuffer strBuf = new StringBuffer();

        int index_int = 1;
        if (index != null) {
            index_int = index.intValue();
        }

        int maxShowRow_int = 20;
        if (maxShowRow != null) {
            maxShowRow_int = maxShowRow.intValue();
        }

        int maxRow = 0;
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //验证 (货位编码,货位名称) 系统表中是否存在
            String msgStr = this.checkWarehouseByDataBase(mapObject, companyId, (i+index_int), warehouseMap);
            if (msgStr != null && msgStr.trim().length() > 0) {
                strBuf.append(msgStr);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }

            //验证 (货品名称,规格型号,货品属性,计量单位) 系统表中是否存在
            msgStr = this.checkProductByDataBase(mapObject, companyId, (i+index_int), productMap);
            if (msgStr != null && msgStr.trim().length() > 0) {
                strBuf.append(msgStr);
                maxRow = maxRow + 1;
                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
            }
        }

        return strBuf.toString();
    }

    public void findWarehouseProductMapByExcelDataList(List<LinkedHashMap<String, String>> objectList,
                                                       Map<String, WarehouseProduct> warehouseProductMap,
                                                       Map<String, String> warehouseMap,
                                                       Map<String, String> productMap) {
        if (objectList == null || objectList.size() == 0) {return;}

        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

            //warehouseCode 货位编码
            String warehouseCode = mapObject.get("warehouseCode");
            //pathName 货位名称
            String pathName = mapObject.get("pathName");

            //productCode 货品编码
            String productCode = mapObject.get("productCode");
            //productName 货品名称
            String productName = mapObject.get("productName");
            //productSpec 规格型号
            String productSpec = mapObject.get("productSpec");
            //productGenreName 货品属性
            String productGenreName = mapObject.get("productGenreName");
            //productUnitName 计量单位
            String productUnitName = mapObject.get("productUnitName");

            //货位key 获取 货位id
            String warehouseKey = "";
            if (warehouseCode != null && warehouseCode.trim().length() > 0) {
                warehouseKey = warehouseCode.trim();
            } else if (pathName != null && pathName.trim().length() > 0) {
                warehouseKey = pathName.trim();
            }
            String warehouseId = warehouseMap.get(warehouseKey);

            //货品Key 获取 货品id
            String productKey = "";
            if (productCode != null && productCode.trim().length() > 0) {
                productKey = productCode.trim();
            } else {
                //货品名称-规格型号-货品属性-计量单位
                StringBuffer productBufStr = new StringBuffer();
                productBufStr.append(productName.trim() + "-");
                productBufStr.append(productSpec.trim() + "-");
                productBufStr.append(productGenreName.trim() + "-");
                productBufStr.append(productUnitName.trim());
                productKey = productBufStr.toString().trim();
            }
            String productId = productMap.get(productKey);

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
            productService.updateStockCount(product, prodStockCount, userId);
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String checkWarehouseColumn(LinkedHashMap<String, String> mapObject, int index) {
        //warehouseCode 货位编码
        String warehouseCode = mapObject.get("warehouseCode");
        //pathName 货位名称
        String pathName = mapObject.get("pathName");

        String msg_column_isnull = "第 {0} 行: 货位编码,货位名称 请至少填写一项！" + Common.SYS_ENDLINE_DEFAULT;
        if ((warehouseCode == null || warehouseCode.trim().length() == 0)
            && (pathName == null || pathName.trim().length() == 0)
        ) {
            return MessageFormat.format(msg_column_isnull, index);
        }

        return new String();
    }

    private String checkProductColumn(LinkedHashMap<String, String> mapObject, int index) {
        StringBuffer strBuf = new StringBuffer();

        //productCode 货品编码
        String productCode = mapObject.get("productCode");
        //productName 货品名称
        String productName = mapObject.get("productName");
        //productSpec 规格型号
        String productSpec = mapObject.get("productSpec");
        //productGenreName 货品属性
        String productGenreName = mapObject.get("productGenreName");
        //productUnitName 计量单位
        String productUnitName = mapObject.get("productUnitName");

        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (productCode == null || productCode.trim().length() == 0) {
            //productName 货品名称
            if (productName == null || productName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        index,
                        "货品名称");
                strBuf.append(str_isnull);
            }

            //productSpec 规格型号
            if (productSpec == null || productSpec.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        index,
                        "规格型号");
                strBuf.append(str_isnull);
            }

            //productGenreName 货品属性
            if (productGenreName == null || productGenreName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        index,
                        "货品属性");
                strBuf.append(str_isnull);
            }

            //productUnitName 计量单位
            if (productUnitName == null || productUnitName.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        index,
                        "计量单位");
                strBuf.append(str_isnull);
            }

            //验证 productGenreName 货品属性 名称字典属性
            if (productGenreName != null && productGenreName.trim().length() > 0) {
                productGenreName = productGenreName.trim();
                if (this.dictionaryMap != null && this.dictionaryMap.get("genreNameKeyMap") != null) {
                    Map<String, String> genreNameKeyMap = this.dictionaryMap.get("genreNameKeyMap");
                    if (genreNameKeyMap.get(productGenreName) == null) {
                        //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！"
                        String str_isnull = MessageFormat.format(msg_column_error,
                                index,
                                "货品属性",
                                productGenreName);
                        strBuf.append(str_isnull);
                    } else {
                        mapObject.put("productGenre", genreNameKeyMap.get(productGenreName));
                    }
                }
            }

            //验证 productUnitName 计量单位 名称字典属性
            if (productUnitName != null && productUnitName.trim().length() > 0) {
                productUnitName = productUnitName.trim();
                if (this.dictionaryMap != null && this.dictionaryMap.get("unitNameKeyMap") != null) {
                    Map<String, String> unitNameKeyMap = this.dictionaryMap.get("unitNameKeyMap");
                    if (unitNameKeyMap.get(productUnitName) == null) {
                        //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！"
                        String str_isnull = MessageFormat.format(msg_column_error,
                                index,
                                "计量单位",
                                productUnitName);
                        strBuf.append(str_isnull);
                    } else {
                        mapObject.put("productUnit", unitNameKeyMap.get(productUnitName));
                    }
                }
            }

        }

        return strBuf.toString();
    }

    private String checkWarehouseByDataBase(LinkedHashMap<String, String> mapObject,
                                          String companyId,
                                          int index,
                                          Map<String, String> warehouseMap) {
        //warehouseCode 货位编码
        String warehouseCode = mapObject.get("warehouseCode");
        //pathName 货位名称
        String pathName = mapObject.get("pathName");

        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;
        if (warehouseCode != null && warehouseCode.trim().length() > 0) {
            warehouseCode = warehouseCode.trim();

            if (warehouseMap.get(warehouseCode) == null) {
                PageData findMap = new PageData();
                findMap.put("code", warehouseCode);
                findMap.put("companyId", companyId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));

                Warehouse warehouse = warehouseService.findWarehouse(findMap);
                if (warehouse == null) {
                    return MessageFormat.format(msg_column_error,
                            index,
                            "货位编码",
                            warehouseCode);
                } else {
                    warehouseMap.put(warehouseCode, warehouse.getId());
                }
            }

        } else if (pathName != null && pathName.trim().length() > 0) {
            pathName = pathName.trim();

            if (warehouseMap.get(pathName) == null) {
                PageData findMap = new PageData();
                findMap.put("pathName", pathName);
                findMap.put("companyId", companyId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                Warehouse warehouse = warehouseService.findWarehouse(findMap);
                if (warehouse == null) {
                    return MessageFormat.format(msg_column_error,
                            index,
                            "货位名称",
                            pathName);
                } else {
                    warehouseMap.put(pathName, warehouse.getId());
                }
            }
        }

        return new String();
    }

    private String checkProductByDataBase(
            LinkedHashMap<String, String> mapObject,
            String companyId,
            int index,
            Map<String, String> productMap) {
        StringBuffer strBuf = new StringBuffer();

        //productCode 货品编码
        String productCode = mapObject.get("productCode");
        //productName 货品名称
        String productName = mapObject.get("productName");
        //productSpec 规格型号
        String productSpec = mapObject.get("productSpec");
        //productGenreName 货品属性
        String productGenreName = mapObject.get("productGenreName");
        //productUnitName 计量单位
        String productUnitName = mapObject.get("productUnitName");

        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_error_1 = "第 {0} 行: (货品名称,规格型号,货品属性,计量单位)输入错误，该货品在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;

        if (productCode != null && productCode.trim().length() > 0) {
            productCode = productCode.trim();

            if (productMap.get(productCode) == null) {
                PageData findMap = new PageData();
                findMap.put("code", productCode);
                findMap.put("companyId", companyId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));

                Product product = productService.findProduct(findMap);
                if (product == null) {
                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，该{1}在系统中不存在！"
                    String str_isnull = MessageFormat.format(msg_column_error,
                            index,
                            "货品编码",
                            productCode);
                    strBuf.append(str_isnull);
                } else {
                    productMap.put(productCode, product.getId());
                }
            }
        } else if (productCode == null || productCode.trim().length() == 0) {
            //货品名称-规格型号-货品属性-计量单位
            StringBuffer productBufStr = new StringBuffer();
            productBufStr.append(productName.trim() + "-");
            productBufStr.append(productSpec.trim() + "-");
            productBufStr.append(productGenreName.trim() + "-");
            productBufStr.append(productUnitName.trim());

            if (productMap.get(productBufStr.toString()) == null) {
                PageData findMap = new PageData();
                findMap.put("name", productName.trim());
                findMap.put("companyId", companyId);
                findMap.put("spec", productSpec.trim());
                findMap.put("genre", mapObject.get("productGenre"));
                findMap.put("unit", mapObject.get("productUnit"));
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));

                Product product = productService.findProduct(findMap);
                if (product == null) {
                    //String msg_column_error_1 = "第 {0} 行: (货品名称,规格型号,货品属性,计量单位)输入错误，该货品在系统中不存在！"
                    String str_isnull = MessageFormat.format(msg_column_error_1, index);
                    strBuf.append(str_isnull);
                } else {
                    productMap.put(productBufStr.toString(), product.getId());
                }
            }
        }

        return strBuf.toString();
    }

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
                    "vmes_product",
                    "yyyyMMdd",
                    "PC");

            productPCCodeMap.put(mapKey, code);
        }

        return productPCCodeMap;
    }
}
