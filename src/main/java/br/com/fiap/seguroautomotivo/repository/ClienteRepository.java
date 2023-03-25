package br.com.fiap.seguroautomotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
