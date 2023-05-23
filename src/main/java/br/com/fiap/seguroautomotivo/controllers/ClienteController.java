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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@Tag(name="Cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    @Operation(summary = "Visualizar cadastros de clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cadastros de clientes obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<Cliente> visualizarCadastrosCliente() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> encontraClientePorId(@PathVariable Long id) {
        var clienteEncontrado = clienteRepository.findById(id);
        if (clienteEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clienteEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cadastro de um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro do cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> atualizaCadastro(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
        var clienteEncontrado = clienteRepository.findById(id);
        if (clienteEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover cadastro de um cliente pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cadastro do cliente removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> removerCadastro(@PathVariable Long id) {
        var clienteEncontrado = clienteRepository.findById(id);
        if (clienteEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.delete(clienteEncontrado.get());
        return ResponseEntity.noContent().build();
    }
}
