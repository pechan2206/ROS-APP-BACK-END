package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "parametros")
@Data
public class Parametro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String clave; // nombre del parámetro, por ejemplo "IVA"

    @Column(length = 255)
    private String valor; // valor, por ejemplo "19"
}
