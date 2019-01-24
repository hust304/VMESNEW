package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.Bom;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.BomTree;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.BomTreeService;
import com.yvan.*;
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
import java.math.BigDecimal;
import java.util.*;



/**
* 说明：操作日志Controller
* @author 刘威 自动生成
* @date 2018-10-09
*/
@RestController
@Slf4j
public class BomTreeController {

    private Logger logger = LoggerFactory.getLogger(BomTreeController.class);

    @Autowired
    private BomTreeService bomTreeService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @GetMapping("/base/bomTree/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################bomTree/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        BomTree bomTree = bomTreeService.selectById(id);
        model.putResult(bomTree);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################bomTree/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        BomTree bomTree = (BomTree)HttpUtils.pageData2Entity(pd, new BomTree());
        bomTreeService.save(bomTree);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################bomTree/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        BomTree bomTree = (BomTree)HttpUtils.pageData2Entity(pd, new BomTree());
        bomTreeService.update(bomTree);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @GetMapping("/base/bomTree/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################bomTree/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        bomTreeService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################bomTree/deleteByIds 执行开始 ################# ");
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
            bomTreeService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################bomTree/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<BomTree> bomTreeList = bomTreeService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",bomTreeList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################bomTree/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<BomTree> bomTreeList = bomTreeService.dataList(pd);
        model.putResult(bomTreeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/listPageBomTrees")
    public ResultModel listPageBomTrees()  throws Exception {

        logger.info("################bomTree/listPageBomTrees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
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
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/listPageBomTrees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/exportExcelBomTrees")
    public void exportExcelBomTrees() throws Exception {
        logger.info("################bomTree/exportExcelBomTrees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("BomTree");
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
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/exportExcelBomTrees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-10-09
    */
    @PostMapping("/base/bomTree/importExcelBomTrees")
    public ResultModel importExcelBomTrees(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################bomTree/importExcelBomTrees 执行开始 ################# ");
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
        logger.info("################bomTree/importExcelBomTrees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/base/bomTree/getBomTree")
    public ResultModel getBomTree()  throws Exception {
        logger.info("################/bomTree/getBomTree 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<TreeEntity> treeList = bomTreeService.getBomTreeList(pd);
        TreeEntity treeObj = TreeUtil.switchTree(pd.getString("prodId"), treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/bomTree/getBomTree 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-09-20
     */
    @PostMapping("/base/bomTree/addBomTree")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addBomTree()  throws Exception {

        logger.info("################bomTree/addBomTree 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        BomTree bomTree = (BomTree)HttpUtils.pageData2Entity(pd, new BomTree());
        String id = Conv.createUuid();
        bomTree.setId(id);
        bomTree.setPathId(bomTree.getPathId()+"_"+id);
        bomTree.setLayer(bomTree.getLayer()+1);

        bomTreeService.save(bomTree);
        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/addBomTree 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-09-20
     */
    @PostMapping("/base/bomTree/updateBomTree")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateBomTree()  throws Exception {

        logger.info("################bomTree/updateBomTree 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
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


        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/updateBomTree 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }





    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-09-20
     */
    @PostMapping("/base/bomTree/deleteBomTree")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteBomTree()  throws Exception {
        logger.info("################bomTree/deleteBomTree 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
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

        Long endTime = System.currentTimeMillis();
        logger.info("################bomTree/deleteBomTree 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



