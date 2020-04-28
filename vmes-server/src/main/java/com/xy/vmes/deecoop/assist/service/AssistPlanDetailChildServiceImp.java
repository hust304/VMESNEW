package com.xy.vmes.deecoop.assist.service;


import com.xy.vmes.deecoop.assist.dao.AssistPlanDetailChildMapper;
import com.xy.vmes.entity.AssistPlanDetail;
import com.xy.vmes.entity.AssistPlanDetailChild;
import com.xy.vmes.service.AssistPlanDetailChildService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SystemToolService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_assist_plan_detail_child:外协订单明细原材料 实现类
* 创建人：刘威 自动创建
* 创建时间：2020-04-25
*/
@Service
@Transactional(readOnly = false)
public class AssistPlanDetailChildServiceImp implements AssistPlanDetailChildService {


    @Autowired
    private AssistPlanDetailChildMapper assistPlanDetailChildMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SystemToolService systemToolService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void save(AssistPlanDetailChild assistPlanDetailChild) throws Exception{
        assistPlanDetailChild.setId(Conv.createUuid());
        assistPlanDetailChild.setCdate(new Date());
        assistPlanDetailChild.setUdate(new Date());
        assistPlanDetailChildMapper.insert(assistPlanDetailChild);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void update(AssistPlanDetailChild assistPlanDetailChild) throws Exception{
        assistPlanDetailChild.setUdate(new Date());
        assistPlanDetailChildMapper.updateById(assistPlanDetailChild);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateAll(AssistPlanDetailChild assistPlanDetailChild) throws Exception{
        assistPlanDetailChild.setUdate(new Date());
        assistPlanDetailChildMapper.updateAllColumnById(assistPlanDetailChild);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    //@Cacheable(cacheNames = "assistPlanDetailChild", key = "''+#id")
    public AssistPlanDetailChild selectById(String id) throws Exception{
        return assistPlanDetailChildMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteById(String id) throws Exception{
        assistPlanDetailChildMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistPlanDetailChildMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetailChild> dataListPage(PageData pd,Pagination pg) throws Exception{
        return assistPlanDetailChildMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetailChild> dataList(PageData pd) throws Exception{
        return assistPlanDetailChildMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return assistPlanDetailChildMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return assistPlanDetailChildMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistPlanDetailChildMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<AssistPlanDetailChild> selectByColumnMap(Map columnMap) throws Exception{
    List<AssistPlanDetailChild> assistPlanDetailChildList =  assistPlanDetailChildMapper.selectByMap(columnMap);
        return assistPlanDetailChildList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return assistPlanDetailChildMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return assistPlanDetailChildMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistPlanDetailChildMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistPlanDetailChildMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistPlanDetailChildMapper.updateToDisableByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2020-04-25
    */
    @Override
    public void updateByDefined(PageData pd)throws Exception{
        assistPlanDetailChildMapper.updateByDefined(pd);
    }
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<AssistPlanDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistPlanDetailChild>();
        }

        return this.dataList(pageData);
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistPlanDetailChilds(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("AssistPlanDetailChild");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @throws Exception
    */
    public void exportExcelAssistPlanDetailChilds(PageData pd) throws Exception{

        List<Column> columnList = columnService.findColumnList("AssistPlanDetailChild");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }
        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        //根据查询条件获取业务数据List
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);
        List<Map> dataList = this.getDataListPage(pd, null);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelAssistPlanDetailChild";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }


    /**
    * 导入
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel importExcelAssistPlanDetailChilds(MultipartFile file) throws Exception{
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
    public void insertAssistPlanDetailChild(AssistPlanDetail assistPlanDetail) throws Exception {
        PageData pd = new PageData();
        pd.put("assistProductId",assistPlanDetail.getAssistProductId());
        pd.put("count",assistPlanDetail.getCount());
        pd.put("planDtlId",assistPlanDetail.getId());
        pd.put("cuser",assistPlanDetail.getCuser());
        pd.put("uuser",assistPlanDetail.getCuser());
        assistPlanDetailChildMapper.insertAssistPlanDetailChild(pd);
    }
}



