package com.siva.moviesinfosearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.siva.moviesinfosearch.models.SearchResponse;

@RestController
@RequestMapping(value = "/search")
public class MoviesInfoSearchController {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "")
	public String getHello() {
		return "This is Movies info search service!";
	}

	@RequestMapping(value = "/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SearchResponse getSearchReponse(@PathVariable("query") String query) {
		SearchResponse searchResponse = restTemplate
				.getForObject("https://api.themoviedb.org/3/search/movie?language=en-US&include_adult=false&api_key="
						+ apiKey + "&query=" + query, SearchResponse.class);
		return searchResponse;
	}

}
