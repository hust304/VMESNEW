package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Equipment;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentService;
import com.xy.vmes.service.FileService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：操作日志Controller
* @author 刘威 自动生成
* @date 2018-09-20
*/
@RestController
@Slf4j
public class EquipmentController {

    private Logger logger = LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @GetMapping("/base/equipment/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################equipment/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        Equipment equipment = equipmentService.selectById(id);
        model.putResult(equipment);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################equipment/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Equipment equipment = (Equipment)HttpUtils.pageData2Entity(pd, new Equipment());
        equipmentService.save(equipment);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################equipment/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Equipment equipment = (Equipment)HttpUtils.pageData2Entity(pd, new Equipment());
        equipmentService.update(equipment);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @GetMapping("/base/equipment/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################equipment/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        equipmentService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################equipment/deleteByIds 执行开始 ################# ");
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
            equipmentService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################equipment/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Equipment> equipmentList = equipmentService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",equipmentList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################equipment/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Equipment> equipmentList = equipmentService.dataList(pd);
        model.putResult(equipmentList);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/listPageEquipments")
    public ResultModel listPageEquipments()  throws Exception {

        logger.info("################equipment/listPageEquipments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = equipmentService.listPageEquipments(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/listPageEquipments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/exportExcelEquipments")
    public void exportExcelEquipments() throws Exception {
        logger.info("################equipment/exportExcelEquipments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        equipmentService.exportExcelEquipments(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/exportExcelEquipments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/base/equipment/importExcelEquipments")
    public ResultModel importExcelEquipments(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################equipment/importExcelEquipments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = equipmentService.importExcelEquipments(file);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/importExcelEquipments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-09-20
     */
    @PostMapping("/base/equipment/addEquipment")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addEquipment()  throws Exception {

        logger.info("################equipment/addEquipment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentService.addEquipment(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/addEquipment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-09-20
     */
    @PostMapping("/base/equipment/updateEquipment")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEquipment()  throws Exception {

        logger.info("################equipment/updateEquipment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Equipment equipment = (Equipment)HttpUtils.pageData2Entity(pd, new Equipment());
        equipmentService.update(equipment);
        Long endTime = System.currentTimeMillis();
        logger.info("################equipment/updateEquipment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    public ResultModel deleteEquipments()  throws Exception {
//        logger.info("################equipment/deleteEquipments 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        ResultModel model = new ResultModel();
//        PageData pd = HttpUtils.parsePageData();
//        String ids = pd.getString("ids");
//        if(StringUtils.isEmpty(ids)){
//            model.putCode("1");
//            model.putMsg("未勾选删除记录，请重新选择！");
//            return model;
//        }
//        String id_str = StringUtil.stringTrimSpace(ids);
//        String[] id_arry = id_str.split(",");
//        if(id_arry.length>0){
//            equipmentService.deleteByIds(id_arry);
//        }
//        Long endTime = System.currentTimeMillis();
//        logger.info("################equipment/deleteEquipments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

}



