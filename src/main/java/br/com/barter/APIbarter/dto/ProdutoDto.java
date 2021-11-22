package br.com.barter.APIbarter.dto;

import lombok.Data;

@Data
public class ProdutoDto {
	
	Long id;
	String nome;
	String descricao;
	String imgUrl;
}
