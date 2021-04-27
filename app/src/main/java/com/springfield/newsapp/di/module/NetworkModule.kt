package com.springfield.newsapp.di.module

import com.springfield.newsapp.BuildConfig
import com.springfield.newsapp.api.NewsAPI
import com.springfield.newsapp.util.Constants
import com.springfield.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    val baseUrl = BASE_URL

    fun provideOkHttpClient() =
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .build()
            } else {
                OkHttpClient
                        .Builder()
                        .build()
            }



    fun provideRetrofit(
            okHttpClient: OkHttpClient,
            BASE_URL: String
    ): Retrofit {
        return Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
    }

    fun provideNewsApi(retrofit: Retrofit): NewsAPI = retrofit.create(NewsAPI::class.java)

    single {
        baseUrl
    }
    single {
        provideOkHttpClient()
    }
    single {
        provideRetrofit(get(), get())
    }
    single {
        provideNewsApi(get())
    }
}