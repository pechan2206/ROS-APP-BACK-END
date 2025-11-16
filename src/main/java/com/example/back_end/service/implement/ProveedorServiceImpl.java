package com.example.back_end.service.implement;

import com.example.back_end.model.Proveedor;
import com.example.back_end.repository.ProveedorRepository;
import com.example.back_end.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listar(){
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor obtenerPorId(Integer id){
        return proveedorRepository.findById(id).orElse(null);
    }


    @Override
    public Proveedor guardar(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminar(Integer id){
        proveedorRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }
}
