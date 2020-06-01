package com.piiwpum.moviecollection.data.remote

import androidx.lifecycle.Observer
import com.piiwpum.moviecollection.model.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieAPI {

    //https://api.themoviedb.org/4/list/1?api_key=d9b044609c69f14634620e0bd94efc34&fbclid=IwAR0IWHly8NZAa-AbQRO_-ionq0ezF5C_L3birjaB2H9oF74bLj3nqtHufI8

    @Headers("Content-Type: application/json")
    @GET("/4/list/1?api_key=d9b044609c69f14634620e0bd94efc34&fbclid=IwAR0IWHly8NZAa-AbQRO_-ionq0ezF5C_L3birjaB2H9oF74bLj3nqtHufI8")
    fun getMovieList(@Query("api_key") key: String): Flowable<MovieResponse>

}