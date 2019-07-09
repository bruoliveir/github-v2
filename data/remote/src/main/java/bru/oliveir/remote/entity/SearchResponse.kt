package bru.oliveir.remote.entity

import com.google.gson.annotations.SerializedName

class SearchResponse(
    @SerializedName("items") val items: List<Repository>
)