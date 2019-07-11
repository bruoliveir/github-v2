package bru.oliveir.remote.di

import bru.oliveir.remote.RepositoryService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://api.github.com/"

val remoteModule = module {
    factory<Interceptor> { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS) }
    factory { OkHttpClient.Builder().addInterceptor(get()).build() }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory { get<Retrofit>().create(RepositoryService::class.java) }
}