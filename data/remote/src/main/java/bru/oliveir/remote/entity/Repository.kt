package bru.oliveir.remote.entity

import com.google.gson.annotations.SerializedName

class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: Owner
)
