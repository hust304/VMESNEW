package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleReceiveRecordMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Customer;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.CustomerService;
import com.xy.vmes.service.SaleReceiveRecordService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.xy.vmes.exception.ApplicationException;
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
* 说明：收款记录 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-25
*/
@Service
@Transactional(readOnly = false)
public class SaleReceiveRecordServiceImp implements SaleReceiveRecordService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SaleReceiveRecordMapper saleReceiveRecordMapper;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void save(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setId(Conv.createUuid());
        saleReceiveRecord.setCdate(new Date());
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.insert(saleReceiveRecord);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void update(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.updateById(saleReceiveRecord);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void updateAll(SaleReceiveRecord saleReceiveRecord) throws Exception{
        saleReceiveRecord.setUdate(new Date());
        saleReceiveRecordMapper.updateAllColumnById(saleReceiveRecord);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    //@Cacheable(cacheNames = "saleReceiveRecord", key = "''+#id")
    public SaleReceiveRecord selectById(String id) throws Exception{
        return saleReceiveRecordMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleReceiveRecordMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleReceiveRecordMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveRecordMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> dataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleReceiveRecordMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleReceiveRecordMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<SaleReceiveRecord> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleReceiveRecord> saleReceiveRecordList =  saleReceiveRecordMapper.selectByMap(columnMap);
        return saleReceiveRecordList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleReceiveRecordMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleReceiveRecordMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleReceiveRecordMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-25
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleReceiveRecordMapper.updateToDisableByIds(ids);
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
    public List<SaleReceiveRecord> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleReceiveRecord>();
        }

        return this.dataList(pageData);
    }

    /**
     * 修改客户余额
     * 1. 修改客户表(vmes_customer)
     * 2. 添加历史表(vmes_sale_receive_record)
     *
     * @param customerId  客户id
     * @param customer    客户对象
     * @param type        操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
     * @param editBalance 修改客户余额 (订单取消，订单删除 该参数为负数)
     * @param user        操作用户id
     * @param remark
     */
    public void editCustomerBalanceByOrder(
            String customerId,
            Customer customer,
            String type,
            BigDecimal editBalance,
            String user,
            String remark) throws TableVersionException, ApplicationException {
        if (customerId == null || customerId.trim().length() == 0) {return;}
        if (editBalance == null || editBalance.doubleValue() == 0) {return;}
        if (customer == null) {customer = customerService.findCustomerById(customerId);}
        if (customer == null) {return;}

        //1. 修改客户表(vmes_customer)
        //变更前
        BigDecimal before_balance = BigDecimal.valueOf(0D);
        if (customer.getBalance() != null) {
            before_balance = customer.getBalance();
        }

        //变更后
        double new_balance = before_balance.doubleValue() + editBalance.doubleValue();
        BigDecimal new_balanceBig = BigDecimal.valueOf(new_balance);
        //四舍五入到2位小数
        new_balanceBig = new_balanceBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        try {
            PageData pd = new PageData();
            pd.put("id",customer.getId());
            pd.put("version",customer.getVersion());
            pd.put("uuser",user);
            pd.put("balance",new_balanceBig);
            customerService.updateCustomerBalance(pd);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TableVersionException(Common.SYS_STOCKCOUNT_ERRORCODE, "当前系统繁忙，请稍后操作！");
        }

        //2. 添加历史表(vmes_sale_receive_record)
        SaleReceiveRecord saleReceiveRecord = new SaleReceiveRecord();
        saleReceiveRecord.setBeforeAmount(before_balance);
        saleReceiveRecord.setAfterAmount(new_balanceBig);
        saleReceiveRecord.setAmount(editBalance);
        saleReceiveRecord.setCustomerId(customerId);
        //操作类型 (0:变更 1:录入收款 2:预付款 3:退货退款 4:订单变更退款 -1:费用分摊)
        saleReceiveRecord.setType(type);
        saleReceiveRecord.setRemark(remark);
        saleReceiveRecord.setUuser(user);
        saleReceiveRecord.setCuser(user);

        try {
            this.save(saleReceiveRecord);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public ResultModel listPageSaleReceiveRecords(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("SaleReceiveRecord");
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
    public void exportExcelSaleReceiveRecords(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("SaleReceiveRecord");
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
            fileName = "ExcelSaleReceiveRecord";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelSaleReceiveRecords(MultipartFile file) throws Exception {
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



