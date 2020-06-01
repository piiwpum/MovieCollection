package com.piiwpum.moviecollection.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.piiwpum.moviecollection.data.remote.MovieDataSource
import com.piiwpum.moviecollection.data.remote.MovieAPI
import com.piiwpum.moviecollection.model.MovieResponse
import io.reactivex.Flowable


class MovieRepository  constructor(
    private val movieDataSource: MovieDataSource) : MovieAPI {

    override fun getMovieList(api_key: String): Flowable<MovieResponse> {
        return movieDataSource.getAllList(api_key)
    }


}