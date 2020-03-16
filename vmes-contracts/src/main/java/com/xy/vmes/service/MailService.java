package com.xy.vmes.service;

import javax.mail.MessagingException;

public interface MailService {
    /**
     * 内容按文本发送邮件
     *
     * @param subject    邮件主题
     * @param content    邮件内容
     * @param toWho      主送人 ';'分隔的字符串
     * @param ccPeoples  抄送人 ';'分隔的字符串
     */
    void sendSimpleMail(String subject, String content, String toWho, String ccPeoples);

    /**
     * 内容按Html格式发送邮件
     *
     * @param subject    邮件主题
     * @param content    邮件内容
     * @param toWho      主送人 ';'分隔的字符串
     * @param ccPeoples  抄送人 ';'分隔的字符串
     */
    void sendHtmlMail(String subject, String content, String toWho, String ccPeoples) throws MessagingException;
}
