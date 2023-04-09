package br.com.fiap.seguroautomotivo.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.seguroautomotivo.models.Carro;
import br.com.fiap.seguroautomotivo.models.PlanoSeguro;
import br.com.fiap.seguroautomotivo.repository.CarroRepository;
import br.com.fiap.seguroautomotivo.repository.PlanoSeguroRepository;
import jakarta.validation.OverridesAttribute.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    CarroRepository CarroRepository;

    @Override
    public void run(String... args) throws Exception {
        CarroRepository.saveAll(List.of(
            new Carro("ABC-1234", "Toyota Corolla",LocalDate.parse("2023-04-09")),
            new Carro("DEF-5678", "Volkswagen Jetta", ,LocalDate.parse("2022-01-01") )
        ));
    
}
