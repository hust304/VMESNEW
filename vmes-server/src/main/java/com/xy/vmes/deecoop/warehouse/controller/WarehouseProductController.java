package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseProduct;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseProductByCollectService;
import com.xy.vmes.service.WarehouseProductService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
* 说明：出库明细Controller
* @author 刘威 自动生成
* @date 2018-10-31
*/
@RestController
@Slf4j
public class WarehouseProductController {
    private Logger logger = LoggerFactory.getLogger(WarehouseProductController.class);

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseProductByCollectService warehouseProductByCollectService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseProduct/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseProduct warehouseProduct = (WarehouseProduct)HttpUtils.pageData2Entity(pd, new WarehouseProduct());
        warehouseProductService.save(warehouseProduct);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseProduct/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseProduct warehouseProduct = (WarehouseProduct)HttpUtils.pageData2Entity(pd, new WarehouseProduct());
        warehouseProductService.update(warehouseProduct);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @GetMapping("/warehouse/warehouseProduct/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseProduct/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseProductService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseProduct/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
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
            warehouseProductService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseProduct/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseProduct> warehouseProductList = warehouseProductService.dataList(pd);
        model.putResult(warehouseProductList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * @author 刘威
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/updateSynStockCount")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSynStockCount()  throws Exception {
        logger.info("################warehouseProduct/updateSynStockCount 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.updateSynStockCount(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/updateSynStockCount 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/updateWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProduct()  throws Exception {
        logger.info("################warehouseProduct/updateWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.updateWarehouseProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/updateWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductView")
    public ResultModel listPageWarehouseProductView()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageWarehouseProductView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageSimpleWarehouseProductView")
    public ResultModel listPageSimpleWarehouseProductView()  throws Exception {

        logger.info("################warehouseProduct/listPageSimpleWarehouseProductView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageSimpleWarehouseProductView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageSimpleWarehouseProductView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWCWarehouseProductView")
    public ResultModel listPageWCWarehouseProductView()  throws Exception {

        logger.info("################warehouseProduct/listPageWCWarehouseProductView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageWCWarehouseProductView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWCWarehouseProductView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductMove")
    public ResultModel listPageWarehouseProductMove()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductMove 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductMove(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductMove 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseDetailView")
    public ResultModel listPageWarehouseDetailView()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseDetailView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseDetailView(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseDetailView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageSimpleWarehouseDetailView")
    public ResultModel listPageSimpleWarehouseDetailView()  throws Exception {

        logger.info("################warehouseProduct/listPageSimpleWarehouseDetailView 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageSimpleWarehouseDetailView(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageSimpleWarehouseDetailView 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-31
    */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductsDispatch")
    public ResultModel listPageWarehouseProductsDispatch()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductsDispatch 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductsDispatch(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductsDispatch 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，可以修改
     * @date 2018-10-31
     */
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductsDispatchOption")
    public ResultModel listPageWarehouseProductsDispatchOption()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOption 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseProductService.listPageWarehouseProductsDispatchOption(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOption 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseProductsDispatchOptionBySimple")
    public ResultModel listPageWarehouseProductsDispatchOptionBySimple()  throws Exception {

        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOptionBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageWarehouseProductsDispatchOptionBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseProduct/listPageWarehouseProductsDispatchOptionBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //仓库表(vmes_warehouse)-关联仓库货品表(vmes_warehouse_product)
    //获取全部仓库信息-并且关联仓库货品表
    @PostMapping("/warehouse/warehouseProduct/listPageWarehouseToWarehouseProductBySimple")
    public ResultModel listPageWarehouseToWarehouseProductBySimple() throws Exception {
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseProductService.listPageWarehouseToWarehouseProductBySimple(pd);
        return model;
    }

    //获取仓库货品信息(虚拟库)-根据(货品id)汇总
    @PostMapping("/warehouse/warehouseProduct/findListProductByWarehouseVirtual")
    public ResultModel findListProductByWarehouseVirtual() throws Exception {
        logger.info("################/warehouse/warehouseProduct/findListProductByWarehouseVirtual 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("productByWarehouseVirtual");
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

//        //是否需要分页 true:需要分页 false:不需要分页
//        Map result = new HashMap();
//        String isNeedPage = pd.getString("isNeedPage");
//        if ("false".equals(isNeedPage)) {
//            pg = null;
//        } else {
//            result.put("pageData", pg);
//        }

        //参数:(deptId deptPlaceKey) 虚拟库查询必须条件-从界面获取参数
        //deptId: 部门id (当前登录用户所属部门id) 用户登录后前端就已经获得
        //deptPlaceKey: 字典表定义(vmes_dictionary:pid:db46547d1bcb4c14baa228db1e8aaffe)
        List<Map> varList = warehouseProductByCollectService.findProductByWarehouseVirtual(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseProduct/findListProductByWarehouseVirtual 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 库存查询(只导出货品仓库信息) Excel导出
     * @author 陈刚 自动创建，可以修改
     * @date 2018-11-20
     */
    @PostMapping("/warehouse/warehouseProduct/exportExcelWarehouseProductByProduct")
    public void exportExcelWarehouseProductByProduct() throws Exception {
        logger.info("################/warehouse/warehouseProduct/exportExcelWarehouseProductByProduct  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        warehouseProductService.exportExcelWarehouseProductByProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseProduct/exportExcelWarehouseProductByProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    ////////////////////////////////////////////////////////////////////////////////
    //文成企业定制
    /**
     * 修改仓库货品价格-文成企业定制
     *
     * @date 2019-11-14
     */
    @PostMapping("/warehouse/warehouseProduct/updateWarehouseProductOnPriceByWc")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProductOnPriceByWc() throws Exception {
        logger.info("################/warehouse/warehouseProduct/updateWarehouseProductOnPriceByWc 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("仓库货品id为空或空字符串！");
            return model;
        }

        String newProductPriceStr = pageData.getString("newProductPrice");
        if (newProductPriceStr == null || newProductPriceStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("变更单价为必填项不可为空！");
            return model;
        }

        BigDecimal price = BigDecimal.valueOf(0D);
        try {
            price = new BigDecimal(newProductPriceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //四舍五入到2位小数
        price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

//        String remark = new String();
//        if (pageData.getString("remark") != null) {
//            remark = pageData.getString("remark").trim();
//        }

        WarehouseProduct editObject = new WarehouseProduct();
        editObject.setId(id);
        editObject.setPrice(price);
        //editObject.setRemark(remark);
        warehouseProductService.update(editObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseProduct/updateWarehouseProductOnPriceByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 库存查询-仓库货品价格 Excel导出-文成企业定制
     * @author 陈刚
     * @date 2019-11-14
     */
    @PostMapping("/warehouse/warehouseProduct/exportExcelWarehouseProductOnPriceByWc")
    public void exportExcelWarehouseProductOnPriceByWc() throws Exception {
        logger.info("################/warehouse/warehouseProduct/exportExcelWarehouseProductOnPriceByWc 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        PageData pd = HttpUtils.parsePageData();
        warehouseProductService.exportExcelWarehouseProductOnPriceByWc(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseProduct/exportExcelWarehouseProductOnPriceByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

    /**
     * 仓库货品(价格) Excel导入文成企业定制
     *
     * @author 陈刚
     * @date 2019-11-14
     */
    @PostMapping("/warehouse/warehouseProduct/importExcelWarehouseProductOnPriceByWc")
    public ResultModel importExcelWarehouseProductOnPriceByWc(@RequestParam(value="excelFile") MultipartFile file) throws Exception {
        logger.info("################/warehouse/warehouseProduct/importExcelWarehouseProductOnPriceByWc 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = warehouseProductService.importExcelWarehouseProductOnPriceByWc(file);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseProduct/importExcelWarehouseProductOnPriceByWc 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}

