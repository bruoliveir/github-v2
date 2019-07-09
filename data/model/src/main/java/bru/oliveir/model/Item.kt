package bru.oliveir.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Item(
    @PrimaryKey val id: String,
    val url: String,
    val iconUrl: String,
    val value: String
)
