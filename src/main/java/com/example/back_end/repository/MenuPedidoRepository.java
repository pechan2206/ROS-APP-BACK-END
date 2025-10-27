package com.example.back_end.repository;

import com.example.back_end.model.MenuPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPedidoRepository extends JpaRepository<MenuPedido,Integer> {
}
