package com.xy.vmes.deecoop.purchase.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.BomTreeService;
import com.xy.vmes.service.BundleAnalysisService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    @Autowired
    private SystemToolService systemToolService;

    @Override
    public ResultModel getBomTreeProduct(PageData pd) throws Exception {
        return bomTreeService.getBomTreeProduct(pd);
    }




    @Override
    public ResultModel getLackProductNew(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("PurchasePlanDetail");
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
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));


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

        List<Map> treeMapList = new ArrayList();
        if(mapList!=null&&mapList.size()>0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> detailMap = mapList.get(i);
                if(detailMap.get("id")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("产品 ID 不能为空！");
                    return model;
                }
                if(detailMap.get("bomId")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("BOM ID 不能为空！");
                    return model;
                }
                TreeEntity treeEntity = (TreeEntity) HttpUtils.pageData2Entity(detailMap, new TreeEntity());
                BigDecimal planCount = treeEntity.getPlanCount()==null?BigDecimal.ZERO:treeEntity.getPlanCount();

                PageData pageData = new PageData();
                pageData.put("bomId",treeEntity.getBomId());
                if(pd.get("isreplaceable")!=null && "1".equals(pd.get("isreplaceable"))){
                    pageData.put("isreplaceable",null);
                }else{
                    pageData.put("isreplaceable",'0');
                }
                List<TreeEntity> treeList = bomTreeService.getBomTreeProductList(pageData);

                Map map = new HashMap();
                map.put("productId",treeEntity.getId());
                map.put("planCount",planCount);
                map.put("treeList",treeList);
                treeMapList.add(map);
            }
        }
        if(treeMapList!=null&&treeMapList.size()>0){
            List<TreeEntity> varMapList = TreeUtil.getMaterielLackNum(treeMapList);
            List<Map> varMapListNew = new ArrayList<>();
            if(varMapList!=null&&varMapList.size()>0){
                for(TreeEntity treeEntity : varMapList){
//                    fieldCode: 'prodInfo,unitName,count,reason,edate,remark,orderCode',
//                            prodColumnKey: 'productCode,productName,spec,productProperty',

//                    let addDetail = {id:'', productId:'', productCode:'', productName:'', spec:'', productProperty:'',
//                            unitId:'', unitName:'', reasonId:'', reason:''};

                    Map detailMap = new HashMap();
                    detailMap.put("id",treeEntity.getId());
                    detailMap.put("productId",treeEntity.getId());
                    detailMap.put("productCode",treeEntity.getCode());
                    detailMap.put("productName",treeEntity.getName());
                    detailMap.put("spec",treeEntity.getSpec());
                    detailMap.put("productProperty",treeEntity.getProperty());
                    detailMap.put("unitId",treeEntity.getUnitId());
                    detailMap.put("unitName",treeEntity.getUnit());
                    detailMap.put("edate",format.format(new Date()));
                    detailMap.put("reasonId","350135d34d1b43aeb4e2977061632045");//齐套分析预采
                    detailMap.put("reason","齐套分析");
                    detailMap.put("remark","齐套分析预采");
                    detailMap.put("count",treeEntity.getLackCount().toString());
                    varMapListNew.add(detailMap);
                }
            }


            if (varMapListNew != null && varMapListNew.size() > 0) {
                //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
                String prodColumnKey = pd.getString("prodColumnKey");

                for (Map<String, Object> mapObject : varMapListNew) {
                    String prodInfo = systemToolService.findProductInfo(prodColumnKey, mapObject);
                    mapObject.put("prodInfo", prodInfo);
                }
            }

            result.put("varList",varMapListNew);
            model.putResult(result);
            return model;
        }else {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无查询记录！");
            return model;
        }
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
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));


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

        List<Map> treeMapList = new ArrayList();
        if(mapList!=null&&mapList.size()>0) {
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> detailMap = mapList.get(i);

                if(detailMap.get("id")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("产品 ID 不能为空！");
                    return model;
                }
                if(detailMap.get("bomId")==null){
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("BOM ID 不能为空！");
                    return model;
                }
                TreeEntity treeEntity = (TreeEntity) HttpUtils.pageData2Entity(detailMap, new TreeEntity());
                BigDecimal planCount = treeEntity.getPlanCount()==null?BigDecimal.ZERO:treeEntity.getPlanCount();

                PageData pageData = new PageData();
                pageData.put("bomId",treeEntity.getBomId());

                if(pd.get("isreplaceable")!=null && "1".equals(pd.get("isreplaceable"))){
                    pageData.put("isreplaceable",null);
                }else{
                    pageData.put("isreplaceable",'0');
                }


                List<TreeEntity> treeList = bomTreeService.getBomTreeProductList(pageData);

                Map map = new HashMap();
                map.put("productId",treeEntity.getId());
                map.put("planCount",planCount);
                map.put("treeList",treeList);
                treeMapList.add(map);
            }
        }
        if(treeMapList!=null&&treeMapList.size()>0){
            List<TreeEntity> varMapList = TreeUtil.getMaterielLackNum(treeMapList);
            result.put("varList",varMapList);
            model.putResult(result);
            return model;
        }else {
            model.putCode(Integer.valueOf(1));
            model.putMsg("无查询记录！");
            return model;
        }
    }
}
