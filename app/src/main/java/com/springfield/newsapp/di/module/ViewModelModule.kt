package com.springfield.newsapp.di.module

import com.springfield.newsapp.ui.NewsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        NewsViewModel(androidApplication(), get())
    }
}