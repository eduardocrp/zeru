package com.eddev.zeru.controllers;

import javax.servlet.http.HttpServletResponse;

import com.eddev.zeru.securities.UserSpringSecurity;
import com.eddev.zeru.securities.utils.JWTUtil;
import com.eddev.zeru.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('COMMON_USER')")
    @PostMapping(value="/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSpringSecurity userSpringSecurity = userService.authenticated();
        String token = jwtUtil.generateToken(userSpringSecurity.getUsername());
        response.addHeader("Authorization", "Bearer " + token);

        return ResponseEntity.noContent().build();
    }
    
    
}
