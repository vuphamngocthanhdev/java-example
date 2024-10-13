package com.springboot.controller;

import com.springboot.dto.request.UserRequestDTO;
import com.springboot.dto.response.ResponseData;
import com.springboot.dto.response.ResponseFailure;
import com.springboot.dto.response.ResponseSuccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController is responsible for handling user-related requests.
 * It provides APIs to create, update, delete, and retrieve user information.
 * <p>
 * The methods in this class are mapped to endpoints that start with "/user".
 *
 * @author Thanh
 */
@RestController
@RequestMapping("/user")
@Tag(name = "User Management")
public class UserController {

	/**
	 * Retrieves user information by their ID.
	 * <p>
	 * This method handles GET requests to fetch details of a user identified by their unique `userID`.
	 *
	 * @param userID the unique identifier of the user to be retrieved
	 * @return a message containing the user's information (currently returns a placeholder)
	 *
	 * @author Thanh
	 */
	@GetMapping("/{userID}")
	@Operation(summary = "Get User by ID", description = "Retrieves user information by their ID.")
	public ResponseSuccess get(@Min(1) @PathVariable Long userID){
		System.out.println("Request get user detail, userId=" + userID);
		try {
			return new ResponseSuccess(HttpStatus.OK, "user",
					UserRequestDTO.builder()
							.firstName("thanh")
							.lastName("vu")
							.phone("0981700700")
							.email("vuphamngocthanh.dev@gmail.com")
							.build());
		} catch (Exception e) {
			return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	/**
	 * Adds a new user with the provided information.
	 *
	 * @param userRequestDTO - the request body containing the new user information
	 * (annotated with @RequestBody to bind the HTTP request's body to this parameter)
	 *
	 * @return a message indicating the user was added
	 *
	 * @author Thanh
	 */
	@PostMapping
	@Operation(summary = "Add New User", description = "Adds a new user with the provided details.")
	public ResponseSuccess add(@Valid @RequestBody UserRequestDTO userRequestDTO) {
		try {
			return new ResponseSuccess(HttpStatus.OK, "User added",
					UserRequestDTO.builder()
							.firstName(userRequestDTO.getFirstName())
							.lastName(userRequestDTO.getLastName())
							.build()
			);
		}catch (Exception e) {
			return new ResponseFailure(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	/**
	 * Updates the information of a specific user.
	 *
	 * @param userRequestDTO - the request body containing updated user information
	 * @param userID - the ID of the user to be updated, provided in the URL path
	 *
	 * @return a message indicating the user was updated
	 *
	 * @author Thanh
	 */
	@PutMapping("/{userID}")
	@Operation(summary = "Update User by ID", description = "Updates an existing user's details using their unique ID.")
	public String update(@Min(1) @PathVariable int userID
			,@Valid @RequestBody UserRequestDTO userRequestDTO) {
		return "User updated";
	}

	/**
	 * Updates the status of a user.
	 * <p>
	 * This method handles PATCH requests to update the status of a user identified by their ID.
	 * It takes in a `userID` as a path variable and a `status` as a request parameter.
	 *
	 * @param userID the unique identifier of the user whose status needs to be updated
	 * @param status a boolean indicating the new status of the user (true for active, false for inactive)
	 * @return a message indicating that the user's status has been changed
	 *
	 *  @author Thanh
	 */
	@PatchMapping("/{userID}")
	@Operation(summary = "Update User Status", description = "Updates the status of a user using their unique ID.")
	public String status(@Min(1) @PathVariable int userID,@Min(1)@RequestParam int status) {
		return "User status changed";
	}

	/**
	 * Deletes a user by their ID.
	 * <p>
	 * This method handles DELETE requests to remove a user identified by their unique `userID`.
	 *
	 * @param userID the unique identifier of the user to be deleted
	 * @return a message confirming the user has been deleted
	 *
	 * @author Thanh
	 */
	@DeleteMapping("/{userID}")
	@Operation(summary = "Delete User by ID", description = "Deletes a user using their unique ID.")
	public String delete(@Min(1) @PathVariable int userID) {
		return "User deleted";
	}
}
