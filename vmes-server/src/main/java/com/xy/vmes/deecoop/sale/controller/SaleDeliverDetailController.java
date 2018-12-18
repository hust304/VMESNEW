package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleDeliverDetailService;
import com.xy.vmes.service.SaleDeliverService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
* 说明：vmes_sale_deliver_detail:发货明细Controller
* @author 陈刚 自动生成
* @date 2018-12-15
*/
@RestController
@Slf4j
public class SaleDeliverDetailController {

    private Logger logger = LoggerFactory.getLogger(SaleDeliverDetailController.class);

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailService saleDeliverDetailService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliverDetail/listPageSaleDeliverDetail")
    public ResultModel listPageSaleDeliverDetail()  throws Exception {
        logger.info("################saleDeliverDetail/listPageSaleDeliverDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleDeliverDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
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

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleDeliverDetailService.getDataListPage(pd,pg);
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
        logger.info("################saleDeliverDetail/listPageSaleDeliverDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改发货单(发货明细)
     * 后计价修改货品单价
     *
     * @author 陈刚
     * @date 2018-12-17
     * @throws Exception
     */
    @PostMapping("/saleDeliverDetail/updateSaleDeliverDetailByPrice")
    @Transactional
    public ResultModel updateSaleDeliverDetailByPrice() throws Exception {
        logger.info("################saleDeliverDetail/updateSaleDeliverDetailByPrice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条发货明细数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 修改发货单明细价格
        List<SaleDeliverDetail> deliverDtlList = saleDeliverDetailService.mapList2DetailList(mapList, null);
        for (SaleDeliverDetail deliverDtl : deliverDtlList) {
            //count 发货数量
            BigDecimal count = BigDecimal.valueOf(0D);
            if (deliverDtl.getCount() != null) {
                count = deliverDtl.getCount();
            }
            //productPrice 货品单价
            BigDecimal productPrice = BigDecimal.valueOf(0D);
            if (deliverDtl.getProductPrice() != null) {
                productPrice = deliverDtl.getProductPrice();
            }

            //sum 发货金额
            BigDecimal sum = BigDecimal.valueOf(count.doubleValue() * productPrice.doubleValue());
            //四舍五入到2位小数
            sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            deliverDtl.setSum(sum);

            saleDeliverDetailService.update(deliverDtl);
        }

        //2. 修改发货单价格
        BigDecimal totalSum = saleDeliverDetailService.findTotalSumByDetailList(deliverDtlList);
        SaleDeliver saleDeliver = new SaleDeliver();
        saleDeliver.setId(deliverId);
        saleDeliver.setTotalSum(totalSum);
        saleDeliverService.update(saleDeliver);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliverDetail/updateSaleDeliverDetailByPrice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliverDetail/exportExcelSaleDeliverDetails")
    public void exportExcelSaleDeliverDetails() throws Exception {
        logger.info("################saleDeliverDetail/exportExcelSaleDeliverDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("saleDeliverDetail");
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
        List<Map> dataList = saleDeliverDetailService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleDeliverDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleDeliverDetail/exportExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-12-15
    */
    @PostMapping("/saleDeliverDetail/importExcelSaleDeliverDetails")
    public ResultModel importExcelSaleDeliverDetails(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################saleDeliverDetail/importExcelSaleDeliverDetails 执行开始 ################# ");
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
        logger.info("################saleDeliverDetail/importExcelSaleDeliverDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



