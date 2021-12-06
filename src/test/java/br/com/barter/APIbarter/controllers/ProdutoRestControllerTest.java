package br.com.barter.APIbarter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.barter.APIbarter.commons.GenericServiceImpl;
import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.service.api.ProdutoServiceAPI;
import br.com.barter.APIbarter.util.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   //  --> Sobe todo o contexto da aplicação

class ProdutoRestControllerTest {
	
	
	
	@Autowired
	private MockMvc mockMvc;   //  --> ponto de entrada p/ o endpoint
	
	
	
	
	@MockBean
	private ProdutoServiceAPI produtoServiceAPI;
	

	@MockBean
	private GenericServiceImpl genericServiceImpl;
	

	
	
//	@BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(produtoServiceAPI)
//                .setCustomArgumentResolvers(new PathVariableMethodArgumentResolver())
//                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
//                .build();
//    }
	
	
	
	
	

	@Test
	public void deveRetornarSucesso_QuandoBuscarListaDeProdutos() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigo_produto(1);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAll()).thenReturn(produtos);		
		this.mockMvc
				.perform(get("/produtos/api/v1/all"))
				.andExpect(status().is2xxSuccessful());

	}


	


	
	@Test
	public void deveRetornarSucesso_QuandoBuscarListaDeProdutosPorOrdemAscendente() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigo_produto(1);
		produtos.add(produtoDto);	
		
		produtoDto.setCodigo_produto(2);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAllAsc()).thenReturn(null);		
		this.mockMvc.perform(get("/produtos/api/v1/allASC")).andExpect(status().is2xxSuccessful());
	}


	


	@Test
	public void deveRetornarSucesso_QuandoBuscarListaDeProdutosPorOrdemDecrescente() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigo_produto(1);
		produtos.add(produtoDto);	
		
		produtoDto.setCodigo_produto(2);
		produtos.add(produtoDto);	
		
		when(produtoServiceAPI.getAllDec()).thenReturn(null);		
		this.mockMvc.perform(get("/produtos/api/v1/allDEC")).andExpect(status().is2xxSuccessful());
	}



/*	
	@Test
	public void deveRetornarSucesso_QuandoCriarNovoProduto() throws Exception {
	
		
//		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoEsperado = new ProdutoDto();
//		produtoEsperado.setCodigo_produto(5);
		produtoEsperado.setId("null");
		produtoEsperado.setNome("Teclado");
		produtoEsperado.setDescricao("Teclado Gamer XForce");
		produtoEsperado.setImgUrl("https://http2.mlstatic.com/D_NQ_NP_958652-MLB26608865323_012018-O.jpg");
		produtoEsperado.setCodigo_categoria(1);
		produtoEsperado.setCodigo_usuario(2);
			
//		produtos.add(produtoEsperado);
		
//		when(produtoServiceAPI.save(any(Produto.class))).thenReturn(null);	
		
		when(produtoServiceAPI.save(null)).thenReturn(null);
						
		ProdutoDto produtoASalvar = new ProdutoDto();
		produtoASalvar.setId("null");
		produtoASalvar.setNome("Teclado");
		produtoASalvar.setDescricao("Teclado Gamer XForce");
		produtoASalvar.setImgUrl("https://http2.mlstatic.com/D_NQ_NP_958652-MLB26608865323_012018-O.jpg");
		produtoASalvar.setCodigo_categoria(1);
		produtoASalvar.setCodigo_usuario(2);
				
		

		
		 this.mockMvc
			.perform(MockMvcRequestBuilders.post("/produtos/api/v1/save/null")	
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.content(JsonUtils.toJson(produtoASalvar)))
		    .andExpect(status().isCreated())
//		    .andExpect(status().isOk())
		    .andExpect(content().json(JsonUtils.toJson(produtoEsperado)));
//		    .andExpect(content().contentType("application/json;charset=UTF-8"));
			
	}

	
	
	
	
	 public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	 }

*/	 
	 
	 
	 

	
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarListaDeProdutosPorId() throws Exception {	
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

