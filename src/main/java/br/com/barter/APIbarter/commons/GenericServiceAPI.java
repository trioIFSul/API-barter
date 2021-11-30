package br.com.barter.APIbarter.commons;

import java.util.List;
import java.util.Map;

import com.google.cloud.firestore.CollectionReference;

import br.com.barter.APIbarter.dto.CategoriaDto;

public interface GenericServiceAPI<I, O> {

	String save(I entity, String id) throws Exception;

	String save(I entity) throws Exception;

	void delete(String id) throws Exception;

	O get(String id) throws Exception;

	Map<String, Object> getAsMap(String id) throws Exception;

	List<O> getAll() throws Exception;

	CollectionReference getAllpage() throws Exception;
	
}
