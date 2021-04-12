package com.pv.cleanarchitecture.data.mappers

import com.pv.cleanarchitecture.data.models.MovieEntity
import com.pv.cleanarchitecture.domain.models.Movie

class MovieMapper : ModelMapper<MovieEntity, Movie> {

    override fun mapToDomain(sourceType: MovieEntity): Movie {
        return Movie(
            sourceType.title
        )
    }

}