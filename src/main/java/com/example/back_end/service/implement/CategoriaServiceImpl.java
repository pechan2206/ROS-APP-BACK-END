package com.example.back_end.service.implement;

import com.example.back_end.repository.CategoriaRepository;
import com.example.back_end.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.back_end.model.Categoria;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> obtenerPorId(Integer id){
        return categoriaRepository.findById(id);
    }
    @Override
    public Categoria guardar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    @Override
    public void eliminar(Integer id){
        categoriaRepository.deleteById(id);
    }

    //Modificar esto
    @Override
    public Categoria actualizar(Integer id, Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
