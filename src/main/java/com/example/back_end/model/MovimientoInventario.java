package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "El insumo es obligatorio")
    private Insumo insumo;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Entrada','Salida')", nullable = false)
    @NotNull(message = "El tipo de movimiento es obligatorio")
    private TipoMovimiento tipo;

    public enum TipoMovimiento {
        Entrada, Salida
    }

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor que 0")
    @Column(nullable = false)
    private Double cantidad;

    @Column
    private LocalDateTime fecha = LocalDateTime.now(); // FECHA AUTOMÁTICA

    @Size(max = 200, message = "La descripción debe tener máximo 200 caracteres")
    @Column(length = 200)
    private String descripcion;
}
