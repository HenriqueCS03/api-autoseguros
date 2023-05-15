package br.com.fiap.seguroautomotivo.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.fiap.seguroautomotivo.controllers.CarroController;
import br.com.fiap.seguroautomotivo.controllers.CotacaoController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Carro{
    
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

    @ManyToOne
    private Cotacao cotacao;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public EntityModel<Carro>  toEntityModel(){
    //     return EntityModel.of(
    //     		this,
    //             linkTo(methodOn(CarroController.class).encontraCarroPorId(id)).withSelfRel(),
    //             linkTo(methodOn(CarroController.class).removerCarro(id)).withRel("delete"),
    //             linkTo(methodOn(CarroController.class).todosOsCarros(null,Pageable.unpaged())).withRel("all"),
    //             linkTo(methodOn(CotacaoController.class).encontraCotacaoPorId(this.getCotacao().getId())).withRel("cotacao")  
    //     );
    // }
}
