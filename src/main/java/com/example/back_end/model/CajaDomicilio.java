package com.example.back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cajas_domicilio")
public class CajaDomicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja_domicilio")
    private Integer idCajaDomicilio;

    @Column(name = "id_caja")
    private Integer idCaja;

    @Column(name = "id_domicilio")
    private Integer idDomicilio;

    @ManyToOne
    @JoinColumn(name = "id_caja", insertable = false, updatable = false)
    private Caja caja;
}
