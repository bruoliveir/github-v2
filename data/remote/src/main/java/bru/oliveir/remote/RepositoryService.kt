package bru.oliveir.remote

import bru.oliveir.model.ApiResult
import bru.oliveir.model.Pull
import bru.oliveir.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryService {
    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    suspend fun fetchJavaReposByStars(): ApiResult<Repository>

    @GET("repos/{ownerLogin}/{repoName}/pulls")
    suspend fun fetchPullsByRepository(@Path("ownerLogin") ownerLogin: String, @Path("repoName") repoName: String): List<Pull>
}