package com.example.comixnookbackend.Service;

import com.example.comixnookbackend.Pojo.AuthenticateRequest;
import com.example.comixnookbackend.Pojo.AuthenticationResponse;

public interface AuthenticateService {

    AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest);
}
