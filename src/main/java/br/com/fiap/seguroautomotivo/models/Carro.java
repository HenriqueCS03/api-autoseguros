package br.com.fiap.seguroautomotivo.models;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "A placa tem que ser preenchido.")
    @Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "A placa deve estar no formato AAA-1234")
    private String placa;

    @NotBlank(message = "O modelo tem que ser preenchido.")
    private String modelo;

    @NotNull(message = "A data não pode ser nula")
    @Temporal(TemporalType.DATE)
    private LocalDate ano;

    public Carro(String placa, String modelo, LocalDate ano){
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }
}
