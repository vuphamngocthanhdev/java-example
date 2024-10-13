package com.springboot.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * PhoneValidator is a custom implementation of the ConstraintValidator interface
 * that validates phone numbers according to specific patterns. It works in conjunction
 * with the @PhoneNumber annotation.
 * <p>
 * - The class implements `ConstraintValidator<PhoneNumber, String>` where
 *   `PhoneNumber` is the custom annotation, and `String` is the type of the field to validate.
 * - The `isValid` method contains the logic for validating phone numbers based
 *   on various common formats.
 *
 * @author Thanh
 */
public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

	/**
	 * The initialize method is part of the ConstraintValidator interface, and it's called
	 * before the `isValid` method. Since no initialization logic is needed here, this method
	 * is left empty.
	 */
	@Override
	public void initialize(PhoneNumber phoneNumberNo) {
		// No initialization required.
	}

	/**
	 * Validates the phone number based on predefined patterns.
	 * <p>
	 * - Phone numbers are validated for several common formats, including:
	 *     1. A standard 10-digit number (e.g., "0902345345").
	 *     2. Numbers separated by hyphens or spaces (e.g., "090-234-4567").
	 *     3. Numbers with extensions (e.g., "090-234-4567 ext123").
	 *     4. Numbers with area codes in parentheses (e.g., "(090)-234-4567").
	 * <p>
	 * - If the phone number matches one of these patterns, the method returns true;
	 *   otherwise, it returns false.
	 *
	 * @param phoneNo The phone number to be validated.
	 * @param cxt The context in which the constraint is evaluated.
	 * @return true if the phone number is valid; false otherwise.
	 */
	@Override
	public boolean isValid(String phoneNo, ConstraintValidatorContext cxt) {
		if (phoneNo == null) {
			return false;
		}
		// Validate phone number of format "0902345345" (10 digits).
		if (phoneNo.matches("\\d{10}")) return true;
			// Validate phone number with hyphens or spaces: "090-234-4567".
		else if (phoneNo.matches("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}")) return true;
			// Validate phone number with extension: "090-234-4567 ext123".
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
			// Validate phone number with area code in parentheses: "(090)-234-4567".
		else return phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}");
	}
}
