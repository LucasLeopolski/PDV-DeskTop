package org.unipar.service;

import org.springframework.stereotype.Service;
import org.unipar.model.ClienteModel;
import org.unipar.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> getAll(){
        return this.clienteRepository.findAll();
    }

    public ClienteModel save(ClienteModel clienteModel){
        return this.clienteRepository.save(clienteModel);
    }

    public ClienteModel validarClienteModel(int id, String nome){

        return this.clienteRepository.findById(id, nome);
    }
}
