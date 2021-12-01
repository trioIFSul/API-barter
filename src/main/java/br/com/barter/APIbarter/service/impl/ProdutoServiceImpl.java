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
import br.com.barter.APIbarter.dto.ProdutoDto;
import br.com.barter.APIbarter.modelos.Produto;
import br.com.barter.APIbarter.service.api.ProdutoServiceAPI;
import br.com.barter.APIbarter.util.TablesConstants;

@Service
public class ProdutoServiceImpl extends GenericServiceImpl<Produto, ProdutoDto> implements ProdutoServiceAPI{
	
	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {		
		return firestore.collection("produtos");
	}
	
	public List<Produto> getAllAsc() throws InterruptedException, ExecutionException {

		ApiFuture<QuerySnapshot> query = (ApiFuture<QuerySnapshot>) firestore
				.collection(TablesConstants.COLLECTION_PRODUTO).orderBy("codigo_produto", Direction.ASCENDING)
				.limit(4).get();

		List<Produto> produtos = new ArrayList<>();
		for (QueryDocumentSnapshot produto : query.get().getDocuments()) {
			produtos.add(produto.toObject(Produto.class));
		}

		return produtos;
	}

	
	
	public List<Produto> getAllDec() throws InterruptedException, ExecutionException {

		ApiFuture<QuerySnapshot> query = (ApiFuture<QuerySnapshot>) firestore
				.collection(TablesConstants.COLLECTION_PRODUTO).orderBy("codigo_produto", Direction.DESCENDING)
				.limit(4).get();

		List<Produto> produtos = new ArrayList<>();
		for (QueryDocumentSnapshot produto : query.get().getDocuments()) {
			produtos.add(produto.toObject(Produto.class));
		}

		return produtos;
	}
	
}
