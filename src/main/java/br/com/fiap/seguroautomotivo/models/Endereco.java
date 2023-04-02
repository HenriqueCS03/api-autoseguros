package br.com.fiap.seguroautomotivo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Size(min = 8, max = 8)
    private String cep;

    @NotBlank(message = "O logradouro é obrigatório") 
    private String logradouro;

    @Min(value = 0, message = "deve ser positivo") 
    @NotNull
    private int numero;

    private String complemento;

    public Endereco
    (){}

    public Endereco
    (Long id,String cep, String logradouro
    , int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.logradouro
         = logradouro
        ;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro
    () {
        return logradouro
        ;
    }

    public void setLogradouro
    (String logradouro
    ) {
        this.logradouro
         = logradouro
        ;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
