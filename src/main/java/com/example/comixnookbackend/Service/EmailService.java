package com.example.comixnookbackend.Service;

import com.example.comixnookbackend.Pojo.EmailRequest;

public interface EmailService {
    void sendCustomerConfirmationEmail(EmailRequest emailRequest);
    void resetPassword(EmailRequest emailRequest);

}
