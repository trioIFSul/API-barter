package br.com.barter.APIbarter.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query.Direction;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import br.com.barter.APIbarter.commons.GenericServiceImpl;
import br.com.barter.APIbarter.dto.CategoriaDto;
import br.com.barter.APIbarter.modelos.Categoria;
import br.com.barter.APIbarter.service.api.CategoriaServiceAPI;
import br.com.barter.APIbarter.util.TablesConstants;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<Categoria, CategoriaDto> implements CategoriaServiceAPI {
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {
		return firestore.collection("categorias");
	}

	
		

	public List<Categoria> getAllAsc() throws InterruptedException, ExecutionException { 
		
		ApiFuture<QuerySnapshot> query = (ApiFuture<QuerySnapshot>) firestore.collection(
				TablesConstants.COLLECTION_CATEGORIA).orderBy("codigoCategoria", Direction.ASCENDING).limit(4).get();

		
		List<Categoria> categorias = new ArrayList<>();
		for (QueryDocumentSnapshot categoria: query.get().getDocuments()) {
			categorias.add(categoria.toObject(Categoria.class));
		}
	
		return categorias;
	}

	public List<Categoria> getAllDec() throws InterruptedException, ExecutionException {

		ApiFuture<QuerySnapshot> query = (ApiFuture<QuerySnapshot>) firestore
				.collection(TablesConstants.COLLECTION_CATEGORIA).orderBy("codigoCategoria", Direction.DESCENDING)
				.limit(4).get();

		List<Categoria> categorias = new ArrayList<>();
		for (QueryDocumentSnapshot categoria : query.get().getDocuments()) {
			categorias.add(categoria.toObject(Categoria.class));
		}

		return categorias;
	}

}
