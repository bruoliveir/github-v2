package bru.oliveir.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import bru.oliveir.local.dao.PullDao
import bru.oliveir.local.dao.RepositoryDao
import bru.oliveir.local.dao.UserDao
import bru.oliveir.model.Pull
import bru.oliveir.model.Repository
import bru.oliveir.model.User

@Database(entities = [Repository::class, User::class, Pull::class], version = 2, exportSchema = false)
abstract class PlaygroundDatabase : RoomDatabase() {
    abstract fun repositoryDao(): RepositoryDao
    abstract fun userDao(): UserDao
    abstract fun pullDao(): PullDao

    companion object {
        fun getInstance(context: Context) =
            Room.databaseBuilder(context.applicationContext, PlaygroundDatabase::class.java, "Playground.db")
                .addMigrations(MIGRATION_1_2)
                .build()

        @JvmStatic
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `Pull` (`pullId` INTEGER NOT NULL, `title` TEXT NOT NULL, `body` TEXT NOT NULL, `repositoryId` INTEGER NOT NULL, PRIMARY KEY(`pullId`), FOREIGN KEY(`repositoryId`) REFERENCES `Repository`(`repositoryId`) ON UPDATE NO ACTION ON DELETE NO ACTION )")
                database.execSQL("CREATE  INDEX `index_Pull_repositoryId` ON `Pull` (`repositoryId`)")
            }
        }
    }
}