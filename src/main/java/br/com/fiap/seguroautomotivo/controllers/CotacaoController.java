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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cotar")
public class CotacaoController {
    
    @Autowired
    CotacaoRepository cotacaoRepository;

    @GetMapping
    public List<Cotacao> todosAsCotacoes() {
        return cotacaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cotacao> cadastrarCotacao(@Valid @RequestBody Cotacao cotacao){
        cotacaoRepository.save(cotacao);
         return ResponseEntity.status(HttpStatus.CREATED).body(cotacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotacao> encontraCotacaoPorId(@PathVariable Long id){
        
        var cotacaoEncontrado = cotacaoRepository.findById(id);

        if (cotacaoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cotacaoEncontrado.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cotacao> atualizarCotacao(@Valid @PathVariable Long id, @RequestBody Cotacao cotacao) {

        // var cotacaoEncontrado = cotacaoRepository.findById(id);

        // if (cotacaoEncontrado.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        getCotacao(id);
        cotacao.setId(id);
        cotacaoRepository.save(cotacao);

        return ResponseEntity.ok(cotacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cotacao> removerCotacao(@PathVariable Long id) {
        
    //    var cotacaoEncontrado = cotacaoRepository.findById(id);
    //     if(cotacaoEncontrado.isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }
        cotacaoRepository.delete(getCotacao(id));

        return ResponseEntity.noContent().build();
    }
    
    private Cotacao getCotacao(Long id) {
        return cotacaoRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("cotação não encontrado"));
    }
}
