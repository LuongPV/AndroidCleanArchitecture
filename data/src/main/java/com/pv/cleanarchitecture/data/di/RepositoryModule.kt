package com.pv.cleanarchitecture.data.di

import com.pv.cleanarchitecture.data.mappers.ModelMapper
import com.pv.cleanarchitecture.data.mappers.MovieMapper
import com.pv.cleanarchitecture.data.models.MovieEntity
import com.pv.cleanarchitecture.data.repositories.AccountRepositoryImpl
import com.pv.cleanarchitecture.data.repositories.MovieRepositoryImpl
import com.pv.cleanarchitecture.domain.models.Movie
import com.pv.cleanarchitecture.domain.repositories.AccountRepository
import com.pv.cleanarchitecture.domain.repositories.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl(get(), get()) }
    single<ModelMapper<MovieEntity, Movie>> { MovieMapper() }
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}