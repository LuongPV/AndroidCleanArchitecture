package com.pv.cleanarchitecture.domain.repositories

import com.pv.cleanarchitecture.domain.models.Movie
import io.reactivex.rxjava3.core.Single

interface MovieRepository {

    fun getTrendingMovies(): Single<List<Movie>>

    fun getMovieDetail(movieId: String): Single<Movie>

}