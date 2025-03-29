package com.android.ibotestapptemplate.API

import com.android.ibotestapptemplate.Model.Movie
import retrofit2.http.GET

interface ApiService {
    @GET("wp-content/plugins/whats-on-netflix/json/alldocs.json?_=1700718031139")
    suspend fun getMovies(): List<Movie>
}
