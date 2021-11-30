package br.com.barter.APIbarter.service.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.barter.APIbarter.commons.GenericServiceAPI;
import br.com.barter.APIbarter.dto.CategoriaDto;
import br.com.barter.APIbarter.modelos.Categoria;

public interface CategoriaServiceAPI extends GenericServiceAPI<Categoria, CategoriaDto> {


	List<Categoria> getAllAsc() throws InterruptedException, ExecutionException;

	
}
