package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(length = 20)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Activo','Inactivo') DEFAULT 'Activo'")
    private EstadoUsuario estado;

    public enum EstadoUsuario { Activo, Inactivo }

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
