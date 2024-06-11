package org.unipar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class VendaModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String observacoes;
    private String dataVenda;
    private double valorVenda;
    @ManyToOne
    private ClienteModel clienteModel;
    @OneToMany(mappedBy = "vendaModel", cascade = CascadeType.ALL)
    public List<ItemVendaModel> itens;

}
