package org.unipar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItemVendaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemVenda;
    private int quantidade;
    private BigDecimal valoUnitario;
    @ManyToOne
    private VendaModel vendaModel;
    @ManyToOne
    private ProdutoModel idModel;
}
