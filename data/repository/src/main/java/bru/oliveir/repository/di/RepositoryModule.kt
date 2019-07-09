package bru.oliveir.repository.di

import bru.oliveir.repository.ItemRepository
import bru.oliveir.repository.ItemRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<ItemRepository> { ItemRepositoryImpl(get(), get()) }
}