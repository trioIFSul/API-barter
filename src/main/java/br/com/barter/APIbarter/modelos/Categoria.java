package br.com.barter.APIbarter.modelos;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
@Valid
public class Categoria {
	
	@NotNull  @Min(value=1, message="Valor minimo e 1")
	private int codigoCategoria;
	@NotNull @NotEmpty @Length (min = 5, max = 20)
	private String nome;
	@NotNull @NotEmpty @Length (min = 5, max = 50)
	private String descricao;
	

}
