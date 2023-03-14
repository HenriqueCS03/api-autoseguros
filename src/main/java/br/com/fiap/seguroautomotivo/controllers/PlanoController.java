package br.com.fiap.seguroautomotivo.controllers;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Cliente;
import br.com.fiap.seguroautomotivo.models.Plano;



@RestController
//Controle de requisições e acionamento de classes
public class PlanoController {
    
    
    @GetMapping("/api/plano")
    public List<Plano> show(){
        return plano.findAll();
    }

    @PostMapping("/api/plano")
    public void create(){
        
    }


}
