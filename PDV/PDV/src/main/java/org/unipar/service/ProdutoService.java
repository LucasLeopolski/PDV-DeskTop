package org.unipar.service;

import org.springframework.stereotype.Service;
import org.unipar.model.ProdutoModel;
import org.unipar.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> getAll(){
        return this.produtoRepository.findAll();
    }

    public ProdutoModel save(ProdutoModel produtoModel){
        return this.produtoRepository.save(produtoModel);
    }

    public ProdutoModel validarProduto(int id, String descricao){
        return this.produtoRepository.findById(id, descricao);
    }
}
