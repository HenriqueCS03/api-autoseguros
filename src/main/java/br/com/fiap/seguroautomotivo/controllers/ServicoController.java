package br.com.fiap.seguroautomotivo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.seguroautomotivo.models.Servico;
import br.com.fiap.seguroautomotivo.repository.ServicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Servico")
@Tag(name="Serviço")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping
    @Operation(summary = "Listar todos os serviços")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todos os serviços obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<Servico> todosOsServicos() {
        return servicoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar um serviço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Serviço cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Servico> cadastrarServico(@Valid @RequestBody Servico servico) {
        servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de um serviço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço encontrado"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Servico> encontraServicoPorId(@PathVariable Long id) {
        var servicoEncontrado = servicoRepository.findById(id);
        if (servicoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(servicoEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um serviço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Servico> atualizarServico(@Valid @PathVariable Long id, @RequestBody Servico servico) {
        var servicoEncontrado = servicoRepository.findById(id);
        if (servicoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
       servico.setId(id);
        servicoRepository.save(servico);
        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover um serviço pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Serviço removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Servico> removerServico(@PathVariable Long id) {
        var servicoEncontrado = servicoRepository.findById(id);
        if (servicoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        servicoRepository.delete(servicoEncontrado.get());
        return ResponseEntity.noContent().build();
    }
}
