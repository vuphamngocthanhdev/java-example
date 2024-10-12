package com.springboot.dto.request;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class UserRequestDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 8070354336800423708L;

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}
