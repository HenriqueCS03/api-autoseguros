package br.com.fiap.seguroautomotivo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O carro não pode ser nulo")
    @Valid
    @OneToMany
    private List<Carro> carros = new ArrayList<Carro>();

    @OneToOne
    private PlanoSeguro planoSeguro;

    @OneToOne
    private Cliente cliente;

    @NotBlank(message = "O uso tem que ser preenchido.")
    private String usoDoCarro;

    private boolean blindagem;

    @NotNull(message = "O endereço não pode ser nulo")
    @Valid
    @OneToOne
    private Endereco endereco;

    private boolean idadeMinima;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
     
}
