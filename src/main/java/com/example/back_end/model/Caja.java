package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cajas")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja")
    private Integer idCaja;

    @Column(name = "nombre_caja", length = 100)
    private String nombreCaja;

    @Column(name = "saldo_inicial")
    private Double saldoInicial;

    @Column(name = "saldo_final")
    private Double saldoFinal;

    // RELACIONES con pedidos y domicilios
    @OneToMany(mappedBy = "caja")
    private List<CajaPedido> cajasPedidos;

    @OneToMany(mappedBy = "caja")
    private List<CajaDomicilio> cajasDomicilios;
}
