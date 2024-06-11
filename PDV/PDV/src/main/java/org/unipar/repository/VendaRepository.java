package org.unipar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unipar.model.VendaModel;

public interface VendaRepository extends JpaRepository<VendaModel, Long> {
    VendaModel findById(Integer id, String descricao);
}
