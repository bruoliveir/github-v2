package bru.oliveir.model

import com.google.gson.annotations.SerializedName

class ApiResult<T>(@SerializedName("items") val items: List<T>)