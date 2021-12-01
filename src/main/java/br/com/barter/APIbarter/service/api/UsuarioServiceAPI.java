package br.com.barter.APIbarter.service.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.barter.APIbarter.commons.GenericServiceAPI;
import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.modelos.Usuario;

public interface UsuarioServiceAPI extends GenericServiceAPI<Usuario, UsuarioDto>{

	List<Usuario> getAllAsc() throws InterruptedException, ExecutionException;

	List<Usuario> getAllDec() throws InterruptedException, ExecutionException;

}
