package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @Column(name = "total_pedido")
    private Double totalPedido;

    @Column(name = "id_mesa")
    private Integer idMesa;

    // RELACIÓN muchos a uno con mesas
    @ManyToOne
    @JoinColumn(name = "id_mesa", insertable = false, updatable = false)
    private Mesa mesa;

    // RELACIÓN uno a muchos con cajas_pedidos
    @OneToMany(mappedBy = "pedido")
    private List<CajaPedido> cajasPedidos;
}
