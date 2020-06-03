package com.piiwpum.moviecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.piiwpum.moviecollection.data.repo.MovieRepository
import com.piiwpum.moviecollection.viewmodel.MovieViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val movieViewModel: MovieViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieViewModel.movie.observe(this, Observer {
            Log.d("xxxxxx", it.name)
        })

        var api_key = "d9b044609c69f14634620e0bd94efc34&fbclid=IwAR0IWHly8NZAa-AbQRO_-ionq0ezF5C_L3birjaB2H9oF74bLj3nqtHufI8"
        movieViewModel.getAll(api_key)


    }
}
