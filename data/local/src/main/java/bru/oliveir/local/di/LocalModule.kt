package bru.oliveir.local.di

import bru.oliveir.local.PlaygroundDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val DATABASE = "DATABASE"

val localModule = module {
    single(named(DATABASE)) { PlaygroundDatabase.getInstance(androidContext()) }
    factory { (get(named(DATABASE)) as PlaygroundDatabase).itemDao() }
}