package br.com.barter.APIbarter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/categorias/api/v1/")
@CrossOrigin("*")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaServiceAPI categoriaServiceAPI;

	@GetMapping(value = "/all")
	@Cacheable(value="listaDeCategorias")
	public List<CategoriaDto> getAll() throws Exception {
		return categoriaServiceAPI.getAll();
		
	}

	@GetMapping(value = "/find/{id}")
	public CategoriaDto find(@PathVariable String id) throws Exception {
		return categoriaServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save(@RequestBody Categoria categoria, @PathVariable String id) throws Exception {
	
		if (id == null || id.length() == 0 || id.equals("null")) {
			id = categoriaServiceAPI.save(categoria);
		
		} else {
			categoriaServiceAPI.save(categoria, id);
		}
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	
	@GetMapping(value = "/delete/{id}")
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
