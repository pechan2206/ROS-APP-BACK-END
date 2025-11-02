package com.example.back_end.model;

import com.example.back_end.model.enums.EstadoMesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer idMesa;

    @Column(name = "numero_mesa", nullable = false)
    private String numeroMesa;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 50)
    private EstadoMesa estado;

    // RELACIÓN uno a muchos con pedidos
    @OneToMany(mappedBy = "mesa")
    private List<Pedido> pedidos;

}
