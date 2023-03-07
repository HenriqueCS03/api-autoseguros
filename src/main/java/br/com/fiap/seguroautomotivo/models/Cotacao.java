package br.com.fiap.seguroautomotivo.models;

import java.time.LocalDate;

public class Cotacao {
    
    private String modelo;
    
    private LocalDate ano;

    private boolean blindagem;

    private String cep;

    private String cpf;

    private boolean idadeMinima;

    
    public Cotacao(String modelo, LocalDate ano, boolean blindagem, String cep, String cpf, boolean idadeMinima) {
        this.modelo = modelo;
        this.ano = ano;
        this.blindagem = blindagem;
        this.cep = cep;
        this.cpf = cpf;
        this.idadeMinima = idadeMinima;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(boolean idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    
}
