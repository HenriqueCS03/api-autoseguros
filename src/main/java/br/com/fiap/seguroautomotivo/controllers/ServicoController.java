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

import br.com.fiap.seguroautomotivo.models.Servico;
import br.com.fiap.seguroautomotivo.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Servico")
public class ServicoController {
    
    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping
    public List<Servico> todosOsServicos() {
        return servicoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Servico> cadastrarServico(@Valid @RequestBody Servico servico){
        servicoRepository.save(servico);
         return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Servico> encontraServicoPorId(@PathVariable Long id){
        
        var servicoEncontrado = servicoRepository.findById(id);

        if (servicoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(servicoEncontrado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@Valid @PathVariable Long id ,@RequestBody Servico servico) {

        var servicoEncontrado = servicoRepository.findById(id);

        if (servicoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        servico.setId(id);
        servicoRepository.save(servico);

        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> removerServico(@PathVariable Long id) {
        
       var servicoEncontrado = servicoRepository.findById(id);
        
       if(servicoEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
       
        servicoRepository.delete(servicoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
