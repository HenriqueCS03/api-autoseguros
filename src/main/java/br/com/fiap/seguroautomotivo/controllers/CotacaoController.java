package br.com.fiap.seguroautomotivo.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Cotacao;

@RestController
//Controle de requisições e acionamento de classes
public class CotacaoController {
    
    @GetMapping("/api/cotacao")
    public Cotacao show(){
        Cotacao cotacao = new  Cotacao("Corsa", LocalDate.now(),false,"06050300","52324634899",false);
        return cotacao;
    }


}
