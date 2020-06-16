package com.siva.moviesinfomain.services;

import com.siva.moviesinfomain.models.SearchResponse;

public interface MoviesInfoSearchService {
	SearchResponse getSearchResponse(String query);
}
