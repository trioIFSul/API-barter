package br.com.barter.APIbarter.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.modelos.Produto;
import br.com.barter.APIbarter.service.api.ProdutoServiceAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/produtos/api/v1/")
@Api(value = "API REST Api-barter")
@CrossOrigin(origins="*")
public class ProdutoRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoRestController.class);
	
	@Autowired
	private ProdutoServiceAPI produtoServiceAPI;

	
	@GetMapping(value = "/all")
	@ApiOperation(value="Retorna uma lista de Produtos")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<ProdutoDto> getAll() throws Exception {		
		logger.info("Listando todas os Produtos");	
		return produtoServiceAPI.getAll();
	}
	
	
	@GetMapping(value = "/allASC")
	@ApiOperation(value="Lista de Produtos paginada em ordem ASCENDENTE")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuaida com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<Produto> ProdutosASC() throws ExecutionException, InterruptedException {
		logger.info("Testando metodo de paginação !!! ");
		return produtoServiceAPI.getAllAsc();
		
	}
	
	@GetMapping(value = "/allDEC")
	@ApiOperation(value="Lista de Produtos paginada em ordem DECRESCENTE")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuaida com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<Produto> ProdutosDEC() throws ExecutionException, InterruptedException {
		logger.info("Testando metodo de paginação em ordem decrescente!!! ");
		return produtoServiceAPI.getAllDec();
	}
	
	

	@GetMapping(value = "/find/{id}")
	@ApiOperation(value="Retorna um produto", notes = "Este endpoint retorna um produto pelo String ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Busca de produto pelo Id efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ProdutoDto find(@PathVariable String id) throws Exception {		
		logger.info("Visualizando 1 Produto por id {}", id);		
		return produtoServiceAPI.get(id);
	}

	@PostMapping(value = "/save/{id}")
	@ApiOperation(value="Cadastra e Atualiza um produto", notes = "Parâmetro null cria um novo produto e Parâmetro ID atualiza um produto")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ResponseEntity<String> save(@RequestBody @Valid Produto produto, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("new")) {			
			logger.info("Criando Produto com data {}", produto);			
			id = produtoServiceAPI.save(produto);
		} else {			
			logger.info("Atualizando Produto com data {}", produto);			
			produtoServiceAPI.save(produto, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value="Deleta um produto", notes = "Usar parâmetro id String para deletar um produto")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Produto excluído com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ResponseEntity<ProdutoDto> delete(@PathVariable String id) throws Exception {
		ProdutoDto produto = produtoServiceAPI.get(id);
		if (produto != null) {
			logger.info("Removendo Produto com id {}", id);
			produtoServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ProdutoDto>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ProdutoDto>(produto, HttpStatus.OK);
	}
	
	


}
