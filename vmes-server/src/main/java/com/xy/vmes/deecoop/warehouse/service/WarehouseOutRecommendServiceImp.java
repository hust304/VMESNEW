package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutRecommendMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOutRecommend;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutRecommendService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：出库推荐 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-07
*/
@Service
@Transactional(readOnly = false)
public class WarehouseOutRecommendServiceImp implements WarehouseOutRecommendService {


    @Autowired
    private WarehouseOutRecommendMapper warehouseOutRecommendMapper;

    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void save(WarehouseOutRecommend warehouseOutRecommend) throws Exception{
        warehouseOutRecommend.setId(Conv.createUuid());
        warehouseOutRecommend.setCdate(new Date());
        warehouseOutRecommend.setUdate(new Date());
        warehouseOutRecommendMapper.insert(warehouseOutRecommend);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void update(WarehouseOutRecommend warehouseOutRecommend) throws Exception{
        warehouseOutRecommend.setUdate(new Date());
        warehouseOutRecommendMapper.updateById(warehouseOutRecommend);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void updateAll(WarehouseOutRecommend warehouseOutRecommend) throws Exception{
        warehouseOutRecommend.setUdate(new Date());
        warehouseOutRecommendMapper.updateAllColumnById(warehouseOutRecommend);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    //@Cacheable(cacheNames = "warehouseOutRecommend", key = "''+#id")
    public WarehouseOutRecommend selectById(String id) throws Exception{
        return warehouseOutRecommendMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseOutRecommendMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseOutRecommendMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<WarehouseOutRecommend> dataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutRecommendMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<WarehouseOutRecommend> dataList(PageData pd) throws Exception{
        return warehouseOutRecommendMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseOutRecommendMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseOutRecommendMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseOutRecommendMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<WarehouseOutRecommend> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseOutRecommend> warehouseOutRecommendList =  warehouseOutRecommendMapper.selectByMap(columnMap);
        return warehouseOutRecommendList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseOutRecommendMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseOutRecommendMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseOutRecommendMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-07
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseOutRecommendMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<Map<String, String>> findWarehouseOutMapList(String companyId, String productId, String code) {
        List<Map<String, String>> outList = new ArrayList<Map<String, String>>();

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("productId", productId);
        findMap.put("code", code);

        List<Map<String, Object>> mapList = null;
        try {
            mapList = warehouseOutRecommendMapper.findWarehouseOutMapList(findMap);
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {return outList;}

        for (Map<String, Object> mapObject : mapList) {
            Map<String, String> mapObj = new HashMap<String, String>();

            //出库单明细id detailId
            mapObj.put("detailId", (String)mapObject.get("detailId"));

            //出库单id parentId
            String parentId = new String();
            if (mapObject.get("parentId") != null) {
                parentId = mapObject.get("parentId").toString().trim();
            }
            mapObj.put("parentId", parentId);


            //出库单编号 parentCode
            String parentCode = new String();
            if (mapObject.get("parentCode") != null) {
                parentCode = mapObject.get("parentCode").toString().trim();
            }
            mapObj.put("parentCode", parentCode);

            //出库数量 detailCount
            String detailCount = new String("0");
            BigDecimal detailCount_big = BigDecimal.valueOf(0D);
            if (mapObject.get("detailCount") != null) {
                String detailCount_str = mapObject.get("detailCount").toString().trim();
                try {
                    detailCount_big = new BigDecimal(detailCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (detailCount_big.doubleValue() != 0) {
                    //四舍五入到2位小数
                    detailCount_big = detailCount_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    detailCount = detailCount_big.toString();
                }
            }
            mapObj.put("detailCount", detailCount);
            mapObj.put("type", "out");

            outList.add(mapObj);
        }

        return outList;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel listPageWarehouseOutRecommends(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutRecommend");
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
        List<Map> varList = this.getDataListPage(pd,pg);
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
    public void exportExcelWarehouseOutRecommends(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        List<Column> columnList = columnService.findColumnList("WarehouseOutRecommend");
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
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseOutRecommend";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseOutRecommends(MultipartFile file) throws Exception {
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
        return model;
    }
}



