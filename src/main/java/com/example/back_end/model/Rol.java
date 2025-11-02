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
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "roles_usuarios",
            joinColumns = @JoinColumn(name = "fk_id_rol"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_usuario")
    )
    private List<Usuario> usuarios;


    // RELACIÓN muchos a muchos con permisos
    @ManyToMany
    @JoinTable(
            name = "rol_permisos",
            joinColumns = @JoinColumn(name = "fk_id_rol"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_permiso")
    )
    private List<Permiso> permisos;


}
