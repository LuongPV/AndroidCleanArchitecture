package com.pv.cleanarchitecture.presentation.di

import com.pv.cleanarchitecture.presentation.screens.home.HomeViewModel
import com.pv.cleanarchitecture.presentation.screens.login.LoginViewModel
import com.pv.cleanarchitecture.presentation.screens.moviedetail.MovieDetailViewModel
import com.pv.cleanarchitecture.presentation.screens.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel() }
    viewModel { MovieDetailViewModel() }
}