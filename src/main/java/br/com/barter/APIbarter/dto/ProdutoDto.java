package br.com.barter.APIbarter.dto;

import lombok.Data;

@Data
public class ProdutoDto {
	
	
	private String id;
	
	private int codigoProduto;
	
	private String nome;

	private String descricao;

	private String imgUrl;

	private int codigoCategoria;
	
	private int codigoUsuario;
}
