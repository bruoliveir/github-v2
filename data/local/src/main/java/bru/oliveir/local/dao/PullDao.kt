package bru.oliveir.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bru.oliveir.model.Pull

@Dao
abstract class PullDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(pull: Pull)

    @Query("SELECT * FROM Pull WHERE repositoryId = :id")
    abstract suspend fun getByRepositoryId(id: Int): List<Pull>
}