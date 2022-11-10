package com.on.mail.On.services;

import com.on.mail.On.enums.StatusEmail;
import com.on.mail.On.models.EmailModel;
import com.on.mail.On.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailModel sendEmail(EmailModel emailModel){
         emailModel.setSendDateEmail(LocalDateTime.now());
         try{
             SimpleMailMessage message = new SimpleMailMessage();
             message.setFrom(emailModel.getEmailFrom());
             message.setTo(emailModel.getEmailTo());
             message.setSubject(emailModel.getSubject());
             message.setText(emailModel.getText());
             javaMailSender.send(message);

             emailModel.setStatusEmail(StatusEmail.SENT);
         }catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
         } finally {
             return emailRepository.save(emailModel);
         }

    }
}
