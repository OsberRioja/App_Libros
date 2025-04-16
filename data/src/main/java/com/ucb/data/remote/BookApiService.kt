package com.ucb.data.remote


import com.ucb.data.remote.dto.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String
    ): SearchResponse
}
