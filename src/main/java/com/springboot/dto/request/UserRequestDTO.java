package com.springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.util.PhoneNumber;
import jakarta.validation.constraints.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * UserRequestDTO is a Data Transfer Object (DTO) used to encapsulate
 * and validate incoming user-related request data. It implements the
 * Serializable interface for object serialization.
 * <p>
 * - The class includes various validation annotations from `jakarta.validation.constraints`
 *   to ensure data integrity for each field.
 * - The @Getter annotation from Lombok automatically generates getter methods for all fields.
 * - Custom validation is used for the phone number field through the @PhoneNumber annotation.
 * - The dateOfBirth field is formatted using both @JsonFormat and @DateTimeFormat to ensure
 *   the proper format for both JSON serialization and Spring's date parsing.
 * - The serialVersionUID provides a unique identifier to ensure the object is compatible
 *   across different JVM implementations during serialization and deserialization.
 *
 * @author Thanh
 */
@Getter
public class UserRequestDTO implements Serializable {
	// Unique identifier for object serialization.
	@Serial
	private static final long serialVersionUID = 8070354336800423708L;

	// First name of the user; cannot be blank.
	@NotBlank(message = "firstName must be not blank")
	private String firstName;

	// Last name of the user; cannot be null.
	@NotNull(message = "lastName must be not null")
	private String lastName;

	// Phone number with custom validation.
	@PhoneNumber
	private String phone;

	// Email address; must be in a valid format.
	@Email(message = "email invalid format")
	private String email;

	// User's date of birth; required and formatted for both JSON and Spring.
	@JsonFormat(pattern = "MM/dd/yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull(message = "dateOfBirth must be not null")
	private LocalDate dateOfBirth;

	// A list of permissions; must not be empty.
	@NotEmpty(message = "permission must be empty")
	List<String> permission;
}
