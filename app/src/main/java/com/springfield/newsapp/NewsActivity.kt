package com.springfield.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.springfield.newsapp.db.ArticleDatabase
import com.springfield.newsapp.repository.NewsRepository
import com.springfield.newsapp.ui.NewsViewModel
import com.springfield.newsapp.ui.NewsViewModelProviderFactory
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private lateinit var newNavHostFragment: FragmentContainerView
    private lateinit var bottomNavigationView: BottomNavigationView

    val viewModel : NewsViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        newNavHostFragment = findViewById(R.id.newsNavHostFragment)

//        val newsRepository = NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        bottomNavigationView.setupWithNavController(newNavHostFragment.findNavController())


    }
}