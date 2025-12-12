package com.example.back_end.service.implement;

import com.example.back_end.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreo(String destino, String asunto, String mensaje) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destino);
        email.setSubject(asunto);
        email.setText(mensaje);

        // Enviar el correo
        mailSender.send(email);

        System.out.println("📧 Correo enviado a " + destino);
    }

    @Override
    public void enviarCorreo(List<String> destinos, String asunto, String mensaje) {
        for (String destino : destinos) {
            enviarCorreo(destino, asunto, mensaje);
        }
    }
}
