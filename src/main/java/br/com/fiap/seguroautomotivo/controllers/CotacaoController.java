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

import br.com.fiap.seguroautomotivo.exception.RestNotFoundException;
import br.com.fiap.seguroautomotivo.models.Cotacao;
import br.com.fiap.seguroautomotivo.repository.CotacaoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cotar")
@Tag(name="Cotação")
public class CotacaoController {

    @Autowired
    CotacaoRepository cotacaoRepository;

    @GetMapping
    @Operation(summary = "Obter todas as cotações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de todas as cotações obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<Cotacao> todosAsCotacoes() {
        return cotacaoRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma cotação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cotação cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cotacao> cadastrarCotacao(@Valid @RequestBody Cotacao cotacao) {
        cotacaoRepository.save(cotacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(cotacao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter detalhes de uma cotação pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cotação encontrada"),
            @ApiResponse(responseCode = "404", description = "Cotação não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cotacao> encontraCotacaoPorId(@PathVariable Long id) {
        var cotacaoEncontrado = cotacaoRepository.findById(id);
        if (cotacaoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cotacaoEncontrado.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma cotação pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cotação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cotação não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cotacao> atualizarCotacao(@Valid @PathVariable Long id, @RequestBody Cotacao cotacao) {
        getCotacao(id);
        cotacao.setId(id);
        cotacaoRepository.save(cotacao);
        return ResponseEntity.ok(cotacao);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma cotação pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cotação removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cotação não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cotacao> removerCotacao(@PathVariable Long id) {
        cotacaoRepository.delete(getCotacao(id));
        return ResponseEntity.noContent().build();
    }

    private Cotacao getCotacao(Long id) {
        return cotacaoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Cotação não encontrada"));
    }
}
