package com.pv.cleanarchitecture.data.di

import com.google.gson.GsonBuilder
import com.pv.cleanarchitecture.data.constants.APIConstants
import com.pv.cleanarchitecture.data.constants.NetworkConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val netModule = module {
    fun provideGson() = GsonBuilder().create()

    fun provideOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(NetworkConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(HttpLoggingInterceptor())
        .build()

    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(APIConstants.BASE_URL_MOVIE_DB)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    single { provideGson() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}