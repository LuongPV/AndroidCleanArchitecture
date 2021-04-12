package com.pv.cleanarchitecture.data.repositories

import com.pv.cleanarchitecture.data.apis.MovieAPI
import com.pv.cleanarchitecture.data.mappers.ModelMapper
import com.pv.cleanarchitecture.data.models.MovieEntity
import com.pv.cleanarchitecture.data.utils.networkException
import com.pv.cleanarchitecture.domain.models.Movie
import com.pv.cleanarchitecture.domain.repositories.MovieRepository
import io.reactivex.rxjava3.core.Single

class MovieRepositoryImpl(
    private val movieAPI: MovieAPI,
    private val movieMapper: ModelMapper<MovieEntity, Movie>
) : MovieRepository {

    override fun getTrendingMovies(): Single<List<Movie>> {
        return movieAPI.getTrendingMovies()
            .map { it.results.map { movieEntity -> movieMapper.mapToDomain(movieEntity) } }
            .compose(networkException())

    }

    override fun getMovieDetail(movieId: String): Single<Movie> {
        return movieAPI.getMovieDetail(movieId)
            .map { movieMapper.mapToDomain(it) }
            .compose(networkException())
    }
}