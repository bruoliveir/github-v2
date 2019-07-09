package bru.oliveir.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bru.oliveir.local.dao.ItemDao
import bru.oliveir.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class PlaygroundDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        fun getInstance(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PlaygroundDatabase::class.java,
                "Playground.db"
            ).build()
    }
}