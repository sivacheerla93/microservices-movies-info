package com.siva.moviesinfodetails.services;

import com.siva.moviesinfodetails.models.DetailsResponse;

public interface MoviesInfoDetailsService {
	DetailsResponse getDetailsResponse(String movieId);
}
