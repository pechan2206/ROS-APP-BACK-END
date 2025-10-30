package com.example.back_end.service;

import com.example.back_end.model.Documento;

import java.util.List;
import java.util.Optional;

public interface DocumentoService {

    List<Documento> listar();
    Optional<Documento> obtenerPorId(Integer id);
    Documento guardar(Documento documento);
    void eliminar(Integer id);
    Documento actualizar(Integer id, Documento documento);


}
