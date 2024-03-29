package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInitialMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.WarehouseInitial;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.*;
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
* 说明：vmes_warehouse_initial:仓库初始化设定 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-11-20
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInitialServiceImp implements WarehouseInitialService {
    @Autowired
    private WarehouseInitialMapper warehouseInitialMapper;

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseMoveService warehouseMoveService;

    //销售
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    SaleInvoiceService saleInvoiceService;
    @Autowired
    SaleRetreatService saleRetreatService;
    @Autowired
    SaleReceiveService saleReceiveService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductExcelService warehouseProductExcelService;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;

    @Autowired
    private ProductService productService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-11-20
    */
    @Override
    public void save(WarehouseInitial warehouseInitial) throws Exception{
        warehouseInitial.setId(Conv.createUuid());
        warehouseInitial.setCdate(new Date());
        warehouseInitial.setUdate(new Date());
        warehouseInitialMapper.insert(warehouseInitial);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public WarehouseInitial selectById(String id) throws Exception{
        return warehouseInitialMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public List<WarehouseInitial> selectByColumnMap(Map columnMap) throws Exception{
        List<WarehouseInitial> warehouseCheckList =  warehouseInitialMapper.selectByMap(columnMap);
        return warehouseCheckList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void update(WarehouseInitial object) throws Exception{
        object.setUdate(new Date());
        warehouseInitialMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void updateAll(WarehouseInitial object) throws Exception{
        object.setUdate(new Date());
        warehouseInitialMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseInitialMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInitialMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInitialMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInitialMapper.deleteByMap(columnMap);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public void updateIsdisable(String isdisable, String companyId) {
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("isdisable", isdisable);
        warehouseInitialMapper.updateIsdisable(findMap);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    @Override
    public List<WarehouseInitial> dataList(PageData pd) throws Exception{
        return warehouseInitialMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseInitialMapper.getDataListPage(pd, pg);
    }

//    //仓库初始化(复杂版仓库)
//    public List<Map> findWarehouseInitialByComplex(PageData pd) throws Exception {
//        List<Map> mapList = new ArrayList<Map>();
//        if (pd == null) {return mapList;}
//
//        Pagination pg = null;
//
//        //是否需要分页 true:需要分页 false:不需要分页
//        String isNeedPage = pd.getString("isNeedPage");
//        if ("true".equals(isNeedPage)) {
//            pg = HttpUtils.parsePagination(pd);
//        }
//
//        if (pg == null) {
//            return warehouseInitialMapper.findWarehouseProductByComplex(pd);
//        } else if (pg != null) {
//            return warehouseInitialMapper.findWarehouseProductByComplex(pd, pg);
//        }
//
//        return mapList;
//    }

    public WarehouseInitial findWarehouseInitial(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInitial> objectList = this.findWarehouseInitialList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInitial findWarehouseInitialById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInitial(findMap);
    }

    public List<WarehouseInitial> findWarehouseInitialList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInitial> objectList = new ArrayList<WarehouseInitial>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

//    //仓库初始化(简版仓库)
//    public List<Map> findWarehouseInitialBySimple(PageData pd) throws Exception {
//        List<Map> mapList = new ArrayList<Map>();
//        if (pd == null) {return mapList;}
//
//        Pagination pg = null;
//
//        //是否需要分页 true:需要分页 false:不需要分页
//        String isNeedPage = pd.getString("isNeedPage");
//        if ("true".equals(isNeedPage)) {
//            pg = HttpUtils.parsePagination(pd);
//        }
//
//        if (pg == null) {
//            return warehouseInitialMapper.findWarehouseProductBySimple(pd);
//        } else if (pg != null) {
//            return warehouseInitialMapper.findWarehouseProductBySimple(pd,pg);
//        }
//
//        return mapList;
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 仓库初始化
     * @param warehouseGenre 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
     * @param cuser
     * @param companyId
     * @throws Exception
     */
    public void initialByWarehouse(String warehouseGenre, String cuser, String companyId) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return;}

        //删除业务相关表
        this.deleteTableByBusiness(warehouseGenre, companyId);

        //(企业id)查询 vmes_warehouse_initial
        WarehouseInitial warehouseInitial = null;
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("warehouseAttribute", warehouseGenre);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouseInitial = this.findWarehouseInitial(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
        //0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
        String isDisableButton = "111";

        if (warehouseInitial == null) {
            WarehouseInitial addObject = new WarehouseInitial();
            addObject.setCuser(cuser);
            addObject.setCompanyId(companyId);
            addObject.setIsDisableButton(isDisableButton);
            //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
            addObject.setWarehouseAttribute(warehouseGenre);
            this.save(addObject);
        } else if (warehouseInitial != null) {
            warehouseInitial.setIsDisableButton(isDisableButton);
            this.update(warehouseInitial);
        }

    }

    /**
     * 删除仓库相关业务数据
     * @param warehouseGenre 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
     * @param companyId
     * @throws Exception
     */
    public void deleteTableByBusiness(String warehouseGenre, String companyId) throws Exception {

        //仓库业务表
        if ("warehouse".equals(warehouseGenre)) {
            //删除入库业务表
            warehouseInService.deleteTableByWarehouseIn(companyId, warehouseGenre);
            //删除出库业务表
            warehouseOutService.deleteTableByWarehouseOut(companyId, warehouseGenre);
            //删除仓库盘点业务表
            warehouseCheckService.deleteTableByWarehouseCheck(companyId);
            //删除移库业务表
            warehouseMoveService.deleteTableByWarehouseMove(companyId);
        } else if ("spare".equals(warehouseGenre)) {
            //删除入库业务表
            warehouseInService.deleteTableByWarehouseIn(companyId, warehouseGenre);
            //删除出库业务表
            warehouseOutService.deleteTableByWarehouseOut(companyId, warehouseGenre);

        }

//        //销售业务表
//        if ("warehouse".equals(warehouseGenre)) {
//            if(saleOrderService != null) {
//                saleOrderService.deleteTableByOrder(companyId);
//            }
//            if(saleDeliverService != null) {
//                saleDeliverService.deleteTableByDeliver(companyId);
//            }
//            if (saleInvoiceService != null) {
//                saleInvoiceService.deleteTableByInvoice(companyId);
//            }
//            if (saleRetreatService != null) {
//                saleRetreatService.deleteTableBySaleRetreat(companyId);
//            }
//            if (saleReceiveService != null) {
//                saleReceiveService.deleteTableByReceive(companyId);
//            }
//        }

        //删除仓库货品表(库存表)
        //isSpare:true: 删除的是备件库 warehouseGenre:= spare:备件库
        //isSpare:false: 删除的是非备件库 warehouseGenre:= warehouse:(简版,复杂版)仓库
        String isSpare = "false";
        if ("warehouse".equals(warehouseGenre)) {
            isSpare = "false";
        } else if ("spare".equals(warehouseGenre)) {
            isSpare = "true";
        }
        warehouseProductService.deleteTable(companyId, isSpare);

        //货品表(库存数量,锁定库存数量)初始化为零
        productService.initialProductByStockCount(companyId, isSpare);

        taskService.deleteTableByTask(companyId);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel listPageWarehouseInitial(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInitial");
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

        List<Map> varList = this.getDataListPage(pd, pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles", titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList", varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel initialWarehouse(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        //初始化仓库业务表
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //初始化仓库属性
        //warehouse:(简版,复杂版)仓库 spare:备件库
        String warehouseGenre = pageData.getString("warehouseGenre");
        if (warehouseGenre == null || warehouseGenre.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("初始化仓库属性为空或空字符串！");
            return model;
        }

        this.initialByWarehouse(warehouseGenre, cuser, companyId);
        return model;
    }

    @Override
    public ResultModel updateWarehouseProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库货品id(库存id)为空或空字符串！");
            return model;
        }

        //库存数量(修改后)
        String afterCountStr = pageData.getString("stockCount");
        BigDecimal afterCountBig = BigDecimal.valueOf(0D);

        if (afterCountStr == null || afterCountStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("库存数量为空或空字符串，库存数量为必填项不可为空！");
            return model;
        } else {
            afterCountStr = afterCountStr.trim();
            try {
                //全数字
                BigDecimal bigDecimal = new BigDecimal(afterCountStr);
                //四舍五入到2位小数
                afterCountBig = bigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            } catch (NumberFormatException e) {
                String msg_column_error = "{0}:{1} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！" + Common.SYS_ENDLINE_DEFAULT;
                //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的数字(大于零的整数，或大于零的(1,2)位小数)！"
                String str_error = MessageFormat.format(msg_column_error, "库存数量", afterCountStr);
                model.putCode(Integer.valueOf(1));
                model.putMsg(str_error);
                return model;
            }
        }

        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        BigDecimal beforeCountBig = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            beforeCountBig = warehouseProduct.getStockCount();
        }

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
        productService.updateStockCount(product, prodStockCount, cuser, "update");

        return model;
    }

    @Override
    public ResultModel deleteWarehouseProduct(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库货品id(库存id)为空或空字符串！");
            return model;
        }

        WarehouseProduct warehouseProduct = warehouseProductService.findWarehouseProductById(id);
        String productId = warehouseProduct.getProductId();
        BigDecimal stockCount = BigDecimal.valueOf(0D);
        if (warehouseProduct.getStockCount() != null) {
            stockCount = warehouseProduct.getStockCount();
        }

        //删除库存表(vmes_warehouse_product:仓库货位产品库存表)
        warehouseProductService.deleteById(id);

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

//    public ResultModel deleteWarehouseProductBySimple(PageData pageData) throws Exception {
//        ResultModel model = new ResultModel();
//        String cuser = pageData.getString("cuser");
//
//        String warehouseId = pageData.getString("warehouseId");
//        if (warehouseId == null || warehouseId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("货位id为空或空字符串！");
//            return model;
//        }
//
//        String productId = pageData.getString("productId");
//        if (productId == null || productId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("货品id为空或空字符串！");
//            return model;
//        }
//
//        //当前(货位id,货品id)仓库数量-sql查询已经按(货位id,货品id)汇总
//        BigDecimal stockCount = BigDecimal.valueOf(0D);
//        String stockCountStr = pageData.getString("stockCount");
//        if (stockCountStr != null) {
//            try {
//                stockCount = new BigDecimal(stockCountStr);
//                //四舍五入到2位小数
//                stockCount = stockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//
//        //删除库存表(vmes_warehouse_product:仓库货位产品库存表)
//        Map columnMap = new HashMap();
//        columnMap.put("product_id", productId);
//        columnMap.put("warehouse_id", warehouseId);
//        warehouseProductService.deleteByColumnMap(columnMap);
//
//        Product product = productService.findProductById(productId);
//        BigDecimal prodCount = BigDecimal.valueOf(0D);
//        if (product.getStockCount() != null) {
//            prodCount = product.getStockCount();
//        }
//
//        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() - stockCount.doubleValue());
//        //四舍五入到2位小数
//        prodStockCount = prodStockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//        productService.updateStockCount(product, prodStockCount, cuser);
//        return model;
//    }

    @Override
    public void exportExcelWarehouseInitial(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("warehouseInitial");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "wp.id in (" + ids + ")";
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
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    public void exportExcelTemplateWarehouseInitial(PageData pd) throws Exception {
        List<Column> columnList = columnService.findColumnList("warehouseInitial");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        //pd.put("queryStr", queryStr);
        List<Map> dataList = warehouseToWarehouseProductService.findMapListWarehouseToWarehouseProduct(pd);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseInitial(MultipartFile file) throws Exception {
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

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        dataMapLst.remove(0);

        StringBuffer checkColumnMsgStr = new StringBuffer();
        //1. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        String msgStr = warehouseProductExcelService.checkColumnImportExcel(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            checkColumnMsgStr.append(msgStr);
        }

        //2. (货位编码,货位名称) (货品编码,货品名称,规格型号,货品属性,计量单位) 名称匹配
        Map<String, String> warehouseMap = new HashMap<String, String>();
        Map<String, String> productMap = new HashMap<String, String>();
        msgStr = warehouseProductExcelService.checkColumnImportExcelByDataBase(dataMapLst,
                companyId,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW,
                warehouseMap,
                productMap);
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

        //3. 遍历Excel导入List-Map<String, WarehouseProduct>
        Map<String, WarehouseProduct> warehouseProductMap = new HashMap<String, WarehouseProduct>();
        warehouseProductExcelService.findWarehouseProductMapByExcelDataList(dataMapLst,
                warehouseProductMap,
                warehouseMap,
                productMap);

        //4. 遍历Map<String, WarehouseProduct> 对业务表添加
        warehouseProductExcelService.addWarehouseProduct(warehouseProductMap, companyId, userId);

        return model;
    }

    @Override
    public ResultModel findWarehouseInitialByWC(PageData pd) throws Exception {
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

        List<Map> varList = this.findWarehouseInitialByWC(pd, pg);
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


    //仓库初始化(简版仓库)
    public List<Map> findWarehouseInitialByWC(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseInitialMapper.findWarehouseProductByWC(pd);
        } else if (pg != null) {
            return warehouseInitialMapper.findWarehouseProductByWC(pd,pg);
        }

        return mapList;
    }
}



