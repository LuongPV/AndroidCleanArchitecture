package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.models.Movie
import com.pv.cleanarchitecture.domain.repositories.MovieRepository
import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single

class GetTrendingMoviesUseCase(
    private val movieRepository: MovieRepository,
    onExecutionScheduler: OnExecutionScheduler,
    postExecutionScheduler: PostExecutionScheduler
) : UseCase<Void, List<Movie>>(onExecutionScheduler, postExecutionScheduler) {

    override fun create(params: Void): Single<List<Movie>> {
        return movieRepository.getTrendingMovies()
    }


}