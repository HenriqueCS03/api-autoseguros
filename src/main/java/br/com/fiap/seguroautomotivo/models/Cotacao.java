package br.com.fiap.seguroautomotivo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Carro carro;


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
