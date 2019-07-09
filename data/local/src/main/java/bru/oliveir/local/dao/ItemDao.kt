package bru.oliveir.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import bru.oliveir.model.Item

@Dao
abstract class ItemDao {
    @Insert
    abstract suspend fun insert(item: Item)

    @Query("SELECT * FROM Item ORDER BY id DESC")
    abstract suspend fun getAllItems(): List<Item>
}