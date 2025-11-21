package com.example.back_end.model;

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
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Pendiente','En preparación','Entregado','Cancelado') DEFAULT 'Pendiente'")
    private EstadoPedido estado;

    public enum EstadoPedido {
        Pendiente,
        En_preparación,
        Entregado,
        Cancelado
    }

    @Column
    private Double total;
}
