package com.example.back_end.repository;

import com.example.back_end.model.DetallePedido;
import com.example.back_end.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    // Buscar por objeto Pedido
    List<DetallePedido> findByPedido(Pedido pedido);

    // O buscar por id de pedido usando @Query
    @Query("SELECT d FROM DetallePedido d WHERE d.pedido.idPedido = :pedidoId")
    List<DetallePedido> findByPedidoId(@Param("pedidoId") Integer pedidoId);
}
