package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInitialMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：(简版)仓库初始化设定 实现类
 * 创建人：陈刚
 * 创建时间：2019-07-15
 */
@Service
@Transactional(readOnly = false)
public class WarehouseInitialBySimpleServiceImp implements WarehouseInitialBySimpleService {

    @Autowired
    private WarehouseInitialMapper warehouseInitialMapper;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductToolService warehouseProductToolService;
    @Autowired
    private WarehouseProductExcelBySimpleService warehouseProductExcelBySimpleService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;

    //仓库初始化(简版仓库)
    public List<Map> findWarehouseInitialBySimple(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseInitialMapper.findWarehouseProductBySimple(pd);
        } else if (pg != null) {
            return warehouseInitialMapper.findWarehouseProductBySimple(pd,pg);
        }

        return mapList;
    }

    public ResultModel findWarehouseInitialBySimple(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("warehouseInitialBySimple");
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

        String productIds = new String();
        if (pd.getString("productIds") != null && pd.getString("productIds").trim().length() > 0) {
            productIds = pd.getString("productIds").trim();
            productIds = StringUtil.stringTrimSpace(productIds);
            productIds = "'" + productIds.replace(",", "','") + "'";
        }
        pd.put("productIds", productIds);

        //genreSelect 界面(货品属性)下拉查询框
        String productGenre = new String();
        if (pd.get("genreSelect") != null && ((List)pd.get("genreSelect")).size() > 0) {
            productGenre = ((List)pd.get("genreSelect")).get(0).toString();
        }
        pd.put("productGenre", productGenre);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        //距今(最后一次变更日期)天数 排序方式
        String orderLast2nowDay = pd.getString("orderLast2nowDay");
        if (orderLast2nowDay != null && orderLast2nowDay.trim().length() > 0
            && "asc,desc".indexOf(orderLast2nowDay) != -1
        ) {
            pd.put("isNotNullLastUpdateDate", "true");
            pd.put("orderStr", null);
        }

        List<Map> varList = this.findWarehouseInitialBySimple(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //last2nowDay 距今(天数)
                //lastUpdateDate 最后一次变更日期
                String lastUpdateDate = (String)mapObject.get("lastUpdateDate");
                if (lastUpdateDate == null || lastUpdateDate.trim().length() == 0) {
                    mapObject.put("last2nowDay", new String());
                }
            }
        }

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles", titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList", varMapList);

        model.putResult(result);
        return model;
    }

    public ResultModel deleteWarehouseProductBySimple(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串！");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        //当前(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
        BigDecimal stockCount = BigDecimal.valueOf(0D);
        String stockCountStr = pageData.getString("stockCount");
        if (stockCountStr != null) {
            try {
                stockCount = new BigDecimal(stockCountStr);
                //四舍五入到2位小数
                stockCount = stockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //删除库存表(vmes_warehouse_product:仓库货位产品库存表)
        Map columnMap = new HashMap();
        columnMap.put("product_id", productId);
        columnMap.put("warehouse_id", warehouseId);
        warehouseProductService.deleteByColumnMap(columnMap);

        Product product = productService.findProductById(productId);
        BigDecimal prodCount = BigDecimal.valueOf(0D);
        if (product.getStockCount() != null) {
            prodCount = product.getStockCount();
        }

        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - stockCount.doubleValue());
        //四舍五入到2位小数
        prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        productService.updateStockCount(product, prodStockCount, cuser, "update");
        return model;
    }

    public ResultModel updateWarehouseProductBySimple(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串！");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        //原(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
        BigDecimal oldStockCount = BigDecimal.valueOf(0D);
        String oldStockCountStr = pageData.getString("oldStockCount");
        if (oldStockCountStr != null) {
            try {
                oldStockCount = new BigDecimal(oldStockCountStr);
                //四舍五入到2位小数
                oldStockCount = oldStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //新(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
        BigDecimal newStockCount = BigDecimal.valueOf(0D);
        String newStockCountStr = pageData.getString("newStockCount");
        if (newStockCountStr != null) {
            try {
                newStockCount = new BigDecimal(newStockCountStr);
                //四舍五入到2位小数
                newStockCount = newStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //(货位id,货品id)查询 vmes_warehouse_product
        PageData findMap = new PageData();
        findMap.put("warehouseId", warehouseId);
        findMap.put("productId", productId);
        findMap.put("queryStr", "stock_count > 0 ");
        findMap.put("orderStr", "cdate asc");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<WarehouseProduct> objectList = warehouseProductService.findWarehouseProductList(findMap);
        if (objectList == null || objectList.size() == 0) {return model;}

        //变更库存数量 := 变更后库存数量 - 变更前库存数量
        BigDecimal changeStockCount = BigDecimal.valueOf(newStockCount.doubleValue() - oldStockCount.doubleValue());
        if (changeStockCount.doubleValue() < 0D) {
            //out 库存减数量
            BigDecimal changeCount = BigDecimal.valueOf(changeStockCount.doubleValue() * -1);
            //四舍五入到2位小数
            changeCount = changeCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, WarehouseProduct> WarehouseProductMap = warehouseProductToolService.warehouseProductList2Map(objectList);

            //List<Map<String, Object>>
            //Map<String, Object>
            //warehouseProductId
            //outCount
            List<Map<String, Object>> changeOutMap = warehouseProductToolService.findWarehouseProductReduceMapListBySimple(objectList, changeCount);
            for (Map<String, Object> outMap : changeOutMap) {
                String warehouseProductId = (String)outMap.get("warehouseProductId");
                BigDecimal outCount = (BigDecimal)outMap.get("outCount");
                if (outCount == null) {continue;}

                //修改库存数量
                WarehouseProduct warehouseProduct = WarehouseProductMap.get(warehouseProductId);
                BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
                if (warehouseProduct.getStockCount() != null) {
                    beforeCountBig = warehouseProduct.getStockCount();
                }

                //变更后库存数量 := 变更前库存数量 - outCount
                BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() - outCount.doubleValue());
                //四舍五入到2位小数
                afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                warehouseProduct.setUuser(cuser);
                warehouseProduct.setStockCount(afterCountBig);
                warehouseProductService.update(warehouseProduct);

                Product product = productService.findProductById(warehouseProduct.getProductId());
                BigDecimal prodCount = BigDecimal.valueOf(0D);
                if (product.getStockCount() != null) {
                    prodCount = product.getStockCount();
                }

                BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
                //四舍五入到2位小数
                prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                productService.updateStockCount(product, prodStockCount, cuser, "out");
            }

        } else if (changeStockCount.doubleValue() > 0D) {
            //in 库存加数量
            //List<WarehouseProduct> objectList，按(cdate)降序排列
            warehouseProductService.orderDescByCdate(objectList);

            WarehouseProduct warehouseProduct = objectList.get(0);
            BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
            if (warehouseProduct.getStockCount() != null) {
                beforeCountBig = warehouseProduct.getStockCount();
            }

            //变更后库存数量 := 变更前库存数量 + changeStockCount
            BigDecimal afterCountBig = BigDecimal.valueOf(beforeCountBig.doubleValue() + changeStockCount.doubleValue());
            //四舍五入到2位小数
            afterCountBig = afterCountBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            warehouseProduct.setUuser(cuser);
            warehouseProduct.setStockCount(afterCountBig);
            warehouseProductService.update(warehouseProduct);

            Product product = productService.findProductById(warehouseProduct.getProductId());
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal modifyCount = BigDecimal.valueOf(afterCountBig.doubleValue() - beforeCountBig.doubleValue());
            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + modifyCount.doubleValue());
            //四舍五入到2位小数
            prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            productService.updateStockCount(product, prodStockCount, cuser, "in");
        }

        return model;
    }

    public ResultModel importExcelWarehouseInitialBySimple(MultipartFile file) throws Exception {
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

        //获取货品属性title
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<>();
        if (dataMapLst.size() > 0) {
            titleMap = dataMapLst.get(0);
        }

        //获取execl自定义货品属性非空最大参数个数
        Integer maxParmInt = warehouseProductExcelBySimpleService.findMaxNotNullProductParm(titleMap);
        dataMapLst.remove(0);

        StringBuffer checkColumnMsgStr = new StringBuffer();
        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = warehouseProductExcelBySimpleService.checkColumnImportExcel(dataMapLst,
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

        try {
            //2. 添加系统基础表
            // 1. 仓库表
            // 2. 货品表
            // 3. 字典表(计量单位)
            warehouseProductExcelBySimpleService.addSystemBaseTableImportExcel(dataMapLst,
                    titleMap,
                    maxParmInt,
                    companyId,
                    userId);

            //3. 遍历Excel导入List-Map<String, WarehouseProduct>
            Map<String, WarehouseProduct> warehouseProductMap = new HashMap<String, WarehouseProduct>();
            warehouseProductExcelBySimpleService.findWarehouseProductMapByExcelDataList(dataMapLst,
                    warehouseProductMap,
                    companyId);

            //4. 遍历Map<String, WarehouseProduct> 对业务表添加
            warehouseProductExcelBySimpleService.addWarehouseProduct(warehouseProductMap, companyId, userId);

        } catch (Exception e) {
            e.printStackTrace();
            model.putCode(Integer.valueOf(1));
            model.putMsg("系统异常：导入数据失败！");
            return model;
        }

        return model;
    }
}
