package br.com.fiap.seguroautomotivo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.seguroautomotivo.models.Servico;

public class ServicoController {
    
    private List<Servico> listServico = new ArrayList<>();

    @GetMapping("/api/isServico")
    public List<Servico> listarServico(Servico servico){
        listServico.add(servico);
        return listServico;
    }

}
