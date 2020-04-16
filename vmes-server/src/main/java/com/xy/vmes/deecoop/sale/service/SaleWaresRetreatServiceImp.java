package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleWaresRetreatMapper;
import com.xy.vmes.entity.SaleWaresRetreat;
import com.xy.vmes.entity.SaleWaresRetreatDetail;
import com.xy.vmes.service.*;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_sale_wares_retreat:无订单退货单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleWaresRetreatServiceImp implements SaleWaresRetreatService {
    @Autowired
    private SaleWaresRetreatMapper saleWaresRetreatMapper;
    @Autowired
    private SaleWaresRetreatDetailService waresRetreatDtlService;
    @Autowired
    private FinanceBillService financeBillService;

    @Autowired
    private WarehouseInCreateService warehouseInCreateService;

    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void save(SaleWaresRetreat object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleWaresRetreatMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public SaleWaresRetreat selectById(String id) throws Exception{
        return saleWaresRetreatMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<SaleWaresRetreat> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleWaresRetreat> warehouseCheckDetailList = saleWaresRetreatMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(SaleWaresRetreat object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(SaleWaresRetreat object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleWaresRetreatMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleWaresRetreatMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleWaresRetreatMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleWaresRetreatMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<SaleWaresRetreat> dataList(PageData pd) throws Exception {
        return saleWaresRetreatMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleWaresRetreatMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleWaresRetreatMapper.getDataListPage(pd, pg);
        }

        return mapList;
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
    public List<SaleWaresRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleWaresRetreat>();
        }

        return this.dataList(pageData);
    }

    public SaleWaresRetreat findWaresRetreat(PageData object) throws Exception {
        List<SaleWaresRetreat> objectList = this.findWaresRetreatList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleWaresRetreat findWaresRetreatById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findWaresRetreat(findMap);
    }
    public List<SaleWaresRetreat> findWaresRetreatList(PageData object) throws Exception  {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleWaresRetreat(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("saleWaresRetreat");
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

//        //设置查询排序方式
//        //pd.put("orderStr", "a.cdate asc");
//        String orderStr = pd.getString("orderStr");
//        if (orderStr != null && orderStr.trim().length() > 0) {
//            pd.put("orderStr", orderStr);
//        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String remarkParent = pageData.getString("remarkParent");

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户名称为必填项不可为空！");
            return model;
        }
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货类型为必填项不可为空！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        List<SaleWaresRetreatDetail> retreatDtlList = new ArrayList<>();
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                SaleWaresRetreatDetail retreatDtl = waresRetreatDtlService.jsonMap2RetreatDetail(mapObject, null);
                retreatDtlList.add(retreatDtl);
            }
        }

        //1. 创建(无订单)退货单表
        SaleWaresRetreat addRetreat = new SaleWaresRetreat();
        addRetreat.setCompanyId(companyId);
        addRetreat.setCustomerId(customerId);
        addRetreat.setType(type);
        addRetreat.setCuser(cuser);

        addRetreat.setRemark(new String());
        if (remarkParent != null) {
            addRetreat.setRemark(remarkParent.trim());
        }

        //(无订单)退货编号(系统生成)
        String sysCode = coderuleService.createCoderCdateOnShortYearByDate(companyId,
                "vmes_sale_wares_retreat",
                "R",
                Common.CODE_RULE_SALEWARESRETREAT_LENGTH_DEFAULT);
        addRetreat.setSysCode(sysCode);

        BigDecimal totalSum = waresRetreatDtlService.findRetreatTotalSum(retreatDtlList);
        addRetreat.setTotalSum(totalSum);

        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        addRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addRetreat.setState("1");
        }

        this.save(addRetreat);

        //2. 创建(无订单)退货单明细
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (SaleWaresRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(addRetreat.getId());
                addDetail.setCuser(cuser);
                addDetail.setState(addRetreat.getState());
                waresRetreatDtlService.save(addDetail);
            }
        }

        return model;
    }

    public ResultModel submitSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //1. 修改退货单明细状态
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        waresRetreatDtlService.updateStateByDetail("1", parentId);

        //2. 修改退货单状态
        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("1");
        this.update(editRetreat);

        return model;
    }

    public ResultModel rebackSubmitSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //1. 修改退货单明细状态
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        waresRetreatDtlService.updateStateByDetail("0", parentId);

        //2. 修改退货单状态
        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("0");
        this.update(editRetreat);

        return model;
    }

    public ResultModel updateSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String remarkParent = pageData.getString("remarkParent");

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户名称为必填项不可为空！");
            return model;
        }
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货类型为必填项不可为空！");
            return model;
        }

        //状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
        String parentState = "0";

        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            parentState = "1";
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //修改退货单明细
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                String id = mapObject.get("id");

                if (id == null || id.trim().length() == 0) {
                    SaleWaresRetreatDetail addDetail = waresRetreatDtlService.jsonMap2RetreatDetail(mapObject, null);
                    addDetail.setParentId(parentId);
                    addDetail.setCuser(cuser);
                    //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
                    addDetail.setState(parentState);
                    waresRetreatDtlService.save(addDetail);
                } else if (id != null && id.trim().length() > 0) {
                    SaleWaresRetreatDetail editDetail = new SaleWaresRetreatDetail();
                    editDetail.setId(id.trim());
                    editDetail = waresRetreatDtlService.jsonMap2RetreatDetail(mapObject, editDetail);
                    waresRetreatDtlService.update(editDetail);
                }
            }
        }

        String deleteIds = pageData.getString("deleteIds");
        if (deleteIds != null && deleteIds.trim().length() > 0) {
            deleteIds = StringUtil.stringTrimSpace(deleteIds);
            String[] delete_Ids = deleteIds.split(",");
            waresRetreatDtlService.deleteByIds(delete_Ids);
        }

        //修改退货单
        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        editRetreat.setCustomerId(customerId);
        editRetreat.setType(type);
        editRetreat.setRemark(new String());
        if (remarkParent != null) {
            editRetreat.setRemark(remarkParent.trim());
        }

        List<SaleWaresRetreatDetail> retreatDtlList = waresRetreatDtlService.findWaresRetreatDetailListByParentId(parentId);
        BigDecimal totalSum = waresRetreatDtlService.findRetreatTotalSum(retreatDtlList);
        editRetreat.setTotalSum(totalSum);
        editRetreat.setState(parentState);
        this.update(editRetreat);

        return model;
    }

    public ResultModel deleteSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //1. (退货单id)删除退货单明细
        Map<String, String> columnMap = new HashMap<>();
        columnMap.put("parent_id", parentId);
        waresRetreatDtlService.deleteByColumnMap(columnMap);

        //2. (退货单id)删除退货单
        this.deleteById(parentId);

        return model;
    }

    public ResultModel cancelSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //1. 修改退货单明细状态
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        waresRetreatDtlService.updateStateByDetail("-1", parentId);

        //2. 修改退货单状态
        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("-1");
        this.update(editRetreat);

        return model;
    }
    public ResultModel rebackCancelSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //1. 修改退货单明细状态
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        waresRetreatDtlService.updateStateByDetail("0", parentId);

        //2. 修改退货单状态
        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("0");
        this.update(editRetreat);

        return model;
    }

    public ResultModel auditPassSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
            return model;
        }

        String customerName = pageData.getString("customerName");
        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户id为空或空字符串！");
            return model;
        }
        SaleWaresRetreat retreatDB = this.findWaresRetreatById(parentId);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        editRetreat.setAuditId(cuser);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("2");

        //retreatDate 退货完成日期(yyyy-MM-dd)
        String dateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date retreatDate = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT);
        editRetreat.setRetreatDate(retreatDate);
        this.update(editRetreat);

        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        waresRetreatDtlService.updateStateByDetail("2", parentId);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<SaleWaresRetreatDetail> retreatDtlList = waresRetreatDtlService.findWaresRetreatDetailListByParentId(parentId);
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            //创建入库单
            Map<String, Map<String, Object>> productByInMap = waresRetreatDtlService.findProductMapByIn(retreatDtlList);
            if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                //退库方式:1:生成退库单: (生成复杂版入库单)
                //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                warehouseInCreateService.createWarehouseInBusinessByComplex(customerId,
                        customerName,
                        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyId,
                        //销售退货入库:81907167d5c8498692e6c4f3694c5cfa:saleRetreatIn:
                        Common.DICTIONARY_MAP.get("saleRetreatIn"),
                        null,
                        productByInMap);

            } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
                //退库方式:1:生成退库单: (生成简版入库单)
                //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                warehouseInCreateService.createWarehouseInBusinessBySimple(customerId,
                        customerName,
                        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyId,
                        //销售退货入库:81907167d5c8498692e6c4f3694c5cfa:saleRetreatIn:
                        Common.DICTIONARY_MAP.get("saleRetreatIn"),
                        null,
                        retreatDB.getSysCode(),
                        productByInMap);
            }

            //修改退货单明细(退货单明细(关联)入库单明细)
            for (SaleWaresRetreatDetail retreatDtl : retreatDtlList) {
                SaleWaresRetreatDetail editDetail = new SaleWaresRetreatDetail();
                editDetail.setId(retreatDtl.getId());

                String id = retreatDtl.getId();
                if (productByInMap != null && productByInMap.get(id) != null) {
                    Map<String, Object> producValueMap = productByInMap.get(id);

                    //inDtlId:   入库明细id
                    String inDtlId = (String)producValueMap.get("inDtlId");
                    editDetail.setInDetailId(inDtlId);
                }

                waresRetreatDtlService.update(editDetail);
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //SaleWaresRetreat retreatDB = this.findWaresRetreatById(parentId);
        String retreatType = retreatDB.getType();

        //退货类型(1:退货退款 2:退货换货)
        if ("1".equals(retreatType)) {
            //生成付款单
            BigDecimal retreatSum = BigDecimal.valueOf(0D);
            if (retreatDB != null && retreatDB.getTotalSum() != null) {
                retreatSum = retreatDB.getTotalSum();
            }
            editRetreat = this.selectById(parentId);
            String remark = "无订单退货单号："+editRetreat.getSysCode() ;
            //创建付款单
            financeBillService.addFinanceBillBySys(retreatDB.getId(),
                    retreatDB.getCompanyId(),
                    retreatDB.getCustomerId(),
                    cuser,
                    //type 单据类型 ( 0:收款单 1:付款单 2:减免单 3:退款单 4:发货账单 5:发退货账单 6:收货账单 7:收退货账单)
                    "5",
                    //业务属性 1:销售订单退货 2:销售无订单退货
                    "2",
                    retreatSum,
                    remark);
        }

        return model;
    }

    public ResultModel auditDisagreeSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退回原因为必填项不可为空！");
            return model;
        }

        SaleWaresRetreat editRetreat = new SaleWaresRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        editRetreat.setState("0");
        editRetreat.setRemark(remark);
        editRetreat.setAuditId(cuser);
        this.update(editRetreat);

        return model;
    }

}



