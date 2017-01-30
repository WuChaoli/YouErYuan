package com.youeryuan.test;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.youeryuan.utils.MailUtil;

public class MailJava {
	
	public static void main(String args[]) throws MessagingException
	{
        //创建正文内容
  		String userId = "434518591";
  		String identity = "parent";
  		String checkId = UUID.randomUUID().toString();
  		String mailContext1 ="<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+
							"<title>Insert title here</title>"+
							"</head>"+
							"<body>"+
							"<h3><font color=\"green\" align=\"center\">柚儿圆家长账户已成功注册，点击下列连接完成验证</font></h3>"+
							"<br><br>"+
							"<a href=\"http://localhost:8080/YouErYuan/Check/Mail?id="+userId+"&identity="+identity+"&checkId="+checkId+"\">点击链接</a>"+
							"</body>"+
							"</html>";
  		String mailContext ="<html>"+
							"<head>"+
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"+
							"<title>Insert title here</title>"+
							"</head>"+
							"<body>"+
							"柚儿圆喜欢你"+
							"</body>"+
							"</html>";
   
        String receivers[] = {"charliewu.chn@qq.com"};
        MailUtil.sendCheckEmail(receivers, "柚儿圆", mailContext);   
        //((JavaMailSender)mimeMailSender).send(mimeMessage);    
            
        System.out.println("发送成功");   
	}

}
