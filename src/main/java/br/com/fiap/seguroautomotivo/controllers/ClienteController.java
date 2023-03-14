package br.com.fiap.seguroautomotivo.controllers;

public class ClienteController {
    
    @GetMapping("/api/cliente")
    public List<Cliente> show(){
        return  clientes;
    }

    @PostMapping("/api/cliente")
    public void create(){
        
    }
}
