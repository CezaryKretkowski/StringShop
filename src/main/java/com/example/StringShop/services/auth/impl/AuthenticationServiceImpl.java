package com.example.StringShop.services.auth.impl;

import com.example.StringShop.dtos.auth.AuthenticationRequest;
import com.example.StringShop.dtos.auth.AuthenticationResponse;
import com.example.StringShop.dtos.auth.RegisterRequest;
import com.example.StringShop.entites.user.Role;
import com.example.StringShop.entites.user.User;
import com.example.StringShop.repositories.UserRepositories;
import com.example.StringShop.services.auth.JwtService;
import com.example.StringShop.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepositories userRepositories;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstName(registerRequest.firstName())
                .lastname(registerRequest.lastname())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.USER)
                .build();
        userRepositories.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new  AuthenticationResponse(jwtToken);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.email(),authRequest.password()));
        var user = userRepositories.findUserByEmail(authRequest.email()).orElseThrow(); // todo Exeception user not found
        var jwtToken = jwtService.generateToken(user);
        return new  AuthenticationResponse(jwtToken);
    }
}
