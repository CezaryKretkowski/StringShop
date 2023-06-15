package com.example.StringShop.services.auth;

import com.example.StringShop.dtos.auth.AuthenticationRequest;
import com.example.StringShop.dtos.auth.AuthenticationResponse;
import com.example.StringShop.dtos.auth.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService  {
    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse  authenticate(AuthenticationRequest authRequest);
}
