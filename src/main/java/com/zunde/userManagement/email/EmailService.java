package com.zunde.userManagement.email;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Service
@AllArgsConstructor

public class EmailService implements EmailSender {

  private final JavaMailSender javaMailSender;

   private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);


    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Please Confirm your email");
            helper.setFrom("management@zunde.co");
            javaMailSender.send(mimeMessage);

        }catch (MessagingException exception){
            LOGGER.error("failed to send email", exception);
            throw new IllegalStateException("failed to send email");
        }

    }
}
