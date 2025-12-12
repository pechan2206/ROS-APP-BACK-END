package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Min(0)
    @Column(nullable = false)
    private Double cantidad;

    @Column(name = "unidad_medida", length = 50)
    private String unidadMedida;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria_insumo", nullable = false)
    @JsonIgnoreProperties("insumos")
    @ToString.Exclude
    private CategoriaInsumo categoriaInsumo;
}
