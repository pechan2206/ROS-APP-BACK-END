package com.example.back_end.service;

import com.example.back_end.dto.LoginRequest;
import com.example.back_end.dto.LoginResponse;
import com.example.back_end.dto.RegisterRequest;

public interface AuthService {


    String register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
