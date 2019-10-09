package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.common.util.Common;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseInDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_warehouse_in_detail:仓库入库单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseInDetailServiceImp implements WarehouseInDetailService {
    @Autowired
    private WarehouseInDetailMapper warehouseInDetailMapper;
    @Autowired
    private WarehouseInService warehouseInService;
    //@Autowired
    //private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductUnitService productUnitService;
    @Autowired
    private ProductService productService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void save(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setCdate(new Date());
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.insert(warehouseInDetail);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void update(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.updateById(warehouseInDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void updateAll(WarehouseInDetail warehouseInDetail) throws Exception{
        warehouseInDetail.setUdate(new Date());
        warehouseInDetailMapper.updateAllColumnById(warehouseInDetail);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseInDetailMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseInDetailMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseInDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    @Override
    public List<WarehouseInDetail> dataList(PageData pd) throws Exception{
        return warehouseInDetailMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<WarehouseInDetail> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseInDetail> warehouseInDetailList =  warehouseInDetailMapper.selectByMap(columnMap);
        return warehouseInDetailList;
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseInDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return warehouseInDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    @Override
    public void updateStateByDetail(PageData pd) throws Exception{
        warehouseInDetailMapper.updateStateByDetail(pd);
    }

    public WarehouseInDetail findWarehouseInDetail(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInDetail> objectList = this.findWarehouseInDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public WarehouseInDetail findWarehouseInDetailById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInDetail(findMap);
    }

    public List<WarehouseInDetail> findWarehouseInDetailList(PageData object) {
        if (object == null) {return null;}

        List<WarehouseInDetail> objectList = new ArrayList<WarehouseInDetail>();
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectList;
    }
    public List<WarehouseInDetail> findWarehouseInDetailListByParentId(String parentId) {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findWarehouseInDetailList(findMap);
    }

    public List<WarehouseInDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseInDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInDetail detail = (WarehouseInDetail)HttpUtils.pageData2Entity(mapObject, new WarehouseInDetail());

            try {
                //获取当前货品id的计量单位
                PageData findMap = new PageData();
                findMap.put("productId", detail.getProductId());
                //单位类型 (1:计量单位 0:计价单位)
                findMap.put("type", "1");
                //是否禁用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                ProductUnit productUnit = productUnitService.findProductUnit(findMap);
                if (productUnit != null && productUnit.getUnit() != null) {
                    detail.setProductUnit(productUnit.getUnit().trim());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            //计价单位转换计量单位
            //p2nFormula 计价转换计量单位 数量转换公式 pn_formula
            String p2nFormula = "";
            if (mapObject.get("p2nFormula") != null && mapObject.get("p2nFormula").toString().trim().length() > 0) {
                p2nFormula = mapObject.get("p2nFormula").toString().trim();
            }

            //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
            String p2nIsScale = new String();
            if (mapObject.get("p2nIsScale") != null) {
                p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
            }

            //小数位数 (最小:0位 最大:4位)
            Integer p2nDecimalCount = Integer.valueOf(2);
            String p2nDecimalCountStr = mapObject.get("p2nDecimalCount");
            if (p2nDecimalCountStr != null) {
                try {
                    p2nDecimalCount = Integer.valueOf(p2nDecimalCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //货品(计价单位)数量
            BigDecimal priceCount = BigDecimal.valueOf(0D);
            String priceCountStr = mapObject.get("priceCount");
            if (priceCountStr != null) {
                try {
                    priceCount = new BigDecimal(priceCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            detail.setPriceCount(priceCount);

            //货品(计量单位)数量
            BigDecimal productCount = EvaluateUtil.countFormulaP2N(priceCount, p2nFormula);
            productCount = StringUtil.scaleDecimal(productCount, p2nIsScale, p2nDecimalCount);
            detail.setProductCount(productCount);
            detail.setCount(productCount);

            //货品价格
            String priceStr = mapObject.get("price");
            if (priceStr != null && priceStr.trim().length() > 0) {
                try {
                    BigDecimal price = new BigDecimal(priceStr);
                    //四舍五入到2位小数
                    price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    detail.setPrice(price);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            objectList.add(detail);
        }

        return objectList;
    }

    public List<WarehouseInDetailEntity> mapList2DetailEntityList(List<Map<String, String>> mapList, List<WarehouseInDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<WarehouseInDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            WarehouseInDetailEntity detail = (WarehouseInDetailEntity)HttpUtils.pageData2Entity(mapObject, new WarehouseInDetailEntity());
            objectList.add(detail);
        }

        return objectList;
    }
//    public WarehouseInDetail warehouseInDtl2QRCodeObj(WarehouseInDetail warehouseInDtl, WarehouseInDetail QRCodeObj) {
//        if (QRCodeObj == null) {QRCodeObj = new WarehouseInDetail();}
//        if (warehouseInDtl == null) {return QRCodeObj;}
//
//        QRCodeObj.setProductId(warehouseInDtl.getProductId());
//        QRCodeObj.setWarehouseId(warehouseInDtl.getWarehouseId());
//        QRCodeObj.setCode(warehouseInDtl.getCode());
//
//        return QRCodeObj;
//    }

    /**
     * 获取入库货品批次二维码 {code:货位批次号,productId:货品id,productName:货品名称}
     *
     * @param warehouseInDtl 入库明细对象
     * @return
     */
    public String warehouseInDtl2QRCode(WarehouseInDetail warehouseInDtl) {
        if (warehouseInDtl == null) {return new String();}
        Map<String, String> QRCodeMap = new HashMap<String, String>();

        QRCodeMap.put("code", "");
        if (warehouseInDtl.getCode() != null && warehouseInDtl.getCode().trim().length() > 0) {
            QRCodeMap.put("code", warehouseInDtl.getCode().trim());
        }

        //QRCodeMap.put("productId", "");
        if (warehouseInDtl.getProductId() != null && warehouseInDtl.getProductId().trim().length() > 0) {
            String productId = warehouseInDtl.getProductId().trim();
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

    public List<Map<String, String>> findWarehouseInMapList(String companyId, String productId, String code) {
        List<Map<String, String>> inList = new ArrayList<Map<String, String>>();

        PageData findMap = new PageData();
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("companyId", companyId);
        }
        findMap.put("productId", productId);
        findMap.put("code", code);

        List<Map<String, Object>> mapList = null;
        try {
            mapList = warehouseInDetailMapper.findWarehouseInMapList(findMap);
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {return inList;}

        for (Map<String, Object> mapObject : mapList) {
            Map<String, String> mapObj = new HashMap<String, String>();

            //入库单明细id detailId
            mapObj.put("detailId", (String)mapObject.get("detailId"));

            //入库单id parentId
            String parentId = new String();
            if (mapObject.get("parentId") != null) {
                parentId = mapObject.get("parentId").toString().trim();
            }
            mapObj.put("parentId", parentId);


            //入库单编号 parentCode
            String parentCode = new String();
            if (mapObject.get("parentCode") != null) {
                parentCode = mapObject.get("parentCode").toString().trim();
            }
            mapObj.put("parentCode", parentCode);

            //入库数量 detailCount
            String detailCount = new String("0");
            BigDecimal detailCount_big = BigDecimal.valueOf(0D);
            if (mapObject.get("detailCount") != null) {
                String detailCount_str = mapObject.get("detailCount").toString().trim();
                try {
                    detailCount_big = new BigDecimal(detailCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                if (detailCount_big.doubleValue() != 0) {
                    //四舍五入到2位小数
                    detailCount_big = detailCount_big.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    detailCount = detailCount_big.toString();
                }
            }
            mapObj.put("detailCount", detailCount);
            mapObj.put("type", "in");

            inList.add(mapObj);
        }

        return inList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String checkDispatcheDetailList(List<WarehouseInDetailEntity> objectList) {
        if (objectList == null || objectList.size() == 0) {
            return new String("请至少选择一条明细！");
        }

        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < objectList.size(); i++) {
            WarehouseInDetailEntity detail = objectList.get(i);
            if (detail.getWarehouseId() == null || detail.getWarehouseId().trim().length() == 0) {
                msgBuf.append("第 " + (i+1) + " 行：推荐库位为空，推荐库位必填项(系统无推荐货位，请指定或添加新货位)");
            }
        }

        return msgBuf.toString();
    }

    @Override
    public void addWarehouseInDetail(String parentId, String cuser, String companyId, List<WarehouseInDetail> objectList) throws Exception {
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseInDetail detail : objectList) {
            detail.setId(Conv.createUuid());

            //获取批次号
            //PC+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(companyId,
                    "vmes_product_pc",
                    "yyyyMMdd",
                    "PC");

            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentId);
            detail.setCuser(cuser);
            detail.setCode(code);

            //生成二维码
            String QRCodeJson = this.warehouseInDtl2QRCode(detail);
            String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                detail.setQrcode(qrcode);
            }

            this.save(detail);
        }
    }

    public void addWarehouseInDetail(WarehouseIn parentObj, List<WarehouseInDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseInDetail detail : objectList) {
            detail.setId(Conv.createUuid());

            //获取批次号
            //PC+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(parentObj.getCompanyId(),
                    "vmes_product_pc",
                    "yyyyMMdd",
                    "PC");

            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            detail.setCode(code);

            //生成批次号二维码(批次号,产品ID,产品名称)
            String QRCodeJson = this.warehouseInDtl2QRCode(detail);
            String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                detail.setQrcode(qrcode);
            }

            this.save(detail);
        }
    }

    public void addWarehouseInDetailBySimple(WarehouseIn parentObj, List<WarehouseInDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseInDetail detail : objectList) {
            detail.setId(Conv.createUuid());

            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            //detail.setWarehouseId(parentObj.getWarehouseId());

            //获取批次号
            //PC+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(parentObj.getCompanyId(),
                    "vmes_product_pc",
                    "yyyyMMdd",
                    "PC");
            detail.setCode(code);

            //生成批次号二维码(批次号,产品ID,产品名称)
            String QRCodeJson = this.warehouseInDtl2QRCode(detail);
            String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                detail.setQrcode(qrcode);
            }

            this.save(detail);
        }
    }

    //创建入库单(简版仓库)--执行时无需人工干预-系统自动执行
    public void addWarehouseInDetailExecuteBySimple(WarehouseIn parentObj, List<WarehouseInDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (WarehouseInDetail detail : objectList) {
            detail.setId(Conv.createUuid());

            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("2");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());
            //detail.setWarehouseId(parentObj.getWarehouseId());

            //获取批次号
            //PC+yyyyMMdd+00001 = 15位
            String code = coderuleService.createCoderCdateByDate(parentObj.getCompanyId(),
                    "vmes_product_pc",
                    "yyyyMMdd",
                    "PC");
            detail.setCode(code);

            //生成批次号二维码(批次号,产品ID,产品名称)
            String QRCodeJson = this.warehouseInDtl2QRCode(detail);
            String qrcode = fileService.createQRCode("warehouseIn", QRCodeJson);
            if (qrcode != null && qrcode.trim().length() > 0) {
                detail.setQrcode(qrcode);
            }

            this.save(detail);
        }
    }

    public void executeWarehouseInDetailBySimple(WarehouseIn warehouseIn, List<WarehouseInDetail> detailList) throws Exception {
        if (detailList == null || detailList.size() == 0) {return;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (int i = 0; i < detailList.size(); i++) {
                WarehouseInDetail object = detailList.get(i);

                String detailId = object.getId();
                BigDecimal count = object.getCount();
                String warehouseId = object.getWarehouseId();
                String productId = object.getProductId();
                String code = object.getCode();

                //入库操作
                WarehouseProduct inObject = new WarehouseProduct();
                //货位批次号
                inObject.setCode(code);
                //产品ID
                inObject.setProductId(productId);
                //(实际)货位ID
                inObject.setWarehouseId(warehouseId);

                //库存变更日志
                String executeId = Conv.createUuid();

                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(warehouseIn.getId());
                loginfo.setDetailId(detailId);
                loginfo.setExecuteId(executeId);
                loginfo.setCompanyId(warehouseIn.getCompanyId());
                loginfo.setCuser(warehouseIn.getCuser());
                //operation 操作类型(add:添加 modify:修改 delete:删除:)
                loginfo.setOperation("add");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(count);

                String msgStr = warehouseProductService.inStockCount(inObject, count, loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                } else {
                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
                    productService.updateStockCount(product, prodStockCount, warehouseIn.getCuser(), "in");
                }
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                throw new ApplicationException("系统繁忙请稍后再次操作");
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            throw new ApplicationException(msgBuf.toString());
        }

        //修改入库单明细状态
        PageData mapDetail = new PageData();
        mapDetail.put("parentId", warehouseIn.getId());
        //明细状态:state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapDetail.put("state", "2");
        this.updateStateByDetail(mapDetail);

        //修改入库单状态
        //state:状态(0:未完成 1:已完成 -1:已取消)
        WarehouseIn warehouseInEdit = new WarehouseIn();
        warehouseInEdit.setId(warehouseIn.getId());
        warehouseInEdit.setState("1");
        warehouseInService.update(warehouseInEdit);
    }

    /**
     * 修改入库单明细状态(vmes_warehouse_in_detail)
     * state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * 入库执行明细(vmes_warehouse_in_execute)
     *     按照(detail_id:入库明细ID)汇总求和(count:当前入库数量)
     * 汇总数量 >= 入库数量  state:2:已完成
     *
     * @param detailList
     */
//    public void updateStateWarehouseInDetail(List<WarehouseInDetail> detailList) throws Exception {
//        if (detailList == null || detailList.size() == 0) {return;}
//
//        //入库单ID
//        String parentId = detailList.get(0).getParentId();
//
//        //1. 根据(入库单ID)查询条件，获取仓库入库执行明细表-按照(入库明细ID)汇总求和
//        Map<String, BigDecimal> mapObject = warehouseInExecuteService.findExecuteCountByParentId(parentId);
//
//        //2. 修改入库单明细状态(vmes_warehouse_in_detail)
//        for (WarehouseInDetail detail : detailList) {
//            String detailId = detail.getId();
//            BigDecimal executeCount = mapObject.get(detailId);
//
//            //state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//            if (executeCount != null && detail.getCount() != null && executeCount.doubleValue() >= detail.getCount().doubleValue()) {
//                detail.setState("2");
//            } else if (executeCount != null && detail.getCount() != null && executeCount.doubleValue() < detail.getCount().doubleValue()) {
//                detail.setState("1");
//            }
//
//            this.update(detail);
//        }
//
//        //3. 反写入库单(vmes_warehouse_in)状态
//        WarehouseIn warehouseIn = new WarehouseIn();
//        warehouseIn.setId(parentId);
//        this.updateParentStateByDetailList(warehouseIn, detailList, null);
//    }


    /**
     * 根据入库单明细状态-反写入库单状态
     * 入库单状态(0:未完成 1:已完成 -1:已取消)
     * 入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     *
     * @param parent       入库单对象
     * @param dtlList      入库单明细List<WarehouseInDetail>
     * @param ignoreState  忽视状态
     */
    public void updateParentStateByDetailList(WarehouseIn parent, List<WarehouseInDetail> dtlList, String ignoreState) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findWarehouseInDetailListByParentId(parent.getId());
        }

        if (dtlList.size() == 0) {
            warehouseInService.deleteById(parent.getId());
        } else {
            //获取入库单状态-根据入库单明细状态
            String parentState = this.findParentStateByDetailList(ignoreState, dtlList);
            parent.setState(parentState);
            warehouseInService.update(parent);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 入库单明细状态，在入库单明细List<WarehouseInDetail>中是否全部相同
     *   true : 全部相同，在入库单明细List
     *   false: 一条或多条不同，在入库单明细List
     *
     * @param state       明细状态-入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     * @param ignoreState 忽视状态(允许为空)
     * @param objectList  入库单明细List<WarehouseInDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseInDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        if ("-1".equals(state)) {state = "c";}
        if ("-1".equals(ignoreState)) {ignoreState = "c";}

        for (WarehouseInDetail object : objectList) {
            String dtl_state = object.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if ("-1".equals(dtl_state)) {dtl_state = "c";}

            //忽视状态:判断与明细状态 相同则继续执行循环
            if (ignoreState != null && ignoreState.trim().length() > 0 && ignoreState.indexOf(dtl_state) != -1) {continue;}

            if (state.indexOf(dtl_state) == -1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取入库单状态-根据入库单明细状态
     * 入库单状态(0:未完成 1:已完成 -1:已取消)
     * 入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     *
     * @param ignoreState  忽视状态
     * @param dtlList      入库单明细List<WarehouseInDetail>
     * @return
     */
    public String findParentStateByDetailList(String ignoreState, List<WarehouseInDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证入库单状态(1:已完成) --> 全部明细状态 (2:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "2";
        if (this.isAllExistStateByDetailList(checkDtlState, ignoreState, dtlList)) {
            return "1";
        }

        //2. 验证入库单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, null, dtlList)) {
            return "-1";
        }

        return parentState;
    }

    @Override
    public ResultModel listPageWarehouseInDetail(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
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
        pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {

                //priceCount 计价单位数量
                BigDecimal priceCount = BigDecimal.valueOf(0D);
                if (mapObject.get("priceCount") != null) {
                    priceCount = (BigDecimal)mapObject.get("priceCount");
                }

                //n2pIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String n2pIsScale = new String();
                if (mapObject.get("n2pIsScale") != null) {
                    n2pIsScale = mapObject.get("n2pIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer n2pDecimalCount = Integer.valueOf(2);
                if (mapObject.get("n2pDecimalCount") != null) {
                    n2pDecimalCount = (Integer)mapObject.get("n2pDecimalCount");
                }
                priceCount = StringUtil.scaleDecimal(priceCount, n2pIsScale, n2pDecimalCount);
                mapObject.put("priceCount", priceCount.toString());

                //count 入库数量(计量单位)
                BigDecimal count = BigDecimal.valueOf(0D);
                if (mapObject.get("count") != null) {
                    count = (BigDecimal)mapObject.get("count");
                }
                //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String p2nIsScale = new String();
                if (mapObject.get("p2nIsScale") != null) {
                    p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer p2nDecimalCount = Integer.valueOf(2);
                if (mapObject.get("p2nDecimalCount") != null) {
                    p2nDecimalCount = (Integer)mapObject.get("p2nDecimalCount");
                }
                count = StringUtil.scaleDecimal(count, p2nIsScale, p2nDecimalCount);
                mapObject.put("count", count.toString());

                //executeCount 已完成数量(计量单位)
                BigDecimal executeCount = BigDecimal.valueOf(0D);
                if (mapObject.get("executeCount") != null) {
                    executeCount = (BigDecimal)mapObject.get("executeCount");
                }
                executeCount = StringUtil.scaleDecimal(executeCount, p2nIsScale, p2nDecimalCount);
                mapObject.put("executeCount", executeCount.toString());
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


    @Override
    public ResultModel listPageDetailProduct(PageData pd, Pagination pg) throws Exception {
        if(pg==null){
            pg =  HttpUtils.parsePagination(pd);
        }
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetailProduct");
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


        PageData findMap = new PageData();
        findMap.put("orderStr", "a.cdate asc");

        String type = pd.getString("type");
        if (!"edit".equals(type)) {
            findMap.put("queryStr", "1=2");
        } else {
            String parentId = pd.getString("parentId");
            findMap.put("parentId", parentId);
        }

        List<Map> varList = this.getDataListPage(findMap, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //priceCount 计价单位数量
                BigDecimal priceCount = BigDecimal.valueOf(0D);
                if (mapObject.get("priceCount") != null) {
                    priceCount = (BigDecimal)mapObject.get("priceCount");
                }

                //n2pIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String n2pIsScale = new String();
                if (mapObject.get("n2pIsScale") != null) {
                    n2pIsScale = mapObject.get("n2pIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer n2pDecimalCount = Integer.valueOf(2);
                if (mapObject.get("n2pDecimalCount") != null) {
                    n2pDecimalCount = (Integer)mapObject.get("n2pDecimalCount");
                }
                priceCount = StringUtil.scaleDecimal(priceCount, n2pIsScale, n2pDecimalCount);
                mapObject.put("priceCount", priceCount.toString());
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel cancelWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();


        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单已经(已完成)！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        this.update(detail);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }
        return model;
    }

    @Override
    public ResultModel recoveryWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不是取消状态，不可恢复！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        this.update(detail);

        //2. 反写入库单主表状态
        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }
        return model;
    }

    @Override
    public ResultModel deleteWarehouseInDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = this.findWarehouseInDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (checkState != null && "1,2".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单已经(已完成)！");
            return model;
        }

        //1. 删除入库明细
        this.deleteById(detailId);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            this.updateParentStateByDetailList(warehouseIn, null, null);
        }

        return model;
    }

    /**
     * 简版仓库-入库单明细查询
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel listPageWarehouseInDetailExecuteBySimple(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pageData);

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String firstFieldCode = pageData.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }
        Map<String, Object> firstTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //B. 第二级: 获取订单明细汇总查询
        columnList = columnService.findColumnList("warehouseInExecutorByAddExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String secondFieldCode = pageData.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }
        Map<String, Object> secondTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        Map result = new HashMap();
        result.put("hideTitles",firstTitleMap.get("hideTitles"));
        result.put("titles",firstTitleMap.get("titles"));

        //C. 查询第一层数据
        //String companyId = pageData.getString("currentCompanyId");
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pageData, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //count 入库数量(计量单位)-四舍五入(2位小数),
                BigDecimal count = BigDecimal.valueOf(0D);
                if (mapObject.get("count") != null) {
                    count = (BigDecimal)mapObject.get("count");
                }
                count = StringUtil.scaleDecimal(count, Common.SYS_ISSCALE_TRUE, Integer.valueOf(Common.SYS_NUMBER_FORMAT_2));
                mapObject.put("count", count.toString());

                //executeCount 已完成数量(计量单位)-四舍五入(2位小数),
                BigDecimal executeCount = BigDecimal.valueOf(0D);
                if (mapObject.get("executeCount") != null) {
                    executeCount = (BigDecimal)mapObject.get("executeCount");
                }
                executeCount = StringUtil.scaleDecimal(executeCount, Common.SYS_ISSCALE_TRUE, Integer.valueOf(Common.SYS_NUMBER_FORMAT_2));
                mapObject.put("executeCount", executeCount.toString());
            }
        }
        if (varList != null && varList.size() > 0) {
            PageData findMap = new PageData();
            //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
            findMap.put("pid", Common.DICTIONARY_MAP.get("warehouseEntity"));
            findMap.put("companyId", companyId);
            //是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            findMap.put("isNotNeedSpare", "true");
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);

            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)firstTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("hideTitles", secondTitleMap.get("hideTitles"));
                varMap.put("titles", secondTitleMap.get("titles"));
                varMap.put("pid", null);

                //查询第二层数据
                List<Map> secondList = this.findSecondList(map, companyId, warehouseList);
                if(secondList != null && secondList.size() > 0) {
                    varMap.put("children", secondList);
                    varMapList.add(varMap);
                }
            }
        }

        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    private List<Map> findSecondList(Map firstRowMap, String companyId, List<Warehouse> warehouseList) throws Exception {
        //入库单明细参数
        String id = (String)firstRowMap.get("id");
        String productId = (String)firstRowMap.get("productId");

        //入库单明细-入库数量
        BigDecimal count = BigDecimal.valueOf(0D);
        String countStr = (String)firstRowMap.get("count");
        if (countStr != null && countStr.trim().length() > 0) {
            try {
                count = new BigDecimal(countStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            //四舍五入到2位小数
            count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        }

        List<Map> secondMapList = new ArrayList();
        if (warehouseList != null && warehouseList.size() > 0) {
            Warehouse object = warehouseList.get(0);
            String warehouseId = object.getId();
            //String pathName = object.getPathName();
            String name = object.getName();

            //(货位id,货品id)获取该货位货品库存数量
            BigDecimal stockCount = BigDecimal.valueOf(0D);
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("isNeedAll_productId", productId);
            findMap.put("warehouseIds", "'" + warehouseId + "'");
            List<Map> mapList = warehouseToWarehouseProductService.findWarehouseToWarehouseProductByProduct(findMap, null);
            if (mapList != null && mapList.size() > 0) {
                Map<String, Object> mapObj = mapList.get(0);
                if (mapObj != null && mapObj.get("stockCount") != null) {
                    stockCount = (BigDecimal)mapObj.get("stockCount");
                }
            }
            //四舍五入到2位小数
            stockCount = stockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //model_code = 'warehouseInExecutorByAddExecute'
            Map<String, String> secondMap = new HashMap<String, String>();
            secondMap.put("id", object.getId());
            secondMap.put("warehouseId", warehouseId);
            secondMap.put("detailId", id);
            secondMap.put("name", name);
            secondMap.put("count", count.toString());
            secondMap.put("stockCount", stockCount.toString());
            secondMapList.add(secondMap);
        }

        return secondMapList;
    }
}

