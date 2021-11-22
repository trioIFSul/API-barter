package br.com.barter.APIbarter.modelos;

import lombok.Data;

@Data
public class Produto {

	private String nome;
	private String descricao;
	private String imgUrl;
	private int codigo_categoria;
	private int codigo_usuario;

}
