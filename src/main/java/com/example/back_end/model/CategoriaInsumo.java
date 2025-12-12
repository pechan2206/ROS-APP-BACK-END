package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias_insumo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_insumo")
    private Integer idCategoriaInsumo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Size(max = 200, message = "La descripción no puede superar los 200 caracteres")
    @Column(length = 200)
    private String descripcion;
}
