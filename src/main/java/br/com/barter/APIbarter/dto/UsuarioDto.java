package br.com.barter.APIbarter.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.google.firebase.database.annotations.NotNull;

import lombok.Data;

@Valid
@Data

public class UsuarioDto {

	@NotNull @NotEmpty @Length (min = 5)
	private String id;
	@NotNull @NotEmpty @Length (min = 5)
	private int codigo_usuario;
	@NotNull @NotEmpty @Length (min = 10)
	private String nome;
	@NotNull @NotEmpty @Length (min = 5)
	private String nomeusuario;
	@NotNull @NotEmpty @Length (min = 15)
	private String email;
	@NotNull @NotEmpty @Length (min = 8)
	private String senha;
	@NotNull @NotEmpty @Length (min = 6)
	private String pais;
	@NotNull @NotEmpty @Length (min = 5)
	private String cidade;
	@NotNull @NotEmpty @Length (min = 5)
	private String bairro;
	@NotNull @NotEmpty @Length (min = 10)
	private String endereco;
	
	
}
