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

import br.com.fiap.seguroautomotivo.models.Endereco;

public class EnderecoController {
    
    List<Endereco> enderecos = new ArrayList<>();

    @GetMapping("/api/endereco")
    public ResponseEntity<List<Endereco>> listarOsEnderecos(){
        return enderecos.isEmpty() 
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(enderecos);
    }

    @PostMapping("/api/endereco")
    public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco){
        enderecos.add(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }


    @PutMapping("/api/endereco")
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {

        var enderecoEncontrado = enderecos.stream().filter(e -> e.getId().equals(endereco.getId())).findFirst();

        if (enderecoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        enderecos.remove(enderecoEncontrado.get());
        enderecos.add(endereco);

        return ResponseEntity.ok().body(endereco);
    }

    @DeleteMapping("/api/endereco/{id}")
    public ResponseEntity<Endereco> remover(@PathVariable Long id) {
        
       var enderecoEncontrado = enderecos.stream().filter(e -> e.getId().equals(id)).findFirst();
        if(enderecoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        enderecos.remove(enderecoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
