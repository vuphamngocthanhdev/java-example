package com.springboot.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The @PhoneNumber annotation is a custom constraint annotation used for
 * validating phone numbers. It is documented and can be applied to fields.
 * <p>
 * - The @Constraint annotation specifies that the validation logic is provided
 *   by the `PhoneValidator` class.
 * - The @Target annotation defines that this constraint can be applied to fields.
 * - The @Retention annotation specifies that the annotation is retained at runtime,
 *   so it can be read via reflection during validation.
 * - The message() attribute is the default error message when the phone number
 *   is invalid.
 * - The groups() and payload() attributes allow for additional categorization
 *   of validation constraints (e.g., for group-based validation).
 *
 * @author Thanh
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {

	// Default error message when the phone number is invalid.
	String message() default "Invalid phone number";

	// Used for grouping validation constraints.
	Class<?>[] groups() default {};

	// Used for specifying custom payload objects for additional context or metadata.
	Class<? extends Payload>[] payload() default {};
}