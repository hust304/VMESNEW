package ${classPath};

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.${objectName};
import com.xy.vmes.service.${objectName}Service;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


/**
* 说明：Controller
* @author ${author} 自动生成
* @date ${nowDate?string("yyyy-MM-dd")}
*/
@RestController
@Slf4j
public class ${objectName}Controller {

    private Logger logger = LoggerFactory.getLogger(${objectName}Controller.class);

    @Autowired
    private ${objectName}Service ${objectNameLower}Service;


    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        ${objectName} ${objectNameLower} = ${objectNameLower}Service.selectById(id);
        model.putResult(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/save")
    public ResultModel save()  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
        ${objectNameLower}Service.save(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/update")
    public ResultModel update()  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
        ${objectNameLower}Service.update(${objectNameLower});
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        ${objectNameLower}Service.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.dataListPage(pd,pg);
        model.putResult(${objectNameLower}List);
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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

    /**
    * @author ${author} 自动创建，禁止修改
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################${objectNameLower}/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = ${objectNameLower}Service.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = ${objectNameLower}Service.findDataList(pd);
                    request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################${objectNameLower}/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

}



