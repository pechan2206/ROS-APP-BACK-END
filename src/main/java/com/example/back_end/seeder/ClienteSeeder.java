package com.example.back_end.seeder;

import com.example.back_end.model.Cliente;
import com.example.back_end.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteSeeder {

    @Autowired
    private ClienteRepository clienteRepository;

/*    @PostConstruct
    public void init() {

        // Evita duplicar datos
        if (clienteRepository.count() == 0) {

            Cliente cliente1 = new Cliente(null, "Juan Pérez", "123456789", "Calle 1", null);
            Cliente cliente2 = new Cliente(null, "Ana López", "987654321", "Calle 2", null);

            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);

            System.out.println("✔ Clientes iniciales cargados correctamente");
        }
    }*/
}
