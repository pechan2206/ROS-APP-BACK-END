package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    private String nombre;

    @Column(length = 10, unique = true, nullable = false)
    @Pattern(
            regexp = "^3\\d{9}$",
            message = "El teléfono debe comenzar con 3 y tener 10 dígitos"
    )
    private String telefono;

    @Column(length = 100, nullable = false)
    @Email(message = "El correo debe ser válido")
    private String correo;

    @Column(length = 150, nullable = false)
    @Size(max = 150, message = "La dirección no puede superar los 150 caracteres")
    private String direccion;

    @Column(length = 100)
    @Size(max = 100, message = "La descripcion no puede ser mas de 100 caracteres")
    private String descripcion;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
