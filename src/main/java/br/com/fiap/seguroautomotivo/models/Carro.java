package br.com.fiap.seguroautomotivo.models;

import java.util.Calendar;


public class Carro {
    
    private long id;

    private String modelo;

    private Calendar ano;

    private String usoDoCarro;

    private boolean blindagem;

    private boolean idadeMinima;

    public Carro(){}
    
    public Carro(long id,String modelo, Calendar ano, String usoDoCarro, boolean blindagem, boolean idadeMinima) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.usoDoCarro = usoDoCarro;
        this.blindagem = blindagem;
        this.idadeMinima = idadeMinima;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
