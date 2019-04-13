package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.deecoop.base.dao.BomTreeMapper;
import com.xy.vmes.entity.BomTree;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.BomTreeService;
import com.xy.vmes.service.ColumnService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-09-29
*/
@Service
@Transactional(readOnly = false)
public class BomTreeServiceImp implements BomTreeService {


    @Autowired
    private BomTreeMapper bomTreeMapper;
    @Autowired
    private BomTreeService bomTreeService;

    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void save(BomTree bomTree) throws Exception{
        bomTree.setCdate(new Date());
        bomTree.setUdate(new Date());
        bomTreeMapper.insert(bomTree);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void update(BomTree bomTree) throws Exception{
        bomTree.setUdate(new Date());
        bomTreeMapper.updateById(bomTree);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateAll(BomTree bomTree) throws Exception{
        bomTree.setUdate(new Date());
        bomTreeMapper.updateAllColumnById(bomTree);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    //@Cacheable(cacheNames = "bomTree", key = "''+#id")
    public BomTree selectById(String id) throws Exception{
        return bomTreeMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteById(String id) throws Exception{
        bomTreeMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        bomTreeMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<BomTree> dataListPage(PageData pd,Pagination pg) throws Exception{
        return bomTreeMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<BomTree> dataList(PageData pd) throws Exception{
        return bomTreeMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return bomTreeMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return bomTreeMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        bomTreeMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<BomTree> selectByColumnMap(Map columnMap) throws Exception{
    List<BomTree> bomTreeList =  bomTreeMapper.selectByMap(columnMap);
        return bomTreeList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return bomTreeMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return bomTreeMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        bomTreeMapper.updateToDisableByIds(ids);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    @Override
    public void deleteByBomIds(String[] ids) throws Exception {
        bomTreeMapper.deleteByBomIds(ids);
    }

    @Override
    public List<TreeEntity> getBomTreeList(PageData pd) throws Exception {
        return bomTreeMapper.getBomTreeList(pd);
    }

    @Override
    public List<TreeEntity> getBomTreeProductList(PageData pd) throws Exception {
        return bomTreeMapper.getBomTreeProductList(pd);
    }

    @Override
    public ResultModel getBomTreeProduct(PageData pd)throws Exception{
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("BomTreeProduct");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取根节点表头
        Map rootTitleMap = ColumnUtil.getTitleList(columnList);

        result.put("hideTitles",rootTitleMap.get("hideTitles"));
        result.put("titles",rootTitleMap.get("titles"));

        columnList = columnService.findColumnList("BomTreeProductChildren");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        //获取子节点表头
        Map childrenTitleMap = ColumnUtil.getTitleList(columnList);

        List<TreeEntity> varMapList = new ArrayList();

        List<TreeEntity> treeList = bomTreeService.getBomTreeProductList(pd);
        String expectCount = StringUtils.isEmpty(pd.getString("expectCount"))?"0":pd.getString("expectCount");
        TreeEntity treeObj = TreeUtil.switchBomTree(pd.getString("productId"),treeList,BigDecimal.valueOf(Double.parseDouble(expectCount)),childrenTitleMap);
//        TreeEntity treeObj = TreeUtil.switchBomTree("99767a4e1d7f4482bc90477096b62b4e",treeList,BigDecimal.TEN,childrenTitleMap);
        varMapList.add(treeObj);
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageBomTrees(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("BomTree");
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
        List<Map> varList = bomTreeService.getDataListPage(pd,pg);
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
        return model;
    }

    @Override
    public void exportExcelBomTrees(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("BomTree");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List

        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);


        pg.setSize(100000);
        List<Map> dataList = bomTreeService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelBomTree";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelBomTrees(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
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
        return model;
    }

    @Override
    public ResultModel getBomTree(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<TreeEntity> treeList = bomTreeService.getBomTreeList(pd);
        TreeEntity treeObj = TreeUtil.switchTree(pd.getString("prodId"), treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel addBomTree(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        BomTree bomTree = (BomTree)HttpUtils.pageData2Entity(pd, new BomTree());
        String id = Conv.createUuid();
        bomTree.setId(id);
        bomTree.setPathId(bomTree.getPathId()+"_"+id);
        bomTree.setLayer(bomTree.getLayer()+1);

        bomTreeService.save(bomTree);
        return model;
    }

    @Override
    public ResultModel updateBomTree(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        BomTree newBomTree = (BomTree)HttpUtils.pageData2Entity(pd, new BomTree());
        BomTree oldBomTree = bomTreeService.selectById(newBomTree.getId());
        bomTreeService.update(newBomTree);

        pd = new PageData();
        pd.put("isQueryAll","true");
        pd.put("queryStr"," bom_id = '"+oldBomTree.getBomId()+"' and  parent_prod_id = '"+oldBomTree.getProdId()+"' and  layer = '"+(oldBomTree.getLayer()+1)+"' ");
//        pd.put("bomId",oldBomTree.getBomId());
//        pd.put("parentProdId",oldBomTree.getProdId());
//        pd.put("layer",oldBomTree.getLayer()+1);
        List<BomTree> bomTreeList = bomTreeService.dataList(pd);

        if(bomTreeList!=null&&bomTreeList.size()>0){
            for(int i=0;i<bomTreeList.size();i++){
                BomTree bomTree =  bomTreeList.get(i);
                bomTree.setParentProdId(newBomTree.getProdId());
                bomTreeService.update(bomTree);
            }

        }
        return model;
    }

    @Override
    public ResultModel deleteBomTree(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String id = pd.getString("id");
        if(StringUtils.isEmpty(id)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }

        BomTree bomTree = bomTreeService.selectById(id);

        pd = new PageData();
        pd.put("isQueryAll","true");
        pd.put("queryStr"," bom_id = '"+bomTree.getBomId()+"' and  parent_prod_id = '"+bomTree.getProdId()+"' and  layer = '"+(bomTree.getLayer()+1)+"' ");
        List<BomTree> bomTreeList = bomTreeService.dataList(pd);
        if(bomTreeList!=null&&bomTreeList.size()>0){
            model.putCode("2");
            model.putMsg("请删除该节点的所有下级子节点后再进行尝试删除操作！");
            return model;
        }else{
            bomTreeService.deleteById(id);
        }
        return model;
    }
}



