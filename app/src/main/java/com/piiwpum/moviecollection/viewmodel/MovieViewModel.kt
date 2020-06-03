package com.piiwpum.moviecollection.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.piiwpum.moviecollection.data.repo.MovieRepository
import com.piiwpum.moviecollection.model.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.experimental.property.inject


class MovieViewModel constructor(private val repository: MovieRepository) : ViewModel() {
    private val _movie: MutableLiveData<MovieResponse> = MutableLiveData()
    var movie: LiveData<MovieResponse> = _movie


    fun getAll(api_key: String) {
        repository.getMovieList(api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _movie.value = it
            }, { t: Throwable? ->

            })


    }


}