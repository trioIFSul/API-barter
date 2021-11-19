package br.com.barter.APIbarter.controllers.form;

import br.com.barter.APIbarter.modelos.Produtos;
import lombok.Data;

@Data
public class AtualizarCategoriasForm {
	
	String nome;
	String descricao;
	
	
	Produtos produto;

}
