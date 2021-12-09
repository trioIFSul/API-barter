package br.com.barter.APIbarter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.barter.APIbarter.ApiBarterApplicationTests;
import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.service.api.ProdutoServiceAPI;


@DisplayName("ProdutoRestControllerTest")
class ProdutoRestControllerTest extends ApiBarterApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;   //  --> ponto de entrada p/ o endpoint
	
	
	@MockBean
	private ProdutoServiceAPI produtoServiceAPI;
	
	

	@Test
	@DisplayName("deve retornar uma lista de Produtos")
	public void deveRetornarListaDeProdutos() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigoProduto(1);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAll()).thenReturn(produtos);		
		this.mockMvc
				.perform(get("/produtos/api/v1/all"))
				.andExpect(status().is2xxSuccessful());

	}

	
	@Test
	@DisplayName("deve retornar uma lista de Produtos em ordem Ascendente")
	public void deveRetornarListaDeProdutosAscendente() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigoProduto(1);
		produtos.add(produtoDto);	
		
		produtoDto.setCodigoProduto(2);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAllAsc()).thenReturn(null);		
		this.mockMvc.perform(get("/produtos/api/v1/allASC")).andExpect(status().is2xxSuccessful());
	}



	@Test
	@DisplayName("deve retornar uma lista de Produtos em ordem Decrescente")
	public void deveRetornarListaDeProdutosDecrescente() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigoProduto(1);
		produtos.add(produtoDto);	
		
		produtoDto.setCodigoProduto(2);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAllDec()).thenReturn(null);		
		this.mockMvc.perform(get("/produtos/api/v1/allDEC")).andExpect(status().is2xxSuccessful());
	}

	 

	
	
	@Test
	@DisplayName("deve buscar um Produto pelo Id")
	public void deveRetornarProdutoPorId() throws Exception {	
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setId("3FYkQysrEoGMGle6Ztj");
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.get("3FYkQysrEoGMGle6Ztj")).thenReturn(produtoDto);		
		this.mockMvc
				.perform(get("/produtos/api/v1/find/id"))
				.andExpect(status().isOk());

	}

	
	@Test
	@DisplayName("deve deletar um Produto pelo Id")
	public void deveRetornarSucesso_QuandoDeletarProdutoPorId() throws Exception {
		
		List<ProdutoDto> produto = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setId("3FYkQysrEoGMGle6Ztj");
		produto.add(produtoDto);
//		produto.remove(produtoDto);	
		
		
		when(produtoServiceAPI.get("3FYkQysrEoGMGle6Zt")).thenReturn(produtoDto);	
		
		
		this.mockMvc
			.perform(get("/produtos/api/v1/delete/id"))
			.andExpect(status().is2xxSuccessful());
	

	}
}

