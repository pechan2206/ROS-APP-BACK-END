package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "correo")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @Column(length = 100)
    private String apellido;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Pattern(regexp = "^3\\d{9}$")
    @Column(nullable = false, length = 10, unique = true)
    private String telefono;

    @NotBlank
    @Size(min = 6, max = 255)
    @Column(nullable = false, length = 255)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private EstadoUsuario estado = EstadoUsuario.Activo;

    public enum EstadoUsuario {
        Activo, Inactivo
    }

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}