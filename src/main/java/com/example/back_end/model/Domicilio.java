package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono_contacto", length = 50)
    private String telefonoContacto;

    @Column(name = "fecha_domicilio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDomicilio;

    // Relación uno a muchos con cajas_domicilio
    @OneToMany(mappedBy = "domicilio")
    private List<CajaDomicilio> cajasDomicilio;

    // Relación uno a muchos con facturas
    @OneToMany(mappedBy = "domicilio")
    private List<Factura> facturas;
}
