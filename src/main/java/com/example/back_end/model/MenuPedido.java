package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menus_pedidos")
@Data
public class MenuPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_pedido")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;
}
