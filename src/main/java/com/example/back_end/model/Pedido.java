package com.example.back_end.model;

import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.model.enums.TipoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private LocalDateTime fecha = LocalDateTime.now(); // <--- FECHA AUTOMÁTICA

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Pendiente','En preparación','Entregado','Cancelado') DEFAULT 'Pendiente'")
    private EstadoPedido estado;

    @Column
    private Double total;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private TipoPedido tipo;
}
