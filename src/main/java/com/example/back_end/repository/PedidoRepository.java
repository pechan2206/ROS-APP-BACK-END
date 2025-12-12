package com.example.back_end.repository;

import com.example.back_end.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    @Query(value = "SELECT tipo, COUNT(*) AS total FROM pedidos GROUP BY tipo",
            nativeQuery = true)
    List<Map<String, Object>> contarPorTipo();



}
