package br.com.fiap.seguroautomotivo.models;

import java.util.Calendar;


public class Carro {
    
    private int id;
    
    private String placa;

    private String modelo;

    private Calendar ano;

  
    public Carro(){}
    
    public Carro(int id,String placa,String modelo, Calendar ano) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
