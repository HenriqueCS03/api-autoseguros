package br.com.fiap.seguroautomotivo.models;

public class Servicos {
    
    private String nome;
    
    private static double valor;

    
    public Servicos(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static double getValor() {
        return valor;
    }

    public static void setValor(double valor) {
        Servicos.valor = valor;
    }


    
}
