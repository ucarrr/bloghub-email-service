package com.patika.bloghubemailservice.listener;

import com.patika.bloghubemailservice.dto.request.EmailCreateRequest;
import com.patika.bloghubemailservice.listener.dto.SendEmailMessage;

import com.patika.bloghubemailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailListener {

    private final EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.email.queue}")
    public void listenEmail(SendEmailMessage emailMessage){
        log.info("email message received: {}", emailMessage);
        emailService.sendEmail(prepareEmailCreateRequest(emailMessage));
    }

    private EmailCreateRequest prepareEmailCreateRequest(SendEmailMessage emailMessage) {
        EmailCreateRequest emailCreateRequest = new EmailCreateRequest();
        emailCreateRequest.setEmailTemplate(emailMessage.getEmailTemplate());
        emailCreateRequest.setTo(emailMessage.getTo());
        return emailCreateRequest;

    }
}
