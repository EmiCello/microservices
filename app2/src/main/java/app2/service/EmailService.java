package app2.service;

import app2.domains.EmailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailInfo emailInfo) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("8472a372031c68");
        mailSender.setPassword("944ab9d3d61f0d");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("test@test.com");
        mailMessage.setTo(emailInfo.getEmail());
        mailMessage.setSubject("You've got a new email from " + emailInfo.getName() );
        mailMessage.setText("Hello my friend!!!");

        mailSender.send(mailMessage);
    }
}