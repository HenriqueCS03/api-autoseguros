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

import br.com.fiap.seguroautomotivo.models.PlanoSeguro;


@RestController
//Controle de requisições e acionamento de classes
public class PlanoSeguroController {
    
    List<PlanoSeguro> listPlanoSeguro = new ArrayList<>();

    @GetMapping("/api/assinar")
    public ResponseEntity<List<PlanoSeguro>> todosOsPlanos() {
        return listPlanoSeguro.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(listPlanoSeguro);
    }

    @PostMapping("/api/assinar")
    public ResponseEntity<PlanoSeguro> cadastrar(@RequestBody PlanoSeguro planoSeguro){
        listPlanoSeguro.add(planoSeguro);
         return ResponseEntity.status(HttpStatus.CREATED).body(planoSeguro);
    }


    @PutMapping("/api/assinar")
    public ResponseEntity<PlanoSeguro> atualizar(@RequestBody PlanoSeguro planoSeguro) {

        var planoEncontrado = listPlanoSeguro.stream().filter(pl -> pl.getId().equals(planoSeguro.getId())).findFirst();

        if (planoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listPlanoSeguro.remove(planoEncontrado.get());
        listPlanoSeguro.add(planoSeguro);

        return ResponseEntity.ok().body(planoSeguro);
    }

    @DeleteMapping("/api/assinar/{id}")
    public ResponseEntity<PlanoSeguro> remover(@PathVariable Long id) {
        
       var planoEncontrado = listPlanoSeguro.stream().filter(pl -> pl.getId().equals(id)).findFirst();
        if(planoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listPlanoSeguro.remove(planoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
    
}
