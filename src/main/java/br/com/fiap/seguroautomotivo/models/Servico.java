package br.com.fiap.seguroautomotivo.models;

import org.hibernate.annotations.NotFound;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do serviço não pode ser vazio.")
    private String servicosNome;
    
    @Min(value = 0) 
    @NotNull(message = "O valor do serviço não pode ser nulo.")
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
