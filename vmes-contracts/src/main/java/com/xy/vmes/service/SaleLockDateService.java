package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleLockDate;
import com.xy.vmes.exception.ApplicationException;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：设置锁库时间 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-12-12
*/
public interface SaleLockDateService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void save(SaleLockDate saleLockDate) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void update(SaleLockDate saleLockDate) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void updateAll(SaleLockDate saleLockDate) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void deleteById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    SaleLockDate selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<SaleLockDate> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<SaleLockDate> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<SaleLockDate> selectByColumnMap(Map columnMap) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-12-12
    */
    void updateToDisableByIds(String[] ids)throws Exception;

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
    List<SaleLockDate> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    SaleLockDate findSaleLockDate(PageData object) throws Exception;
    SaleLockDate findSaleLockDateById(String id) throws Exception;
    SaleLockDate findSaleLockDateByCompanyId(String companyId) throws Exception;

    List<SaleLockDate> findSaleLockDateList(PageData object) throws Exception;

    //////////////////////////////////////////////////////////////////////////
    Long findLockDateMillisecondByCompanyId(String companyId) throws ApplicationException;

    ResultModel updateSaleLockDate(PageData pd) throws Exception;
    ResultModel saveSaleLockDate(PageData pd) throws Exception;
    ResultModel selectSaleLockDateByCompanyId(PageData pd) throws Exception;
    ResultModel listPageSaleLockDates(PageData pd, Pagination pg) throws Exception;

    void exportExcelSaleLockDates(PageData pd, Pagination pg) throws Exception;
    ResultModel importExcelSaleLockDates(MultipartFile file) throws Exception;

}



