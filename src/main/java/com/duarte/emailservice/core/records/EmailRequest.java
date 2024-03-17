package com.duarte.emailservice.core.records;

public record EmailRequest(String to, String subject, String body) {
}
