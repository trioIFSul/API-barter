package br.com.barter.APIbarter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

import br.com.barter.APIbarter.commons.GenericServiceImpl;
import br.com.barter.APIbarter.dto.UsuarioDto;
import br.com.barter.APIbarter.modelos.Usuario;
import br.com.barter.APIbarter.service.api.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, UsuarioDto> implements UsuarioServiceAPI{
	
	@Autowired
	private Firestore firestore;
	
	@Override
	public CollectionReference getCollection() {
		
		return firestore.collection("usuarios");
	}

}
