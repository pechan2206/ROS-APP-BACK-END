package com.example.back_end.controller;

import com.example.back_end.model.Usuario;
import com.example.back_end.repository.UsuarioRepository;
import com.example.back_end.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (puedes ajustarlo según sea necesario)
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Endpoint para enviar un correo en formato JSON
    @PostMapping("/enviar-json")
    public String enviarCorreoJson(@RequestBody EmailRequest request) {
        emailService.enviarCorreo(request.getDestino(), request.getAsunto(), request.getMensaje());
        return "Correo enviado correctamente";
    }

    @PostMapping("/enviar-a-usuarios")
    public String enviarCorreoAUsuarios(@RequestBody EmailRequest request) {

        // Obtener todos los emails de la tabla usuarios
        List<String> correos = usuarioRepository.findAll()
                .stream()
                .map(Usuario::getCorreo) // Asegúrate de que tu entidad Usuario tenga el campo email
                .toList();

        // Enviar el correo a todos
        emailService.enviarCorreo(correos, request.getAsunto(), request.getMensaje());

        return "Correos enviados a " + correos.size() + " usuarios";
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
