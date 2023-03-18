package br.com.fiap.seguroautomotivo.models;

import java.util.List;

public class PlanoSeguro {
    
    private long id;

    private Cotacao cotacao;

    private List<Servico> servicos;

    private boolean status;

    private double valorTotal;

    
    public PlanoSeguro(long id, Cotacao cotacao, List<Servico> servicos ,boolean status) {
        this.id = id;
        this.cotacao = cotacao;
        //Adicionando servicos
        this.servicos = servicos;
        this.status = status;
        //Calculando valor total toda vez que o objeto for acionado
        calcularValorTotal();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cotacao getCotacao() {
        return cotacao;
    }

    public void setCotacao(Cotacao cotacao) {
        this.cotacao = cotacao;
    }
    
    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    private double calcularValorTotal() {
        for (Servico servico : servicos) {
            valorTotal += servico.getValor();
        }
        return valorTotal;
    }

    
}
