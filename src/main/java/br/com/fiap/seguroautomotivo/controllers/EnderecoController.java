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

import br.com.fiap.seguroautomotivo.models.Endereco;
import br.com.fiap.seguroautomotivo.repository.EnderecoRepository;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listarOsEnderecos(){
        return enderecoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco){
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> encontraEnderecoPorId(@PathVariable Long id){
        
        var enderecoEncontrado = enderecoRepository.findById(id);

        if (enderecoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(enderecoEncontrado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {

        var enderecoEncontrado = enderecoRepository.findById(id);

        if (enderecoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        enderecoRepository.save(endereco);

        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> removerEndereco(@PathVariable Long id) {
        
       var enderecoEncontrado = enderecoRepository.findById(id);
        
        if(enderecoEncontrado.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        enderecoRepository.delete(enderecoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
