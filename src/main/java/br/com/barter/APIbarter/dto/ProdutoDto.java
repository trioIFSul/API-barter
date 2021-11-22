package br.com.barter.APIbarter.dto;

import lombok.Data;

@Data
public class ProdutoDto {
	
	private String id;
	private String nome;
	private String descricao;
	private String imgUrl;
	private int codigo_categoria;
	private int codigo_usuario;
}
