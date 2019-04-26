package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.BomTreeService;
import com.xy.vmes.service.BundleAnalysisService;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 46368 on 2019/2/27.
 */
@Service
@Transactional(readOnly = false)
public class BundleAnalysisServiceImp implements BundleAnalysisService {
    @Autowired
    private BomTreeService bomTreeService;
    @Autowired
    private ColumnService columnService;

    @Override
    public ResultModel getBomTreeProduct(PageData pd) throws Exception {
        return bomTreeService.getBomTreeProduct(pd);
    }

    @Override
    public ResultModel getLackProduct(PageData pd,Pagination pg) throws Exception {

        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("BomTreeProductChildren");
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



        String dtlJsonStr = pd.getString("dtlJsonStr");

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        List<TreeEntity> varMapList = new ArrayList();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String edate = format.format(new Date());
        if(mapList!=null&&mapList.size()>0){
            for(int i=0;i<mapList.size();i++){
                Map<String, String> detailMap = mapList.get(i);
                TreeEntity treeEntity = (TreeEntity) HttpUtils.pageData2Entity(detailMap, new TreeEntity());
                treeEntity.setEdate(edate);
                varMapList.add(treeEntity);
            }
        }

//        List<TreeEntity> varMapList = bomTreeService.getBomTreeProductList(pd);


        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }
}
