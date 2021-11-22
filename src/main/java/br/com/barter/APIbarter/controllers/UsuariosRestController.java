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

@RestController
@RequestMapping(value = "/usuarios/api/v1")
@CrossOrigin("*")
public class UsuariosRestController {
	
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;
	
	@GetMapping(value = "/all")
	public List<UsuarioDto> getAll() throws Exception{
		return usuarioServiceAPI.getAll();	
		}
	
	@GetMapping(value = "/find/{id}")
	public UsuarioDto find (@PathVariable String id) throws Exception{
		return usuarioServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save/{id}")
	public ResponseEntity<String> save (@RequestBody Usuario usuario, @PathVariable String id) throws Exception {
	if (id == null || id.length() == 0 || id.equals("null")) {
		id = usuarioServiceAPI.save(usuario);
	}else {
		usuarioServiceAPI.save(usuario, id);
	}
	return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
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


