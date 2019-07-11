package bru.oliveir.repositories.domain

import bru.oliveir.repository.RepositoryRepository

class GetJavaRepositoriesUseCase(private val repository: RepositoryRepository) {
    suspend operator fun invoke(forceRefresh: Boolean = false) = repository.getJavaRepositoriesWithCache(forceRefresh)
}