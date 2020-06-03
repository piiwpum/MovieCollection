package com.piiwpum.moviecollection.data.repo

import com.piiwpum.moviecollection.data.remote.MovieAPI
import com.piiwpum.moviecollection.data.NetworkClient
import com.piiwpum.moviecollection.model.MovieResponse
import io.reactivex.Flowable


class MovieRepository constructor(private val networkClient: NetworkClient) : MovieAPI {

    override fun getMovieList(api_key: String): Flowable<MovieResponse> {
        return networkClient.getClient().getMovieList(api_key)
    }


}