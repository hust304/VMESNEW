package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleInvoiceDetailMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleInvoice;
import com.xy.vmes.entity.SaleInvoiceDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleInvoiceDetailService;
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
* 说明：vmes_sale_invoice_detail:发票明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-01-08
*/
@Service
@Transactional(readOnly = false)
public class SaleInvoiceDetailServiceImp implements SaleInvoiceDetailService {

    @Autowired
    private SaleInvoiceDetailMapper saleInvoiceDetailMapper;
    @Autowired
    private SaleInvoiceDetailService saleInvoiceDetailService;

    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    @Override
    public void save(SaleInvoiceDetail saleInvoiceDetail) throws Exception{
        saleInvoiceDetail.setId(Conv.createUuid());
        saleInvoiceDetail.setCdate(new Date());
        saleInvoiceDetail.setUdate(new Date());
        saleInvoiceDetailMapper.insert(saleInvoiceDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public SaleInvoiceDetail selectById(String id) throws Exception{
        return saleInvoiceDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoiceDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleInvoiceDetail> warehouseCheckDetailList =  saleInvoiceDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void update(SaleInvoiceDetail object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateAll(SaleInvoiceDetail object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleInvoiceDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleInvoiceDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleInvoiceDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleInvoiceDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoiceDetail> dataList(PageData pd) throws Exception{
        return saleInvoiceDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleInvoiceDetailMapper.getDataListPage(pd,pg);
    }
    public List<Map> getDataListPage(PageData pd) throws Exception {
        return saleInvoiceDetailMapper.getDataListPage(pd);
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
    public List<SaleInvoiceDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleInvoiceDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleInvoiceDetail findSaleInvoiceDetail(PageData object) throws Exception {
        List<SaleInvoiceDetail> objectList = this.findSaleInvoiceDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleInvoiceDetail findSaleInvoiceDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleInvoiceDetail(findMap);
    }

    public List<SaleInvoiceDetail> findSaleInvoiceDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleInvoiceDetail> findSaleInvoiceDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleInvoiceDetailList(findMap);
    }

    public BigDecimal findTotalSumBySum(List<SaleInvoiceDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        double totalSum_double = 0D;
        for (SaleInvoiceDetail detail : objectList) {

            double sum_double = 0D;
            if (detail.getSum() != null) {
                sum_double = detail.getSum().doubleValue();
            }

            totalSum_double = totalSum_double + sum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        saleInvoiceDetailMapper.updateStateByDetail(pageData);
    }


    public void addInvoiceDetail(SaleInvoice parentObj, List<SaleInvoiceDetail> detailList) throws Exception {
        if (parentObj == null) {return;}
        if (detailList == null || detailList.size() == 0) {return;}

        for (SaleInvoiceDetail detail : detailList) {
            //state:状态(0:待开票 1:已开票 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            this.save(detail);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ResultModel listPageSaleInvoiceDetail(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleInvoiceDetail");
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
        List<Map> varList = saleInvoiceDetailService.getDataListPage(pd,pg);
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

    public void exportExcelSaleInvoiceDetails(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("saleInvoiceDetail");
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
        List<Map> dataList = saleInvoiceDetailService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleInvoiceDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);

    }
    public ResultModel importExcelSaleInvoiceDetails(MultipartFile file) throws Exception {
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



