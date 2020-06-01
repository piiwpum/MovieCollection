package com.piiwpum.moviecollection.di

import com.piiwpum.moviecollection.data.remote.MovieAPI
import com.piiwpum.moviecollection.data.remote.MovieDataSource
import com.piiwpum.moviecollection.data.repo.MovieRepository
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://newsapi.org/v2/"

val networkModule = module {

    single { NetworkModule().buildOkHttpClient() }

    single<CallAdapter.Factory> { RxJavaCallAdapterFactory.create() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single { NetworkModule().buildRetofit(BASE_URL, get(), get(), get()) }

    single { MovieRepository(get()) }

    single { MovieDataSource(get()) }

    single { NetworkModule().movieProvide(BASE_URL) }


}