package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cajas_pedidos")
public class CajaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja_pedido")
    private Integer idCajaPedido;

    @Column(name = "id_caja")
    private Integer idCaja;

    @Column(name = "id_pedido")
    private Integer idPedido;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_caja", insertable = false, updatable = false)
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Pedido pedido;
}
