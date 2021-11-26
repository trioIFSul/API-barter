package br.com.barter.APIbarter.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barter.APIbarter.dto.CategoriaDto;
import br.com.barter.APIbarter.modelos.Categoria;
import br.com.barter.APIbarter.service.api.CategoriaServiceAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/categorias/api/v1/")
@Api(value = "API REST Api-barter")
@CrossOrigin(origins="*")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaServiceAPI categoriaServiceAPI;

	@GetMapping(value = "/all")
	@Cacheable(value="listaDeCategorias")
	@ApiOperation(value="Retorna uma lista de Categorias")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Prohibido. O cliente se autentico mais nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<CategoriaDto> getAll() throws Exception {
		System.out.println("Executando metodo de listado de categorias !!! ");
		return categoriaServiceAPI.getAll();
		
	}

	@GetMapping(value = "/find/{id}")
	@ApiOperation(value="Retorna uma categoria", notes = "Este endpoint retorna uma categoria pelo String ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Busca de categoria pelo Id efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Prohibido. O cliente se autentico mais nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public CategoriaDto find(@PathVariable String id) throws Exception {
		return categoriaServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save/{id}")
	@ApiOperation(value="Cadastra e Atualiza uma categoria", notes = "Parâmetro null cria uma nova categoria e Parâmetro ID atualiza uma categoria")
	@CacheEvict(value = "listaDeCategorias", allEntries = true)
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Prohibido. O cliente se autentico mais nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ResponseEntity<String> save(@RequestBody @Valid Categoria categoria, @PathVariable String id) throws Exception {
	
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = categoriaServiceAPI.save(categoria);
		
		} else {
			categoriaServiceAPI.save(categoria, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	
	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value="Deleta uma categoria", notes = "Usar parâmetro id String para deletar uma categoria")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Categoria excluída com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Prohibido. O cliente se autentico mais nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
		
	})
	public ResponseEntity<CategoriaDto> delete(@PathVariable String id) throws Exception {
		CategoriaDto categoria = categoriaServiceAPI.get(id);
		
		if (categoria != null) {
			categoriaServiceAPI.delete(id);
	
		} else {
			return new ResponseEntity<CategoriaDto>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CategoriaDto>(categoria, HttpStatus.OK);
	}

}
