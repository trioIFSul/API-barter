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

import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.modelos.Usuario;
import br.com.barter.APIbarter.service.api.UsuarioServiceAPI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/usuarios/api/v1")
@Api(value = "API REST Api-barter")
@CrossOrigin(origins="*")
public class UsuarioRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioRestController.class);
	
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;

	@GetMapping(value = "/all")
	@ApiOperation(value = "Retorna uma lista de Usuários")
	@ApiResponses({ @ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
			@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
			@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
			@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.") })
	public List<UsuarioDto> getAll() throws Exception {
		logger.info("Listando todos os Usuarios");
		return usuarioServiceAPI.getAll();
	}

	@GetMapping(value = "/allASC")
	@ApiOperation(value="Lista de Usuários paginada em ordem ASCENDENTE")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuaida com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<Usuario> UsuariosASC() throws ExecutionException, InterruptedException {
		logger.info("Testando metodo de paginação em ordem crescente!!! ");
		return usuarioServiceAPI.getAllAsc();
	}
	
	
	
	@GetMapping(value = "/allDEC")
	@ApiOperation(value="Lista de Usuários paginada em ordem DECRESCENTE")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public List<Usuario> UsuariosDEC() throws ExecutionException, InterruptedException {
		logger.info("Testando metodo de paginação em ordem decrescente !!! ");
		return usuarioServiceAPI.getAllDec();
	}
	
	
	
	@GetMapping(value = "/find/{id}")
	@ApiOperation(value="Retorna um usuário", notes = "Este endpoint retorna um usuário pelo String Id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Busca de usuário pelo Id efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public UsuarioDto find (@PathVariable String id) throws Exception{
		logger.info("Visualizando 1 Usuario por id {}", id);
		return usuarioServiceAPI.get(id);
	}
	
	@PostMapping(value = "/save/{id}")
	@ApiOperation(value="Cadastra e Atualiza um usuário", notes = "Parâmetro null cria um novo usuário e Parâmetro Id atualiza um usuário")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Operação efetuada com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ResponseEntity<String> save (@RequestBody @Valid Usuario usuario, @PathVariable String id) throws Exception {
	if (id == null || id.length() == 0 || id.equals("null")) {
		id = usuarioServiceAPI.save(usuario);
		logger.info("Criando Usuario com data {}", usuario);
	}else {
		usuarioServiceAPI.save(usuario, id);
		logger.info("Atualizando Usuario com data {}", usuario);
	}
	return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	@ApiOperation(value="Deleta um usuário", notes = "Usar parâmetro id String para deletar um usuário")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Usuário excluído com sucesso!"),
		@ApiResponse(code = 401, message = "Usuario nao autorizado para esta operacao!"),
		@ApiResponse(code = 403, message = "Proibido. O cliente se autenticou mas nao tem a permissao para aceder ao recurso solicitado."),
		@ApiResponse(code = 404, message = "Nao encontrado: o recurso solicitado nao existe.")
	})
	public ResponseEntity<UsuarioDto> delete (@PathVariable String id) throws Exception{
		UsuarioDto usuario = usuarioServiceAPI.get(id);
		if (usuario != null) {
			logger.info("Removendo Usuario com id {}", id);
			usuarioServiceAPI.delete(id);
		} else {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<UsuarioDto>(usuario,HttpStatus.OK);
		
		}
	}


