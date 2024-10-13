package com.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ResponseData<T> implements Serializable {
	private final int status;
	private final String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T data;

	/**
	 * Constructs a new ResponseData object representing a successful API response.
	 * This is specifically used for GET and POST requests to return the response
	 * data along with the HTTP status code and an appropriate message.
	 *
	 * @param status the HTTP status code (e.g., 200 for OK, 201 for Created, etc.)
	 * @param message a descriptive message corresponding to the status
	 * @param data the actual data payload that is being returned in the response
	 */
	public ResponseData(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * Constructs a new ResponseData object for cases where the API operation executes
	 * successfully or encounters an error, specifically for PUT, PATCH, and DELETE
	 * requests. This version does not include a data payload and only returns the
	 * HTTP status code and a message.
	 *
	 * @param status the HTTP status code (e.g., 200 for success, 400 for bad request, etc.)
	 * @param message a descriptive message corresponding to the status, such as success or error details
	 */
	public ResponseData(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
