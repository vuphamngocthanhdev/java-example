package com.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Errors {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String field;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
}
