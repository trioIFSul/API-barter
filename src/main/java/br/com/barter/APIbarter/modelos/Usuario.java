package br.com.barter.APIbarter.modelos;

import lombok.Data;

@Data
public class Usuario {
	private int codigo_usuario;
	private String nome;
	private String nomeUsuario;
	private String email;
	private String senha;
	private String pais;
	private String cidade;
	private String bairro;
	private String endereco;
	
	
	

}
