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


import br.com.fiap.seguroautomotivo.models.Cliente;
import br.com.fiap.seguroautomotivo.repository.ClienteRepository;

@RestController
@RequestMapping("api/cadastro")
public class ClienteController {
    
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> visualizarCadastrosCliente() {
       return clienteRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
         clienteRepository.save(cliente);
         return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // @PostMapping("/login")
    // public ResponseEntity<Boolean> verifica(@RequestBody Cliente cliente){
    //     Cliente clienteEncontrado = clienteRepository.findAll(cliente);
    //     if(!clienteEncontrado){
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(clienteEncontrado);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> encontraClientePorId(@PathVariable Long id){
        
        var clienteEncontrado = clienteRepository.findById(id);

        if (clienteEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(clienteEncontrado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizaCadastro(@PathVariable Long id, @RequestBody Cliente cliente) {

        var clientesncontrado = clienteRepository.findById(id);

        if (clientesncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> removerCadastro(@PathVariable Long id) {
        
       var clienteEncontrado = clienteRepository.findById(id);
        if(clienteEncontrado.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.delete(clienteEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
