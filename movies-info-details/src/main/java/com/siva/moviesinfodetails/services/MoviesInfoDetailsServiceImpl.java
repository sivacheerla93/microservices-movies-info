package com.siva.moviesinfodetails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siva.moviesinfodetails.models.DetailsResponse;

@Service
public class MoviesInfoDetailsServiceImpl implements MoviesInfoDetailsService {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DetailsResponse getDetailsResponse(String movieId) {
		return restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
				DetailsResponse.class);
	}
}
