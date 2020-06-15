package com.siva.moviesinfodetails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.moviesinfodetails.models.DetailsResponse;
import com.siva.moviesinfodetails.services.MoviesInfoDetailsService;

@RestController
@RequestMapping(value = "/details")
public class MoviesInfoDetailsController {

	@Autowired
	MoviesInfoDetailsService moviesInfoDetailsService;

	@GetMapping(value = "")
	public String getHello() {
		return "This is Movies info details service!";
	}

	@RequestMapping(value = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DetailsResponse getSearchReponse(@PathVariable("movieId") String movieId) {
		return moviesInfoDetailsService.getDetailsResponse(movieId);
	}
}
