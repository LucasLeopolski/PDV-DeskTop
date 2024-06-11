package org.unipar.controller;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unipar.model.ClienteModel;
import org.unipar.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteModel>getAllClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public ClienteModel criarCliente(@RequestBody ClienteModel clienteModel){

        return clienteRepository.save(clienteModel);
    }

    @GetMapping("/{idCliente}")
    public ClienteModel getClienteModelById(@PathVariable Long idCliente){
        return  clienteRepository.findById(idCliente).orElseThrow(()
                -> new OpenApiResourceNotFoundException("Cliente Não Encontrado!"));
    }

    @PutMapping("/{idCliente}")
    public ClienteModel atualizarClienteModel(@PathVariable Long idCliente, @RequestBody ClienteModel clienteModelDetalhes){
        ClienteModel clienteModel = clienteRepository.findById(idCliente).orElseThrow(()
                -> new OpenApiResourceNotFoundException("Cliente Não Encontrado!"));
        clienteModel.setNome(clienteModelDetalhes.getNome());
        clienteModel.setEmail(clienteModelDetalhes.getEmail());
        clienteModel.setTelefone(clienteModelDetalhes.getTelefone());
        return clienteRepository.save(clienteModel);
    }

    @DeleteMapping("/{idCliente}")
    public void deletarClienteModel(@PathVariable Long idCliente){
        ClienteModel clienteModel = clienteRepository.findById(idCliente).orElseThrow(()
        -> new OpenApiResourceNotFoundException("Cliente Não Encontrado!"));
        clienteRepository.delete(clienteModel);
    }

}
