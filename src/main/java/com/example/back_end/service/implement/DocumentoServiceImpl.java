package com.example.back_end.service.implement;

import com.example.back_end.model.Documento;
import com.example.back_end.repository.DocumentoRepository;
import com.example.back_end.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public List<Documento> listar(){
        return documentoRepository.findAll();
    }

    @Override
    public Optional<Documento> obtenerPorId(Integer id){
        return documentoRepository.findById(id);
    }

    @Override
    public Documento guardar(Documento documento){
        return documentoRepository.save(documento);
    }

    @Override
    public void eliminar(Integer id){
        documentoRepository.deleteById(id);
    }


    //Modificar funcionalidad
    @Override
    public Documento actualizar(Integer id, Documento documento){
        return documentoRepository.save(documento);
    }
}
