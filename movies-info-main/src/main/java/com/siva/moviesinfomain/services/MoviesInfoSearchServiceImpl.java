package com.siva.moviesinfomain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siva.moviesinfomain.models.SearchResponse;

@Service
public class MoviesInfoSearchServiceImpl implements MoviesInfoSearchService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public SearchResponse getSearchResponse(String query) {
		return restTemplate.getForObject("http://movies-info-search/search/" + query, SearchResponse.class);
	}
}
