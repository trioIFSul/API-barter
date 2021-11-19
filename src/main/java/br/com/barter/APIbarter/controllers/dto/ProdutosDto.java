package br.com.barter.APIbarter.controllers.dto;

import lombok.Data;

@Data
public class ProdutosDto {
	
	Long id;
	String nome;
	String descricao;
	String imgUrl;
}
