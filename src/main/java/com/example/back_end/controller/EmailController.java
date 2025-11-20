package com.example.back_end.controller;

import com.example.back_end.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (puedes ajustarlo según sea necesario)
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Endpoint para enviar un correo en formato JSON
    @PostMapping("/enviar-json")
    public String enviarCorreoJson(@RequestBody EmailRequest request) {
        emailService.enviarCorreo(request.getDestino(), request.getAsunto(), request.getMensaje());
        return "Correo enviado correctamente";
    }
}

class EmailRequest {
    private String destino;
    private String asunto;
    private String mensaje;

    // Getters y Setters
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
