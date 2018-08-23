package com.pad.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// retrieveUser(id)
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}

	// created
	// details of user
	// output created return the created url
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder
		  .fromCurrentRequest()
		  .path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
