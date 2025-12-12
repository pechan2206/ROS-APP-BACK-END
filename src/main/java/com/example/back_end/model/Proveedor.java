package com.example.back_end.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(max = 100, message = "El nombre debe tener máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Pattern(
            regexp = "^3\\d{9}$",
            message = "El teléfono debe comenzar con 3 y tener 10 dígitos"
    )
    @Column(length = 20)
    private String telefono;

    @Email(message = "El correo debe ser válido")
    @Size(max = 100, message = "El correo debe tener máximo 100 caracteres")
    @Column(length = 100, unique = true)
    private String correo;

    @Size(max = 150, message = "La dirección debe tener máximo 150 caracteres")
    @Column(length = 150)
    private String direccion;
}
