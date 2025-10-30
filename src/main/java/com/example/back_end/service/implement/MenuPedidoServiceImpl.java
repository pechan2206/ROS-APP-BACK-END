package com.example.back_end.service.implement;

import com.example.back_end.model.MenuPedido;
import com.example.back_end.repository.MenuPedidoRepository;
import com.example.back_end.service.MenuPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MenuPedidoServiceImpl implements MenuPedidoService {

    @Autowired
    private MenuPedidoRepository menuPedidoRepository;

    @Override
    public List<MenuPedido> listar(){
        return menuPedidoRepository.findAll();
    }

    @Override
    public Optional<MenuPedido> obtenerPorId(Integer id){
        return menuPedidoRepository.findById(id);
    }

    @Override
    public MenuPedido guardar(MenuPedido menuPedido){
        return menuPedidoRepository.save(menuPedido);
    }

    @Override
    public void eliminar(Integer id){
        menuPedidoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public MenuPedido actualizar(Integer id, MenuPedido menuPedido){
        return menuPedidoRepository.save(menuPedido);
    }
}
