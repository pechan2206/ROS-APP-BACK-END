package com.example.back_end.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Map.of("mensaje", e.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrity(DataIntegrityViolationException e) {
        String msg = e.getMessage() != null ? e.getMessage() : "";
        String mensaje;

        // Usuario
        if (msg.contains("usuarios") && msg.contains("correo")) {
            mensaje = "El correo ya está registrado en otro usuario";
        } else if (msg.contains("usuarios") && msg.contains("telefono")) {
            mensaje = "El teléfono ya está registrado en otro usuario";

        // Plato
        } else if (msg.contains("platos")) {
            mensaje = "Ya existe un plato con ese nombre";

        // Cliente
        } else if (msg.contains("clientes") && msg.contains("telefono")) {
            mensaje = "El teléfono ya está registrado en otro cliente";

        // Proveedor
        } else if (msg.contains("proveedores") && msg.contains("correo")) {
            mensaje = "El correo ya está registrado en otro proveedor";

        // Genérico
        } else {
            mensaje = "Ya existe un registro con ese dato, verifica los campos únicos";
        }

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(Map.of("mensaje", mensaje));
    }
}