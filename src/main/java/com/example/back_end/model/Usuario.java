package com.example.back_end.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombreUsuario;

    @Column(name = "apellido_usuario", nullable = false, length = 100)
    private String apellidoUsuario;

    @Column(name = "telefono_usuario", length = 50)
    private String telefonoUsuario;

    @Column(name = "email_usuario", length = 100)
    private String emailUsuario;

    @Column(name = "id_rol")
    private Integer idRol;

    // RELACIÓN muchos a uno con Roles
    @ManyToMany(mappedBy = "usuarios")
    private List<Rol> roles;


}
