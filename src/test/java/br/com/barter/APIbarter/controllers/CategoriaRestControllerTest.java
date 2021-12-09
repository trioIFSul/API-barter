package br.com.barter.APIbarter.controllers;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.barter.APIbarter.ApiBarterApplicationTests;
import br.com.barter.APIbarter.dto.CategoriaDto;
import br.com.barter.APIbarter.service.api.CategoriaServiceAPI;



class CategoriaRestControllerTest extends ApiBarterApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CategoriaServiceAPI categoriaServiceAPI;
	
	@Test
	public void retornarSucesso_quandoRetornaListaDeCategorias() throws Exception{
		List<CategoriaDto> categoria = new ArrayList<>();
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setCodigoCategoria(1);
		categoria.add(categoriaDto);
		when(categoriaServiceAPI.getAll()).thenReturn(categoria);
		this.mockMvc
		.perform(get("/categorias/api/v1/all")).andExpect(status().is2xxSuccessful());
	}
	@Test
	public void retornarSucesso_quandoRetornarPorOrdemAscendente() throws Exception{
		List<CategoriaDto> categoria = new ArrayList<>();
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setCodigoCategoria(1);
		categoria.add(categoriaDto); 
		
		categoriaDto.setCodigoCategoria(2);
		categoria.add(categoriaDto);
		
		when(categoriaServiceAPI.getAllAsc()).thenReturn(null);
		this.mockMvc.perform(get("/categorias/api/v1/allASC")).andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	public void retornarSucesso_quandoRetornarPorOrdemDecresente() throws Exception{
		List<CategoriaDto> categoria = new ArrayList<>();
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setCodigoCategoria(1);
		categoria.add(categoriaDto);
		
		categoriaDto.setCodigoCategoria(2);
		categoria.add(categoriaDto);
		
		when(categoriaServiceAPI.getAllDec()).thenReturn(null);
		this.mockMvc.perform(get("/categorias/api/v1/allDEC")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void retornarSucesso_quandoBuscaProdutoPeloId() throws Exception {
		List<CategoriaDto> categoria = new ArrayList<>();
		CategoriaDto categoriaDto= new CategoriaDto();
		
		when(categoriaServiceAPI.get("3FYkQysrEoGMGle6Ztj")).thenReturn(categoriaDto);
		this.mockMvc.perform(get("/categorias/api/v1/find/id")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void retornarSucesso_quandoDeletarCategoriaPorId() throws Exception {
		List<CategoriaDto> categoria = new ArrayList<>();
		CategoriaDto categoriaDto = new CategoriaDto();
		
		categoriaDto.setId("3FYkQysrEoGMGle6Ztj");
		categoria.add(categoriaDto);
		
		when(categoriaServiceAPI.get("3FYkQysrEoGMGle6Ztj")).thenReturn(categoriaDto);
		this.mockMvc.perform(get("/categorias/api/v1/delete/id")).andExpect(status().is2xxSuccessful());
	}
	}