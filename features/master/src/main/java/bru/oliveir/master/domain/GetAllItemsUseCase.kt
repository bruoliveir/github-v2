package bru.oliveir.master.domain

import bru.oliveir.repository.ItemRepository

class GetAllItemsUseCase(private val repository: ItemRepository) {
    suspend operator fun invoke() = repository.getAllItemsFromLocal()
}