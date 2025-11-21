package com.example.back_end.model;

import com.example.back_end.model.enums.EstadoMesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mesas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer idMesa;

    @Column(nullable = false)
    private Integer numero;

    @Column
    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Disponible','Ocupada','Reservada') DEFAULT 'Disponible'")
    private EstadoMesa estado;

}
