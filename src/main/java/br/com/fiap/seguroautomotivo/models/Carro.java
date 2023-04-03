package br.com.fiap.seguroautomotivo.models;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity
public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "A placa tem que ser preenchido.")
    @Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "A placa deve estar no formato AAA-1234")
    private String placa;

    @NotBlank(message = "O modelo tem que ser preenchido.")
    private String modelo;

    @NotNull(message = "A data não pode ser nula")
    @Temporal(TemporalType.DATE)
    private LocalDate ano;

  
    public Carro(){}
    
    public Carro(Long id, String placa, String modelo, LocalDate ano) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

}
