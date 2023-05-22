package br.com.fiap.seguroautomotivo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.exception.RestNotFoundException;
import br.com.fiap.seguroautomotivo.models.Carro;
import br.com.fiap.seguroautomotivo.repository.CarroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carroCliente")
public class CarroController {
    
    @Autowired
    CarroRepository carroRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public List<Carro> todosOsCarros() {
       return carroRepository.findAll();
    }

    // @GetMapping
    // public PagedModel<EntityModel<Object>> todosOsCarros(@RequestParam(required = false) String modelo, @PageableDefault(size = 5) Pageable pageable) {
    //     Page<Carro> carros = (modelo == null)?
    //         carroRepository.findAll(pageable): 
    //         carroRepository.pesquisarPorModelo(modelo, pageable);
    //     return assembler.toModel(carros.map(Carro::toEntityModel));
    // }

    @PostMapping
    public ResponseEntity<Object> cadastrarCarro(@RequestBody @Valid Carro carro, BindingResult result){
        // if(result.hasErrors()){
        //     return ResponseEntity.badRequest().body(new RestValidationError("erro de validação"));
        // }
        carroRepository.save(carro);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(carro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> encontraCarroPorId(@PathVariable Long id){
        
         var carroEncontrado = carroRepository.findById(id);

         if (carroEncontrado.isEmpty())
             return ResponseEntity.notFound().build();

        return ResponseEntity.ok(carroEncontrado.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@Valid @PathVariable Long id, @RequestBody Carro carro) {

        // var carroEncontrado = carroRepository.findById(id);

        // if (carroEncontrado.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        getCarro(id);
        carro.setId(id);
        carroRepository.save(carro);
        

        return  ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> removerCarro(@PathVariable Long id) {
        
       var carroEncontrado = getCarro(id);
        
    //    if(carroEncontrado.isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }


        carroRepository.delete(carroEncontrado);

        return ResponseEntity.noContent().build();
    }
    
    private Carro getCarro(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("carro não encontrado"));
    }
}
