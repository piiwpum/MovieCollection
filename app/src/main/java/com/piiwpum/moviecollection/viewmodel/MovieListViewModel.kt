package com.piiwpum.moviecollection.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.piiwpum.moviecollection.data.remote.MovieDataSource
import com.piiwpum.moviecollection.data.repo.MovieRepository
import com.piiwpum.moviecollection.di.NetworkModule
import com.piiwpum.moviecollection.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MovieListViewModel : ViewModel() {
    private val _movie: MutableLiveData<MovieResponse> = MutableLiveData()
    var movie: LiveData<MovieResponse> = _movie

    private val BASE_URL = "https://api.themoviedb.org"
    val networkModule: NetworkModule = NetworkModule()
    val dataSource: MovieDataSource
    val repository: MovieRepository

    init {
        dataSource = MovieDataSource(networkModule.movieProvide(BASE_URL))
        repository = MovieRepository(dataSource)
    }

    fun getAll(api_key: String) {
        repository.getMovieList(api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                Log.d("xxxx" , "xxxxxx ${it.name}")
                _movie.value = it
            } , {t: Throwable? ->
                Log.d("xxxx" , "error =  ${t?.message}")
            })


    }


}