package com.springboot.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {
	private LocalDateTime timestamp;
	private int status;
	private String path;
	private List<Errors> errors;
}
