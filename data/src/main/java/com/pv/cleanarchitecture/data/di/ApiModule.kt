package com.pv.cleanarchitecture.data.di

import com.pv.cleanarchitecture.data.apis.AccountAPI
import com.pv.cleanarchitecture.data.apis.AccountAPIImpl
import com.pv.cleanarchitecture.data.apis.MovieAPI
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideMovieAPI(retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)

    fun provideAccountAPI(): AccountAPI = AccountAPIImpl()

    single { provideMovieAPI(get()) }
    single { provideAccountAPI() }
}