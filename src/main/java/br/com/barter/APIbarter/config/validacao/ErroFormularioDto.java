package br.com.barter.APIbarter.config.validacao;

public class ErroFormularioDto {
	
	private String erro;
	private String campo;
	
	public ErroFormularioDto(String campo, String erro) {
		this.campo=campo;
		this.erro=erro;
	}

	public String getErro() {
		return erro;
	}

	public String getCampo() {
		return campo;
	}

}
