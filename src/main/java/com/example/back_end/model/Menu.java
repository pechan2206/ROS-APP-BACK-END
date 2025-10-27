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

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuCategoria> categorias;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuPedido> pedidos;
}

