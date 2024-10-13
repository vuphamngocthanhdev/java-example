## Validation data input use dependency
***
*pom.xml*
```xml
<dependencies>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.6.0</version>
    </dependency>
</dependencies>
```
***
### Quy trình validation
- **Bước 1:** Thêm các annotation ràng buộc các field của class. Mỗi annotation có ý nghĩa riêng.
        Ví dụ : `@NotNull` , `@NotEmpty`, ...
***
```
@NotBlank(message = "firstName must be not blank")
private String firstName;

// Last name of the user; cannot be null.
@NotNull(message = "lastName must be not null")
private String lastName;

// Phone number with custom validation.
@PhoneNumber
private String phone;
```
***
- **Bước 2:** Class đó được dùng ở vị trí nào cần đảm bảo hợp lệ,thì thêm `@Valid` hoặc `@Validated`
````
@PostMapping
@Operation(summary = "Add New User", description = "Adds a new user with the provided details.")
    public String add(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return "User added";
}
````
***
***Ngoài ra khi validation để đảm bảo yêu cầu chúng ta có thể custom lại các annotation.***

````
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
````
- Ref:` https://www.baeldung.com/spring-boot-bean-validation`