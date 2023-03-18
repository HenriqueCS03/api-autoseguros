package br.com.fiap.seguroautomotivo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Cliente;

@RestController
public class ClienteController {
    
    List<Cliente> listCliente = new ArrayList<>();

    @GetMapping("/api/cadastro")
    public List<Cliente> show() {
        return listCliente;
    }

    @PostMapping("/api/cadastro")
    public List<Cliente> cadastra(@RequestBody Cliente cliente){
         listCliente.add(cliente);
         return listCliente;
    }

    @PostMapping("/api/login")
    public Boolean verifica(@RequestBody Cliente cliente){
       return listCliente.contains(cliente);
    }

    // @DeleteMapping("/api/cadastro/{id}")
    // public ResponseEntity<Cliente> remover(@PathVariable long id) {
        
    //     for(Cliente c : listCliente){
    //         if(c.getId() == id){
    //             listCliente.remove(c);
    //         }
    //     }
    //     return ResponseEntity.noContent().build();
    // }
}
