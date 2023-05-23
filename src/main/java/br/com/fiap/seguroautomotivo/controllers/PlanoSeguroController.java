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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assinar")
@Tag(name="Plano Seguro")
public class PlanoSeguroController {

    @Autowired
    PlanoSeguroRepository planoSeguroRepository;

    @GetMapping
    @Operation(summary = "Listar todos os planos de seguro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todos os planos obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<PlanoSeguro> todosOsPlanos() {
        return planoSeguroRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar um plano de seguro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plano de seguro cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<PlanoSeguro> cadastrarPlano(@Valid @RequestBody PlanoSeguro planoSeguro) {
        planoSeguroRepository.save(planoSeguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(planoSeguro);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de um plano de seguro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano de seguro encontrado"),
            @ApiResponse(responseCode = "404", description = "Plano de seguro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<PlanoSeguro> encontraPlanoPorId(@PathVariable Long id) {
        var planoEncontrado = planoSeguroRepository.findById(id);
        if (planoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(planoEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um plano de seguro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano de seguro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano de seguro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
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
    @Operation(summary = "Remover um plano de seguro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Plano de seguro removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano de seguro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<PlanoSeguro> removerPlano(@PathVariable Long id) {
        var planoEncontrado = planoSeguroRepository.findById(id);
        if (planoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        planoSeguroRepository.delete(planoEncontrado.get());
        return ResponseEntity.noContent().build();
    }
}
