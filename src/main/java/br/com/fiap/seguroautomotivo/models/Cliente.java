package br.com.fiap.seguroautomotivo.models;

public class Cliente {
    
    private int id;

    private String email;

    private String cpf;

    private String senha;

    public Cliente(){}

    public Cliente(int id, String email, String senha, String cpf) {
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
