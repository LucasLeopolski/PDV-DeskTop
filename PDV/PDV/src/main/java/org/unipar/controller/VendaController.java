package org.unipar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unipar.model.ClienteModel;
import org.unipar.model.ItemVendaModel;
import org.unipar.model.VendaModel;
import org.unipar.repository.ClienteRepository;
import org.unipar.repository.VendaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import  java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<VendaModel> getAllVendaModel(){
        return vendaRepository.findAll();
    }

    @GetMapping("/{idVenda}")
    public VendaModel getVendaById(@PathVariable Long idVenda){
        return  vendaRepository.findById(idVenda).orElseThrow(() -> new RuntimeException("Venda não Encontrada!"));
    }

    @PostMapping
    public VendaModel criarVendaModel(@RequestBody VendaModel vendaModel){
        ClienteModel clienteModel = clienteRepository.findById(Long.valueOf(vendaModel.getClienteModel().getIdCliente())).orElseThrow(()
                -> new RuntimeException("Cliente não Encontrado!"));
        vendaModel.setClienteModel(clienteModel);
        vendaModel.setDataVenda(String.valueOf(LocalDateTime.now()));
        vendaModel.setValorVenda(vendaModel.getItens().stream().mapToDouble(ItemVendaModel::getIdItemVenda).sum());
        return  vendaRepository.save(vendaModel);
    }

    @DeleteMapping("/{idVenda}")
    public void apagarVenda(@PathVariable Long idVenda){
        vendaRepository.deleteById(idVenda);
    }

}
