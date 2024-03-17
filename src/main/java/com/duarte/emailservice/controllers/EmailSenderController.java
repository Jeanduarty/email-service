package com.duarte.emailservice.controllers;

import com.amazonaws.AmazonServiceException;
import com.duarte.emailservice.application.EmailSenderUseCaseImpl;
import com.duarte.emailservice.core.records.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderUseCaseImpl emailSenderUseCaseImpl;

    @Autowired
    public EmailSenderController(EmailSenderUseCaseImpl emailSenderUseCaseImpl){
        this.emailSenderUseCaseImpl = emailSenderUseCaseImpl;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try {
            this.emailSenderUseCaseImpl.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email send successfully");
        } catch (AmazonServiceException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");

        }

    }
}