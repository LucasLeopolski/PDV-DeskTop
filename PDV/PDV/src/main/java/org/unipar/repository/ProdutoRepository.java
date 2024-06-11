package org.unipar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unipar.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    ProdutoModel findById(int id, String descricao);
}
