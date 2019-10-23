package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.service.WarehouseOutDetailExecuteService;
import com.xy.vmes.service.WarehouseOutService;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.*;



/**
* 说明：出库Controller
* @author 刘威 自动生成
* @date 2018-10-22
*/
@RestController
@Slf4j
public class WarehouseOutController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailExecuteService outDetailExecuteService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @GetMapping("/warehouse/warehouseOut/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOut/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOut warehouseOut = warehouseOutService.selectById(id);
        model.putResult(warehouseOut);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOut/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOut warehouseOut = (WarehouseOut)HttpUtils.pageData2Entity(pd, new WarehouseOut());
        warehouseOutService.save(warehouseOut);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOut/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOut warehouseOut = (WarehouseOut)HttpUtils.pageData2Entity(pd, new WarehouseOut());
        warehouseOutService.update(warehouseOut);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @GetMapping("/warehouse/warehouseOut/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOut/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOut/deleteByIds 执行开始 ################# ");
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
            warehouseOutService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOut/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOut> warehouseOutList = warehouseOutService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOut/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOut> warehouseOutList = warehouseOutService.dataList(pd);
        model.putResult(warehouseOutList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/




    /**
     * 编辑出库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/updateWarehouseOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOut() throws Exception {
        logger.info("################/warehouseOut/updateWarehouseOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.updateWarehouseOut(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOut/updateWarehouseOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
     * 新增出库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/addWarehouseOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseOut() throws Exception {
        logger.info("################/warehouseOut/addWarehouseOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.addWarehouseOut(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOut/addWarehouseOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 恢复出库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/recoveryWarehouseOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseOut() throws Exception {
        logger.info("################/warehouseOut/recoveryWarehouseOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.recoveryWarehouseOut(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOut/recoveryWarehouseOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 取消出库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/cancelWarehouseOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseOut() throws Exception {
        logger.info("################/warehouseOut/cancelWarehouseOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.cancelWarehouseOut(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOut/cancelWarehouseOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除出库单
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/deleteWarehouseOut")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOut() throws Exception {
        logger.info("################/warehouseOut/deleteWarehouseOut 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.deleteWarehouseOut(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOut/deleteWarehouseOut 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-22
    */
    @PostMapping("/warehouse/warehouseOut/listPageWarehouseOuts")
    public ResultModel listPageWarehouseOuts()  throws Exception {

        logger.info("################warehouseOut/listPageWarehouseOuts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseOutService.listPageWarehouseOuts(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOut/listPageWarehouseOuts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 根据出库单id-关联查询(vmes_warehouse_out_detail,vmes_warehouse_out_execute)
     * 获取(出库单id)出库单明细对应的出库执行数量，是否存在执行数量大于零
     *
     * 返回值:
     * isExistExecuteCount: 是否存在出库执行数量大于零
     * false: 不存在
     * true:  存在(一条或多条出库执行数量大于零)
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOut/checkExecuteCountWarehouseOut")
    public ResultModel checkExecuteCountWarehouseOut() throws Exception {
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String parentId = pd.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }

        String isExistExecuteCount = new String("false");

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        List<Map> mapList = outDetailExecuteService.findOutDetailExecute(findMap);
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> mapObject : mapList) {
                //出库单明细-出库执行数量
                BigDecimal outDtlExecuteCount = (BigDecimal)mapObject.get("outDtlExecuteCount");
                if (outDtlExecuteCount != null && outDtlExecuteCount.doubleValue() != 0D) {
                    isExistExecuteCount = "true";
                    break;
                }
            }
        }

        model.put("isExistExecuteCount", isExistExecuteCount);
        return model;
    }


//    /**
//    * Excel导出
//    * @author 刘威 自动创建，可以修改
//    * @date 2018-10-22
//    */
//    @PostMapping("/warehouse/warehouseOut/exportExcelWarehouseOuts")
//    public void exportExcelWarehouseOuts() throws Exception {
//        logger.info("################warehouseOut/exportExcelWarehouseOuts 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pd = HttpUtils.parsePageData();
//        Pagination pg = HttpUtils.parsePagination(pd);
//        warehouseOutService.exportExcelWarehouseOuts(pd,pg);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################warehouseOut/exportExcelWarehouseOuts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }
//
//    /**
//    * Excel导入
//    *
//    * @author 刘威 自动创建，可以修改
//    * @date 2018-10-22
//    */
//    @PostMapping("/warehouse/warehouseOut/importExcelWarehouseOuts")
//    public ResultModel importExcelWarehouseOuts(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
//        logger.info("################warehouseOut/importExcelWarehouseOuts 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = warehouseOutService.importExcelWarehouseOuts(file);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################warehouseOut/importExcelWarehouseOuts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

}



