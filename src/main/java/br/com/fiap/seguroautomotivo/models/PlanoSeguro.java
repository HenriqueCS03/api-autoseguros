package br.com.fiap.seguroautomotivo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlanoSeguro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A cotação não pode ser nula.")
    @Valid
    @OneToOne
    private Cotacao cotacao;

    @NotNull(message = "A lista de serviços não pode ser nula.")
    @Size(min = 1, message = "A lista de serviços deve conter pelo menos um serviço.")
    @ManyToMany
    private List<Servico> servicos = new ArrayList<Servico>();

    private boolean status;

    @Min(value = 0)
    @NotNull(message = "O valor total não pode ser nulo.")
    private double valorTotal;

    
    public PlanoSeguro(Long id, Cotacao cotacao, List<Servico> servicos ,boolean status) {
        this.id = id;
        this.cotacao = cotacao;
        //Adicionando servicos
        this.servicos = servicos;
        this.status = status;
        //Calculando valor total toda vez que o objeto for acionado
        calcularValorTotal();
    }
  
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	private double calcularValorTotal() {
        for (Servico servico : servicos) {
            valorTotal += servico.getValor();
        }
        return valorTotal;
    }
  
}
