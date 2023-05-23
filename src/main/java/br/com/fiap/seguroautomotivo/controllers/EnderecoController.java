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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/endereco")
@Tag(name="Endereço")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    @Operation(summary = "Listar todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todos os endereços obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<Endereco> listarOsEnderecos() {
        return enderecoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar um endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Endereço cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Endereco> cadastrarEndereco(@Valid @RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de um endereço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço encontrado"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Endereco> encontraEnderecoPorId(@PathVariable Long id) {
        var enderecoEncontrado = enderecoRepository.findById(id);
        if (enderecoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(enderecoEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um endereço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Endereco> atualizarEndereco(@Valid @PathVariable Long id, @RequestBody Endereco endereco) {
        var enderecoEncontrado = enderecoRepository.findById(id);
        if (enderecoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        enderecoRepository.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um endereço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Endereço removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Endereco> removerEndereco(@PathVariable Long id) {
        var enderecoEncontrado = enderecoRepository.findById(id);
        if (enderecoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.delete(enderecoEncontrado.get());
        return ResponseEntity.noContent().build();
    }
}
