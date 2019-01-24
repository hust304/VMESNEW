package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleLockDate;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleLockDateService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
* 说明：设置锁库时间Controller
* @author 刘威 自动生成
* @date 2018-12-12
*/
@RestController
@Slf4j
public class SaleLockDateController {

    private Logger logger = LoggerFactory.getLogger(SaleLockDateController.class);

    @Autowired
    private SaleLockDateService saleLockDateService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @GetMapping("/saleLockDate/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################saleLockDate/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleLockDate saleLockDate = saleLockDateService.selectById(id);
        model.putResult(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################saleLockDate/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        saleLockDateService.save(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################saleLockDate/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        saleLockDateService.update(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @GetMapping("/saleLockDate/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################saleLockDate/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleLockDateService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################saleLockDate/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
            saleLockDateService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################saleLockDate/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleLockDateList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################saleLockDate/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataList(pd);
        model.putResult(saleLockDateList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    @PostMapping("/saleLockDate/updateSaleLockDate")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateSaleLockDate()  throws Exception {

        logger.info("################saleLockDate/updateSaleLockDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        int day = saleLockDate.getDay()==null?0:saleLockDate.getDay();
        int hour = saleLockDate.getHour()==null?0:saleLockDate.getHour();
        int minute = saleLockDate.getMinute()==null?0:saleLockDate.getMinute();
        saleLockDate.setSecond(day*24*60*60+hour*60*60+minute*60);
        saleLockDateService.update(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/updateSaleLockDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    @PostMapping("/saleLockDate/saveSaleLockDate")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel saveSaleLockDate()  throws Exception {

        logger.info("################saleLockDate/saveSaleLockDate 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());

        pd.putQueryStr(" company_id = '"+saleLockDate.getCompanyId()+"'");
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataList(pd);
        if(saleLockDateList!=null&&saleLockDateList.size()>0){
            for(int i=0;i<saleLockDateList.size();i++){
                SaleLockDate deleteObj = saleLockDateList.get(i);
                saleLockDateService.deleteById(deleteObj.getId());
            }
        }
        int day = saleLockDate.getDay()==null?0:saleLockDate.getDay();
        int hour = saleLockDate.getHour()==null?0:saleLockDate.getHour();
        int minute = saleLockDate.getMinute()==null?0:saleLockDate.getMinute();
        saleLockDate.setSecond(day*24*60*60+hour*60*60+minute*60);
        saleLockDateService.save(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/saveSaleLockDate 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    @PostMapping("/saleLockDate/selectSaleLockDateByCompanyId")
    public ResultModel selectSaleLockDateByCompanyId()  throws Exception {

        logger.info("################saleLockDate/selectSaleLockDateByCompanyId 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleLockDate> saleLockDateList = saleLockDateService.dataList(pd);
        SaleLockDate saleLockDate = null;
        if(saleLockDateList!=null&&saleLockDateList.size()>0){
            saleLockDate = saleLockDateList.get(0);
        }
        model.putResult(saleLockDate);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/selectSaleLockDateByCompanyId 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/listPageSaleLockDates")
    public ResultModel listPageSaleLockDates()  throws Exception {

        logger.info("################saleLockDate/listPageSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("SaleLockDate");
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleLockDateService.getDataListPage(pd,pg);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/listPageSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/exportExcelSaleLockDates")
    public void exportExcelSaleLockDates() throws Exception {
        logger.info("################saleLockDate/exportExcelSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("SaleLockDate");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = saleLockDateService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleLockDate";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/exportExcelSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-12
    */
    @PostMapping("/saleLockDate/importExcelSaleLockDates")
    public ResultModel importExcelSaleLockDates(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################saleLockDate/importExcelSaleLockDates 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
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

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################saleLockDate/importExcelSaleLockDates 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



