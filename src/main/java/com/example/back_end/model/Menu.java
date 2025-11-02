package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "menus")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private Promocion promocion; // menú puede tener promoción opcional

    @ManyToMany
    @JoinTable(
            name = "menu_categoria",
            joinColumns = @JoinColumn(name = "fk_id_menu"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_categoria")
    )
    private List<Categoria> categorias;


    @ManyToMany
    @JoinTable(
            name = "menu_pedidos",
            joinColumns = @JoinColumn(name = "fk_id_menu"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_pedido")
    )
    private List<Pedido> pedidos;

}

