package com.xy.vmes.deecoop.base.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.CustomeAddress;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.CustomeAddressService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：vmes_customer_addressController
* @author 陈刚 自动生成
* @date 2018-09-20
*/
@RestController
@Slf4j
public class CustomeAddressController {

    private Logger logger = LoggerFactory.getLogger(CustomeAddressController.class);

    @Autowired
    private CustomeAddressService customeAddressService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @GetMapping("/customeAddress/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################customeAddress/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        CustomeAddress customeAddress = customeAddressService.selectById(id);
        model.putResult(customeAddress);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/save")
    public ResultModel save()  throws Exception {

        logger.info("################customeAddress/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        CustomeAddress customeAddress = (CustomeAddress)HttpUtils.pageData2Entity(pd, new CustomeAddress());
        customeAddressService.save(customeAddress);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/update")
    public ResultModel update()  throws Exception {

        logger.info("################customeAddress/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        CustomeAddress customeAddress = (CustomeAddress)HttpUtils.pageData2Entity(pd, new CustomeAddress());
        customeAddressService.update(customeAddress);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @GetMapping("/customeAddress/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################customeAddress/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        customeAddressService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/deleteByIds")
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################customeAddress/deleteById 执行开始 ################# ");
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
            customeAddressService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################customeAddress/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<CustomeAddress> customeAddressList = customeAddressService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",customeAddressList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################customeAddress/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<CustomeAddress> customeAddressList = customeAddressService.dataList(pd);
        model.putResult(customeAddressList);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/listPageCustomeAddress")
    public ResultModel listPageCustomeAddress() throws Exception {
        logger.info("################customeAddress/listPageCustomeAddress 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("customeAddress");
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
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = customeAddressService.getDataListPage(pd,pg);
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
        logger.info("################customeAddress/listPageCustomeAddress 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增客户供应商地址
     *
     * @author 陈刚
     * @date 2018-09-20
     */
    @PostMapping("/customeAddress/addCustomerAddress")
    public ResultModel addCustomerAddress() throws Exception {
        logger.info("################/customeAddress/addCustomerAddress 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("客户id为空或空字符串！");
            return model;
        }

        CustomeAddress custAddr = (CustomeAddress)HttpUtils.pageData2Entity(pageData, new CustomeAddress());
        //是否默认(0:非默认 1:默认)
        custAddr.setIsdefault("0");

        String msgStr = customeAddressService.checkColumnByAddEdit(custAddr);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 根据客户id查询(vmes_customer_address)
        //是否默认(0:非默认 1:默认)
        PageData findMap = new PageData();
        findMap.put("customerId", customerId);
        findMap.put("isdefault", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<CustomeAddress> objectList = customeAddressService.findCustomeAddressList(findMap);
        if (objectList == null || objectList.size() == 0) {
            custAddr.setIsdefault("1");
        }

        customeAddressService.save(custAddr);

        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/addCustomerAddress 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改客户供应商地址
     *
     * @author 陈刚
     * @date 2018-09-20
     */
    @PostMapping("/customeAddress/updateCustomerAddress")
    public ResultModel updateCustomerAddress() throws Exception {
        logger.info("################/customeAddress/updateCustomerAddress 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        CustomeAddress custAddrDB = (CustomeAddress)HttpUtils.pageData2Entity(pageData, new CustomeAddress());
        String msgStr = customeAddressService.checkColumnByAddEdit(custAddrDB);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        customeAddressService.update(custAddrDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/updateCustomerAddress 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改默认客户供应商地址
     *
     * @author 陈刚
     * @date 2018-09-20
     */
    @PostMapping("/customeAddress/updateDefaultCustomerAddress")
    public ResultModel updateDefaultCustomerAddress() throws Exception {
        logger.info("################/customeAddress/updateDefaultCustomerAddress 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("客户id为空或空字符串！");
            return model;
        }
        String addrId = pageData.getString("addrId");
        if (addrId == null || addrId.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("地址id为空或空字符串！");
            return model;
        }

        //2. 客户id-修改客户地址表字段(vmes_customer_address.isdefault) 全部为(0:非默认)
        PageData mapObject = new PageData();
        mapObject.put("customerId", customerId);
        //是否默认(0:非默认 1:默认)
        mapObject.put("isdefault", "0");
        customeAddressService.updateDefaultByCustId(mapObject);

        CustomeAddress custAddrDB = customeAddressService.findCustomeAddressById(addrId);
        //是否默认(0:非默认 1:默认)
        custAddrDB.setIsdefault("1");
        customeAddressService.update(custAddrDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/updateDefaultCustomerAddress 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除客户供应商地址
     * 1. 支持批量删除
     *
     * @author 陈刚
     * @date 2018-09-20
     */
    @PostMapping("/customeAddress/deleteCustomerAddress")
    public ResultModel deleteCustomerAddress() throws Exception {
        logger.info("################/customeAddress/deleteCustomerAddress 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        String ids = pageData.getString("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");
            return model;
        }

        ids = StringUtil.stringTrimSpace(ids);
        customeAddressService.deleteByIds(ids.split(","));

        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/deleteCustomerAddress 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/exportExcelCustomeAddresss")
    public void exportExcelCustomeAddresss() throws Exception {
        logger.info("################customeAddress/exportExcelCustomeAddresss 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("customeAddress");
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
        List<Map> dataList = customeAddressService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelCustomeAddress";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################customeAddress/exportExcelCustomeAddresss 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-09-20
    */
    @PostMapping("/customeAddress/importExcelCustomeAddresss")
    public ResultModel importExcelCustomeAddresss(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################customeAddress/importExcelCustomeAddresss 执行开始 ################# ");
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
        logger.info("################customeAddress/importExcelCustomeAddresss 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



