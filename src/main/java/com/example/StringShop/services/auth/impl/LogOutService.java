package com.example.StringShop.services.auth.impl;

import com.example.StringShop.services.auth.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogOutService implements LogoutHandler {
    private final JwtService jwtService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        String userEmail  = jwtService.extractUserName(jwt);
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() != null){
            SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
            SecurityContextHolder.clearContext();
        }

    }
}
