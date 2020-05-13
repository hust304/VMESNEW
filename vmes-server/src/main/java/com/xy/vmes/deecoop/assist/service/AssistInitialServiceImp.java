package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistInitialMapper;
import com.xy.vmes.service.AssistInitialService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 说明：:外协初始化 实现类
 * 创建人：陈刚
 * 创建时间：2020-05-13
 */
@Service
@Transactional(readOnly = false)
public class AssistInitialServiceImp implements AssistInitialService {
    @Autowired
    private AssistInitialMapper assistInitialMapper;

    public void deleteAssistByInitial(PageData pd) {
        assistInitialMapper.deleteAssistByInitial(pd);
    }
}
