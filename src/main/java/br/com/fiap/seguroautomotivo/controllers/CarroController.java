package br.com.fiap.seguroautomotivo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<EntityModel<Object>> todosOsCarros(@RequestParam(required = false) String modelo, @PageableDefault(size = 5) Pageable pageable) {
        Page<Carro> carros = (modelo == nul)?
            carroRepository.findAll(pageable) 
            carroRepository.pesquisarPorModelo(modelo, pageable);
        return assembler.toModel(carros.map(Carro::toEntityModel)); 
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarCarro(@RequestBody @Valid Carro carro, BindingResult result){
        // if(result.hasErrors()){
        //     return ResponseEntity.badRequest().body(new RestValidationError("erro de validação"));
        // }
        carroRepository.save(carro);
        return ResponseEntity
                .created(carro.toEntityModel().getRequiredLink("self").toUri())
                .body(carro.toEntityModel());
    }

    @GetMapping("/{id}")
    public EntityModel<Carro> encontraCarroPorId(@PathVariable Long id){
        
        // var carroEncontrado = carroRepository.findById(id);

        // if (carroEncontrado.isEmpty())
        //     return ResponseEntity.notFound().build();

        return getCarro(id).EntityModel();
    }

    @PutMapping("/{id}")
    public EntityModel<Carro> atualizarCarro(@Valid @PathVariable Long id, @RequestBody Carro carro) {

        // var carroEncontrado = carroRepository.findById(id);

        // if (carroEncontrado.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        getCarro(id);
        carro.setId(id);
        carroRepository.save(carro);
        

        return carro.toEntityModel();
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
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("carro não encontrado"));
    }
}
