package br.com.fiap.seguroautomotivo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.PlanoSeguro;
import br.com.fiap.seguroautomotivo.repository.PlanoSeguroRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/assinar")
//Controle de requisições e acionamento de classes
public class PlanoSeguroController {
    
    @Autowired
    PlanoSeguroRepository planoSeguroRepository;

    @GetMapping
    public List<PlanoSeguro> todosOsPlanos() {
        return planoSeguroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<PlanoSeguro> cadastrarPlano(@Valid @RequestBody PlanoSeguro planoSeguro){
        planoSeguroRepository.save(planoSeguro);
         return ResponseEntity.status(HttpStatus.CREATED).body(planoSeguro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoSeguro> encontraPlanoPorId(@PathVariable Long id){
        
        var planoEncontrado = planoSeguroRepository.findById(id);

        if (planoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(planoEncontrado.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlanoSeguro> atualizarPlano(@Valid @PathVariable Long id, @RequestBody PlanoSeguro planoSeguro) {

        var planoEncontrado = planoSeguroRepository.findById(id);

        if (planoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        planoSeguro.setId(id);
        planoSeguroRepository.save(planoSeguro);

        return ResponseEntity.ok(planoSeguro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlanoSeguro> removerPlano(@PathVariable Long id) {
        
       var planoEncontrado = planoSeguroRepository.findById(id);
        
       if(planoEncontrado.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        planoSeguroRepository.delete(planoEncontrado.get());
        
        return ResponseEntity.noContent().build();
    }
    
}
