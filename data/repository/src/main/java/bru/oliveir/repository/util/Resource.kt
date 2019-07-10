package bru.oliveir.repository.util

data class Resource<out T>(val status: Status, val data: T?, val error: Throwable?) {
    enum class Status {
        SUCCESS,
        LOADING
    }
}