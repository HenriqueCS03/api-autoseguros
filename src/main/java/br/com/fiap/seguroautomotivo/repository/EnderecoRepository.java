package br.com.fiap.seguroautomotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
