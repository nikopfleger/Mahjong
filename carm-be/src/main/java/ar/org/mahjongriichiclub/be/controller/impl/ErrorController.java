package ar.org.mahjongriichiclub.be.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.org.mahjongriichiclub.be.exception.ServiceException;
import ar.org.mahjongriichiclub.be.generic.model.response.ApiError;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	private ObjectMapper om = new ObjectMapper();

	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Object> handleException(Throwable ex, WebRequest request) throws IOException {
		LogManager.getLogger(getClass()).error("Error on request \n" + request.toString(), ex);
		List<String> errors = new ArrayList<String>();

		if (HttpClientErrorException.class.isAssignableFrom(ex.getClass())) {
			Object o = om.readValue(((RestClientResponseException) ex).getResponseBodyAsString(), Object.class);
			return new ResponseEntity<Object>(o, HttpStatus.BAD_REQUEST);
		} else if (ServiceException.class.isAssignableFrom(ex.getClass())) {
			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "ERROR", ex.getLocalizedMessage());
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LogManager.getLogger(getClass()).error("Error on request \n" + request.toString(), ex);
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}