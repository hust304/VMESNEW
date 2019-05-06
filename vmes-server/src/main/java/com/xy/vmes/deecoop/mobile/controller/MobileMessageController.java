package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.Message;
import com.xy.vmes.service.MessageService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class MobileMessageController {
    private Logger logger = LoggerFactory.getLogger(MobileMessageController.class);

    @Autowired
    private MessageService messageService;
    private Integer message_separate_length = Integer.valueOf(10);

    @PostMapping("/mobile/mobileMessage/findMessage")
    public ResultModel findMessage() throws Exception {
        logger.info("################/mobile/mobileMessage/findMessage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        PageData findMap = new PageData();
        String companyIds = "b6ff76cb95f711e884ad00163e105f05";
        String companyId = pageData.getString("currentCompanyId");
        if (companyId != null && companyId.trim().length() > 0) {
            companyIds = companyIds + "," + companyId.trim();
        }

        companyIds = "'" + companyIds.replace(",", "','") + "'";
        findMap.put("companyIds", companyIds);
        //是否发布(0:未发布 1:已发布)
        findMap.put("isShow", "1");
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");

        StringBuffer msgStrBuf = new StringBuffer();
        List<Map> messageList = messageService.findListMessage(findMap);
        if (messageList != null && messageList.size() > 0) {
            for (int i = 0; i < messageList.size(); i++) {
                Map objectMap = messageList.get(i);

                String title = (String)objectMap.get("title");
                String content = (String)objectMap.get("content");
                String message = title + ":" + content;

                String separate = this.findSeparate(this.message_separate_length);
                if (i < (messageList.size() - 1)) {
                    msgStrBuf.append(message).append(separate);
                } else if (i == (messageList.size() - 1)) {
                    msgStrBuf.append(message);
                }
            }
        }

        //System.out.println("sysMessage:" + msgStrBuf.toString());
        model.set("sysMessage", msgStrBuf.toString());

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileMessage/findMessage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileMessage/findListMessage")
    public ResultModel findListMessage() throws Exception {
        logger.info("################/mobile/mobileMessage/findListMessage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        PageData findMap = new PageData();
        String companyIds = "b6ff76cb95f711e884ad00163e105f05";
        String companyId = pageData.getString("currentCompanyId");
        if (companyId != null && companyId.trim().length() > 0) {
            companyIds = companyIds + "," + companyId.trim();
        }

        companyIds = "'" + companyIds.replace(",", "','") + "'";
        findMap.put("companyIds", companyIds);
        //是否发布(0:未发布 1:已发布)
        findMap.put("isShow", "1");
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");

        List<Map<String, String>> msgMapList = new ArrayList<Map<String, String>>();
        List<Map> messageList = messageService.findListMessage(findMap);
        if (messageList != null && messageList.size() > 0) {
            for (Map mapObj : messageList) {
                Map<String, String> msgMap = new HashMap<String, String>();

                String id = (String)mapObj.get("id");
                msgMap.put("id", id);

                String title = (String)mapObj.get("title");
                msgMap.put("title", title);

                msgMapList.add(msgMap);
            }
        }

        String messageJson = new String();
        if (msgMapList.size() > 0) {
            messageJson = YvanUtil.toJson(msgMapList);
        }

        //System.out.println("messageJson:" + messageJson);
        model.put("messageJson", messageJson);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileMessage/findListMessage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileMessage/findMessageContent")
    public ResultModel findMessageContent() throws Exception {
        logger.info("################/mobile/mobileMessage/findMessageContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        Message message = messageService.selectById(id);

        Map<String, String> messageMap = new HashMap<String, String>();
        if (message != null && message.getCdate() != null) {
            messageMap.put("cdate", DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT));

            String cdate_str = DateFormat.date2String(message.getCdate(), DateFormat.DEFAULT_DATE_FORMAT);
            if (cdate_str != null && cdate_str.trim().length() > 0) {
                messageMap.put("cdate", cdate_str);
            }
        }

        if (message != null && message.getContent() != null && message.getContent().trim().length() > 0) {
            messageMap.put("content", message.getContent());
        }

        String messageJson = new String();
        if (messageMap.size() > 0) {
            messageJson = YvanUtil.toJson(messageMap);
        }

        //System.out.println("messageJson:" + messageJson);
        model.put("messageJson", messageJson);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileMessage/findMessageContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    private String findSeparate(Integer length) {
        if (length == null || length.intValue() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < length.intValue(); i++) {
            strBuf.append("@");
        }

        return strBuf.toString();
    }
}
