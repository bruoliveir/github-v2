package bru.oliveir.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = ["repositoryId"],
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["userId"], childColumns = ["userId"])],
    indices = [Index("userId")]
)
class Repository(
    @SerializedName("id") val repositoryId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("forks_count") val forks: Int,
    var userId: Int
) {
    @Ignore
    @SerializedName("owner")
    var owner: User? = null
}
