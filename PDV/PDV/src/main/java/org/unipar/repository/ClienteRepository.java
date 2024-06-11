package org.unipar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unipar.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    ClienteModel findById(int id, String nome);
}
