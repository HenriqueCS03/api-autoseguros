package br.com.fiap.seguroautomotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.PlanoSeguro;

public interface PlanoSeguroRepository extends JpaRepository<PlanoSeguro, Long> {
    
}
