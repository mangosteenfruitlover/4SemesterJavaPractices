package main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void send(Object value) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("sendTo@mail.com");
        message.setFrom("sendFrom@mail.ru");
        message.setSubject("Entity " + value.getClass().getSimpleName() + " has been saved");
        message.setText(value.toString());
        mailSender.send(message);
    }
}
