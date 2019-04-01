package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleLockDateMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleLockDate;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleLockDateService;
import com.xy.vmes.service.SaleOrderDetailByLockCountService;
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
* 说明：设置锁库时间 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-12-12
*/
@Service
@Transactional(readOnly = false)
public class SaleLockDateServiceImp implements SaleLockDateService {

    @Autowired
    private SaleLockDateMapper saleLockDateMapper;
    @Autowired
    private SaleOrderDetailByLockCountService saleOrderDetailByLockCountService;

    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void save(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setId(Conv.createUuid());
        saleLockDate.setCdate(new Date());
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.insert(saleLockDate);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void update(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.updateById(saleLockDate);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void updateAll(SaleLockDate saleLockDate) throws Exception{
        saleLockDate.setUdate(new Date());
        saleLockDateMapper.updateAllColumnById(saleLockDate);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    //@Cacheable(cacheNames = "saleLockDate", key = "''+#id")
    public SaleLockDate selectById(String id) throws Exception{
        return saleLockDateMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteById(String id) throws Exception{
        saleLockDateMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleLockDateMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> dataListPage(PageData pd,Pagination pg) throws Exception{
        return saleLockDateMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> dataList(PageData pd) throws Exception{
        return saleLockDateMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return saleLockDateMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return saleLockDateMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleLockDateMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<SaleLockDate> selectByColumnMap(Map columnMap) throws Exception{
    List<SaleLockDate> saleLockDateList =  saleLockDateMapper.selectByMap(columnMap);
        return saleLockDateList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return saleLockDateMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return saleLockDateMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleLockDateMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleLockDateMapper.updateToDisableByIds(ids);
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
    public List<SaleLockDate> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleLockDate>();
        }

        return this.dataList(pageData);
    }

    public SaleLockDate findSaleLockDate(PageData object) throws Exception {
        List<SaleLockDate> objectList = this.findSaleLockDateList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleLockDate findSaleLockDateById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleLockDate(findMap);
    }

    public SaleLockDate findSaleLockDateByCompanyId(String companyId) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);

        return this.findSaleLockDate(findMap);
    }

    public List<SaleLockDate> findSaleLockDateList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    //////////////////////////////////////////////////////////////////////////

    /**
     * 根据企业id查询(vmes_sale_lock_date)获取该企业锁库时长(毫秒)
     * @param companyId  企业id
     * @return
     * @throws ApplicationException
     */
    public Long findLockDateMillisecondByCompanyId(String companyId) throws ApplicationException {
        if (companyId == null || companyId.trim().length() == 0) {
            throw new ApplicationException("企业id为空或空字符串");
        }

        SaleLockDate object = null;
        try {
            object = this.findSaleLockDateByCompanyId(companyId);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
        if (object == null) {return Long.valueOf(0L);}

        //锁库时长(毫秒)
        long lockTimeMillisecond = 0L;

        //天
        long day = 0L;
        if (object.getDay() != null) {
            day = object.getDay().longValue();
        }
        lockTimeMillisecond = lockTimeMillisecond + (day * 24 * 60 * 60 * 1000);

        //时
        long hour = 0L;
        if (object.getHour() != null) {
            hour = object.getHour().longValue();
        }
        lockTimeMillisecond = lockTimeMillisecond + (hour * 60 * 60 * 1000);

        //分
        long minute = 0L;
        if (object.getMinute() != null) {
            minute = object.getMinute().longValue();
        }
        lockTimeMillisecond = lockTimeMillisecond + (minute * 60 * 1000);

//        //秒
//        long second = 0L;
//        if (object.getSecond() != null) {
//            second = object.getSecond().longValue();
//        }
//        lockTimeMillisecond = lockTimeMillisecond + (second * 1000);

        return Long.valueOf(lockTimeMillisecond);
    }

    public ResultModel updateSaleLockDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());
        int day = saleLockDate.getDay()==null?0:saleLockDate.getDay();
        int hour = saleLockDate.getHour()==null?0:saleLockDate.getHour();
        int minute = saleLockDate.getMinute()==null?0:saleLockDate.getMinute();
        saleLockDate.setSecond(day*24*60*60+hour*60*60+minute*60);
        this.update(saleLockDate);

        //重新设定信息队列信息:(订单明细id,锁定库存版本号)
        String companyId = pd.getString("currentCompanyId");
        //1. 根据(企业id)获取订单明细表(vmes_sale_order_detail)
        //2. 字段 version_lock_count 加一
        saleOrderDetailByLockCountService.updateVersionLockCount(companyId);

        return model;
    }

    public ResultModel saveSaleLockDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        SaleLockDate saleLockDate = (SaleLockDate)HttpUtils.pageData2Entity(pd, new SaleLockDate());

        pd.putQueryStr(" company_id = '"+saleLockDate.getCompanyId()+"'");
        List<SaleLockDate> saleLockDateList = this.dataList(pd);
        if(saleLockDateList!=null&&saleLockDateList.size()>0){
            for(int i=0;i<saleLockDateList.size();i++){
                SaleLockDate deleteObj = saleLockDateList.get(i);
                this.deleteById(deleteObj.getId());
            }
        }
        int day = saleLockDate.getDay()==null?0:saleLockDate.getDay();
        int hour = saleLockDate.getHour()==null?0:saleLockDate.getHour();
        int minute = saleLockDate.getMinute()==null?0:saleLockDate.getMinute();
        saleLockDate.setSecond(day*24*60*60+hour*60*60+minute*60);
        this.save(saleLockDate);




        return model;
    }

    public ResultModel selectSaleLockDateByCompanyId(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<SaleLockDate> saleLockDateList = this.dataList(pd);
        SaleLockDate saleLockDate = null;
        if(saleLockDateList!=null&&saleLockDateList.size()>0){
            saleLockDate = saleLockDateList.get(0);
        }
        model.putResult(saleLockDate);

        return model;
    }

    public ResultModel listPageSaleLockDates(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("SaleLockDate");
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

    public void exportExcelSaleLockDates(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("SaleLockDate");
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
            fileName = "ExcelSaleLockDate";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    public ResultModel importExcelSaleLockDates(MultipartFile file) throws Exception {
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



