package br.com.barter.APIbarter.modelos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;


@Data
public class Produto {
 
	@NotNull @Min(value=1, message="Valor minimo e 1")
	private int codigoProduto;
	@NotNull @NotEmpty @Length (min = 5)
	private String nome;
	@NotNull @NotEmpty @Length (min = 5)
	private String descricao;
	@NotNull @NotEmpty @Length (min = 5)
	private String imgUrl;
	@NotNull @Min(value=1, message="Valor minimo e 1")
	private int codigoCategoria;
	@NotNull @Min(value=1, message="Valor minimo e 1")
	private int codigoUsuario;
 
}
