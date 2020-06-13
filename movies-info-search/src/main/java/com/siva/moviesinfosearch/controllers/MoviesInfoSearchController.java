package com.siva.moviesinfosearch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesInfoSearchController {

	@GetMapping(value = "/")
	public String getHello() {
		return "This is Movies info search service!";
	}

}
