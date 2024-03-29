package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseProductMapper;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_warehouse_product:仓库货位产品库存表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseProductServiceImp implements WarehouseProductService {

    @Autowired
    private WarehouseProductMapper warehouseProductMapper;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;
    @Autowired
    private WarehouseProductQueryService warehouseProductQueryService;
    @Autowired
    private WarehouseProductExcelByWcService warehouseProductExcelByWcService;

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private WarehouseLoginfoService warehouseLoginfoService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private FileService fileService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setId(Conv.createUuid());
        warehouseProduct.setCdate(new Date());
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.insert(warehouseProduct);
    }

    public void save(String id, WarehouseProduct warehouseProduct) throws Exception {
        warehouseProduct.setId(id);
        warehouseProduct.setCdate(new Date());
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.insert(warehouseProduct);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.updateById(warehouseProduct);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseProduct warehouseProduct) throws Exception{
        warehouseProduct.setUdate(new Date());
        warehouseProductMapper.updateAllColumnById(warehouseProduct);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseProductMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseProductMapper.deleteByIds(ids);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-10-22
     */
    @Override
    //@Cacheable(cacheNames = "warehouseOut", key = "''+#id")
    public WarehouseProduct selectById(String id) throws Exception{
        return warehouseProductMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseProduct> dataList(PageData pd) throws Exception{
        return warehouseProductMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseProductMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseProduct> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseProduct> warehouseProductList =  warehouseProductMapper.selectByMap(columnMap);
        return warehouseProductList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseProductMapper.getDataListPage(pd, pg);
    }

    @Override
    public List<Map> getDataListPageDispatchByWC(PageData pd) throws Exception {
        return warehouseProductMapper.getDataListPageDispatchByWC(pd);
    }

    public List<Map> getDataListPageDispatchBySimple(PageData pd) throws Exception{
        return warehouseProductMapper.getDataListPageDispatchBySimple(pd);
    }
    public List<Map> simpleWarehouseDetailView(PageData pd) throws Exception {
        return warehouseProductMapper.simpleWarehouseDetailView(pd);
    }


    @Override
    public List<Map> getDataListPageDispatch(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseProductMapper.getDataListPageDispatch(pd);
        } else if (pg != null) {
            return warehouseProductMapper.getDataListPageDispatch(pd, pg);
        }

        return mapList;
    }
    public List<Map> getDataListPageDispatch(PageData pd) throws Exception{
        return warehouseProductMapper.getDataListPageDispatch(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseProductMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     *
     * @param companyId  企业id
     * @param isSpare    是否备件库(true: 删除的是备件库 false: 删除的是非备件库)
     * @throws Exception
     */
    public void deleteTable(String companyId, String isSpare) {
        PageData pageData = new PageData();
        pageData.put("companyId", companyId);
        //isSpare:=false 或 isSpare is null (删除的是非备件库)
        pageData.put("isNeedNotInWarehouseSpare", "true");

        if ("true".equals(isSpare)) {
            pageData.put("isNeedNotInWarehouseSpare", null);

            //isSpare:=true (删除的是备件库)
            pageData.put("isNeedWarehouseSpare", "true");
        }

        warehouseProductMapper.deleteTable(pageData);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-26
     */
    public void updateStockCount(PageData pd) throws Exception {
        Integer updateValue = null;
        try {
            updateValue = warehouseProductMapper.updateStockCount(pd);
        } catch (Exception e) {}

        if (updateValue == null || 0 == updateValue.intValue()) {
            throw new Exception("当前系统繁忙，请稍后操作！");
        }
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    public List<Map<String, Object>> findWarehouseProductMapList(PageData pd) {
        return warehouseProductMapper.findWarehouseProductMapList(pd);
    }

    public WarehouseProduct findWarehouseProduct(PageData object) {
        if (object == null) {return null;}

        List<WarehouseProduct> objectList = this.findWarehouseProductList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseProduct findWarehouseProductById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseProduct(findMap);
    }

    public List<WarehouseProduct> findWarehouseProductList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseProduct> objectList = new ArrayList<WarehouseProduct>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }

    public String findWarehouseIdsByWarehouseProductList(List<WarehouseProduct> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (WarehouseProduct object : objectList) {
            if (object.getWarehouseId() != null && object.getWarehouseId().trim().length() > 0) {
                strBuf.append(object.getWarehouseId().trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

//    public WarehouseProduct warehouseProduct2QRCodeObj(WarehouseProduct warehouseProduct, WarehouseProduct QRCodeObj) {
//        if (QRCodeObj == null) {QRCodeObj = new WarehouseProduct();}
//        if (warehouseProduct == null) {return QRCodeObj;}
//
//        QRCodeObj.setId(warehouseProduct.getId());
//        QRCodeObj.setProductId(warehouseProduct.getProductId());
//        QRCodeObj.setWarehouseId(warehouseProduct.getWarehouseId());
//        QRCodeObj.setCode(warehouseProduct.getCode());
//
//        return QRCodeObj;
//    }

    public String warehouseProduct2QRCode(WarehouseProduct warehouseProduct) {
        if (warehouseProduct == null) {return new String();}
        Map<String, String> QRCodeMap = new HashMap<String, String>();

        QRCodeMap.put("code", "");
        if (warehouseProduct.getCode() != null && warehouseProduct.getCode().trim().length() > 0) {
            QRCodeMap.put("code", warehouseProduct.getCode().trim());
        }

        //QRCodeMap.put("productId", "");
        if (warehouseProduct.getProductId() != null && warehouseProduct.getProductId().trim().length() > 0) {
            String productId = warehouseProduct.getProductId().trim();
            //QRCodeMap.put("productId", productId);

            QRCodeMap.put("productName", "");
            Product prod = productService.findProductById(productId);
            if (prod != null && prod.getName() != null && prod.getName().trim().length() > 0) {
                QRCodeMap.put("productName", prod.getName().trim());
            }
        }

        String QRCodeJson = new String();
        if (QRCodeMap.size() > 0) {
            QRCodeJson = YvanUtil.toJson(QRCodeMap);
        }
        //System.out.println("QRCodeJson:" + QRCodeJson);

        return QRCodeJson;
    }

    public List<Map<String, Object>> findWarehouseProductByWarehouse(PageData pageData) {
        return warehouseProductMapper.findWarehouseProductByWarehouse(pageData);
    }

    public List<Map<String, String>> findWarehouseProductMapList(String companyId, String productId, String code) {
        List<Map<String, String>> warehouseList = new ArrayList<Map<String, String>>();

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("currentCompanyId", companyId);
        }
        findMap.put("productId", productId);
        findMap.put("code", code);

        List<Map> mapList = null;
        try {
            mapList = warehouseProductMapper.getDataListPageDispatch(findMap);
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {return warehouseList;}

        for (Map<String, Object> mapObject : mapList) {
            Map<String, String> mapObj = new HashMap<String, String>();

            //货位货品id id warehouseProductId
            String id = new String();
            if (mapObject.get("id") != null) {
                id = mapObject.get("id").toString().trim();
            }
            mapObj.put("warehouseProductId", id);

            //货位id warehouseId
            String warehouseId = new String();
            if (mapObject.get("warehouseId") != null) {
                warehouseId = mapObject.get("warehouseId").toString().trim();
            }
            mapObj.put("warehouseId", warehouseId);

            //仓库路径名称 name warehousePathName
            String name = new String();
            if (mapObject.get("name") != null) {
                name = mapObject.get("name").toString().trim();
            }
            mapObj.put("warehousePathName", name);

            //库存数量 stockCount warehouseStockCount
            String warehouseStockCount = new String("0");
            BigDecimal stockCount_big = BigDecimal.valueOf(0D);
            if (mapObject.get("stockCount") != null) {
                String stockCount_str = mapObject.get("stockCount").toString().trim();
                try {
                    stockCount_big = new BigDecimal(stockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (stockCount_big.doubleValue() != 0) {
                    //四舍五入到2位小数
                    stockCount_big = stockCount_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    warehouseStockCount = stockCount_big.toString();
                }
            }
            mapObj.put("warehouseStockCount", warehouseStockCount);

            warehouseList.add(mapObj);
        }

        return warehouseList;
    }

    /**
     * 按照(cdate创建时间)升序排序，返回结果集
     * 按值应用调用方法
     *
     * @param objectList
     */
    public void orderAcsByCdate(List<WarehouseProduct> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                WarehouseProduct object_0 = (WarehouseProduct)arg0;
                WarehouseProduct object_1 = (WarehouseProduct)arg1;
                return object_0.getCdate().compareTo(object_1.getCdate());
            }
        });
    }
    /**
     * 按照(cdate创建时间)降序排序，返回结果集
     * 按值应用调用方法
     *
     * @param objectList
     */
    public void orderDescByCdate(List<WarehouseProduct> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                WarehouseProduct object_0 = (WarehouseProduct)arg0;
                WarehouseProduct object_1 = (WarehouseProduct)arg1;
                return object_1.getCdate().compareTo(object_0.getCdate());
            }
        });
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取推荐货位(默认货位)
     * 1. 查询库存表(vmes_warehouse_product:仓库货位产品库存表)
     *   A. 相同货品的库位，按数量由少到多
     *   B. 历史放过此货品的空库位
     * 2. 若是新货，就推荐相同货品分类附近的空库位
     * 3. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
     *
     * @param companyId  企业id
     * @param product    货品对象
     * @return
     */
    public String findDefaultWarehousePosition(String companyId, Product product) {
        String position = new String();
        if (companyId == null || companyId.trim().length() == 0) {return position;}
        if (product == null) {return position;}

        //1. 相同货品的库位，按数量由少到多
        position = this.findDefaultPositionByHistory(companyId, product);
        if (position != null && position.trim().length() > 0) {return position;}

        //2. 若是新货，就推荐相同货品分类附近的空库位
        position = this.findDefaultPositionByproductType(companyId, product);
        if (position != null && position.trim().length() > 0) {return position;}

        //3. 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
        position = this.findDefaultPosition(companyId);

        return position;
    }

    public String findWarehouseIdsByMapList(List<Map<String, Object>> mapList) {
        if (mapList == null || mapList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (Map<String, Object> mapObject : mapList) {
            String warehouseId = (String)mapObject.get("warehouseId");
            if (warehouseId != null && warehouseId.trim().length() > 0) {
                strBuf.append(warehouseId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * vmes_warehouse_product:仓库货位产品库存表
     * 优先推荐相同货品的库位，按数量由少到多
     * 其次推荐曾放过此货品的空库位
     *
     * @param companyId
     * @param product
     * @return
     */
    private String findDefaultPositionByHistory(String companyId, Product product) {
        if (companyId == null || companyId.trim().length() == 0) {return new String();}
        if (product == null) {return new String();}

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("productId", product.getId());
        findMap.put("queryStr", "  stock_count > 0 and isdisable = '1' ");
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            findMap.put("orderStr", "stock_count,cdate asc");
        }

        List<WarehouseProduct> objectList = findWarehouseProductList(findMap);
        if (objectList != null && objectList.size() > 0
                && objectList.get(0).getWarehouseId() != null
                && objectList.get(0).getWarehouseId().trim().length() > 0
                ) {
            return objectList.get(0).getWarehouseId().trim();
        }

        return new String();
    }

    /**
     * 相同货品分类附近的空库位
     *
     * @param companyId
     * @param product
     * @return
     */
    private String findDefaultPositionByproductType(String companyId, Product product) {
        if (companyId == null || companyId.trim().length() == 0) {return new String();}
        if (product == null) {return new String();}

        //查询 vmes_warehouse_product 获取已放货品的货位id Map<货位id,货位id>
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("queryStr", "  stock_count > 0 and isdisable = '1' and  warehouse_id is not null and product_id is not null");
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
        }
        List<WarehouseProduct> objectList = this.findWarehouseProductList(findMap);

        Map<String, String> existMap = new HashMap<String, String>();
        for (WarehouseProduct object : objectList) {
            String warehouseId = object.getWarehouseId();
            existMap.put(warehouseId, warehouseId);
        }

        //1. vmes_warehouse_product,vmes_product 关联查询
        //相同货品分类-在仓库中的货位id(逗号分隔的字符串)
        findMap = new PageData();
        //isdisable:是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("productIsdisable", "1");
        findMap.put("companyId", companyId);
        findMap.put("type", product.getType());
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
        }

        List<Map<String, Object>> mapList = this.findWarehouseProductMapList(findMap);
        String warehouseIds = this.findWarehouseIdsByMapList(mapList);
        if (warehouseIds == null || warehouseIds.trim().length() == 0) {return new String();}

        //2. 根据货位ids-查询 vmes_warehouse:仓库货位表-获取全部仓库货位表pid
        findMap = new PageData();
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        warehouseIds = StringUtil.stringTrimSpace(warehouseIds);
        warehouseIds = "'" + warehouseIds.replace(",", "','") + "'";
        findMap.put("queryStr", "id in (" + warehouseIds + ")");
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
        }

        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);
        String pids = warehouseService.findPidsByWarehouseList(warehouseList);
        if (pids == null || pids.trim().length() == 0) {return new String();}

        //3. 根据上级pids-查询 vmes_warehouse:仓库货位表-获取全部仓库货位List
        findMap = new PageData();
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        //实体库 warehouseEntity 2d75e49bcb9911e884ad00163e105f05
        findMap.put("nodeId", Common.DICTIONARY_MAP.get("warehouseEntity"));
        findMap.put("companyId", companyId);
        //isLeaf:是否叶子(0:非叶子 1:是叶子)
        findMap.put("isLeaf", "1");
        pids = StringUtil.stringTrimSpace(pids);
        pids = "'" + pids.replace(",", "','") + "'";
        findMap.put("queryStr", "pid in (" + pids + ") and layer >= 3");
        findMap.put("orderStr", "layer,serial_number");
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
        }

        warehouseList = warehouseService.findWarehouseList(findMap);
        if (warehouseList == null || warehouseList.size() == 0) {return new String();}

        //4. 遍历warehouseList<Warehouse>--(同类货品所有货位)
        for (Warehouse object : warehouseList) {
            String warehouseId = object.getId();
            if (existMap.get(warehouseId) == null) {
                return warehouseId;
            }
        }

        return new String();
    }

    /**
     * 获取一个空货位
     * 查询仓库表(vmes_warehouse:仓库货位表) 创建时间最久的货位(cdate)
     *
     * @param companyId
     * @return
     */
    private String findDefaultPosition(String companyId) {
        if (companyId == null || companyId.trim().length() == 0) {return new String();}

        PageData findMap = new PageData();
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        //实体库 warehouseEntity 2d75e49bcb9911e884ad00163e105f05
        findMap.put("nodeId", Common.DICTIONARY_MAP.get("warehouseEntity"));
        findMap.put("queryStr", "layer >= 3");
        findMap.put("companyId", companyId);
        //是否叶子(0:非叶子 1:是叶子)
        findMap.put("isLeaf", "1");
        findMap.put("orderStr", "cdate,serial_number asc");
        if (findMap.size() > 0) {
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
        }

        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);
        if (warehouseList != null && warehouseList.size() > 0 && warehouseList.get(0).getId() != null) {
            return warehouseList.get(0).getId().trim();
        }

        return new String();
    }

    /////////////////////////////////////////////////////////////////////////////////
    /**
     * 入库(变更库存数量)
     * @param object  入库库存信息
     * @param count   入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
     * @param loginfo
     */
    public String inStockCount(WarehouseProduct object,
                               BigDecimal count,
                               WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkInWarehouseProduct(object);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("入库数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        object.setCuser(loginfo.getCuser());
        object.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
        loginfo.setBusinessType("in");
        //count:业务数量
        loginfo.setCount(count);

        //type:(in:入库 out:出库 move:移库, check:盘点)
        msgStr = this.modifyStockCount(null, object, "in", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }
//    public String inStockCountBySimple(WarehouseProduct object,
//                                BigDecimal count,
//                                WarehouseLoginfo loginfo) throws TableVersionException,Exception {
//        StringBuffer msgBuf = new StringBuffer();
//
//        String msgStr = this.checkInWarehouseProductBySimple(object);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//        if (count == null) {
//            msgBuf.append("入库数量为空" + Common.SYS_ENDLINE_DEFAULT);
//        }
//        if (msgBuf.toString().trim().length() > 0) {
//            return msgBuf.toString().trim();
//        }
//
//        object.setCuser(loginfo.getCuser());
//        object.setCompanyId(loginfo.getCompanyId());
//
//        //设置库存变更日志-基本信息
//        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
//        loginfo.setBusinessType("in");
//        //count:业务数量
//        loginfo.setCount(count);
//
//        //type:(in:入库 out:出库 move:移库, check:盘点)
//        msgStr = this.modifyStockCount(null, object, "in", count, loginfo);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//
//        return msgBuf.toString();
//    }


    /**
     * 出库(变更库存数量)
     * @param object  出库库存信息
     * @param count   出库数量(大于零或小于零)--小于零)反向操作(撤销出库)
     * @param loginfo
     */
    public String outStockCount(WarehouseProduct object,
                                BigDecimal count,
                                WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkOutWarehouseProduct(object);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("出库数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        object.setCuser(loginfo.getCuser());
        object.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
        loginfo.setBusinessType("out");
        //count:业务数量
        loginfo.setCount(count);

        //type:(in:入库 out:出库 move:移库, check:盘点)
        msgStr = this.modifyStockCount(object, null, "out", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }

//    //(简版仓库)出库(变更库存数量)
//    public String outStockCountBySimple(WarehouseProduct object,
//                                 BigDecimal count,
//                                 WarehouseLoginfo loginfo) throws TableVersionException,Exception {
//        StringBuffer msgBuf = new StringBuffer();
//
//        String msgStr = this.checkOutWarehouseProductBySimple(object);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//        if (count == null) {
//            msgBuf.append("出库数量为空" + Common.SYS_ENDLINE_DEFAULT);
//        }
//        if (msgBuf.toString().trim().length() > 0) {
//            return msgBuf.toString().trim();
//        }
//
//        object.setCuser(loginfo.getCuser());
//        object.setCompanyId(loginfo.getCompanyId());
//
//        //设置库存变更日志-基本信息
//        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
//        loginfo.setBusinessType("out");
//        //count:业务数量
//        loginfo.setCount(count);
//
//        //type:(in:入库 out:出库 move:移库, check:盘点)
//        msgStr = this.modifyStockCount(object, null, "out", count, loginfo);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//
//        return msgBuf.toString();
//    }

    /**
     * 盘点(变更库存数量)
     * @param object  盘点库存信息
     * @param count   盘点数量(大于零或小于零)--小于零)反向操作(撤销盘点)
     * @param loginfo
     */
    public String checkStockCount(WarehouseProduct object,
                                  BigDecimal count,
                                  WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkInWarehouseProduct(object);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("盘点数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        object.setCuser(loginfo.getCuser());
        object.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
        loginfo.setBusinessType("check");
        //count:业务数量
        loginfo.setCount(count);

        //type:(in:入库 out:出库 move:移库, check:盘点)
        msgStr = this.modifyStockCount(null, object, "check", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }
//    public String checkStockCountBySimple(WarehouseProduct object,
//                                   BigDecimal count,
//                                   WarehouseLoginfo loginfo) throws TableVersionException,Exception {
//        StringBuffer msgBuf = new StringBuffer();
//
//        String msgStr = this.checkInWarehouseProductBySimple(object);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//        if (count == null) {
//            msgBuf.append("盘点数量为空" + Common.SYS_ENDLINE_DEFAULT);
//        }
//        if (msgBuf.toString().trim().length() > 0) {
//            return msgBuf.toString().trim();
//        }
//
//        object.setCuser(loginfo.getCuser());
//        object.setCompanyId(loginfo.getCompanyId());
//
//        //设置库存变更日志-基本信息
//        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
//        loginfo.setBusinessType("check");
//        //count:业务数量
//        loginfo.setCount(count);
//
//        //type:(in:入库 out:出库 move:移库, check:盘点)
//        msgStr = this.modifyStockCount(null, object, "check", count, loginfo);
//        if (msgStr != null && msgStr.trim().length() > 0) {
//            msgBuf.append(msgStr);
//        }
//
//        return msgBuf.toString();
//    }

    public String updateStockCount(WarehouseProduct object,
                            BigDecimal count,
                            WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkInWarehouseProduct(object);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("盘点数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        object.setCuser(loginfo.getCuser());
        object.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点 update:库存修改)
        loginfo.setBusinessType("update");
        //count:业务数量
        loginfo.setCount(count);

        //type:(in:入库 out:出库 move:移库, check:盘点)
        msgStr = this.modifyStockCount(null, object, "update", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }

    /**
     * 移库(变更库存数量)
     * @param source  变更源对象
     * @param target  变更目标对象
     * @param count   变更数量(大于零或小于零)
     */
    public String moveStockCount(WarehouseProduct source, WarehouseProduct target, BigDecimal count, WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkMoveWarehouseProduct(source, target);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("移库数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        source.setCuser(loginfo.getCuser());
        source.setCompanyId(loginfo.getCompanyId());

        target.setCuser(loginfo.getCuser());
        target.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
        loginfo.setBusinessType("move");
        //count:业务数量
        loginfo.setCount(count);

        msgStr = this.modifyStockCount(source, target, "move", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }
    public String moveStockCountBySimple(WarehouseProduct source, WarehouseProduct target, BigDecimal count, WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        String msgStr = this.checkMoveWarehouseProductBySimple(source, target);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }
        if (count == null) {
            msgBuf.append("移库数量为空" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString().trim();
        }

        source.setCuser(loginfo.getCuser());
        source.setCompanyId(loginfo.getCompanyId());

        target.setCuser(loginfo.getCuser());
        target.setCompanyId(loginfo.getCompanyId());

        //设置库存变更日志-基本信息
        //business_type:业务类型(in:入库 out:出库: move:移库 check:库存盘点)
        loginfo.setBusinessType("move");
        //count:业务数量
        loginfo.setCount(count);

        msgStr = this.modifyStockCount(source, target, "move", count, loginfo);
        if (msgStr != null && msgStr.trim().length() > 0) {
            msgBuf.append(msgStr);
        }

        return msgBuf.toString();
    }

    /**
     * 变更库存数量唯一接口
     * 库存数量变更，包括操作(入库, 出库, 移库)
     *
     * (源)source<WarehouseProduct>
     *   code:        is not null 货位批次号
     *   productId:   is not null 货品id
     *   warehouseId: is not null 库位id
     *
     * (目标)target<WarehouseProduct>
     *   code:        is not null 货位批次号
     *   productId:   is not null 货品id
     *   warehouseId: is not null 库位id
     *
     * (操作类型)type:(in:入库 out:出库 move:移库, check:盘点, update:库存修改)
     * (变更数量)count: 大于零或小于零，(小于零)反向操作 退回或撤销业务等
     *
     * in:入库
     * (源)source (null) is null
     *(目标)target (不可为空)is not null
     * (货位批次号,货品id,库位id)查询库存表-得到库存数量
     * 库存数量 + 变更数量 := 变更后库存数量  变更数量(小于零) 撤销入库
     *
     * out:出库
     * (源)source (不可为空) is not null
     * (目标)target (null) is null
     * (货位批次号,货品id,库位id)查询库存表-得到库存数量
     * 库存数量 - 变更数量 := 变更后库存数量  变更数量(小于零) 撤销出库
     *
     * move:移库
     * (源)source (不可为空) is not null
     *   (货位批次号,货品id,库位id)查询库存表-得到(源)库存数量
     *   (源)库存数量 - 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     * (目标)target (不可为空)is not null
     *   (货位批次号,货品id,库位id)查询库存表-得到(目标)库存数量
     *   (目标)库存数量 + 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     *
     * @param source  变更源对象
     * @param target  变更目标对象
     * @param type    (不可为空)类型(in:入库 out:出库 move:移库)
     * @param count   (不可为空)变更数量
     * @return
     */
    public String modifyStockCount(WarehouseProduct source, WarehouseProduct target, String type, BigDecimal count, WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        StringBuffer msgBuf = new StringBuffer();

        //基本入口参数(非空判断)
        if (type == null || type.trim().length() == 0) {
            msgBuf.append("变更类型(type)为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (count == null) {
            msgBuf.append("变更数量(count)为空！" + Common.SYS_ENDLINE_DEFAULT);
        }

        //"in,check,update" (目标)target 非空判断
        //"out" (源)source 非空判断
        //"move" (source,target) 非判断
        if ("in".equals(type) && target == null) {
            msgBuf.append("入库操作:变更目标对象 target<WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
        } else if ("check".equals(type) && target == null) {
            msgBuf.append("盘点操作:变更目标对象 target<WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
        } else if ("update".equals(type) && target == null) {
            msgBuf.append("修改库存操作:变更目标对象 target<WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
        } else if ("out".equals(type) && source == null) {
            msgBuf.append("出库操作:变更源对象对象 source<WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
        } else if ("move".equals(type) && (target == null || source == null) ) {
            msgBuf.append("移库操作:变更源或变更目标对象(source,target) <WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgBuf.toString().trim().length() > 0) {
            return msgBuf.toString();
        }

        //(源)source 变更库存数量
        if (source != null) {
            this.modifyBySource(source, count, loginfo);
        }

        //(目标)target 变更库存数量
        if (target != null) {
            this.modifyByTarget(target, count, loginfo);
        }

        return msgBuf.toString();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * (源)source 变更库存数量
     *   (货位批次号,货品id,库位id)查询库存表-得到(源)库存数量
     *   (源)库存数量 - 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     * @param object
     * @param count
     */
    private void modifyBySource(WarehouseProduct object, BigDecimal count, WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        if (object == null) {return;}
        if (count == null) {return;}

        //(货位批次号,货品id,库位id)查询库存表
        //非空判断 -- 接口入口已经验证

        WarehouseProduct objectDB = null;
        if (object.getId() != null && object.getId().trim().length() > 0) {
            objectDB = this.findWarehouseProductById(object.getId().trim());
        } else {
            PageData findMap = new PageData();
            findMap.put("code", object.getCode());
            findMap.put("productId", object.getProductId());
            findMap.put("warehouseId", object.getWarehouseId());
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            objectDB = this.findWarehouseProduct(findMap);
        }

        //当前需要变更库存数量 (大于零:加库存 小于零:减库存)
        double tempCount = -1 * count.doubleValue();
        //operationCount 操作数量(正数:加库存 负数:减库存)
        loginfo.setOperationCount(BigDecimal.valueOf(tempCount));

        if (objectDB == null) {
            WarehouseProduct addObj = new WarehouseProduct();
            String id = Conv.createUuid();
            addObj.setId(id);
            addObj.setCode(object.getCode());
            addObj.setProductId(object.getProductId());
            addObj.setWarehouseId(object.getWarehouseId());
            addObj.setStockCount(BigDecimal.valueOf(tempCount));
            addObj.setCuser(object.getCuser());
            addObj.setCompanyId(object.getCompanyId());

            //生成二维码
            String QRCodeJson = this.warehouseProduct2QRCode(addObj);
            String qrcode = fileService.createQRCode("warehouseProduct", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                addObj.setQrcode(qrcode);
            }

            this.save(id, addObj);

            loginfo.setSourceWpId(addObj.getId());
            loginfo.setSourceBeforeStockcount(BigDecimal.valueOf(0D));
            loginfo.setSourceAfterStockcount(BigDecimal.valueOf(tempCount));

            //库存变更日志
            //businessType 业务类型(in:入库 out:出库: move:移库 check:库存盘点)
            if (!"move".equals(loginfo.getBusinessType())) {
                warehouseLoginfoService.save(loginfo);
            }
        } else {
            loginfo.setSourceWpId(objectDB.getId());

            //变更前库存数量
            //sourceBeforeStockcount (源)库存变更前数量(出库,移库时填写)
            double stockCountDB = 0D;
            if (objectDB.getStockCount() != null) {
                stockCountDB = objectDB.getStockCount().doubleValue();
            }
            loginfo.setSourceBeforeStockcount(BigDecimal.valueOf(stockCountDB));

            //变更后库存数量 := (源)库存数量 + (-1 * 变更数量)
            //sourceAfterStockcount (源)库存变更后数量(出库,移库时填写)
            double modifyCount = stockCountDB + tempCount;
            //四舍五入到2位小数
            BigDecimal bigDecimal = BigDecimal.valueOf(modifyCount).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            loginfo.setSourceAfterStockcount(bigDecimal);

            PageData modifyMap = new PageData();
            modifyMap.put("stockCount", bigDecimal.toString());
            modifyMap.put("uuser", object.getCuser());
            //修改where条件
            modifyMap.put("id", objectDB.getId());
            modifyMap.put("version", objectDB.getVersion().toString());
            try {
                this.updateStockCount(modifyMap);

                //库存变更日志
                //businessType 业务类型(in:入库 out:出库: move:移库 check:库存盘点)
                if (!"move".equals(loginfo.getBusinessType())) {
                    warehouseLoginfoService.save(loginfo);
                }
            } catch (Exception e) {
                throw new TableVersionException(Common.SYS_STOCKCOUNT_ERRORCODE, "当前系统繁忙，请稍后操作！");
            }
        }
    }

    /**
     * (目标)target 变更库存数量
     *   (货位批次号,货品id,库位id)查询库存表-得到(目标)库存数量
     *   (目标)库存数量 + 变更数量 := 变更后库存数量  变更数量(小于零) 撤销移库
     *
     * @param object
     * @param count
     */
    private void modifyByTarget(WarehouseProduct object, BigDecimal count, WarehouseLoginfo loginfo) throws TableVersionException,Exception {
        if (object == null) {return;}
        if (count == null) {return;}

        //(货位批次号,货品id,库位id)查询库存表
        //非空判断 -- 接口入口已经验证

        WarehouseProduct objectDB = null;
        if (object.getId() != null && object.getId().trim().length() > 0) {
            objectDB = this.findWarehouseProductById(object.getId().trim());
        } else {
            PageData findMap = new PageData();
            findMap.put("code", object.getCode());
            findMap.put("productId", object.getProductId());
            findMap.put("warehouseId", object.getWarehouseId());
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            objectDB = this.findWarehouseProduct(findMap);
        }

        //当前需要变更库存数量 (大于零:加库存 小于零:减库存)
        double tempCount = count.doubleValue();
        //库存变更日志
        //operationCount 操作数量(正数:加库存 负数:减库存)
        loginfo.setOperationCount(BigDecimal.valueOf(tempCount));

        if (objectDB == null) {
            WarehouseProduct addObj = new WarehouseProduct();
            addObj.setCode(object.getCode());
            addObj.setProductId(object.getProductId());
            addObj.setWarehouseId(object.getWarehouseId());
            addObj.setStockCount(BigDecimal.valueOf(tempCount));
            addObj.setCuser(object.getCuser());
            addObj.setCompanyId(object.getCompanyId());
            addObj.setQrcode(object.getQrcode());

            //二维码
            if (object.getQrcode() != null) {
                addObj.setQrcode(object.getQrcode());
            }

            //货品单价(计量单位)-文成企业定制
            if (object.getPrice() != null) {
                addObj.setPrice(object.getPrice());
            }

            this.save(addObj);

            loginfo.setTargetWpId(addObj.getId());
            loginfo.setTargetBeforeStockcount(BigDecimal.valueOf(0D));
            loginfo.setTargetAfterStockcount(BigDecimal.valueOf(tempCount));

            //库存变更日志
            warehouseLoginfoService.save(loginfo);
        } else {
            loginfo.setTargetWpId(objectDB.getId());

            //变更前库存数量
            //targetBeforeStockcount (目标)库存变更前数量(入库,盘点,移库,填写)
            double stockCountDB = 0D;
            if (objectDB.getStockCount() != null) {
                stockCountDB = objectDB.getStockCount().doubleValue();
            }
            loginfo.setTargetBeforeStockcount(BigDecimal.valueOf(stockCountDB));

            //变更后库存数量 := (目标)库存数量 + 变更数量
            //targetAfterStockcount (目标)库存变更后数量(入库,盘点,移库,填写)
            double modifyCount = stockCountDB + tempCount;
            //四舍五入到2位小数
            BigDecimal bigDecimal = BigDecimal.valueOf(modifyCount).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            loginfo.setTargetAfterStockcount(bigDecimal);

            PageData modifyMap = new PageData();
            modifyMap.put("stockCount", bigDecimal.toString());
            modifyMap.put("uuser", object.getCuser());
            //修改where条件
            modifyMap.put("id", objectDB.getId());
            modifyMap.put("version", objectDB.getVersion().toString());

            try {
                this.updateStockCount(modifyMap);

                //库存变更日志
                warehouseLoginfoService.save(loginfo);
            } catch (Exception e) {
                e.printStackTrace();
                throw new TableVersionException(Common.SYS_STOCKCOUNT_ERRORCODE, "当前系统繁忙，请稍后操作！");
            }
        }
    }

    private String checkInWarehouseProduct(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: 入库对象<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            msgBuf.append("货位批次号为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }

//    private String checkInWarehouseProductBySimple(WarehouseProduct object) {
//        StringBuffer msgBuf = new StringBuffer();
//        if (object == null) {
//            msgBuf.append("参数错误: 入库对象<WarehouseProduct> 为空！");
//            return msgBuf.toString();
//        }
//
//        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
//            msgBuf.append("货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
//        }
//        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
//            msgBuf.append("库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
//        }
//
//        return msgBuf.toString();
//    }

    private String checkOutWarehouseProduct(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: 出库对象<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            msgBuf.append("货位批次号为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }

//    private String checkOutWarehouseProductBySimple(WarehouseProduct object) {
//        StringBuffer msgBuf = new StringBuffer();
//        if (object == null) {
//            msgBuf.append("参数错误: 出库对象<WarehouseProduct> 为空！");
//            return msgBuf.toString();
//        }
//
//        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
//            msgBuf.append("货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
//        }
//        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
//            msgBuf.append("库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
//        }
//
//        return msgBuf.toString();
//    }

    private String checkSourceWarehouseProduct(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: (源)source<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            msgBuf.append("(源)货位批次号为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("(源)货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("(源)库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }
    private String checkSourceWarehouseProductBySimple(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: (源)source<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("(源)货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("(源)库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }

    private String checkTargetWarehouseProduct(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: (目标)target<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            msgBuf.append("(目标)货位批次号为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("(目标)货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("(目标)库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }
    private String checkTargetWarehouseProductBySimple(WarehouseProduct object) {
        StringBuffer msgBuf = new StringBuffer();
        if (object == null) {
            msgBuf.append("参数错误: (目标)target<WarehouseProduct> 为空！");
            return msgBuf.toString();
        }

        if (object.getProductId() == null || object.getProductId().trim().length() == 0) {
            msgBuf.append("(目标)货品id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getWarehouseId() == null || object.getWarehouseId().trim().length() == 0) {
            msgBuf.append("(目标)库位id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT);
        }

        return msgBuf.toString();
    }

    private String checkMoveWarehouseProduct(WarehouseProduct source, WarehouseProduct target) {
        StringBuffer msgBuf = new StringBuffer();
        if (source == null || target == null) {
            msgBuf.append("移库操作:变更源或变更目标对象(source,target) <WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
            return msgBuf.toString();
        }

        String msg_source = this.checkSourceWarehouseProduct(source);
        if (msg_source != null && msg_source.trim().length() > 0) {
            msgBuf.append(msg_source);
        }

        String msg_target = this.checkTargetWarehouseProduct(target);
        if (msg_target != null && msg_target.trim().length() > 0) {
            msgBuf.append(msg_target);
        }

        return msgBuf.toString();
    }
    private String checkMoveWarehouseProductBySimple(WarehouseProduct source, WarehouseProduct target) {
        StringBuffer msgBuf = new StringBuffer();
        if (source == null || target == null) {
            msgBuf.append("移库操作:变更源或变更目标对象(source,target) <WarehouseProduct>为空！" + Common.SYS_ENDLINE_DEFAULT);
            return msgBuf.toString();
        }

        String msg_source = this.checkSourceWarehouseProductBySimple(source);
        if (msg_source != null && msg_source.trim().length() > 0) {
            msgBuf.append(msg_source);
        }

        String msg_target = this.checkTargetWarehouseProductBySimple(target);
        if (msg_target != null && msg_target.trim().length() > 0) {
            msgBuf.append(msg_target);
        }

        return msgBuf.toString();
    }


    @Override
    public List<Map> getWarehouseProductView(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseProductMapper.warehouseProductView(pd);
        } else if (pg != null) {
            return warehouseProductMapper.warehouseProductView(pd,pg);
        }

        return mapList;
    }

    @Override
    public List<Map> getWarehouseDetailView(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseProductMapper.warehouseDetailView(pd,pg);
    }


    @Override
    public List<Map> getWarehouseProductMove(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseProductMapper.warehouseProductMove(pd,pg);
    }



    /////////////////////////////////////////////////////////////////////////////////
    //手机端功能
    public List<Map> findListPageWarehouseByProduct(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        return warehouseProductMapper.findListPageWarehouseByProduct(pd,pg);
    }


    //手机端功能
    @Override
    public ResultModel findListPageWarehouseByProduct(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);
        ResultModel model = new ResultModel();
        List<Map> varList = warehouseProductMapper.findListPageWarehouseByProduct(pd,pg);
        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel updateWarehouseProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        String uuser = pd.getString("uuser");
        String companyId = pd.getString("currentCompanyId");

        String productId = pd.getString("productId");
        BigDecimal beforeCount = BigDecimal.valueOf(Double.parseDouble( pd.getString("beforeCount")));
        BigDecimal afterCount = BigDecimal.valueOf(Double.parseDouble( pd.getString("afterCount")));
        WarehouseProduct warehouseProduct = (WarehouseProduct) HttpUtils.pageData2Entity(pd, new WarehouseProduct());
        warehouseProduct.setStockCount(afterCount);
        //warehouseProductService.update(warehouseProduct);

        WarehouseLoginfo loginfo = new WarehouseLoginfo();
        loginfo.setCuser(uuser);
        loginfo.setCompanyId(companyId);
        //操作变更前数量(业务相关)
        loginfo.setBeforeCount(beforeCount);
        //操作变更后数量(业务相关)
        loginfo.setAfterCount(afterCount);
        this.updateStockCount(warehouseProduct,
                BigDecimal.valueOf(afterCount.doubleValue() - beforeCount.doubleValue()),
                loginfo);

        //添加修改产品库存的代码
        Product product = productService.selectById(productId);
        productService.updateStockCount(product,
                product.getStockCount().add(afterCount.subtract(beforeCount)),
                uuser,
                "update");

        //还需添加库存操作日志代码
        return model;
    }

    @Override
    public ResultModel listPageWCWarehouseProductView(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WCWarehouseProductView");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = warehouseProductMapper.wcWarehouseProductView(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageSimpleWarehouseProductView(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseProductView");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varList = warehouseProductMapper.simpleWarehouseProductView(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseProductView(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("WarehouseProductView");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //genreSelect 界面(货品属性)下拉查询框
        String productGenre = new String();
        if (pd.get("genreSelect") != null && ((List)pd.get("genreSelect")).size() > 0) {
            productGenre = ((List)pd.get("genreSelect")).get(0).toString();
        }
        pd.put("productGenre", productGenre);

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getWarehouseProductView(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseProductMove(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseProductMove");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }


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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getWarehouseProductMove(pd,pg);
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
    public ResultModel listPageWarehouseDetailView(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseDetailView");
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


        List<Map> varList = this.getWarehouseDetailView(pd,pg);

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }



    @Override
    public ResultModel listPageSimpleWarehouseDetailView(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);
        ResultModel model = new ResultModel();
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseDetailView");
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

        //是否需要分页 true:需要分页 false:不需要分页
        List<Map> varList = warehouseProductMapper.simpleWarehouseDetailView(pd,pg);

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);


        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseProductsDispatch(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        DecimalFormat df = new DecimalFormat("0.00");
        double count = Double.parseDouble(pd.getString("count"));

        List<Column> columnList = columnService.findColumnList("WarehouseProductDispatch");
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
        List<Map> varList = this.getDataListPageDispatch(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                double stockCount = Double.parseDouble((String)varMap.get("stockCount"));
                if(count>0){
                    if(count>=stockCount){

                        varMap.put("suggestCount",df.format(stockCount));
                        count = count - stockCount;
                        varMapList.add(varMap);
                    }else if(count<stockCount){
                        varMap.put("suggestCount",df.format(count));
                        count = 0;
                        varMapList.add(varMap);
                    }
                }
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseProductsDispatchOptionBySimple(PageData pd) throws Exception {
        Pagination pg =  HttpUtils.parsePagination(pd);

        ResultModel model = new ResultModel();

        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseProductDispatchOption");
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

        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        String notInWarehouseIds = pd.getString("notInWarehouseIds");
        if (notInWarehouseIds != null && notInWarehouseIds.trim().length() > 0) {
            notInWarehouseIds = StringUtil.stringTrimSpace(notInWarehouseIds);
            notInWarehouseIds = "'" + notInWarehouseIds.replace(",", "','") + "'";
            pd.put("notInWarehouseIds", notInWarehouseIds);
        }

        List<Map> varList = warehouseProductMapper.getDataListPageDispatchBySimple(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public ResultModel listPageWarehouseToWarehouseProductBySimple(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg =  HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("warehouseToWarehouseProductByProduct");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        String companyId = pd.getString("currentCompanyId");
        pd.put("companyId", companyId);

        String notInWarehouseIds = pd.getString("notInWarehouseIds");
        if (notInWarehouseIds != null && notInWarehouseIds.trim().length() > 0) {
            notInWarehouseIds = StringUtil.stringTrimSpace(notInWarehouseIds);
            notInWarehouseIds = "'" + notInWarehouseIds.replace(",", "','") + "'";
            pd.put("notInWarehouseIds", notInWarehouseIds);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = warehouseToWarehouseProductService.findWarehouseToWarehouseProductByProduct(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageWarehouseProductsDispatchOption(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("WarehouseProductDispatchOption");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        String notInIds = pd.getString("notInIds");
        if (notInIds != null && notInIds.trim().length() > 0) {
            notInIds = StringUtil.stringTrimSpace(notInIds);
            notInIds = "'" + notInIds.replace(",", "','") + "'";
            pd.put("notInIds", notInIds);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPageDispatch(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelWarehouseProductByProduct(PageData pd) throws Exception {
        List<Column> columnList = columnService.findColumnList("WarehouseProductView");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        //id(为货品id)
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "wp.product_id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        List<Map> dataList = this.getWarehouseProductView(pd, null);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

//    @Override
//    public ResultModel importExcelWarehouseProducts(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//        //HttpServletRequest Request = HttpUtils.currentRequest();
//
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//        return model;
//    }


    @Override
    public ResultModel updateSynStockCount(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        warehouseProductMapper.updateSynStockCount(pd);
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////
    //文成企业定制
    //库存查询-仓库货品价格 Excel导出-文成企业定制
    public void exportExcelWarehouseProductOnPriceByWc(PageData pd) throws Exception {
        List<Column> columnList = columnService.findColumnList("warehouseProductQuery");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        //id(为货品id)
        String productIds = pd.getString("productIds");
        if (productIds != null && productIds.trim().length() > 0) {
            productIds = StringUtil.stringTrimSpace(productIds);
            productIds = "'" + productIds.replace(",", "','") + "'";
            pd.put("inProductIds", productIds);
        }

        List<Map> dataList = warehouseProductQueryService.findWarehouseProductQuery(pd, null);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportHideFirstByDataList(response, fileName, dataMapList);
    }

    //仓库货品(价格) Excel导入文成企业定制
    // 导入前置条件: 财务-库存查询-导出(按钮) 导出的Excel文件，对单价列修改
    // 注意: 财务-库存查询-导出(按钮) 导出的Excel文件,第一列(id)是隐藏列
    public ResultModel importExcelWarehouseProductOnPriceByWc(MultipartFile file) throws Exception {
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

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String userId = httpRequest.getParameter("userId");

        if (dataMapLst == null || dataMapLst.size() == 1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("导入文件数据为空，请至少填写一行导入数据！");
            return model;
        }
        dataMapLst.remove(0);

        //1. 验证:第一列(id)隐藏列是否非空
        //如果:第一列(id)为空-被视为非法行
        String msgStr = warehouseProductExcelByWcService.checkColumnByIdImportExcel(dataMapLst);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2.导入字段非空判断-(单价)非空判断-(单价)数字判断
        msgStr = warehouseProductExcelByWcService.checkColumnImportExcel(dataMapLst,
                Integer.valueOf(3),
                Common.SYS_IMPORTEXCEL_MESSAGE_MAXROW);
        if (msgStr != null && msgStr.trim().length() > 0) {
            StringBuffer msgBuf = new StringBuffer();
            msgBuf.append("Excel导入失败！" + Common.SYS_ENDLINE_DEFAULT);
            msgBuf.append(msgStr);
            msgBuf.append("请核对后再次导入" + Common.SYS_ENDLINE_DEFAULT);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        //3.获取导入有效数据:只需要(单价)列不为空的行数据
        // 过滤出(单价)列为空或空字符串
        List<Map<String, String>> dataList = new ArrayList<>();
        for (Map<String, String> mapObject : dataMapLst) {

            //price 单价
            BigDecimal price = BigDecimal.valueOf(0D);
            String priceStr = mapObject.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (price.doubleValue() > 0) {
                dataList.add(mapObject);
            }
        }

        //4.修改仓库货品(单价)
        for (Map<String, String> mapObject : dataList) {
            String id = mapObject.get("id");

            //price 单价
            BigDecimal price = BigDecimal.valueOf(0D);
            String priceStr = mapObject.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //四舍五入到2位小数
            price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            WarehouseProduct editObject = new WarehouseProduct();
            editObject.setId(id);
            editObject.setPrice(price);
            editObject.setUuser(userId);
            this.update(editObject);
        }

        return model;
    }
}



