package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metodos_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo")
    private Integer idMetodo;

    @NotBlank(message = "El nombre del método de pago es obligatorio")
    @Size(max = 100, message = "El nombre puede tener como máximo 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;
}
