package com.example.back_end.model;

import com.example.back_end.model.enums.EstadoMesa;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "mesas",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "numero") // Cada mesa debe tener un número único
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer idMesa;

    @NotNull(message = "El número de mesa es obligatorio")
    @Positive(message = "El número de mesa debe ser mayor a 0")
    @Column(nullable = false)
    private Integer numero;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La capacidad mínima es 1")
    @Max(value = 20, message = "La capacidad máxima es 20")
    @Column(nullable = false)
    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('Disponible','Ocupada','Reservada') DEFAULT 'Disponible'")
    private EstadoMesa estado;
}
