package com.xy.vmes.deecoop.timer.warehouseProduct;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Product;
import com.xy.vmes.service.ProductService;
import com.xy.vmes.service.WarehouseProductService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@EnableScheduling
public class WarehouseProductTimerTask {
    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private ProductService productService;

    /**
     * 创建设备保养单-定时任务
     * 每天凌晨1点执行        (0 0 1 * * ?)
     *
     * 1. 获取系统全部企业
     * 2. 查询设备保养计划(vmes_equipment_maintain_plan)
     *
     */
    //每天12点30分执行 (0 30 12 * * ?)
    //@Scheduled(cron = "0 30 12 * * ?") //测试代码-真实环境无此代码

    //@Scheduled(cron = "30 03 17 * * ?")
    public void createWarehouseProductTimer() throws Exception {
        String companyId = new String("d8fd18f1255048bf83e6f77b2ef1b2b1");


        Map<String, String> sysProductMap = new HashMap<String, String>();

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Product> prodList = productService.findProductList(findMap);
        if (prodList != null && prodList.size() > 0) {
            for (Product prodObject : prodList) {
                sysProductMap.put(prodObject.getId(), prodObject.getId());
            }
        }


        findMap = new PageData();
        findMap.put("currentCompanyId", companyId);
        List<Map> mapList = warehouseProductService.getWarehouseProductView(findMap, null);

        if (mapList != null && mapList.size() > 0) {
            String strTemp = "仓库共({0})货品-已更新第({1})个";

            for (int i = 0; i < mapList.size(); i++) {
                Map<String, Object> objectMap = mapList.get(i);

                String prodId = (String)objectMap.get("id");
                BigDecimal stockCount = (BigDecimal)objectMap.get("stockCount");

                if (prodId != null && stockCount != null && sysProductMap.get(prodId) != null) {
                    Product editProduct = new Product();
                    editProduct.setId(prodId);

                    //四舍五入 2位小数
                    stockCount = stockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    editProduct.setStockCount(stockCount);
                    productService.update(editProduct);

                    String msgStr = MessageFormat.format(strTemp,
                            Integer.valueOf(mapList.size()).toString(),
                            Integer.valueOf(i+1).toString());
                    System.out.println(msgStr);
                }
            }
        }
    }
}
