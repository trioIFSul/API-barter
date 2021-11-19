package br.com.barter.APIbarter.controllers.dto;

import br.com.barter.APIbarter.modelos.Produtos;
import lombok.Data;

@Data
public class DetalheCategoriasDto {
	
	Long id;
	String nome;
	String descricao;
	
	
	Produtos produto;
	

}
