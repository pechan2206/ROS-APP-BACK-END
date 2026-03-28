package com.example.back_end.model;

import com.example.back_end.model.enums.EstadoPedido;
import com.example.back_end.model.enums.TipoPedido;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime fecha = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Pendiente','En preparación','Entregado','Anulado','Pagado') DEFAULT 'Pendiente'")
    private EstadoPedido estado;

    @Column
    private Double total;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private TipoPedido tipo;

    // ── Relación con DetallePedido ──────────────────────────────────────────
    // FetchType.EAGER = los detalles se cargan siempre junto con el pedido
    // JsonManagedReference = evita el bucle infinito JSON (Pedido → Detalle → Pedido → ...)
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetallePedido> detallePedidos;
}