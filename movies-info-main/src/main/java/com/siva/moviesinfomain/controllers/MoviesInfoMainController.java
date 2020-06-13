package com.siva.moviesinfomain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesInfoMainController {

	@GetMapping(value = "/")
	public String getHello() {
		return "This is Movies info main service!";
	}

}
