package org.unipar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unipar.model.ProdutoModel;
import org.unipar.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoModel> getAllProdutoModel(){
        return  produtoRepository.findAll();
    }
    @GetMapping("/{idProduto}")
    public ProdutoModel geProdutoById(@PathVariable Long idProduto){
        return produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    @PostMapping
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @PutMapping("/{idProduto}")
    public ProdutoModel atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoModel produtoDetalhado){
        ProdutoModel produtoModel = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não emcontrado!"));
        produtoModel.setDescricao(produtoDetalhado.getDescricao());
        produtoModel.setCategoria(produtoDetalhado.getCategoria());
        produtoModel.setValor(produtoDetalhado.getValor());
        produtoModel.setIdProduto(produtoDetalhado.getIdProduto());
        return produtoRepository.save(produtoModel);

    }

    @DeleteMapping("/{idProduto}")
    public void apagarProduto(@PathVariable Long idProduto){
        produtoRepository.deleteById(idProduto);
    }
}
