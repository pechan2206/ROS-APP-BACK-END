package com.example.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetallePedido;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_plato", nullable = false)
    private Plato plato;

    @Min(1)
    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = true)
    private BigDecimal precioUnitario;

    @Column(nullable = true)
    private BigDecimal subtotal;

}
