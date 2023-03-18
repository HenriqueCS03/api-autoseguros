package br.com.fiap.seguroautomotivo.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.PlanoSeguro;



@RestController
//Controle de requisições e acionamento de classes
public class PlanoController {
    
    List<PlanoSeguro> planoSeguros = new ArrayList<>();
    
    @GetMapping("/api/plano")
    public List<PlanoSeguro> todosOsPlanos(){
        return planoSeguros;
    }

    @PostMapping("/api/plano")
    public ResponseEntity<PlanoSeguro> criandoPlano(PlanoSeguro plano){
        planoSeguros.add(plano);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    
}
