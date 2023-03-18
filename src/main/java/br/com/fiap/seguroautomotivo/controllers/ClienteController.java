package br.com.fiap.seguroautomotivo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.seguroautomotivo.models.Cliente;

public class ClienteController {
    
    List<Cliente> listCliente = new ArrayList<>();


    @PostMapping("/api/cadastro")
    public List<Cliente> cadastra(@RequestBody Cliente cliente){
        listCliente.add(cliente);
        return listCliente;
    }

    @PostMapping("/api/login")
    public Boolean verifica(@RequestBody Cliente cliente){
       return listCliente.contains(cliente);
    }


}
