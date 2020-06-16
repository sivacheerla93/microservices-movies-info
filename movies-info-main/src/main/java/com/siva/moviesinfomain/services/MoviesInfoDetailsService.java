package com.siva.moviesinfomain.services;

import com.siva.moviesinfomain.models.DetailsResponse;

public interface MoviesInfoDetailsService {
	DetailsResponse getDetailsResponse(String movieId);
}
