package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_factura")
    private Integer idDetalleFactura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_plato", nullable = false)
    private Plato plato;

    @Min(1)
    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal subtotal;

    @PrePersist
    @PreUpdate
    public void calcularSubtotal() {
        if (precioUnitario != null && cantidad != null) {
            this.subtotal = precioUnitario.multiply(new BigDecimal(cantidad));
        }
    }
}
