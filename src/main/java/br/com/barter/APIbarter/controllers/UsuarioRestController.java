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

import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.modelos.Usuario;
import br.com.barter.APIbarter.service.api.UsuarioServiceAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/usuarios/api/v1")
@Api(value = "API REST Api-barter")
@CrossOrigin(origins="*")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;
	
	@GetMapping(value = "/all")
	@ApiOperation(value="Retorna uma lista de Usuários")
	public List<UsuarioDto> getAll() throws Exception{
		return usuarioServiceAPI.getAll();	
		}
	
	@GetMapping(value = "/find/{id}")
	@ApiOperation(value="Retorna usuário único por id")
	public UsuarioDto find (@PathVariable String id) throws Exception{
		return usuarioServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save/{id}")
	@ApiOperation(value="Salva um usuário")
	public ResponseEntity<String> save (@RequestBody Usuario usuario, @PathVariable String id) throws Exception {
	if (id == null || id.length() == 0 || id.equals("null")) {
		id = usuarioServiceAPI.save(usuario);
	}else {
		usuarioServiceAPI.save(usuario, id);
	}
	return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value="Deleta um usuário por id")
	public ResponseEntity<UsuarioDto> delete (@PathVariable String id) throws Exception{
		UsuarioDto usuario = usuarioServiceAPI.get(id);
		if (usuario != null) {
			usuarioServiceAPI.delete(id);
		} else {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<UsuarioDto>(usuario,HttpStatus.OK);
		
		}
	}


