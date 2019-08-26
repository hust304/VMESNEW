package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveDetailMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleReceive;
import com.xy.vmes.entity.SaleReceiveDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleReceiveDetailService;
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
* 说明：收款明细 实现类
* 创建人：刘威 自动创建
* 创建时间：2019-01-10
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveDetailServiceImp implements SaleReceiveDetailService {


    @Autowired
    private SaleReceiveDetailMapper saleReceiveDetailMapper;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void save(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setId(Conv.createUuid());
        saleReceiveDetail.setCdate(new Date());
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.insert(saleReceiveDetail);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void update(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.updateById(saleReceiveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateAll(SaleReceiveDetail saleReceiveDetail) throws Exception{
        saleReceiveDetail.setUdate(new Date());
        saleReceiveDetailMapper.updateAllColumnById(saleReceiveDetail);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    //@Cacheable(cacheNames = "saleReceiveDetail", key = "''+#id")
    public SaleReceiveDetail selectById(String id) throws Exception{
        return saleReceiveDetailMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveDetailMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveDetailMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> dataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveDetailMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveDetailMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<SaleReceiveDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceiveDetail> saleReceiveDetailList =  saleReceiveDetailMapper.selectByMap(columnMap);
        return saleReceiveDetailList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveDetailMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveDetailMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveDetailMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2019-01-10
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveDetailMapper.updateToDisableByIds(ids);
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
    public List<SaleReceiveDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceiveDetail>();
        }

        return this.dataList(pageData);
    }

    public List<SaleReceiveDetail> findSaleReceiveDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<SaleReceiveDetail> findSaleReceiveDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleReceiveDetailList(findMap);
    }

    public List<Map<String, Object>> findReceiveDetailCollectByOrderId(PageData pageData) throws Exception {
        return saleReceiveDetailMapper.findReceiveDetailCollectByOrderId(pageData);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2019-01-10
     */
    @Override
    public List<Map> getOrderReceiveDetailDataListPage(PageData pd, Pagination pg) throws Exception{
        return saleReceiveDetailMapper.getOrderReceiveDetailDataListPage(pd,pg);
    }

    /**
     * 获取订单付款信息<订单id, 订单付款信息Map>
     *     订单付款信息Map
     *         receiveSum: 付款金额
     *
     * @param orderIds
     * @param state
     * @return
     * @throws Exception
     */
    public Map<String, Map<String, BigDecimal>> findMapOrderReceiveByOrderId(String orderIds, String state) throws Exception {
        if (orderIds == null || orderIds.trim().length() == 0) {return null;}
        Map<String, Map<String, BigDecimal>> orderReceiveMap = new HashMap<String, Map<String, BigDecimal>>();

        orderIds = StringUtil.stringTrimSpace(orderIds);
        orderIds = "'" + orderIds.replace(",", "','") + "'";

        PageData findMap = new PageData();
        findMap.put("orderIds", orderIds);
        findMap.put("state", state);
        List<Map<String, Object>> mapList = this.findReceiveDetailCollectByOrderId(findMap);
        if (mapList == null || mapList.size() == 0) {return orderReceiveMap;}

        for (Map<String, Object> objectMap : mapList) {
            String orderId = (String)objectMap.get("orderId");

            Map<String, BigDecimal> receiveMap = new HashMap<String, BigDecimal>();
            BigDecimal receiveSum = BigDecimal.valueOf(0D);
            if (objectMap.get("receiveSum") != null) {
                receiveSum = (BigDecimal)objectMap.get("receiveSum");
            }
            receiveMap.put("receiveSum", receiveSum);

            orderReceiveMap.put(orderId, receiveMap);
        }

        return orderReceiveMap;

    }

//    public BigDecimal findReceiveSumByOrderId(String orderId) {
//        if (orderId == null || orderId.trim().length() == 0) {return BigDecimal.valueOf(0D);}
//
//        PageData findMap = new PageData();
//        findMap.put("orderId", orderId);
//        //收款单状态(0:待收款 1:已收款 -1:已取消)
//        findMap.put("state", "1");
//        List<Map<String, Object>> mapList = null;
//        try {
//            mapList = this.findReceiveDetailCollectByOrderId(findMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (mapList == null || mapList.size() == 0) {return BigDecimal.valueOf(0D);}
//
//        double receiveSum = 0D;
//        for (Map<String, Object> objectMap : mapList) {
//            if (objectMap.get("receiveAmount") != null) {
//                BigDecimal receiveAmount = (BigDecimal)objectMap.get("receiveAmount");
//                receiveSum = receiveSum + receiveAmount.doubleValue();
//            }
//        }
//
//        //四舍五入到2位小数
//        return BigDecimal.valueOf(receiveSum).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ResultModel listPageOrderReceiveDetail(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("OrderReceiveDetail");
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

        //订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
//        pd.put("orderStateNotin", "'-1','4'");
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getOrderReceiveDetailDataListPage(pd,pg);
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
    public ResultModel listPageSaleReceiveDetails(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("SaleReceiveDetail");
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

    @Override
    public void exportExcelSaleReceiveDetails(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("SaleReceiveDetail");
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
            fileName = "ExcelSaleReceiveDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelSaleReceiveDetails(MultipartFile file) throws Exception {
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

    public void addReceiveDetail(SaleReceive parentObj, List<SaleReceiveDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (SaleReceiveDetail detail : objectList) {
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            this.save(detail);
        }
    }
}



