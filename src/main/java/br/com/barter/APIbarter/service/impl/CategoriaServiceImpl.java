package br.com.barter.APIbarter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

import br.com.barter.APIbarter.commons.GenericServiceImpl;
import br.com.barter.APIbarter.dto.CategoriaDto;
import br.com.barter.APIbarter.modelos.Categoria;
import br.com.barter.APIbarter.service.api.CategoriaServiceAPI;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<Categoria, CategoriaDto> implements CategoriaServiceAPI {
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {
		return firestore.collection("categorias");
	}

}
