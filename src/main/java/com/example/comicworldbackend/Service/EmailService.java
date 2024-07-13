package com.example.comicworldbackend.Service;

import com.example.comicworldbackend.Pojo.EmailRequest;

public interface EmailService {
    void sendCustomerConfirmationEmail(EmailRequest emailRequest);
    void resetPassword(EmailRequest emailRequest);

}
