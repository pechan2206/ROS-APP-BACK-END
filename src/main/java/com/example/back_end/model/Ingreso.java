package com.example.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "ingresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso")
    private Integer idIngreso;

    @Min(0)
    @Column(nullable = false)
    private Double monto;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    @JsonIgnoreProperties("ingresos")
    @ToString.Exclude
    private MetodoPago metodoPago;
}
