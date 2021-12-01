package br.com.barter.APIbarter.service.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.barter.APIbarter.commons.GenericServiceAPI;
import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.modelos.Produto;

public interface ProdutoServiceAPI extends GenericServiceAPI<Produto, ProdutoDto>{

	List<Produto> getAllAsc() throws InterruptedException, ExecutionException;

	List<Produto> getAllDec() throws InterruptedException, ExecutionException;

}
