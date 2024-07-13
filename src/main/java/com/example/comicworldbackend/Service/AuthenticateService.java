package com.example.comicworldbackend.Service;

import com.example.comicworldbackend.Pojo.AuthenticateRequest;
import com.example.comicworldbackend.Pojo.AuthenticationResponse;

public interface AuthenticateService {

    AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest);
}
