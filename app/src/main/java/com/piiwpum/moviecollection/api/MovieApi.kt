package com.piiwpum.moviecollection.api

import androidx.lifecycle.Observer
import com.piiwpum.moviecollection.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //https://api.themoviedb.org/4/list/1?api_key=d9b044609c69f14634620e0bd94efc34&fbclid=IwAR0IWHly8NZAa-AbQRO_-ionq0ezF5C_L3birjaB2H9oF74bLj3nqtHufI8

    @GET("/list/1")
    fun getMovieList(@Query("api_key") api_key : String?) : Observer<MovieResponse>


}