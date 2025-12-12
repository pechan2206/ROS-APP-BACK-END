package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "platos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato")
    private Integer idPlato;

    @NotBlank(message = "El nombre del plato es obligatorio")
    @Size(max = 100, message = "El nombre debe tener máximo 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 dígitos enteros y 2 decimales")
    @Column(nullable = false)
    private BigDecimal precio;

    @Size(max = 255, message = "La descripción debe tener máximo 255 caracteres")
    @Column(length = 255)
    private String descripcion;

    @Size(max = 255, message = "La ruta/URL de la imagen debe tener máximo 255 caracteres")
    @Column(length = 255)
    private String imagen;

    @NotNull(message = "La categoría del plato es obligatoria")
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaPlato categoriaPlato;
}
