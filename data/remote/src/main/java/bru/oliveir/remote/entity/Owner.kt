package bru.oliveir.remote.entity

import com.google.gson.annotations.SerializedName

class Owner(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
