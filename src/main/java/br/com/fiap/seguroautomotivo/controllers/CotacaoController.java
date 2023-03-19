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

import br.com.fiap.seguroautomotivo.models.Cotacao;

public class CotacaoController {
    
    List<Cotacao> cotacoes = new ArrayList<>();

    @GetMapping("/api/cotar")
    public ResponseEntity<List<Cotacao>> todosOsCarros() {
        return cotacoes.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(cotacoes);
    }

    @PostMapping("/api/cotar")
    public ResponseEntity<Cotacao> cadastrar(@RequestBody Cotacao cotacao){
        cotacoes.add(cotacao);
         return ResponseEntity.status(HttpStatus.CREATED).body(cotacao);
    }


    @PutMapping("/api/cotar")
    public ResponseEntity<Cotacao> atualizar(@RequestBody Cotacao cotacao) {

        var cotacaoEncontrado = cotacoes.stream().filter(c -> c.getId().equals(cotacao.getId())).findFirst();

        if (cotacaoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cotacoes.remove(cotacaoEncontrado.get());
        cotacoes.add(cotacao);

        return ResponseEntity.ok().body(cotacao);
    }

    @DeleteMapping("/api/cotar/{id}")
    public ResponseEntity<Cotacao> remover(@PathVariable Long id) {
        
       var cotacaoEncontrado = cotacoes.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(cotacaoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cotacoes.remove(cotacaoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
