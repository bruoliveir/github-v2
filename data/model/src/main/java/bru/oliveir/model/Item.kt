package bru.oliveir.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Item(
    @PrimaryKey val id: Long,
    val iconUrl: String,
    val text: String
)
