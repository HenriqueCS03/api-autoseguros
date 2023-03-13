package br.com.fiap.seguroautomotivo.models;

public class Plano {
    
    private Servico servico;

    private boolean status;

    private double valor;

    public Plano(){}

    public Plano(Servico servico, boolean status, double valor) {
        this.servico = servico;
        this.status = status;
        this.valor = valor;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
