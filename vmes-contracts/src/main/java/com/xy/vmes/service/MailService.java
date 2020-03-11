package com.xy.vmes.service;

public interface MailService {
    /**
     *
     * @param subject    邮件主题
     * @param content    邮件内容
     * @param toWho      主送人 ';'分隔的字符串
     * @param ccPeoples  抄送人 ';'分隔的字符串
     */
    void sendSimpleMail(String subject, String content, String toWho, String ccPeoples);
}
