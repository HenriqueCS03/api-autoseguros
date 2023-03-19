package br.com.fiap.seguroautomotivo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Cliente;

@RestController
public class ClienteController {
    
    List<Cliente> listCliente = new ArrayList<>();

    @GetMapping("/api/cadastro")
    public ResponseEntity<List<Cliente>> show() {
        return listCliente.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(listCliente);
    }

    @PostMapping("/api/cadastro")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
         listCliente.add(cliente);
         return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Boolean> verifica(@RequestBody Cliente cliente){
        var clienteEncontrado = listCliente.contains(cliente);
        if(!clienteEncontrado){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clienteEncontrado);
    }

    @PutMapping("/api/cadastro")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {

        var clientesncontrado = listCliente.stream().filter(cl -> cl.getId().equals(cliente.getId())).findFirst();

        if (clientesncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listCliente.remove(clientesncontrado.get());
        listCliente.add(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/api/cadastro/{id}")
    public ResponseEntity<Cliente> remover(@PathVariable Long id) {
        
       var clienteEncontrado = listCliente.stream().filter(cl -> cl.getId().equals(id)).findFirst();
        if(clienteEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listCliente.remove(clienteEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
