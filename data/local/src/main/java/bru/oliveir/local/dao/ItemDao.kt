package bru.oliveir.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bru.oliveir.model.Item

@Dao
abstract class ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(items: List<Item>)

    @Query("SELECT * FROM Item ORDER BY id DESC")
    abstract suspend fun getAllItems(): List<Item>
}