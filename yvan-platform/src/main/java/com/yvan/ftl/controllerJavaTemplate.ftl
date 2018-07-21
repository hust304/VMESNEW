package ${classPath};

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.${objectName};
import com.xy.vmes.service.${objectName}Service;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
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
* @author ${author}
* @date ${nowDate?string("yyyy-MM-dd")}
*/
@RestController
@Slf4j
public class ${objectName}Controller {

    private Logger logger = LoggerFactory.getLogger(${objectName}Controller.class);

    @Autowired
    private ${objectName}Service ${objectNameLower}Service;


    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/selectById/{id}")
    public String selectById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            ${objectName} ${objectNameLower} = ${objectNameLower}Service.selectById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",${objectNameLower});
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/selectById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }



    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/findById")
    public String findById() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            ${objectName} ${objectNameLower} = ${objectNameLower}Service.findById(pd);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",${objectNameLower});
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/findById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/save")
    public String save() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
            ${objectNameLower}Service.save(${objectNameLower});
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/save################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/update")
    public String update() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
            ${objectNameLower}Service.update(${objectNameLower});
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/update################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/delete")
    public String delete() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            ${objectName} ${objectNameLower} = (${objectName})HttpUtils.pageData2Entity(pd, new ${objectName}());
            ${objectNameLower}Service.delete(${objectNameLower});
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/delete################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }


    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            ${objectNameLower}Service.deleteById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/deleteById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/dataListPage")
    public String dataListPage() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Pagination pg = HttpUtils.parsePagination();
            List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.dataListPage(pd,pg);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",${objectNameLower}List);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/dataListPage################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @PostMapping("/${objectNameLower}/dataList")
    public String dataList() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            List<${objectName}> ${objectNameLower}List = ${objectNameLower}Service.dataList(pd);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",${objectNameLower}List);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################${objectNameLower}/dataList################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * @author ${author}
    * @date ${nowDate?string("yyyy-MM-dd")}
    */
    @GetMapping("/${objectNameLower}/excelExport")
    public void excelExport() {

        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","*");
        response.addHeader("Access-Control-Max-Age","100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials","false");
        try {
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
            }catch(Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                logger.error("################${objectNameLower}/excelExport################# 执行异常:"+sw.toString());
            }

    }



}



