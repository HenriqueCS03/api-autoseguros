package br.com.fiap.seguroautomotivo.models;

import java.time.LocalDate;

public class Carro {
    
    private String modelo;
    
    private LocalDate ano;

    private boolean blindagem;

    
    public Carro() {
    }

    
    public Carro(String modelo, LocalDate ano, boolean blindagem) {
        this.modelo = modelo;
        this.ano = ano;
        this.blindagem = blindagem;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public boolean isBlindagem() {
        return blindagem;
    }

    public void setBlindagem(boolean blindagem) {
        this.blindagem = blindagem;
    }

    
}
