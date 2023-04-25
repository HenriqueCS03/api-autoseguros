package br.com.fiap.seguroautomotivo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao,Long>{
 
}
