package ${classPath};

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.ColumnUtil;

import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.${objectName};
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.${objectName}Service;

import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：${TITLE}Controller
* @author ${author} 自动生成
* @date ${nowDate?string("yyyy-MM-dd")}
*/
@RestController
@Slf4j
public class ${objectName}Controller {

    private Logger logger = LoggerFactory.getLogger(${objectName}Controller.class);

    @Autowired
    private ${objectName}Service ${objectNameLower}Service;

    @Autowired
    private ColumnService columnService;

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################${objectNameLower}/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        ${objectName} ${objectNameLower} = ${objectNameLower}Service.selectById(id);
        model.putResult(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/save")
    public ResultModel save()  throws Exception {

        logger.info("################${objectNameLower}/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
        ${objectNameLower}Service.save(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/update")
    public ResultModel update()  throws Exception {

        logger.info("################${objectNameLower}/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
        ${objectNameLower}Service.update(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################${objectNameLower}/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        ${objectNameLower}Service.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/deleteByIds")
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################${objectNameLower}/deleteById 执行开始 ################# ");
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
            ${objectNameLower}Service.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################${objectNameLower}/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",${objectNameLower}List);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.dataList(pd);
        model.putResult(${objectNameLower}List);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author ${author} 自动创建，可以修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/listPage${objectName}s")
    public ResultModel listPage${objectName}s()  throws Exception {

        logger.info("################${objectNameLower}/listPage${objectName}s 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        //List<LinkedHashMap> titles = ${objectNameLower}Service.getColumnList();
        List<LinkedHashMap> titles = new ArrayList<LinkedHashMap>();
        List<Column> columnList = columnService.findColumnList("dictionary");
        if (columnList == null || columnList.size() == 0) {
            titles = ${objectNameLower}Service.getColumnList();
        } else {
            titles = ColumnUtil.listColumnByModelCode(columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(titles!=null&&titles.size()>0){
            LinkedHashMap<String, String> titlesMap = titles.get(0);
            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
                LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                if(entry.getKey().indexOf("_hide")>0){
                    titlesLinkedMap.put(entry.getKey().replace("_hide",""),entry.getValue());
                    titlesHideList.add(entry.getKey().replace("_hide",""));
                    varModelMap.put(entry.getKey().replace("_hide",""),"");
                }else{
                    titlesLinkedMap.put(entry.getKey(),entry.getValue());
                    varModelMap.put(entry.getKey(),"");
                }
                titlesList.add(titlesLinkedMap);
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = ${objectNameLower}Service.getDataListPage(pd,pg);
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
        logger.info("################${objectNameLower}/listPage${objectName}s 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author ${author} 自动创建，可以修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/exportExcel${objectName}s")
    public void exportExcel${objectName}s() throws Exception {
        logger.info("################${objectNameLower}/exportExcel${objectName}s 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.get("ids");
        String queryColumn = (String)pd.get("queryColumn");
        String showFieldcode = (String)pd.get("showFieldcode");

        //2. 获取业务列表List<Map<栏位Key, 栏位名称>>  Service.getColumnList();
        List<LinkedHashMap> columnList = null;
        LinkedHashMap columnMap = ExcelUtil.modifyColumnMap(showFieldcode, columnList.get(0));

        //3. 根据查询条件获取业务数据List
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        if (queryColumn != null && queryColumn.trim().length() > 0) {
            queryStr = queryStr + queryColumn;
        }

        PageData findMap = new PageData();
        //业务表查询条件 findMap.put("查询字段名称", "Value");
        findMap.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> dataList = ${objectNameLower}Service.getDataList(findMap);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ExcelUtil.modifyDataList(columnMap, dataList);

        HttpServletResponse response  = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        //String fileName = "Excel文件导出";
        String fileName = "Excel${objectName}";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/exportExcel${objectName}s 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author ${author} 自动创建，可以修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/importExcel${objectName}s")
    public ResultModel importExcel${objectName}s(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################${objectNameLower}/importExcel${objectName}s 执行开始 ################# ");
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
        List<Map<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/importExcel${objectName}s 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



