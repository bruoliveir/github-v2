package bru.oliveir.detail.domain

import bru.oliveir.repository.ItemRepository

class GetAllItemsUseCase(private val repository: ItemRepository) {
    suspend operator fun invoke(forceRefresh: Boolean = false) = repository.getAllItemsFromLocal(forceRefresh)
}