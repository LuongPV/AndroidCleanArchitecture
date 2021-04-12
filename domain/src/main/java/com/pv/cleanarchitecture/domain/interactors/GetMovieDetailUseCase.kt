package com.pv.cleanarchitecture.domain.interactors

import com.pv.cleanarchitecture.domain.models.Movie
import com.pv.cleanarchitecture.domain.repositories.MovieRepository
import com.pv.cleanarchitecture.domain.schedulers.OnExecutionScheduler
import com.pv.cleanarchitecture.domain.schedulers.PostExecutionScheduler
import io.reactivex.rxjava3.core.Single

class GetMovieDetailUseCase(
    private val movieRepository: MovieRepository,
    onExecutionScheduler: OnExecutionScheduler,
    postExecutionScheduler: PostExecutionScheduler
) : UseCase<String, Movie>(onExecutionScheduler, postExecutionScheduler) {

    override fun create(params: String): Single<Movie> {
        return movieRepository.getMovieDetail(params)
    }

}