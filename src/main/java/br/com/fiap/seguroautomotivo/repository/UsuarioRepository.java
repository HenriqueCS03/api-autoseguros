package br.com.fiap.seguroautomotivo.repository;

import java.util.Optional;

import javax.swing.text.html.Option;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.seguroautomotivo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email); 

}
