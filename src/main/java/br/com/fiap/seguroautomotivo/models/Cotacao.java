package br.com.fiap.seguroautomotivo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Carro carro;

    private String usoDoCarro;

    private boolean blindagem;

    private Endereco endereco;

    private boolean idadeMinima;

    public Cotacao(Long id, Carro carro,  String usoDoCarro,
            boolean blindagem, Endereco endereco, boolean idadeMinima) {
        this.id = id;
        this.carro = carro;
        this.endereco = endereco;
        this.usoDoCarro = usoDoCarro;
        this.blindagem = blindagem;
        this.idadeMinima = idadeMinima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getUsoDoCarro() {
        return usoDoCarro;
    }

    public void setUsoDoCarro(String usoDoCarro) {
        this.usoDoCarro = usoDoCarro;
    }

    public boolean isBlindagem() {
        return blindagem;
    }

    public void setBlindagem(boolean blindagem) {
        this.blindagem = blindagem;
    }

    public boolean isIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(boolean idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    
}
