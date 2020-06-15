package com.siva.moviesinfosearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.moviesinfosearch.models.SearchResponse;
import com.siva.moviesinfosearch.services.MoviesInfoSearchService;

@RestController
@RequestMapping(value = "/search")
public class MoviesInfoSearchController {

	@Autowired
	MoviesInfoSearchService moviesInfoSearchService;

	@RequestMapping(value = "")
	public String getHello() {
		return "This is Movies info search service!";
	}

	@RequestMapping(value = "/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchResponse getSearchReponse(@PathVariable("query") String query) {
		return moviesInfoSearchService.getSearchResponse(query);
	}

}
