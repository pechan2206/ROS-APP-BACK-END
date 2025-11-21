package com.example.back_end.service.implement;

import com.example.back_end.model.CategoriaInsumo;
import com.example.back_end.model.Insumo;
import com.example.back_end.repository.CategoriaInsumoRepository;
import com.example.back_end.repository.InsumoRepository;
import com.example.back_end.service.InsumoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoServiceImpl implements InsumoService {

    private final InsumoRepository insumoRepository;
    private final CategoriaInsumoRepository categoriaInsumoRepository;

    public InsumoServiceImpl(InsumoRepository insumoRepository,
                             CategoriaInsumoRepository categoriaInsumoRepository) {
        this.insumoRepository = insumoRepository;
        this.categoriaInsumoRepository = categoriaInsumoRepository;
    }

    @Override
    public List<Insumo> findAll() {
        return insumoRepository.findAll();
    }

    @Override
    public Optional<Insumo> findById(Integer id) {
        return insumoRepository.findById(id);
    }

    @Override
    public Insumo save(Insumo insumo) {

        if (insumo.getCategoriaInsumo() != null) {
            CategoriaInsumo categoria = categoriaInsumoRepository.findById(
                    insumo.getCategoriaInsumo().getIdCategoriaInsumo()
            ).orElseThrow(() -> new RuntimeException("Categoría de insumo no encontrada"));

            insumo.setCategoriaInsumo(categoria);
        }

        return insumoRepository.save(insumo);
    }

    @Override
    public Insumo update(Integer id, Insumo insumo) {

        return insumoRepository.findById(id)
                .map(existing -> {

                    existing.setNombre(insumo.getNombre());
                    existing.setCantidad(insumo.getCantidad());
                    existing.setUnidadMedida(insumo.getUnidadMedida());

                    if (insumo.getCategoriaInsumo() != null) {
                        CategoriaInsumo categoria = categoriaInsumoRepository
                                .findById(insumo.getCategoriaInsumo().getIdCategoriaInsumo())
                                .orElseThrow(() -> new RuntimeException("Categoría de insumo no encontrada"));
                        existing.setCategoriaInsumo(categoria);
                    }

                    return insumoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        insumoRepository.deleteById(id);
    }
}
