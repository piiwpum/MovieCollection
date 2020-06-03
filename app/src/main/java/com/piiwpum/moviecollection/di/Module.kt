package com.piiwpum.moviecollection.di

import com.piiwpum.moviecollection.data.NetworkClient
import com.piiwpum.moviecollection.data.repo.MovieRepository
import com.piiwpum.moviecollection.viewmodel.MovieViewModel
import org.koin.dsl.module


val networkModule = module {
    single { NetworkClient() }
    single { MovieRepository(get()) }
}

val appModule = module {
    single { MovieViewModel(get()) }
}
