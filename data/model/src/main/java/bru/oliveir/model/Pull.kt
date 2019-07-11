package bru.oliveir.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = ["pullId"],
    foreignKeys = [ForeignKey(
        entity = Repository::class,
        parentColumns = ["repositoryId"],
        childColumns = ["repositoryId"]
    ), ForeignKey(
        entity = User::class,
        parentColumns = ["userId"],
        childColumns = ["userId"]
    )],
    indices = [Index("repositoryId"), Index("userId")]
)
class Pull(
    @SerializedName("id") val pullId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    var repositoryId: Int,
    var userId: Int
) {
    @Ignore
    @SerializedName("user")
    var user: User? = null
}
