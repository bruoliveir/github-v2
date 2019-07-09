package bru.oliveir.playground

import android.app.Application
import bru.oliveir.local.di.localModule
import bru.oliveir.master.di.featureMasterModule
import bru.oliveir.remote.di.remoteModule
import bru.oliveir.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidContext(this@App)
            modules(listOf(localModule, remoteModule, repositoryModule, featureMasterModule))
        }
    }
}