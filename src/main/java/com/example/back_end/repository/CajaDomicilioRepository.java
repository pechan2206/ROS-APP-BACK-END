package com.example.back_end.repository;

import com.example.back_end.model.CajaDomicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajaDomicilioRepository extends JpaRepository<CajaDomicilio,Integer> {
}
