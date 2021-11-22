package br.com.barter.APIbarter.dto;

import lombok.Data;

@Data


public class UsuarioDto {

	private String id;
	private int codigo_usuario;
	private String nome;
	private String nomeusuario;
	private String email;
	private String senha;
	private String pais;
	private String cidade;
	private String bairro;
	private String endereco;
	
}
