package com.xy.vmes.service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 仓库货品(价格)Excel导入-文成企业定制
 * 导入前置条件: 财务-库存查询-导出(按钮) 导出的Excel文件，对单价列修改
 * 注意: 财务-库存查询-导出(按钮) 导出的Excel文件,第一列(id)是隐藏列
 *
 */
public interface WarehouseProductExcelByWcService {
    /**
     * 导入字段非空判断-(id)列非空判断
     * 第一列(id)为空:被视为非法行
     * 导入前置条件: 财务-库存查询-导出(按钮) 导出的Excel文件
     *
     * @param objectList
     * @return
     */
    String checkColumnByIdImportExcel(List<LinkedHashMap<String, String>> objectList);

    /**
     * 导入字段非空判断-(单价)数字判断
     * @param objectList
     * @param index
     * @param maxShowRow
     * @return
     */
    String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  Integer index,
                                  Integer maxShowRow);

    /**
     * 获取导入有效数据
     * 过滤出:
     * @param objectList
     */
}
