package com.springfield.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.springfield.newsapp.NewsActivity
import com.springfield.newsapp.R
import com.springfield.newsapp.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {

    private lateinit var webView: WebView
    private lateinit var fab: FloatingActionButton

    lateinit var viewModel: NewsViewModel

    val args : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        fab = view.findViewById(R.id.fab)

        webView = view.findViewById(R.id.webView)

        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }

    }
}