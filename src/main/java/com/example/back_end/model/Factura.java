package com.example.back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pedido")
    @JsonIgnoreProperties("facturas")
    @ToString.Exclude
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("facturas")
    @ToString.Exclude
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_metodo")
    @JsonIgnoreProperties("facturas")
    @ToString.Exclude
    private MetodoPago metodoPago;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Min(0)
    @Column(nullable = false)
    private Double total;

    // Generar fecha automáticamente
    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }
}
