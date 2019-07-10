package bru.oliveir.repository

import bru.oliveir.local.dao.ItemDao
import bru.oliveir.model.Item
import bru.oliveir.remote.ItemService
import bru.oliveir.repository.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ItemRepository {
    suspend fun getAllItemsFromLocal(forceRefresh: Boolean): Resource<List<Item>>
}

class ItemRepositoryImpl(private val itemDao: ItemDao, private val itemService: ItemService) : ItemRepository {
    override suspend fun getAllItemsFromLocal(forceRefresh: Boolean): Resource<List<Item>> {
        var status = Resource.Status.SUCCESS
        if (forceRefresh) {
            withContext(Dispatchers.IO) {
                status = Resource.Status.LOADING
                itemService.fetchJavaReposByStars().items
                    .map { Item(it.id, it.owner.avatarUrl, it.name) }
                    .let {
                        itemDao.insert(it)
                        status = Resource.Status.SUCCESS
                    }
            }
        }
        return Resource(status, itemDao.getAllItems(), null)
    }
}