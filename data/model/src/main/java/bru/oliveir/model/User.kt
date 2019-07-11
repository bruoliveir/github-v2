package bru.oliveir.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["userId"])
class User(
    @SerializedName("id") val userId: Int,
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
