package com.example.back_end.dto;

import com.example.back_end.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String telefono;
    private Rol rol; // o el ID del rol según tu implementación
}
