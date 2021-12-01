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
import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.modelos.Usuario;
import br.com.barter.APIbarter.service.api.UsuarioServiceAPI;
import br.com.barter.APIbarter.util.TablesConstants;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDto> implements UsuarioServiceAPI {

	@Autowired
	private Firestore firestore;

	@Override
	public CollectionReference getCollection() {

		return firestore.collection("usuarios");
	}

	public List<Usuario> getAllAsc() throws InterruptedException, ExecutionException {

		ApiFuture<QuerySnapshot> query = (ApiFuture<QuerySnapshot>) firestore
				.collection(TablesConstants.COLLECTION_USUARIO).orderBy("codigo_usuario", Direction.ASCENDING).limit(4)
				.get();

		List<Usuario> usuarios = new ArrayList<>();
		for (QueryDocumentSnapshot usuario : query.get().getDocuments()) {
			usuarios.add(usuario.toObject(Usuario.class));
		}

		return usuarios;
	}

}
