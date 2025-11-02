package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    // 🔹 Relación uno a muchos con inventario
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Inventario> inventarios;

    // 🔹 Relación muchos a muchos con proveedores
    @ManyToMany(mappedBy = "productos") // 👉 el lado inverso está en Proveedor
    private List<Proveedor> proveedores;
}
