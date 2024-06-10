/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuário
 */
public class Venda {
    
    private int idVenda;
    private String observacoesVenda;
    private String dataVenda;
    private double valorVenda;
    
    public void Venda(){}

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getObservacoes() {
        return observacoesVenda;
    }

    public void setObservacoes(String observacoesVenda) {
        this.observacoesVenda = observacoesVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
}
