package br.com.fiap.seguroautomotivo.models;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String placa;

    private String modelo;

    private Calendar ano;

  
    public Carro(){}
    
    public Carro(Long id,String placa,String modelo, Calendar ano) {
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Calendar getAno() {
        return ano;
    }

    public void setAno(Calendar ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
