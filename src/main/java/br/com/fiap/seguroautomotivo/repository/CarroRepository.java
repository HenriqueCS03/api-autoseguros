package br.com.fiap.seguroautomotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Carro;

public interface CarroRepository extends JpaRepository<Carro,Long>{
    
}
