package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Size(max = 50, message = "El nombre del rol debe tener máximo 50 caracteres")
    @Column(nullable = false, length = 50, unique = true)
    private String nombre;

    @Size(max = 100, message = "La descripción debe tener máximo 100 caracteres")
    @Column(length = 100)
    private String descripcion;
}
