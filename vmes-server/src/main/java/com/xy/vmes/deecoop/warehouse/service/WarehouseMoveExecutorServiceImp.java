package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveExecutorMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseMoveDetail;
import com.xy.vmes.entity.WarehouseMoveExecute;
import com.xy.vmes.entity.WarehouseMoveExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseMoveDetailService;
import com.xy.vmes.service.WarehouseMoveExecuteService;
import com.xy.vmes.service.WarehouseMoveExecutorService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：移库单执行人 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveExecutorServiceImp implements WarehouseMoveExecutorService {


    @Autowired
    private WarehouseMoveExecutorMapper warehouseMoveExecutorMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;
    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMoveExecutor warehouseMoveExecutor) throws Exception{
        warehouseMoveExecutor.setId(Conv.createUuid());
        warehouseMoveExecutor.setCdate(new Date());
        warehouseMoveExecutor.setUdate(new Date());
        warehouseMoveExecutorMapper.insert(warehouseMoveExecutor);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMoveExecutor warehouseMoveExecutor) throws Exception{
        warehouseMoveExecutor.setUdate(new Date());
        warehouseMoveExecutorMapper.updateById(warehouseMoveExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMoveExecutor warehouseMoveExecutor) throws Exception{
        warehouseMoveExecutor.setUdate(new Date());
        warehouseMoveExecutorMapper.updateAllColumnById(warehouseMoveExecutor);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMoveExecutor", key = "''+#id")
    public WarehouseMoveExecutor selectById(String id) throws Exception{
        return warehouseMoveExecutorMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveExecutorMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveExecutorMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecutor> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecutorMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecutor> dataList(PageData pd) throws Exception{
        return warehouseMoveExecutorMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveExecutorMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveExecutorMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveExecutorMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecutor> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMoveExecutor> warehouseMoveExecutorList =  warehouseMoveExecutorMapper.selectByMap(columnMap);
        return warehouseMoveExecutorList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveExecutorMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveExecutorMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecutorMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveExecutorMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Override
    public ResultModel updateExecutor(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String detailId = pd.getString("detailId");
        String executorIds = pd.getString("executorIds");
        pd.put("queryStr","detail_id ='"+detailId+"' and isdisable = '1' ");
        pd.put("mapSize", Integer.valueOf(pd.size()));
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataList(pd);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            model.putCode("1");
            model.putMsg("该移库单执行人已开始执行，不能直接更换执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }

        if(!StringUtils.isEmpty(executorIds)){
            String[] executorIdArr = executorIds.split(",");
            if(executorIdArr!=null&&executorIdArr.length>0){
                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                List<WarehouseMoveExecutor> warehouseMoveExecutorList = this.selectByColumnMap(columnMap);
                if(warehouseMoveExecutorList!=null&&warehouseMoveExecutorList.size()>0){
                    for(int i=0;i<warehouseMoveExecutorList.size();i++){
                        WarehouseMoveExecutor warehouseMoveExecutor = warehouseMoveExecutorList.get(i);
                        warehouseMoveExecutor.setIsdisable("0");
                        warehouseMoveExecutor.setRemark("执行人变更");
                        this.update(warehouseMoveExecutor);
                    }
                }

                for(int i=0;i<executorIdArr.length;i++){
                    WarehouseMoveExecutor warehouseMoveExecutor = new WarehouseMoveExecutor();
                    warehouseMoveExecutor.setDetailId(detailId);
                    warehouseMoveExecutor.setExecutorId(executorIdArr[i]);
                    this.save(warehouseMoveExecutor);
                }
            }

            WarehouseMoveDetail warehouseMoveDetail = warehouseMoveDetailService.selectById(detailId);
            warehouseMoveDetail.setState("1");
            warehouseMoveDetailService.update(warehouseMoveDetail);
        }else {
            model.putCode("2");
            model.putMsg("未勾选记录，请重新选择！");
            return model;
        }
        return model;
    }

    @Override
    public ResultModel listPageWarehouseMoveExecutors(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveExecutor");
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
    public void exportExcelWarehouseMoveExecutors(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("WarehouseMoveExecutor");
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
            fileName = "ExcelWarehouseMoveExecutor";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelWarehouseMoveExecutors(MultipartFile file) throws Exception {
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



