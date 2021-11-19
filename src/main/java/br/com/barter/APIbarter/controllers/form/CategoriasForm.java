package br.com.barter.APIbarter.controllers.form;

import br.com.barter.APIbarter.modelos.Produtos;
import lombok.Data;

@Data
public class CategoriasForm {
	
	String nome;
	String descricao;
	
	
	Produtos produto;
	


}
