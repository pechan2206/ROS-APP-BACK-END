package com.example.back_end.service.implement;

import com.example.back_end.model.CategoriaInsumo;
import com.example.back_end.repository.CategoriaInsumoRepository;
import com.example.back_end.service.CategoriaInsumoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaInsumoServiceImpl implements CategoriaInsumoService {

    private final CategoriaInsumoRepository categoriaInsumoRepository;

    public CategoriaInsumoServiceImpl(CategoriaInsumoRepository categoriaInsumoRepository) {
        this.categoriaInsumoRepository = categoriaInsumoRepository;
    }

    @Override
    public List<CategoriaInsumo> findAll() {
        return categoriaInsumoRepository.findAll();
    }

    @Override
    public Optional<CategoriaInsumo> findById(Integer id) {
        return categoriaInsumoRepository.findById(id);
    }

    @Override
    public CategoriaInsumo save(CategoriaInsumo categoriaInsumo) {
        return categoriaInsumoRepository.save(categoriaInsumo);
    }

    @Override
    public CategoriaInsumo update(Integer id, CategoriaInsumo categoriaInsumo) {
        return categoriaInsumoRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(categoriaInsumo.getNombre());
                    existing.setDescripcion(categoriaInsumo.getDescripcion());
                    return categoriaInsumoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Categoría de insumo no encontrada"));
    }

    @Override
    public void delete(Integer id) {
        categoriaInsumoRepository.deleteById(id);
    }
}
