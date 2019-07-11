package bru.oliveir.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bru.oliveir.model.User

@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(user: User)

    @Query("SELECT * FROM User WHERE userId = :id")
    abstract suspend fun getById(id: Int): List<User>
}