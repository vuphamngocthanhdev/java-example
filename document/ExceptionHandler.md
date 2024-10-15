
# **GlobalExceptionHandler Documentation**

## **Overview**
The `GlobalExceptionHandler` class is a centralized exception handler for RESTful applications in Spring Boot. It uses the `@RestControllerAdvice` annotation to handle exceptions globally, providing a consistent structure for error responses across all REST controllers.

This class is primarily focused on handling validation errors, such as those triggered when an invalid request body is submitted to a controller.

## **Annotations Used**
- **`@RestControllerAdvice`**: This annotation allows the class to handle exceptions for all `@RestController` components in the application. It combines `@ControllerAdvice` (to handle exceptions globally) with `@ResponseBody`, ensuring the response body is serialized as JSON or XML.
- **`@ResponseStatus(HttpStatus.BAD_REQUEST)`**: This annotation sets the HTTP status code for the response to `400 Bad Request`, which is typically returned when validation errors occur.
- **`@ExceptionHandler(MethodArgumentNotValidException.class)`**: This annotation designates a method as the handler for the `MethodArgumentNotValidException` exception. This exception is thrown when validation on a method argument fails (e.g., due to `@Valid` annotations).

## **ErrorResponse Class**
The `ErrorResponse` class is used as the response object when exceptions are caught. It contains the following fields:
- `timestamp`: The time when the error occurred.
- `status`: The HTTP status code (e.g., 400).
- `errors`: A list of validation error details.
- `path`: The URI path of the request that caused the error.

## **Errors Class**
The `Errors` class represents individual validation errors. It contains:
- `code`: The HTTP status code for the error (e.g., 400).
- `field`: The name of the field or object that failed validation.
- `message`: A descriptive message explaining the validation error.

## **Example Workflow**
1. A client sends a POST request with an invalid body (e.g., missing required fields).
2. Spring throws a `MethodArgumentNotValidException` due to the validation failure.
3. The `GlobalExceptionHandler` catches the exception.
4. The `handleValidation` method extracts the validation errors and builds an `ErrorResponse`.
5. The client receives a JSON response with the following structure:
   ```json
   {
     "timestamp": "2024-10-15T15:23:00",
     "status": 400,
     "errors": [
       {
         "code": 400,
         "field": "username",
         "message": "Username is required"
       },
       {
         "code": 400,
         "field": "email",
         "message": "Email is not valid"
       }
     ],
     "path": "/api/users"
   }
   ```

## **Benefits**
- **Centralized Exception Handling**: All exceptions are handled in one place, reducing duplication and improving maintainability.
- **Consistent Error Responses**: Ensures that error responses are consistently structured, making it easier for clients to handle errors.
- **Modular Design**: The use of small, focused methods makes the code easier to read, test, and maintain.

## **Conclusion**
The `GlobalExceptionHandler` class provides an efficient way to handle validation exceptions in a Spring Boot REST application. By using modular methods and centralized handling, it ensures a clean, maintainable solution for managing errors.
