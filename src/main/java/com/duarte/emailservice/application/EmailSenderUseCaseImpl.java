package com.duarte.emailservice.application;

import com.duarte.emailservice.adapters.EmailSenderGateway;
import com.duarte.emailservice.core.cases.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderUseCaseImpl implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderUseCaseImpl(EmailSenderGateway emailSenderGateway){
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);

    }
}
