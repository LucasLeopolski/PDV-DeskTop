package org.unipar.service;

import org.springframework.stereotype.Service;
import org.unipar.model.ItemVendaModel;
import org.unipar.repository.ItemVendaRepository;

import java.util.List;

@Service
public class ItemVendaService {

    public final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository){
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVendaModel> getAll(){
    return this.itemVendaRepository.findAll();
    }

    public  ItemVendaModel save(ItemVendaModel itemVendaModel){

        return  this.itemVendaRepository.save(itemVendaModel);
    }

    public ItemVendaModel validarItemVenda(int id, String descricao){
        return (ItemVendaModel) this.itemVendaRepository.findAllById(id, descricao);
    }
}
