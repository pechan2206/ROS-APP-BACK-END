package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @ManyToMany
    @JoinTable(
            name = "proveedores_productos",
            joinColumns = @JoinColumn(name = "fk_id_proveedor"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_producto")
    )
    private List<Producto> productos;

}
