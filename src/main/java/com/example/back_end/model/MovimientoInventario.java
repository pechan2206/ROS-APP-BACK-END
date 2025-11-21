package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Entrada','Salida')")
    private TipoMovimiento tipo;

    public enum TipoMovimiento {
        Entrada, Salida
    }

    @Column(nullable = false)
    private Double cantidad;

    @Column
    private LocalDateTime fecha;

    @Column(length = 200)
    private String descripcion;
}
