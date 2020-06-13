package com.siva.moviesinfodetails.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesInfoDetailsController {

	@GetMapping(value = "/")
	public String getHello() {
		return "This is Movies info details service!";
	}

}
