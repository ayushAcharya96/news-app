package com.springfield.newsapp.di.module

import com.springfield.newsapp.repository.NewsRepository
import org.koin.dsl.module


val repoModule = module {
    single {
        NewsRepository(get(), get())
    }
}