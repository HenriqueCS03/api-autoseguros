package br.com.fiap.seguroautomotivo.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.seguroautomotivo.models.Carro;
import br.com.fiap.seguroautomotivo.models.Servico;
import br.com.fiap.seguroautomotivo.repository.CarroRepository;
import br.com.fiap.seguroautomotivo.repository.ServicoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    CarroRepository CarroRepository;

    @Autowired
    ServicoRepository servicoRepository;

    @Override
    public void run(String... args) throws Exception {
        CarroRepository.saveAll(List.of(
            new Carro("ABC-1234", "Toyota Corolla",LocalDate.parse("2023-04-09")),
            new Carro("DEF-5678", "Volkswagen Jetta",LocalDate.parse("2022-01-01"))
        ));
        
        servicoRepository.saveAll(List.of(
             //Criar um objeto com builder
             Servico.builder().servicosNome("Roubo e Furto").valor(450).build(),
             Servico.builder().servicosNome("Eventos Naturais").valor(600).build(),
             Servico.builder().servicosNome("Incêndio").valor(800).build(),
             Servico.builder().servicosNome("Colisão(Batida)").valor(1000).build(),
             Servico.builder().servicosNome("Colisão(Perda Total)").valor(1500).build()
         ));
    }
}