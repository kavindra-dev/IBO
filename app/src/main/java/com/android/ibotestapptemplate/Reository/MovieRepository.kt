package com.android.ibotestapptemplate.Reository

import com.android.ibotestapptemplate.API.ApiService
import com.android.ibotestapptemplate.Model.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchMovies(): List<Movie> = apiService.getMovies()
}