package com.siva.moviesinfomain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siva.moviesinfomain.models.DetailsResponse;

@Service
public class MoviesInfoDetailsServiceImpl implements MoviesInfoDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DetailsResponse getDetailsResponse(String movieId) {
		return restTemplate.getForObject("http://movies-info-details/details/" + movieId, DetailsResponse.class);
	}
}
