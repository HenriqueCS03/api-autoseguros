package br.com.fiap.seguroautomotivo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String servicosNome;
    
    private double valor;

    public Servico(Long id, String servicosNome, int valor) {
        this.id = id;
        this.servicosNome = servicosNome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
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
