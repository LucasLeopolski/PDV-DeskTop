package org.unipar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unipar.model.ItemVendaModel;
import org.unipar.model.ProdutoModel;
import org.unipar.model.VendaModel;
import org.unipar.repository.ItemVendaRepository;
import org.unipar.repository.ProdutoRepository;
import org.unipar.repository.VendaRepository;

import java.util.List;

public class ItemVendaController { @Autowired
private ItemVendaRepository itemVendaRepository;
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ItemVendaModel> getAllItemVendas() {
        return itemVendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ItemVendaModel getItemVendaById(@PathVariable Long id) {
        return itemVendaRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemVenda não encontrado"));
    }

    @PostMapping
    public ItemVendaModel createItemVenda(@RequestBody ItemVendaModel itemVenda) {
        VendaModel venda = vendaRepository.findById(itemVenda.getVendaModel().getId())
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        ProdutoModel produto = produtoRepository.findById(itemVenda.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        itemVenda.setVendaModel(venda);
        itemVenda.setProduto(produto);
        itemVenda.setValorTotal(produto.getPreco() * itemVenda.getQuantidade());

        return itemVendaRepository.save(itemVenda);
    }

    @PutMapping("/{id}")
    public ItemVendaModel updateItemVenda(@PathVariable Long id, @RequestBody ItemVendaModel itemVendaDetails) {
        ItemVendaModel itemVenda = itemVendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemVenda não encontrado"));

        VendaModel venda = vendaRepository.findById(itemVendaDetails.getVendaModel().getId())
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        ProdutoModel produto = produtoRepository.findById(itemVendaDetails.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        itemVenda.setVendaModel(venda);
        itemVenda.setProduto(produto);
        itemVenda.setQuantidade(itemVendaDetails.getQuantidade());
        itemVenda.setValorTotal(produto.getPreco() * itemVendaDetails.getQuantidade());

        return itemVendaRepository.save(itemVenda);
    }

    @DeleteMapping("/{id}")
    public void deleteItemVenda(@PathVariable Long id) {
        itemVendaRepository.deleteById(id);
    }
}