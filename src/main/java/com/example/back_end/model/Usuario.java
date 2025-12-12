package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo")   // Seguridad a nivel BD
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    // ------------------------------
    // NOMBRE
    // ------------------------------
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    // ------------------------------
    // APELLIDO
    // ------------------------------
    @Size(max = 100, message = "El apellido no puede superar 100 caracteres")
    @Column(length = 100)
    private String apellido;

    // ------------------------------
    // CORREO
    // ------------------------------
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    @Size(max = 100, message = "El correo no puede superar 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    // ------------------------------
    // TELÉFONO
    // ------------------------------
    @Pattern(regexp = "^3\\d{9}$", message = "El teléfono debe iniciar con 3 y tener 10 dígitos")
    @Column(nullable = false, length = 10, unique = true)
    private String telefono;


    // ------------------------------
    // CONTRASEÑA
    // ------------------------------
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 255, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(nullable = false, length = 255)
    private String contrasena;

    // ------------------------------
    // ESTADO
    // ------------------------------
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private EstadoUsuario estado = EstadoUsuario.Activo;

    public enum EstadoUsuario { Activo, Inactivo }

    // ------------------------------
    // FECHA REGISTRO
    // ------------------------------
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // ------------------------------
    // ROL
    // ------------------------------
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
}
