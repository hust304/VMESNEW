package com.yvan.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class MailUtil {
    //private Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private static final int SIMPLE_MAIL = 1;
    private static final int HTML_MAIL = 2;

    private String host; //邮件服务器地址
    private String username; //邮件发送服务器上的有效帐号
    private String password; //邮件发送服务器上的有效密码
    private boolean authenticated; //登录邮件发送服务器时否需要进行验证
    private String protocol = "smtp"; //邮件发送服务器的所有协议，默认为SMPT

    private Authenticator authenticator;
    private Transport transport;
    private Session session;
    private List<File> attachments = new ArrayList<File>(); //对应的邮件附件
    List<File> newFiles = new ArrayList<File>();//保存原有文件的文件名

    private String[] to; //邮件接收人数组
    private String[] cc; //邮件抄送人
    private String[] bcc; //邮件密件抄送人
    private String from; //邮件发送人
    private String subject; //邮件主题

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Transport getTransport() {
        return transport;
    }

    public Session getSession() {
        return session;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public void setTo(String to) {
        this.to = new String[] {to};
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public void setCc(String cc) {
        this.cc = new String[] {cc};
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = new String[] {bcc};
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void addAttachment(File attachment) {
        this.attachments.add(attachment);
    }

    public void addNewFiles(File attachment) {
        this.newFiles.add(attachment);
    }

    public MailUtil() {}
    /**
     * 构造一个邮件发送器
     * @param host 邮件服务器地址
     * @param username 邮件服务器上有效的帐号
     * @param password 邮件服务器上有效的密码
     * @param authenticated 邮件服务器是否需要验证，一般为true
     * @throws Exception
     */
    public MailUtil(
            String host,
            String username,
            String password,
            boolean authenticated) throws Exception {
        this.host = host;
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;

        if(this.authenticated) {
            this.authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(getUsername(), getPassword());
                }
            };
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", this.host);
        String authod = "true";
        if(! this.authenticated) {
            authod = "false";
        }
        props.put("mail.smtp.auth", authod);

        session = Session.getInstance(props, authenticator);//Access to default session denied 错误
        transport = session.getTransport(this.protocol);
        transport.connect(host, username, password);
    }

    public void close() {
        try {
            this.transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMessage(String content, String contentType, int mailType) throws Exception {
        if(this.from == null) {
            throw new Exception("not set from field.");
        }

        if(this.to == null) {
            throw new Exception("not set to field.");
        }

        MimeMessage message = new MimeMessage(session);

        if(this.from != null) {
            message.setFrom(new InternetAddress(from));
        }

        InternetAddress[] icc = new InternetAddress[to.length];
        if(this.to != null) {
            for(int i = 0; i < to.length; i++) {
                icc[i] = new InternetAddress(to[i]);
            }
            message.setRecipients(Message.RecipientType.TO, icc);
        }

        if(this.cc != null) {
            icc = new InternetAddress[cc.length];
            for(int i = 0; i < cc.length; i++) {
                icc[i] = new InternetAddress(cc[i]);
            }
            message.setRecipients(Message.RecipientType.CC, icc);
        }

        if(this.bcc != null) {
            icc = new InternetAddress[bcc.length];
            for(int i = 0; i < bcc.length; i++) {
                icc[i] = new InternetAddress(bcc[i]);
            }
            message.setRecipients(Message.RecipientType.BCC, icc);
        }

        if(this.subject != null) {
            //message.setSubject(this.subject);
            message.setSubject(MimeUtility.encodeText(this.subject,"UTF-8","B"));
        }

        Multipart multipart = new MimeMultipart();

        //set message body part
        BodyPart bodyPart = new MimeBodyPart();
        if(mailType == SIMPLE_MAIL) {
            bodyPart.setText(content); //发送简单文本邮件
        } else if(mailType == HTML_MAIL) {
            bodyPart.setContent(content, contentType);
        }
        multipart.addBodyPart(bodyPart); //add message body part
        //set attchment part
        for(File attachment : attachments) {
            if(attachment != null && attachment.exists()) {
                String path = attachment.getPath().toString();
                //去掉随机码
                String newPath = "";
                if(path.length()>7 && path.substring(6, 7).equals("_")) {
                    newPath = path.substring(0,path.lastIndexOf("\\")+1) + path.substring(path.lastIndexOf("\\")+1+7,path.length());
                } else {
                    newPath = path;
                }
                File newFile = new File(newPath);
                this.newFiles.add(newFile);
                attachment.renameTo(newFile);
                BodyPart attachmentPart = new MimeBodyPart();
                DataSource ds = new FileDataSource(newFile);
                attachmentPart.setDataHandler(new DataHandler(ds));
                //注意：下面定义的enc对象用来处理中文附件名，否则名称是中文的附//件在邮箱里面显示的会是乱码，
//	            sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
//	            attachmentPart.setFileName("=?UTF-8?B?"+enc.encode(newFile.getName().getBytes("utf-8"))+"?=");
                //第1个参数：附件名称，第2个参数：指定编码内容的字符集UTF-8，第3个参数：使用指定的base64方式编码。
                attachmentPart.setFileName(MimeUtility.encodeText(newFile.getName(),"UTF-8","B"));
                //attachmentPart.setFileName(attachment.getName());
                multipart.addBodyPart(attachmentPart);
            }
        }

        message.setContent(multipart); //put all parts into message
        return message;
    }

    public void sendSimpleMail(String content) throws Exception {
        this.transport.send(this.createMessage(content, null, SIMPLE_MAIL));
    }

    public void sendHtmlMail(String content, String contentType) throws Exception {
        this.transport.send(this.createMessage(content, contentType, HTML_MAIL));
        for(int i=0;i<newFiles.size();i++){
            if(newFiles.get(i).exists()){
                newFiles.get(i).renameTo(attachments.get(i));
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //TODO Email 邮件发送功能
    public static String mailSend(List<String> para) {
        try{
            String fromstr = Common.SYS_MAIL_SEND;//0:发送人 发送者
            if (para.get(0) != null && para.get(0).trim().length() > 0) {
                fromstr = para.get(0).trim();
            }

            String tostr = para.get(1); //主送者:
            String ccstr = para.get(2); //抄送者:
            String subjectstr = para.get(3); //邮件标题
            String content = para.get(4); //邮件体"<h1>Hello world!<br>sunjc,带2个附件</h1> <a href='mailto:sunjc@fiberhome.com.cn'>mail</a> <a href='http://www.fiberhome.com.cn'>fiberhome</a>  ";
            String attachmentstr = "";//附件路径，多个以|分割

            if (para.size()>= 6) {
                if (para.get(5).length()>0) {
                    attachmentstr = para.get(5);//"d:\\user.zip|d:\\processimage.jpg";
                } else {
                    attachmentstr = "";
                }
            }

//            if (para.size()>= 7) {
//                if (para.get(6).length()>0) {
//                    fromstr = para.get(6); //发送者
//                }
//            }

            //String mailserver = "smtp.163.com";220.181.12.16
            //String authuser = "chen_gang7906";
            //String authpass = "wdmzjcg79";
            //boolean authenticated = true;

            MailUtil sender = new MailUtil(
                    "220.181.12.16",
                    "chen_gang7906",
                    "wdmzjcg79",
                    true);
            if (tostr=="" || tostr == null) {
                return "false";
            }
            String[] ps = tostr.split("\\;");
            String[] to = new String[ps.length];
            for (int i = 0; i < ps.length; i++)
            {
                to[i] = ps [i];
            }
            sender.setTo(to);
            ps = ccstr.split("\\;");
            if (ps.length >0 && ccstr.length()>0 ) { //有抄送 sender.setCc("sunjc@fiberhome.com.cn");
                String[] cc = new String[ps.length];
                for (int i = 0; i < ps.length; i++)
                {
                    cc[i] = ps [i];
                }
                sender.setCc(cc);
            }
            if (subjectstr.length()==0) {
                sender.setSubject("邮件测试");
            } else {
                sender.setSubject(subjectstr);
            }

            if (content =="" || content == null) {
                content = "邮件测试";
            }

            sender.setFrom(fromstr);
            sender.setSubject(subjectstr);
            ps = attachmentstr.split("\\|");
            if (ps.length >0 && attachmentstr.length()>0  ) { //有附件
                File[] attachment = new File[ps.length]; //附件1
                for (int i = 0; i < ps.length; i++)
                {
                    attachment[i] = new File(ps[i]);
                    sender.addAttachment(attachment[i]);
                }
            }
            Thread senderThread = new MailSenderThread(sender,content);
            senderThread.start();
            return "true";
        } catch(Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 主方法,用于测试该类
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<String> mailpara = new ArrayList();
        mailpara.add("");// 0:发送人
        mailpara.add("chen_gang7906@163.com");// 1:主送
        mailpara.add("");// 2:抄送
        mailpara.add("**************测试2");// 3:标题
        mailpara.add("测试22222");// 4:内容
        // 5:附件
        //File attachment = new File("d:\\测试.txt"); //附件1
        //String attachmentstr=MimeUtility.decodeText("d:\\测试.txt");
        //String attachmentstr = "d:\\测试.txt";
        //mailpara.add(attachmentstr);

        MailUtil.mailSend(mailpara);
    }

}
