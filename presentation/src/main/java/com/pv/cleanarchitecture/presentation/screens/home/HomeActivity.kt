package com.pv.cleanarchitecture.presentation.screens.home

import android.content.Context
import android.content.Intent
import com.pv.cleanarchitecture.R
import com.pv.cleanarchitecture.presentation.screens.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {
    companion object {
        fun getStartIntent(context: Context) = Intent(
            context, HomeActivity::class.java
        )
    }

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getViewModel() = homeViewModel

    override fun getLayoutId() = R.layout.activity_home

    override fun initViews() {
        listenUIAction {

        }
    }

}