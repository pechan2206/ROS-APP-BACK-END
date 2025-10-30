package com.example.back_end.service.implement;

import com.example.back_end.model.Cliente;
import com.example.back_end.repository.ClienteRepository;
import com.example.back_end.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    @Override
    public Optional<Cliente> obtenerPorId(Integer id){
        return clienteRepository.findById(id);
    }
    @Override
    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @Override
    public void eliminar(Integer id){
        clienteRepository.deleteById(id);
    }

    //modificar esto
    @Override
    public Cliente actualizar(Integer id, Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
