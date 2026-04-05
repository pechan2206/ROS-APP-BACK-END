package com.example.back_end.controller;

import com.example.back_end.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-json")
    public ResponseEntity<Map<String, String>> enviarCorreoJson(@RequestBody EmailRequest request) {
        Map<String, String> response = new HashMap<>();
        try {
            emailService.enviarCorreo(request.getDestino(), request.getAsunto(), request.getMensaje());
            response.put("status", "ok");
            response.put("mensaje", "Correo enviado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("mensaje", "Error al enviar el correo");
            response.put("detalle", e.getMessage());
            response.put("tipo", e.getClass().getSimpleName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

class EmailRequest {
    private String destino;
    private String asunto;
    private String mensaje;

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}