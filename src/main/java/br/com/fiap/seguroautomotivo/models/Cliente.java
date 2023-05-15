package br.com.fiap.seguroautomotivo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotBlank(message = "O CPF tem que ser preenchido.")
    @Pattern(regexp = "[0-9]{11}", message = "O CPF deve conter apenas números e ter 11 dígitos")
    private String cpf;

    @NotBlank(message = "A senha tem que ser preenchida.")
    private String senha;

    @OneToOne
    private Cotacao cotacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
