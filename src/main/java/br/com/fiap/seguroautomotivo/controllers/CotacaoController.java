package br.com.fiap.seguroautomotivo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
//Controle de requisições e acionamento de classes
public class CotacaoController {
    
    @GetMapping("/api/cotar")
    public String show(){
        return "cotacao";
    }


}
