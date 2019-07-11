package bru.oliveir.repository.di

import bru.oliveir.repository.RepositoryRepository
import bru.oliveir.repository.RepositoryRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<RepositoryRepository> { RepositoryRepositoryImpl(get(), get(), get(), get()) }
}