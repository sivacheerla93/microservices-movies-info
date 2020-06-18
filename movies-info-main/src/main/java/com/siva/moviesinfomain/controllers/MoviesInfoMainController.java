package com.siva.moviesinfomain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

	@HystrixCommand(fallbackMethod = "getSearchResponseFallback")
	@RequestMapping(value = "/search/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchResponse getSearchResponse(@PathVariable("query") String query) {
		return moviesInfoSearchService.getSearchResponse(query);
	}

	public SearchResponse getSearchResponseFallback(String query) {
		System.out.println("-------- getSearchResponseFallback ----------");
		return new SearchResponse();
	}

	@HystrixCommand(fallbackMethod = "getDetailsResponseFallback")
	@RequestMapping(value = "/details/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DetailsResponse getDetailsResponse(@PathVariable("movieId") String movieId) {
		return moviesInfoDetailsService.getDetailsResponse(movieId);
	}

	public DetailsResponse getDetailsResponseFallback(String movieId) {
		System.out.println("-------- getDetailsResponseFallback ----------");
		return new DetailsResponse();
	}

}
