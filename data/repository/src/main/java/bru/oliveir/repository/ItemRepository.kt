package bru.oliveir.repository

import bru.oliveir.local.dao.ItemDao
import bru.oliveir.model.Item
import bru.oliveir.remote.ItemService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ItemRepository {
    suspend fun getAllItemsFromLocal(forceRefresh: Boolean): List<Item>
}

class ItemRepositoryImpl(private val itemDao: ItemDao, private val itemService: ItemService) : ItemRepository {
    override suspend fun getAllItemsFromLocal(forceRefresh: Boolean): List<Item> {
        if (forceRefresh) {
            withContext(Dispatchers.IO) {
                itemService.fetchJavaReposByStars().items.map {
                    Item(it.id, it.owner.avatarUrl, it.name)
                }.let { itemDao.insert(it) }
            }
        }
        return itemDao.getAllItems()
    }
}