package com.example.back_end.service.implement;

import com.example.back_end.model.Proveedor;
import com.example.back_end.repository.ProveedorRepository;
import com.example.back_end.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listar() {
        return proveedorRepository.findAll(); // devuelve todos, el filtro lo hace el frontend
    }

    @Override
    public Proveedor obtenerPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        proveedor.setEstado(true); // nuevo proveedor siempre activo
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminar(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        proveedor.setEstado(false);
        proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor) {
        return proveedorRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(proveedor.getNombre());
                    existing.setTelefono(proveedor.getTelefono());
                    existing.setCorreo(proveedor.getCorreo());
                    existing.setDireccion(proveedor.getDireccion());
                    existing.setEstado(proveedor.getEstado()); // ← guarda el estado
                    return proveedorRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }
}