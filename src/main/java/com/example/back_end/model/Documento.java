package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "documentos")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(length = 20)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}

