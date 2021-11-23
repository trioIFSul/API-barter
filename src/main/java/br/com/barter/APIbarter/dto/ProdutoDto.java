package br.com.barter.APIbarter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Valid
@Data
public class ProdutoDto {
	
	@NotNull @NotEmpty @Length (min = 5)
	private String id;
	@NotNull @NotEmpty @Length (min = 10)
	private String nome;
	@NotNull @NotEmpty @Length (min = 20)
	private String descricao;
	@NotNull @NotEmpty @Length (min = 5)
	private String imgUrl;
	@NotNull @NotEmpty @Length (min = 5)
	private int codigo_categoria;
	@NotNull @NotEmpty @Length (min = 5)
	private int codigo_usuario;
}
