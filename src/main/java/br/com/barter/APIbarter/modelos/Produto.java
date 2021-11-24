package br.com.barter.APIbarter.modelos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;


@Data
public class Produto {
 
	@NotNull
	private int codigo_produto;
	@NotNull @NotEmpty @Length (min = 5)
	private String nome;
	@NotNull @NotEmpty @Length (min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length (min = 5)
	private String imgUrl;
	@NotNull
	private int codigo_categoria;
	@NotNull 
	private int codigo_usuario;
 
}
