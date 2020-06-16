package com.siva.moviesinfomain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.moviesinfomain.models.DetailsResponse;
import com.siva.moviesinfomain.models.SearchResponse;
import com.siva.moviesinfomain.services.MoviesInfoDetailsService;
import com.siva.moviesinfomain.services.MoviesInfoSearchService;

@RestController
public class MoviesInfoMainController {

	@Autowired
	MoviesInfoSearchService moviesInfoSearchService;

	@Autowired
	MoviesInfoDetailsService moviesInfoDetailsService;

	@GetMapping(value = "/")
	public String getHello() {
		return "This is Movies info main service!";
	}

	@RequestMapping(value = "/search/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchResponse getSearchResponse(@PathVariable("query") String query) {
		return moviesInfoSearchService.getSearchResponse(query);
	}

	@RequestMapping(value = "/details/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DetailsResponse getDetailsResponse(@PathVariable("movieId") String movieId) {
		return moviesInfoDetailsService.getDetailsResponse(movieId);
	}

}
