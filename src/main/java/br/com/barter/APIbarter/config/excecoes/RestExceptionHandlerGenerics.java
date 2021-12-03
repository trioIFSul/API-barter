package br.com.barter.APIbarter.config.excecoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@RestControllerAdvice
public class RestExceptionHandlerGenerics extends ResponseEntityExceptionHandler {		

	
	  
	//-------------------------------------------------------------------------------------------------------------------------
	// CUANDO ENVIO POR EX UM ID DE CATEGORIA A DETALHE OU INTENTO REMOVER UM ITEM E O ID NAO EXISTE---------------------------	  
	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(Exception exc) {	    
		  HttpStatus httpStatus = HttpStatus.NOT_FOUND; //codigo 404
	    return buildResponseEntity(httpStatus, new RuntimeException("Registro nao encontrado, Id inexistente."));
	  }

	  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc) {
	    return buildResponseEntity(httpStatus, exc, null);
	  }
	  
	  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc, List<String> errors) {
			HttpStatus httpStatus1 = HttpStatus.NOT_FOUND;  // codigo 404
		    ErrorResponse error = new ErrorResponse();
		    error.setMessage("USRMSG--> " + exc.getMessage());
		    error.setStatus(httpStatus1.value());
		    error.setTimestamp(LocalDateTime.now().toString());
		    error.setErrors(errors);      
		    return new ResponseEntity<>(error, httpStatus1);
	  }
	 //-------------------------------------------------------------------------------------------------------------------------
	  	  
	  
	
     // ------------------------------------------------------------------------------------------------------------------------- 	  
	  //CUANDO ENVIO POR EJ UN string en lugar de un int por url ----------------------------------------------------------------
	 
	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {
	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	    // Aplica cuando en el URL se envia un argumento invalido, por ejemplo String
	    // por Integer
	    return buildResponseEntity(httpStatus, new RuntimeException("Tipo de Argumento invalido"));
	  }	  
	  //-------------------------------------------------------------------------------------------------------------------------
	  	  
	  
	  
	  
	  
	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc) {
	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	    return buildResponseEntity(httpStatus, exc);
	  }

	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(DuplicateKeyException exc) {
	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	    return buildResponseEntity(httpStatus, exc);
	  }

	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc) {
	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	    return buildResponseEntity(httpStatus, exc);
	  }
	  
	  
	  
}
