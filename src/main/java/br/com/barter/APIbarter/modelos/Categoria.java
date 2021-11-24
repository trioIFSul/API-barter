package br.com.barter.APIbarter.modelos;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;


@Data
@Valid
public class Categoria {
	
	@NotNull  
	private int codigo_categoria;
	@NotNull @NotEmpty @Length (min = 5)
	private String nome;
	@NotNull @NotEmpty @Length (min = 20)
	private String descricao;
	

}
