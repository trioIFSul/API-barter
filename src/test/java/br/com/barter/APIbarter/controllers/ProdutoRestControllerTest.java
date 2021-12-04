package br.com.barter.APIbarter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.service.impl.ProdutoServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc

class ProdutoRestControllerTest {
	
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
//	@MockBean
//	private ProdutoServiceAPI produtoServiceAPI;
	
	
	@MockBean
	private ProdutoServiceImpl produtoServiceAPI;
	

	@Test
	public void deveRetornarSucesso_QuandoBuscarListaDeProdutos() throws Exception {
		List<ProdutoDto> produtos = new ArrayList<>();
		ProdutoDto produtoDto = new ProdutoDto();
		
		produtoDto.setCodigo_produto(1);
		produtos.add(produtoDto);
		
		
		
		when(produtoServiceAPI.getAll()).thenReturn(produtos);
		
		
		this.mockMvc.perform(get("/produtos/api/v1/all")).andExpect(status().isOk());

	}


	
	
//	@Test
//	void testProdutosASC() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testProdutosDEC() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFind() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}

}
