package com.springfield.newsapp.di.module

import com.springfield.newsapp.db.ArticleDao
import com.springfield.newsapp.db.ArticleDatabase
import com.springfield.newsapp.models.Article
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val dataModule = module {
    single {
        ArticleDatabase(androidApplication())
    }
}