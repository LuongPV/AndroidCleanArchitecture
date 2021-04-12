package com.pv.cleanarchitecture.presentation.screens.moviedetail

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pv.cleanarchitecture.R
import com.pv.cleanarchitecture.presentation.screens.base.BaseActivity
import com.pv.cleanarchitecture.presentation.screens.base.UIAction

class MovieDetailActivity : BaseActivity() {
    private val viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

    override fun getViewModel() = viewModel

    override fun getLayoutId() = R.layout.activity_movie_detail

    override fun initViews() {
        viewModel.getUIAction().observe(this, Observer<UIAction> {

        })
    }
}