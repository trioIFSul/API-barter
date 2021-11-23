package br.com.barter.APIbarter.dto;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;
@Valid
@Data
public class CategoriaDto {

	@NotNull @NotEmpty @Length (min = 5)
	private String id;
	@NotNull @NotEmpty @Length (min = 5)
	private int codigo_categoria;
	@NotNull @NotEmpty @Length (min = 1)
	private String nome;
	@NotNull @NotEmpty @Length (min = 20)
	private String descricao;
	
	
}
