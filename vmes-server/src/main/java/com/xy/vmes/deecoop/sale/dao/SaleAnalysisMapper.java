package com.xy.vmes.deecoop.sale.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2020/4/8.
 */
@Mapper
@Repository
public interface SaleAnalysisMapper {


    List<Map> getSalesOrderNumber(PageData pd);

    List<Map> getSalesVolumeNumber(PageData pd);

    List<Map> getSalesTrend(PageData pd);

    List<Map> getSalesVolumeNumberByProduct(PageData pd);

    List<Map> getProductReturnRate(PageData pd);

    List<Map> getSalesVolumeNumberByCustomer(PageData pd);

    List<Map> getSalesVolumeNumberByEmployee(PageData pd);

    List<Map> getSalesByEmployee(PageData pd);

    List<Map> getSalesTrendByEmployee(PageData pd);

    List<Map> getSalesTrendQueryByDMY(PageData pd);

    List<Map> getSalesProductQueryByDMY(PageData pd);

    List<Map> getSalesCustomerQueryByDMY(PageData pd);

    List<Map> getSalesEmployeeQueryByDMY(PageData pd);
}
