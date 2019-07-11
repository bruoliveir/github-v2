package bru.oliveir.repository

import androidx.lifecycle.LiveData
import bru.oliveir.local.dao.PullDao
import bru.oliveir.local.dao.RepositoryDao
import bru.oliveir.local.dao.UserDao
import bru.oliveir.model.ApiResult
import bru.oliveir.model.Pull
import bru.oliveir.model.Repository
import bru.oliveir.remote.RepositoryService
import bru.oliveir.repository.util.NetworkBoundResource
import bru.oliveir.repository.util.Resource

interface RepositoryRepository {
    suspend fun getJavaRepositoriesWithCache(forceRefresh: Boolean): LiveData<Resource<List<Repository>>>
    suspend fun getPullsByRepositoryWithCache(
        forceRefresh: Boolean,
        ownerLogin: String,
        repoName: String
    ): LiveData<Resource<List<Pull>>>
}

class RepositoryRepositoryImpl(
    private val repositoryDao: RepositoryDao,
    private val userDao: UserDao,
    private val pullDao: PullDao,
    private val repositoryService: RepositoryService
) : RepositoryRepository {
    override suspend fun getJavaRepositoriesWithCache(forceRefresh: Boolean): LiveData<Resource<List<Repository>>> =
        object : NetworkBoundResource<List<Repository>, ApiResult<Repository>>() {
            override suspend fun processResponse(response: ApiResult<Repository>) = response.items

            override suspend fun saveCallResults(items: List<Repository>) =
                items.filterNot { it.owner == null }
                    .forEach {
                        userDao.insert(it.owner!!)
                        it.userId = it.owner!!.userId
                        repositoryDao.insert(it)
                    }

            override fun shouldFetch(data: List<Repository>?) = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb() = repositoryDao.getAll().map {
                it.apply { owner = userDao.getById(it.userId)[0] }
            }

            override suspend fun createCall() = repositoryService.fetchJavaReposByStars()

        }.build().asLiveData()

    override suspend fun getPullsByRepositoryWithCache(
        forceRefresh: Boolean,
        ownerLogin: String,
        repoName: String
    ): LiveData<Resource<List<Pull>>> =
        object : NetworkBoundResource<List<Pull>, List<Pull>>() {
            private var repositoryId = -1

            override suspend fun processResponse(response: List<Pull>) = response

            override suspend fun saveCallResults(items: List<Pull>) {
                items.filterNot { it.user == null }
                    .forEach {
                        userDao.insert(it.user!!)
                        it.userId = it.user!!.userId
                        it.repositoryId = repositoryId
                        pullDao.insert(it)
                    }
            }

            override fun shouldFetch(data: List<Pull>?) = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Pull> {
                repositoryId = repositoryDao.getByName(repoName)[0].repositoryId
                return pullDao.getByRepositoryId(repositoryId).map {
                    it.apply { user = userDao.getById(it.userId)[0] }
                }
            }

            override suspend fun createCall() = repositoryService.fetchPullsByRepository(ownerLogin, repoName)

        }.build().asLiveData()
}