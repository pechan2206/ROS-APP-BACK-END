package com.example.back_end.service.implement;

import com.example.back_end.model.CategoriaPlato;
import com.example.back_end.model.Plato;
import com.example.back_end.repository.CategoriaPlatoRepository;
import com.example.back_end.repository.PlatoRepository;
import com.example.back_end.service.PlatoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {

    private final PlatoRepository platoRepository;
    private final CategoriaPlatoRepository categoriaPlatoRepository;

    public PlatoServiceImpl(PlatoRepository platoRepository, CategoriaPlatoRepository categoriaPlatoRepository) {
        this.platoRepository = platoRepository;
        this.categoriaPlatoRepository = categoriaPlatoRepository;
    }

    @Override
    public List<Plato> findAll() {
        return platoRepository.findAll();
    }

    @Override
    public Optional<Plato> findById(Integer id) {
        return platoRepository.findById(id);
    }

    @Override
    public Plato save(Plato plato) {

        CategoriaPlato categoria = categoriaPlatoRepository.findById(
                plato.getCategoriaPlato().getIdCategoria()
        ).orElseThrow(() -> new RuntimeException("Categoría de plato no encontrada"));

        plato.setCategoriaPlato(categoria);

        return platoRepository.save(plato);
    }

    @Override
    public Plato update(Integer id, Plato plato) {

        return platoRepository.findById(id)
                .map(existing -> {

                    existing.setNombre(plato.getNombre());
                    existing.setPrecio(plato.getPrecio());
                    existing.setDescripcion(plato.getDescripcion());
                    existing.setImagen(plato.getImagen());

                    CategoriaPlato categoria = categoriaPlatoRepository.findById(
                            plato.getCategoriaPlato().getIdCategoria()
                    ).orElseThrow(() -> new RuntimeException("Categoría de plato no encontrada"));

                    existing.setCategoriaPlato(categoria);

                    return platoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));
    }

    @Override
    public void delete(Integer id) {
        platoRepository.deleteById(id);
    }
}
