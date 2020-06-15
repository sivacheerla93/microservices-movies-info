package com.siva.moviesinfosearch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siva.moviesinfosearch.models.SearchResponse;

@Service
public class MoviesInfoSearchServiceImpl implements MoviesInfoSearchService {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public SearchResponse getSearchResponse(String query) {
		return restTemplate
				.getForObject("https://api.themoviedb.org/3/search/movie?language=en-US&include_adult=false&api_key="
						+ apiKey + "&query=" + query, SearchResponse.class);
	}
}
