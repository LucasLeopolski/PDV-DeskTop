package org.unipar.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import org.unipar.model.VendaModel;
import org.unipar.repository.VendaRepository;

import java.util.List;
@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    public List<VendaModel> getAll(){
        return this.vendaRepository.findAll();
    }

    public VendaModel save(VendaModel vendaModel){
        return  this.vendaRepository.save(vendaModel);
    }

    public VendaModel valoidarVenda(Integer id, String descricao){
        return this.vendaRepository.findById(id, descricao);
    }
}
