package com.example.back_end.repository;

import com.example.back_end.model.CajaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaPedidoRepository extends JpaRepository<CajaPedido,Integer> {

}
