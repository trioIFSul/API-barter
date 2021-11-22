package br.com.barter.APIbarter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

import br.com.barter.APIbarter.commons.GenericServiceImpl;
import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.modelos.Produto;
import br.com.barter.APIbarter.service.api.ProdutoServiceAPI;

@Service
public class ProdutoServiceImpl extends GenericServiceImpl<Produto, ProdutoDto> implements ProdutoServiceAPI{
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {		
		return firestore.collection("produtos");
	}

}
