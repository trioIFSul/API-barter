package br.com.barter.APIbarter.config.excecoes;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@ControllerAdvice
public class RestExceptionHandlerTests extends ResponseEntityExceptionHandler {		   
	  
	  // PROBADO , SALE CUANDO ENVIO POR EJ UN string en lugar de un int por url -------------------------------------------------
	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(MethodArgumentTypeMismatchException exc) {
	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	    // Aplica cuando en el URL se envia un argumento invalido, por ejemplo String
	    // por Integer
	    return buildResponseEntity(httpStatus, new RuntimeException("Tipo de Argumento invalido"));
	  }
	  //-------------------------------------------------------------------------------------------------------------------------
	  
	  

	// PROBADO Y TIRO PROBLEMA CUANDO ENVIE POST CON UN ID YA EXISTENTE -------------------------------------------------------  
	  @ExceptionHandler
	  protected ResponseEntity<ErrorResponse> handleException(Exception exc) {
	    //HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; //reponderia 500
		  HttpStatus httpStatus = HttpStatus.BAD_REQUEST; //responde 400
	    return buildResponseEntity(httpStatus, new RuntimeException("Se presento un problema, reporte e intente luego."));
	  }

	  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc) {
	    return buildResponseEntity(httpStatus, exc, null);
	  }
	  //-------------------------------------------------------------------------------------------------------------------------
	  
	  	  

	  // PROBADO CUANDO ENVIO POR EJ UN ID DE USUARIO A DETALLE QUE NO EXISTE----------------------------------------------------
	  private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exc, List<String> errors) {
		HttpStatus httpStatus1 = HttpStatus.NOT_FOUND;  // codigo 404
	    ErrorResponse error = new ErrorResponse();
	    error.setMessage("USRMSG--> " + exc.getMessage());
	    error.setStatus(httpStatus1.value());
	    error.setTimestamp(new Date());
	    error.setErrors(errors);      
	    return new ResponseEntity<>(error, httpStatus1);
	  }
	  // -------------------------------------------------------------------------------------------------------------------------
	  
	  
	  
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
