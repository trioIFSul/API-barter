package br.com.barter.APIbarter.modelos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Data
public class Usuario {
	
	@NotNull @Min(value=1, message="Valor minimo e 1")
	private int codigo_usuario;
	@NotNull @NotEmpty @Length (min = 5)
	private String nome;
	@NotNull @NotEmpty @Length (min = 5)
	private String nomeUsuario;
	@NotNull @NotEmpty @Length (min = 5)
	private String email;
	@NotNull @NotEmpty @Length (min = 4)
	private String senha;
	@NotNull @NotEmpty @Length (min = 5)
	private String pais;
	@NotNull @NotEmpty @Length (min = 5)
	private String cidade;
	@NotNull @NotEmpty @Length (min = 5)
	private String bairro;
	@NotNull @NotEmpty @Length (min = 4)
	private String endereco;
	
	
	

}
