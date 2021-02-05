package notification.service;

import notification.domains.EmailInfo;
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
        mailSender.setUsername("2e0ca958ae7a73");
        mailSender.setPassword("cd23c280218268");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("test@test.com");
        mailMessage.setTo(emailInfo.getEmail());
        mailMessage.setSubject("You've got a new email from " + emailInfo.getName() );
        mailMessage.setText("Hello my friend!!!");

        mailSender.send(mailMessage);
    }
}