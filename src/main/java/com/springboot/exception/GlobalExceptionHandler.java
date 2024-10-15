package com.springboot.exception;

import com.springboot.dto.response.ErrorResponse;
import com.springboot.dto.response.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GlobalExceptionHandler is a centralized exception handler for REST controllers.
 * It intercepts specific exceptions thrown by the application and provides a
 * consistent response structure.
 *
 * @author Thanh
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles MethodArgumentNotValidException, typically triggered by validation failures.
	 *
	 * @param e the exception that contains validation error details
	 * @param request the web request, used to extract path information
	 * @return a structured ErrorResponse with the error details, status, and request path
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleValidation(MethodArgumentNotValidException e, WebRequest request) {
		List<Errors> errors = extractErrors(e);
		return buildErrorResponse(errors, request);
	}

	/**
	 * Extracts validation errors from the MethodArgumentNotValidException.
	 *
	 * @param e the exception containing validation errors
	 * @return a list of Errors objects
	 */
	private List<Errors> extractErrors(MethodArgumentNotValidException e) {
		return e.getAllErrors().stream()
				.map(error -> Errors.builder()
						.code(HttpStatus.BAD_REQUEST.value())
						.field(error.getObjectName())
						.message(error.getDefaultMessage())
						.build())
				.toList();
	}

	/**
	 * Builds a structured ErrorResponse object.
	 *
	 * @param errors  the list of validation errors
	 * @param request the web request to extract the request path
	 * @return the constructed ErrorResponse object
	 */
	private ErrorResponse buildErrorResponse(List<Errors> errors, WebRequest request) {
		return ErrorResponse.builder()
				.timestamp(LocalDateTime.now().withNano(0))
				.status(HttpStatus.BAD_REQUEST.value())
				.errors(errors)
				.path(extractPath(request))
				.build();
	}

	/**
	 * Extracts the request path from the WebRequest object.
	 *
	 * @param request the web request to extract the path from
	 * @return the extracted request path as a String
	 */
	private String extractPath(WebRequest request) {
		return request.getDescription(false).replace("uri=", "");
	}
}
