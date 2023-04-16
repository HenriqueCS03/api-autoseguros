package br.com.fiap.seguroautomotivo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Long>{
    Page<Servico> pesquisarPorNomeServico(String servicosNome, Pageable pageable);
}
