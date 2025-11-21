package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insumos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo")
    private Integer idInsumo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column
    private Double cantidad;

    @Column(name = "unidad_medida", length = 50)
    private String unidadMedida;

    @ManyToOne
    @JoinColumn(name = "id_categoria_insumo")
    private CategoriaInsumo categoriaInsumo;
}
