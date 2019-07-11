package bru.oliveir.local.di

import bru.oliveir.local.PlaygroundDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { PlaygroundDatabase.getInstance(androidContext()) }
    factory { get<PlaygroundDatabase>().repositoryDao() }
    factory { get<PlaygroundDatabase>().userDao() }
    factory { get<PlaygroundDatabase>().pullDao() }
}