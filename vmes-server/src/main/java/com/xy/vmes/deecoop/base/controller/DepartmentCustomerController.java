package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.DepartmentCustomerService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 说明：部门客户供应商
 * @author 陈刚 自动生成
 * @date 2018-10-24
 */
@RestController
@Slf4j
public class DepartmentCustomerController {
    private Logger logger = LoggerFactory.getLogger(DepartmentCustomerController.class);

    @Autowired
    private DepartmentCustomerService departmentCustomerService;
    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-09-18
     */
    @PostMapping("/base/listPageDepartmentCustomer")
    public ResultModel listPageDepartmentCustomer()  throws Exception {
        logger.info("################base/listPageDepartmentCustomer 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("departmentCustomer");
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

        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        PageData pd = HttpUtils.parsePageData();
        pd.put("orderStr", "cdate desc");

        String genreId = pd.getString("pid");
        if (genreId != null && genreId.trim().length() > 0
                && !Common.DICTIONARY_MAP.get("customerSupplierGenre").equals(genreId)
                ) {
            pd.put("genre", genreId);
        }

        List<Map> varMapList = new ArrayList();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = departmentCustomerService.getDataListPage(pd, pg);
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
        logger.info("################base/listPageDepartmentCustomer 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
