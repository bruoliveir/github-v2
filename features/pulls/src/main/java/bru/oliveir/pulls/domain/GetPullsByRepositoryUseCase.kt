package bru.oliveir.pulls.domain

import bru.oliveir.repository.RepositoryRepository

class GetPullsByRepositoryUseCase(private val repository: RepositoryRepository) {
    suspend operator fun invoke(forceRefresh: Boolean = false, ownerLogin: String, repoName: String) =
        repository.getPullsByRepository(forceRefresh, ownerLogin, repoName)
}