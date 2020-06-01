package com.piiwpum.moviecollection.data.remote


class MovieDataSource constructor(private val movieAPI: MovieAPI) {
    fun getAllList(api_key : String) = movieAPI.getMovieList(api_key)

}