package com.example.back_end.repository;

import com.example.back_end.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    Cliente findByTelefono(String telefono);
    List<Cliente> findByTelefonoContaining(String telefono);



}
