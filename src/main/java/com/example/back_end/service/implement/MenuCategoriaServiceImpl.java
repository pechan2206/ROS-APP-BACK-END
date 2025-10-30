package com.example.back_end.service.implement;

import com.example.back_end.model.MenuCategoria;
import com.example.back_end.repository.MenuCategoriaRepository;
import com.example.back_end.service.MenuCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuCategoriaServiceImpl implements MenuCategoriaService {

    @Autowired
    private MenuCategoriaRepository menuCategoriaRepository;

    @Override
    public List<MenuCategoria> listar(){
        return menuCategoriaRepository.findAll();
    }

    @Override
    public Optional<MenuCategoria> obtenerPorId(Integer id){
        return menuCategoriaRepository.findById(id);
    }

    @Override
    public MenuCategoria guardar(MenuCategoria menuCategoria){
        return menuCategoriaRepository.save(menuCategoria);
    }

    @Override
    public void eliminar(Integer id){
        menuCategoriaRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public MenuCategoria actualizar(Integer id, MenuCategoria menuCategoria){
        return menuCategoriaRepository.save(menuCategoria);
    }
}
