package com.example.back_end.service.implement;

import com.example.back_end.model.Menu;
import com.example.back_end.repository.MenuRepository;
import com.example.back_end.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> listar(){
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> obtenerPorId(Integer id){
        return menuRepository.findById(id);
    }

    @Override
    public Menu guardar(Menu menu){
        return menuRepository.save(menu);
    }

    @Override
    public void eliminar(Integer id){
        menuRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Menu actualizar(Integer id, Menu menu){
        return menuRepository.save(menu);
    }
}
