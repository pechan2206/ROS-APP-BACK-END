package com.example.back_end.service;

public interface EmailService {
    void enviarCorreo(String destino, String asunto, String mensaje);
}
