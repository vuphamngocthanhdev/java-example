package com.springboot.dto.response;

import org.springframework.http.HttpStatus;

/**
 * A subclass of ResponseSuccess that represents a failure response for an API.
 * This class is used to handle scenarios where an operation fails, but it leverages
 * the same structure as a successful response by extending `ResponseSuccess`.
 * <p>
 * It allows for consistent formatting of error responses while maintaining the status
 * and message structure.
 *
 * @author Thanh
 */
public class ResponseFailure extends ResponseSuccess{
	/**
	 * Constructs a new ResponseFailure object, extending the structure of a
	 * successful response, but used specifically for failure cases.
	 * This constructor sets the HTTP status and failure message, which
	 * will provide clients with error details.
	 *
	 * @param status the HTTP status code indicating failure (e.g., 400 for Bad Request, 500 for Internal Server Error, etc.)
	 * @param message a descriptive message explaining the reason for the failure, providing details to the client
	 *
	 * @author Thanh
	 */
	public ResponseFailure(HttpStatus status, String message) {
		super(status, message);
	}
}
