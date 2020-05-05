package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistSignDetailMapper;
import com.xy.vmes.entity.AssistSignDetail;
import com.xy.vmes.service.AssistOrderDetailQueryBySignService;
import com.xy.vmes.service.AssistSignDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_assist_sign_detail:外协签收单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-05-04
*/
@Service
@Transactional(readOnly = false)
public class AssistSignDetailServiceImp implements AssistSignDetailService {
    @Autowired
    private AssistSignDetailMapper assistSignDetailMapper;
    @Autowired
    private AssistOrderDetailQueryBySignService assistOrderDetailQueryBySignService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistSignDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistSignDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistSignDetail selectById(String id) throws Exception{
        return assistSignDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistSignDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistSignDetail> warehouseCheckDetailList = assistSignDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistSignDetail object) throws Exception{
        object.setUdate(new Date());
        assistSignDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistSignDetail object) throws Exception{
        object.setUdate(new Date());
        assistSignDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistSignDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistSignDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistSignDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistSignDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistSignDetail> dataList(PageData pd) throws Exception{
        return assistSignDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistSignDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistSignDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistSignDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistSignDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistSignDetail findAssistSignDetail(PageData object) throws Exception {
        List<AssistSignDetail> objectList = this.findAssistSignDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistSignDetail findAssistSignDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistSignDetail(findMap);
    }

    public List<AssistSignDetail> findAssistSignDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistSignDetail> findAssistSignDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findAssistSignDetailList(findMap);
    }

    /**
     * 获取签收单状态-根据签收单明细状态
     * 签收单单状态(1:检验中 2:已完成 -1:已取消)
     * 签收单明细状态(1:检验中 2:已完成 -1:已取消)
     *
     * @param objectList      外协签收单明细List<AssistSignDetail>
     * @return
     */
    public String findParentStateByDetailList(List<AssistSignDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}

        //签收单明细状态(1:检验中 2:已完成 -1:已取消)
        int jyz = 0; //1:检验中
        int ywc = 0; //2:已完成
        int yqx = 0; //-1:已取消

        if (objectList != null && objectList.size() > 0) {
            for (AssistSignDetail detail : objectList) {
                if ("-1".equals(detail.getState())) {
                    yqx = yqx + 1;
                } else if ("1".equals(detail.getState())) {
                    jyz = jyz + 1;
                } else if ("2".equals(detail.getState())) {
                    ywc = ywc + 1;
                }
            }
        }

        //签收单明细状态:-1:已取消 全是已取消状态  签收单状态:-1:已取消
        if (yqx > 0 && yqx == objectList.size()) {
            return "-1";

            //签收单明细状态:2:已完成(发货) 全是已完成  签收单状态:2:已完成
        } else if (ywc > 0 && yqx >= 0 && jyz == 0) {
            return "2";

            //签收单明细状态:1:检验中 一条或多条  签收单状态:1:检验中
        } else if (jyz > 0) {
            return "1";
        }

        return null;
    }

    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param objectList
     * @return
     */
    public Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> objectList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<String, Map<String, Object>>();
        if (objectList == null || objectList.size() == 0) {return productByInMap;}

        for (Map<String, String> objectMap : objectList) {
            //signDtlId 采购签收明细id
            String signDtlId = objectMap.get("signDtlId");

            //productId 货品id
            String productId = objectMap.get("productId");

            //count 签收数量(arriveCount) count := inCount 入库数量
            BigDecimal count = BigDecimal.valueOf(0D);
            String arriveCountStr = objectMap.get("arriveCount");
            if (arriveCountStr != null && arriveCountStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(arriveCountStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            Map<String, Object> productMap = new HashMap<>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", count);

            productByInMap.put(signDtlId, productMap);
        }

        return productByInMap;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        assistSignDetailMapper.updateStateByDetail(pageData);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistSignDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistSignDetail");
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

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

}



