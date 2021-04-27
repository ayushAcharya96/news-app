package com.springfield.newsapp.repository

import com.springfield.newsapp.api.NewsAPI
import com.springfield.newsapp.api.RetrofitInstance
import com.springfield.newsapp.db.ArticleDatabase
import com.springfield.newsapp.models.Article

class NewsRepository(
        private val db: ArticleDatabase,
        private val service: NewsAPI
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
            service.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
            service.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}