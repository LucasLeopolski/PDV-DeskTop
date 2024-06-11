package org.unipar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unipar.model.ItemVendaModel;

public interface ItemVendaRepository extends JpaRepository<ItemVendaModel, Long> {
    Object findAllById(int id, String descricao);
}
