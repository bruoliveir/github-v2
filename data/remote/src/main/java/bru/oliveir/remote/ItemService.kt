package bru.oliveir.remote

import bru.oliveir.remote.entity.SearchResponse
import retrofit2.http.GET

interface ItemService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    suspend fun fetchJavaReposByStars(): SearchResponse
}