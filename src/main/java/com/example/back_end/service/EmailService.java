package com.example.back_end.service;

import java.util.List;

public interface EmailService {
    void enviarCorreo(String destino, String asunto, String mensaje);
    void enviarCorreo(List<String> destinos, String asunto, String mensaje);
}
