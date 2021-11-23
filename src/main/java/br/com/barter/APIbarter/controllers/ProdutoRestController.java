package br.com.barter.APIbarter.controllers;

import java.util.List;

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

@RestController
@RequestMapping(value = "/produtos/api/v1/")
@Api(value = "API REST Api-barter")
@CrossOrigin(origins="*")
public class ProdutoRestController {
	
	@Autowired
	private ProdutoServiceAPI produtoServiceAPI;

	
	@GetMapping(value = "/all")
	@ApiOperation(value="Retorna uma lista de Produtos")
	public List<ProdutoDto> getAll() throws Exception {
		return produtoServiceAPI.getAll();
	}

	@GetMapping(value = "/find/{id}")
	@ApiOperation(value="Retorna produto único por id")
	public ProdutoDto find(@PathVariable String id) throws Exception {
		return produtoServiceAPI.get(id);
	}

	@PostMapping(value = "/save/{id}")
	@ApiOperation(value="Salva um produto")
	public ResponseEntity<String> save(@RequestBody Produto produto, @PathVariable String id) throws Exception {
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = produtoServiceAPI.save(produto);
		} else {
			produtoServiceAPI.save(produto, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value="Deleta um produto por id")
	public ResponseEntity<ProdutoDto> delete(@PathVariable String id) throws Exception {
		ProdutoDto produto = produtoServiceAPI.get(id);
		if (produto != null) {
			produtoServiceAPI.delete(id);
		} else {
			return new ResponseEntity<ProdutoDto>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ProdutoDto>(produto, HttpStatus.OK);
	}
	
	


}
