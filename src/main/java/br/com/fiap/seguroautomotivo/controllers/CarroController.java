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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.exception.RestNotFoundException;
import br.com.fiap.seguroautomotivo.models.Carro;
import br.com.fiap.seguroautomotivo.repository.CarroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carroCliente")
@Tag(name = "Carro Cliente")
public class CarroController {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    @Operation(summary = "Obtém todos os carros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de carros obtida com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
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
    @Operation(summary = "Cadastra um novo carro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Carro cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Object> cadastrarCarro(
            @RequestBody @Valid Carro carro,
            BindingResult result) {
        // if(result.hasErrors()){
        //     return ResponseEntity.badRequest().body(new RestValidationError("erro de validação"));
        // }
        carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtém um carro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Carro encontrado"),
        @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Carro> encontraCarroPorId(
            @PathVariable Long id) {
        var carroEncontrado = carroRepository.findById(id);
        if (carroEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carroEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um carro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Carro atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Carro> atualizarCarro(
            @PathVariable Long id,
            @RequestBody @Valid Carro carro) {
        // var carroEncontrado = carroRepository.findById(id);
        // if (carroEncontrado.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        getCarro(id);
        carro.setId(id);
        carroRepository.save(carro);
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um carro por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Carro removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Carro> removerCarro(
            @PathVariable Long id) {
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
