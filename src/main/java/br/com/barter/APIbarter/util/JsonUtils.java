package br.com.barter.APIbarter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static String toJson(Object object) throws JsonProcessingException {
		return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(object);
		
	}

}
