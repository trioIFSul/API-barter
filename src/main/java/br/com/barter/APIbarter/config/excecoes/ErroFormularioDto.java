package br.com.barter.APIbarter.config.excecoes;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ErroFormularioDto {
	
	private String data;
	private String Validacao;
	private String Erro;
	private String Atributo;	
	
	public ErroFormularioDto(String validacao, String atributo, String erro) {
		this.Validacao=validacao;
		this.Atributo=atributo;
		this.Erro=erro;			
		this.data=LocalDateTime.now().toString();
	}

	
}
