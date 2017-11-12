//package fr.istic.m2il.weekendplanning.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;  
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Service;  
//
//@Service("mailService")
//public class ServiceMail{  
//	
//	@Autowired
//    private MailSender mailSender;  
//   
//    public void setMailSender(MailSender mailSender) {  
//        this.mailSender = mailSender;  
//    }  
//   
//    public void notify(String from, String to, String subject, String msg) {  
//        //creating message  
//        SimpleMailMessage message = new SimpleMailMessage();  
//        message.setFrom(from);  
//        message.setTo(to);  
//        message.setSubject(subject);  
//        message.setText(msg);  
//        //sending message  
//        mailSender.send(message);     
//    }  
//} 