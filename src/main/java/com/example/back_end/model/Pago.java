package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(length = 50)
    private String metodo; // Efectivo, Tarjeta, etc.

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;
}

