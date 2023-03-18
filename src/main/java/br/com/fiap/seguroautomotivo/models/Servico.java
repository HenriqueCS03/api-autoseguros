package br.com.fiap.seguroautomotivo.models;


public class Servico {
    
    private int id;

    private String servicosNome;
    
    private double valor;

    public Servico(int id, String servicosNome, int valor) {
        this.id = id;
        this.servicosNome = servicosNome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicosNome() {
        return servicosNome;
    }

    public void setServicosNome(String servicosNome) {
        this.servicosNome = servicosNome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
