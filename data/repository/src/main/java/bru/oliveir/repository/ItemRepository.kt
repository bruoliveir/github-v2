package bru.oliveir.repository

import bru.oliveir.local.dao.ItemDao
import bru.oliveir.model.Item

interface ItemRepository {
    suspend fun getAllItemsFromLocal(): List<Item>
}

class ItemRepositoryImpl(private val itemDao: ItemDao) : ItemRepository {
    override suspend fun getAllItemsFromLocal() = itemDao.getAllItems()
}