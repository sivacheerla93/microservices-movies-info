package com.siva.moviesinfosearch.services;

import com.siva.moviesinfosearch.models.SearchResponse;

public interface MoviesInfoSearchService {
	SearchResponse getSearchResponse(String query);
}
