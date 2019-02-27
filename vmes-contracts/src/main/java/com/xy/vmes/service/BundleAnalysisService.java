package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.BomTree;
import com.xy.vmes.entity.TreeEntity;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：操作日志 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-09-29
*/
public interface BundleAnalysisService {


    ResultModel getBomTreeProduct(PageData pd) throws Exception;
}



