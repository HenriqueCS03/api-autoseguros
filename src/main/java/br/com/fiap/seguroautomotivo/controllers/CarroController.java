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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Carro;

@RestController
public class CarroController {
    
    List<Carro> listCarros = new ArrayList<>();

    @GetMapping("/api/carroCliente")
    public ResponseEntity<List<Carro>> todosOsCarros() {
        return listCarros.isEmpty()
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok(listCarros);
    }

    @PostMapping("/api/carroCliente")
    public ResponseEntity<Carro> cadastrar(@RequestBody Carro carro){
         listCarros.add(carro);
         return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }


    @PutMapping("/api/carrosCliente")
    public ResponseEntity<Carro> atualizar(@RequestBody Carro carro) {

        var carroEncontrado = listCarros.stream().filter(c -> c.getId().equals(carro.getId())).findFirst();

        if (carroEncontrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listCarros.remove(carroEncontrado.get());
        listCarros.add(carro);

        return ResponseEntity.ok().body(carro);
    }

    @DeleteMapping("/api/carrosCliente/{id}")
    public ResponseEntity<Carro> remover(@PathVariable Long id) {
        
       var carroEncontrado = listCarros.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(carroEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        listCarros.remove(carroEncontrado.get());

        return ResponseEntity.noContent().build();
    }
}
