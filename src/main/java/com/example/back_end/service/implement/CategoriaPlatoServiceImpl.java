package com.example.back_end.service.implement;

import com.example.back_end.model.CategoriaPlato;
import com.example.back_end.repository.CategoriaPlatoRepository;
import com.example.back_end.service.CategoriaPlatoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaPlatoServiceImpl implements CategoriaPlatoService {

    private final CategoriaPlatoRepository categoriaPlatoRepository;

    public CategoriaPlatoServiceImpl(CategoriaPlatoRepository categoriaPlatoRepository) {
        this.categoriaPlatoRepository = categoriaPlatoRepository;
    }

    @Override
    public List<CategoriaPlato> findAll() {
        return categoriaPlatoRepository.findAll();
    }

    @Override
    public Optional<CategoriaPlato> findById(Integer id) {
        return categoriaPlatoRepository.findById(id);
    }

    @Override
    public CategoriaPlato save(CategoriaPlato categoriaPlato) {
        return categoriaPlatoRepository.save(categoriaPlato);
    }

    @Override
    public CategoriaPlato update(Integer id, CategoriaPlato categoriaPlato) {
        return categoriaPlatoRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(categoriaPlato.getNombre());
                    existing.setDescripcion(categoriaPlato.getDescripcion());
                    return categoriaPlatoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Categoría de plato no encontrada"));
    }

    @Override
    public void delete(Integer id) {
        categoriaPlatoRepository.deleteById(id);
    }
}
