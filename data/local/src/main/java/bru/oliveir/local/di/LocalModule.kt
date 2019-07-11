package bru.oliveir.local.di

import bru.oliveir.local.GithubDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { GithubDatabase.getInstance(androidContext()) }
    factory { get<GithubDatabase>().repositoryDao() }
    factory { get<GithubDatabase>().userDao() }
    factory { get<GithubDatabase>().pullDao() }
}