package br.com.barter.APIbarter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.service.api.UsuarioServiceAPI;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class UsuarioRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsuarioServiceAPI usuarioServiceAPI;

	@Test
	@DisplayName("deve retornar uma lista de Usuários")
	public void deveRetornarListaDeUsuarios() throws Exception {
		List<UsuarioDto> usuarios = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setCodigoUsuario(1);
		usuarios.add(usuarioDto);	
		
		when(usuarioServiceAPI.getAll()).thenReturn(usuarios);		
		this.mockMvc
				.perform(get("/usuarios/api/v1/all"))
				.andExpect(status().is2xxSuccessful());

	}

	@Test
	@DisplayName("deve retornar uma lista de Usuários em ordem Ascendente")
	public void deveRetornarListaDeUsuariosAscendente() throws Exception {
		List<UsuarioDto> usuarios = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setCodigoUsuario(1);
		usuarios.add(usuarioDto);	
		
		usuarioDto.setCodigoUsuario(2);
		usuarios.add(usuarioDto);	
		
		when(usuarioServiceAPI.getAllAsc()).thenReturn(null);		
		this.mockMvc.perform(get("/usuarios/api/v1/allASC")).andExpect(status().is2xxSuccessful());
	}


	@Test
	@DisplayName("deve retornar uma lista de Usuários em ordem Decrescente")
	public void deveRetornarListaDeUsuariosDecrescente() throws Exception {
		List<UsuarioDto> usuarios = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setCodigoUsuario(1);
		usuarios.add(usuarioDto);	
		
		usuarioDto.setCodigoUsuario(2);
		usuarios.add(usuarioDto);	
		
		when(usuarioServiceAPI.getAllDec()).thenReturn(null);		
		this.mockMvc.perform(get("/produtos/api/v1/allDEC")).andExpect(status().is2xxSuccessful());
	}

	@Test
	@DisplayName("deve buscar um Usuario pelo Id")
	public void deveRetornarUsuarioPorId() throws Exception {	
		List<UsuarioDto> usuarios = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId("3FYkQysrEoGMGle6Ztj");
		usuarios.add(usuarioDto);	
		
		when(usuarioServiceAPI.get("3FYkQysrEoGMGle6Ztj")).thenReturn(usuarioDto);		
		this.mockMvc
				.perform(get("/usuarios/api/v1/find/id"))
				.andExpect(status().isOk());

	}

	@Test
	@DisplayName("deve deletar um Usuario pelo Id")
	public void deveDeletarUsuarioPorId() throws Exception {
		
		List<UsuarioDto> usuario = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId("3FYkQysrEoGMGle6Ztj");
		usuario.add(usuarioDto);
//		produto.remove(produtoDto);	
		
		
		when(usuarioServiceAPI.get("3FYkQysrEoGMGle6Zt")).thenReturn(usuarioDto);	
		
		
		this.mockMvc
			.perform(get("/usuarios/api/v1/delete/id"))
			.andExpect(status().is2xxSuccessful());
	

	}

}
