package com.springfield.newsapp

import android.app.Application
import com.springfield.newsapp.di.applicationModule
import com.springfield.newsapp.di.module.dataModule
import com.springfield.newsapp.di.module.networkModule
import com.springfield.newsapp.di.module.repoModule
import com.springfield.newsapp.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import timber.log.Timber.DebugTree


class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NewsApplication)
            modules(
                listOf(applicationModule, dataModule, networkModule, repoModule, viewModelModule)
            )
        }
    }
}