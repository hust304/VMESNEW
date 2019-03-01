package com.xy.vmes.deecoop.sale.service;


import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.deecoop.sale.dao.SaleRetreatDetailMapper;
import com.xy.vmes.entity.SaleRetreat;
import com.xy.vmes.entity.SaleRetreatDetail;
import com.xy.vmes.service.SaleRetreatDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_retreat_detail:退货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-02-25
*/
@Service
@Transactional(readOnly = false)
public class SaleRetreatDetailServiceImp implements SaleRetreatDetailService {

    @Autowired
    private SaleRetreatDetailMapper saleOrderReturnDetailMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void save(SaleRetreatDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleOrderReturnDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public SaleRetreatDetail selectById(String id) throws Exception{
        return saleOrderReturnDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public List<SaleRetreatDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleRetreatDetail> warehouseCheckDetailList =  saleOrderReturnDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void update(SaleRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderReturnDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateAll(SaleRetreatDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderReturnDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleOrderReturnDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleOrderReturnDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleOrderReturnDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleOrderReturnDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    public List<SaleRetreatDetail> dataList(PageData pd) throws Exception {
        return saleOrderReturnDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        return saleOrderReturnDetailMapper.getDataListPage(pd, pg);
    }

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
    public List<SaleRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleRetreatDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleRetreatDetail findSaleOrderReturnDetail(PageData object) throws Exception {
        List<SaleRetreatDetail> objectList = this.findSaleOrderReturnDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleRetreatDetail findSaleOrderReturnDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrderReturnDetail(findMap);
    }

    public List<SaleRetreatDetail> findSaleOrderReturnDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<SaleRetreatDetail> findSaleOrderReturnDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleOrderReturnDetailList(findMap);
    }

    public List<SaleRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleRetreatDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleRetreatDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleRetreatDetail detail = (SaleRetreatDetail) HttpUtils.pageData2Entity(mapObject, new SaleRetreatDetail());

            //orderCount 退货数量(订单单位)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            detail.setOrderCount(orderCount);

            //计价转换计量单位 数量转换公式 p2nFormula
            String p2nFormula = mapObject.get("p2nFormula");
            BigDecimal valueBig = BigDecimal.valueOf(0D);
            //P(计价单位) --> N(计量单位)
            if (p2nFormula != null && p2nFormula.trim().length() > 0) {
                valueBig = EvaluateUtil.countFormulaP2N(orderCount, p2nFormula);
            }
            //productCount 退货数量(计量数量)
            detail.setProductCount(valueBig);

            objectList.add(detail);
        }

        return objectList;
    }

    public BigDecimal findTotalSumByDetailList(List<SaleRetreatDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleRetreatDetail detail : objectList) {
            //orderSum 退货金额
            double orderSum_double = 0D;
            if (detail.getOrderSum() != null) {
                orderSum_double = detail.getOrderSum().doubleValue();
            }

            totalSum_double = totalSum_double + orderSum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void addSaleRetreatDetail(SaleRetreat parentObj, List<SaleRetreatDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (SaleRetreatDetail detail : objectList) {
            //退货明细状态 (0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }

    public void updateStateByDetail(PageData pd) throws Exception {
        saleOrderReturnDetailMapper.updateStateByDetail(pd);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleOrderReturnDetailMapper.updateStateByDetail(pageData);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleRetreatDetail(PageData pd,Pagination pg) throws Exception{

        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleRetreatDetail");
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

    /**
    * 导出
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @throws Exception
    */
    public void exportExcelSaleRetreatDetail(PageData pd,Pagination pg) throws Exception{

        List<Column> columnList = columnService.findColumnList("saleOrderReturnDetail");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
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
        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleOrderReturnDetail";
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
    public ResultModel importExcelSaleRetreatDetail(MultipartFile file) throws Exception{
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


}



