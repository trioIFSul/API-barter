package br.com.barter.APIbarter.modelos;

import lombok.Data;

@Data
public class Categoria {
	
	private int codigo_categoria;
	private String nome;
	private String descricao;
	
	
	private Produto produto;
	

}
