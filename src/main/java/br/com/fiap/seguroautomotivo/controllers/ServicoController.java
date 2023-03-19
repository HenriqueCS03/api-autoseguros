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

import br.com.fiap.seguroautomotivo.models.Servico;

public class ServicoController {
    
    private List<Servico> listServico = new ArrayList<>();

    @GetMapping("/api/isServico")
    public ResponseEntity<List<Servico>> todosOsServicos() {
        return listServico.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(listServico);
    }

    @PostMapping("/api/isServico")
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico){
        listServico.add(servico);
         return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }


    @PutMapping("/api/isServico")
    public ResponseEntity<Servico> atualizar(@RequestBody Servico servico) {

        var servicoEncontrado = listServico.stream().filter(s -> s.getId().equals(servico.getId())).findFirst();

        if (servicoEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listServico.remove(servicoEncontrado.get());
        listServico.add(servico);

        return ResponseEntity.ok().body(servico);
    }

    @DeleteMapping("/api/isServico/{id}")
    public ResponseEntity<Servico> remover(@PathVariable Long id) {
        
       var servicoEncontrado = listServico.stream().filter(s -> s.getId().equals(id)).findFirst();
        if(servicoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listServico.remove(servicoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
