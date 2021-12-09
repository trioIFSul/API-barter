package br.com.barter.APIbarter.dto;




import lombok.Data;


@Data

public class UsuarioDto {


	private String id;

	private int codigoUsuario;

	private String nome;
	
	private String nomeUsuario;

	private String email;

	private String senha;

	private String pais;

	private String cidade;

	private String bairro;

	private String endereco;
	
	
}
