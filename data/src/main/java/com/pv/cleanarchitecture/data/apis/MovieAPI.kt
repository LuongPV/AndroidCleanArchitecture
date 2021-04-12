package com.pv.cleanarchitecture.data.apis

import com.pv.cleanarchitecture.data.apis.models.ListPageResponse
import com.pv.cleanarchitecture.data.constants.APIConstants.API_KEY_MOVIE_DB
import com.pv.cleanarchitecture.data.mappers.APILanguage
import com.pv.cleanarchitecture.data.models.MovieEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET("trending/movie/day")
    fun getTrendingMovies(@Query("api_key") apiKey: String = API_KEY_MOVIE_DB): Single<ListPageResponse<MovieEntity>>

    @GET("movie/{movieId}")
    fun getMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = API_KEY_MOVIE_DB,
        @Query("language") language: String = APILanguage.EN_US.toString()
    ): Single<MovieEntity>

}