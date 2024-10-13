package com.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * A custom response entity class used to represent a successful API response.
 * It extends `ResponseEntity` to provide a standardized structure for successful
 * responses, encapsulating HTTP status, message, and optional data.
 * <p>
 * This class provides multiple constructors to support various use cases such as
 * basic success messages, responses with data, or responses with custom headers.
 *
 * @author Thanh
 */
public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Payload> {

	/**
	 * Constructs a ResponseSuccess object with a status and message, but without any additional data.
	 * The response is always returned with an HTTP 200 OK status.
	 *
	 * @param status the HTTP status code to be included in the payload (converted to int)
	 * @param message a descriptive message indicating the success
	 */
	public ResponseSuccess(HttpStatus status, String message) {
		super(new Payload(status.value(), message), HttpStatus.OK);
	}


	/**
	 * Constructs a ResponseSuccess object with a status, message, and additional data.
	 * This can be used to return both the success message and relevant data in the response body.
	 *
	 * @param status the HTTP status code (e.g., 200 for OK, 201 for Created, etc.)
	 * @param message a descriptive message indicating the success
	 * @param data the additional data to be included in the response body
	 */
	public ResponseSuccess(HttpStatus status, String message, Object data) {
		super(new Payload(status.value(), message, data), status);
	}

	/**
	 * Constructs a ResponseSuccess object with a custom payload and status.
	 *
	 * @param body the custom payload that includes status, message, and optional data
	 * @param status the HTTP status code
	 */
	public ResponseSuccess(Payload body, HttpStatus status) {
		super(body, status);
	}


	/**
	 * Constructs a ResponseSuccess object with custom headers and status, without a body.
	 *
	 * @param headers custom HTTP headers to include in the response
	 * @param status the HTTP status code
	 */
	public ResponseSuccess(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
	}

	/**
	 * Constructs a ResponseSuccess object with a custom payload, headers, and a raw status code.
	 *
	 * @param payload the custom payload that includes status, message, and optional data
	 * @param headers custom HTTP headers to include in the response
	 * @param rawStatus the raw integer status code
	 */
	public ResponseSuccess(Payload payload, MultiValueMap<String, String> headers, int rawStatus) {
		super(payload, headers, rawStatus);
	}

	/**
	 * Constructs a ResponseSuccess object with a custom payload, headers, and status.
	 *
	 * @param payload the custom payload that includes status, message, and optional data
	 * @param headers custom HTTP headers to include in the response
	 * @param status the HTTP status code
	 */
	public ResponseSuccess(Payload payload, MultiValueMap<String, String> headers, HttpStatus status) {
		super(payload, headers, status);
	}

	/**
	 * Inner static class representing the payload of the response.
	 * The payload contains the HTTP status code, a descriptive message,
	 * and optionally, additional data.
	 */
	@Getter
	public static class Payload {
		private final int status;
		private final String message;
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private Object data;

		/**
		 * Constructs a Payload object with just the status and message.
		 *
		 * @param status the HTTP status code as an integer
		 * @param message a descriptive message for the response
		 */
		public Payload(int status, String message) {
			this.status = status;
			this.message = message;
		}
		/**
		 * Constructs a Payload object with just the status and message.
		 *
		 * @param status the HTTP status code as an integer
		 * @param message a descriptive message for the response
		 */
		public Payload(int status, String message, Object data) {
			this.status = status;
			this.message = message;
			this.data = data;
		}
	}
}
