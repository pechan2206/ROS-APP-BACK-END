package com.example.back_end.dto;

public class LoginResponse {
    private String token;
    private String tipo = "Bearer";
    private String usuario;
    private Long id;
    private String rol;

    public LoginResponse(String token, String usuario, Long id, String rol) {
        this.token = token;
        this.usuario = usuario;
        this.id = id;
        this.rol = rol;
    }

    // getters y setters
}

