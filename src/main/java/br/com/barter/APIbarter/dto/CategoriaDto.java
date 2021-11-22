package br.com.barter.APIbarter.dto;

import br.com.barter.APIbarter.modelos.Produto;
import lombok.Data;

@Data
public class CategoriaDto {

	
	Long id;
	String nome;
	String descricao;
	
	
	Produto produto;
	
	

}
