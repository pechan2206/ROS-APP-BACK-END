package com.example.back_end.repository;

import com.example.back_end.model.Mesa;
import com.example.back_end.model.enums.EstadoMesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    List<Mesa> findByEstado(EstadoMesa estado);
}
