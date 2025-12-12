package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "egresos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Egreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egreso")
    private Integer idEgreso;

    @Min(0)
    @Column(nullable = false)
    private Double monto;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDate.now();
    }
}
