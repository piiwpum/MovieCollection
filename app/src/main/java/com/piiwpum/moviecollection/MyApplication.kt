package com.piiwpum.moviecollection

import android.app.Application
import com.piiwpum.moviecollection.di.appModule
import com.piiwpum.moviecollection.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()

            modules(networkModule , appModule)
        }
    }
}