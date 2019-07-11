package bru.oliveir.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import bru.oliveir.model.Repository

@Dao
abstract class RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(repository: Repository)

    @Query("SELECT * FROM Repository ORDER BY stars DESC")
    abstract suspend fun getAll(): List<Repository>

    @Query("SELECT * FROM Repository WHERE name = :repoName")
    abstract suspend fun getByName(repoName: String): List<Repository>
}