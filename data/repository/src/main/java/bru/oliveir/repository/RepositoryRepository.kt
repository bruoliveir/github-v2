package bru.oliveir.repository

import bru.oliveir.local.dao.PullDao
import bru.oliveir.local.dao.RepositoryDao
import bru.oliveir.local.dao.UserDao
import bru.oliveir.model.Pull
import bru.oliveir.model.Repository
import bru.oliveir.remote.RepositoryService
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface RepositoryRepository {
    suspend fun getJavaRepositoriesWithCache(forceRefresh: Boolean): Resource<List<Repository>>
    suspend fun getPullsByRepository(forceRefresh: Boolean, ownerLogin: String, repoName: String): Resource<List<Pull>>
}

class RepositoryRepositoryImpl(
    private val repositoryDao: RepositoryDao,
    private val userDao: UserDao,
    private val pullDao: PullDao,
    private val repositoryService: RepositoryService
) : RepositoryRepository {
    override suspend fun getJavaRepositoriesWithCache(forceRefresh: Boolean): Resource<List<Repository>> {
        var status = Resource.Status.SUCCESS
        if (forceRefresh) {
            withContext(Dispatchers.IO) {
                status = Resource.Status.LOADING
                repositoryService.fetchJavaReposByStars().items
                    .filterNot { it.owner == null }
                    .forEach {
                        userDao.insert(it.owner!!)
                        it.userId = it.owner!!.userId
                        repositoryDao.insert(it)
                    }
                status = Resource.Status.SUCCESS
            }
        }
        val data = repositoryDao.getAll().map {
            it.apply { owner = userDao.getById(it.userId)[0] }
        }
        return Resource(status, data, null)
    }

    override suspend fun getPullsByRepository(
        forceRefresh: Boolean,
        ownerLogin: String,
        repoName: String
    ): Resource<List<Pull>> {
        var status = Resource.Status.SUCCESS
        val repositoryId = repositoryDao.getByName(repoName)[0].repositoryId
        if (forceRefresh) {
            withContext(Dispatchers.IO) {
                status = Resource.Status.LOADING
                repositoryService.fetchPullsByRepository(ownerLogin, repoName)
                    .filterNot { it.user == null }
                    .forEach {
                        userDao.insert(it.user!!)
                        it.userId = it.user!!.userId
                        it.repositoryId = repositoryId
                        pullDao.insert(it)
                    }
                status = Resource.Status.SUCCESS
            }
        }
        val data = pullDao.getByRepositoryId(repositoryId).map {
            it.apply { user = userDao.getById(it.userId)[0] }
        }
        return Resource(status, data, null)
    }
}